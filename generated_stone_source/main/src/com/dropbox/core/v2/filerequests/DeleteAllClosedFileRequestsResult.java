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

/**
 * Result for {@link DbxUserFileRequestsRequests#deleteAllClosed}.
 */
public class DeleteAllClosedFileRequestsResult {
    // struct file_requests.DeleteAllClosedFileRequestsResult (file_requests.stone)

    protected final List<FileRequest> fileRequests;

    /**
     * Result for {@link DbxUserFileRequestsRequests#deleteAllClosed}.
     *
     * @param fileRequests  The file requests deleted for this user. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteAllClosedFileRequestsResult(List<FileRequest> fileRequests) {
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
     * The file requests deleted for this user.
     *
     * @return value for this field, never {@code null}.
     */
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
            DeleteAllClosedFileRequestsResult other = (DeleteAllClosedFileRequestsResult) obj;
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
    static class Serializer extends StructSerializer<DeleteAllClosedFileRequestsResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteAllClosedFileRequestsResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
        public DeleteAllClosedFileRequestsResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeleteAllClosedFileRequestsResult value;
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
                value = new DeleteAllClosedFileRequestsResult(f_fileRequests);
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
