package com.dropbox.core;

/*>>> import checkers.nullness.quals.Nullable; */

public class DbxSdkVersion
{
    public static final String Version;
    static {
        Version = loadVersion();
    }

    // TODO: Pass this version from Gradle
    private static String loadVersion()
    {
        return "5.0.0-SNAPSHOT";
    }
}
