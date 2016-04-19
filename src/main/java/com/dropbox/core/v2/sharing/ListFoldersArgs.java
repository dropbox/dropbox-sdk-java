/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

@JsonSerialize(using=ListFoldersArgs.Serializer.class)
@JsonDeserialize(using=ListFoldersArgs.Deserializer.class)
class ListFoldersArgs {
    // struct ListFoldersArgs

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final long limit;
    protected final List<FolderAction> actions;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param limit  The maximum number of results to return per request. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     * @param actions  Folder actions to query. Must not contain a {@code null}
     *     item.
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
     * Folder actions to query.
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
         * @param actions  Folder actions to query. Must not contain a {@code
         *     null} item.
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ListFoldersArgs> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFoldersArgs.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFoldersArgs.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFoldersArgs> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFoldersArgs value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("limit", value.limit);
            if (value.actions != null) {
                g.writeObjectField("actions", value.actions);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFoldersArgs> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFoldersArgs.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFoldersArgs.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFoldersArgs> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFoldersArgs deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            long limit = 1000L;
            List<FolderAction> actions = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("limit".equals(_field)) {
                    limit = _p.getLongValue();
                    assertUnsigned(_p, limit);
                    if (limit > Integer.MAX_VALUE) {
                        throw new JsonParseException(_p, "expecting a 32-bit unsigned integer, got: " + limit);
                    }
                    _p.nextToken();
                }
                else if ("actions".equals(_field)) {
                    expectArrayStart(_p);
                    actions = new java.util.ArrayList<FolderAction>();
                    while (!isArrayEnd(_p)) {
                        FolderAction _x = null;
                        _x = _p.readValueAs(FolderAction.class);
                        _p.nextToken();
                        actions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new ListFoldersArgs(limit, actions);
        }
    }
}
