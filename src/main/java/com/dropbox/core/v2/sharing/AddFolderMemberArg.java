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

@JsonSerialize(using=AddFolderMemberArg.Serializer.class)
@JsonDeserialize(using=AddFolderMemberArg.Deserializer.class)
class AddFolderMemberArg {
    // struct AddFolderMemberArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sharedFolderId;
    protected final List<AddMember> members;
    protected final boolean quiet;
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
    public AddFolderMemberArg(String sharedFolderId, List<AddMember> members, boolean quiet, String customMessage) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
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
     * The default values for unset fields will be used.
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
    public AddFolderMemberArg(String sharedFolderId, List<AddMember> members) {
        this(sharedFolderId, members, false, null);
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
     * The intended list of members to add.  Added members will receive invites
     * to join the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
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
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
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
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            members,
            quiet,
            customMessage
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

    static final class Serializer extends StructJsonSerializer<AddFolderMemberArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AddFolderMemberArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(AddFolderMemberArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<AddFolderMemberArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(AddFolderMemberArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            g.writeObjectField("members", value.members);
            g.writeObjectField("quiet", value.quiet);
            if (value.customMessage != null) {
                g.writeObjectField("custom_message", value.customMessage);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<AddFolderMemberArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AddFolderMemberArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(AddFolderMemberArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<AddFolderMemberArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public AddFolderMemberArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sharedFolderId = null;
            List<AddMember> members = null;
            Boolean quiet = null;
            String customMessage = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("members".equals(_field)) {
                    expectArrayStart(_p);
                    members = new java.util.ArrayList<AddMember>();
                    while (!isArrayEnd(_p)) {
                        AddMember _x = null;
                        _x = _p.readValueAs(AddMember.class);
                        _p.nextToken();
                        members.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("quiet".equals(_field)) {
                    quiet = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("custom_message".equals(_field)) {
                    customMessage = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_id\" is missing.");
            }
            if (members == null) {
                throw new JsonParseException(_p, "Required field \"members\" is missing.");
            }

            return new AddFolderMemberArg(sharedFolderId, members, quiet, customMessage);
        }
    }
}
