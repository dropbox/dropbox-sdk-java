/* DO NOT EDIT */
/* This file was generated from team_secondary_mails.stone */

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

public class UserResendEmailsResult {
    // struct team.UserResendEmailsResult (team_secondary_mails.stone)

    protected final UserSelectorArg user;
    protected final List<ResendSecondaryEmailResult> results;

    /**
     *
     * @param user  Must not be {@code null}.
     * @param results  Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserResendEmailsResult(UserSelectorArg user, List<ResendSecondaryEmailResult> results) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (results == null) {
            throw new IllegalArgumentException("Required value for 'results' is null");
        }
        for (ResendSecondaryEmailResult x : results) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'results' is null");
            }
        }
        this.results = results;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<ResendSecondaryEmailResult> getResults() {
        return results;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            user,
            results
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
            UserResendEmailsResult other = (UserResendEmailsResult) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.results == other.results) || (this.results.equals(other.results)))
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
    static class Serializer extends StructSerializer<UserResendEmailsResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserResendEmailsResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("results");
            StoneSerializers.list(ResendSecondaryEmailResult.Serializer.INSTANCE).serialize(value.results, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserResendEmailsResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserResendEmailsResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                List<ResendSecondaryEmailResult> f_results = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("results".equals(field)) {
                        f_results = StoneSerializers.list(ResendSecondaryEmailResult.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_results == null) {
                    throw new JsonParseException(p, "Required field \"results\" missing.");
                }
                value = new UserResendEmailsResult(f_user, f_results);
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
