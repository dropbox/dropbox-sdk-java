/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=MembersRemoveArg.Serializer.class)
@JsonDeserialize(using=MembersRemoveArg.Deserializer.class)
class MembersRemoveArg extends MembersDeactivateArg {
    // struct MembersRemoveArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UserSelectorArg transferDestId;
    protected final UserSelectorArg transferAdminId;

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
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && (this.wipeData == other.wipeData)
                && ((this.transferDestId == other.transferDestId) || (this.transferDestId != null && this.transferDestId.equals(other.transferDestId)))
                && ((this.transferAdminId == other.transferAdminId) || (this.transferAdminId != null && this.transferAdminId.equals(other.transferAdminId)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<MembersRemoveArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersRemoveArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersRemoveArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersRemoveArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersRemoveArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("user", value.user);
            g.writeObjectField("wipe_data", value.wipeData);
            if (value.transferDestId != null) {
                g.writeObjectField("transfer_dest_id", value.transferDestId);
            }
            if (value.transferAdminId != null) {
                g.writeObjectField("transfer_admin_id", value.transferAdminId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersRemoveArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersRemoveArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersRemoveArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersRemoveArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersRemoveArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            UserSelectorArg user = null;
            boolean wipeData = true;
            UserSelectorArg transferDestId = null;
            UserSelectorArg transferAdminId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("user".equals(_field)) {
                    user = _p.readValueAs(UserSelectorArg.class);
                    _p.nextToken();
                }
                else if ("wipe_data".equals(_field)) {
                    wipeData = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("transfer_dest_id".equals(_field)) {
                    transferDestId = _p.readValueAs(UserSelectorArg.class);
                    _p.nextToken();
                }
                else if ("transfer_admin_id".equals(_field)) {
                    transferAdminId = _p.readValueAs(UserSelectorArg.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (user == null) {
                throw new JsonParseException(_p, "Required field \"user\" is missing.");
            }

            return new MembersRemoveArg(user, wipeData, transferDestId, transferAdminId);
        }
    }
}
