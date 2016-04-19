/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Space is allocated differently based on the type of account.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
@JsonSerialize(using=SpaceAllocation.Serializer.class)
@JsonDeserialize(using=SpaceAllocation.Deserializer.class)
public final class SpaceAllocation {
    // union SpaceAllocation

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link SpaceAllocation}.
     */
    public enum Tag {
        /**
         * The user's space allocation applies only to their individual account.
         */
        INDIVIDUAL, // IndividualSpaceAllocation
        /**
         * The user shares space with other members of their team.
         */
        TEAM, // TeamSpaceAllocation
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SpaceAllocation OTHER = new SpaceAllocation(Tag.OTHER, null, null);

    private final Tag tag;
    private final IndividualSpaceAllocation individualValue;
    private final TeamSpaceAllocation teamValue;

    /**
     * Space is allocated differently based on the type of account.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private SpaceAllocation(Tag tag, IndividualSpaceAllocation individualValue, TeamSpaceAllocation teamValue) {
        this.tag = tag;
        this.individualValue = individualValue;
        this.teamValue = teamValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code SpaceAllocation}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#INDIVIDUAL},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INDIVIDUAL}, {@code false} otherwise.
     */
    public boolean isIndividual() {
        return this.tag == Tag.INDIVIDUAL;
    }

    /**
     * Returns an instance of {@code SpaceAllocation} that has its tag set to
     * {@link Tag#INDIVIDUAL}.
     *
     * <p> The user's space allocation applies only to their individual account.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SpaceAllocation} with its tag set to {@link
     *     Tag#INDIVIDUAL}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SpaceAllocation individual(IndividualSpaceAllocation value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SpaceAllocation(Tag.INDIVIDUAL, value, null);
    }

    /**
     * The user's space allocation applies only to their individual account.
     *
     * <p> This instance must be tagged as {@link Tag#INDIVIDUAL}. </p>
     *
     * @return The {@link SpaceAllocation#individual} value associated with this
     *     instance if {@link #isIndividual} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isIndividual} is {@code false}.
     */
    public IndividualSpaceAllocation getIndividualValue() {
        if (this.tag != Tag.INDIVIDUAL) {
            throw new IllegalStateException("Invalid tag: required Tag.INDIVIDUAL, but was Tag." + tag.name());
        }
        return individualValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#TEAM},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#TEAM},
     *     {@code false} otherwise.
     */
    public boolean isTeam() {
        return this.tag == Tag.TEAM;
    }

    /**
     * Returns an instance of {@code SpaceAllocation} that has its tag set to
     * {@link Tag#TEAM}.
     *
     * <p> The user shares space with other members of their team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SpaceAllocation} with its tag set to {@link
     *     Tag#TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SpaceAllocation team(TeamSpaceAllocation value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SpaceAllocation(Tag.TEAM, null, value);
    }

    /**
     * The user shares space with other members of their team.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM}. </p>
     *
     * @return The {@link SpaceAllocation#team} value associated with this
     *     instance if {@link #isTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeam} is {@code false}.
     */
    public TeamSpaceAllocation getTeamValue() {
        if (this.tag != Tag.TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM, but was Tag." + tag.name());
        }
        return teamValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            individualValue,
            teamValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof SpaceAllocation) {
            SpaceAllocation other = (SpaceAllocation) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case INDIVIDUAL:
                    return (this.individualValue == other.individualValue) || (this.individualValue.equals(other.individualValue));
                case TEAM:
                    return (this.teamValue == other.teamValue) || (this.teamValue.equals(other.teamValue));
                case OTHER:
                    return true;
                default:
                    return false;
            }
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

    static final class Serializer extends UnionJsonSerializer<SpaceAllocation> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SpaceAllocation.class, IndividualSpaceAllocation.class, TeamSpaceAllocation.class);
        }

        @Override
        public void serialize(SpaceAllocation value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case INDIVIDUAL:
                    g.writeStartObject();
                    g.writeStringField(".tag", "individual");
                    getUnwrappingSerializer(IndividualSpaceAllocation.class).serialize(value.individualValue, g, provider);
                    g.writeEndObject();
                    break;
                case TEAM:
                    g.writeStartObject();
                    g.writeStringField(".tag", "team");
                    getUnwrappingSerializer(TeamSpaceAllocation.class).serialize(value.teamValue, g, provider);
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SpaceAllocation, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SpaceAllocation.class, getTagMapping(), Tag.OTHER, IndividualSpaceAllocation.class, TeamSpaceAllocation.class);
        }

        @Override
        public SpaceAllocation deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case INDIVIDUAL: {
                    IndividualSpaceAllocation value = null;
                    value = readCollapsedStructValue(IndividualSpaceAllocation.class, _p, _ctx);
                    return SpaceAllocation.individual(value);
                }
                case TEAM: {
                    TeamSpaceAllocation value = null;
                    value = readCollapsedStructValue(TeamSpaceAllocation.class, _p, _ctx);
                    return SpaceAllocation.team(value);
                }
                case OTHER: {
                    return SpaceAllocation.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, SpaceAllocation.Tag> getTagMapping() {
            Map<String, SpaceAllocation.Tag> values = new HashMap<String, SpaceAllocation.Tag>();
            values.put("individual", SpaceAllocation.Tag.INDIVIDUAL);
            values.put("team", SpaceAllocation.Tag.TEAM);
            values.put("other", SpaceAllocation.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
