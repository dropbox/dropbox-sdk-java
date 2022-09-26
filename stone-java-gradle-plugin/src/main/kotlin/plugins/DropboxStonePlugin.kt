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
                stoneTask.outputDir("${project.projectDir}/generated_stone_source/${sourceSet.name}")

                stoneTask.inputs
                    .dir {
                        project.fileTree(stoneTask.getGeneratorDir()).filter { !it.name.endsWith(".pyc") }
                    }
                    .withPropertyName("stone")
                    .withPathSensitivity(PathSensitivity.RELATIVE)
                stoneTask.inputs.dir(stoneTask.getSpecFiles(project.objects, stoneTask.getSpecDir().get()))
                    .withPathSensitivity(
                        PathSensitivity.RELATIVE
                    )
                    .withPropertyName("stoneSpec").skipWhenEmpty(true)
//                val configsValue: String = groovy.json.JsonBuilder(stoneTask.getStoneConfigs().get()).toPrettyString()
//                stoneTask.inputs.properties["configs"] = configsValue
                stoneTask.outputs.dir { stoneTask.getOutputDir() }.withPropertyName("generatedStone")
                stoneTask.outputs.cacheIf { true }
//
                sourceSet.java.srcDir(stoneTask.getOutputDir().get().toString() + "/src")
                val compile: Task = project.tasks.getByName(sourceSet.getCompileTaskName("java"))
                compile.dependsOn(stoneTask)
            }
        }
    }
}


//// add generateStone task for all source sets (e.g. generateTestStone, etc)
//project.sourceSets.all { SourceSet sourceSet ->
//    def taskName = "main" == sourceSet.name ? "generateStone" : "generate${sourceSet.name.capitalize()}Stone"
//    tasks.register(taskName, StoneTask) {
//        description "Generate Stone Java source files for ${sourceSet.name}."
//
//        def specDirPropName = "com.dropbox.api.${sourceSet.name}.specDir".toString()
//        def mySpecDir = project.properties.get(specDirPropName, "src/${sourceSet.name}/stone")
//        specDir mySpecDir
//                def routeWhitelistFilterPropName = "com.dropbox.api.${sourceSet.name}.routeWhitelistFilter".toString()
//        generatorDir 'generator'
//        stoneDir 'stone'
//        routeWhitelistFilter project.properties.get(routeWhitelistFilterPropName, null)
//        pythonCommand 'python'
//        outputDir "${project.getProjectDir()}/generated_stone_source/${sourceSet.name}"
//
//        inputs.dir { project.fileTree(dir: generatorDir, exclude: '**/*.pyc') }.withPropertyName("stone").withPathSensitivity(PathSensitivity.RELATIVE)
//        inputs.dir(getSpecFiles(objects, getSpecDir().get())).withPathSensitivity(PathSensitivity.RELATIVE).withPropertyName("stoneSpec").skipWhenEmpty(true)
//        inputs.property "configs", { new groovy.json.JsonBuilder(getStoneConfigs().get()).toString() }
//        outputs.dir { getOutputDir().get() }.withPropertyName("generatedStone")
//        outputs.cacheIf { true }
//    }
//
//    sourceSet.java.srcDir project.tasks."${taskName}".getOutputDir().get().toString() + "/src"
//    Task compile = project.tasks.getByName(sourceSet.getCompileTaskName("java"))
//    compile.dependsOn project.tasks."${taskName}"
//}
//
//
//generateStone {
//    String unusedClassesToGenerate = 'AuthError, PathRoot, PathRootError, AccessError, RateLimitError'
//    String packageName = 'com.dropbox.core.v2'
//    String globalRouteFilter = 'alpha_group=null and beta_group=null'
//    config [
//        new StoneConfig(
//                packageName: packageName,
//    globalRouteFilter: globalRouteFilter,
//    client: new ClientSpec(
//    name: 'DbxClientV2Base',
//    javadoc: 'Base class for user auth clients.',
//    requestsClassnamePrefix: "DbxUser",
//    routeFilter: 'auth="user" or auth="noauth" or auth="app, user"',
//    unusedClassesToGenerate: unusedClassesToGenerate,
//    ),
//    ),
//    new StoneConfig(
//            packageName: packageName,
//    globalRouteFilter: globalRouteFilter,
//    client:  new ClientSpec(
//    name: 'DbxTeamClientV2Base',
//    javadoc: 'Base class for team auth clients.',
//    requestsClassnamePrefix: 'DbxTeam',
//    routeFilter: 'auth="team"',
//    ),
//    ),
//    new StoneConfig(
//            packageName: packageName,
//    globalRouteFilter: globalRouteFilter,
//    client: new ClientSpec(
//    name: 'DbxAppClientV2Base',
//    javadoc: 'Base class for app auth clients.',
//    requestsClassnamePrefix: "DbxApp",
//    routeFilter: 'auth="app" or auth="app, user"',
//    )
//    ),
//
//    ]
//}
//
//generateTestStone {
//    String packageName = 'com.dropbox.core.stone'
//    config [
//        new StoneConfig(
//                packageName: packageName,
//    dataTypesOnly: true,
//    ),
//    new StoneConfig(
//            packageName: packageName,
//    client: new ClientSpec(
//    name: 'DbxClientV2Base',
//    javadoc: 'TestClass.',
//    requestsClassnamePrefix: "DbxTest",
//    )
//    ),
//    ]
//}
