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
import java.util.List;

@JsonSerialize(using=MembersGetInfoArgs.Serializer.class)
@JsonDeserialize(using=MembersGetInfoArgs.Deserializer.class)
class MembersGetInfoArgs {
    // struct MembersGetInfoArgs

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<UserSelectorArg> members;

    /**
     *
     * @param members  List of team members. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersGetInfoArgs(List<UserSelectorArg> members) {
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (UserSelectorArg x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
    }

    /**
     * List of team members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserSelectorArg> getMembers() {
        return members;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            members
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
            MembersGetInfoArgs other = (MembersGetInfoArgs) obj;
            return (this.members == other.members) || (this.members.equals(other.members));
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

    static final class Serializer extends StructJsonSerializer<MembersGetInfoArgs> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersGetInfoArgs.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersGetInfoArgs.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersGetInfoArgs> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersGetInfoArgs value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("members", value.members);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersGetInfoArgs> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersGetInfoArgs.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersGetInfoArgs.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersGetInfoArgs> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersGetInfoArgs deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<UserSelectorArg> members = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("members".equals(_field)) {
                    expectArrayStart(_p);
                    members = new java.util.ArrayList<UserSelectorArg>();
                    while (!isArrayEnd(_p)) {
                        UserSelectorArg _x = null;
                        _x = _p.readValueAs(UserSelectorArg.class);
                        _p.nextToken();
                        members.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (members == null) {
                throw new JsonParseException(_p, "Required field \"members\" is missing.");
            }

            return new MembersGetInfoArgs(members);
        }
    }
}
