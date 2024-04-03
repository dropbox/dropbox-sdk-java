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

import javax.annotation.Nonnull;

/**
 * User and a list of secondary emails.
 */
public class UserSecondaryEmailsArg {
    // struct team.UserSecondaryEmailsArg (team_secondary_mails.stone)

    @Nonnull
    protected final UserSelectorArg user;
    @Nonnull
    protected final List<String> secondaryEmails;

    /**
     * User and a list of secondary emails.
     *
     * @param user  Must not be {@code null}.
     * @param secondaryEmails  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserSecondaryEmailsArg(@Nonnull UserSelectorArg user, @Nonnull List<String> secondaryEmails) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (secondaryEmails == null) {
            throw new IllegalArgumentException("Required value for 'secondaryEmails' is null");
        }
        for (String x : secondaryEmails) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'secondaryEmails' is null");
            }
            if (x.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list 'secondaryEmails' is longer than 255");
            }
            if (!java.util.regex.Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", x)) {
                throw new IllegalArgumentException("Stringan item in list 'secondaryEmails' does not match pattern");
            }
        }
        this.secondaryEmails = secondaryEmails;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getSecondaryEmails() {
        return secondaryEmails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.user,
            this.secondaryEmails
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
            UserSecondaryEmailsArg other = (UserSecondaryEmailsArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.secondaryEmails == other.secondaryEmails) || (this.secondaryEmails.equals(other.secondaryEmails)))
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
    static class Serializer extends StructSerializer<UserSecondaryEmailsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserSecondaryEmailsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("secondary_emails");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.secondaryEmails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserSecondaryEmailsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserSecondaryEmailsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                List<String> f_secondaryEmails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("secondary_emails".equals(field)) {
                        f_secondaryEmails = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_secondaryEmails == null) {
                    throw new JsonParseException(p, "Required field \"secondary_emails\" missing.");
                }
                value = new UserSecondaryEmailsArg(f_user, f_secondaryEmails);
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
