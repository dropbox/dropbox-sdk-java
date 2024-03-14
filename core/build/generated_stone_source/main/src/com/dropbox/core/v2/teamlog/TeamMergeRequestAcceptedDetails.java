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
 * Accepted a team merge request.
 */
public class TeamMergeRequestAcceptedDetails {
    // struct team_log.TeamMergeRequestAcceptedDetails (team_log_generated.stone)

    protected final TeamMergeRequestAcceptedExtraDetails requestAcceptedDetails;

    /**
     * Accepted a team merge request.
     *
     * @param requestAcceptedDetails  Team merge request acceptance details.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMergeRequestAcceptedDetails(TeamMergeRequestAcceptedExtraDetails requestAcceptedDetails) {
        if (requestAcceptedDetails == null) {
            throw new IllegalArgumentException("Required value for 'requestAcceptedDetails' is null");
        }
        this.requestAcceptedDetails = requestAcceptedDetails;
    }

    /**
     * Team merge request acceptance details.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamMergeRequestAcceptedExtraDetails getRequestAcceptedDetails() {
        return requestAcceptedDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            requestAcceptedDetails
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
            TeamMergeRequestAcceptedDetails other = (TeamMergeRequestAcceptedDetails) obj;
            return (this.requestAcceptedDetails == other.requestAcceptedDetails) || (this.requestAcceptedDetails.equals(other.requestAcceptedDetails));
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
    static class Serializer extends StructSerializer<TeamMergeRequestAcceptedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMergeRequestAcceptedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("request_accepted_details");
            TeamMergeRequestAcceptedExtraDetails.Serializer.INSTANCE.serialize(value.requestAcceptedDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMergeRequestAcceptedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMergeRequestAcceptedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMergeRequestAcceptedExtraDetails f_requestAcceptedDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("request_accepted_details".equals(field)) {
                        f_requestAcceptedDetails = TeamMergeRequestAcceptedExtraDetails.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_requestAcceptedDetails == null) {
                    throw new JsonParseException(p, "Required field \"request_accepted_details\" missing.");
                }
                value = new TeamMergeRequestAcceptedDetails(f_requestAcceptedDetails);
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
