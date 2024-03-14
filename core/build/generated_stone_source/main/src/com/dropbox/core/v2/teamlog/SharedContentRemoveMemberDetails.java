/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.sharing.AccessLevel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Removed user/group from shared file/folder.
 */
public class SharedContentRemoveMemberDetails {
    // struct team_log.SharedContentRemoveMemberDetails (team_log_generated.stone)

    protected final AccessLevel sharedContentAccessLevel;

    /**
     * Removed user/group from shared file/folder.
     *
     * @param sharedContentAccessLevel  Shared content access level.
     */
    public SharedContentRemoveMemberDetails(AccessLevel sharedContentAccessLevel) {
        this.sharedContentAccessLevel = sharedContentAccessLevel;
    }

    /**
     * Removed user/group from shared file/folder.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedContentRemoveMemberDetails() {
        this(null);
    }

    /**
     * Shared content access level.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public AccessLevel getSharedContentAccessLevel() {
        return sharedContentAccessLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedContentAccessLevel
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
            SharedContentRemoveMemberDetails other = (SharedContentRemoveMemberDetails) obj;
            return (this.sharedContentAccessLevel == other.sharedContentAccessLevel) || (this.sharedContentAccessLevel != null && this.sharedContentAccessLevel.equals(other.sharedContentAccessLevel));
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
    static class Serializer extends StructSerializer<SharedContentRemoveMemberDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentRemoveMemberDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sharedContentAccessLevel != null) {
                g.writeFieldName("shared_content_access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(value.sharedContentAccessLevel, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentRemoveMemberDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentRemoveMemberDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_sharedContentAccessLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_content_access_level".equals(field)) {
                        f_sharedContentAccessLevel = StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedContentRemoveMemberDetails(f_sharedContentAccessLevel);
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
