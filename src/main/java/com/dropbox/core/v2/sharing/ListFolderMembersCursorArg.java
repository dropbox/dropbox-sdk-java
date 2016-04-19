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

@JsonSerialize(using=ListFolderMembersCursorArg.Serializer.class)
@JsonDeserialize(using=ListFolderMembersCursorArg.Deserializer.class)
public class ListFolderMembersCursorArg {
    // struct ListFolderMembersCursorArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<MemberAction> actions;
    protected final long limit;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param actions  Member actions to query. Must not contain a {@code null}
     *     item.
     * @param limit  The maximum number of results that include members, groups
     *     and invitees to return per request. Must be greater than or equal to
     *     1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersCursorArg(List<MemberAction> actions, long limit) {
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
     */
    public ListFolderMembersCursorArg() {
        this(null, 1000L);
    }

    /**
     * Member actions to query.
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
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link ListFolderMembersCursorArg}.
     */
    public static class Builder {

        protected List<MemberAction> actions;
        protected long limit;

        protected Builder() {
            this.actions = null;
            this.limit = 1000L;
        }

        /**
         * Set value for optional field.
         *
         * @param actions  Member actions to query. Must not contain a {@code
         *     null} item.
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
         * Builds an instance of {@link ListFolderMembersCursorArg} configured
         * with this builder's values
         *
         * @return new instance of {@link ListFolderMembersCursorArg}
         */
        public ListFolderMembersCursorArg build() {
            return new ListFolderMembersCursorArg(actions, limit);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
            ListFolderMembersCursorArg other = (ListFolderMembersCursorArg) obj;
            return ((this.actions == other.actions) || (this.actions != null && this.actions.equals(other.actions)))
                && (this.limit == other.limit)
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

    static final class Serializer extends StructJsonSerializer<ListFolderMembersCursorArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFolderMembersCursorArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFolderMembersCursorArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFolderMembersCursorArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFolderMembersCursorArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value.actions != null) {
                g.writeObjectField("actions", value.actions);
            }
            g.writeObjectField("limit", value.limit);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFolderMembersCursorArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFolderMembersCursorArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFolderMembersCursorArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFolderMembersCursorArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFolderMembersCursorArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<MemberAction> actions = null;
            long limit = 1000L;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("actions".equals(_field)) {
                    expectArrayStart(_p);
                    actions = new java.util.ArrayList<MemberAction>();
                    while (!isArrayEnd(_p)) {
                        MemberAction _x = null;
                        _x = _p.readValueAs(MemberAction.class);
                        _p.nextToken();
                        actions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("limit".equals(_field)) {
                    limit = _p.getLongValue();
                    assertUnsigned(_p, limit);
                    if (limit > Integer.MAX_VALUE) {
                        throw new JsonParseException(_p, "expecting a 32-bit unsigned integer, got: " + limit);
                    }
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new ListFolderMembersCursorArg(actions, limit);
        }
    }
}
