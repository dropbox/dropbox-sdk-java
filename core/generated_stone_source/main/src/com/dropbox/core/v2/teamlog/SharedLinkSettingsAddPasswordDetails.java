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
 * Added a password to the shared link.
 */
public class SharedLinkSettingsAddPasswordDetails {
    // struct team_log.SharedLinkSettingsAddPasswordDetails (team_log_generated.stone)

    protected final AccessLevel sharedContentAccessLevel;
    protected final String sharedContentLink;

    /**
     * Added a password to the shared link.
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     * @param sharedContentLink  Shared content link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkSettingsAddPasswordDetails(AccessLevel sharedContentAccessLevel, String sharedContentLink) {
        if (sharedContentAccessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = sharedContentAccessLevel;
        this.sharedContentLink = sharedContentLink;
    }

    /**
     * Added a password to the shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkSettingsAddPasswordDetails(AccessLevel sharedContentAccessLevel) {
        this(sharedContentAccessLevel, null);
    }

    /**
     * Shared content access level.
     *
     * @return value for this field, never {@code null}.
     */
    public AccessLevel getSharedContentAccessLevel() {
        return sharedContentAccessLevel;
    }

    /**
     * Shared content link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getSharedContentLink() {
        return sharedContentLink;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedContentAccessLevel,
            sharedContentLink
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
            SharedLinkSettingsAddPasswordDetails other = (SharedLinkSettingsAddPasswordDetails) obj;
            return ((this.sharedContentAccessLevel == other.sharedContentAccessLevel) || (this.sharedContentAccessLevel.equals(other.sharedContentAccessLevel)))
                && ((this.sharedContentLink == other.sharedContentLink) || (this.sharedContentLink != null && this.sharedContentLink.equals(other.sharedContentLink)))
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
    static class Serializer extends StructSerializer<SharedLinkSettingsAddPasswordDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkSettingsAddPasswordDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(value.sharedContentAccessLevel, g);
            if (value.sharedContentLink != null) {
                g.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedContentLink, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkSettingsAddPasswordDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkSettingsAddPasswordDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_sharedContentAccessLevel = null;
                String f_sharedContentLink = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_content_access_level".equals(field)) {
                        f_sharedContentAccessLevel = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_content_link".equals(field)) {
                        f_sharedContentLink = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedContentAccessLevel == null) {
                    throw new JsonParseException(p, "Required field \"shared_content_access_level\" missing.");
                }
                value = new SharedLinkSettingsAddPasswordDetails(f_sharedContentAccessLevel, f_sharedContentLink);
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
