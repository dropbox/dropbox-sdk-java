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

public class RemoveFolderMemberArg {
    // struct RemoveFolderMemberArg

    private final String sharedFolderId;
    private final MemberSelector member;
    private final boolean leaveACopy;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member to remove from the folder. Must not be {@code
     *     null}.
     * @param leaveACopy  If true, the removed user will keep their copy of the
     *     folder after it's unshared, assuming it was mounted. Otherwise, it
     *     will be removed from their Dropbox. Also, this must be set to false
     *     when kicking a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RemoveFolderMemberArg(String sharedFolderId, MemberSelector member, boolean leaveACopy) {
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
        this.leaveACopy = leaveACopy;
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
     * The member to remove from the folder.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberSelector getMember() {
        return member;
    }

    /**
     * If true, the removed user will keep their copy of the folder after it's
     * unshared, assuming it was mounted. Otherwise, it will be removed from
     * their Dropbox. Also, this must be set to false when kicking a group.
     *
     * @return value for this field.
     */
    public boolean getLeaveACopy() {
        return leaveACopy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RemoveFolderMemberArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RemoveFolderMemberArg> _JSON_WRITER = new JsonWriter<RemoveFolderMemberArg>() {
        public final void write(RemoveFolderMemberArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RemoveFolderMemberArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RemoveFolderMemberArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            g.writeFieldName("member");
            MemberSelector._JSON_WRITER.write(x.member, g);
            g.writeFieldName("leave_a_copy");
            g.writeBoolean(x.leaveACopy);
        }
    };

    public static final JsonReader<RemoveFolderMemberArg> _JSON_READER = new JsonReader<RemoveFolderMemberArg>() {
        public final RemoveFolderMemberArg read(JsonParser parser) throws IOException, JsonReadException {
            RemoveFolderMemberArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RemoveFolderMemberArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            MemberSelector member = null;
            Boolean leaveACopy = null;
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
                else if ("leave_a_copy".equals(fieldName)) {
                    leaveACopy = JsonReader.BooleanReader
                        .readField(parser, "leave_a_copy", leaveACopy);
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
            if (leaveACopy == null) {
                throw new JsonReadException("Required field \"leave_a_copy\" is missing.", parser.getTokenLocation());
            }
            return new RemoveFolderMemberArg(sharedFolderId, member, leaveACopy);
        }
    };
}
