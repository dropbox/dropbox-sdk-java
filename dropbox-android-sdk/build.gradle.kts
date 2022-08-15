plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
        targetSdk = libs.versions.android.target.sdk.get().toInt()
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    project(":")
}
