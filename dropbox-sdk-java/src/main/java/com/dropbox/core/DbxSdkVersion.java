package com.dropbox.core;

/*>>> import checkers.nullness.quals.Nullable; */

public class DbxSdkVersion
{
    public static final String Version;
    static {
        Version = loadVersion();
    }

    // https://github.com/dropbox/dropbox-sdk-java/issues/357
    private static String loadVersion()
    {
        return "5.3.1-SNAPSHOT";
    }
}
