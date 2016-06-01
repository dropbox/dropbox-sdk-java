package com.dropbox.core;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;

import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.http.HttpRequestor;

/**
 * For internal use only.
 */
public final class DbxWrappedException extends Exception {
    private static final long serialVersionUID = 0L;

    private final Object errValue;  // Really an ErrT instance, but Throwable does not allow generic subclasses.
    private final String requestId;
    private final LocalizedText userMessage;

    public DbxWrappedException(Object errValue, String requestId, LocalizedText userMessage) {
        this.errValue = errValue;
        this.requestId = requestId;
        this.userMessage = userMessage;
    }

    public Object getErrorValue() {
        return errValue;
    }

    public String getRequestId() {
        return requestId;
    }

    public LocalizedText getUserMessage() {
        return userMessage;
    }

    public static <T> DbxWrappedException fromResponse(StoneSerializer<T> errSerializer, HttpRequestor.Response response)
        throws IOException, JsonParseException {
        String requestId = DbxRequestUtil.getRequestId(response);

        ApiErrorResponse<T> apiResponse = new ApiErrorResponse.Serializer<T>(errSerializer)
            .deserialize(response.getBody());

        return new DbxWrappedException(apiResponse.getError(), requestId, apiResponse.getUserMessage());
    }
}
