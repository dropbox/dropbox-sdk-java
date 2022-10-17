# Dropbox Core SDK for Java

![GitHub](https://img.shields.io/github/license/dropbox/dropbox-sdk-java)
![Maven Central](https://img.shields.io/maven-central/v/com.dropbox.core/dropbox-core-sdk)
![GitHub Release Date](https://img.shields.io/github/release-date/dropbox/dropbox-sdk-java)

A Java library to access [Dropbox's HTTP-based Core API v2](https://www.dropbox.com/developers/documentation/http/documentation).  This SDK also supports the older [Core API v1](https://www.dropbox.com/developers-v1/core/docs), but that support will be removed at some point.

License: [MIT](License.txt)

Documentation: [Javadocs](https://dropbox.github.io/dropbox-sdk-java/api-docs/v5.4.3/)

## Setup

### Java Version

The current release of Dropbox SDK Java supports Java 11+. If you are running Java 8 and want to use the SDK, you should use version `4.0.1`.

### Add a dependency on the Dropbox Java SDK to your project

If you're using Maven, then edit your project's "pom.xml" and add this to the `<dependencies>` section:

```xml
<dependency>
    <groupId>com.dropbox.core</groupId>
    <artifactId>dropbox-core-sdk</artifactId>
    <version>5.4.4</version>
</dependency>
```

If you are using Gradle, then edit your project's "build.gradle" and add this to the `dependencies` section:

```groovy
dependencies {
    // ...
    implementation 'com.dropbox.core:dropbox-core-sdk:5.4.4'
}
```

You can also download the Java SDK JAR and and its required dependencies directly from the [latest release page](https://github.com/dropbox/dropbox-sdk-java/releases/latest). Note that the distribution artifacts on the releases pages do not contain optional dependencies.

## Dropbox for Java tutorial

A good way to start using the Java SDK is to follow this quick tutorial. Just make sure you have the Java SDK [installed](#setup) first!

### Register a Dropbox API app

To use the Dropbox API, you'll need to register a new app in the [App Console](https://www.dropbox.com/developers/apps). Select Dropbox API app and choose your app's permission. You'll need to use the app key created with this app to access API v2.

### Link an account

In order to make calls to the API, you'll need an instance of the Dropbox object. To instantiate, pass in the access token for the account you want to link. (Tip: You can [generate an access token](https://blogs.dropbox.com/developers/2014/05/generate-an-access-token-for-your-own-account/) for your own account through the [App Console](https://www.dropbox.com/developers/apps)).

```java
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

public class Main {
    private static final String ACCESS_TOKEN = "<ACCESS TOKEN>";

    public static void main(String args[]) throws DbxException {
        // Create Dropbox client
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    }
}
```

Test it out to make sure you've linked the right account:

```java
// Get current account info
FullAccount account = client.users().getCurrentAccount();
System.out.println(account.getName().getDisplayName());
```

### Try some API requests

You can use the Dropbox object you instantiated above to make API calls. Try out a request to list the contents of a folder.

```java
// Get files and folder metadata from Dropbox root directory
ListFolderResult result = client.files().listFolder("");
while (true) {
    for (Metadata metadata : result.getEntries()) {
        System.out.println(metadata.getPathLower());
    }

    if (!result.getHasMore()) {
        break;
    }

    result = client.files().listFolderContinue(result.getCursor());
}
```

Try uploading a file to your Dropbox.

```java
// Upload "test.txt" to Dropbox
try (InputStream in = new FileInputStream("test.txt")) {
    FileMetadata metadata = client.files().uploadBuilder("/test.txt")
        .uploadAndFinish(in);
}
```

### Full Example Snippet

```java
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class Main {
    private static final String ACCESS_TOKEN = "<ACCESS TOKEN>";

    public static void main(String args[]) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }

        // Upload "test.txt" to Dropbox
        try (InputStream in = new FileInputStream("test.txt")) {
            FileMetadata metadata = client.files().uploadBuilder("/test.txt")
                .uploadAndFinish(in);
        }
    }
}
```

## Full examples

Some more complete examples can be found here:

* Example for a simple web app: [Web File Browser example](examples/examples/src/main/java/com/dropbox/core/examples/web_file_browser/DropboxAuth.java)
* Example for an Android app written in Kotlin: [Android Kotlin Example](examples/android)

To try out running these examples, please follow the instructions below.

### Save your Dropbox API key

Save your Dropbox API key to a JSON file called, say, "test.app":

```json
{
  "key": "Your Dropbox API app key",
  "secret": "Your Dropbox API app secret"
}
```

App key and secret can be found in you app page in [App Console](https://www.dropbox.com/developers/apps).

### Building from source

```shell
git clone https://github.com/dropbox/dropbox-sdk-java.git
cd dropbox-sdk-java
./update-submodules    # also do this after every "git checkout"
./gradlew build # requires `python` command to use Python 3.9, pip dropbox
```

The output will be in "build/".

### Running the examples

1. Follow the instructions in the "Build from source" section above.
2. Save your Dropbox API key in a file called "test.app".  See: [Save your Dropbox API key](#save-your-dropbox-api-key), above.
3. Compile and install the SDK into your local maven repo: `./gradlew build`
4. To compile all the examples: `cd examples/ && ./gradlew classes`
5. To compile just one example: `cd examples/ && ./gradlew :<example-name>:classes`

#### authorize

This example runs through the OAuth 2 authorization flow.

```shell
cd examples
./run authorize test.app test.auth
```

This produces a file named "test.auth" that has the access token.  This file can be passed in to the other examples.

#### account-info

A simple example that fetches and displays information about the account associated with the access token.

```shell
cd examples
./run account-info test.auth
```

(You must first generate "test.auth" using the "authorize" example above.)

#### longpoll

An example of how to watch for changes in a Dropbox directory.

```shell
cd examples
./run longpoll test.auth "/path/to/watch"
```

(You must first generate "test.auth" using the "authorize" example above.)

#### upload-file

Uploads a file to Dropbox. The example includes regular and chunked file uploads.

```shell
cd examples
./run upload-file test.auth local-path/file.txt /dropbox-path/file.txt
```

(You must first generate "test.auth" using the "authorize" example above.)

#### web-file-browser

A tiny web app that runs through the OAuth 2 authorization flow and then uses Dropbox API calls to let the user browse their Dropbox files.

Prerequisite: In the Dropbox API [app configuration console](https://www.dropbox.com/developers/apps), you need to add "http://localhost:5000/dropbox-auth-finish" to the list of allowed redirect URIs.

```shell
cd examples
./run web-file-browser 5000 test.app web-file-browser.db
```

## Running the integration tests

1. Run through the `authorize` example above to get a "test.auth" file.
2. `./gradlew -Pcom.dropbox.test.authInfoFile=<path-to-test.auth> integrationTest`

To run individual tests, use the `--tests` gradle test filter:

```shell
./gradlew -Pcom.dropbox.test.authInfoFile=<path-to-test.auth> integrationTest --tests '*.DbxClientV1IT.testAccountInfo'
```

## Usage on Android

The Android code in this SDK is written in Kotlin (as of 5.4.x) and Kotlin is now a runtime dependency. If you do not already have Kotlin in your project, you will need to add `implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.21")` to your dependencies block in order to avoid a runtime exception.

At this point in time, the Android code is bundled with the main Java artifact, but will be published as a separate artifact at some point in the future.

If the [official Dropbox App](https://play.google.com/store/apps/details?id=com.dropbox.android) is installed, it will attempt to use it to do authorization.  If it is not, a web authentication flow is launched in-browser.

Use the methods in the [`Auth`](https://github.com/dropbox/dropbox-sdk-java/blob/main/dropbox-sdk-android/src/main/java/com/dropbox/core/android/Auth.kt) to start an authentication sessions.
* [`Auth.startOAuth2Authentication(...)`](https://github.com/dropbox/dropbox-sdk-java/blob/main/dropbox-sdk-android/src/main/java/com/dropbox/core/android/Auth.kt)
* [`Auth.startOAuth2PKCE(...)`](https://github.com/dropbox/dropbox-sdk-java/blob/main/dropbox-sdk-android/src/main/java/com/dropbox/core/android/Auth.kt)

Please look at the `examples/android` sample app for usage as well.

### Required Configuration for Authentication on Android

The following below is required configuration when using the SDK on Android.

#### AndroidManifest.xml

Add these following pieces to your `AndroidManifest.xml` to use Dropbox for Authentication in Android.

##### Add `AuthActivity` to the manifest
Use your Dropbox APP Key in place of `dropboxKey` below.  You need to add the `AuthActivity` entry, and it's associated `intent-filter`.  
```
<manifest>
    ...
    <application>
        <activity
            android:name="com.dropbox.core.android.AuthActivity"
            android:exported="true"
            android:configChanges="orientation|keyboard"
            android:launchMode="singleTask">
            <intent-filter>
                <data android:scheme="db-${dropboxKey}" />
        
                <action android:name="android.intent.action.VIEW" />
        
                <category android:name="android.intent.category.BROWSABLE" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
            
            <!-- Additional intent-filter required as a workaround for Apps using targetSdk=33 until the fix in the Dropbox app is available to all users. -->
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
    </application>
    ...
</manifest>
```

🚨[There is a known issue regarding apps with `targetSdk=33` regarding app-to-app authentication when the Dropbox App is installed](https://github.com/dropbox/dropbox-sdk-java/pull/471) 🚨
A fix is being worked on and will be released in an upcoming version of the Dropbox Mobile App.

##### Add Dropbox `package` to `queries`
Additionally, you need to allow `queries` from the Dropbox official app for verification during the app-to-app authentication flow.
```
<manifest>
    ...
    <queries>
        <package android:name="com.dropbox.android" />
    </queries>
    ...
</manifest>
```

## FAQ

### When I use `OkHttp3Requestor` in `DbxRequestConfig`, I get errors like 'class file for okhttp3.OkHttpClient not found'

The dependency of OKHttp/OKHttp3 is optional. You should add them, only if you explicitly want to use it as the http requestor.

Example in Gradle:

```gradle
dependencies {
    // ...
    api 'com.squareup.okhttp3:okhttp:4.0.0'
}
```

### When I use the bundle JAR with some OSGi containers within an OSGi subsystem, I get a "Missing required capability" error

The JAR's manifest has the following line:

```
Require-Capability: osgi.ee;filter:="(&(osgi.ee=JavaSE)(version=11))"
```

Most OSGi containers should provide this capability.  Unfortunately, some OSGi containers don't do this correctly and will reject the bundle JAR in the OSGi subsystem context.

As a workaround, you can build your own version of the JAR that omits the "osgi.ee" capability by running:

```shell
./gradlew clean
./gradlew -Posgi.bnd.noee=true :dropbox-sdk-java:jar
```

(This is equivalent to passing the "-noee" option to the OSGi "bnd" tool.)

Another workaround is to tell your OSGi container to provide that requirement: [StackOverflow answer](https://stackoverflow.com/a/24673359/163832).

### Does this SDK require any special ProGuard rules for shrink optimizations?

Versions 2.0.0-2.0.3 of this SDK require SDK-specific ProGuard rules when shrinking is enabled. However, since version **2.0.4**, the only ProGuard rules necessary are for the SDK's required and optional dependencies. If you encounter ProGuard warnings, consider adding the following "-dontwarn" directives to your ProGuard configuration file:

```
-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn com.squareup.okhttp.**
-dontwarn com.google.apphosting.**
-dontwarn com.google.appengine.**
-dontwarn com.google.protos.cloud.sql.**
-dontwarn com.google.cloud.sql.**
-dontwarn javax.activation.**
-dontwarn javax.mail.**
-dontwarn javax.servlet.**
-dontwarn org.apache.**
```
