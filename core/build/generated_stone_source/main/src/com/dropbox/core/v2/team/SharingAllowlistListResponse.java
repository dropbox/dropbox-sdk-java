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

import javax.annotation.Nonnull;

public class SharingAllowlistListResponse {
    // struct team.SharingAllowlistListResponse (team_sharing_allowlist.stone)

    protected final List<String> domains;
    protected final List<String> emails;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param domains  List of domains represented by valid string
     *     representation (RFC-1034/5). Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param emails  List of emails represented by valid string representation
     *     (RFC-5322/822). Must not contain a {@code null} item and not be
     *     {@code null}.
     * @param cursor  If this is nonempty, there are more entries that can be
     *     fetched with {@link
     *     DbxTeamTeamRequests#sharingAllowlistListContinue(String)}. Must not
     *     be {@code null}.
     * @param hasMore  if true indicates that more entries can be fetched with
     *     {@link DbxTeamTeamRequests#sharingAllowlistListContinue(String)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingAllowlistListResponse(@Nonnull List<String> domains, @Nonnull List<String> emails, @Nonnull String cursor, boolean hasMore) {
        if (domains == null) {
            throw new IllegalArgumentException("Required value for 'domains' is null");
        }
        for (String x : domains) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'domains' is null");
            }
        }
        this.domains = domains;
        if (emails == null) {
            throw new IllegalArgumentException("Required value for 'emails' is null");
        }
        for (String x : emails) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'emails' is null");
            }
        }
        this.emails = emails;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param domains  List of domains represented by valid string
     *     representation (RFC-1034/5). Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param emails  List of emails represented by valid string representation
     *     (RFC-5322/822). Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingAllowlistListResponse(@Nonnull List<String> domains, @Nonnull List<String> emails) {
        this(domains, emails, "", false);
    }

    /**
     * List of domains represented by valid string representation (RFC-1034/5).
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getDomains() {
        return domains;
    }

    /**
     * List of emails represented by valid string representation (RFC-5322/822).
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getEmails() {
        return emails;
    }

    /**
     * If this is nonempty, there are more entries that can be fetched with
     * {@link DbxTeamTeamRequests#sharingAllowlistListContinue(String)}.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     "".
     */
    @Nonnull
    public String getCursor() {
        return cursor;
    }

    /**
     * if true indicates that more entries can be fetched with {@link
     * DbxTeamTeamRequests#sharingAllowlistListContinue(String)}.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param domains  List of domains represented by valid string
     *     representation (RFC-1034/5). Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param emails  List of emails represented by valid string representation
     *     (RFC-5322/822). Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(List<String> domains, List<String> emails) {
        return new Builder(domains, emails);
    }

    /**
     * Builder for {@link SharingAllowlistListResponse}.
     */
    public static class Builder {
        protected final List<String> domains;
        protected final List<String> emails;

        protected String cursor;
        protected boolean hasMore;

        protected Builder(List<String> domains, List<String> emails) {
            if (domains == null) {
                throw new IllegalArgumentException("Required value for 'domains' is null");
            }
            for (String x : domains) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'domains' is null");
                }
            }
            this.domains = domains;
            if (emails == null) {
                throw new IllegalArgumentException("Required value for 'emails' is null");
            }
            for (String x : emails) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'emails' is null");
                }
            }
            this.emails = emails;
            this.cursor = "";
            this.hasMore = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code ""}.
         * </p>
         *
         * @param cursor  If this is nonempty, there are more entries that can
         *     be fetched with {@link
         *     DbxTeamTeamRequests#sharingAllowlistListContinue(String)}. Must
         *     not be {@code null}. Defaults to {@code ""} when set to {@code
         *     null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withCursor(String cursor) {
            if (cursor != null) {
                this.cursor = cursor;
            }
            else {
                this.cursor = "";
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param hasMore  if true indicates that more entries can be fetched
         *     with {@link
         *     DbxTeamTeamRequests#sharingAllowlistListContinue(String)}.
         *     Defaults to {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withHasMore(Boolean hasMore) {
            if (hasMore != null) {
                this.hasMore = hasMore;
            }
            else {
                this.hasMore = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link SharingAllowlistListResponse} configured
         * with this builder's values
         *
         * @return new instance of {@link SharingAllowlistListResponse}
         */
        public SharingAllowlistListResponse build() {
            return new SharingAllowlistListResponse(domains, emails, cursor, hasMore);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            domains,
            emails,
            cursor,
            hasMore
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
            SharingAllowlistListResponse other = (SharingAllowlistListResponse) obj;
            return ((this.domains == other.domains) || (this.domains.equals(other.domains)))
                && ((this.emails == other.emails) || (this.emails.equals(other.emails)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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
    static class Serializer extends StructSerializer<SharingAllowlistListResponse> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingAllowlistListResponse value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("domains");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.domains, g);
            g.writeFieldName("emails");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.emails, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharingAllowlistListResponse deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharingAllowlistListResponse value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_domains = null;
                List<String> f_emails = null;
                String f_cursor = "";
                Boolean f_hasMore = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("domains".equals(field)) {
                        f_domains = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("emails".equals(field)) {
                        f_emails = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_domains == null) {
                    throw new JsonParseException(p, "Required field \"domains\" missing.");
                }
                if (f_emails == null) {
                    throw new JsonParseException(p, "Required field \"emails\" missing.");
                }
                value = new SharingAllowlistListResponse(f_domains, f_emails, f_cursor, f_hasMore);
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
