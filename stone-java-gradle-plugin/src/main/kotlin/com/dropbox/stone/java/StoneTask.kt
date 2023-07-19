package com.dropbox.stone.java

import com.dropbox.stone.java.model.StoneConfig
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Optional
import org.gradle.process.ExecOperations
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

abstract class StoneTask : DefaultTask() {

    @get:Inject
    abstract val exec: ExecOperations

    @get:Input
    abstract val stoneConfigs: ListProperty<StoneConfig>

    @get:InputDirectory
    abstract val generatorDir: DirectoryProperty

    @get:InputDirectory
    abstract val specDir: DirectoryProperty

    @get:Optional
    @get:Input
    abstract val routeWhitelistFilter: Property<String>

    @get:InputDirectory
    abstract val stoneDir: DirectoryProperty

    @get:Input
    abstract val pythonCommand: Property<String>

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @TaskAction
    fun processStone() {
        check(stoneDir.get().asFile.exists()) {
            "Stone directory ${stoneDir} does not exist. " +
                    "Please run `./update-submodules` to download the stone submodule."
        }
        check(pythonCommand.get().isNotEmpty())

        val outputDirectory = outputDir.asFile.get()
        outputDirectory.deleteRecursively()
        outputDirectory.mkdirs()

        val generatorFile = generatorDir.asFileTree.matching {
            exclude("**/*.pyc")
        }.singleFile

        val specFiles = specDir.asFileTree.matching {
            include("**/*.stone")
        }.files

        val refsFile = File(outputDirectory, "refs/javadoc-refs.json")
        refsFile.parentFile.mkdirs()

        val logFile = File(outputDir.asFile.get(), "log/stone.log")
        logFile.parentFile.mkdirs()

        stoneConfigs.get().forEachIndexed { index, stoneConfig ->
            val isFirst = index == 0
            val append: Boolean = !isFirst

            val generatorArgs = mutableListOf(
                    pythonCommand.get(), "-m", "stone.cli",
                    "--attribute", ":all",

                    generatorFile.absolutePath,
                    outputDirectory.resolve("src").absolutePath,
                    *specFiles.map { it.absolutePath }.toTypedArray(),
                    "--", "--package", stoneConfig.packageName,
            )

            if (isFirst) generatorArgs.add(generatorArgs.indexOf("stone.cli") + 1, "--clean-build")
            stoneConfig.routeWhitelistFilter?.let { filter ->
                generatorArgs.add("--route-whitelist-filter")
                generatorArgs.add(filter)
            }

            if (buildRouteFilter(stoneConfig).isNotEmpty()) {
                generatorArgs.addAll(generatorArgs.indexOf(":all") + 1, listOf("--filter-by-route-attr", buildRouteFilter(stoneConfig)))
            }

            if (stoneConfig.dataTypesOnly) {
                generatorArgs += "--data-types-only"
            } else {
                generatorArgs.addAll(listOf("--javadoc-refs", refsFile.absolutePath))
                stoneConfig.client?.let { client ->
                    generatorArgs += listOfNotNull(
                            client.name?.let { "--client-class" to it },
                            client.javadoc?.let { "--client-javadoc" to it },
                            client.requestsClassnamePrefix?.takeIf { it.isNotBlank() }?.let { "--requests-classname-prefix" to it },
                            client.unusedClassesToGenerate?.takeIf { it.isNotBlank() }?.let { "--unused-classes-to-generate" to it }
                    ).flatMap { (arg, value) -> listOfNotNull(arg, value) }
                }
            }

            exec.exec {
                standardOutput = FileOutputStream(logFile, append)
                environment["PYTHONPATH"] = stoneDir.get()
                logger.info("Calling stone generator: {${generatorArgs.joinToString(" ")}}")
                commandLine(generatorArgs)
            }
        }
    }

    private fun buildRouteFilter(stoneConfig: StoneConfig): String {
        val client = stoneConfig.client
        val routeFilters = listOf(stoneConfig.globalRouteFilter, client?.routeFilter).filterNotNull()
        return routeFilters.joinToString(" and ") { "(${it})" }
    }
}