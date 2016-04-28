/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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

@JsonSerialize(using=IncludeMembersArg.Serializer.class)
@JsonDeserialize(using=IncludeMembersArg.Deserializer.class)
public class IncludeMembersArg {
    // struct IncludeMembersArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final boolean returnMembers;

    /**
     *
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     */
    public IncludeMembersArg(boolean returnMembers) {
        this.returnMembers = returnMembers;
    }

    /**
     * The default values for unset fields will be used.
     */
    public IncludeMembersArg() {
        this(true);
    }

    /**
     * Whether to return the list of members in the group.  Note that the
     * default value will cause all the group members  to be returned in the
     * response. This may take a long time for large groups.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getReturnMembers() {
        return returnMembers;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            returnMembers
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
            IncludeMembersArg other = (IncludeMembersArg) obj;
            return this.returnMembers == other.returnMembers;
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

    static final class Serializer extends StructJsonSerializer<IncludeMembersArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(IncludeMembersArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(IncludeMembersArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<IncludeMembersArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(IncludeMembersArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("return_members", value.returnMembers);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<IncludeMembersArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(IncludeMembersArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(IncludeMembersArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<IncludeMembersArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public IncludeMembersArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            boolean returnMembers = true;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("return_members".equals(_field)) {
                    returnMembers = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new IncludeMembersArg(returnMembers);
        }
    }
}
