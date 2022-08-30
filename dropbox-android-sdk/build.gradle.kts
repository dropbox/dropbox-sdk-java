plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = dropboxJavaSdkLibs.versions.android.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = dropboxJavaSdkLibs.versions.android.min.sdk.get().toInt()
        targetSdk = dropboxJavaSdkLibs.versions.android.target.sdk.get().toInt()
    }
}

dependencies {
    implementation(dropboxJavaSdkLibs.kotlin.stdlib)
    project(":")
}
