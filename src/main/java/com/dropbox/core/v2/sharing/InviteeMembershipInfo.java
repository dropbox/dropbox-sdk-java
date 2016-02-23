/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * The information about a user invited to become a member of a shared folder.
 */
public class InviteeMembershipInfo extends MembershipInfo {
    // struct InviteeMembershipInfo

    private final InviteeInfo invitee;

    /**
     * The information about a user invited to become a member of a shared
     * folder.
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param invitee  The information for the invited user. Must not be {@code
     *     null}.
     * @param permissions  The permissions that requesting user has on this
     *     member. The set of permissions corresponds to the MemberActions in
     *     the request. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public InviteeMembershipInfo(AccessLevel accessType, InviteeInfo invitee, List<MemberPermission> permissions) {
        super(accessType, permissions);
        if (invitee == null) {
            throw new IllegalArgumentException("Required value for 'invitee' is null");
        }
        this.invitee = invitee;
    }

    /**
     * The information about a user invited to become a member of a shared
     * folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param invitee  The information for the invited user. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public InviteeMembershipInfo(AccessLevel accessType, InviteeInfo invitee) {
        this(accessType, invitee, null);
    }

    /**
     * The information for the invited user.
     *
     * @return value for this field, never {@code null}.
     */
    public InviteeInfo getInvitee() {
        return invitee;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            invitee
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            InviteeMembershipInfo other = (InviteeMembershipInfo) obj;
            return ((this.invitee == other.invitee) || (this.invitee.equals(other.invitee)))
                && ((this.getAccessType() == other.getAccessType()) || (this.getAccessType().equals(other.getAccessType())))
                && ((this.getPermissions() == other.getPermissions()) || (this.getPermissions() != null && this.getPermissions().equals(other.getPermissions())))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static InviteeMembershipInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<InviteeMembershipInfo> _JSON_WRITER = new JsonWriter<InviteeMembershipInfo>() {
        public final void write(InviteeMembershipInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembershipInfo._JSON_WRITER.writeFields(x, g);
            InviteeMembershipInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(InviteeMembershipInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("invitee");
            InviteeInfo._JSON_WRITER.write(x.invitee, g);
        }
    };

    public static final JsonReader<InviteeMembershipInfo> _JSON_READER = new JsonReader<InviteeMembershipInfo>() {
        public final InviteeMembershipInfo read(JsonParser parser) throws IOException, JsonReadException {
            InviteeMembershipInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final InviteeMembershipInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            AccessLevel accessType = null;
            InviteeInfo invitee = null;
            List<MemberPermission> permissions = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("access_type".equals(fieldName)) {
                    accessType = AccessLevel._JSON_READER
                        .readField(parser, "access_type", accessType);
                }
                else if ("invitee".equals(fieldName)) {
                    invitee = InviteeInfo._JSON_READER
                        .readField(parser, "invitee", invitee);
                }
                else if ("permissions".equals(fieldName)) {
                    permissions = JsonArrayReader.mk(MemberPermission._JSON_READER)
                        .readField(parser, "permissions", permissions);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (accessType == null) {
                throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
            }
            if (invitee == null) {
                throw new JsonReadException("Required field \"invitee\" is missing.", parser.getTokenLocation());
            }
            return new InviteeMembershipInfo(accessType, invitee, permissions);
        }
    };
}
