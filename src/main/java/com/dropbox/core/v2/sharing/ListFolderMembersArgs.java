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

public class ListFolderMembersArgs {
    // struct ListFolderMembersArgs

    private final String sharedFolderId;
    private final List<MemberAction> actions;
    private final long limit;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param actions  Member actions to query. This field is optional. Must not
     *     contain a {@code null} item.
     * @param limit  The maximum number of results that include members, groups
     *     and invitees to return per request. Must be greater than or equal to
     *     1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersArgs(String sharedFolderId, List<MemberAction> actions, long limit) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (actions != null) {
            for (MemberAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = actions;
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = limit;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersArgs(String sharedFolderId) {
        this(sharedFolderId, null, 1000L);
    }

    /**
     * The ID for the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Member actions to query. This field is optional.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<MemberAction> getActions() {
        return actions;
    }

    /**
     * The maximum number of results that include members, groups and invitees
     * to return per request.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000L.
     */
    public long getLimit() {
        return limit;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sharedFolderId) {
        return new Builder(sharedFolderId);
    }

    /**
     * Builder for {@link ListFolderMembersArgs}.
     */
    public static class Builder {
        protected final String sharedFolderId;

        protected List<MemberAction> actions;
        protected long limit;

        protected Builder(String sharedFolderId) {
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
            this.actions = null;
            this.limit = 1000L;
        }

        /**
         * Set value for optional field.
         *
         * @param actions  Member actions to query. This field is optional. Must
         *     not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withActions(List<MemberAction> actions) {
            if (actions != null) {
                for (MemberAction x : actions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'actions' is null");
                    }
                }
            }
            this.actions = actions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 1000L}.
         * </p>
         *
         * @param limit  The maximum number of results that include members,
         *     groups and invitees to return per request. Must be greater than
         *     or equal to 1 and be less than or equal to 1000. Defaults to
         *     {@code 1000L} when set to {@code null}.
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
         * Builds an instance of {@link ListFolderMembersArgs} configured with
         * this builder's values
         *
         * @return new instance of {@link ListFolderMembersArgs}
         */
        public ListFolderMembersArgs build() {
            return new ListFolderMembersArgs(sharedFolderId, actions, limit);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            actions,
            limit
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
            ListFolderMembersArgs other = (ListFolderMembersArgs) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.actions == other.actions) || (this.actions != null && this.actions.equals(other.actions)))
                && (this.limit == other.limit)
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

    public static ListFolderMembersArgs fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderMembersArgs> _JSON_WRITER = new JsonWriter<ListFolderMembersArgs>() {
        public final void write(ListFolderMembersArgs x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFolderMembersArgs._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFolderMembersArgs x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            if (x.actions != null) {
                g.writeFieldName("actions");
                g.writeStartArray();
                for (MemberAction item: x.actions) {
                    if (item != null) {
                        MemberAction._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
            g.writeFieldName("limit");
            g.writeNumber(x.limit);
        }
    };

    public static final JsonReader<ListFolderMembersArgs> _JSON_READER = new JsonReader<ListFolderMembersArgs>() {
        public final ListFolderMembersArgs read(JsonParser parser) throws IOException, JsonReadException {
            ListFolderMembersArgs result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFolderMembersArgs readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            List<MemberAction> actions = null;
            Long limit = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("actions".equals(fieldName)) {
                    actions = JsonArrayReader.mk(MemberAction._JSON_READER)
                        .readField(parser, "actions", actions);
                }
                else if ("limit".equals(fieldName)) {
                    limit = JsonReader.UInt32Reader
                        .readField(parser, "limit", limit);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            return new ListFolderMembersArgs(sharedFolderId, actions, limit);
        }
    };
}
