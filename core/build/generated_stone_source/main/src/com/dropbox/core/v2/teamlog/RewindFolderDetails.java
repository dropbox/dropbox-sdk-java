/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;

/**
 * Rewound a folder.
 */
public class RewindFolderDetails {
    // struct team_log.RewindFolderDetails (team_log_generated.stone)

    @Nonnull
    protected final Date rewindFolderTargetTsMs;

    /**
     * Rewound a folder.
     *
     * @param rewindFolderTargetTsMs  Folder was Rewound to this date. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RewindFolderDetails(@Nonnull Date rewindFolderTargetTsMs) {
        if (rewindFolderTargetTsMs == null) {
            throw new IllegalArgumentException("Required value for 'rewindFolderTargetTsMs' is null");
        }
        this.rewindFolderTargetTsMs = LangUtil.truncateMillis(rewindFolderTargetTsMs);
    }

    /**
     * Folder was Rewound to this date.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Date getRewindFolderTargetTsMs() {
        return rewindFolderTargetTsMs;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            rewindFolderTargetTsMs
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
            RewindFolderDetails other = (RewindFolderDetails) obj;
            return (this.rewindFolderTargetTsMs == other.rewindFolderTargetTsMs) || (this.rewindFolderTargetTsMs.equals(other.rewindFolderTargetTsMs));
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
    static class Serializer extends StructSerializer<RewindFolderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RewindFolderDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("rewind_folder_target_ts_ms");
            StoneSerializers.timestamp().serialize(value.rewindFolderTargetTsMs, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RewindFolderDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RewindFolderDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_rewindFolderTargetTsMs = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("rewind_folder_target_ts_ms".equals(field)) {
                        f_rewindFolderTargetTsMs = StoneSerializers.timestamp().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_rewindFolderTargetTsMs == null) {
                    throw new JsonParseException(p, "Required field \"rewind_folder_target_ts_ms\" missing.");
                }
                value = new RewindFolderDetails(f_rewindFolderTargetTsMs);
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
