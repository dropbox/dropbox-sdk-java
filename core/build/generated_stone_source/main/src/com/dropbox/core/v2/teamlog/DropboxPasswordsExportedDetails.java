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
 * Exported passwords.
 */
public class DropboxPasswordsExportedDetails {
    // struct team_log.DropboxPasswordsExportedDetails (team_log_generated.stone)

    protected final String platform;

    /**
     * Exported passwords.
     *
     * @param platform  The platform the device runs export. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DropboxPasswordsExportedDetails(@Nonnull String platform) {
        if (platform == null) {
            throw new IllegalArgumentException("Required value for 'platform' is null");
        }
        this.platform = platform;
    }

    /**
     * The platform the device runs export.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPlatform() {
        return platform;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            platform
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
            DropboxPasswordsExportedDetails other = (DropboxPasswordsExportedDetails) obj;
            return (this.platform == other.platform) || (this.platform.equals(other.platform));
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
    static class Serializer extends StructSerializer<DropboxPasswordsExportedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DropboxPasswordsExportedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("platform");
            StoneSerializers.string().serialize(value.platform, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DropboxPasswordsExportedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DropboxPasswordsExportedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_platform = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("platform".equals(field)) {
                        f_platform = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_platform == null) {
                    throw new JsonParseException(p, "Required field \"platform\" missing.");
                }
                value = new DropboxPasswordsExportedDetails(f_platform);
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
