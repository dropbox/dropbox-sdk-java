package com.dropbox.stone.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.SourceSet

public class StonePlugin implements Plugin<Project> {

    void apply(final Project project) {
        project.convention.plugins.stone = new StoneConvention(project)

        addSourceSets(project)
        addTasks(project)
    }

    private void addSourceSets(final Project project) {
        project.sourceSets.all { SourceSet sourceSet ->
            sourceSet.extensions.create('stone', StoneSourceSetExtension, project, sourceSet.name)
            String configName = "main".equals(sourceSet.name) ? "stone" : "${sourceSet.name}Stone"
            if (project.configurations.findByName(configName) == null) {
                project.configurations.create(configName) {
                    visible = false
                    transitive = false
                    extendsFrom = []
                }
            }
        }
    }

    private void addTasks(final Project project) {
        project.sourceSets.all { SourceSet sourceSet ->
            String sourceSetIdentifier = "main".equals(sourceSet.name) ? "" : sourceSet.name
            String taskName = "generate${sourceSetIdentifier.capitalize()}Stone"

            // create task with sensible defaults
            StoneTask task = (StoneTask) project.tasks.create(taskName, StoneTask) { Task t ->
                t.description = "Generate Java source files from ${sourceSet.name} Stone spec files."
                t.sourceSet sourceSet
                t.stoneDir project.stone.stoneDir
                t.generatorDir project.stone.generatorDir
                t.outputBaseDir  "${project.stone.generatedFilesBaseDir}/${sourceSet.name}"
            }

            sourceSet.java.srcDir task.outputDir

            // add dependencies with other tasks
            addTaskDependencies(project, task, sourceSet)
        }
    }

    private void addTaskDependencies(Project project, Task task, SourceSet sourceSet) {
        Task compile = project.tasks.getByName(sourceSet.getCompileTaskName("java"))
        compile.dependsOn task
    }

    private static String decapitalize(String s) {
        char [] array = s.toCharArray()
        array[0] = Character.toLowerCase(array[0])
        return new String(array)
    }
}
