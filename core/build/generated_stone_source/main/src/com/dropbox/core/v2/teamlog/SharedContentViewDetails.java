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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Previewed shared file/folder.
 */
public class SharedContentViewDetails {
    // struct team_log.SharedContentViewDetails (team_log_generated.stone)

    protected final String sharedContentLink;
    protected final UserLogInfo sharedContentOwner;
    protected final AccessLevel sharedContentAccessLevel;

    /**
     * Previewed shared file/folder.
     *
     * @param sharedContentLink  Shared content link. Must not be {@code null}.
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     * @param sharedContentOwner  The shared content owner.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedContentViewDetails(@Nonnull String sharedContentLink, @Nonnull AccessLevel sharedContentAccessLevel, @Nullable UserLogInfo sharedContentOwner) {
        if (sharedContentLink == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentLink' is null");
        }
        this.sharedContentLink = sharedContentLink;
        this.sharedContentOwner = sharedContentOwner;
        if (sharedContentAccessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = sharedContentAccessLevel;
    }

    /**
     * Previewed shared file/folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sharedContentLink  Shared content link. Must not be {@code null}.
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedContentViewDetails(String sharedContentLink, AccessLevel sharedContentAccessLevel) {
        this(sharedContentLink, sharedContentAccessLevel, null);
    }

    /**
     * Shared content link.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSharedContentLink() {
        return sharedContentLink;
    }

    /**
     * Shared content access level.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return sharedContentAccessLevel;
    }

    /**
     * The shared content owner.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public UserLogInfo getSharedContentOwner() {
        return sharedContentOwner;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedContentLink,
            sharedContentOwner,
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
            SharedContentViewDetails other = (SharedContentViewDetails) obj;
            return ((this.sharedContentLink == other.sharedContentLink) || (this.sharedContentLink.equals(other.sharedContentLink)))
                && ((this.sharedContentAccessLevel == other.sharedContentAccessLevel) || (this.sharedContentAccessLevel.equals(other.sharedContentAccessLevel)))
                && ((this.sharedContentOwner == other.sharedContentOwner) || (this.sharedContentOwner != null && this.sharedContentOwner.equals(other.sharedContentOwner)))
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
    static class Serializer extends StructSerializer<SharedContentViewDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentViewDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_content_link");
            StoneSerializers.string().serialize(value.sharedContentLink, g);
            g.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(value.sharedContentAccessLevel, g);
            if (value.sharedContentOwner != null) {
                g.writeFieldName("shared_content_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(value.sharedContentOwner, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentViewDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentViewDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedContentLink = null;
                AccessLevel f_sharedContentAccessLevel = null;
                UserLogInfo f_sharedContentOwner = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_content_link".equals(field)) {
                        f_sharedContentLink = StoneSerializers.string().deserialize(p);
                    }
                    else if ("shared_content_access_level".equals(field)) {
                        f_sharedContentAccessLevel = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_content_owner".equals(field)) {
                        f_sharedContentOwner = StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedContentLink == null) {
                    throw new JsonParseException(p, "Required field \"shared_content_link\" missing.");
                }
                if (f_sharedContentAccessLevel == null) {
                    throw new JsonParseException(p, "Required field \"shared_content_access_level\" missing.");
                }
                value = new SharedContentViewDetails(f_sharedContentLink, f_sharedContentAccessLevel, f_sharedContentOwner);
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
