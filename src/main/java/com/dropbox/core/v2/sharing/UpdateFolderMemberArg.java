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

@JsonSerialize(using=UpdateFolderMemberArg.Serializer.class)
@JsonDeserialize(using=UpdateFolderMemberArg.Deserializer.class)
class UpdateFolderMemberArg {
    // struct UpdateFolderMemberArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sharedFolderId;
    protected final MemberSelector member;
    protected final AccessLevel accessLevel;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member of the shared folder to update.  Only the
     *     {@link MemberSelector#dropboxId} may be set at this time. Must not be
     *     {@code null}.
     * @param accessLevel  The new access level for the {@code member} argument
     *     to {@link
     *     DbxUserSharingRequests#updateFolderMember(String,MemberSelector,AccessLevel)}.
     *     {@link AccessLevel#OWNER} is disallowed. Must not be {@code null}.
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
     * The new access level for the {@code member} argument to {@link
     * DbxUserSharingRequests#updateFolderMember(String,MemberSelector,AccessLevel)}.
     * {@link AccessLevel#OWNER} is disallowed.
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

    static final class Serializer extends StructJsonSerializer<UpdateFolderMemberArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UpdateFolderMemberArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(UpdateFolderMemberArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UpdateFolderMemberArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UpdateFolderMemberArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            g.writeObjectField("member", value.member);
            g.writeObjectField("access_level", value.accessLevel);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UpdateFolderMemberArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UpdateFolderMemberArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UpdateFolderMemberArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UpdateFolderMemberArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UpdateFolderMemberArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sharedFolderId = null;
            MemberSelector member = null;
            AccessLevel accessLevel = null;

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
                else if ("access_level".equals(_field)) {
                    accessLevel = _p.readValueAs(AccessLevel.class);
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
            if (accessLevel == null) {
                throw new JsonParseException(_p, "Required field \"access_level\" is missing.");
            }

            return new UpdateFolderMemberArg(sharedFolderId, member, accessLevel);
        }
    }
}
