package com.dropbox.core;

import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/*>>> import checkers.nullness.quals.Nullable; */

public class DbxSdkVersion
{
    public static final String Version;
    static {
        Version = loadVersion();
    }

    private static final String ResourceName = "sdk-version.txt";

    private static final class LoadException extends Exception
    {
        public LoadException(/*@Nullable*/String message)
        {
            super(message);
        }
    }

    private static String loadLineFromResource()
        throws LoadException
    {
        try {
            InputStream in = DbxSdkVersion.class.getResourceAsStream(ResourceName);
            if (in == null) throw new LoadException("Not found.");
            try {
                BufferedReader bin = new BufferedReader(new InputStreamReader(in, StringUtil.UTF8));
                String version = bin.readLine();
                if (version == null) throw new LoadException("No lines.");
                String secondLine = bin.readLine();
                if (secondLine != null) throw new LoadException("Found more than one line.  Second line: " + StringUtil.jq(secondLine));
                return version;
            }
            finally {
                IOUtil.closeInput(in);
            }
        }
        catch (IOException ex) {
            throw new LoadException(ex.getMessage());
        }
    }

    private static String loadVersion()
    {
        try {
            String version = loadLineFromResource();

            Pattern versionRegex = Pattern.compile("[0-9]+(?:\\.[0-9]+)*(?:-[-_A-Za-z0-9]+)?");
            if (!versionRegex.matcher(version).matches()) {
                throw new LoadException("Text doesn't follow expected pattern: " + StringUtil.jq(version));
            }

            return version;
        }
        catch (LoadException ex) {
            throw new RuntimeException("Error loading version from resource \"sdk-version.txt\": " + ex.getMessage());
        }
    }
}
