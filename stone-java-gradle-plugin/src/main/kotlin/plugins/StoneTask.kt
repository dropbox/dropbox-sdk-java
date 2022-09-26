package plugins

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileTree
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import plugins.model.StoneConfig
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import javax.inject.Inject

abstract class StoneTask  : DefaultTask() {

    init {
        group = "Dropbox Stone Java Generator"
    }

    @Input
    abstract fun getStoneConfigs(): ListProperty<StoneConfig>

    @Input
    abstract fun getGeneratorDir(): Property<String>

    @Input
    abstract fun getSpecDir(): Property<String>

    @Optional
    @Input
    abstract fun getRouteWhitelistFilter(): Property<String>

    @Input
    abstract fun getStoneDir(): Property<String>

    @Input
    abstract fun getPythonCommand(): Property<String>

    @OutputDirectory
    abstract fun getOutputDir(): DirectoryProperty

    @Inject
    abstract fun getObjectFactory(): ObjectFactory

    @Inject
    abstract fun getExecOperations(): ExecOperations


    public fun config(configs: List<StoneConfig>) {
        getStoneConfigs().set(configs)
    }

    public fun generatorDir(generatorDir: String) {
        getGeneratorDir().set(generatorDir)
    }

    public fun routeWhitelistFilter(routeWhitelistFilter: String) {
        getRouteWhitelistFilter().set(routeWhitelistFilter)
    }

    public fun stoneDir(stoneDir: String) {
        getStoneDir().set(stoneDir)
    }

    public fun pythonCommand(pythonCommand: String) {
        getPythonCommand().set(pythonCommand)
    }

    public fun specDir(specDir: String) {
        getSpecDir().set(specDir)
    }

    public fun outputDir(outputDir: String) {
        getOutputDir().set(File(outputDir))
    }

    @TaskAction
    public fun processStone() {
        val generatorFileTree = getObjectFactory().fileTree().from(getGeneratorDir().get())
        generatorFileTree.include("**/*stoneg.py")
        val generatorFile = generatorFileTree.getSingleFile()
        val specFiles = getSpecFiles(getObjectFactory(), getSpecDir().get()).getFiles()
        for (config: StoneConfig in getStoneConfigs().get()) {
            config.routeWhitelistFilter = getRouteWhitelistFilter().getOrNull()
        }
        runStoneGenerator(
            getStoneConfigs().get(),
            getObjectFactory().fileTree().from(getStoneDir().get()).getDir(),
            generatorFile,
            specFiles,
            getOutputDir().getAsFile().get(),
            getPythonCommand().get()
        )
    }

    fun getSpecFiles(objectFactory: ObjectFactory, specDir: String): FileTree {
        val fileTree = objectFactory.fileTree().from(specDir)
        fileTree.include("**/*.stone")
        return fileTree
    }

    fun deleteDir(file: File) {
        val contents = file.listFiles()
        if (contents != null) {
            for (f in contents) {
                if (!Files.isSymbolicLink(f.toPath())) {
                    deleteDir(f)
                }
            }
        }
        file.delete()
    }

    fun runStoneGenerator(
        configs: List<StoneConfig>,
        stoneDir: File,
        generatorFile: File,
        specFiles: Collection<File>,
        outputDir: File,
        pythonCommand: String,
    ) {
        val srcOutputDir = File(outputDir, "src")
        val refsFile = File(outputDir, "refs/javadoc-refs.json")
        val logFile = File(outputDir, "log/stone.log")

        // delete output dir for a clean build
        if (outputDir.exists()) {
            try {
                deleteDir(outputDir)
            } catch (e: Exception) {
                throw GradleException("Failed to delete output directory: ${outputDir.absolutePath}")
            }
        }

        srcOutputDir.mkdirs()
        logFile.parentFile.mkdirs()
        refsFile.parentFile.mkdirs()

        configs.forEachIndexed { index, stoneConfig ->
            val isFirst = (index == 0)
            var append: Boolean = !isFirst
            if (stoneConfig.dataTypesOnly) {
                // generate only data types. This is a much simpler call
                if (stoneConfig.client != null) {
                    throw GradleException("Cannot specify dataTypesOnly and clients for Stone generation.")
                }
                getExecOperations().exec {
                    standardOutput = FileOutputStream(logFile, append)
                    commandLine(pythonCommand, "-m", "stone.cli")

                    environment["PYTHONPATH"] = stoneDir.absolutePath

                    if (isFirst) {
                        args.add("--clean-build")
                    }
                    if (stoneConfig.routeWhitelistFilter != null) {
                        args.add("--route-whitelist-filter")
                        args.add(getRouteWhitelistFilter().get())
                    }
                    args.add(generatorFile.absolutePath)
                    args.add(srcOutputDir.absolutePath)
                    specFiles.map { f -> f.absolutePath }.forEach {
                        args.add(it)
                    }
                    args.add("--")
                    args.add("--package")
                    args.add(stoneConfig.packageName)
                    args.add("--data-types-only")
                }
            } else {
                val client = stoneConfig.client
                val routeFilters = listOf(stoneConfig.globalRouteFilter, client?.routeFilter).filterNotNull()
                val routeFilter = routeFilters.joinToString(" and ") { filter -> "(${filter})" }

                getExecOperations().exec {
                    standardOutput = FileOutputStream(logFile, append)
                    commandLine("pythonCommand", "-m", "stone.cli")

                    environment["PYTHONPATH"] = stoneDir.absolutePath
                    if (isFirst) {
                        args.add("--clean-build")
                    }
                    args.add("--attribute")
                    args.add(":all")
                    if (routeFilter.isNotEmpty()) {
                        args.add("--filter-by-route-attr")
                        args.add(routeFilter)
                    }
                    if (stoneConfig.routeWhitelistFilter != null) {
                        args.add("--route-whitelist-filter")
                        args.add(stoneConfig.routeWhitelistFilter)
                    }
                    args.add(generatorFile.absolutePath)
                    args.add(srcOutputDir.absolutePath)
                    specFiles.map { f -> f.absolutePath }.forEach {
                        args.add(it)
                    }
                    args.add("--")
                    args.add("--package")
                    args.add(stoneConfig.packageName)
                    args.add("--javadoc-refs")
                    args.add(refsFile.absolutePath)

                    if (client?.name != null) {
                        args.add("--client-class")
                        args.add(client.name)
                    }
                    if (client?.javadoc != null) {
                        args.add("--client-javadoc")
                        args.add(client.javadoc)
                    }
                    if (client?.requestsClassnamePrefix != null) {
                        args.add("--requests-classname-prefix")
                        args.add(client.requestsClassnamePrefix)
                    }
                    if (client?.unusedClassesToGenerate != null) {
                        args.add("--unused-classes-to-generate")
                        args.add(client.unusedClassesToGenerate)
                    }
                }
            }
        }
    }
}