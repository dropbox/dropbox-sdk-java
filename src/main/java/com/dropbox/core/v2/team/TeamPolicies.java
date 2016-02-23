/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Policies governing team members.
 */
public class TeamPolicies {
    // struct TeamPolicies

    private final TeamSharingPolicies sharing;
    private final EmmState emmState;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static TeamPolicies fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TeamPolicies> _JSON_WRITER = new JsonWriter<TeamPolicies>() {
        public final void write(TeamPolicies x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            TeamPolicies._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(TeamPolicies x, JsonGenerator g) throws IOException {
            g.writeFieldName("sharing");
            TeamSharingPolicies._JSON_WRITER.write(x.sharing, g);
            g.writeFieldName("emm_state");
            EmmState._JSON_WRITER.write(x.emmState, g);
        }
    };

    public static final JsonReader<TeamPolicies> _JSON_READER = new JsonReader<TeamPolicies>() {
        public final TeamPolicies read(JsonParser parser) throws IOException, JsonReadException {
            TeamPolicies result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final TeamPolicies readFields(JsonParser parser) throws IOException, JsonReadException {
            TeamSharingPolicies sharing = null;
            EmmState emmState = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("sharing".equals(fieldName)) {
                    sharing = TeamSharingPolicies._JSON_READER
                        .readField(parser, "sharing", sharing);
                }
                else if ("emm_state".equals(fieldName)) {
                    emmState = EmmState._JSON_READER
                        .readField(parser, "emm_state", emmState);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharing == null) {
                throw new JsonReadException("Required field \"sharing\" is missing.", parser.getTokenLocation());
            }
            if (emmState == null) {
                throw new JsonReadException("Required field \"emm_state\" is missing.", parser.getTokenLocation());
            }
            return new TeamPolicies(sharing, emmState);
        }
    };
}
