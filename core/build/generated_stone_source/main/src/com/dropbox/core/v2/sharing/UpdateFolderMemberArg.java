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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

class UpdateFolderMemberArg {
    // struct sharing.UpdateFolderMemberArg (sharing_folders.stone)

    @Nonnull
    protected final String sharedFolderId;
    @Nonnull
    protected final MemberSelector member;
    @Nonnull
    protected final AccessLevel accessLevel;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member of the shared folder to update.  Only the
     *     {@link MemberSelector#getDropboxIdValue} may be set at this time.
     *     Must not be {@code null}.
     * @param accessLevel  The new access level for {@link
     *     UpdateFolderMemberArg#getMember}. {@link AccessLevel#OWNER} is
     *     disallowed. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateFolderMemberArg(@Nonnull String sharedFolderId, @Nonnull MemberSelector member, @Nonnull AccessLevel accessLevel) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (member == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = member;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessLevel' is null");
        }
        this.accessLevel = accessLevel;
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
     * The member of the shared folder to update.  Only the {@link
     * MemberSelector#getDropboxIdValue} may be set at this time.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public MemberSelector getMember() {
        return member;
    }

    /**
     * The new access level for {@link UpdateFolderMemberArg#getMember}. {@link
     * AccessLevel#OWNER} is disallowed.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sharedFolderId,
            this.member,
            this.accessLevel
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
            UpdateFolderMemberArg other = (UpdateFolderMemberArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.member == other.member) || (this.member.equals(other.member)))
                && ((this.accessLevel == other.accessLevel) || (this.accessLevel.equals(other.accessLevel)))
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
    static class Serializer extends StructSerializer<UpdateFolderMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdateFolderMemberArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(value.member, g);
            g.writeFieldName("access_level");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessLevel, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UpdateFolderMemberArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UpdateFolderMemberArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                MemberSelector f_member = null;
                AccessLevel f_accessLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("member".equals(field)) {
                        f_member = MemberSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("access_level".equals(field)) {
                        f_accessLevel = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                if (f_member == null) {
                    throw new JsonParseException(p, "Required field \"member\" missing.");
                }
                if (f_accessLevel == null) {
                    throw new JsonParseException(p, "Required field \"access_level\" missing.");
                }
                value = new UpdateFolderMemberArg(f_sharedFolderId, f_member, f_accessLevel);
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
