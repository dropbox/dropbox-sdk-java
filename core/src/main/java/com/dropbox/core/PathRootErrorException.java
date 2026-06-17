package com.dropbox.core;

import com.dropbox.core.v2.common.PathRootError;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Gets thrown when an invalid path rood is supplied.
 */
public class PathRootErrorException extends DbxException {
    private static final long serialVersionUID = 0;

    private final @Nonnull PathRootError pathRootError;

    public @Nonnull PathRootError getPathRootError() {
        return pathRootError;
    }

    public PathRootErrorException(@Nullable String requestId,
                                  @Nullable String message,
                                  @Nonnull PathRootError pathRootError) {
        super(requestId, message);
        this.pathRootError = pathRootError;
    }
}
