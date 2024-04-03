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
 * Suggested person to add to team.
 */
public class MemberSuggestDetails {
    // struct team_log.MemberSuggestDetails (team_log_generated.stone)

    @Nonnull
    protected final List<String> suggestedMembers;

    /**
     * Suggested person to add to team.
     *
     * @param suggestedMembers  suggested users emails. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberSuggestDetails(@Nonnull List<String> suggestedMembers) {
        if (suggestedMembers == null) {
            throw new IllegalArgumentException("Required value for 'suggestedMembers' is null");
        }
        for (String x : suggestedMembers) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'suggestedMembers' is null");
            }
            if (x.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list 'suggestedMembers' is longer than 255");
            }
        }
        this.suggestedMembers = suggestedMembers;
    }

    /**
     * suggested users emails.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getSuggestedMembers() {
        return suggestedMembers;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.suggestedMembers
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
            MemberSuggestDetails other = (MemberSuggestDetails) obj;
            return (this.suggestedMembers == other.suggestedMembers) || (this.suggestedMembers.equals(other.suggestedMembers));
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
    static class Serializer extends StructSerializer<MemberSuggestDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberSuggestDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("suggested_members");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.suggestedMembers, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberSuggestDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberSuggestDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_suggestedMembers = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("suggested_members".equals(field)) {
                        f_suggestedMembers = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_suggestedMembers == null) {
                    throw new JsonParseException(p, "Required field \"suggested_members\" missing.");
                }
                value = new MemberSuggestDetails(f_suggestedMembers);
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
