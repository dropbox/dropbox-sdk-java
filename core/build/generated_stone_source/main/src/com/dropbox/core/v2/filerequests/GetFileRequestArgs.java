/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

/**
 * Arguments for {@link DbxUserFileRequestsRequests#get(String)}.
 */
class GetFileRequestArgs {
    // struct file_requests.GetFileRequestArgs (file_requests.stone)

    protected final String id;

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#get(String)}.
     *
     * @param id  The ID of the file request to retrieve. Must have length of at
     *     least 1, match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetFileRequestArgs(@Nonnull String id) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z]+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
    }

    /**
     * The ID of the file request to retrieve.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GetFileRequestArgs other = (GetFileRequestArgs) obj;
            return (this.id == other.id) || (this.id.equals(other.id));
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<GetFileRequestArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetFileRequestArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetFileRequestArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetFileRequestArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                value = new GetFileRequestArgs(f_id);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
