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
import javax.annotation.Nullable;

/**
 * Details about team invites
 */
public class TeamInviteDetails {
    // struct team_log.TeamInviteDetails (team_log_generated.stone)

    protected final InviteMethod inviteMethod;
    protected final Boolean additionalLicensePurchase;

    /**
     * Details about team invites
     *
     * @param inviteMethod  How the user was invited to the team. Must not be
     *     {@code null}.
     * @param additionalLicensePurchase  True if the invitation incurred an
     *     additional license purchase.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamInviteDetails(@Nonnull InviteMethod inviteMethod, @Nullable Boolean additionalLicensePurchase) {
        if (inviteMethod == null) {
            throw new IllegalArgumentException("Required value for 'inviteMethod' is null");
        }
        this.inviteMethod = inviteMethod;
        this.additionalLicensePurchase = additionalLicensePurchase;
    }

    /**
     * Details about team invites
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param inviteMethod  How the user was invited to the team. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamInviteDetails(InviteMethod inviteMethod) {
        this(inviteMethod, null);
    }

    /**
     * How the user was invited to the team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public InviteMethod getInviteMethod() {
        return inviteMethod;
    }

    /**
     * True if the invitation incurred an additional license purchase.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getAdditionalLicensePurchase() {
        return additionalLicensePurchase;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            inviteMethod,
            additionalLicensePurchase
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
            TeamInviteDetails other = (TeamInviteDetails) obj;
            return ((this.inviteMethod == other.inviteMethod) || (this.inviteMethod.equals(other.inviteMethod)))
                && ((this.additionalLicensePurchase == other.additionalLicensePurchase) || (this.additionalLicensePurchase != null && this.additionalLicensePurchase.equals(other.additionalLicensePurchase)))
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
    static class Serializer extends StructSerializer<TeamInviteDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamInviteDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("invite_method");
            InviteMethod.Serializer.INSTANCE.serialize(value.inviteMethod, g);
            if (value.additionalLicensePurchase != null) {
                g.writeFieldName("additional_license_purchase");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.additionalLicensePurchase, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamInviteDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamInviteDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                InviteMethod f_inviteMethod = null;
                Boolean f_additionalLicensePurchase = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("invite_method".equals(field)) {
                        f_inviteMethod = InviteMethod.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("additional_license_purchase".equals(field)) {
                        f_additionalLicensePurchase = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_inviteMethod == null) {
                    throw new JsonParseException(p, "Required field \"invite_method\" missing.");
                }
                value = new TeamInviteDetails(f_inviteMethod, f_additionalLicensePurchase);
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
