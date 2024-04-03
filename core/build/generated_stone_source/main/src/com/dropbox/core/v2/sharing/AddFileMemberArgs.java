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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Arguments for {@link DbxUserSharingRequests#addFileMember(String,List)}.
 */
class AddFileMemberArgs {
    // struct sharing.AddFileMemberArgs (sharing_files.stone)

    @Nonnull
    protected final String file;
    @Nonnull
    protected final List<MemberSelector> members;
    @Nullable
    protected final String customMessage;
    protected final boolean quiet;
    @Nonnull
    protected final AccessLevel accessLevel;
    protected final boolean addMessageAsComment;

    /**
     * Arguments for {@link DbxUserSharingRequests#addFileMember(String,List)}.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param file  File to which to add members. Must have length of at least
     *     1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param members  Members to add. Note that even an email address is given,
     *     this may result in a user being directly added to the membership if
     *     that email is the user's main account email. Must not contain a
     *     {@code null} item and not be {@code null}.
     * @param customMessage  Message to send to added members in their
     *     invitation.
     * @param quiet  Whether added members should be notified via email and
     *     device notifications of their invitation.
     * @param accessLevel  AccessLevel union object, describing what access
     *     level we want to give new members. Must not be {@code null}.
     * @param addMessageAsComment  If the custom message should be added as a
     *     comment on the file.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddFileMemberArgs(@Nonnull String file, @Nonnull List<MemberSelector> members, @Nullable String customMessage, boolean quiet, @Nonnull AccessLevel accessLevel, boolean addMessageAsComment) {
        if (file == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (file.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", file)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = file;
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (MemberSelector x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        this.customMessage = customMessage;
        this.quiet = quiet;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessLevel' is null");
        }
        this.accessLevel = accessLevel;
        this.addMessageAsComment = addMessageAsComment;
    }

    /**
     * Arguments for {@link DbxUserSharingRequests#addFileMember(String,List)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param file  File to which to add members. Must have length of at least
     *     1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param members  Members to add. Note that even an email address is given,
     *     this may result in a user being directly added to the membership if
     *     that email is the user's main account email. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddFileMemberArgs(@Nonnull String file, @Nonnull List<MemberSelector> members) {
        this(file, members, null, false, AccessLevel.VIEWER, false);
    }

    /**
     * File to which to add members.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFile() {
        return file;
    }

    /**
     * Members to add. Note that even an email address is given, this may result
     * in a user being directly added to the membership if that email is the
     * user's main account email.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<MemberSelector> getMembers() {
        return members;
    }

    /**
     * Message to send to added members in their invitation.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCustomMessage() {
        return customMessage;
    }

    /**
     * Whether added members should be notified via email and device
     * notifications of their invitation.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getQuiet() {
        return quiet;
    }

    /**
     * AccessLevel union object, describing what access level we want to give
     * new members.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AccessLevel.VIEWER.
     */
    @Nonnull
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * If the custom message should be added as a comment on the file.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAddMessageAsComment() {
        return addMessageAsComment;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param file  File to which to add members. Must have length of at least
     *     1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param members  Members to add. Note that even an email address is given,
     *     this may result in a user being directly added to the membership if
     *     that email is the user's main account email. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String file, List<MemberSelector> members) {
        return new Builder(file, members);
    }

    /**
     * Builder for {@link AddFileMemberArgs}.
     */
    public static class Builder {
        protected final String file;
        protected final List<MemberSelector> members;

        protected String customMessage;
        protected boolean quiet;
        protected AccessLevel accessLevel;
        protected boolean addMessageAsComment;

        protected Builder(String file, List<MemberSelector> members) {
            if (file == null) {
                throw new IllegalArgumentException("Required value for 'file' is null");
            }
            if (file.length() < 1) {
                throw new IllegalArgumentException("String 'file' is shorter than 1");
            }
            if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", file)) {
                throw new IllegalArgumentException("String 'file' does not match pattern");
            }
            this.file = file;
            if (members == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            for (MemberSelector x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = members;
            this.customMessage = null;
            this.quiet = false;
            this.accessLevel = AccessLevel.VIEWER;
            this.addMessageAsComment = false;
        }

        /**
         * Set value for optional field.
         *
         * @param customMessage  Message to send to added members in their
         *     invitation.
         *
         * @return this builder
         */
        public Builder withCustomMessage(String customMessage) {
            this.customMessage = customMessage;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param quiet  Whether added members should be notified via email and
         *     device notifications of their invitation. Defaults to {@code
         *     false} when set to {@code null}.
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
         * <p> If left unset or set to {@code null}, defaults to {@code
         * AccessLevel.VIEWER}. </p>
         *
         * @param accessLevel  AccessLevel union object, describing what access
         *     level we want to give new members. Must not be {@code null}.
         *     Defaults to {@code AccessLevel.VIEWER} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAccessLevel(AccessLevel accessLevel) {
            if (accessLevel != null) {
                this.accessLevel = accessLevel;
            }
            else {
                this.accessLevel = AccessLevel.VIEWER;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param addMessageAsComment  If the custom message should be added as
         *     a comment on the file. Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withAddMessageAsComment(Boolean addMessageAsComment) {
            if (addMessageAsComment != null) {
                this.addMessageAsComment = addMessageAsComment;
            }
            else {
                this.addMessageAsComment = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link AddFileMemberArgs} configured with this
         * builder's values
         *
         * @return new instance of {@link AddFileMemberArgs}
         */
        public AddFileMemberArgs build() {
            return new AddFileMemberArgs(file, members, customMessage, quiet, accessLevel, addMessageAsComment);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.file,
            this.members,
            this.customMessage,
            this.quiet,
            this.accessLevel,
            this.addMessageAsComment
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
            AddFileMemberArgs other = (AddFileMemberArgs) obj;
            return ((this.file == other.file) || (this.file.equals(other.file)))
                && ((this.members == other.members) || (this.members.equals(other.members)))
                && ((this.customMessage == other.customMessage) || (this.customMessage != null && this.customMessage.equals(other.customMessage)))
                && (this.quiet == other.quiet)
                && ((this.accessLevel == other.accessLevel) || (this.accessLevel.equals(other.accessLevel)))
                && (this.addMessageAsComment == other.addMessageAsComment)
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
    static class Serializer extends StructSerializer<AddFileMemberArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddFileMemberArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file");
            StoneSerializers.string().serialize(value.file, g);
            g.writeFieldName("members");
            StoneSerializers.list(MemberSelector.Serializer.INSTANCE).serialize(value.members, g);
            if (value.customMessage != null) {
                g.writeFieldName("custom_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.customMessage, g);
            }
            g.writeFieldName("quiet");
            StoneSerializers.boolean_().serialize(value.quiet, g);
            g.writeFieldName("access_level");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessLevel, g);
            g.writeFieldName("add_message_as_comment");
            StoneSerializers.boolean_().serialize(value.addMessageAsComment, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AddFileMemberArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AddFileMemberArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_file = null;
                List<MemberSelector> f_members = null;
                String f_customMessage = null;
                Boolean f_quiet = false;
                AccessLevel f_accessLevel = AccessLevel.VIEWER;
                Boolean f_addMessageAsComment = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file".equals(field)) {
                        f_file = StoneSerializers.string().deserialize(p);
                    }
                    else if ("members".equals(field)) {
                        f_members = StoneSerializers.list(MemberSelector.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("custom_message".equals(field)) {
                        f_customMessage = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("quiet".equals(field)) {
                        f_quiet = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("access_level".equals(field)) {
                        f_accessLevel = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("add_message_as_comment".equals(field)) {
                        f_addMessageAsComment = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_file == null) {
                    throw new JsonParseException(p, "Required field \"file\" missing.");
                }
                if (f_members == null) {
                    throw new JsonParseException(p, "Required field \"members\" missing.");
                }
                value = new AddFileMemberArgs(f_file, f_members, f_customMessage, f_quiet, f_accessLevel, f_addMessageAsComment);
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
