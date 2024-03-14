/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Changed sharing setting for Paper doc.
 */
public class PaperDocChangeSharingPolicyDetails {
    // struct team_log.PaperDocChangeSharingPolicyDetails (team_log_generated.stone)

    protected final String eventUuid;
    protected final String publicSharingPolicy;
    protected final String teamSharingPolicy;

    /**
     * Changed sharing setting for Paper doc.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param publicSharingPolicy  Sharing policy with external users.
     * @param teamSharingPolicy  Sharing policy with team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocChangeSharingPolicyDetails(String eventUuid, String publicSharingPolicy, String teamSharingPolicy) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        this.publicSharingPolicy = publicSharingPolicy;
        this.teamSharingPolicy = teamSharingPolicy;
    }

    /**
     * Changed sharing setting for Paper doc.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocChangeSharingPolicyDetails(String eventUuid) {
        this(eventUuid, null, null);
    }

    /**
     * Event unique identifier.
     *
     * @return value for this field, never {@code null}.
     */
    public String getEventUuid() {
        return eventUuid;
    }

    /**
     * Sharing policy with external users.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPublicSharingPolicy() {
        return publicSharingPolicy;
    }

    /**
     * Sharing policy with team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getTeamSharingPolicy() {
        return teamSharingPolicy;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String eventUuid) {
        return new Builder(eventUuid);
    }

    /**
     * Builder for {@link PaperDocChangeSharingPolicyDetails}.
     */
    public static class Builder {
        protected final String eventUuid;

        protected String publicSharingPolicy;
        protected String teamSharingPolicy;

        protected Builder(String eventUuid) {
            if (eventUuid == null) {
                throw new IllegalArgumentException("Required value for 'eventUuid' is null");
            }
            this.eventUuid = eventUuid;
            this.publicSharingPolicy = null;
            this.teamSharingPolicy = null;
        }

        /**
         * Set value for optional field.
         *
         * @param publicSharingPolicy  Sharing policy with external users.
         *
         * @return this builder
         */
        public Builder withPublicSharingPolicy(String publicSharingPolicy) {
            this.publicSharingPolicy = publicSharingPolicy;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param teamSharingPolicy  Sharing policy with team.
         *
         * @return this builder
         */
        public Builder withTeamSharingPolicy(String teamSharingPolicy) {
            this.teamSharingPolicy = teamSharingPolicy;
            return this;
        }

        /**
         * Builds an instance of {@link PaperDocChangeSharingPolicyDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link PaperDocChangeSharingPolicyDetails}
         */
        public PaperDocChangeSharingPolicyDetails build() {
            return new PaperDocChangeSharingPolicyDetails(eventUuid, publicSharingPolicy, teamSharingPolicy);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            eventUuid,
            publicSharingPolicy,
            teamSharingPolicy
        });
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
            PaperDocChangeSharingPolicyDetails other = (PaperDocChangeSharingPolicyDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && ((this.publicSharingPolicy == other.publicSharingPolicy) || (this.publicSharingPolicy != null && this.publicSharingPolicy.equals(other.publicSharingPolicy)))
                && ((this.teamSharingPolicy == other.teamSharingPolicy) || (this.teamSharingPolicy != null && this.teamSharingPolicy.equals(other.teamSharingPolicy)))
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
    static class Serializer extends StructSerializer<PaperDocChangeSharingPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocChangeSharingPolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            if (value.publicSharingPolicy != null) {
                g.writeFieldName("public_sharing_policy");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.publicSharingPolicy, g);
            }
            if (value.teamSharingPolicy != null) {
                g.writeFieldName("team_sharing_policy");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.teamSharingPolicy, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocChangeSharingPolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocChangeSharingPolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                String f_publicSharingPolicy = null;
                String f_teamSharingPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("public_sharing_policy".equals(field)) {
                        f_publicSharingPolicy = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("team_sharing_policy".equals(field)) {
                        f_teamSharingPolicy = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                value = new PaperDocChangeSharingPolicyDetails(f_eventUuid, f_publicSharingPolicy, f_teamSharingPolicy);
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
