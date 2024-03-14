/* DO NOT EDIT */
/* This file was generated from team_sharing_allowlist.stone */

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

class SharingAllowlistRemoveArgs {
    // struct team.SharingAllowlistRemoveArgs (team_sharing_allowlist.stone)

    protected final List<String> domains;
    protected final List<String> emails;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param domains  List of domains represented by valid string
     *     representation (RFC-1034/5). Must not contain a {@code null} item.
     * @param emails  List of emails represented by valid string representation
     *     (RFC-5322/822). Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingAllowlistRemoveArgs(List<String> domains, List<String> emails) {
        if (domains != null) {
            for (String x : domains) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'domains' is null");
                }
            }
        }
        this.domains = domains;
        if (emails != null) {
            for (String x : emails) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'emails' is null");
                }
            }
        }
        this.emails = emails;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharingAllowlistRemoveArgs() {
        this(null, null);
    }

    /**
     * List of domains represented by valid string representation (RFC-1034/5).
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<String> getDomains() {
        return domains;
    }

    /**
     * List of emails represented by valid string representation (RFC-5322/822).
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<String> getEmails() {
        return emails;
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
     * Builder for {@link SharingAllowlistRemoveArgs}.
     */
    public static class Builder {

        protected List<String> domains;
        protected List<String> emails;

        protected Builder() {
            this.domains = null;
            this.emails = null;
        }

        /**
         * Set value for optional field.
         *
         * @param domains  List of domains represented by valid string
         *     representation (RFC-1034/5). Must not contain a {@code null}
         *     item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withDomains(List<String> domains) {
            if (domains != null) {
                for (String x : domains) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'domains' is null");
                    }
                }
            }
            this.domains = domains;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param emails  List of emails represented by valid string
         *     representation (RFC-5322/822). Must not contain a {@code null}
         *     item.
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
                }
            }
            this.emails = emails;
            return this;
        }

        /**
         * Builds an instance of {@link SharingAllowlistRemoveArgs} configured
         * with this builder's values
         *
         * @return new instance of {@link SharingAllowlistRemoveArgs}
         */
        public SharingAllowlistRemoveArgs build() {
            return new SharingAllowlistRemoveArgs(domains, emails);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            domains,
            emails
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
            SharingAllowlistRemoveArgs other = (SharingAllowlistRemoveArgs) obj;
            return ((this.domains == other.domains) || (this.domains != null && this.domains.equals(other.domains)))
                && ((this.emails == other.emails) || (this.emails != null && this.emails.equals(other.emails)))
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
    static class Serializer extends StructSerializer<SharingAllowlistRemoveArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingAllowlistRemoveArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.domains != null) {
                g.writeFieldName("domains");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.domains, g);
            }
            if (value.emails != null) {
                g.writeFieldName("emails");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.emails, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharingAllowlistRemoveArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharingAllowlistRemoveArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_domains = null;
                List<String> f_emails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("domains".equals(field)) {
                        f_domains = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else if ("emails".equals(field)) {
                        f_emails = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharingAllowlistRemoveArgs(f_domains, f_emails);
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
