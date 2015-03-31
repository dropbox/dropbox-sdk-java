package com.dropbox.core;

import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class DbxSdkVersion
{
    public static final String Version;
    static {
        Version = loadVersion();
    }

    private static String loadVersion()
    {
        String version;
        InputStream in = DbxSdkVersion.class.getResourceAsStream("sdk-version.txt");
        try {
            if (in == null) throw new AssertionError("Not found.");
            try {
                BufferedReader bin = new BufferedReader(new InputStreamReader(in, StringUtil.UTF8));
                version = bin.readLine();
                if (version == null) throw new AssertionError("No lines.");
                String secondLine = bin.readLine();
                if (secondLine != null) throw new AssertionError("Found more than one line.  Second line: " + StringUtil.jq(secondLine));
            }
            finally {
                IOUtil.closeInput(in);
            }

            Pattern versionRegex = Pattern.compile("[0-9]+(?:\\.[0-9]+)*(?:-[-_A-Za-z0-9]+)");
            if (!versionRegex.matcher(version).matches()) {
                throw new AssertionError("Text doesn't follow expected pattern: " + StringUtil.jq(version));
            }

        }
        catch (IOException ex) {
            throw new AssertionError("Error loading version from resource \"sdk-version.txt\": " + ex.getMessage());
        }

        return version;
    }
}
