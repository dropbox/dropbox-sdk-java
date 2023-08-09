package com.dropbox.core;

import com.dropbox.core.v2.common.PathRootError;

/**
 * Gets thrown when an invalid path rood is supplied.
 */
public class PathRootErrorException extends DbxException {
    private static final long serialVersionUID = 0;

    private final PathRootError pathRootError;

    public PathRootError getPathRootError() {
        return pathRootError;
    }

    public PathRootErrorException(String requestId, String message, PathRootError pathRootError) {
        super(requestId, message);
        this.pathRootError = pathRootError;
    }
}
