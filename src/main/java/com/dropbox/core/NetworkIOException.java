package com.dropbox.core;

import java.io.IOException;

/**
 * This gets thrown when there's an {@link IOException} when reading or writing to the
 * network (when communicating with the Dropbox API servers).
 *
 * <p> We use a separate exception class (instead of just relaying {@code IOException}) to make it
 * easier for you to distinguish between I/O errors communicating with Dropbox and I/O errors from
 * your own code.  </p>
 */
public class NetworkIOException extends DbxException {
    private static final long serialVersionUID = 0L;

    public NetworkIOException(IOException cause) {
        super(cause.getMessage(), cause);
    }

    @Override
    public IOException getCause() {
        // guaranteed to be an IOException
        return (IOException) super.getCause();
    }
}

