# Dropbox Core SDK for Java 6+

A Java library to access [Dropbox's HTTP-based Core API v2](https://www.dropbox.com/developers/documentation/http/documentation).  This SDK also supports the older [Core API v1](https://www.dropbox.com/developers-v1/core/docs), but that support will be removed at some point.

License: [MIT](License.txt)

[Javadoc.](https://dropbox.github.io/dropbox-sdk-java/api-docs/v2.1.x/)

## Setup

If you're using Maven, then edit your project's "pom.xml" and add this to the `<dependencies>` section:

```xml
<dependency>
    <groupId>com.dropbox.core</groupId>
    <artifactId>dropbox-core-sdk</artifactId>
    <version>2.1.1</version>
</dependency>
```

If you are using Gradle, then edit your project's "build.gradle" and add this to the `dependencies` section:

```groovy
dependencies {
    // ...
    compile 'com.dropbox.core:dropbox-core-sdk:2.1.1'
}
```

You can also download the Java SDK JAR and and its required dependencies directly from the [latest release page](https://github.com/dropbox/dropbox-sdk-java/releases/latest). Note that the distribution artifacts on the releases pages do not contain optional dependencies.

## Get a Dropbox API key

You need a Dropbox API key to make API requests.
  * Go to: [https://www.dropbox.com/developers/apps](https://www.dropbox.com/developers/apps)
  * If you've already registered an app, click on the "Options" link to see the app's API key and secret.
  * Otherwise, click "Create an app" to register an app.  Choose "Dropbox API app", then "Files and datastores", then "Yes" or "No" [depending on your needs](https://www.dropbox.com/developers/reference#permissions).

Save the API key to a JSON file called, say, "test.app":

```
{
  "key": "Your Dropbox API app key",
  "secret": "Your Dropbox API app secret"
}
```

## Using the Dropbox API

Before your app can access a Dropbox user's files, the user must authorize your application using OAuth 2.  Successfully completing this authorization flow gives you an _access token_ for the user's Dropbox account, which grants you the ability to make Dropbox API calls to access their files.
  * Example for a simple web app: [Web File Browser example](examples/web-file-browser/src/main/java/com/dropbox/core/examples/web_file_browser/DropboxAuth.java)
  * Example for an Android app: [Android example](examples/android/src/main/java/com/dropbox/core/examples/android/UserActivity.java)
  * Example for a command-line tool: [Command-Line Authorization example](examples/authorize/src/main/java/com/dropbox/core/examples/authorize/Main.java)

Once you have an access token, create a [`DbxClientV2`](https://dropbox.github.io/dropbox-sdk-java/api-docs/v2.1.x/com/dropbox/core/v2/DbxClientV2.html) and start making API calls.

You only need to perform the authorization process once per user.  Once you have an access token for a user, save it somewhere persistent, like in a database.  The next time that user visits your app's, you can skip the authorization process and go straight to creating a `DbxClientV2` and making API calls.

## Building from source

```
git clone https://github.com/dropbox/dropbox-sdk-java.git
cd dropbox-sdk-java
./update-submodules    # also do this after every "git checkout"
./gradlew build
```

The output will be in "build/".

## Running the examples

1. Follow the instructions in the "Build from source" section above.
2. Save your Dropbox API key in a file called "test.app".  See: [Get a Dropbox API key](#get-a-dropbox-api-key), above.
3. Compile and install the SDK into your local maven repo: `./gradlew install`
4. To compile all the examples: `(cd examples/ && ./gradlew classes`
5. To compile just one example: `(cd examples/ && ./gradlew :<example-name>:classes`

### authorize

This examples runs through the OAuth 2 authorization flow.

```
cd examples
./run authorize test.app test.auth
```

This produces a file named "test.auth" that has the access token.  This file can be passed in to the other examples.

### account-info

A simple example that fetches and displays information about the account associated with the access token.

```
cd examples
./run account-info test.auth
```

(You must first generate "test.auth" using the "authorize" example above.)

### longpoll

An example of how to watch for changes in a Dropbox directory.

```
cd examples
./run longpoll test.auth "/path/to/watch"
```

(You must first generate "test.auth" using the "authorize" example above.)

### tutorial

The example from our [online tutorial](https://www.dropbox.com/developers/documentation/java#tutorial). Unlike the other examples, this example is not meant to be run without modification.

### upload-file

Uploads a file to Dropbox. The example includes regular and chunked file uploads.

```
cd examples
./run upload-file test.auth local-path/file.txt /dropbox-path/file.txt
```

(You must first generate "test.auth" using the "authorize" example above.)

### web-file-browser

A tiny web app that runs through the OAuth 2 authorization flow and then uses Dropbox API calls to let the user browse their Dropbox files.

Prerequisite: In the Dropbox API [app configuration console](https://www.dropbox.com/developers/apps), you need to add "http://localhost:5000/dropbox-auth-finish" to the list of allowed redirect URIs.

```
cd examples
./run web-file-browser 5000 test.app web-file-browser.db
```

## Running the integration tests

1. Run through the `authorize` example above to get a "test.auth" file.
2. `./gradlew -Pcom.dropbox.test.authInfoFile=<path-to-test.auth> integrationTest`

To run individual tests, use the `--tests` gradle test filter:
```
./gradlew -Pcom.dropbox.test.authInfoFile=<path-to-test.auth> integrationTest --tests '*.DbxClientV1IT.testAccountInfo'
```

## FAQ

### When I use the bundle JAR with some OSGi containers within an OSGi subsystem, I get a "Missing required capability" error.

The JAR's manifest has the following line:

```
Require-Capability: osgi.ee;filter="(&(osgi.ee=JavaSE)(version=1.6))"
```

OSGi containers running on Java 1.6 or above should provide this capability.  Unfortunately, some OSGi containers don't do this correctly and will reject the bundle JAR in the OSGi subsystem context.

As a workaround, you can build your own version of the JAR that omits the "osgi.ee" capability by running:

```
./gradlew clean
./gradlew -Posgi.bnd.noee=true jar
```

(This is equivalent to passing the "-noee" option to the OSGi "bnd" tool.)

Another workaround is to tell your OSGi container to provide that requirement: [StackOverflow answer](https://stackoverflow.com/a/24673359/163832).

### Does this SDK require any special ProGuard rules for shrink optimizations?

Versions 2.0.0-2.0.3 of this SDK require SDK-specific ProGuard rules when shrinking is enabled. However, since version **2.0.4**, the only ProGuard rules necessary are for the SDK's required and optional dependencies. If you encounter ProGuard warnings, consider adding the following "-dontwarn" directives to your ProGuard configuration file:

```
-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn com.squareup.okhttp.**
-dontwarn com.google.appengine.**
-dontwarn javax.servlet.**
```

**IMPORTANT: If you are running version 2.0.x before 2.0.3, you should update to the latest Dropbox SDK version to avoid a deserialization bug that can cause Android apps that use ProGuard to crash.**
