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

@JsonSerialize(using=MembersAddArg.Serializer.class)
@JsonDeserialize(using=MembersAddArg.Deserializer.class)
class MembersAddArg {
    // struct MembersAddArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<MemberAddArg> newMembers;
    protected final boolean forceAsync;

    /**
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param forceAsync  Whether to force the add to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddArg(List<MemberAddArg> newMembers, boolean forceAsync) {
        if (newMembers == null) {
            throw new IllegalArgumentException("Required value for 'newMembers' is null");
        }
        for (MemberAddArg x : newMembers) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'newMembers' is null");
            }
        }
        this.newMembers = newMembers;
        this.forceAsync = forceAsync;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddArg(List<MemberAddArg> newMembers) {
        this(newMembers, false);
    }

    /**
     * Details of new members to be added to the team.
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberAddArg> getNewMembers() {
        return newMembers;
    }

    /**
     * Whether to force the add to happen asynchronously.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getForceAsync() {
        return forceAsync;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            newMembers,
            forceAsync
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
            MembersAddArg other = (MembersAddArg) obj;
            return ((this.newMembers == other.newMembers) || (this.newMembers.equals(other.newMembers)))
                && (this.forceAsync == other.forceAsync)
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

    static final class Serializer extends StructJsonSerializer<MembersAddArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersAddArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersAddArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersAddArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersAddArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("new_members", value.newMembers);
            g.writeObjectField("force_async", value.forceAsync);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersAddArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersAddArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersAddArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersAddArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersAddArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<MemberAddArg> newMembers = null;
            boolean forceAsync = false;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("new_members".equals(_field)) {
                    expectArrayStart(_p);
                    newMembers = new java.util.ArrayList<MemberAddArg>();
                    while (!isArrayEnd(_p)) {
                        MemberAddArg _x = null;
                        _x = _p.readValueAs(MemberAddArg.class);
                        _p.nextToken();
                        newMembers.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("force_async".equals(_field)) {
                    forceAsync = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (newMembers == null) {
                throw new JsonParseException(_p, "Required field \"new_members\" is missing.");
            }

            return new MembersAddArg(newMembers, forceAsync);
        }
    }
}
