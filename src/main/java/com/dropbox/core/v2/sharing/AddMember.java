/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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
 * The member and type of access the member should have when added to a shared
 * folder.
 */
@JsonSerialize(using=AddMember.Serializer.class)
@JsonDeserialize(using=AddMember.Deserializer.class)
public class AddMember {
    // struct AddMember

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final MemberSelector member;
    protected final AccessLevel accessLevel;

    /**
     * The member and type of access the member should have when added to a
     * shared folder.
     *
     * @param member  The member to add to the shared folder. Must not be {@code
     *     null}.
     * @param accessLevel  The access level to grant {@link AddMember#getMember}
     *     to the shared folder.  {@link AccessLevel#OWNER} is disallowed.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddMember(MemberSelector member, AccessLevel accessLevel) {
        if (member == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = member;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessLevel' is null");
        }
        this.accessLevel = accessLevel;
    }

    /**
     * The member and type of access the member should have when added to a
     * shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param member  The member to add to the shared folder. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddMember(MemberSelector member) {
        this(member, AccessLevel.VIEWER);
    }

    /**
     * The member to add to the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberSelector getMember() {
        return member;
    }

    /**
     * The access level to grant {@link AddMember#getMember} to the shared
     * folder.  {@link AccessLevel#OWNER} is disallowed.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AccessLevel.VIEWER.
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            member,
            accessLevel
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
            AddMember other = (AddMember) obj;
            return ((this.member == other.member) || (this.member.equals(other.member)))
                && ((this.accessLevel == other.accessLevel) || (this.accessLevel.equals(other.accessLevel)))
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

    static final class Serializer extends StructJsonSerializer<AddMember> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AddMember.class);
        }

        public Serializer(boolean unwrapping) {
            super(AddMember.class, unwrapping);
        }

        @Override
        protected JsonSerializer<AddMember> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(AddMember value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("member", value.member);
            g.writeObjectField("access_level", value.accessLevel);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<AddMember> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AddMember.class);
        }

        public Deserializer(boolean unwrapping) {
            super(AddMember.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<AddMember> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public AddMember deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            MemberSelector member = null;
            AccessLevel accessLevel = AccessLevel.VIEWER;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("member".equals(_field)) {
                    member = _p.readValueAs(MemberSelector.class);
                    _p.nextToken();
                }
                else if ("access_level".equals(_field)) {
                    accessLevel = _p.readValueAs(AccessLevel.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (member == null) {
                throw new JsonParseException(_p, "Required field \"member\" is missing.");
            }

            return new AddMember(member, accessLevel);
        }
    }
}
