plugins {
    `kotlin-dsl`
}

group = "com.dropbox.gradle.plugins"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(dropboxJavaSdkLibs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        fun createPlugin(id: String, className: String) {
            plugins.create(id) {
                this.id = id
                implementationClass = className
            }
        }
        createPlugin(
            id = "com.dropbox.stone.java",
            className = "plugins.DropboxStonePlugin"
        )
    }
}
