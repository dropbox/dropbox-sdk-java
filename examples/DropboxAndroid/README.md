# Dropbox Android Example
<img src="https://user-images.githubusercontent.com/10744793/125870299-b1079798-e3ba-4e51-a289-f2689dfc9905.png" width="220">


This is a sample app to show you how to integrate an Android app with the Dropbox Java SDK. It demonstrates how to do the following:
- Authenticates with the Dropbox SDK
- Upload a photo to Dropbox
- Fetch the contents of a folder
- Fetch a user's profile information
- Use Kotlin Coroutines to make calls to the Dropbox API off the main thread using the Java SDK
- Hide the app key using `local.properties` (as described below)


<img src="https://user-images.githubusercontent.com/10744793/125870219-87508fbd-56f8-4960-8ca4-d938a83069c7.png" width="320">  <img src="https://user-images.githubusercontent.com/10744793/125870223-22fff96c-e818-4884-b354-87c4bba0d08a.png" width="320">

## Creating your own Android app with the Dropbox Java SDK

1. Acquire an app key for your project, [instructions here](../../ReadMe.md#get-a-dropbox-api-key)
2. Add the dependency to your build.gradle with the latest version. You can find our versions [here](https://github.com/dropbox/dropbox-sdk-java/releases).
```
implementation 'com.dropbox.core:dropbox-core-sdk:X.Y.Z'
```
3. Add the following to your `AndroidManifest.xml` and replace `YOUR_APP_KEY` with the key from the console

```
        <activity
            android:name="com.dropbox.core.android.AuthActivity"
            android:configChanges="orientation|keyboard"
            android:launchMode="singleTask">
            <intent-filter>

                <!-- Change this to be db- followed by your app key -->
                <data android:scheme="db-YOUR_APP_KEY" />

                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.BROWSABLE" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
```
4. To initiate the Dropbox authentication flow call `startOAuth2PKCE` with the appropiate scopes your app will need. Read more about scopes [here](https://developers.dropbox.com/oauth-guide#dropbox-api-permissions). This will launch the Dropbox app if installed or Dropbox.com in the browser.
```
val scopes = listOf("account_info.read", "files.content.write")
Auth.startOAuth2PKCE(this, APP_KEY, requestConfig, scopes)
```
5. When the user has completed the authentication flow they will be taken back to your app. In `onResume` you can call `Auth.getDbxCredential()` to get the resulting `DbxCredential`.
6. To make requests using the Dropbox Java SDK, create a `DbxClientV2` like so. ClientIdentifiers are usually of the form "SoftwareName/SoftwareVersion". `DbxClientV2` will have the request objects needed to make a call to the Dropbox API.
```
val clientIdentifier = "DropboxSampleAndroid/1.0.0"
val requestConfig = DbxRequestConfig(clientIdentifier)
val dropboxClient = DbxClientV2(requestConfig, credential)
```
The Dropbox Java SDK will use the long lived refresh token found in the DbxCredential to automatically refresh your short lived access token when it makes requests.

### Hiding your Dropbox App Secret

If you want to hide your Dropbox app secret, you can follow these steps:
1. Edit your `local.properties` file to contain the following line with your Dropbox key from the developer console
```
DROPBOX_KEY=mydropboxkeygoeshere
```
2. Edit your `build.gradle` to include the following:
```
android {
    defaultConfig {
        //more config

        Properties localProperties = getLocalProperties()
        String dropboxKey = localProperties['DROPBOX_KEY']
        buildConfigField "String", "DROPBOX_KEY", "\"${dropboxKey}\""
        manifestPlaceholders = [dropboxKey: dropboxKey]
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
}

def getLocalProperties() {
    Properties props = new Properties()
    if (file('../local.properties').exists()) {
        props.load(new FileInputStream(file('../local.properties')))
    }
    return props
}
```
3. Edit your `AndroidManifest` to use the manifest placeholder defined in step 2.
```
    <activity
        android:name="com.dropbox.core.android.AuthActivity"
        android:configChanges="orientation|keyboard"
        android:launchMode="singleTask">
        <intent-filter>
            <!-- Using a Manifest Placeholder to hide our app key -->
            <data android:scheme="db-${dropboxKey}" />
            <action android:name="android.intent.action.VIEW" />
            <category android:name="android.intent.category.BROWSABLE" />
            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>
```
4. Use your app key with:
```
val APP_KEY = BuildConfig.DROPBOX_KEY
```

## Authentication with the Dropbox Java SDK
Starting September 30, 2021 the Dropbox authentication flow will only return short lived tokens. The Java SDK has been updated to support this using `DbxCredential`s.
This credential consists of a short lived `accessToken` and a long lived `refreshToken`. The SDK will refresh this short lived access token by calling the server and exchanging the refresh token for an access token when the access token has expired (See `refreshAccessTokenIfNeeded()` in `DbxRawClientV2`).
This allows clients to continue to have a valid access token without further interaction with the user. This is useful for mobile clients that need to do periodic background work without having to force the user to manually re-authenticate.

If you have users with existing long lived access tokens, they will not be impacted. Only tokens issued after September 30th will be short lived.
