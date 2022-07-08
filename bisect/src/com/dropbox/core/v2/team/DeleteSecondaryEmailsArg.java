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

class DeleteSecondaryEmailsArg {
    // struct team.DeleteSecondaryEmailsArg (team_secondary_mails.stone)

    protected final List<UserSecondaryEmailsArg> emailsToDelete;

    /**
     *
     * @param emailsToDelete  List of users and their secondary emails to
     *     delete. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteSecondaryEmailsArg(List<UserSecondaryEmailsArg> emailsToDelete) {
        if (emailsToDelete == null) {
            throw new IllegalArgumentException("Required value for 'emailsToDelete' is null");
        }
        for (UserSecondaryEmailsArg x : emailsToDelete) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'emailsToDelete' is null");
            }
        }
        this.emailsToDelete = emailsToDelete;
    }

    /**
     * List of users and their secondary emails to delete.
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserSecondaryEmailsArg> getEmailsToDelete() {
        return emailsToDelete;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            emailsToDelete
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
            DeleteSecondaryEmailsArg other = (DeleteSecondaryEmailsArg) obj;
            return (this.emailsToDelete == other.emailsToDelete) || (this.emailsToDelete.equals(other.emailsToDelete));
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
    static class Serializer extends StructSerializer<DeleteSecondaryEmailsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteSecondaryEmailsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("emails_to_delete");
            StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).serialize(value.emailsToDelete, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeleteSecondaryEmailsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeleteSecondaryEmailsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserSecondaryEmailsArg> f_emailsToDelete = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("emails_to_delete".equals(field)) {
                        f_emailsToDelete = StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_emailsToDelete == null) {
                    throw new JsonParseException(p, "Required field \"emails_to_delete\" missing.");
                }
                value = new DeleteSecondaryEmailsArg(f_emailsToDelete);
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
