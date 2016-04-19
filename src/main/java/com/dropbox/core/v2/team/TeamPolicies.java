/* DO NOT EDIT */
/* This file was generated from team.babel */

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
 * Policies governing team members.
 */
@JsonSerialize(using=TeamPolicies.Serializer.class)
@JsonDeserialize(using=TeamPolicies.Deserializer.class)
public class TeamPolicies {
    // struct TeamPolicies

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final TeamSharingPolicies sharing;
    protected final EmmState emmState;

    /**
     * Policies governing team members.
     *
     * @param sharing  Policies governing sharing. Must not be {@code null}.
     * @param emmState  This describes the Enterprise Mobility Management (EMM)
     *     state for this team. This information can be used to understand if an
     *     organization is integrating with a third-party EMM vendor to further
     *     manage and apply restrictions upon the team's Dropbox usage on mobile
     *     devices. This is a new feature and in the future we'll be adding more
     *     new fields and additional documentation. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamPolicies(TeamSharingPolicies sharing, EmmState emmState) {
        if (sharing == null) {
            throw new IllegalArgumentException("Required value for 'sharing' is null");
        }
        this.sharing = sharing;
        if (emmState == null) {
            throw new IllegalArgumentException("Required value for 'emmState' is null");
        }
        this.emmState = emmState;
    }

    /**
     * Policies governing sharing.
     *
     * @return value for this field, never {@code null}.
     */
    public TeamSharingPolicies getSharing() {
        return sharing;
    }

    /**
     * This describes the Enterprise Mobility Management (EMM) state for this
     * team. This information can be used to understand if an organization is
     * integrating with a third-party EMM vendor to further manage and apply
     * restrictions upon the team's Dropbox usage on mobile devices. This is a
     * new feature and in the future we'll be adding more new fields and
     * additional documentation.
     *
     * @return value for this field, never {@code null}.
     */
    public EmmState getEmmState() {
        return emmState;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharing,
            emmState
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
            TeamPolicies other = (TeamPolicies) obj;
            return ((this.sharing == other.sharing) || (this.sharing.equals(other.sharing)))
                && ((this.emmState == other.emmState) || (this.emmState.equals(other.emmState)))
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

    static final class Serializer extends StructJsonSerializer<TeamPolicies> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamPolicies.class);
        }

        public Serializer(boolean unwrapping) {
            super(TeamPolicies.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TeamPolicies> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TeamPolicies value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("sharing", value.sharing);
            g.writeObjectField("emm_state", value.emmState);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TeamPolicies> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamPolicies.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TeamPolicies.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TeamPolicies> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TeamPolicies deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            TeamSharingPolicies sharing = null;
            EmmState emmState = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("sharing".equals(_field)) {
                    sharing = _p.readValueAs(TeamSharingPolicies.class);
                    _p.nextToken();
                }
                else if ("emm_state".equals(_field)) {
                    emmState = _p.readValueAs(EmmState.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharing == null) {
                throw new JsonParseException(_p, "Required field \"sharing\" is missing.");
            }
            if (emmState == null) {
                throw new JsonParseException(_p, "Required field \"emm_state\" is missing.");
            }

            return new TeamPolicies(sharing, emmState);
        }
    }
}
