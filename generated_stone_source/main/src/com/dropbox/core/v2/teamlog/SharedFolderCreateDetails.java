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
 * Created shared folder.
 */
public class SharedFolderCreateDetails {
    // struct team_log.SharedFolderCreateDetails (team_log_generated.stone)

    protected final String targetNsId;

    /**
     * Created shared folder.
     *
     * @param targetNsId  Target namespace ID.
     */
    public SharedFolderCreateDetails(String targetNsId) {
        this.targetNsId = targetNsId;
    }

    /**
     * Created shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedFolderCreateDetails() {
        this(null);
    }

    /**
     * Target namespace ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getTargetNsId() {
        return targetNsId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            targetNsId
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
            SharedFolderCreateDetails other = (SharedFolderCreateDetails) obj;
            return (this.targetNsId == other.targetNsId) || (this.targetNsId != null && this.targetNsId.equals(other.targetNsId));
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
    static class Serializer extends StructSerializer<SharedFolderCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderCreateDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.targetNsId != null) {
                g.writeFieldName("target_ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.targetNsId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedFolderCreateDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFolderCreateDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_targetNsId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("target_ns_id".equals(field)) {
                        f_targetNsId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedFolderCreateDetails(f_targetNsId);
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
