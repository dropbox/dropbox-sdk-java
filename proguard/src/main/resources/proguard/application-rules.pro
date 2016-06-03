-keep class com.dropbox.core.test.proguard.Main { *** main(...); }
-keepattributes SourceFile,LineNumberTable

-dontwarn okhttp3.**
-dontwarn com.squareup.okhttp.**
-dontwarn com.google.appengine.**
-dontwarn com.dropbox**.android.**
-dontwarn org.testng.**
-dontwarn bsh.**
