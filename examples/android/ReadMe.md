# Example Android application (using the Dropbox SDK for Java.)

This shows the Dropbox API authorization flow and some API calls to retrieve files.

## Requirements

This example is backwards compatible with Android 5.0 (Lollipop). Ensure your build environment supports at least Android SDK version 21.

## Running the example

Running in [Android Studio](https://developer.android.com/studio) (not strictly necessary)

* Download this `dropbox-sdk-java` repository or clone it using `git clone https://github.com/dropbox/dropbox-sdk-java`.
* Open the root folder `dropbox-sdk-java` in the terminal, or open it in Android Studio.
* Create a `local.properties` manually in the Android example project at `examples/android/local.properties` with the content `DROPBOX_APP_KEY=YOUR_KEY_HERE` where `YOUR_KEY_HERE` is your [Dropbox App/Api Key](../../README.md#get-a-dropbox-api-key). 
  * TIP: You can create this `local.properties` file with the appropriate contents by runing this command `echo "DROPBOX_APP_KEY=YOUR_KEY_HERE" > examples/android/local.properties` on the terminal from the `dropbox-sdk-java`.
  * NOTE: This step of creating the `examples/android/local.properties` file is not required to build the app, but is required if you would like to test authentication.
5. Build and run the Android sample via the Android Studio UI.

# Notes

This example project uses the source version of `dropbox-sdk-java`.  If you would like to use the published version of the SDK, replace the following in the `examples/android/build.gradle` file.
* Replace `implementation(project(":dropbox-sdk-java"))` 
* with `implementation("com.dropbox.core:dropbox-core-sdk:LATEST_VERSION_GOES_HERE")`
