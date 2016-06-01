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

class ShareFolderArg {
    // struct ShareFolderArg

    protected final String path;
    protected final MemberPolicy memberPolicy;
    protected final AclUpdatePolicy aclUpdatePolicy;
    protected final SharedLinkPolicy sharedLinkPolicy;
    protected final boolean forceAsync;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /(.|[\\r\\n])*}" and
     *     not be {@code null}.
     * @param memberPolicy  Who can be a member of this shared folder. Only
     *     applicable if the current user is on a team.
     * @param aclUpdatePolicy  Who can add and remove members of this shared
     *     folder.
     * @param sharedLinkPolicy  The policy to apply to shared links created for
     *     content inside this shared folder.  The current user must be on a
     *     team to set this policy to {@link SharedLinkPolicy#MEMBERS}.
     * @param forceAsync  Whether to force the share to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderArg(String path, MemberPolicy memberPolicy, AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy, boolean forceAsync) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/(.|[\\r\\n])*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (memberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'memberPolicy' is null");
        }
        this.memberPolicy = memberPolicy;
        if (aclUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
        }
        this.aclUpdatePolicy = aclUpdatePolicy;
        if (sharedLinkPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
        }
        this.sharedLinkPolicy = sharedLinkPolicy;
        this.forceAsync = forceAsync;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /(.|[\\r\\n])*}" and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderArg(String path) {
        this(path, MemberPolicy.ANYONE, AclUpdatePolicy.OWNER, SharedLinkPolicy.ANYONE, false);
    }

    /**
     * The path to the folder to share. If it does not exist, then a new one is
     * created.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Who can be a member of this shared folder. Only applicable if the current
     * user is on a team.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     MemberPolicy.ANYONE.
     */
    public MemberPolicy getMemberPolicy() {
        return memberPolicy;
    }

    /**
     * Who can add and remove members of this shared folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AclUpdatePolicy.OWNER.
     */
    public AclUpdatePolicy getAclUpdatePolicy() {
        return aclUpdatePolicy;
    }

    /**
     * The policy to apply to shared links created for content inside this
     * shared folder.  The current user must be on a team to set this policy to
     * {@link SharedLinkPolicy#MEMBERS}.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     SharedLinkPolicy.ANYONE.
     */
    public SharedLinkPolicy getSharedLinkPolicy() {
        return sharedLinkPolicy;
    }

    /**
     * Whether to force the share to happen asynchronously.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getForceAsync() {
        return forceAsync;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /(.|[\\r\\n])*}" and
     *     not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link ShareFolderArg}.
     */
    public static class Builder {
        protected final String path;

        protected MemberPolicy memberPolicy;
        protected AclUpdatePolicy aclUpdatePolicy;
        protected SharedLinkPolicy sharedLinkPolicy;
        protected boolean forceAsync;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/(.|[\\r\\n])*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.memberPolicy = MemberPolicy.ANYONE;
            this.aclUpdatePolicy = AclUpdatePolicy.OWNER;
            this.sharedLinkPolicy = SharedLinkPolicy.ANYONE;
            this.forceAsync = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * MemberPolicy.ANYONE}. </p>
         *
         * @param memberPolicy  Who can be a member of this shared folder. Only
         *     applicable if the current user is on a team. Defaults to {@code
         *     MemberPolicy.ANYONE} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withMemberPolicy(MemberPolicy memberPolicy) {
            if (memberPolicy != null) {
                this.memberPolicy = memberPolicy;
            }
            else {
                this.memberPolicy = MemberPolicy.ANYONE;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * AclUpdatePolicy.OWNER}. </p>
         *
         * @param aclUpdatePolicy  Who can add and remove members of this shared
         *     folder. Defaults to {@code AclUpdatePolicy.OWNER} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
            if (aclUpdatePolicy != null) {
                this.aclUpdatePolicy = aclUpdatePolicy;
            }
            else {
                this.aclUpdatePolicy = AclUpdatePolicy.OWNER;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * SharedLinkPolicy.ANYONE}. </p>
         *
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder.  The current user must be
         *     on a team to set this policy to {@link SharedLinkPolicy#MEMBERS}.
         *     Defaults to {@code SharedLinkPolicy.ANYONE} when set to {@code
         *     null}.
         *
         * @return this builder
         */
        public Builder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
            if (sharedLinkPolicy != null) {
                this.sharedLinkPolicy = sharedLinkPolicy;
            }
            else {
                this.sharedLinkPolicy = SharedLinkPolicy.ANYONE;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param forceAsync  Whether to force the share to happen
         *     asynchronously. Defaults to {@code false} when set to {@code
         *     null}.
         *
         * @return this builder
         */
        public Builder withForceAsync(Boolean forceAsync) {
            if (forceAsync != null) {
                this.forceAsync = forceAsync;
            }
            else {
                this.forceAsync = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ShareFolderArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ShareFolderArg}
         */
        public ShareFolderArg build() {
            return new ShareFolderArg(path, memberPolicy, aclUpdatePolicy, sharedLinkPolicy, forceAsync);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            memberPolicy,
            aclUpdatePolicy,
            sharedLinkPolicy,
            forceAsync
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
            ShareFolderArg other = (ShareFolderArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy.equals(other.memberPolicy)))
                && ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
                && (this.forceAsync == other.forceAsync)
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
    static final class Serializer extends StructSerializer<ShareFolderArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ShareFolderArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("member_policy");
            MemberPolicy.Serializer.INSTANCE.serialize(value.memberPolicy, g);
            g.writeFieldName("acl_update_policy");
            AclUpdatePolicy.Serializer.INSTANCE.serialize(value.aclUpdatePolicy, g);
            g.writeFieldName("shared_link_policy");
            SharedLinkPolicy.Serializer.INSTANCE.serialize(value.sharedLinkPolicy, g);
            g.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(value.forceAsync, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ShareFolderArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ShareFolderArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                MemberPolicy f_memberPolicy = MemberPolicy.ANYONE;
                AclUpdatePolicy f_aclUpdatePolicy = AclUpdatePolicy.OWNER;
                SharedLinkPolicy f_sharedLinkPolicy = SharedLinkPolicy.ANYONE;
                Boolean f_forceAsync = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("member_policy".equals(field)) {
                        f_memberPolicy = MemberPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("acl_update_policy".equals(field)) {
                        f_aclUpdatePolicy = AclUpdatePolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_link_policy".equals(field)) {
                        f_sharedLinkPolicy = SharedLinkPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("force_async".equals(field)) {
                        f_forceAsync = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ShareFolderArg(f_path, f_memberPolicy, f_aclUpdatePolicy, f_sharedLinkPolicy, f_forceAsync);
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
