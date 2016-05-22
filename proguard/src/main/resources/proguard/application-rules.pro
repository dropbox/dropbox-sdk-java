-keep class com.dropbox.core.test.proguard.Main { *** main(...); }
-keepattributes SourceFile,LineNumberTable

-dontwarn com.squareup.okhttp.**
-dontwarn com.dropbox**.android.**
-dontwarn org.testng.**
-dontwarn bsh.**
