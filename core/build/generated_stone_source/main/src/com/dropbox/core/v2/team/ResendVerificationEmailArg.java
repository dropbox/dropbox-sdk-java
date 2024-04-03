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

class ResendVerificationEmailArg {
    // struct team.ResendVerificationEmailArg (team_secondary_mails.stone)

    @Nonnull
    protected final List<UserSecondaryEmailsArg> emailsToResend;

    /**
     *
     * @param emailsToResend  List of users and secondary emails to resend
     *     verification emails to. Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ResendVerificationEmailArg(@Nonnull List<UserSecondaryEmailsArg> emailsToResend) {
        if (emailsToResend == null) {
            throw new IllegalArgumentException("Required value for 'emailsToResend' is null");
        }
        for (UserSecondaryEmailsArg x : emailsToResend) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'emailsToResend' is null");
            }
        }
        this.emailsToResend = emailsToResend;
    }

    /**
     * List of users and secondary emails to resend verification emails to.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<UserSecondaryEmailsArg> getEmailsToResend() {
        return emailsToResend;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.emailsToResend
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
            ResendVerificationEmailArg other = (ResendVerificationEmailArg) obj;
            return (this.emailsToResend == other.emailsToResend) || (this.emailsToResend.equals(other.emailsToResend));
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
    static class Serializer extends StructSerializer<ResendVerificationEmailArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ResendVerificationEmailArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("emails_to_resend");
            StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).serialize(value.emailsToResend, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ResendVerificationEmailArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ResendVerificationEmailArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserSecondaryEmailsArg> f_emailsToResend = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("emails_to_resend".equals(field)) {
                        f_emailsToResend = StoneSerializers.list(UserSecondaryEmailsArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_emailsToResend == null) {
                    throw new JsonParseException(p, "Required field \"emails_to_resend\" missing.");
                }
                value = new ResendVerificationEmailArg(f_emailsToResend);
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
