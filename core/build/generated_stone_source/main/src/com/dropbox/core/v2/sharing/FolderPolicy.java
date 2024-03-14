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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A set of policies governing membership and privileges for a shared folder.
 */
public class FolderPolicy {
    // struct sharing.FolderPolicy (sharing_folders.stone)

    protected final MemberPolicy memberPolicy;
    protected final MemberPolicy resolvedMemberPolicy;
    protected final AclUpdatePolicy aclUpdatePolicy;
    protected final SharedLinkPolicy sharedLinkPolicy;
    protected final ViewerInfoPolicy viewerInfoPolicy;

    /**
     * A set of policies governing membership and privileges for a shared
     * folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param aclUpdatePolicy  Who can add and remove members from this shared
     *     folder. Must not be {@code null}.
     * @param sharedLinkPolicy  Who links can be shared with. Must not be {@code
     *     null}.
     * @param memberPolicy  Who can be a member of this shared folder, as set on
     *     the folder itself. The effective policy may differ from this value if
     *     the team-wide policy is more restrictive. Present only if the folder
     *     is owned by a team.
     * @param resolvedMemberPolicy  Who can be a member of this shared folder,
     *     taking into account both the folder and the team-wide policy. This
     *     value may differ from that of member_policy if the team-wide policy
     *     is more restrictive than the folder policy. Present only if the
     *     folder is owned by a team.
     * @param viewerInfoPolicy  Who can enable/disable viewer info for this
     *     shared folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderPolicy(@Nonnull AclUpdatePolicy aclUpdatePolicy, @Nonnull SharedLinkPolicy sharedLinkPolicy, @Nullable MemberPolicy memberPolicy, @Nullable MemberPolicy resolvedMemberPolicy, @Nullable ViewerInfoPolicy viewerInfoPolicy) {
        this.memberPolicy = memberPolicy;
        this.resolvedMemberPolicy = resolvedMemberPolicy;
        if (aclUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
        }
        this.aclUpdatePolicy = aclUpdatePolicy;
        if (sharedLinkPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
        }
        this.sharedLinkPolicy = sharedLinkPolicy;
        this.viewerInfoPolicy = viewerInfoPolicy;
    }

    /**
     * A set of policies governing membership and privileges for a shared
     * folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param aclUpdatePolicy  Who can add and remove members from this shared
     *     folder. Must not be {@code null}.
     * @param sharedLinkPolicy  Who links can be shared with. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderPolicy(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
        this(aclUpdatePolicy, sharedLinkPolicy, null, null, null);
    }

    /**
     * Who can add and remove members from this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AclUpdatePolicy getAclUpdatePolicy() {
        return aclUpdatePolicy;
    }

    /**
     * Who links can be shared with.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public SharedLinkPolicy getSharedLinkPolicy() {
        return sharedLinkPolicy;
    }

    /**
     * Who can be a member of this shared folder, as set on the folder itself.
     * The effective policy may differ from this value if the team-wide policy
     * is more restrictive. Present only if the folder is owned by a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public MemberPolicy getMemberPolicy() {
        return memberPolicy;
    }

    /**
     * Who can be a member of this shared folder, taking into account both the
     * folder and the team-wide policy. This value may differ from that of
     * member_policy if the team-wide policy is more restrictive than the folder
     * policy. Present only if the folder is owned by a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public MemberPolicy getResolvedMemberPolicy() {
        return resolvedMemberPolicy;
    }

    /**
     * Who can enable/disable viewer info for this shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public ViewerInfoPolicy getViewerInfoPolicy() {
        return viewerInfoPolicy;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param aclUpdatePolicy  Who can add and remove members from this shared
     *     folder. Must not be {@code null}.
     * @param sharedLinkPolicy  Who links can be shared with. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
        return new Builder(aclUpdatePolicy, sharedLinkPolicy);
    }

    /**
     * Builder for {@link FolderPolicy}.
     */
    public static class Builder {
        protected final AclUpdatePolicy aclUpdatePolicy;
        protected final SharedLinkPolicy sharedLinkPolicy;

        protected MemberPolicy memberPolicy;
        protected MemberPolicy resolvedMemberPolicy;
        protected ViewerInfoPolicy viewerInfoPolicy;

        protected Builder(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
            if (aclUpdatePolicy == null) {
                throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
            }
            this.aclUpdatePolicy = aclUpdatePolicy;
            if (sharedLinkPolicy == null) {
                throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
            }
            this.sharedLinkPolicy = sharedLinkPolicy;
            this.memberPolicy = null;
            this.resolvedMemberPolicy = null;
            this.viewerInfoPolicy = null;
        }

        /**
         * Set value for optional field.
         *
         * @param memberPolicy  Who can be a member of this shared folder, as
         *     set on the folder itself. The effective policy may differ from
         *     this value if the team-wide policy is more restrictive. Present
         *     only if the folder is owned by a team.
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
         * @param resolvedMemberPolicy  Who can be a member of this shared
         *     folder, taking into account both the folder and the team-wide
         *     policy. This value may differ from that of member_policy if the
         *     team-wide policy is more restrictive than the folder policy.
         *     Present only if the folder is owned by a team.
         *
         * @return this builder
         */
        public Builder withResolvedMemberPolicy(MemberPolicy resolvedMemberPolicy) {
            this.resolvedMemberPolicy = resolvedMemberPolicy;
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
         * Builds an instance of {@link FolderPolicy} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderPolicy}
         */
        public FolderPolicy build() {
            return new FolderPolicy(aclUpdatePolicy, sharedLinkPolicy, memberPolicy, resolvedMemberPolicy, viewerInfoPolicy);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            memberPolicy,
            resolvedMemberPolicy,
            aclUpdatePolicy,
            sharedLinkPolicy,
            viewerInfoPolicy
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
            FolderPolicy other = (FolderPolicy) obj;
            return ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
                && ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy != null && this.memberPolicy.equals(other.memberPolicy)))
                && ((this.resolvedMemberPolicy == other.resolvedMemberPolicy) || (this.resolvedMemberPolicy != null && this.resolvedMemberPolicy.equals(other.resolvedMemberPolicy)))
                && ((this.viewerInfoPolicy == other.viewerInfoPolicy) || (this.viewerInfoPolicy != null && this.viewerInfoPolicy.equals(other.viewerInfoPolicy)))
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
    static class Serializer extends StructSerializer<FolderPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderPolicy value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("acl_update_policy");
            AclUpdatePolicy.Serializer.INSTANCE.serialize(value.aclUpdatePolicy, g);
            g.writeFieldName("shared_link_policy");
            SharedLinkPolicy.Serializer.INSTANCE.serialize(value.sharedLinkPolicy, g);
            if (value.memberPolicy != null) {
                g.writeFieldName("member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(value.memberPolicy, g);
            }
            if (value.resolvedMemberPolicy != null) {
                g.writeFieldName("resolved_member_policy");
                StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).serialize(value.resolvedMemberPolicy, g);
            }
            if (value.viewerInfoPolicy != null) {
                g.writeFieldName("viewer_info_policy");
                StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).serialize(value.viewerInfoPolicy, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FolderPolicy deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderPolicy value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AclUpdatePolicy f_aclUpdatePolicy = null;
                SharedLinkPolicy f_sharedLinkPolicy = null;
                MemberPolicy f_memberPolicy = null;
                MemberPolicy f_resolvedMemberPolicy = null;
                ViewerInfoPolicy f_viewerInfoPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("acl_update_policy".equals(field)) {
                        f_aclUpdatePolicy = AclUpdatePolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_link_policy".equals(field)) {
                        f_sharedLinkPolicy = SharedLinkPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("member_policy".equals(field)) {
                        f_memberPolicy = StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("resolved_member_policy".equals(field)) {
                        f_resolvedMemberPolicy = StoneSerializers.nullable(MemberPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("viewer_info_policy".equals(field)) {
                        f_viewerInfoPolicy = StoneSerializers.nullable(ViewerInfoPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_aclUpdatePolicy == null) {
                    throw new JsonParseException(p, "Required field \"acl_update_policy\" missing.");
                }
                if (f_sharedLinkPolicy == null) {
                    throw new JsonParseException(p, "Required field \"shared_link_policy\" missing.");
                }
                value = new FolderPolicy(f_aclUpdatePolicy, f_sharedLinkPolicy, f_memberPolicy, f_resolvedMemberPolicy, f_viewerInfoPolicy);
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
