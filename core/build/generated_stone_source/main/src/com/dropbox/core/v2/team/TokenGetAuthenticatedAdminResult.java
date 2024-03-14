/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

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
 * Results for {@link DbxTeamTeamRequests#tokenGetAuthenticatedAdmin}.
 */
public class TokenGetAuthenticatedAdminResult {
    // struct team.TokenGetAuthenticatedAdminResult (team.stone)

    protected final TeamMemberProfile adminProfile;

    /**
     * Results for {@link DbxTeamTeamRequests#tokenGetAuthenticatedAdmin}.
     *
     * @param adminProfile  The admin who authorized the token. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TokenGetAuthenticatedAdminResult(@javax.annotation.Nonnull TeamMemberProfile adminProfile) {
        if (adminProfile == null) {
            throw new IllegalArgumentException("Required value for 'adminProfile' is null");
        }
        this.adminProfile = adminProfile;
    }

    /**
     * The admin who authorized the token.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamMemberProfile getAdminProfile() {
        return adminProfile;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            adminProfile
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
            TokenGetAuthenticatedAdminResult other = (TokenGetAuthenticatedAdminResult) obj;
            return (this.adminProfile == other.adminProfile) || (this.adminProfile.equals(other.adminProfile));
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
    static class Serializer extends StructSerializer<TokenGetAuthenticatedAdminResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TokenGetAuthenticatedAdminResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("admin_profile");
            TeamMemberProfile.Serializer.INSTANCE.serialize(value.adminProfile, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TokenGetAuthenticatedAdminResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TokenGetAuthenticatedAdminResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMemberProfile f_adminProfile = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("admin_profile".equals(field)) {
                        f_adminProfile = TeamMemberProfile.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_adminProfile == null) {
                    throw new JsonParseException(p, "Required field \"admin_profile\" missing.");
                }
                value = new TokenGetAuthenticatedAdminResult(f_adminProfile);
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
