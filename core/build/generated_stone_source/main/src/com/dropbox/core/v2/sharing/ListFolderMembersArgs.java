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
import java.util.regex.Pattern;

class ListFolderMembersArgs extends ListFolderMembersCursorArg {
    // struct sharing.ListFolderMembersArgs (sharing_folders.stone)

    protected final String sharedFolderId;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
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
    public ListFolderMembersArgs(String sharedFolderId, List<MemberAction> actions, long limit) {
        super(actions, limit);
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
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
    @javax.annotation.Nonnull
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * This is a list indicating whether each returned member will include a
     * boolean value {@link MemberPermission#getAllow} that describes whether
     * the current user can perform the MemberAction on the member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
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
    public static class Builder extends ListFolderMembersCursorArg.Builder {
        protected final String sharedFolderId;

        protected Builder(String sharedFolderId) {
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
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
            super.withActions(actions);
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
            super.withLimit(limit);
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
        int hash = Arrays.hashCode(new Object [] {
            sharedFolderId
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
    static class Serializer extends StructSerializer<ListFolderMembersArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderMembersArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
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
        public ListFolderMembersArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFolderMembersArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                List<MemberAction> f_actions = null;
                Long f_limit = 1000L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("actions".equals(field)) {
                        f_actions = StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                value = new ListFolderMembersArgs(f_sharedFolderId, f_actions, f_limit);
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
