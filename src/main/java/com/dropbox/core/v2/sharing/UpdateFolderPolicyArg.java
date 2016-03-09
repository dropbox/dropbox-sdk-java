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

/**
 * If any of the policy's are unset, then they retain their current setting.
 */
@JsonSerialize(using=UpdateFolderPolicyArg.Serializer.class)
@JsonDeserialize(using=UpdateFolderPolicyArg.Deserializer.class)
class UpdateFolderPolicyArg {
    // struct UpdateFolderPolicyArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sharedFolderId;
    protected final MemberPolicy memberPolicy;
    protected final AclUpdatePolicy aclUpdatePolicy;
    protected final SharedLinkPolicy sharedLinkPolicy;

    /**
     * If any of the policy's are unset, then they retain their current setting.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param memberPolicy  Who can be a member of this shared folder. Only
     *     applicable if the current user is on a team.
     * @param aclUpdatePolicy  Who can add and remove members of this shared
     *     folder.
     * @param sharedLinkPolicy  The policy to apply to shared links created for
     *     content inside this shared folder. The current user must be on a team
     *     to set this policy to {@link SharedLinkPolicy#MEMBERS}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateFolderPolicyArg(String sharedFolderId, MemberPolicy memberPolicy, AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        this.memberPolicy = memberPolicy;
        this.aclUpdatePolicy = aclUpdatePolicy;
        this.sharedLinkPolicy = sharedLinkPolicy;
    }

    /**
     * If any of the policy's are unset, then they retain their current setting.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateFolderPolicyArg(String sharedFolderId) {
        this(sharedFolderId, null, null, null);
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
     * Who can be a member of this shared folder. Only applicable if the current
     * user is on a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public MemberPolicy getMemberPolicy() {
        return memberPolicy;
    }

    /**
     * Who can add and remove members of this shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public AclUpdatePolicy getAclUpdatePolicy() {
        return aclUpdatePolicy;
    }

    /**
     * The policy to apply to shared links created for content inside this
     * shared folder. The current user must be on a team to set this policy to
     * {@link SharedLinkPolicy#MEMBERS}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public SharedLinkPolicy getSharedLinkPolicy() {
        return sharedLinkPolicy;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sharedFolderId) {
        return new Builder(sharedFolderId);
    }

    /**
     * Builder for {@link UpdateFolderPolicyArg}.
     */
    public static class Builder {
        protected final String sharedFolderId;

        protected MemberPolicy memberPolicy;
        protected AclUpdatePolicy aclUpdatePolicy;
        protected SharedLinkPolicy sharedLinkPolicy;

        protected Builder(String sharedFolderId) {
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
            this.memberPolicy = null;
            this.aclUpdatePolicy = null;
            this.sharedLinkPolicy = null;
        }

        /**
         * Set value for optional field.
         *
         * @param memberPolicy  Who can be a member of this shared folder. Only
         *     applicable if the current user is on a team.
         *
         * @return this builder
         */
        public Builder withMemberPolicy(MemberPolicy memberPolicy) {
            this.memberPolicy = memberPolicy;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param aclUpdatePolicy  Who can add and remove members of this shared
         *     folder.
         *
         * @return this builder
         */
        public Builder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
            this.aclUpdatePolicy = aclUpdatePolicy;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder. The current user must be
         *     on a team to set this policy to {@link SharedLinkPolicy#MEMBERS}.
         *
         * @return this builder
         */
        public Builder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }

        /**
         * Builds an instance of {@link UpdateFolderPolicyArg} configured with
         * this builder's values
         *
         * @return new instance of {@link UpdateFolderPolicyArg}
         */
        public UpdateFolderPolicyArg build() {
            return new UpdateFolderPolicyArg(sharedFolderId, memberPolicy, aclUpdatePolicy, sharedLinkPolicy);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            memberPolicy,
            aclUpdatePolicy,
            sharedLinkPolicy
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
            UpdateFolderPolicyArg other = (UpdateFolderPolicyArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy != null && this.memberPolicy.equals(other.memberPolicy)))
                && ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy != null && this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy != null && this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
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

    static final class Serializer extends StructJsonSerializer<UpdateFolderPolicyArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UpdateFolderPolicyArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(UpdateFolderPolicyArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UpdateFolderPolicyArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UpdateFolderPolicyArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            if (value.memberPolicy != null) {
                g.writeObjectField("member_policy", value.memberPolicy);
            }
            if (value.aclUpdatePolicy != null) {
                g.writeObjectField("acl_update_policy", value.aclUpdatePolicy);
            }
            if (value.sharedLinkPolicy != null) {
                g.writeObjectField("shared_link_policy", value.sharedLinkPolicy);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UpdateFolderPolicyArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UpdateFolderPolicyArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UpdateFolderPolicyArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UpdateFolderPolicyArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UpdateFolderPolicyArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sharedFolderId = null;
            MemberPolicy memberPolicy = null;
            AclUpdatePolicy aclUpdatePolicy = null;
            SharedLinkPolicy sharedLinkPolicy = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_policy".equals(_field)) {
                    memberPolicy = _p.readValueAs(MemberPolicy.class);
                    _p.nextToken();
                }
                else if ("acl_update_policy".equals(_field)) {
                    aclUpdatePolicy = _p.readValueAs(AclUpdatePolicy.class);
                    _p.nextToken();
                }
                else if ("shared_link_policy".equals(_field)) {
                    sharedLinkPolicy = _p.readValueAs(SharedLinkPolicy.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_id\" is missing.");
            }

            return new UpdateFolderPolicyArg(sharedFolderId, memberPolicy, aclUpdatePolicy, sharedLinkPolicy);
        }
    }
}
