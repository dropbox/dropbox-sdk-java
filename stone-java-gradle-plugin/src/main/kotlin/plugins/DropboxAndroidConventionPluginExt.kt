package plugins.android

import VersionCatalogExt
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Common Configuration for Android Libraries and Apps
 */
internal fun Project.applyCommonAndroidConfig() {

    val libs = VersionCatalogExt(this)

    plugins.apply("org.jetbrains.kotlin.android")
    extensions.getByType(BaseExtension::class.java).apply {
        compileSdkVersion(libs.ANDROID_COMPILE_SDK_VERSION)
        compileOptions {
            targetCompatibility = JavaVersion.VERSION_1_8
            sourceCompatibility = JavaVersion.VERSION_1_8
            isCoreLibraryDesugaringEnabled = true
        }
        defaultConfig {
            minSdk = libs.ANDROID_MIN_SDK_VERSION
            targetSdk = libs.ANDROID_TARGET_SDK_VERSION
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    dependencies {
        add("coreLibraryDesugaring", libs.ANDROID_TOOLS_CORE_DESUGARING)
    }
}
