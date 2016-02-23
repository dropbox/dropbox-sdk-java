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
 * Policies governing sharing within and outside of the team.
 */
public class TeamSharingPolicies {
    // struct TeamSharingPolicies

    private final SharedFolderMemberPolicy sharedFolderMemberPolicy;
    private final SharedFolderJoinPolicy sharedFolderJoinPolicy;

    /**
     * Policies governing sharing within and outside of the team.
     *
     * @param sharedFolderMemberPolicy  Who can join folders shared by team
     *     members. Must not be {@code null}.
     * @param sharedFolderJoinPolicy  Which shared folders team members can
     *     join. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamSharingPolicies(SharedFolderMemberPolicy sharedFolderMemberPolicy, SharedFolderJoinPolicy sharedFolderJoinPolicy) {
        if (sharedFolderMemberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderMemberPolicy' is null");
        }
        this.sharedFolderMemberPolicy = sharedFolderMemberPolicy;
        if (sharedFolderJoinPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderJoinPolicy' is null");
        }
        this.sharedFolderJoinPolicy = sharedFolderJoinPolicy;
    }

    /**
     * Who can join folders shared by team members.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedFolderMemberPolicy getSharedFolderMemberPolicy() {
        return sharedFolderMemberPolicy;
    }

    /**
     * Which shared folders team members can join.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedFolderJoinPolicy getSharedFolderJoinPolicy() {
        return sharedFolderJoinPolicy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderMemberPolicy,
            sharedFolderJoinPolicy
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
            TeamSharingPolicies other = (TeamSharingPolicies) obj;
            return ((this.sharedFolderMemberPolicy == other.sharedFolderMemberPolicy) || (this.sharedFolderMemberPolicy.equals(other.sharedFolderMemberPolicy)))
                && ((this.sharedFolderJoinPolicy == other.sharedFolderJoinPolicy) || (this.sharedFolderJoinPolicy.equals(other.sharedFolderJoinPolicy)))
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

    public static TeamSharingPolicies fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TeamSharingPolicies> _JSON_WRITER = new JsonWriter<TeamSharingPolicies>() {
        public final void write(TeamSharingPolicies x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            TeamSharingPolicies._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(TeamSharingPolicies x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_member_policy");
            SharedFolderMemberPolicy._JSON_WRITER.write(x.sharedFolderMemberPolicy, g);
            g.writeFieldName("shared_folder_join_policy");
            SharedFolderJoinPolicy._JSON_WRITER.write(x.sharedFolderJoinPolicy, g);
        }
    };

    public static final JsonReader<TeamSharingPolicies> _JSON_READER = new JsonReader<TeamSharingPolicies>() {
        public final TeamSharingPolicies read(JsonParser parser) throws IOException, JsonReadException {
            TeamSharingPolicies result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final TeamSharingPolicies readFields(JsonParser parser) throws IOException, JsonReadException {
            SharedFolderMemberPolicy sharedFolderMemberPolicy = null;
            SharedFolderJoinPolicy sharedFolderJoinPolicy = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_member_policy".equals(fieldName)) {
                    sharedFolderMemberPolicy = SharedFolderMemberPolicy._JSON_READER
                        .readField(parser, "shared_folder_member_policy", sharedFolderMemberPolicy);
                }
                else if ("shared_folder_join_policy".equals(fieldName)) {
                    sharedFolderJoinPolicy = SharedFolderJoinPolicy._JSON_READER
                        .readField(parser, "shared_folder_join_policy", sharedFolderJoinPolicy);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderMemberPolicy == null) {
                throw new JsonReadException("Required field \"shared_folder_member_policy\" is missing.", parser.getTokenLocation());
            }
            if (sharedFolderJoinPolicy == null) {
                throw new JsonReadException("Required field \"shared_folder_join_policy\" is missing.", parser.getTokenLocation());
            }
            return new TeamSharingPolicies(sharedFolderMemberPolicy, sharedFolderJoinPolicy);
        }
    };
}
