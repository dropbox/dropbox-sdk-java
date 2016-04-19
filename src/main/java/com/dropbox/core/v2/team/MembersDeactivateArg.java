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

/**
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account.
 */
@JsonSerialize(using=MembersDeactivateArg.Serializer.class)
@JsonDeserialize(using=MembersDeactivateArg.Deserializer.class)
class MembersDeactivateArg {
    // struct MembersDeactivateArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UserSelectorArg user;
    protected final boolean wipeData;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersDeactivateArg(UserSelectorArg user, boolean wipeData) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        this.wipeData = wipeData;
    }

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersDeactivateArg(UserSelectorArg user) {
        this(user, true);
    }

    /**
     * Identity of user to remove/suspend.
     *
     * @return value for this field, never {@code null}.
     */
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

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user,
            wipeData
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            MembersDeactivateArg other = (MembersDeactivateArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && (this.wipeData == other.wipeData)
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

    static final class Serializer extends StructJsonSerializer<MembersDeactivateArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersDeactivateArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersDeactivateArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersDeactivateArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersDeactivateArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("user", value.user);
            g.writeObjectField("wipe_data", value.wipeData);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersDeactivateArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersDeactivateArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersDeactivateArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersDeactivateArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersDeactivateArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            UserSelectorArg user = null;
            boolean wipeData = true;

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
                else {
                    skipValue(_p);
                }
            }

            if (user == null) {
                throw new JsonParseException(_p, "Required field \"user\" is missing.");
            }

            return new MembersDeactivateArg(user, wipeData);
        }
    }
}
