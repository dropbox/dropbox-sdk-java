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
 * Canceled a team merge request.
 */
public class TeamMergeRequestCanceledDetails {
    // struct team_log.TeamMergeRequestCanceledDetails (team_log_generated.stone)

    protected final TeamMergeRequestCanceledExtraDetails requestCanceledDetails;

    /**
     * Canceled a team merge request.
     *
     * @param requestCanceledDetails  Team merge request cancellation details.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMergeRequestCanceledDetails(@javax.annotation.Nonnull TeamMergeRequestCanceledExtraDetails requestCanceledDetails) {
        if (requestCanceledDetails == null) {
            throw new IllegalArgumentException("Required value for 'requestCanceledDetails' is null");
        }
        this.requestCanceledDetails = requestCanceledDetails;
    }

    /**
     * Team merge request cancellation details.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamMergeRequestCanceledExtraDetails getRequestCanceledDetails() {
        return requestCanceledDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            requestCanceledDetails
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
            TeamMergeRequestCanceledDetails other = (TeamMergeRequestCanceledDetails) obj;
            return (this.requestCanceledDetails == other.requestCanceledDetails) || (this.requestCanceledDetails.equals(other.requestCanceledDetails));
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
    static class Serializer extends StructSerializer<TeamMergeRequestCanceledDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMergeRequestCanceledDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("request_canceled_details");
            TeamMergeRequestCanceledExtraDetails.Serializer.INSTANCE.serialize(value.requestCanceledDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMergeRequestCanceledDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMergeRequestCanceledDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMergeRequestCanceledExtraDetails f_requestCanceledDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("request_canceled_details".equals(field)) {
                        f_requestCanceledDetails = TeamMergeRequestCanceledExtraDetails.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_requestCanceledDetails == null) {
                    throw new JsonParseException(p, "Required field \"request_canceled_details\" missing.");
                }
                value = new TeamMergeRequestCanceledDetails(f_requestCanceledDetails);
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
