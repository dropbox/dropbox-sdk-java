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
 * Result for {@link DbxUserFileRequestsRequests#list}.
 */
public class ListFileRequestsResult {
    // struct file_requests.ListFileRequestsResult (file_requests.stone)

    @Nonnull
    protected final List<FileRequest> fileRequests;

    /**
     * Result for {@link DbxUserFileRequestsRequests#list}.
     *
     * @param fileRequests  The file requests owned by this user. Apps with the
     *     app folder permission will only see file requests in their app
     *     folder. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileRequestsResult(@Nonnull List<FileRequest> fileRequests) {
        if (fileRequests == null) {
            throw new IllegalArgumentException("Required value for 'fileRequests' is null");
        }
        for (FileRequest x : fileRequests) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'fileRequests' is null");
            }
        }
        this.fileRequests = fileRequests;
    }

    /**
     * The file requests owned by this user. Apps with the app folder permission
     * will only see file requests in their app folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<FileRequest> getFileRequests() {
        return fileRequests;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            fileRequests
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
            ListFileRequestsResult other = (ListFileRequestsResult) obj;
            return (this.fileRequests == other.fileRequests) || (this.fileRequests.equals(other.fileRequests));
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
    static class Serializer extends StructSerializer<ListFileRequestsResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileRequestsResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file_requests");
            StoneSerializers.list(FileRequest.Serializer.INSTANCE).serialize(value.fileRequests, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFileRequestsResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileRequestsResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<FileRequest> f_fileRequests = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file_requests".equals(field)) {
                        f_fileRequests = StoneSerializers.list(FileRequest.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_fileRequests == null) {
                    throw new JsonParseException(p, "Required field \"file_requests\" missing.");
                }
                value = new ListFileRequestsResult(f_fileRequests);
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
