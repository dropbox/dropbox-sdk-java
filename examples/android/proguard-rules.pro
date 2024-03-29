# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in $ANDROID_SDK/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# OkHttp and Servlet optional dependencies

-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn com.squareup.okhttp.**
-dontwarn com.google.apphosting.**
-dontwarn com.google.appengine.**
-dontwarn com.google.protos.cloud.sql.**
-dontwarn com.google.cloud.sql.**
-dontwarn javax.activation.**
-dontwarn jakarta.mail.**
-dontwarn jakarta.servlet.**
-dontwarn org.apache.**

# Support classes for compatibility with older API versions

-dontwarn android.support.**
-dontnote android.support.**

