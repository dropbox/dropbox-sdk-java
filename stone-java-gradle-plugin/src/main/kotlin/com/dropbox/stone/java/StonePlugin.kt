package com.dropbox.stone.java

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.File

/**
 * Stone Plugin
 *
 * Allows us to apply a Stone Plugin and utilize StoneTask.
 */
class StonePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val javaPluginExtension = target.extensions.getByType(JavaPluginExtension::class.java)

        // add generateStone task for all source sets (e.g. generateTestStone, etc)
        javaPluginExtension.sourceSets.forEach { sourceSet: SourceSet ->
            createTaskForSourceSet(target, sourceSet)
        }

        // Declare dependency of compile tasks on stone tasks.
        // We need the generated code first or the project won't compile.
        target.tasks.withType<JavaCompile>().configureEach {
            dependsOn(target.tasks.withType<StoneTask>())
        }
        target.tasks.withType<KotlinCompile>().configureEach {
            dependsOn(target.tasks.withType<StoneTask>())
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

        project.tasks.register(taskName, StoneTask::class.java) {
            description = "Generate Stone Java source files for ${sourceSet.name}."

            val routeWhitelistFilterPropName = "com.dropbox.api.${sourceSet.name}.routeWhitelistFilter"
            val routeWhitelistFilterValue: String? = project.properties[routeWhitelistFilterPropName] as String?
            if (!routeWhitelistFilterValue.isNullOrBlank()) routeWhitelistFilter.set(File(routeWhitelistFilterValue))

            val specDirPropName = "com.dropbox.api.${sourceSet.name}.specDir"
            val specDirPropNameValue: String? = project.properties[specDirPropName] as String?
            val mySpecDir: String = specDirPropNameValue ?: "src/${sourceSet.name}/stone"
            specDir.set(File(mySpecDir))

            generatorFile.set(File("${project.layout.projectDirectory}/generator/java/java.stoneg.py"))
            stoneDir.set(File("stone"))
            pythonCommand.set("python")
            outputDir.set(File("${project.layout.buildDirectory}/generated/source/stone/${sourceSet.name}/src"))

            sourceSet.java.srcDir("${outputDir}/src")
        }
    }
}
