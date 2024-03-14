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

class ListPaperDocsArgs {
    // struct paper.ListPaperDocsArgs (paper.stone)

    protected final ListPaperDocsFilterBy filterBy;
    protected final ListPaperDocsSortBy sortBy;
    protected final ListPaperDocsSortOrder sortOrder;
    protected final int limit;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param filterBy  Allows user to specify how the Paper docs should be
     *     filtered. Must not be {@code null}.
     * @param sortBy  Allows user to specify how the Paper docs should be
     *     sorted. Must not be {@code null}.
     * @param sortOrder  Allows user to specify the sort order of the result.
     *     Must not be {@code null}.
     * @param limit  Size limit per batch. The maximum number of docs that can
     *     be retrieved per batch is 1000. Higher value results in invalid
     *     arguments error. Must be greater than or equal to 1 and be less than
     *     or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListPaperDocsArgs(@javax.annotation.Nonnull ListPaperDocsFilterBy filterBy, @javax.annotation.Nonnull ListPaperDocsSortBy sortBy, @javax.annotation.Nonnull ListPaperDocsSortOrder sortOrder, int limit) {
        if (filterBy == null) {
            throw new IllegalArgumentException("Required value for 'filterBy' is null");
        }
        this.filterBy = filterBy;
        if (sortBy == null) {
            throw new IllegalArgumentException("Required value for 'sortBy' is null");
        }
        this.sortBy = sortBy;
        if (sortOrder == null) {
            throw new IllegalArgumentException("Required value for 'sortOrder' is null");
        }
        this.sortOrder = sortOrder;
        if (limit < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1");
        }
        if (limit > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000");
        }
        this.limit = limit;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListPaperDocsArgs() {
        this(ListPaperDocsFilterBy.DOCS_ACCESSED, ListPaperDocsSortBy.ACCESSED, ListPaperDocsSortOrder.ASCENDING, 1000);
    }

    /**
     * Allows user to specify how the Paper docs should be filtered.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ListPaperDocsFilterBy.DOCS_ACCESSED.
     */
    @javax.annotation.Nonnull
    public ListPaperDocsFilterBy getFilterBy() {
        return filterBy;
    }

    /**
     * Allows user to specify how the Paper docs should be sorted.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ListPaperDocsSortBy.ACCESSED.
     */
    @javax.annotation.Nonnull
    public ListPaperDocsSortBy getSortBy() {
        return sortBy;
    }

    /**
     * Allows user to specify the sort order of the result.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ListPaperDocsSortOrder.ASCENDING.
     */
    @javax.annotation.Nonnull
    public ListPaperDocsSortOrder getSortOrder() {
        return sortOrder;
    }

    /**
     * Size limit per batch. The maximum number of docs that can be retrieved
     * per batch is 1000. Higher value results in invalid arguments error.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000.
     */
    public int getLimit() {
        return limit;
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
     * Builder for {@link ListPaperDocsArgs}.
     */
    public static class Builder {

        protected ListPaperDocsFilterBy filterBy;
        protected ListPaperDocsSortBy sortBy;
        protected ListPaperDocsSortOrder sortOrder;
        protected int limit;

        protected Builder() {
            this.filterBy = ListPaperDocsFilterBy.DOCS_ACCESSED;
            this.sortBy = ListPaperDocsSortBy.ACCESSED;
            this.sortOrder = ListPaperDocsSortOrder.ASCENDING;
            this.limit = 1000;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ListPaperDocsFilterBy.DOCS_ACCESSED}. </p>
         *
         * @param filterBy  Allows user to specify how the Paper docs should be
         *     filtered. Must not be {@code null}. Defaults to {@code
         *     ListPaperDocsFilterBy.DOCS_ACCESSED} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFilterBy(ListPaperDocsFilterBy filterBy) {
            if (filterBy != null) {
                this.filterBy = filterBy;
            }
            else {
                this.filterBy = ListPaperDocsFilterBy.DOCS_ACCESSED;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ListPaperDocsSortBy.ACCESSED}. </p>
         *
         * @param sortBy  Allows user to specify how the Paper docs should be
         *     sorted. Must not be {@code null}. Defaults to {@code
         *     ListPaperDocsSortBy.ACCESSED} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSortBy(ListPaperDocsSortBy sortBy) {
            if (sortBy != null) {
                this.sortBy = sortBy;
            }
            else {
                this.sortBy = ListPaperDocsSortBy.ACCESSED;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ListPaperDocsSortOrder.ASCENDING}. </p>
         *
         * @param sortOrder  Allows user to specify the sort order of the
         *     result. Must not be {@code null}. Defaults to {@code
         *     ListPaperDocsSortOrder.ASCENDING} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSortOrder(ListPaperDocsSortOrder sortOrder) {
            if (sortOrder != null) {
                this.sortOrder = sortOrder;
            }
            else {
                this.sortOrder = ListPaperDocsSortOrder.ASCENDING;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 1000}.
         * </p>
         *
         * @param limit  Size limit per batch. The maximum number of docs that
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
         * Builds an instance of {@link ListPaperDocsArgs} configured with this
         * builder's values
         *
         * @return new instance of {@link ListPaperDocsArgs}
         */
        public ListPaperDocsArgs build() {
            return new ListPaperDocsArgs(filterBy, sortBy, sortOrder, limit);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            filterBy,
            sortBy,
            sortOrder,
            limit
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
            ListPaperDocsArgs other = (ListPaperDocsArgs) obj;
            return ((this.filterBy == other.filterBy) || (this.filterBy.equals(other.filterBy)))
                && ((this.sortBy == other.sortBy) || (this.sortBy.equals(other.sortBy)))
                && ((this.sortOrder == other.sortOrder) || (this.sortOrder.equals(other.sortOrder)))
                && (this.limit == other.limit)
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
    static class Serializer extends StructSerializer<ListPaperDocsArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListPaperDocsArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("filter_by");
            ListPaperDocsFilterBy.Serializer.INSTANCE.serialize(value.filterBy, g);
            g.writeFieldName("sort_by");
            ListPaperDocsSortBy.Serializer.INSTANCE.serialize(value.sortBy, g);
            g.writeFieldName("sort_order");
            ListPaperDocsSortOrder.Serializer.INSTANCE.serialize(value.sortOrder, g);
            g.writeFieldName("limit");
            StoneSerializers.int32().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListPaperDocsArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListPaperDocsArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                ListPaperDocsFilterBy f_filterBy = ListPaperDocsFilterBy.DOCS_ACCESSED;
                ListPaperDocsSortBy f_sortBy = ListPaperDocsSortBy.ACCESSED;
                ListPaperDocsSortOrder f_sortOrder = ListPaperDocsSortOrder.ASCENDING;
                Integer f_limit = 1000;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("filter_by".equals(field)) {
                        f_filterBy = ListPaperDocsFilterBy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("sort_by".equals(field)) {
                        f_sortBy = ListPaperDocsSortBy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("sort_order".equals(field)) {
                        f_sortOrder = ListPaperDocsSortOrder.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.int32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ListPaperDocsArgs(f_filterBy, f_sortBy, f_sortOrder, f_limit);
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
