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
 * Reseller information.
 */
public class ResellerLogInfo {
    // struct team_log.ResellerLogInfo (team_log_generated.stone)

    protected final String resellerName;
    protected final String resellerEmail;

    /**
     * Reseller information.
     *
     * @param resellerName  Reseller name. Must not be {@code null}.
     * @param resellerEmail  Reseller email. Must have length of at most 255 and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ResellerLogInfo(@Nonnull String resellerName, @Nonnull String resellerEmail) {
        if (resellerName == null) {
            throw new IllegalArgumentException("Required value for 'resellerName' is null");
        }
        this.resellerName = resellerName;
        if (resellerEmail == null) {
            throw new IllegalArgumentException("Required value for 'resellerEmail' is null");
        }
        if (resellerEmail.length() > 255) {
            throw new IllegalArgumentException("String 'resellerEmail' is longer than 255");
        }
        this.resellerEmail = resellerEmail;
    }

    /**
     * Reseller name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getResellerName() {
        return resellerName;
    }

    /**
     * Reseller email.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getResellerEmail() {
        return resellerEmail;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            resellerName,
            resellerEmail
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
            ResellerLogInfo other = (ResellerLogInfo) obj;
            return ((this.resellerName == other.resellerName) || (this.resellerName.equals(other.resellerName)))
                && ((this.resellerEmail == other.resellerEmail) || (this.resellerEmail.equals(other.resellerEmail)))
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
    static class Serializer extends StructSerializer<ResellerLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ResellerLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("reseller_name");
            StoneSerializers.string().serialize(value.resellerName, g);
            g.writeFieldName("reseller_email");
            StoneSerializers.string().serialize(value.resellerEmail, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ResellerLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ResellerLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_resellerName = null;
                String f_resellerEmail = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("reseller_name".equals(field)) {
                        f_resellerName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("reseller_email".equals(field)) {
                        f_resellerEmail = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_resellerName == null) {
                    throw new JsonParseException(p, "Required field \"reseller_name\" missing.");
                }
                if (f_resellerEmail == null) {
                    throw new JsonParseException(p, "Required field \"reseller_email\" missing.");
                }
                value = new ResellerLogInfo(f_resellerName, f_resellerEmail);
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
