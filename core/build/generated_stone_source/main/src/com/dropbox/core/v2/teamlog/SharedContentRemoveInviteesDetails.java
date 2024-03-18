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
import java.util.List;

import javax.annotation.Nonnull;

/**
 * Removed invitee from shared file/folder before invite was accepted.
 */
public class SharedContentRemoveInviteesDetails {
    // struct team_log.SharedContentRemoveInviteesDetails (team_log_generated.stone)

    @Nonnull
    protected final List<String> invitees;

    /**
     * Removed invitee from shared file/folder before invite was accepted.
     *
     * @param invitees  A list of invitees. Must not contain a {@code null} item
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedContentRemoveInviteesDetails(@Nonnull List<String> invitees) {
        if (invitees == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        for (String x : invitees) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
            if (x.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list 'invitees' is longer than 255");
            }
        }
        this.invitees = invitees;
    }

    /**
     * A list of invitees.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getInvitees() {
        return invitees;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            invitees
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
            SharedContentRemoveInviteesDetails other = (SharedContentRemoveInviteesDetails) obj;
            return (this.invitees == other.invitees) || (this.invitees.equals(other.invitees));
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
    static class Serializer extends StructSerializer<SharedContentRemoveInviteesDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentRemoveInviteesDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("invitees");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.invitees, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentRemoveInviteesDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentRemoveInviteesDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_invitees = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("invitees".equals(field)) {
                        f_invitees = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_invitees == null) {
                    throw new JsonParseException(p, "Required field \"invitees\" missing.");
                }
                value = new SharedContentRemoveInviteesDetails(f_invitees);
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
