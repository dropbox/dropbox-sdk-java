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
 * Recipients Configuration
 */
public class RecipientsConfiguration {
    // struct team_log.RecipientsConfiguration (team_log_generated.stone)

    @Nullable
    protected final AlertRecipientsSettingType recipientSettingType;
    @Nullable
    protected final List<String> emails;
    @Nullable
    protected final List<String> groups;

    /**
     * Recipients Configuration
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param recipientSettingType  Recipients setting type.
     * @param emails  A list of user emails to notify. Must not contain a {@code
     *     null} item.
     * @param groups  A list of groups to notify. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RecipientsConfiguration(@Nullable AlertRecipientsSettingType recipientSettingType, @Nullable List<String> emails, @Nullable List<String> groups) {
        this.recipientSettingType = recipientSettingType;
        if (emails != null) {
            for (String x : emails) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'emails' is null");
                }
                if (x.length() > 255) {
                    throw new IllegalArgumentException("Stringan item in list 'emails' is longer than 255");
                }
            }
        }
        this.emails = emails;
        if (groups != null) {
            for (String x : groups) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'groups' is null");
                }
            }
        }
        this.groups = groups;
    }

    /**
     * Recipients Configuration
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public RecipientsConfiguration() {
        this(null, null, null);
    }

    /**
     * Recipients setting type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AlertRecipientsSettingType getRecipientSettingType() {
        return recipientSettingType;
    }

    /**
     * A list of user emails to notify.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getEmails() {
        return emails;
    }

    /**
     * A list of groups to notify.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link RecipientsConfiguration}.
     */
    public static class Builder {

        protected AlertRecipientsSettingType recipientSettingType;
        protected List<String> emails;
        protected List<String> groups;

        protected Builder() {
            this.recipientSettingType = null;
            this.emails = null;
            this.groups = null;
        }

        /**
         * Set value for optional field.
         *
         * @param recipientSettingType  Recipients setting type.
         *
         * @return this builder
         */
        public Builder withRecipientSettingType(AlertRecipientsSettingType recipientSettingType) {
            this.recipientSettingType = recipientSettingType;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param emails  A list of user emails to notify. Must not contain a
         *     {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withEmails(List<String> emails) {
            if (emails != null) {
                for (String x : emails) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'emails' is null");
                    }
                    if (x.length() > 255) {
                        throw new IllegalArgumentException("Stringan item in list 'emails' is longer than 255");
                    }
                }
            }
            this.emails = emails;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param groups  A list of groups to notify. Must not contain a {@code
         *     null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withGroups(List<String> groups) {
            if (groups != null) {
                for (String x : groups) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'groups' is null");
                    }
                }
            }
            this.groups = groups;
            return this;
        }

        /**
         * Builds an instance of {@link RecipientsConfiguration} configured with
         * this builder's values
         *
         * @return new instance of {@link RecipientsConfiguration}
         */
        public RecipientsConfiguration build() {
            return new RecipientsConfiguration(recipientSettingType, emails, groups);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            recipientSettingType,
            emails,
            groups
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
            RecipientsConfiguration other = (RecipientsConfiguration) obj;
            return ((this.recipientSettingType == other.recipientSettingType) || (this.recipientSettingType != null && this.recipientSettingType.equals(other.recipientSettingType)))
                && ((this.emails == other.emails) || (this.emails != null && this.emails.equals(other.emails)))
                && ((this.groups == other.groups) || (this.groups != null && this.groups.equals(other.groups)))
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
    static class Serializer extends StructSerializer<RecipientsConfiguration> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RecipientsConfiguration value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.recipientSettingType != null) {
                g.writeFieldName("recipient_setting_type");
                StoneSerializers.nullable(AlertRecipientsSettingType.Serializer.INSTANCE).serialize(value.recipientSettingType, g);
            }
            if (value.emails != null) {
                g.writeFieldName("emails");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.emails, g);
            }
            if (value.groups != null) {
                g.writeFieldName("groups");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.groups, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RecipientsConfiguration deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RecipientsConfiguration value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AlertRecipientsSettingType f_recipientSettingType = null;
                List<String> f_emails = null;
                List<String> f_groups = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("recipient_setting_type".equals(field)) {
                        f_recipientSettingType = StoneSerializers.nullable(AlertRecipientsSettingType.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("emails".equals(field)) {
                        f_emails = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else if ("groups".equals(field)) {
                        f_groups = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new RecipientsConfiguration(f_recipientSettingType, f_emails, f_groups);
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
