package com.dropbox.stone.java

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
public class StonePlugin : Plugin<Project> {

    private lateinit var project: Project

    override fun apply(target: Project) {
        this.project = target
        val javaPluginExtension = project.extensions.getByType(JavaPluginExtension::class.java)

        // add generateStone task for all source sets (e.g. generateTestStone, etc)
        javaPluginExtension.sourceSets.forEach { sourceSet: SourceSet ->
            createTaskForSourceSet(project, sourceSet)
        }
    }

    private fun createTaskForSourceSet(
        project: Project,
        sourceSet: SourceSet
    ) {
        val isMainSourceSet = sourceSet.name == "main"
        val taskName: String = if (isMainSourceSet) {
            "generateStone"
        } else {
            "generate${sourceSet.name.capitalize()}Stone"
        }
        val stoneTaskProvider: TaskProvider<StoneTask> = project.tasks.register(taskName, StoneTask::class.java)
        stoneTaskProvider.get().also { stoneTask ->
            stoneTask.description = "Generate Stone Java source files for ${sourceSet.name}."

            val routeWhitelistFilterPropName = "com.dropbox.api.${sourceSet.name}.routeWhitelistFilter"
            val routeWhitelistFilterValue: String? = project.properties[routeWhitelistFilterPropName] as String?
            routeWhitelistFilterValue?.let {
                stoneTask.routeWhitelistFilter(it)
            }

            val specDirPropName = "com.dropbox.api.${sourceSet.name}.specDir"
            val specDirPropNameValue: String? = project.properties[specDirPropName] as String?
            val mySpecDir: String = specDirPropNameValue ?: "src/${sourceSet.name}/stone"

            stoneTask.specDir(mySpecDir)
            stoneTask.generatorDir("generator")
            stoneTask.stoneDir("stone")
            stoneTask.pythonCommand("python")
            stoneTask.outputDir("${project.buildDir}/generated/source/stone/${sourceSet.name}")
            stoneTask.inputs
                .dir { project.fileTree(stoneTask.getGeneratorDir()) { filter { !it.name.endsWith(".pyc") } } }
                .withPropertyName("stone")
                .withPathSensitivity(PathSensitivity.RELATIVE)

            val specDir = stoneTask.getSpecDir().get()
            stoneTask.inputs
                .dir(stoneTask.getSpecFiles(project.objects, specDir))
                .withPathSensitivity(PathSensitivity.RELATIVE)
                .withPropertyName("stoneSpec")
                .skipWhenEmpty(true)
            stoneTask.outputs
                .dir { stoneTask.getOutputDir() }
                .withPropertyName("generatedStone")
            stoneTask.outputs.cacheIf { true }

            val compile: Task = project.tasks.getByName(sourceSet.getCompileTaskName("java"))
            compile.dependsOn(stoneTask)

            project.afterEvaluate {
                // Must run afterEvaluate so we can honor any output directory specified in user's config
                sourceSet.java.srcDir("${stoneTask.getOutputDir().get()}/src")
            }
        }
    }

}
