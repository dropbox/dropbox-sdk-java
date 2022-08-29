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

class AddSecondaryEmailsArg {
    // struct team.AddSecondaryEmailsArg (team_secondary_mails.stone)

    protected final List<UserSecondaryEmailsArg> newSecondaryEmails;

    /**
     *
     * @param newSecondaryEmails  List of users and secondary emails to add.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddSecondaryEmailsArg(List<UserSecondaryEmailsArg> newSecondaryEmails) {
        if (newSecondaryEmails == null) {
            throw new IllegalArgumentException("Required value for 'newSecondaryEmails' is null");
        }
        for (UserSecondaryEmailsArg x : newSecondaryEmails) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'newSecondaryEmails' is null");
            }
        }
        this.newSecondaryEmails = newSecondaryEmails;
    }

    /**
     * List of users and secondary emails to add.
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserSecondaryEmailsArg> getNewSecondaryEmails() {
        return newSecondaryEmails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            newSecondaryEmails
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
            AddSecondaryEmailsArg other = (AddSecondaryEmailsArg) obj;
            return (this.newSecondaryEmails == other.newSecondaryEmails) || (this.newSecondaryEmails.equals(other.newSecondaryEmails));
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
    static class Serializer extends StructSerializer<AddSecondaryEmailsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddSecondaryEmailsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_secondary_emails");
            StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).serialize(value.newSecondaryEmails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AddSecondaryEmailsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AddSecondaryEmailsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserSecondaryEmailsArg> f_newSecondaryEmails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_secondary_emails".equals(field)) {
                        f_newSecondaryEmails = StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newSecondaryEmails == null) {
                    throw new JsonParseException(p, "Required field \"new_secondary_emails\" missing.");
                }
                value = new AddSecondaryEmailsArg(f_newSecondaryEmails);
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
