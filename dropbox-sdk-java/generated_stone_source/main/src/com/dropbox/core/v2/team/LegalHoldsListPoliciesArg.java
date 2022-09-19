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

class LegalHoldsListPoliciesArg {
    // struct team.LegalHoldsListPoliciesArg (team_legal_holds.stone)

    protected final boolean includeReleased;

    /**
     *
     * @param includeReleased  Whether to return holds that were released.
     */
    public LegalHoldsListPoliciesArg(boolean includeReleased) {
        this.includeReleased = includeReleased;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public LegalHoldsListPoliciesArg() {
        this(false);
    }

    /**
     * Whether to return holds that were released.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeReleased() {
        return includeReleased;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            includeReleased
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
            LegalHoldsListPoliciesArg other = (LegalHoldsListPoliciesArg) obj;
            return this.includeReleased == other.includeReleased;
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
    static class Serializer extends StructSerializer<LegalHoldsListPoliciesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsListPoliciesArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("include_released");
            StoneSerializers.boolean_().serialize(value.includeReleased, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsListPoliciesArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsListPoliciesArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_includeReleased = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("include_released".equals(field)) {
                        f_includeReleased = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new LegalHoldsListPoliciesArg(f_includeReleased);
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
