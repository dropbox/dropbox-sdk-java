/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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
 * Arguments for {@link DbxUserSharingRequests#listReceivedFiles}.
 */
class ListFilesArg {
    // struct sharing.ListFilesArg (sharing_files.stone)

    protected final long limit;
    @Nullable
    protected final List<FileAction> actions;

    /**
     * Arguments for {@link DbxUserSharingRequests#listReceivedFiles}.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param limit  Number of files to return max per query. Defaults to 100 if
     *     no limit is specified. Must be greater than or equal to 1 and be less
     *     than or equal to 300.
     * @param actions  A list of `FileAction`s corresponding to
     *     `FilePermission`s that should appear in the  response's {@link
     *     SharedFileMetadata#getPermissions} field describing the actions the
     *     authenticated user can perform on the file. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFilesArg(long limit, @Nullable List<FileAction> actions) {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 300L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 300L");
        }
        this.limit = limit;
        if (actions != null) {
            for (FileAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = actions;
    }

    /**
     * Arguments for {@link DbxUserSharingRequests#listReceivedFiles}.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListFilesArg() {
        this(100L, null);
    }

    /**
     * Number of files to return max per query. Defaults to 100 if no limit is
     * specified.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     100L.
     */
    public long getLimit() {
        return limit;
    }

    /**
     * A list of `FileAction`s corresponding to `FilePermission`s that should
     * appear in the  response's {@link SharedFileMetadata#getPermissions} field
     * describing the actions the  authenticated user can perform on the file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<FileAction> getActions() {
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
     * Builder for {@link ListFilesArg}.
     */
    public static class Builder {

        protected long limit;
        protected List<FileAction> actions;

        protected Builder() {
            this.limit = 100L;
            this.actions = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 100L}.
         * </p>
         *
         * @param limit  Number of files to return max per query. Defaults to
         *     100 if no limit is specified. Must be greater than or equal to 1
         *     and be less than or equal to 300. Defaults to {@code 100L} when
         *     set to {@code null}.
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
            if (limit > 300L) {
                throw new IllegalArgumentException("Number 'limit' is larger than 300L");
            }
            if (limit != null) {
                this.limit = limit;
            }
            else {
                this.limit = 100L;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param actions  A list of `FileAction`s corresponding to
         *     `FilePermission`s that should appear in the  response's {@link
         *     SharedFileMetadata#getPermissions} field describing the actions
         *     the  authenticated user can perform on the file. Must not contain
         *     a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withActions(List<FileAction> actions) {
            if (actions != null) {
                for (FileAction x : actions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'actions' is null");
                    }
                }
            }
            this.actions = actions;
            return this;
        }

        /**
         * Builds an instance of {@link ListFilesArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListFilesArg}
         */
        public ListFilesArg build() {
            return new ListFilesArg(limit, actions);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.limit,
            this.actions
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
            ListFilesArg other = (ListFilesArg) obj;
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
    static class Serializer extends StructSerializer<ListFilesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFilesArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(value.limit, g);
            if (value.actions != null) {
                g.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).serialize(value.actions, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFilesArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFilesArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_limit = 100L;
                List<FileAction> f_actions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else if ("actions".equals(field)) {
                        f_actions = StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ListFilesArg(f_limit, f_actions);
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
