package com.dropbox.core;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.security.cert.CertPathValidatorException;

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
        super(computeMessage(cause), cause);
    }

    private static String computeMessage(IOException ex) {
        String message = ex.getMessage();

        // For CertPathValidationErrors, the CertPath is in the exception object but not
        // in the exception message.  Pull it out into the message, because it would be
        // useful for debugging.
        if (ex instanceof SSLHandshakeException) {
            Throwable innerCause = ex.getCause();
            if (innerCause instanceof CertPathValidatorException) {
                CertPathValidatorException cpve = (CertPathValidatorException) innerCause;
                message += "[CERT PATH: " + cpve.getCertPath() + "]";
            }
        }

        return message;
    }

    @Override
    public IOException getCause() {
        // guaranteed to be an IOException
        return (IOException) super.getCause();
    }
}

