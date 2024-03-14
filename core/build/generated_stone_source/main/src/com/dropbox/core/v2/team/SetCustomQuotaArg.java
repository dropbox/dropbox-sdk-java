/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

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
import java.util.List;

class SetCustomQuotaArg {
    // struct team.SetCustomQuotaArg (team_member_space_limits.stone)

    protected final List<UserCustomQuotaArg> usersAndQuotas;

    /**
     *
     * @param usersAndQuotas  List of users and their custom quotas. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SetCustomQuotaArg(@javax.annotation.Nonnull List<UserCustomQuotaArg> usersAndQuotas) {
        if (usersAndQuotas == null) {
            throw new IllegalArgumentException("Required value for 'usersAndQuotas' is null");
        }
        for (UserCustomQuotaArg x : usersAndQuotas) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'usersAndQuotas' is null");
            }
        }
        this.usersAndQuotas = usersAndQuotas;
    }

    /**
     * List of users and their custom quotas.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<UserCustomQuotaArg> getUsersAndQuotas() {
        return usersAndQuotas;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            usersAndQuotas
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
            SetCustomQuotaArg other = (SetCustomQuotaArg) obj;
            return (this.usersAndQuotas == other.usersAndQuotas) || (this.usersAndQuotas.equals(other.usersAndQuotas));
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
    static class Serializer extends StructSerializer<SetCustomQuotaArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SetCustomQuotaArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("users_and_quotas");
            StoneSerializers.list(UserCustomQuotaArg.Serializer.INSTANCE).serialize(value.usersAndQuotas, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SetCustomQuotaArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SetCustomQuotaArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserCustomQuotaArg> f_usersAndQuotas = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("users_and_quotas".equals(field)) {
                        f_usersAndQuotas = StoneSerializers.list(UserCustomQuotaArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_usersAndQuotas == null) {
                    throw new JsonParseException(p, "Required field \"users_and_quotas\" missing.");
                }
                value = new SetCustomQuotaArg(f_usersAndQuotas);
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
