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
import java.util.List;
import java.util.regex.Pattern;

class ShareFolderArg extends ShareFolderArgBase {
    // struct sharing.ShareFolderArg (sharing_folders.stone)

    protected final List<FolderAction> actions;
    protected final LinkSettings linkSettings;

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
     * @param actions  A list of `FolderAction`s corresponding to
     *     `FolderPermission`s that should appear in the  response's {@link
     *     SharedFolderMetadata#getPermissions} field describing the actions the
     *     authenticated user can perform on the folder. Must not contain a
     *     {@code null} item.
     * @param linkSettings  Settings on the link for this folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderArg(String path, AclUpdatePolicy aclUpdatePolicy, boolean forceAsync, MemberPolicy memberPolicy, SharedLinkPolicy sharedLinkPolicy, ViewerInfoPolicy viewerInfoPolicy, AccessInheritance accessInheritance, List<FolderAction> actions, LinkSettings linkSettings) {
        super(path, aclUpdatePolicy, forceAsync, memberPolicy, sharedLinkPolicy, viewerInfoPolicy, accessInheritance);
        if (actions != null) {
            for (FolderAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = actions;
        this.linkSettings = linkSettings;
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
    public ShareFolderArg(String path) {
        this(path, null, false, null, null, null, AccessInheritance.INHERIT, null, null);
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
     * A list of `FolderAction`s corresponding to `FolderPermission`s that
     * should appear in the  response's {@link
     * SharedFolderMetadata#getPermissions} field describing the actions the
     * authenticated user can perform on the folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<FolderAction> getActions() {
        return actions;
    }

    /**
     * Settings on the link for this folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public LinkSettings getLinkSettings() {
        return linkSettings;
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
     * Builder for {@link ShareFolderArg}.
     */
    public static class Builder extends ShareFolderArgBase.Builder {

        protected List<FolderAction> actions;
        protected LinkSettings linkSettings;

        protected Builder(String path) {
            super(path);
            this.actions = null;
            this.linkSettings = null;
        }

        /**
         * Set value for optional field.
         *
         * @param actions  A list of `FolderAction`s corresponding to
         *     `FolderPermission`s that should appear in the  response's {@link
         *     SharedFolderMetadata#getPermissions} field describing the actions
         *     the  authenticated user can perform on the folder. Must not
         *     contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withActions(List<FolderAction> actions) {
            if (actions != null) {
                for (FolderAction x : actions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'actions' is null");
                    }
                }
            }
            this.actions = actions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linkSettings  Settings on the link for this folder.
         *
         * @return this builder
         */
        public Builder withLinkSettings(LinkSettings linkSettings) {
            this.linkSettings = linkSettings;
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
            super.withAclUpdatePolicy(aclUpdatePolicy);
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
            super.withForceAsync(forceAsync);
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
            super.withMemberPolicy(memberPolicy);
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
            super.withSharedLinkPolicy(sharedLinkPolicy);
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
            super.withViewerInfoPolicy(viewerInfoPolicy);
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
            super.withAccessInheritance(accessInheritance);
            return this;
        }

        /**
         * Builds an instance of {@link ShareFolderArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ShareFolderArg}
         */
        public ShareFolderArg build() {
            return new ShareFolderArg(path, aclUpdatePolicy, forceAsync, memberPolicy, sharedLinkPolicy, viewerInfoPolicy, accessInheritance, actions, linkSettings);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            actions,
            linkSettings
        });
        hash = (31 * super.hashCode()) + hash;
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
            ShareFolderArg other = (ShareFolderArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy != null && this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && (this.forceAsync == other.forceAsync)
                && ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy != null && this.memberPolicy.equals(other.memberPolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy != null && this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
                && ((this.viewerInfoPolicy == other.viewerInfoPolicy) || (this.viewerInfoPolicy != null && this.viewerInfoPolicy.equals(other.viewerInfoPolicy)))
                && ((this.accessInheritance == other.accessInheritance) || (this.accessInheritance.equals(other.accessInheritance)))
                && ((this.actions == other.actions) || (this.actions != null && this.actions.equals(other.actions)))
                && ((this.linkSettings == other.linkSettings) || (this.linkSettings != null && this.linkSettings.equals(other.linkSettings)))
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
    static class Serializer extends StructSerializer<ShareFolderArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ShareFolderArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (value.actions != null) {
                g.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(FolderAction.Serializer.INSTANCE)).serialize(value.actions, g);
            }
            if (value.linkSettings != null) {
                g.writeFieldName("link_settings");
                StoneSerializers.nullableStruct(LinkSettings.Serializer.INSTANCE).serialize(value.linkSettings, g);
            }
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
                AclUpdatePolicy f_aclUpdatePolicy = null;
                Boolean f_forceAsync = false;
                MemberPolicy f_memberPolicy = null;
                SharedLinkPolicy f_sharedLinkPolicy = null;
                ViewerInfoPolicy f_viewerInfoPolicy = null;
                AccessInheritance f_accessInheritance = AccessInheritance.INHERIT;
                List<FolderAction> f_actions = null;
                LinkSettings f_linkSettings = null;
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
                    else if ("actions".equals(field)) {
                        f_actions = StoneSerializers.nullable(StoneSerializers.list(FolderAction.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("link_settings".equals(field)) {
                        f_linkSettings = StoneSerializers.nullableStruct(LinkSettings.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ShareFolderArg(f_path, f_aclUpdatePolicy, f_forceAsync, f_memberPolicy, f_sharedLinkPolicy, f_viewerInfoPolicy, f_accessInheritance, f_actions, f_linkSettings);
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
