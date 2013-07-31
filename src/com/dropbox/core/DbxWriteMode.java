package com.dropbox.core;

/**
 * Describes how a file should be saved when it is written to Dropbox.  Do not call
 * the constructor.  Instead, call one of the three static functions: {@link #add},
 * {@link #force}, {@link #update}.
 */
public final class DbxWriteMode
{
    // NOTE: The current implementation just holds the URL parameters that we pass
    // to /files_put.  If the upload mode becomes used in other calls, we may need
    // to switch the implementation over to be less tied to that specific endpoint.
    final String[] params;
    DbxWriteMode(String... params)
    {
        this.params = params;
    }

    /**
     * Returns a {@link DbxWriteMode} for adding new file.  If a file at the specified path
     * already exists, the new file will be renamed automatically.
     *
     * <p>
     * For example, if you're trying to upload a file to "/Hello.txt", but there's already
     * something there, your file will be written to "/Notes/Groceries (1).txt".
     * </p>
     *
     * <p>
     * You can determine whether your file was renamed by checking the {@link DbxEntry#name}
     * returned by the API call.
     * </p>
     */
    public static DbxWriteMode add() { return AddInstance; }
    private static final DbxWriteMode AddInstance = new DbxWriteMode("overwrite", "false");

    /**
     * Returns a {@link DbxWriteMode} for forcing a file to be at a certain path.
     * If there's already a file at that path, the existing file will be overwritten.
     * If there's a folder at that path, however, it will not be overwritten and the
     * API call will fail.
     */
    public static DbxWriteMode force() { return ForceInstance; }
    private static final DbxWriteMode ForceInstance = new DbxWriteMode("overwrite", "true");

    /**
     * Returns a {@link DbxWriteMode} for updating an existing file.  This is useful
     * for when you have downloaded a file and made modifications and want to save
     * your modifications back to Dropbox.  You need to specify the revision of the
     * copy of the file you downloaded (it's in {@link DbxEntry.File#rev}).
     *
     * <p>
     * If, when you attempt to save, the revision of the file currently on Dropbox
     * matches {@code revisionToReplace}, the file on Dropbox will be overwritten with
     * the new contents you provide.
     * </p>
     *
     * <p>
     * If the rev of the file currently on Dropbox doesn't match {@code revisionToReplace},
     * Dropbox leave the original file alone and save your contents to a new file.  For example,
     * if the original file path is {@literal "/Notes/Groceries.txt"}, the new file's path might
     * be {@literal "/Notes/Groceries (conflicted copy).txt"}.
     * </p>
     *
     * <p>
     * You can determine whether your file was renamed by checking the {@link DbxEntry#name}
     * returned by the API call.
     * </p>
     */
    public static DbxWriteMode update(String revisionToReplace)
    {
        return new DbxWriteMode("parent_rev", revisionToReplace);
    }
}
