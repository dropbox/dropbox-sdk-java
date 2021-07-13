# Dropbox Android Example

This is a sample app to show you how to integrate an Android app with the Dropbox Java SDK.a


## Getting Started

1. Create your app in the drobpox console or whatever
2. Add the dependency to your build.gradle
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


## Authenticating users
To allow your users to link their Dropbox accounts with your app, complete the following.

1. Launch the Dropbox OAuth process like so. This will either open the Dropbox Android app if installed,or dropbox.com in the default browser app. List of scopes is here.
```
        val clientIdentifier = "<your client name>/<your client version>"
        val requestConfig = DbxRequestConfig(clientIdentifier)
        val scopes = listOf("account_info.read", "files.content.write")
        Auth.startOAuth2PKCE(this, "YOUR_APP_KEY", requestConfig, scopes)
```
2. When the user comes back to your app and they have successfully linked their Dropbox to your app you will have access to `Auth.getDbxCredential()` which will provide you with the DbxCredential you will use for future requests.to

## Making requests


## Refreshing Tokens

When the access token has expired we will get a 401 response.

When authenticating through the Dropbox Java SDK you will get back a `DbxCredential`. This credential consists of a short lived `accessToken` and a long lived `refreshToken`.
The `accessToken` is short lived and will eventually expire. We can refresh this short lived access token by calling the server and exchanging a refresh token for an access token when the access token has expired.
This allows clients to continue to have a valid access token without further interaction with the user. This is useful for mobile clients that need to do periodic background work without having to force the user to manually re-authenticate.

When making requests the Dropbox Java SDK will refresh the token if needed before making the request (See `refreshAccessTokenIfNeeded()` in `DbxRawClientV2`).
To manually refresh tokens in the Dropbox Java SDK, call `DbxClientV2.refreshAccessToken()`. This makes an API call to `/oauth2/token` with your refresh token and a grant-type of `refresh_token`. The endpoint returns a new short lived access token and expiration time.



## Frequently Asked Questions

How long before short lived `accessToken`s expire?

When refreshAccessToken is called do we need to recreate the DbxClientV2? Or is it getting updated itself?
What about the access token we're storing in sharedPreferences?

It seems the SDK is refreshing the tokens for us, but we aren't updating them in the SharedPreferences.