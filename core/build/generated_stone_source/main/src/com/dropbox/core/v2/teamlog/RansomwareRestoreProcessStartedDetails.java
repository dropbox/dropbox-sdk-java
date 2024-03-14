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
 * Started ransomware restore process.
 */
public class RansomwareRestoreProcessStartedDetails {
    // struct team_log.RansomwareRestoreProcessStartedDetails (team_log_generated.stone)

    protected final String extension;

    /**
     * Started ransomware restore process.
     *
     * @param extension  Ransomware filename extension. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RansomwareRestoreProcessStartedDetails(@Nonnull String extension) {
        if (extension == null) {
            throw new IllegalArgumentException("Required value for 'extension' is null");
        }
        this.extension = extension;
    }

    /**
     * Ransomware filename extension.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getExtension() {
        return extension;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            extension
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
            RansomwareRestoreProcessStartedDetails other = (RansomwareRestoreProcessStartedDetails) obj;
            return (this.extension == other.extension) || (this.extension.equals(other.extension));
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
    static class Serializer extends StructSerializer<RansomwareRestoreProcessStartedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RansomwareRestoreProcessStartedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("extension");
            StoneSerializers.string().serialize(value.extension, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RansomwareRestoreProcessStartedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RansomwareRestoreProcessStartedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_extension = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("extension".equals(field)) {
                        f_extension = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_extension == null) {
                    throw new JsonParseException(p, "Required field \"extension\" missing.");
                }
                value = new RansomwareRestoreProcessStartedDetails(f_extension);
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
