/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.sharing.InviteeInfo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

public class InviteeInfoWithPermissionLevel {
    // struct paper.InviteeInfoWithPermissionLevel (paper.stone)

    protected final InviteeInfo invitee;
    protected final PaperDocPermissionLevel permissionLevel;

    /**
     *
     * @param invitee  Email address invited to the Paper doc. Must not be
     *     {@code null}.
     * @param permissionLevel  Permission level for the invitee. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public InviteeInfoWithPermissionLevel(InviteeInfo invitee, PaperDocPermissionLevel permissionLevel) {
        if (invitee == null) {
            throw new IllegalArgumentException("Required value for 'invitee' is null");
        }
        this.invitee = invitee;
        if (permissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'permissionLevel' is null");
        }
        this.permissionLevel = permissionLevel;
    }

    /**
     * Email address invited to the Paper doc.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public InviteeInfo getInvitee() {
        return invitee;
    }

    /**
     * Permission level for the invitee.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public PaperDocPermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            invitee,
            permissionLevel
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
            InviteeInfoWithPermissionLevel other = (InviteeInfoWithPermissionLevel) obj;
            return ((this.invitee == other.invitee) || (this.invitee.equals(other.invitee)))
                && ((this.permissionLevel == other.permissionLevel) || (this.permissionLevel.equals(other.permissionLevel)))
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
    static class Serializer extends StructSerializer<InviteeInfoWithPermissionLevel> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(InviteeInfoWithPermissionLevel value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("invitee");
            InviteeInfo.Serializer.INSTANCE.serialize(value.invitee, g);
            g.writeFieldName("permission_level");
            PaperDocPermissionLevel.Serializer.INSTANCE.serialize(value.permissionLevel, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public InviteeInfoWithPermissionLevel deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            InviteeInfoWithPermissionLevel value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                InviteeInfo f_invitee = null;
                PaperDocPermissionLevel f_permissionLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("invitee".equals(field)) {
                        f_invitee = InviteeInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("permission_level".equals(field)) {
                        f_permissionLevel = PaperDocPermissionLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_invitee == null) {
                    throw new JsonParseException(p, "Required field \"invitee\" missing.");
                }
                if (f_permissionLevel == null) {
                    throw new JsonParseException(p, "Required field \"permission_level\" missing.");
                }
                value = new InviteeInfoWithPermissionLevel(f_invitee, f_permissionLevel);
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
