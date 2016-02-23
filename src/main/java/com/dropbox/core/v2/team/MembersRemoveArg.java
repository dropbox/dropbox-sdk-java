/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class MembersRemoveArg extends MembersDeactivateArg {
    // struct MembersRemoveArg

    private final UserSelectorArg transferDestId;
    private final UserSelectorArg transferAdminId;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices.
     * @param transferDestId  If provided, files from the deleted member account
     *     will be transferred to this user.
     * @param transferAdminId  If provided, errors during the transfer process
     *     will be sent via email to this user. If the transfer_dest_id argument
     *     was provided, then this argument must be provided as well.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersRemoveArg(UserSelectorArg user, boolean wipeData, UserSelectorArg transferDestId, UserSelectorArg transferAdminId) {
        super(user, wipeData);
        this.transferDestId = transferDestId;
        this.transferAdminId = transferAdminId;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersRemoveArg(UserSelectorArg user) {
        this(user, true, null, null);
    }

    /**
     * If provided, files from the deleted member account will be transferred to
     * this user.
     *
     * @return value for this field, or {@code null} if not present.
     */
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
    public UserSelectorArg getTransferAdminId() {
        return transferAdminId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
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

        protected Builder(UserSelectorArg user) {
            if (user == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = user;
            this.wipeData = true;
            this.transferDestId = null;
            this.transferAdminId = null;
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
         * Builds an instance of {@link MembersRemoveArg} configured with this
         * builder's values
         *
         * @return new instance of {@link MembersRemoveArg}
         */
        public MembersRemoveArg build() {
            return new MembersRemoveArg(user, wipeData, transferDestId, transferAdminId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            MembersRemoveArg other = (MembersRemoveArg) obj;
            return ((this.transferDestId == other.transferDestId) || (this.transferDestId != null && this.transferDestId.equals(other.transferDestId)))
                && ((this.transferAdminId == other.transferAdminId) || (this.transferAdminId != null && this.transferAdminId.equals(other.transferAdminId)))
                && ((this.getUser() == other.getUser()) || (this.getUser().equals(other.getUser())))
                && (this.getWipeData() == other.getWipeData())
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

    public static MembersRemoveArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersRemoveArg> _JSON_WRITER = new JsonWriter<MembersRemoveArg>() {
        public final void write(MembersRemoveArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersDeactivateArg._JSON_WRITER.writeFields(x, g);
            MembersRemoveArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersRemoveArg x, JsonGenerator g) throws IOException {
            if (x.transferDestId != null) {
                g.writeFieldName("transfer_dest_id");
                UserSelectorArg._JSON_WRITER.write(x.transferDestId, g);
            }
            if (x.transferAdminId != null) {
                g.writeFieldName("transfer_admin_id");
                UserSelectorArg._JSON_WRITER.write(x.transferAdminId, g);
            }
        }
    };

    public static final JsonReader<MembersRemoveArg> _JSON_READER = new JsonReader<MembersRemoveArg>() {
        public final MembersRemoveArg read(JsonParser parser) throws IOException, JsonReadException {
            MembersRemoveArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersRemoveArg readFields(JsonParser parser) throws IOException, JsonReadException {
            UserSelectorArg user = null;
            Boolean wipeData = null;
            UserSelectorArg transferDestId = null;
            UserSelectorArg transferAdminId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("user".equals(fieldName)) {
                    user = UserSelectorArg._JSON_READER
                        .readField(parser, "user", user);
                }
                else if ("wipe_data".equals(fieldName)) {
                    wipeData = JsonReader.BooleanReader
                        .readField(parser, "wipe_data", wipeData);
                }
                else if ("transfer_dest_id".equals(fieldName)) {
                    transferDestId = UserSelectorArg._JSON_READER
                        .readField(parser, "transfer_dest_id", transferDestId);
                }
                else if ("transfer_admin_id".equals(fieldName)) {
                    transferAdminId = UserSelectorArg._JSON_READER
                        .readField(parser, "transfer_admin_id", transferAdminId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            return new MembersRemoveArg(user, wipeData, transferDestId, transferAdminId);
        }
    };
}
