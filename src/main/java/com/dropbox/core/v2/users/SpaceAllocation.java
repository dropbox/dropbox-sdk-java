/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Space is allocated differently based on the type of account.
 */
public final class SpaceAllocation {
    // union SpaceAllocation

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
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("individual", Tag.INDIVIDUAL);
        VALUES_.put("team", Tag.TEAM);
        VALUES_.put("other", Tag.OTHER);
    }

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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code SpaceAllocation}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link SpaceAllocation#individual} value to assign to this
     *     instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#TEAM},
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
     * @param value  {@link SpaceAllocation#team} value to assign to this
     *     instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SpaceAllocation fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SpaceAllocation> _JSON_WRITER = new JsonWriter<SpaceAllocation>() {
        public final void write(SpaceAllocation x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case INDIVIDUAL:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("individual");
                    g.writeFieldName("individual");
                    IndividualSpaceAllocation._JSON_WRITER.write(x.getIndividualValue(), g);
                    g.writeEndObject();
                    break;
                case TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team");
                    g.writeFieldName("team");
                    TeamSpaceAllocation._JSON_WRITER.write(x.getTeamValue(), g);
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<SpaceAllocation> _JSON_READER = new JsonReader<SpaceAllocation>() {

        public final SpaceAllocation read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return SpaceAllocation.OTHER;
                }
                switch (tag) {
                    case OTHER: return SpaceAllocation.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            SpaceAllocation value = null;
            if (tag != null) {
                switch (tag) {
                    case INDIVIDUAL: {
                        IndividualSpaceAllocation v = null;
                        v = IndividualSpaceAllocation._JSON_READER.readFields(parser);
                        value = SpaceAllocation.individual(v);
                        break;
                    }
                    case TEAM: {
                        TeamSpaceAllocation v = null;
                        v = TeamSpaceAllocation._JSON_READER.readFields(parser);
                        value = SpaceAllocation.team(v);
                        break;
                    }
                    case OTHER: {
                        value = SpaceAllocation.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return SpaceAllocation.OTHER;
            }
            return value;
        }

    };
}
