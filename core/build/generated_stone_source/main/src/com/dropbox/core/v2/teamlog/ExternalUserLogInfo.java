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
 * A user without a Dropbox account.
 */
public class ExternalUserLogInfo {
    // struct team_log.ExternalUserLogInfo (team_log_generated.stone)

    protected final String userIdentifier;
    protected final IdentifierType identifierType;

    /**
     * A user without a Dropbox account.
     *
     * @param userIdentifier  An external user identifier. Must not be {@code
     *     null}.
     * @param identifierType  Identifier type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExternalUserLogInfo(String userIdentifier, IdentifierType identifierType) {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("Required value for 'userIdentifier' is null");
        }
        this.userIdentifier = userIdentifier;
        if (identifierType == null) {
            throw new IllegalArgumentException("Required value for 'identifierType' is null");
        }
        this.identifierType = identifierType;
    }

    /**
     * An external user identifier.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getUserIdentifier() {
        return userIdentifier;
    }

    /**
     * Identifier type.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public IdentifierType getIdentifierType() {
        return identifierType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            userIdentifier,
            identifierType
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
            ExternalUserLogInfo other = (ExternalUserLogInfo) obj;
            return ((this.userIdentifier == other.userIdentifier) || (this.userIdentifier.equals(other.userIdentifier)))
                && ((this.identifierType == other.identifierType) || (this.identifierType.equals(other.identifierType)))
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
    static class Serializer extends StructSerializer<ExternalUserLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExternalUserLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user_identifier");
            StoneSerializers.string().serialize(value.userIdentifier, g);
            g.writeFieldName("identifier_type");
            IdentifierType.Serializer.INSTANCE.serialize(value.identifierType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExternalUserLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExternalUserLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_userIdentifier = null;
                IdentifierType f_identifierType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user_identifier".equals(field)) {
                        f_userIdentifier = StoneSerializers.string().deserialize(p);
                    }
                    else if ("identifier_type".equals(field)) {
                        f_identifierType = IdentifierType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_userIdentifier == null) {
                    throw new JsonParseException(p, "Required field \"user_identifier\" missing.");
                }
                if (f_identifierType == null) {
                    throw new JsonParseException(p, "Required field \"identifier_type\" missing.");
                }
                value = new ExternalUserLogInfo(f_userIdentifier, f_identifierType);
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
