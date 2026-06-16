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
import java.util.List;

import javax.annotation.Nonnull;

/**
 * Arguments for {@link DbxUserFileRequestsRequests#delete(List)}.
 */
class DeleteFileRequestArgs {
    // struct file_requests.DeleteFileRequestArgs (file_requests.stone)

    @Nonnull
    protected final List<String> ids;

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#delete(List)}.
     *
     * @param ids  List IDs of the file requests to delete. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteFileRequestArgs(@Nonnull List<String> ids) {
        if (ids == null) {
            throw new IllegalArgumentException("Required value for 'ids' is null");
        }
        for (String x : ids) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'ids' is null");
            }
            if (x.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'ids' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z]+", x)) {
                throw new IllegalArgumentException("Stringan item in list 'ids' does not match pattern");
            }
        }
        this.ids = ids;
    }

    /**
     * List IDs of the file requests to delete.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getIds() {
        return ids;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.ids
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
            DeleteFileRequestArgs other = (DeleteFileRequestArgs) obj;
            return (this.ids == other.ids) || (this.ids.equals(other.ids));
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
    static class Serializer extends StructSerializer<DeleteFileRequestArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteFileRequestArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.ids, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeleteFileRequestArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeleteFileRequestArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_ids = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("ids".equals(field)) {
                        f_ids = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_ids == null) {
                    throw new JsonParseException(p, "Required field \"ids\" missing.");
                }
                value = new DeleteFileRequestArgs(f_ids);
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
