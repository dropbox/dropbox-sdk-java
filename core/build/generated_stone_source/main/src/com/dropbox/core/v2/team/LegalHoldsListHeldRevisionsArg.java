/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

package com.dropbox.core.v2.team;

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
import java.util.regex.Pattern;

class LegalHoldsListHeldRevisionsArg {
    // struct team.LegalHoldsListHeldRevisionsArg (team_legal_holds.stone)

    protected final String id;

    /**
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionsArg(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
    }

    /**
     * The legal hold Id.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id
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
            LegalHoldsListHeldRevisionsArg other = (LegalHoldsListHeldRevisionsArg) obj;
            return (this.id == other.id) || (this.id.equals(other.id));
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
    static class Serializer extends StructSerializer<LegalHoldsListHeldRevisionsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsListHeldRevisionsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsListHeldRevisionsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsListHeldRevisionsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                value = new LegalHoldsListHeldRevisionsArg(f_id);
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
