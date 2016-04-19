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

@JsonSerialize(using=RemoveFolderMemberArg.Serializer.class)
@JsonDeserialize(using=RemoveFolderMemberArg.Deserializer.class)
class RemoveFolderMemberArg {
    // struct RemoveFolderMemberArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<RemoveFolderMemberArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RemoveFolderMemberArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(RemoveFolderMemberArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RemoveFolderMemberArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RemoveFolderMemberArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            g.writeObjectField("member", value.member);
            g.writeObjectField("leave_a_copy", value.leaveACopy);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RemoveFolderMemberArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RemoveFolderMemberArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RemoveFolderMemberArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RemoveFolderMemberArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RemoveFolderMemberArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sharedFolderId = null;
            MemberSelector member = null;
            Boolean leaveACopy = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member".equals(_field)) {
                    member = _p.readValueAs(MemberSelector.class);
                    _p.nextToken();
                }
                else if ("leave_a_copy".equals(_field)) {
                    leaveACopy = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_id\" is missing.");
            }
            if (member == null) {
                throw new JsonParseException(_p, "Required field \"member\" is missing.");
            }
            if (leaveACopy == null) {
                throw new JsonParseException(_p, "Required field \"leave_a_copy\" is missing.");
            }

            return new RemoveFolderMemberArg(sharedFolderId, member, leaveACopy);
        }
    }
}
