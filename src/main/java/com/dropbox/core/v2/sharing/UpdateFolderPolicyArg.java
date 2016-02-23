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

/**
 * If any of the policy's are unset, then they retain their current setting.
 */
public class UpdateFolderPolicyArg {
    // struct UpdateFolderPolicyArg

    private final String sharedFolderId;
    private final MemberPolicy memberPolicy;
    private final AclUpdatePolicy aclUpdatePolicy;
    private final SharedLinkPolicy sharedLinkPolicy;

    /**
     * If any of the policy's are unset, then they retain their current setting.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param memberPolicy  Who can be a member of this shared folder. Only set
     *     this if the current user is on a team.
     * @param aclUpdatePolicy  Who can add and remove members of this shared
     *     folder.
     * @param sharedLinkPolicy  The policy to apply to shared links created for
     *     content inside this shared folder.
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
     * Who can be a member of this shared folder. Only set this if the current
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
     * shared folder.
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
         *     set this if the current user is on a team.
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
         *     for content inside this shared folder.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UpdateFolderPolicyArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UpdateFolderPolicyArg> _JSON_WRITER = new JsonWriter<UpdateFolderPolicyArg>() {
        public final void write(UpdateFolderPolicyArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UpdateFolderPolicyArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UpdateFolderPolicyArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            if (x.memberPolicy != null) {
                g.writeFieldName("member_policy");
                MemberPolicy._JSON_WRITER.write(x.memberPolicy, g);
            }
            if (x.aclUpdatePolicy != null) {
                g.writeFieldName("acl_update_policy");
                AclUpdatePolicy._JSON_WRITER.write(x.aclUpdatePolicy, g);
            }
            if (x.sharedLinkPolicy != null) {
                g.writeFieldName("shared_link_policy");
                SharedLinkPolicy._JSON_WRITER.write(x.sharedLinkPolicy, g);
            }
        }
    };

    public static final JsonReader<UpdateFolderPolicyArg> _JSON_READER = new JsonReader<UpdateFolderPolicyArg>() {
        public final UpdateFolderPolicyArg read(JsonParser parser) throws IOException, JsonReadException {
            UpdateFolderPolicyArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UpdateFolderPolicyArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            MemberPolicy memberPolicy = null;
            AclUpdatePolicy aclUpdatePolicy = null;
            SharedLinkPolicy sharedLinkPolicy = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("member_policy".equals(fieldName)) {
                    memberPolicy = MemberPolicy._JSON_READER
                        .readField(parser, "member_policy", memberPolicy);
                }
                else if ("acl_update_policy".equals(fieldName)) {
                    aclUpdatePolicy = AclUpdatePolicy._JSON_READER
                        .readField(parser, "acl_update_policy", aclUpdatePolicy);
                }
                else if ("shared_link_policy".equals(fieldName)) {
                    sharedLinkPolicy = SharedLinkPolicy._JSON_READER
                        .readField(parser, "shared_link_policy", sharedLinkPolicy);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            return new UpdateFolderPolicyArg(sharedFolderId, memberPolicy, aclUpdatePolicy, sharedLinkPolicy);
        }
    };
}
