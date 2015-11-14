# Dropbox Core SDK for Java 6+

A Java library to access [Dropbox's HTTP-based Core API v2](https://www.dropbox.com/developers/documentation/http#documentation).  This SDK also supports the older [Core API v1](https://www.dropbox.com/developers-v1/core/docs), but that support will be removed at some point.

License: [MIT](License.txt)

[Javadoc.](http://dropbox.github.io/dropbox-sdk-java/api-docs/v2.0.x/)

## Setup

If you're using Maven, then edit your project's "pom.xml" and add this to the `<dependencies>` section:

```xml
<dependency>
    <groupId>com.dropbox.core</groupId>
    <artifactId>dropbox-core-sdk</artifactId>
    <version>2.0-beta-2</version>
</dependency>
```

If you aren't using Maven, here are the JARs you need:
- [Dropbox Core SDK 2.0-beta-2](https://oss.sonatype.org/content/repositories/releases/com/dropbox/core/dropbox-core-sdk/2.0-beta-2/dropbox-core-sdk-2.0-beta-2.jar)
- [Jackson Core 2.6.1](https://oss.sonatype.org/content/repositories/releases/com/fasterxml/jackson/core/jackson-core/2.6.1/jackson-core-2.6.1.jar) (JSON parser)

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
  * Example for a simple web app: [Web File Browser example](examples/web-file-browser/src/com/dropbox/core/examples/web_file_browser/DropboxAuth.java)
  * Example for an Android app: [Android example](examples/android/src/main/java/com/dropbox/core/examples/android/UserActivity.java)
  * Example for a command-line tool: [Command-Line Authorization example](examples/authorize/src/com/dropbox/core/examples/authorize/Main.java)

Once you have an access token, create a [`DbxClientV2`](https://dropbox.github.io/dropbox-sdk-java/api-docs/v2.0.x/com/dropbox/core/v2/DbxClientV2.html) and start making API calls.

You only need to perform the authorization process once per user.  Once you have an access token for a user, save it somewhere persistent, like in a database.  The next time that user visits your app's, you can skip the authorization process and go straight to creating a `DbxClientV2` and making API calls.

## Running the examples

Prerequisites: Apache Maven

1. Download this repository.
2. Save your Dropbox API key in a file called "test.app".  See: [Get a Dropbox API key](#get-a-dropbox-api-key), above.
3. `mvn install`
4. To compile all the examples: `mvn -f examples/pom.xml compile`
5. To compile just one example: `mvn -f examples/<example-name>/pom.xml compile`.

### authorize

This examples runs through the OAuth 2 authorization flow.

```
cd examples
./run authorize test.app test.auth
```

This produces a file named "test.auth" that has the access token.  This file can be passed in to the other examples.

### account-info

A trivial example that calls the /account/info API endpoint.

```
cd examples
./run account-info test.auth
```

(You must first generate "test.auth" using the "authorize" example above.)

### upload-file

Uploads a file to Dropbox.

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

## Running the tests

1. Run through the `authorize` example above to get a "test.auth" file.
2. `./run-tests <path-to-test.auth>`

Run `./run-tests` with no arguments to see how to run individual tests.

## Running the benchmarks

1. `mvn test-compile`
2. `./run-bench <fully-qualified-benchmark-class>`

For example: `./run-bench com.dropbox.core.json.JsonDateReaderBench.ParseDropboxDate`

## Running the Checker Framework static analysis

`mvn checker:check`

## Loading the project in IntelliJ 14

Assume "{sdk}" represents the top-level folder of this SDK.

1. Click *Import Project*, select "{sdk}/pom.xml".
2. You'll see the *Import Project From Maven* dialog.
   - Check *Search for projects recursively*
   - Check *Keep project files in*, set it to "{sdk}/intellij"
   - Check *Import Maven projects automatically*
   - Uncheck *Use Maven output directories*
   - Click *Next*
3. Clicking *Next* on the rest of the dialogs.
4. On the last dialog, you can change *Project name* if you want **but make sure** you set *Project file location* back to "{sdk}/intellij".

## FAQ

### When I use the bundle JAR with some OSGi containers within an OSGi subsystem, I get a "Missing required capability" error.

The JAR's manifest has the following line:

```
Require-Capability: osgi.ee;filter="(&(osgi.ee=JavaSE)(version=1.6))"
```

OSGi containers running on Java 1.6 or above should provide this capability.  Unfortunately, some OSGi containers don't do this correctly and will reject the bundle JAR in the OSGi subsystem context.

As a workaround, you can build your own version of the JAR that omits the "osgi.ee" capability by running:

```
mvn clean
mvn package -Dosgi.bnd.noee=true
```

(This is equivalent to passing the "-noee" option to the OSGi "bnd" tool.)

Another workaround is to tell your OSGi container to provide that requirement: [StackOverflow answer](http://stackoverflow.com/a/24673359/163832).
