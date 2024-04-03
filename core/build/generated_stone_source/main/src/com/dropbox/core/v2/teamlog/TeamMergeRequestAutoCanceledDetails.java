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
import javax.annotation.Nullable;

/**
 * Automatically canceled team merge request.
 */
public class TeamMergeRequestAutoCanceledDetails {
    // struct team_log.TeamMergeRequestAutoCanceledDetails (team_log_generated.stone)

    @Nullable
    protected final String details;

    /**
     * Automatically canceled team merge request.
     *
     * @param details  The cancellation reason.
     */
    public TeamMergeRequestAutoCanceledDetails(@Nullable String details) {
        this.details = details;
    }

    /**
     * Automatically canceled team merge request.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public TeamMergeRequestAutoCanceledDetails() {
        this(null);
    }

    /**
     * The cancellation reason.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDetails() {
        return details;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.details
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
            TeamMergeRequestAutoCanceledDetails other = (TeamMergeRequestAutoCanceledDetails) obj;
            return (this.details == other.details) || (this.details != null && this.details.equals(other.details));
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
    static class Serializer extends StructSerializer<TeamMergeRequestAutoCanceledDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMergeRequestAutoCanceledDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.details != null) {
                g.writeFieldName("details");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.details, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMergeRequestAutoCanceledDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMergeRequestAutoCanceledDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_details = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("details".equals(field)) {
                        f_details = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new TeamMergeRequestAutoCanceledDetails(f_details);
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
