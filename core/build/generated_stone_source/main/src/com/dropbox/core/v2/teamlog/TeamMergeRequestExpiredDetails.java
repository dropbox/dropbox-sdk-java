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
 * Team merge request expired.
 */
public class TeamMergeRequestExpiredDetails {
    // struct team_log.TeamMergeRequestExpiredDetails (team_log_generated.stone)

    protected final TeamMergeRequestExpiredExtraDetails requestExpiredDetails;

    /**
     * Team merge request expired.
     *
     * @param requestExpiredDetails  Team merge request expiration details. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMergeRequestExpiredDetails(TeamMergeRequestExpiredExtraDetails requestExpiredDetails) {
        if (requestExpiredDetails == null) {
            throw new IllegalArgumentException("Required value for 'requestExpiredDetails' is null");
        }
        this.requestExpiredDetails = requestExpiredDetails;
    }

    /**
     * Team merge request expiration details.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamMergeRequestExpiredExtraDetails getRequestExpiredDetails() {
        return requestExpiredDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            requestExpiredDetails
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
            TeamMergeRequestExpiredDetails other = (TeamMergeRequestExpiredDetails) obj;
            return (this.requestExpiredDetails == other.requestExpiredDetails) || (this.requestExpiredDetails.equals(other.requestExpiredDetails));
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
    static class Serializer extends StructSerializer<TeamMergeRequestExpiredDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMergeRequestExpiredDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("request_expired_details");
            TeamMergeRequestExpiredExtraDetails.Serializer.INSTANCE.serialize(value.requestExpiredDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMergeRequestExpiredDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMergeRequestExpiredDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMergeRequestExpiredExtraDetails f_requestExpiredDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("request_expired_details".equals(field)) {
                        f_requestExpiredDetails = TeamMergeRequestExpiredExtraDetails.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_requestExpiredDetails == null) {
                    throw new JsonParseException(p, "Required field \"request_expired_details\" missing.");
                }
                value = new TeamMergeRequestExpiredDetails(f_requestExpiredDetails);
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
