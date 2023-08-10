package com.dropbox.core;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;

import com.dropbox.core.stone.StoneSerializer;

final class ApiErrorResponse<T> {
    private final T error;
    private LocalizedText userMessage;

    public ApiErrorResponse(T error, LocalizedText userMessage) {
        if (error == null) {
            throw new NullPointerException("error");
        }
        this.error = error;
        this.userMessage = userMessage;
    }

    public T getError() {
        return error;
    }

    public LocalizedText getUserMessage() {
        return userMessage;
    }

    /**
     * For internal use only.
     */
    static final class Serializer<T> extends StoneSerializer<ApiErrorResponse<T>> {
        private StoneSerializer<T> errSerializer;

        public Serializer(StoneSerializer<T> errSerializer) {
            this.errSerializer = errSerializer;
        }

        @Override
        public void serialize(ApiErrorResponse<T> value, JsonGenerator g) throws IOException, JsonGenerationException {
            throw new UnsupportedOperationException("Error wrapper serialization not supported.");
        }

        @Override
        public ApiErrorResponse<T> deserialize(JsonParser p) throws IOException, JsonParseException {
            T error = null;
            LocalizedText userMessage = null;

            expectStartObject(p);
            while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String field = p.getCurrentName();
                p.nextToken();
                if ("error".equals(field)) {
                    error = errSerializer.deserialize(p);
                } else if ("user_message".equals(field)) {
                    userMessage = LocalizedText.STONE_SERIALIZER.deserialize(p);
                } else {
                    skipValue(p);
                }
            }
            if (error == null) {
                throw new JsonParseException(p, "Required field \"error\" missing.");
            }

            ApiErrorResponse<T> value = new ApiErrorResponse<T>(error, userMessage);
            expectEndObject(p);

            return value;
        }
    }
}

