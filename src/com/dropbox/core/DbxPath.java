package com.dropbox.core;

import static com.dropbox.core.util.StringUtil.jq;

/**
 * Utility functions for working with Dropbox paths.  This SDK uses {@code String}s
 * to represent paths.
 *
 * <p>
 * Dropbox paths always start with with a slash ({@code "/"}).
 * For full-Dropbox apps, the path is relative to the
 * root of the user's Dropbox.  For App Folder apps,
 * the path is relative to the App Folder.
 * </p>
 */
public class DbxPath
{
    public static boolean isValid(String path)
    {
        String error = findError(path);
        return (error == null);
    }

    public static String findError(String path)
    {
        if (!path.startsWith("/")) return "must start with \"/\"";
        if (path.length() == 1) return null;  // Special case for "/"

        if (path.endsWith("/")) return "must not end with \"/\"";

        // TODO: More checks.
        // - No trailing white space in any path component.
        // - No extended unicode.
        // - Even more checks.

        return null;
    }

    public static void checkArg(String argName, String value)
    {
        if (value == null) {
            throw new IllegalArgumentException("'" + argName + "' should not be null");
        }
        String error = findError(value);
        if (error != null) {
            throw new IllegalArgumentException("'" + argName + "': bad path: " + error + ": " + jq(value));
        }
    }

    public static void checkArgNonRoot(String argName, String value)
    {
        if ("/".equals(value)) {
            throw new IllegalArgumentException("'" + argName + "' should not be the root path (\"/\")");
        }
        checkArg(argName, value);
    }

    /**
     * Returns just the last component of the path.
     * <ul>
     *     <li>{@code getName("/")} &rarr; {@code "/"}</li>
     *     <li>{@code getName("/Photos")} &rarr; {@code "Photos"}</li>
     *     <li>{@code getName("/Photos/Home.jpeg")} &rarr; {@code "Home.jpeg"}</li>
     * </ul>
     */
    public static String getName(String path)
    {
        if (path == null) throw new IllegalArgumentException("'path' can't be null");
        if (!path.startsWith("/")) throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + path + "\"");
        if (path.length() > 1 && path.endsWith("/")) throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + path + "\"");

        int start = path.length() - 1;
        while (path.charAt(start) != '/') {
            start--;
        }
        return path.substring(start+1);
    }

    public static String[] split(String path)
    {
        if (path == null) throw new IllegalArgumentException("'path' can't be null");
        if (!path.startsWith("/")) throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + path + "\"");
        if (path.length() > 1 && path.endsWith("/")) throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + path + "\"");

        if (path.length() == 1) return new String[0];
        return path.substring(1).split("/");
    }

    /**
     * Returns the parent path of the given path or {@code null} if the path
     * is {@code "/"}.
     * <ul>
     *     <li>{@code getParent("/")} &rarr; {@code null}</li>
     *     <li>{@code getParent("/Photos")} &rarr; {@code "/"}</li>
     *     <li>{@code getParent("/Photos/Recent/Home.jpeg")} &rarr; {@code "/Photos/Recent"}</li>
     * </ul>
     */
    public static String getParent(String path)
    {
        if (path == null) throw new IllegalArgumentException("'path' can't be null");
        if (!path.startsWith("/")) throw new IllegalArgumentException("Not a valid path.  Doesn't start with a \"/\": \"" + path + "\"");
        if (path.length() > 1 && path.endsWith("/")) throw new IllegalArgumentException("Not a valid path.  Ends with a \"/\": \"" + path + "\"");

        int lastSlash = path.lastIndexOf("/");
        if (path.length() == 1) return null;  // "/" has no parent

        if (lastSlash == 0) return "/";

        return path.substring(0, lastSlash);
    }
}
