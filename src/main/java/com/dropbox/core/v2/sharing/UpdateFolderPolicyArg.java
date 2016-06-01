/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * If any of the policy's are unset, then they retain their current setting.
 */
class UpdateFolderPolicyArg {
    // struct UpdateFolderPolicyArg

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
    static final class Serializer extends StructSerializer<UpdateFolderPolicyArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdateFolderPolicyArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            if (value.memberPolicy != null) {
                g.writeFieldName("member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(value.memberPolicy, g);
            }
            if (value.aclUpdatePolicy != null) {
                g.writeFieldName("acl_update_policy");
                StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).serialize(value.aclUpdatePolicy, g);
            }
            if (value.sharedLinkPolicy != null) {
                g.writeFieldName("shared_link_policy");
                StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).serialize(value.sharedLinkPolicy, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UpdateFolderPolicyArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UpdateFolderPolicyArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                MemberPolicy f_memberPolicy = null;
                AclUpdatePolicy f_aclUpdatePolicy = null;
                SharedLinkPolicy f_sharedLinkPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("member_policy".equals(field)) {
                        f_memberPolicy = StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("acl_update_policy".equals(field)) {
                        f_aclUpdatePolicy = StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("shared_link_policy".equals(field)) {
                        f_sharedLinkPolicy = StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                value = new UpdateFolderPolicyArg(f_sharedFolderId, f_memberPolicy, f_aclUpdatePolicy, f_sharedLinkPolicy);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
