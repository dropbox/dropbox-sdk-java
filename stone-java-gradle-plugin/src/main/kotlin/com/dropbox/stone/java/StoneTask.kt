package com.dropbox.stone.java

import com.dropbox.stone.java.model.StoneConfig
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.*
import org.gradle.process.ExecOperations
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import org.gradle.api.file.ConfigurableFileCollection

@CacheableTask
abstract class StoneTask : DefaultTask() {

    @get:Inject
    abstract val exec: ExecOperations

    @get:Input
    abstract val stoneConfigs: ListProperty<StoneConfig>

    @get:Internal
    abstract val generatorFile: RegularFileProperty

    @get:Internal
    abstract val specDir: DirectoryProperty

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val specFiles: ConfigurableFileCollection

    @get:Optional
    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val routeWhitelistFilter: RegularFileProperty

    @get:Internal
    abstract val stoneDir: DirectoryProperty

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val stoneFiles: ConfigurableFileCollection

    @get:Input
    abstract val pythonCommand: Property<String>

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    init {
        stoneFiles.setFrom(stoneDir.asFileTree.matching {
            include("**/*.py")
        })

        specFiles.setFrom(specDir.asFileTree.matching {
            include("**/*.stone")
        })
    }

    @TaskAction
    fun processStone() {
        check(stoneDir.get().asFile.exists()) {
            "Stone directory $stoneDir does not exist. " +
                    "Please run `./update-submodules` to download the stone submodule."
        }

        val outputDirectory = outputDir.asFile.get()
        outputDirectory.deleteRecursively()
        outputDirectory.mkdirs()

        val specFiles = specDir.asFileTree.matching {
            include("**/*.stone")
        }.files

        val refsFile = File(outputDirectory, "refs/javadoc-refs.json")
        refsFile.parentFile.mkdirs()

        val logFile = File(outputDir.asFile.get(), "log/stone.log")
        logFile.parentFile.mkdirs()

        if (routeWhitelistFilter.isPresent) {
            for (config: StoneConfig in stoneConfigs.get()) {
                config.routeWhitelistFilter = routeWhitelistFilter.get().toString()
            }
        }

        stoneConfigs.get().forEachIndexed { index, stoneConfig ->
            val isFirst = index == 0
            val append: Boolean = !isFirst

            val generatorArgs = mutableListOf(
                    pythonCommand.get(), "-m", "stone.cli",
                    "--attribute", ":all",

                    generatorFile.get().asFile,
                    outputDirectory.resolve("src").absolutePath,
                    *specFiles.map { it.absolutePath }.toTypedArray(),
                    "--", "--package", stoneConfig.packageName,
            )

            if (isFirst) generatorArgs.add(generatorArgs.indexOf("stone.cli") + 1, "--clean-build")

            if (stoneConfig.routeWhitelistFilter?.isNotEmpty() == true){
                generatorArgs.addAll(generatorArgs.indexOf(":all") + 1, listOf("--route-whitelist-filter", stoneConfig.routeWhitelistFilter))
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
        val routeFilters = listOfNotNull(stoneConfig.globalRouteFilter, client?.routeFilter)
        return routeFilters.joinToString(" and ") { "(${it})" }
    }
}