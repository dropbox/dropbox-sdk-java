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
import javax.annotation.Nullable;

/**
 * Received files via Email to Dropbox.
 */
public class EmailIngestReceiveFileDetails {
    // struct team_log.EmailIngestReceiveFileDetails (team_log_generated.stone)

    protected final String inboxName;
    protected final List<String> attachmentNames;
    protected final String subject;
    protected final String fromName;
    protected final String fromEmail;

    /**
     * Received files via Email to Dropbox.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param inboxName  Inbox name. Must not be {@code null}.
     * @param attachmentNames  Submitted file names. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param subject  Subject of the email.
     * @param fromName  The name as provided by the submitter.
     * @param fromEmail  The email as provided by the submitter. Must have
     *     length of at most 255.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public EmailIngestReceiveFileDetails(@Nonnull String inboxName, @Nonnull List<String> attachmentNames, @Nullable String subject, @Nullable String fromName, @Nullable String fromEmail) {
        if (inboxName == null) {
            throw new IllegalArgumentException("Required value for 'inboxName' is null");
        }
        this.inboxName = inboxName;
        if (attachmentNames == null) {
            throw new IllegalArgumentException("Required value for 'attachmentNames' is null");
        }
        for (String x : attachmentNames) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'attachmentNames' is null");
            }
        }
        this.attachmentNames = attachmentNames;
        this.subject = subject;
        this.fromName = fromName;
        if (fromEmail != null) {
            if (fromEmail.length() > 255) {
                throw new IllegalArgumentException("String 'fromEmail' is longer than 255");
            }
        }
        this.fromEmail = fromEmail;
    }

    /**
     * Received files via Email to Dropbox.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param inboxName  Inbox name. Must not be {@code null}.
     * @param attachmentNames  Submitted file names. Must not contain a {@code
     *     null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public EmailIngestReceiveFileDetails(@Nonnull String inboxName, @Nonnull List<String> attachmentNames) {
        this(inboxName, attachmentNames, null, null, null);
    }

    /**
     * Inbox name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getInboxName() {
        return inboxName;
    }

    /**
     * Submitted file names.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getAttachmentNames() {
        return attachmentNames;
    }

    /**
     * Subject of the email.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSubject() {
        return subject;
    }

    /**
     * The name as provided by the submitter.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getFromName() {
        return fromName;
    }

    /**
     * The email as provided by the submitter.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getFromEmail() {
        return fromEmail;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param inboxName  Inbox name. Must not be {@code null}.
     * @param attachmentNames  Submitted file names. Must not contain a {@code
     *     null} item and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String inboxName, List<String> attachmentNames) {
        return new Builder(inboxName, attachmentNames);
    }

    /**
     * Builder for {@link EmailIngestReceiveFileDetails}.
     */
    public static class Builder {
        protected final String inboxName;
        protected final List<String> attachmentNames;

        protected String subject;
        protected String fromName;
        protected String fromEmail;

        protected Builder(String inboxName, List<String> attachmentNames) {
            if (inboxName == null) {
                throw new IllegalArgumentException("Required value for 'inboxName' is null");
            }
            this.inboxName = inboxName;
            if (attachmentNames == null) {
                throw new IllegalArgumentException("Required value for 'attachmentNames' is null");
            }
            for (String x : attachmentNames) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'attachmentNames' is null");
                }
            }
            this.attachmentNames = attachmentNames;
            this.subject = null;
            this.fromName = null;
            this.fromEmail = null;
        }

        /**
         * Set value for optional field.
         *
         * @param subject  Subject of the email.
         *
         * @return this builder
         */
        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fromName  The name as provided by the submitter.
         *
         * @return this builder
         */
        public Builder withFromName(String fromName) {
            this.fromName = fromName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fromEmail  The email as provided by the submitter. Must have
         *     length of at most 255.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFromEmail(String fromEmail) {
            if (fromEmail != null) {
                if (fromEmail.length() > 255) {
                    throw new IllegalArgumentException("String 'fromEmail' is longer than 255");
                }
            }
            this.fromEmail = fromEmail;
            return this;
        }

        /**
         * Builds an instance of {@link EmailIngestReceiveFileDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link EmailIngestReceiveFileDetails}
         */
        public EmailIngestReceiveFileDetails build() {
            return new EmailIngestReceiveFileDetails(inboxName, attachmentNames, subject, fromName, fromEmail);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            inboxName,
            attachmentNames,
            subject,
            fromName,
            fromEmail
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
            EmailIngestReceiveFileDetails other = (EmailIngestReceiveFileDetails) obj;
            return ((this.inboxName == other.inboxName) || (this.inboxName.equals(other.inboxName)))
                && ((this.attachmentNames == other.attachmentNames) || (this.attachmentNames.equals(other.attachmentNames)))
                && ((this.subject == other.subject) || (this.subject != null && this.subject.equals(other.subject)))
                && ((this.fromName == other.fromName) || (this.fromName != null && this.fromName.equals(other.fromName)))
                && ((this.fromEmail == other.fromEmail) || (this.fromEmail != null && this.fromEmail.equals(other.fromEmail)))
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
    static class Serializer extends StructSerializer<EmailIngestReceiveFileDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(EmailIngestReceiveFileDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("inbox_name");
            StoneSerializers.string().serialize(value.inboxName, g);
            g.writeFieldName("attachment_names");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.attachmentNames, g);
            if (value.subject != null) {
                g.writeFieldName("subject");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.subject, g);
            }
            if (value.fromName != null) {
                g.writeFieldName("from_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.fromName, g);
            }
            if (value.fromEmail != null) {
                g.writeFieldName("from_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.fromEmail, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public EmailIngestReceiveFileDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            EmailIngestReceiveFileDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_inboxName = null;
                List<String> f_attachmentNames = null;
                String f_subject = null;
                String f_fromName = null;
                String f_fromEmail = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("inbox_name".equals(field)) {
                        f_inboxName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("attachment_names".equals(field)) {
                        f_attachmentNames = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("subject".equals(field)) {
                        f_subject = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("from_name".equals(field)) {
                        f_fromName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("from_email".equals(field)) {
                        f_fromEmail = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_inboxName == null) {
                    throw new JsonParseException(p, "Required field \"inbox_name\" missing.");
                }
                if (f_attachmentNames == null) {
                    throw new JsonParseException(p, "Required field \"attachment_names\" missing.");
                }
                value = new EmailIngestReceiveFileDetails(f_inboxName, f_attachmentNames, f_subject, f_fromName, f_fromEmail);
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
