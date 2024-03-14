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

class MembersRemoveArg extends MembersDeactivateArg {
    // struct team.MembersRemoveArg (team_members.stone)

    protected final UserSelectorArg transferDestId;
    protected final UserSelectorArg transferAdminId;
    protected final boolean keepAccount;
    protected final boolean retainTeamShares;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices.
     * @param transferDestId  If provided, files from the deleted member account
     *     will be transferred to this user.
     * @param transferAdminId  If provided, errors during the transfer process
     *     will be sent via email to this user. If the transfer_dest_id argument
     *     was provided, then this argument must be provided as well.
     * @param keepAccount  Downgrade the member to a Basic account. The user
     *     will retain the email address associated with their Dropbox  account
     *     and data in their account that is not restricted to team members. In
     *     order to keep the account the argument the {@code wipeData} argument
     *     to {@link
     *     DbxTeamTeamRequests#membersSuspend(UserSelectorArg,boolean)} should
     *     be set to {@code false}.
     * @param retainTeamShares  If provided, allows removed users to keep access
     *     to Dropbox folders (not Dropbox Paper folders) already explicitly
     *     shared with them (not via a group) when they are downgraded to a
     *     Basic account. Users will not retain access to folders that do not
     *     allow external sharing. In order to keep the sharing relationships,
     *     the arguments the {@code wipeData} argument to {@link
     *     DbxTeamTeamRequests#membersSuspend(UserSelectorArg,boolean)} should
     *     be set to {@code false} and {@link MembersRemoveArg#getKeepAccount}
     *     should be set to {@code true}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersRemoveArg(UserSelectorArg user, boolean wipeData, UserSelectorArg transferDestId, UserSelectorArg transferAdminId, boolean keepAccount, boolean retainTeamShares) {
        super(user, wipeData);
        this.transferDestId = transferDestId;
        this.transferAdminId = transferAdminId;
        this.keepAccount = keepAccount;
        this.retainTeamShares = retainTeamShares;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersRemoveArg(UserSelectorArg user) {
        this(user, true, null, null, false, false);
    }

    /**
     * Identity of user to remove/suspend/have their files moved.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * If provided, controls if the user's data will be deleted on their linked
     * devices.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getWipeData() {
        return wipeData;
    }

    /**
     * If provided, files from the deleted member account will be transferred to
     * this user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public UserSelectorArg getTransferDestId() {
        return transferDestId;
    }

    /**
     * If provided, errors during the transfer process will be sent via email to
     * this user. If the transfer_dest_id argument was provided, then this
     * argument must be provided as well.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public UserSelectorArg getTransferAdminId() {
        return transferAdminId;
    }

    /**
     * Downgrade the member to a Basic account. The user will retain the email
     * address associated with their Dropbox  account and data in their account
     * that is not restricted to team members. In order to keep the account the
     * argument the {@code wipeData} argument to {@link
     * DbxTeamTeamRequests#membersSuspend(UserSelectorArg,boolean)} should be
     * set to {@code false}.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getKeepAccount() {
        return keepAccount;
    }

    /**
     * If provided, allows removed users to keep access to Dropbox folders (not
     * Dropbox Paper folders) already explicitly shared with them (not via a
     * group) when they are downgraded to a Basic account. Users will not retain
     * access to folders that do not allow external sharing. In order to keep
     * the sharing relationships, the arguments the {@code wipeData} argument to
     * {@link DbxTeamTeamRequests#membersSuspend(UserSelectorArg,boolean)}
     * should be set to {@code false} and {@link
     * MembersRemoveArg#getKeepAccount} should be set to {@code true}.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getRetainTeamShares() {
        return retainTeamShares;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(UserSelectorArg user) {
        return new Builder(user);
    }

    /**
     * Builder for {@link MembersRemoveArg}.
     */
    public static class Builder {
        protected final UserSelectorArg user;

        protected boolean wipeData;
        protected UserSelectorArg transferDestId;
        protected UserSelectorArg transferAdminId;
        protected boolean keepAccount;
        protected boolean retainTeamShares;

        protected Builder(UserSelectorArg user) {
            if (user == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = user;
            this.wipeData = true;
            this.transferDestId = null;
            this.transferAdminId = null;
            this.keepAccount = false;
            this.retainTeamShares = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param wipeData  If provided, controls if the user's data will be
         *     deleted on their linked devices. Defaults to {@code true} when
         *     set to {@code null}.
         *
         * @return this builder
         */
        public Builder withWipeData(Boolean wipeData) {
            if (wipeData != null) {
                this.wipeData = wipeData;
            }
            else {
                this.wipeData = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param transferDestId  If provided, files from the deleted member
         *     account will be transferred to this user.
         *
         * @return this builder
         */
        public Builder withTransferDestId(UserSelectorArg transferDestId) {
            this.transferDestId = transferDestId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param transferAdminId  If provided, errors during the transfer
         *     process will be sent via email to this user. If the
         *     transfer_dest_id argument was provided, then this argument must
         *     be provided as well.
         *
         * @return this builder
         */
        public Builder withTransferAdminId(UserSelectorArg transferAdminId) {
            this.transferAdminId = transferAdminId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param keepAccount  Downgrade the member to a Basic account. The user
         *     will retain the email address associated with their Dropbox
         *     account and data in their account that is not restricted to team
         *     members. In order to keep the account the argument the {@code
         *     wipeData} argument to {@link
         *     DbxTeamTeamRequests#membersSuspend(UserSelectorArg,boolean)}
         *     should be set to {@code false}. Defaults to {@code false} when
         *     set to {@code null}.
         *
         * @return this builder
         */
        public Builder withKeepAccount(Boolean keepAccount) {
            if (keepAccount != null) {
                this.keepAccount = keepAccount;
            }
            else {
                this.keepAccount = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param retainTeamShares  If provided, allows removed users to keep
         *     access to Dropbox folders (not Dropbox Paper folders) already
         *     explicitly shared with them (not via a group) when they are
         *     downgraded to a Basic account. Users will not retain access to
         *     folders that do not allow external sharing. In order to keep the
         *     sharing relationships, the arguments the {@code wipeData}
         *     argument to {@link
         *     DbxTeamTeamRequests#membersSuspend(UserSelectorArg,boolean)}
         *     should be set to {@code false} and {@link
         *     MembersRemoveArg#getKeepAccount} should be set to {@code true}.
         *     Defaults to {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withRetainTeamShares(Boolean retainTeamShares) {
            if (retainTeamShares != null) {
                this.retainTeamShares = retainTeamShares;
            }
            else {
                this.retainTeamShares = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link MembersRemoveArg} configured with this
         * builder's values
         *
         * @return new instance of {@link MembersRemoveArg}
         */
        public MembersRemoveArg build() {
            return new MembersRemoveArg(user, wipeData, transferDestId, transferAdminId, keepAccount, retainTeamShares);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            transferDestId,
            transferAdminId,
            keepAccount,
            retainTeamShares
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
            MembersRemoveArg other = (MembersRemoveArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && (this.wipeData == other.wipeData)
                && ((this.transferDestId == other.transferDestId) || (this.transferDestId != null && this.transferDestId.equals(other.transferDestId)))
                && ((this.transferAdminId == other.transferAdminId) || (this.transferAdminId != null && this.transferAdminId.equals(other.transferAdminId)))
                && (this.keepAccount == other.keepAccount)
                && (this.retainTeamShares == other.retainTeamShares)
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
    static class Serializer extends StructSerializer<MembersRemoveArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersRemoveArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("wipe_data");
            StoneSerializers.boolean_().serialize(value.wipeData, g);
            if (value.transferDestId != null) {
                g.writeFieldName("transfer_dest_id");
                StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).serialize(value.transferDestId, g);
            }
            if (value.transferAdminId != null) {
                g.writeFieldName("transfer_admin_id");
                StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).serialize(value.transferAdminId, g);
            }
            g.writeFieldName("keep_account");
            StoneSerializers.boolean_().serialize(value.keepAccount, g);
            g.writeFieldName("retain_team_shares");
            StoneSerializers.boolean_().serialize(value.retainTeamShares, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersRemoveArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersRemoveArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                Boolean f_wipeData = true;
                UserSelectorArg f_transferDestId = null;
                UserSelectorArg f_transferAdminId = null;
                Boolean f_keepAccount = false;
                Boolean f_retainTeamShares = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("wipe_data".equals(field)) {
                        f_wipeData = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("transfer_dest_id".equals(field)) {
                        f_transferDestId = StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("transfer_admin_id".equals(field)) {
                        f_transferAdminId = StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("keep_account".equals(field)) {
                        f_keepAccount = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("retain_team_shares".equals(field)) {
                        f_retainTeamShares = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                value = new MembersRemoveArg(f_user, f_wipeData, f_transferDestId, f_transferAdminId, f_keepAccount, f_retainTeamShares);
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
