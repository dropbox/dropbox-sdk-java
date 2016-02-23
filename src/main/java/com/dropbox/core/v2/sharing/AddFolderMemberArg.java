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

public class AddFolderMemberArg {
    // struct AddFolderMemberArg

    private final String sharedFolderId;
    private final List<AddMember> members;
    private final boolean quiet;
    private final String customMessage;

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
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static AddFolderMemberArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AddFolderMemberArg> _JSON_WRITER = new JsonWriter<AddFolderMemberArg>() {
        public final void write(AddFolderMemberArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            AddFolderMemberArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(AddFolderMemberArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            g.writeFieldName("members");
            g.writeStartArray();
            for (AddMember item: x.members) {
                if (item != null) {
                    AddMember._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("quiet");
            g.writeBoolean(x.quiet);
            if (x.customMessage != null) {
                g.writeFieldName("custom_message");
                g.writeString(x.customMessage);
            }
        }
    };

    public static final JsonReader<AddFolderMemberArg> _JSON_READER = new JsonReader<AddFolderMemberArg>() {
        public final AddFolderMemberArg read(JsonParser parser) throws IOException, JsonReadException {
            AddFolderMemberArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final AddFolderMemberArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            List<AddMember> members = null;
            Boolean quiet = null;
            String customMessage = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("members".equals(fieldName)) {
                    members = JsonArrayReader.mk(AddMember._JSON_READER)
                        .readField(parser, "members", members);
                }
                else if ("quiet".equals(fieldName)) {
                    quiet = JsonReader.BooleanReader
                        .readField(parser, "quiet", quiet);
                }
                else if ("custom_message".equals(fieldName)) {
                    customMessage = JsonReader.StringReader
                        .readField(parser, "custom_message", customMessage);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            if (members == null) {
                throw new JsonReadException("Required field \"members\" is missing.", parser.getTokenLocation());
            }
            return new AddFolderMemberArg(sharedFolderId, members, quiet, customMessage);
        }
    };
}
