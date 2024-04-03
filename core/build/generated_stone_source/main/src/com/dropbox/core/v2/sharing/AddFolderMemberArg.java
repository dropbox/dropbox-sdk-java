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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class AddFolderMemberArg {
    // struct sharing.AddFolderMemberArg (sharing_folders.stone)

    @Nonnull
    protected final String sharedFolderId;
    @Nonnull
    protected final List<AddMember> members;
    protected final boolean quiet;
    @Nullable
    protected final String customMessage;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param members  The intended list of members to add.  Added members will
     *     receive invites to join the shared folder. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param quiet  Whether added members should be notified via email and
     *     device notifications of their invite.
     * @param customMessage  Optional message to display to added members in
     *     their invitation. Must have length of at least 1.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddFolderMemberArg(@Nonnull String sharedFolderId, @Nonnull List<AddMember> members, boolean quiet, @Nullable String customMessage) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (AddMember x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        this.quiet = quiet;
        if (customMessage != null) {
            if (customMessage.length() < 1) {
                throw new IllegalArgumentException("String 'customMessage' is shorter than 1");
            }
        }
        this.customMessage = customMessage;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param members  The intended list of members to add.  Added members will
     *     receive invites to join the shared folder. Must not contain a {@code
     *     null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddFolderMemberArg(@Nonnull String sharedFolderId, @Nonnull List<AddMember> members) {
        this(sharedFolderId, members, false, null);
    }

    /**
     * The ID for the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * The intended list of members to add.  Added members will receive invites
     * to join the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<AddMember> getMembers() {
        return members;
    }

    /**
     * Whether added members should be notified via email and device
     * notifications of their invite.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getQuiet() {
        return quiet;
    }

    /**
     * Optional message to display to added members in their invitation.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCustomMessage() {
        return customMessage;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param members  The intended list of members to add.  Added members will
     *     receive invites to join the shared folder. Must not contain a {@code
     *     null} item and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sharedFolderId, List<AddMember> members) {
        return new Builder(sharedFolderId, members);
    }

    /**
     * Builder for {@link AddFolderMemberArg}.
     */
    public static class Builder {
        protected final String sharedFolderId;
        protected final List<AddMember> members;

        protected boolean quiet;
        protected String customMessage;

        protected Builder(String sharedFolderId, List<AddMember> members) {
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
            if (members == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            for (AddMember x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = members;
            this.quiet = false;
            this.customMessage = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param quiet  Whether added members should be notified via email and
         *     device notifications of their invite. Defaults to {@code false}
         *     when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withQuiet(Boolean quiet) {
            if (quiet != null) {
                this.quiet = quiet;
            }
            else {
                this.quiet = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param customMessage  Optional message to display to added members in
         *     their invitation. Must have length of at least 1.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withCustomMessage(String customMessage) {
            if (customMessage != null) {
                if (customMessage.length() < 1) {
                    throw new IllegalArgumentException("String 'customMessage' is shorter than 1");
                }
            }
            this.customMessage = customMessage;
            return this;
        }

        /**
         * Builds an instance of {@link AddFolderMemberArg} configured with this
         * builder's values
         *
         * @return new instance of {@link AddFolderMemberArg}
         */
        public AddFolderMemberArg build() {
            return new AddFolderMemberArg(sharedFolderId, members, quiet, customMessage);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sharedFolderId,
            this.members,
            this.quiet,
            this.customMessage
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
            AddFolderMemberArg other = (AddFolderMemberArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.members == other.members) || (this.members.equals(other.members)))
                && (this.quiet == other.quiet)
                && ((this.customMessage == other.customMessage) || (this.customMessage != null && this.customMessage.equals(other.customMessage)))
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
    static class Serializer extends StructSerializer<AddFolderMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddFolderMemberArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("members");
            StoneSerializers.list(AddMember.Serializer.INSTANCE).serialize(value.members, g);
            g.writeFieldName("quiet");
            StoneSerializers.boolean_().serialize(value.quiet, g);
            if (value.customMessage != null) {
                g.writeFieldName("custom_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.customMessage, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AddFolderMemberArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AddFolderMemberArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                List<AddMember> f_members = null;
                Boolean f_quiet = false;
                String f_customMessage = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("members".equals(field)) {
                        f_members = StoneSerializers.list(AddMember.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("quiet".equals(field)) {
                        f_quiet = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("custom_message".equals(field)) {
                        f_customMessage = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                if (f_members == null) {
                    throw new JsonParseException(p, "Required field \"members\" missing.");
                }
                value = new AddFolderMemberArg(f_sharedFolderId, f_members, f_quiet, f_customMessage);
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
