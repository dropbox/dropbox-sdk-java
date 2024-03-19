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
 * Changed membership type (limited/full) of member.
 */
public class MemberChangeMembershipTypeDetails {
    // struct team_log.MemberChangeMembershipTypeDetails (team_log_generated.stone)

    @Nonnull
    protected final TeamMembershipType prevValue;
    @Nonnull
    protected final TeamMembershipType newValue;

    /**
     * Changed membership type (limited/full) of member.
     *
     * @param prevValue  Previous membership type. Must not be {@code null}.
     * @param newValue  New membership type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberChangeMembershipTypeDetails(@Nonnull TeamMembershipType prevValue, @Nonnull TeamMembershipType newValue) {
        if (prevValue == null) {
            throw new IllegalArgumentException("Required value for 'prevValue' is null");
        }
        this.prevValue = prevValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
    }

    /**
     * Previous membership type.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TeamMembershipType getPrevValue() {
        return prevValue;
    }

    /**
     * New membership type.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TeamMembershipType getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            prevValue,
            newValue
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
            MemberChangeMembershipTypeDetails other = (MemberChangeMembershipTypeDetails) obj;
            return ((this.prevValue == other.prevValue) || (this.prevValue.equals(other.prevValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                ;
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
    static class Serializer extends StructSerializer<MemberChangeMembershipTypeDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberChangeMembershipTypeDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("prev_value");
            TeamMembershipType.Serializer.INSTANCE.serialize(value.prevValue, g);
            g.writeFieldName("new_value");
            TeamMembershipType.Serializer.INSTANCE.serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberChangeMembershipTypeDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberChangeMembershipTypeDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMembershipType f_prevValue = null;
                TeamMembershipType f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("prev_value".equals(field)) {
                        f_prevValue = TeamMembershipType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = TeamMembershipType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_prevValue == null) {
                    throw new JsonParseException(p, "Required field \"prev_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new MemberChangeMembershipTypeDetails(f_prevValue, f_newValue);
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
