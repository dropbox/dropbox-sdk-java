/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

import javax.annotation.Nonnull;

class ListUsersOnPaperDocArgs extends RefPaperDoc {
    // struct paper.ListUsersOnPaperDocArgs (paper.stone)

    protected final int limit;
    @Nonnull
    protected final UserOnPaperDocFilter filterBy;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param limit  Size limit per batch. The maximum number of users that can
     *     be retrieved per batch is 1000. Higher value results in invalid
     *     arguments error. Must be greater than or equal to 1 and be less than
     *     or equal to 1000.
     * @param filterBy  Specify this attribute if you want to obtain users that
     *     have already accessed the Paper doc. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListUsersOnPaperDocArgs(@Nonnull String docId, int limit, @Nonnull UserOnPaperDocFilter filterBy) {
        super(docId);
        if (limit < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1");
        }
        if (limit > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000");
        }
        this.limit = limit;
        if (filterBy == null) {
            throw new IllegalArgumentException("Required value for 'filterBy' is null");
        }
        this.filterBy = filterBy;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListUsersOnPaperDocArgs(@Nonnull String docId) {
        this(docId, 1000, UserOnPaperDocFilter.SHARED);
    }

    /**
     * The Paper doc ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDocId() {
        return docId;
    }

    /**
     * Size limit per batch. The maximum number of users that can be retrieved
     * per batch is 1000. Higher value results in invalid arguments error.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Specify this attribute if you want to obtain users that have already
     * accessed the Paper doc.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     UserOnPaperDocFilter.SHARED.
     */
    @Nonnull
    public UserOnPaperDocFilter getFilterBy() {
        return filterBy;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String docId) {
        return new Builder(docId);
    }

    /**
     * Builder for {@link ListUsersOnPaperDocArgs}.
     */
    public static class Builder {
        protected final String docId;

        protected int limit;
        protected UserOnPaperDocFilter filterBy;

        protected Builder(String docId) {
            if (docId == null) {
                throw new IllegalArgumentException("Required value for 'docId' is null");
            }
            this.docId = docId;
            this.limit = 1000;
            this.filterBy = UserOnPaperDocFilter.SHARED;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 1000}.
         * </p>
         *
         * @param limit  Size limit per batch. The maximum number of users that
         *     can be retrieved per batch is 1000. Higher value results in
         *     invalid arguments error. Must be greater than or equal to 1 and
         *     be less than or equal to 1000. Defaults to {@code 1000} when set
         *     to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withLimit(Integer limit) {
            if (limit < 1) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1");
            }
            if (limit > 1000) {
                throw new IllegalArgumentException("Number 'limit' is larger than 1000");
            }
            if (limit != null) {
                this.limit = limit;
            }
            else {
                this.limit = 1000;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * UserOnPaperDocFilter.SHARED}. </p>
         *
         * @param filterBy  Specify this attribute if you want to obtain users
         *     that have already accessed the Paper doc. Must not be {@code
         *     null}. Defaults to {@code UserOnPaperDocFilter.SHARED} when set
         *     to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFilterBy(UserOnPaperDocFilter filterBy) {
            if (filterBy != null) {
                this.filterBy = filterBy;
            }
            else {
                this.filterBy = UserOnPaperDocFilter.SHARED;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ListUsersOnPaperDocArgs} configured with
         * this builder's values
         *
         * @return new instance of {@link ListUsersOnPaperDocArgs}
         */
        public ListUsersOnPaperDocArgs build() {
            return new ListUsersOnPaperDocArgs(docId, limit, filterBy);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            limit,
            filterBy
        });
        hash = (31 * super.hashCode()) + hash;
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
            ListUsersOnPaperDocArgs other = (ListUsersOnPaperDocArgs) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && (this.limit == other.limit)
                && ((this.filterBy == other.filterBy) || (this.filterBy.equals(other.filterBy)))
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
    static class Serializer extends StructSerializer<ListUsersOnPaperDocArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListUsersOnPaperDocArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("limit");
            StoneSerializers.int32().serialize(value.limit, g);
            g.writeFieldName("filter_by");
            UserOnPaperDocFilter.Serializer.INSTANCE.serialize(value.filterBy, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListUsersOnPaperDocArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListUsersOnPaperDocArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                Integer f_limit = 1000;
                UserOnPaperDocFilter f_filterBy = UserOnPaperDocFilter.SHARED;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.int32().deserialize(p);
                    }
                    else if ("filter_by".equals(field)) {
                        f_filterBy = UserOnPaperDocFilter.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                value = new ListUsersOnPaperDocArgs(f_docId, f_limit, f_filterBy);
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
