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
 * Team merge request expiration details shown to the secondary team
 */
public class SecondaryTeamRequestExpiredDetails {
    // struct team_log.SecondaryTeamRequestExpiredDetails (team_log_generated.stone)

    protected final String sentTo;

    /**
     * Team merge request expiration details shown to the secondary team
     *
     * @param sentTo  The email of the primary team admin the request was sent
     *     to. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SecondaryTeamRequestExpiredDetails(String sentTo) {
        if (sentTo == null) {
            throw new IllegalArgumentException("Required value for 'sentTo' is null");
        }
        this.sentTo = sentTo;
    }

    /**
     * The email of the primary team admin the request was sent to.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSentTo() {
        return sentTo;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sentTo
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
            SecondaryTeamRequestExpiredDetails other = (SecondaryTeamRequestExpiredDetails) obj;
            return (this.sentTo == other.sentTo) || (this.sentTo.equals(other.sentTo));
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
    static class Serializer extends StructSerializer<SecondaryTeamRequestExpiredDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SecondaryTeamRequestExpiredDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("sent_to");
            StoneSerializers.string().serialize(value.sentTo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SecondaryTeamRequestExpiredDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SecondaryTeamRequestExpiredDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sentTo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("sent_to".equals(field)) {
                        f_sentTo = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sentTo == null) {
                    throw new JsonParseException(p, "Required field \"sent_to\" missing.");
                }
                value = new SecondaryTeamRequestExpiredDetails(f_sentTo);
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
