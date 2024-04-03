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

import javax.annotation.Nonnull;

/**
 * Completed ransomware restore process.
 */
public class RansomwareRestoreProcessCompletedDetails {
    // struct team_log.RansomwareRestoreProcessCompletedDetails (team_log_generated.stone)

    @Nonnull
    protected final String status;
    protected final long restoredFilesCount;
    protected final long restoredFilesFailedCount;

    /**
     * Completed ransomware restore process.
     *
     * @param status  The status of the restore process. Must not be {@code
     *     null}.
     * @param restoredFilesCount  Restored files count.
     * @param restoredFilesFailedCount  Restored files failed count.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RansomwareRestoreProcessCompletedDetails(@Nonnull String status, long restoredFilesCount, long restoredFilesFailedCount) {
        if (status == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = status;
        this.restoredFilesCount = restoredFilesCount;
        this.restoredFilesFailedCount = restoredFilesFailedCount;
    }

    /**
     * The status of the restore process.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getStatus() {
        return status;
    }

    /**
     * Restored files count.
     *
     * @return value for this field.
     */
    public long getRestoredFilesCount() {
        return restoredFilesCount;
    }

    /**
     * Restored files failed count.
     *
     * @return value for this field.
     */
    public long getRestoredFilesFailedCount() {
        return restoredFilesFailedCount;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.status,
            this.restoredFilesCount,
            this.restoredFilesFailedCount
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
            RansomwareRestoreProcessCompletedDetails other = (RansomwareRestoreProcessCompletedDetails) obj;
            return ((this.status == other.status) || (this.status.equals(other.status)))
                && (this.restoredFilesCount == other.restoredFilesCount)
                && (this.restoredFilesFailedCount == other.restoredFilesFailedCount)
                ;
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
    static class Serializer extends StructSerializer<RansomwareRestoreProcessCompletedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RansomwareRestoreProcessCompletedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("status");
            StoneSerializers.string().serialize(value.status, g);
            g.writeFieldName("restored_files_count");
            StoneSerializers.int64().serialize(value.restoredFilesCount, g);
            g.writeFieldName("restored_files_failed_count");
            StoneSerializers.int64().serialize(value.restoredFilesFailedCount, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RansomwareRestoreProcessCompletedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RansomwareRestoreProcessCompletedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_status = null;
                Long f_restoredFilesCount = null;
                Long f_restoredFilesFailedCount = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("status".equals(field)) {
                        f_status = StoneSerializers.string().deserialize(p);
                    }
                    else if ("restored_files_count".equals(field)) {
                        f_restoredFilesCount = StoneSerializers.int64().deserialize(p);
                    }
                    else if ("restored_files_failed_count".equals(field)) {
                        f_restoredFilesFailedCount = StoneSerializers.int64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_status == null) {
                    throw new JsonParseException(p, "Required field \"status\" missing.");
                }
                if (f_restoredFilesCount == null) {
                    throw new JsonParseException(p, "Required field \"restored_files_count\" missing.");
                }
                if (f_restoredFilesFailedCount == null) {
                    throw new JsonParseException(p, "Required field \"restored_files_failed_count\" missing.");
                }
                value = new RansomwareRestoreProcessCompletedDetails(f_status, f_restoredFilesCount, f_restoredFilesFailedCount);
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
