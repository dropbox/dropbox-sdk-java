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

import javax.annotation.Nonnull;

/**
 * Sent a team merge request reminder.
 */
public class TeamMergeRequestReminderDetails {
    // struct team_log.TeamMergeRequestReminderDetails (team_log_generated.stone)

    protected final TeamMergeRequestReminderExtraDetails requestReminderDetails;

    /**
     * Sent a team merge request reminder.
     *
     * @param requestReminderDetails  Team merge request reminder details. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMergeRequestReminderDetails(@Nonnull TeamMergeRequestReminderExtraDetails requestReminderDetails) {
        if (requestReminderDetails == null) {
            throw new IllegalArgumentException("Required value for 'requestReminderDetails' is null");
        }
        this.requestReminderDetails = requestReminderDetails;
    }

    /**
     * Team merge request reminder details.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TeamMergeRequestReminderExtraDetails getRequestReminderDetails() {
        return requestReminderDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            requestReminderDetails
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
            TeamMergeRequestReminderDetails other = (TeamMergeRequestReminderDetails) obj;
            return (this.requestReminderDetails == other.requestReminderDetails) || (this.requestReminderDetails.equals(other.requestReminderDetails));
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
    static class Serializer extends StructSerializer<TeamMergeRequestReminderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMergeRequestReminderDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("request_reminder_details");
            TeamMergeRequestReminderExtraDetails.Serializer.INSTANCE.serialize(value.requestReminderDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMergeRequestReminderDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMergeRequestReminderDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMergeRequestReminderExtraDetails f_requestReminderDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("request_reminder_details".equals(field)) {
                        f_requestReminderDetails = TeamMergeRequestReminderExtraDetails.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_requestReminderDetails == null) {
                    throw new JsonParseException(p, "Required field \"request_reminder_details\" missing.");
                }
                value = new TeamMergeRequestReminderDetails(f_requestReminderDetails);
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
