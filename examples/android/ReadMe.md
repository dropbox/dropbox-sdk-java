# Example Android application (using the Dropbox SDK for Java.)

This shows the Dropbox API authorization flow and some API calls to retrieve files.

## Requirements

This example is backwards compatible with Android 4.4 (KitKat). Ensure your build environment supports at least Android SDK version 19.

## Running the example

Prerequisites: Apache Maven (to build the SDK), [Android Studio](http://developer.android.com/sdk/installing/) (not strictly necessary)

1. Download this repository.
2. Build the SDK: run `mvn install` in the SDK root directory (two levels up from this folder).
3. In Android Studio, choose "Import Project" and select this folder.
4. Edit "src/main/AndroidManifest.xml" and "src/main/res/values/strings.xml" and replace `YOUR_APP_KEY_HERE` with your Dropbox API key ([how to get a Dropbox API key](../../ReadMe.md#get-a-dropbox-api-key)).
5. Build and run.

If you don't have Android Studio, you can use the command-line:

1. Make sure you have the standalone [Android SDK Tools](http://developer.android.com/sdk/installing/).
2. Make sure your `ANDROID_SDK` environment variable is set to the path where the standalone Android SDK Tools are installed.
3. To build: run `./gradlew assemble`.
4. The example app's ".apk" files should now be in "build/outputs/apk".  You can use "adb install" to install them to the emulator or to a real device.

## ProGuard

The Dropbox Java SDK supports ProGuard class file shrinking optimizations. The only requirements to
your ProGuard configuration are to ensure [Jackson Databind](https://github.com/FasterXML/jackson-databind)
classes are handled correctly and annotations are kept. See [proguard-rules.pro](proguard-rules.pro) for an example.