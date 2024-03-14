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

class ShareFolderArgBase {
    // struct sharing.ShareFolderArgBase (sharing_folders.stone)

    protected final AclUpdatePolicy aclUpdatePolicy;
    protected final boolean forceAsync;
    protected final MemberPolicy memberPolicy;
    protected final String path;
    protected final SharedLinkPolicy sharedLinkPolicy;
    protected final ViewerInfoPolicy viewerInfoPolicy;
    protected final AccessInheritance accessInheritance;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path or the file id to the folder to share. If it does
     *     not exist, then a new one is created. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be {@code null}.
     * @param aclUpdatePolicy  Who can add and remove members of this shared
     *     folder.
     * @param forceAsync  Whether to force the share to happen asynchronously.
     * @param memberPolicy  Who can be a member of this shared folder. Only
     *     applicable if the current user is on a team.
     * @param sharedLinkPolicy  The policy to apply to shared links created for
     *     content inside this shared folder.  The current user must be on a
     *     team to set this policy to {@link SharedLinkPolicy#MEMBERS}.
     * @param viewerInfoPolicy  Who can enable/disable viewer info for this
     *     shared folder.
     * @param accessInheritance  The access inheritance settings for the folder.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderArgBase(@javax.annotation.Nonnull String path, @javax.annotation.Nullable AclUpdatePolicy aclUpdatePolicy, boolean forceAsync, @javax.annotation.Nullable MemberPolicy memberPolicy, @javax.annotation.Nullable SharedLinkPolicy sharedLinkPolicy, @javax.annotation.Nullable ViewerInfoPolicy viewerInfoPolicy, @javax.annotation.Nonnull AccessInheritance accessInheritance) {
        this.aclUpdatePolicy = aclUpdatePolicy;
        this.forceAsync = forceAsync;
        this.memberPolicy = memberPolicy;
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.sharedLinkPolicy = sharedLinkPolicy;
        this.viewerInfoPolicy = viewerInfoPolicy;
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        this.accessInheritance = accessInheritance;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  The path or the file id to the folder to share. If it does
     *     not exist, then a new one is created. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderArgBase(String path) {
        this(path, null, false, null, null, null, AccessInheritance.INHERIT);
    }

    /**
     * The path or the file id to the folder to share. If it does not exist,
     * then a new one is created.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPath() {
        return path;
    }

    /**
     * Who can add and remove members of this shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public AclUpdatePolicy getAclUpdatePolicy() {
        return aclUpdatePolicy;
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
     * Who can be a member of this shared folder. Only applicable if the current
     * user is on a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public MemberPolicy getMemberPolicy() {
        return memberPolicy;
    }

    /**
     * The policy to apply to shared links created for content inside this
     * shared folder.  The current user must be on a team to set this policy to
     * {@link SharedLinkPolicy#MEMBERS}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public SharedLinkPolicy getSharedLinkPolicy() {
        return sharedLinkPolicy;
    }

    /**
     * Who can enable/disable viewer info for this shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public ViewerInfoPolicy getViewerInfoPolicy() {
        return viewerInfoPolicy;
    }

    /**
     * The access inheritance settings for the folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AccessInheritance.INHERIT.
     */
    @javax.annotation.Nonnull
    public AccessInheritance getAccessInheritance() {
        return accessInheritance;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path or the file id to the folder to share. If it does
     *     not exist, then a new one is created. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be {@code null}.
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
     * Builder for {@link ShareFolderArgBase}.
     */
    public static class Builder {
        protected final String path;

        protected AclUpdatePolicy aclUpdatePolicy;
        protected boolean forceAsync;
        protected MemberPolicy memberPolicy;
        protected SharedLinkPolicy sharedLinkPolicy;
        protected ViewerInfoPolicy viewerInfoPolicy;
        protected AccessInheritance accessInheritance;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.aclUpdatePolicy = null;
            this.forceAsync = false;
            this.memberPolicy = null;
            this.sharedLinkPolicy = null;
            this.viewerInfoPolicy = null;
            this.accessInheritance = AccessInheritance.INHERIT;
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
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder.  The current user must be
         *     on a team to set this policy to {@link SharedLinkPolicy#MEMBERS}.
         *
         * @return this builder
         */
        public Builder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param viewerInfoPolicy  Who can enable/disable viewer info for this
         *     shared folder.
         *
         * @return this builder
         */
        public Builder withViewerInfoPolicy(ViewerInfoPolicy viewerInfoPolicy) {
            this.viewerInfoPolicy = viewerInfoPolicy;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * AccessInheritance.INHERIT}. </p>
         *
         * @param accessInheritance  The access inheritance settings for the
         *     folder. Must not be {@code null}. Defaults to {@code
         *     AccessInheritance.INHERIT} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAccessInheritance(AccessInheritance accessInheritance) {
            if (accessInheritance != null) {
                this.accessInheritance = accessInheritance;
            }
            else {
                this.accessInheritance = AccessInheritance.INHERIT;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ShareFolderArgBase} configured with this
         * builder's values
         *
         * @return new instance of {@link ShareFolderArgBase}
         */
        public ShareFolderArgBase build() {
            return new ShareFolderArgBase(path, aclUpdatePolicy, forceAsync, memberPolicy, sharedLinkPolicy, viewerInfoPolicy, accessInheritance);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            aclUpdatePolicy,
            forceAsync,
            memberPolicy,
            path,
            sharedLinkPolicy,
            viewerInfoPolicy,
            accessInheritance
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
            ShareFolderArgBase other = (ShareFolderArgBase) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy != null && this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && (this.forceAsync == other.forceAsync)
                && ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy != null && this.memberPolicy.equals(other.memberPolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy != null && this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
                && ((this.viewerInfoPolicy == other.viewerInfoPolicy) || (this.viewerInfoPolicy != null && this.viewerInfoPolicy.equals(other.viewerInfoPolicy)))
                && ((this.accessInheritance == other.accessInheritance) || (this.accessInheritance.equals(other.accessInheritance)))
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
    private static class Serializer extends StructSerializer<ShareFolderArgBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ShareFolderArgBase value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            if (value.aclUpdatePolicy != null) {
                g.writeFieldName("acl_update_policy");
                StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).serialize(value.aclUpdatePolicy, g);
            }
            g.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(value.forceAsync, g);
            if (value.memberPolicy != null) {
                g.writeFieldName("member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(value.memberPolicy, g);
            }
            if (value.sharedLinkPolicy != null) {
                g.writeFieldName("shared_link_policy");
                StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).serialize(value.sharedLinkPolicy, g);
            }
            if (value.viewerInfoPolicy != null) {
                g.writeFieldName("viewer_info_policy");
                StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).serialize(value.viewerInfoPolicy, g);
            }
            g.writeFieldName("access_inheritance");
            AccessInheritance.Serializer.INSTANCE.serialize(value.accessInheritance, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ShareFolderArgBase deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ShareFolderArgBase value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                AclUpdatePolicy f_aclUpdatePolicy = null;
                Boolean f_forceAsync = false;
                MemberPolicy f_memberPolicy = null;
                SharedLinkPolicy f_sharedLinkPolicy = null;
                ViewerInfoPolicy f_viewerInfoPolicy = null;
                AccessInheritance f_accessInheritance = AccessInheritance.INHERIT;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("acl_update_policy".equals(field)) {
                        f_aclUpdatePolicy = StoneSerializers.nullable(AclUpdatePolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("force_async".equals(field)) {
                        f_forceAsync = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("member_policy".equals(field)) {
                        f_memberPolicy = StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("shared_link_policy".equals(field)) {
                        f_sharedLinkPolicy = StoneSerializers.nullable(SharedLinkPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("viewer_info_policy".equals(field)) {
                        f_viewerInfoPolicy = StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("access_inheritance".equals(field)) {
                        f_accessInheritance = AccessInheritance.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ShareFolderArgBase(f_path, f_aclUpdatePolicy, f_forceAsync, f_memberPolicy, f_sharedLinkPolicy, f_viewerInfoPolicy, f_accessInheritance);
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
