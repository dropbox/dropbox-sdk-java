/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link UnshareFolderError}
 * error.
 */
public class UnshareFolderErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#unshareFolder(String,boolean)}.
     */
    public final UnshareFolderError errorValue;

    public UnshareFolderErrorException(String requestId, LocalizedText userMessage, UnshareFolderError errorValue) {
        super(requestId, userMessage, buildMessage("unshare_folder", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
