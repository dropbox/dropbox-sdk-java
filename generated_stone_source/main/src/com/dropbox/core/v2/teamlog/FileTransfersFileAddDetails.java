/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Transfer files added.
 */
public class FileTransfersFileAddDetails {
    // struct team_log.FileTransfersFileAddDetails (team_log_generated.stone)

    protected final String fileTransferId;

    /**
     * Transfer files added.
     *
     * @param fileTransferId  Transfer id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileTransfersFileAddDetails(String fileTransferId) {
        if (fileTransferId == null) {
            throw new IllegalArgumentException("Required value for 'fileTransferId' is null");
        }
        this.fileTransferId = fileTransferId;
    }

    /**
     * Transfer id.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFileTransferId() {
        return fileTransferId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            fileTransferId
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
            FileTransfersFileAddDetails other = (FileTransfersFileAddDetails) obj;
            return (this.fileTransferId == other.fileTransferId) || (this.fileTransferId.equals(other.fileTransferId));
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
    static class Serializer extends StructSerializer<FileTransfersFileAddDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileTransfersFileAddDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file_transfer_id");
            StoneSerializers.string().serialize(value.fileTransferId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileTransfersFileAddDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileTransfersFileAddDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_fileTransferId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file_transfer_id".equals(field)) {
                        f_fileTransferId = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_fileTransferId == null) {
                    throw new JsonParseException(p, "Required field \"file_transfer_id\" missing.");
                }
                value = new FileTransfersFileAddDetails(f_fileTransferId);
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
