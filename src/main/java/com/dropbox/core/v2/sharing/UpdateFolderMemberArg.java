/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class UpdateFolderMemberArg {
    // struct UpdateFolderMemberArg

    private final String sharedFolderId;
    private final MemberSelector member;
    private final AccessLevel accessLevel;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member of the shared folder to update.  Only the
     *     {@link MemberSelector#dropboxId} may be set at this time. Must not be
     *     {@code null}.
     * @param accessLevel  The new access level for {@link
     *     UpdateFolderMemberArg#getMember}. {@link AccessLevel#OWNER} is
     *     disallowed. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateFolderMemberArg(String sharedFolderId, MemberSelector member, AccessLevel accessLevel) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
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
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * The member of the shared folder to update.  Only the {@link
     * MemberSelector#dropboxId} may be set at this time.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberSelector getMember() {
        return member;
    }

    /**
     * The new access level for {@link UpdateFolderMemberArg#getMember}. {@link
     * AccessLevel#OWNER} is disallowed.
     *
     * @return value for this field, never {@code null}.
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            member,
            accessLevel
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UpdateFolderMemberArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UpdateFolderMemberArg> _JSON_WRITER = new JsonWriter<UpdateFolderMemberArg>() {
        public final void write(UpdateFolderMemberArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UpdateFolderMemberArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UpdateFolderMemberArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            g.writeFieldName("member");
            MemberSelector._JSON_WRITER.write(x.member, g);
            g.writeFieldName("access_level");
            AccessLevel._JSON_WRITER.write(x.accessLevel, g);
        }
    };

    public static final JsonReader<UpdateFolderMemberArg> _JSON_READER = new JsonReader<UpdateFolderMemberArg>() {
        public final UpdateFolderMemberArg read(JsonParser parser) throws IOException, JsonReadException {
            UpdateFolderMemberArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UpdateFolderMemberArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            MemberSelector member = null;
            AccessLevel accessLevel = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("member".equals(fieldName)) {
                    member = MemberSelector._JSON_READER
                        .readField(parser, "member", member);
                }
                else if ("access_level".equals(fieldName)) {
                    accessLevel = AccessLevel._JSON_READER
                        .readField(parser, "access_level", accessLevel);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            if (member == null) {
                throw new JsonReadException("Required field \"member\" is missing.", parser.getTokenLocation());
            }
            if (accessLevel == null) {
                throw new JsonReadException("Required field \"access_level\" is missing.", parser.getTokenLocation());
            }
            return new UpdateFolderMemberArg(sharedFolderId, member, accessLevel);
        }
    };
}
