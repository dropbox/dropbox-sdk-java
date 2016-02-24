/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class ListFoldersArgs {
    // struct ListFoldersArgs

    private final long limit;
    private final List<FolderAction> actions;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param limit  The maximum number of results to return per request. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     * @param actions  Folder actions to query. This field is optional. Must not
     *     contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersArgs(long limit, List<FolderAction> actions) {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = limit;
        if (actions != null) {
            for (FolderAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = actions;
    }

    /**
     * The default values for unset fields will be used.
     */
    public ListFoldersArgs() {
        this(1000L, null);
    }

    /**
     * The maximum number of results to return per request.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000L.
     */
    public long getLimit() {
        return limit;
    }

    /**
     * Folder actions to query. This field is optional.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<FolderAction> getActions() {
        return actions;
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
     * Builder for {@link ListFoldersArgs}.
     */
    public static class Builder {

        protected long limit;
        protected List<FolderAction> actions;

        protected Builder() {
            this.limit = 1000L;
            this.actions = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 1000L}.
         * </p>
         *
         * @param limit  The maximum number of results to return per request.
         *     Must be greater than or equal to 1 and be less than or equal to
         *     1000. Defaults to {@code 1000L} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withLimit(Long limit) {
            if (limit < 1L) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (limit > 1000L) {
                throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
            }
            if (limit != null) {
                this.limit = limit;
            }
            else {
                this.limit = 1000L;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param actions  Folder actions to query. This field is optional. Must
         *     not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withActions(List<FolderAction> actions) {
            if (actions != null) {
                for (FolderAction x : actions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'actions' is null");
                    }
                }
            }
            this.actions = actions;
            return this;
        }

        /**
         * Builds an instance of {@link ListFoldersArgs} configured with this
         * builder's values
         *
         * @return new instance of {@link ListFoldersArgs}
         */
        public ListFoldersArgs build() {
            return new ListFoldersArgs(limit, actions);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            limit,
            actions
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ListFoldersArgs other = (ListFoldersArgs) obj;
            return (this.limit == other.limit)
                && ((this.actions == other.actions) || (this.actions != null && this.actions.equals(other.actions)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListFoldersArgs fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFoldersArgs> _JSON_WRITER = new JsonWriter<ListFoldersArgs>() {
        public final void write(ListFoldersArgs x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFoldersArgs._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFoldersArgs x, JsonGenerator g) throws IOException {
            g.writeFieldName("limit");
            g.writeNumber(x.limit);
            if (x.actions != null) {
                g.writeFieldName("actions");
                g.writeStartArray();
                for (FolderAction item: x.actions) {
                    if (item != null) {
                        FolderAction._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        }
    };

    public static final JsonReader<ListFoldersArgs> _JSON_READER = new JsonReader<ListFoldersArgs>() {
        public final ListFoldersArgs read(JsonParser parser) throws IOException, JsonReadException {
            ListFoldersArgs result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFoldersArgs readFields(JsonParser parser) throws IOException, JsonReadException {
            Long limit = null;
            List<FolderAction> actions = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("limit".equals(fieldName)) {
                    limit = JsonReader.UInt32Reader
                        .readField(parser, "limit", limit);
                }
                else if ("actions".equals(fieldName)) {
                    actions = JsonArrayReader.mk(FolderAction._JSON_READER)
                        .readField(parser, "actions", actions);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new ListFoldersArgs(limit, actions);
        }
    };
}
