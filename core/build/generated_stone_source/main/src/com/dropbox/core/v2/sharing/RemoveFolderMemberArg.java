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

class RemoveFolderMemberArg {
    // struct sharing.RemoveFolderMemberArg (sharing_folders.stone)

    protected final String sharedFolderId;
    protected final MemberSelector member;
    protected final boolean leaveACopy;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member to remove from the folder. Must not be {@code
     *     null}.
     * @param leaveACopy  If true, the removed user will keep their copy of the
     *     folder after it's unshared, assuming it was mounted. Otherwise, it
     *     will be removed from their Dropbox. This must be set to false when
     *     removing a group, or when the folder is within a team folder or
     *     another shared folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RemoveFolderMemberArg(@javax.annotation.Nonnull String sharedFolderId, @javax.annotation.Nonnull MemberSelector member, boolean leaveACopy) {
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
        this.leaveACopy = leaveACopy;
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
     * The member to remove from the folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public MemberSelector getMember() {
        return member;
    }

    /**
     * If true, the removed user will keep their copy of the folder after it's
     * unshared, assuming it was mounted. Otherwise, it will be removed from
     * their Dropbox. This must be set to false when removing a group, or when
     * the folder is within a team folder or another shared folder.
     *
     * @return value for this field.
     */
    public boolean getLeaveACopy() {
        return leaveACopy;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedFolderId,
            member,
            leaveACopy
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
            RemoveFolderMemberArg other = (RemoveFolderMemberArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.member == other.member) || (this.member.equals(other.member)))
                && (this.leaveACopy == other.leaveACopy)
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
    static class Serializer extends StructSerializer<RemoveFolderMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RemoveFolderMemberArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(value.member, g);
            g.writeFieldName("leave_a_copy");
            StoneSerializers.boolean_().serialize(value.leaveACopy, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RemoveFolderMemberArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RemoveFolderMemberArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                MemberSelector f_member = null;
                Boolean f_leaveACopy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("member".equals(field)) {
                        f_member = MemberSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("leave_a_copy".equals(field)) {
                        f_leaveACopy = StoneSerializers.boolean_().deserialize(p);
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
                if (f_leaveACopy == null) {
                    throw new JsonParseException(p, "Required field \"leave_a_copy\" missing.");
                }
                value = new RemoveFolderMemberArg(f_sharedFolderId, f_member, f_leaveACopy);
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
