package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.TaskProvider

/**
 * Android Application Convention Plugin
 *
 * We'll apply all of Dropbox's Custom Config here.
 */
public class DropboxStonePlugin : Plugin<Project> {
    override fun apply(project: Project) {

        val javaPluginExtension = project.extensions.getByType(JavaPluginExtension::class.java)

        // add generateStone task for all source sets (e.g. generateTestStone, etc)
        javaPluginExtension.sourceSets.forEach { sourceSet: SourceSet ->
            val isMainSourceSet = sourceSet.name == "main"
            val taskName: String = if (isMainSourceSet) {
                "generateStone"
            } else {
                "generate${sourceSet.name.capitalize()}Stone"
            }
            val stoneTaskProvider: TaskProvider<StoneTask> = project.tasks.register(taskName, StoneTask::class.java)
            stoneTaskProvider.get().also { stoneTask ->
                stoneTask.description = "Generate Stone Java source files for ${sourceSet.name}."

                val specDirPropName = "com.dropbox.api.${sourceSet.name}.specDir"
                val specDirPropNameValue: String? = project.properties[specDirPropName] as String?
                val mySpecDir: String = specDirPropNameValue ?: "src/${sourceSet.name}/stone"
                stoneTask.specDir(mySpecDir)
                val routeWhitelistFilterPropName = "com.dropbox.api.${sourceSet.name}.routeWhitelistFilter"
                stoneTask.generatorDir("generator")
                stoneTask.stoneDir("stone")
                val routeWhitelistFilterValue: String? = project.properties[routeWhitelistFilterPropName] as String?
                routeWhitelistFilterValue?.let {
                    stoneTask.routeWhitelistFilter(it)
                }
                stoneTask.pythonCommand("python")
                stoneTask.outputDir("${project.buildDir}/generated/source/stone/${sourceSet.name}")

                stoneTask.inputs
                    .dir {
                        val configurableFileTree = project.fileTree(stoneTask.getGeneratorDir()) {
                            filter { !it.name.endsWith(".pyc") }
                        }
                        configurableFileTree
                    }
                    .withPropertyName("stone")
                    .withPathSensitivity(PathSensitivity.RELATIVE)
                val specDir = stoneTask.getSpecDir().get()
                stoneTask.inputs.dir(stoneTask.getSpecFiles(project.objects, specDir))
                    .withPathSensitivity(PathSensitivity.RELATIVE)
                    .withPropertyName("stoneSpec")
                    .skipWhenEmpty(true)
//                val configsValue: String = groovy.json.JsonBuilder(stoneTask.getStoneConfigs().get()).toPrettyString()
//                stoneTask.inputs.properties["configs"] = configsValue
                stoneTask.outputs.dir { stoneTask.getOutputDir() }.withPropertyName("generatedStone")
                stoneTask.outputs.cacheIf { true }
//
                sourceSet.java.srcDir(stoneTask.getOutputDir().get().toString() + "/src")
                val compile: Task = project.tasks.getByName(sourceSet.getCompileTaskName("java"))
                val logger = project.logger
                logger.info("-------------------")
                logger.info("Input Properties for StoneTask ${stoneTask.name}")
                stoneTask.inputs.properties.entries.forEach {
                    project.logger.info("${it.key} -> ${it.value}")
                }
                logger.info("")
                compile.dependsOn(stoneTask)
            }
        }
    }
}
