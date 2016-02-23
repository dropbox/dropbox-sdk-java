/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link TransferFolderError}
 * error.
 */
public class TransferFolderErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#transferFolder(String,String)}.
     */
    public final TransferFolderError errorValue;

    public TransferFolderErrorException(String requestId, LocalizedText userMessage, TransferFolderError errorValue) {
        super(requestId, userMessage, buildMessage("transfer_folder", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
