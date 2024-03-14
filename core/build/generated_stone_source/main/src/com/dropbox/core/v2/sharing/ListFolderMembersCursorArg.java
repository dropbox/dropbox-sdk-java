/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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

class ListFolderMembersCursorArg {
    // struct sharing.ListFolderMembersCursorArg (sharing_folders.stone)

    protected final List<MemberAction> actions;
    protected final long limit;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param actions  This is a list indicating whether each returned member
     *     will include a boolean value {@link MemberPermission#getAllow} that
     *     describes whether the current user can perform the MemberAction on
     *     the member. Must not contain a {@code null} item.
     * @param limit  The maximum number of results that include members, groups
     *     and invitees to return per request. Must be greater than or equal to
     *     1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersCursorArg(@Nullable List<MemberAction> actions, long limit) {
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
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListFolderMembersCursorArg() {
        this(null, 1000L);
    }

    /**
     * This is a list indicating whether each returned member will include a
     * boolean value {@link MemberPermission#getAllow} that describes whether
     * the current user can perform the MemberAction on the member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
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
         * @param actions  This is a list indicating whether each returned
         *     member will include a boolean value {@link
         *     MemberPermission#getAllow} that describes whether the current
         *     user can perform the MemberAction on the member. Must not contain
         *     a {@code null} item.
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    private static class Serializer extends StructSerializer<ListFolderMembersCursorArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderMembersCursorArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.actions != null) {
                g.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).serialize(value.actions, g);
            }
            g.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFolderMembersCursorArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFolderMembersCursorArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<MemberAction> f_actions = null;
                Long f_limit = 1000L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("actions".equals(field)) {
                        f_actions = StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ListFolderMembersCursorArg(f_actions, f_limit);
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
