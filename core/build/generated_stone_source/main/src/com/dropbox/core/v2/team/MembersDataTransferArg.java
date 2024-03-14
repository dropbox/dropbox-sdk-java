/* DO NOT EDIT */
/* This file was generated from team_members.stone */

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

import javax.annotation.Nonnull;

class MembersDataTransferArg extends MembersDeactivateBaseArg {
    // struct team.MembersDataTransferArg (team_members.stone)

    protected final UserSelectorArg transferDestId;
    protected final UserSelectorArg transferAdminId;

    /**
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     * @param transferDestId  Files from the deleted member account will be
     *     transferred to this user. Must not be {@code null}.
     * @param transferAdminId  Errors during the transfer process will be sent
     *     via email to this user. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersDataTransferArg(@Nonnull UserSelectorArg user, @Nonnull UserSelectorArg transferDestId, @Nonnull UserSelectorArg transferAdminId) {
        super(user);
        if (transferDestId == null) {
            throw new IllegalArgumentException("Required value for 'transferDestId' is null");
        }
        this.transferDestId = transferDestId;
        if (transferAdminId == null) {
            throw new IllegalArgumentException("Required value for 'transferAdminId' is null");
        }
        this.transferAdminId = transferAdminId;
    }

    /**
     * Identity of user to remove/suspend/have their files moved.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * Files from the deleted member account will be transferred to this user.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getTransferDestId() {
        return transferDestId;
    }

    /**
     * Errors during the transfer process will be sent via email to this user.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getTransferAdminId() {
        return transferAdminId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            transferDestId,
            transferAdminId
        });
        hash = (31 * super.hashCode()) + hash;
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
            MembersDataTransferArg other = (MembersDataTransferArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.transferDestId == other.transferDestId) || (this.transferDestId.equals(other.transferDestId)))
                && ((this.transferAdminId == other.transferAdminId) || (this.transferAdminId.equals(other.transferAdminId)))
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
    static class Serializer extends StructSerializer<MembersDataTransferArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersDataTransferArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("transfer_dest_id");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.transferDestId, g);
            g.writeFieldName("transfer_admin_id");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.transferAdminId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersDataTransferArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersDataTransferArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                UserSelectorArg f_transferDestId = null;
                UserSelectorArg f_transferAdminId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("transfer_dest_id".equals(field)) {
                        f_transferDestId = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("transfer_admin_id".equals(field)) {
                        f_transferAdminId = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_transferDestId == null) {
                    throw new JsonParseException(p, "Required field \"transfer_dest_id\" missing.");
                }
                if (f_transferAdminId == null) {
                    throw new JsonParseException(p, "Required field \"transfer_admin_id\" missing.");
                }
                value = new MembersDataTransferArg(f_user, f_transferDestId, f_transferAdminId);
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
