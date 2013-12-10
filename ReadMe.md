# Dropbox Core SDK for Java 6+

A Java library to access [Dropbox's HTTP-based Core API](https://www.dropbox.com/developers/core/docs).

License: [MIT](License.txt)

This is for web applications.  If you want to use Dropbox's API from Android, try the [Sync SDK](https://www.dropbox.com/developers/sync)

[Javadoc.](http://dropbox.github.io/dropbox-sdk-java/api-docs/v1.7.x/)

## Setup

If you're using Maven, then edit your project's "pom.xml" and add this to the `<dependencies>` section:

```xml
<dependency>
    <groupId>com.dropbox.core</groupId>
    <artifactId>dropbox-core-sdk</artifactId>
    <version>[1.7,1.8)</version>
</dependency>
```

If you aren't using Maven, here are the JARs you need:
- [Dropbox Core SDK](http://repo1.maven.org/maven2/com/dropbox/core/dropbox-core-sdk/1.7.6/dropbox-core-sdk-1.7.6.jar)
- [Jackson Core](http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.2.3/jackson-core-2.2.3.jar) (JSON parser)

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

  * Authorization example for a simple web app: [Web File Browser example](examples/web-file-browser/src/com/dropbox/core/examples/web_file_browser/DropboxAuth.java)
  * Authorization example for a command-line tool: [Command-Line Authorization example](examples/authorize/src/com/dropbox/core/examples/authorize/Main.java)

Once you have an access token, create a [`DbxClient`](http://dropbox.github.io/dropbox-sdk-java/api-docs/v1.7.x/com/dropbox/core/DbxClient.html) and start making API calls.

You only need to perform the authorization process once per user.  Once you have an access token for a user, save it somewhere persistent, like in a database.  The next time that user visits your app's, you can skip the authorization process and go straight to creating a `DbxClient` and making API calls.

## Running the examples

Prerequisites: Apache Maven

1. Download this repository.
2. Save your Dropbox API key in a file called "test.app".  See: [Get a Dropbox API key](#get-a-dropbox-api-key), above.
3. `mvn install`
4. `mvn -f examples/pom.xml compile`

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
