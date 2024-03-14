/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

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

public class LinkPermissions {
    // struct sharing.LinkPermissions (shared_links.stone)

    protected final ResolvedVisibility resolvedVisibility;
    protected final RequestedVisibility requestedVisibility;
    protected final boolean canRevoke;
    protected final SharedLinkAccessFailureReason revokeFailureReason;
    protected final LinkAudience effectiveAudience;
    protected final LinkAccessLevel linkAccessLevel;
    protected final List<VisibilityPolicy> visibilityPolicies;
    protected final boolean canSetExpiry;
    protected final boolean canRemoveExpiry;
    protected final boolean allowDownload;
    protected final boolean canAllowDownload;
    protected final boolean canDisallowDownload;
    protected final boolean allowComments;
    protected final boolean teamRestrictsComments;
    protected final List<LinkAudienceOption> audienceOptions;
    protected final Boolean canSetPassword;
    protected final Boolean canRemovePassword;
    protected final Boolean requirePassword;
    protected final Boolean canUseExtendedSharingControls;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param canRevoke  Whether the caller can revoke the shared link.
     * @param visibilityPolicies  A list of policies that the user might be able
     *     to set for the visibility. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param canSetExpiry  Whether the user can set the expiry settings of the
     *     link. This refers to the ability to create a new expiry and modify an
     *     existing expiry.
     * @param canRemoveExpiry  Whether the user can remove the expiry of the
     *     link.
     * @param allowDownload  Whether the link can be downloaded or not.
     * @param canAllowDownload  Whether the user can allow downloads via the
     *     link. This refers to the ability to remove a no-download restriction
     *     on the link.
     * @param canDisallowDownload  Whether the user can disallow downloads via
     *     the link. This refers to the ability to impose a no-download
     *     restriction on the link.
     * @param allowComments  Whether comments are enabled for the linked file.
     *     This takes the team commenting policy into account.
     * @param teamRestrictsComments  Whether the team has disabled commenting
     *     globally.
     * @param resolvedVisibility  The current visibility of the link after
     *     considering the shared links policies of the the team (in case the
     *     link's owner is part of a team) and the shared folder (in case the
     *     linked file is part of a shared folder). This field is shown only if
     *     the caller has access to this info (the link's owner always has
     *     access to this data). For some links, an effective_audience value is
     *     returned instead.
     * @param requestedVisibility  The shared link's requested visibility. This
     *     can be overridden by the team and shared folder policies. The final
     *     visibility, after considering these policies, can be found in {@link
     *     LinkPermissions#getResolvedVisibility}. This is shown only if the
     *     caller is the link's owner and resolved_visibility is returned
     *     instead of effective_audience.
     * @param revokeFailureReason  The failure reason for revoking the link.
     *     This field will only be present if the {@link
     *     LinkPermissions#getCanRevoke} is {@code false}.
     * @param effectiveAudience  The type of audience who can benefit from the
     *     access level specified by the `link_access_level` field.
     * @param linkAccessLevel  The access level that the link will grant to its
     *     users. A link can grant additional rights to a user beyond their
     *     current access level. For example, if a user was invited as a viewer
     *     to a file, and then opens a link with `link_access_level` set to
     *     `editor`, then they will gain editor privileges. The
     *     `link_access_level` is a property of the link, and does not depend on
     *     who is calling this API. In particular, `link_access_level` does not
     *     take into account the API caller's current permissions to the
     *     content.
     * @param audienceOptions  A list of link audience options the user might be
     *     able to set as the new audience. Must not contain a {@code null}
     *     item.
     * @param canSetPassword  Whether the user can set a password for the link.
     * @param canRemovePassword  Whether the user can remove the password of the
     *     link.
     * @param requirePassword  Whether the user is required to provide a
     *     password to view the link.
     * @param canUseExtendedSharingControls  Whether the user can use extended
     *     sharing controls, based on their account type.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkPermissions(boolean canRevoke, List<VisibilityPolicy> visibilityPolicies, boolean canSetExpiry, boolean canRemoveExpiry, boolean allowDownload, boolean canAllowDownload, boolean canDisallowDownload, boolean allowComments, boolean teamRestrictsComments, ResolvedVisibility resolvedVisibility, RequestedVisibility requestedVisibility, SharedLinkAccessFailureReason revokeFailureReason, LinkAudience effectiveAudience, LinkAccessLevel linkAccessLevel, List<LinkAudienceOption> audienceOptions, Boolean canSetPassword, Boolean canRemovePassword, Boolean requirePassword, Boolean canUseExtendedSharingControls) {
        this.resolvedVisibility = resolvedVisibility;
        this.requestedVisibility = requestedVisibility;
        this.canRevoke = canRevoke;
        this.revokeFailureReason = revokeFailureReason;
        this.effectiveAudience = effectiveAudience;
        this.linkAccessLevel = linkAccessLevel;
        if (visibilityPolicies == null) {
            throw new IllegalArgumentException("Required value for 'visibilityPolicies' is null");
        }
        for (VisibilityPolicy x : visibilityPolicies) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'visibilityPolicies' is null");
            }
        }
        this.visibilityPolicies = visibilityPolicies;
        this.canSetExpiry = canSetExpiry;
        this.canRemoveExpiry = canRemoveExpiry;
        this.allowDownload = allowDownload;
        this.canAllowDownload = canAllowDownload;
        this.canDisallowDownload = canDisallowDownload;
        this.allowComments = allowComments;
        this.teamRestrictsComments = teamRestrictsComments;
        if (audienceOptions != null) {
            for (LinkAudienceOption x : audienceOptions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'audienceOptions' is null");
                }
            }
        }
        this.audienceOptions = audienceOptions;
        this.canSetPassword = canSetPassword;
        this.canRemovePassword = canRemovePassword;
        this.requirePassword = requirePassword;
        this.canUseExtendedSharingControls = canUseExtendedSharingControls;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param canRevoke  Whether the caller can revoke the shared link.
     * @param visibilityPolicies  A list of policies that the user might be able
     *     to set for the visibility. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param canSetExpiry  Whether the user can set the expiry settings of the
     *     link. This refers to the ability to create a new expiry and modify an
     *     existing expiry.
     * @param canRemoveExpiry  Whether the user can remove the expiry of the
     *     link.
     * @param allowDownload  Whether the link can be downloaded or not.
     * @param canAllowDownload  Whether the user can allow downloads via the
     *     link. This refers to the ability to remove a no-download restriction
     *     on the link.
     * @param canDisallowDownload  Whether the user can disallow downloads via
     *     the link. This refers to the ability to impose a no-download
     *     restriction on the link.
     * @param allowComments  Whether comments are enabled for the linked file.
     *     This takes the team commenting policy into account.
     * @param teamRestrictsComments  Whether the team has disabled commenting
     *     globally.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkPermissions(boolean canRevoke, List<VisibilityPolicy> visibilityPolicies, boolean canSetExpiry, boolean canRemoveExpiry, boolean allowDownload, boolean canAllowDownload, boolean canDisallowDownload, boolean allowComments, boolean teamRestrictsComments) {
        this(canRevoke, visibilityPolicies, canSetExpiry, canRemoveExpiry, allowDownload, canAllowDownload, canDisallowDownload, allowComments, teamRestrictsComments, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Whether the caller can revoke the shared link.
     *
     * @return value for this field.
     */
    public boolean getCanRevoke() {
        return canRevoke;
    }

    /**
     * A list of policies that the user might be able to set for the visibility.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<VisibilityPolicy> getVisibilityPolicies() {
        return visibilityPolicies;
    }

    /**
     * Whether the user can set the expiry settings of the link. This refers to
     * the ability to create a new expiry and modify an existing expiry.
     *
     * @return value for this field.
     */
    public boolean getCanSetExpiry() {
        return canSetExpiry;
    }

    /**
     * Whether the user can remove the expiry of the link.
     *
     * @return value for this field.
     */
    public boolean getCanRemoveExpiry() {
        return canRemoveExpiry;
    }

    /**
     * Whether the link can be downloaded or not.
     *
     * @return value for this field.
     */
    public boolean getAllowDownload() {
        return allowDownload;
    }

    /**
     * Whether the user can allow downloads via the link. This refers to the
     * ability to remove a no-download restriction on the link.
     *
     * @return value for this field.
     */
    public boolean getCanAllowDownload() {
        return canAllowDownload;
    }

    /**
     * Whether the user can disallow downloads via the link. This refers to the
     * ability to impose a no-download restriction on the link.
     *
     * @return value for this field.
     */
    public boolean getCanDisallowDownload() {
        return canDisallowDownload;
    }

    /**
     * Whether comments are enabled for the linked file. This takes the team
     * commenting policy into account.
     *
     * @return value for this field.
     */
    public boolean getAllowComments() {
        return allowComments;
    }

    /**
     * Whether the team has disabled commenting globally.
     *
     * @return value for this field.
     */
    public boolean getTeamRestrictsComments() {
        return teamRestrictsComments;
    }

    /**
     * The current visibility of the link after considering the shared links
     * policies of the the team (in case the link's owner is part of a team) and
     * the shared folder (in case the linked file is part of a shared folder).
     * This field is shown only if the caller has access to this info (the
     * link's owner always has access to this data). For some links, an
     * effective_audience value is returned instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public ResolvedVisibility getResolvedVisibility() {
        return resolvedVisibility;
    }

    /**
     * The shared link's requested visibility. This can be overridden by the
     * team and shared folder policies. The final visibility, after considering
     * these policies, can be found in {@link
     * LinkPermissions#getResolvedVisibility}. This is shown only if the caller
     * is the link's owner and resolved_visibility is returned instead of
     * effective_audience.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public RequestedVisibility getRequestedVisibility() {
        return requestedVisibility;
    }

    /**
     * The failure reason for revoking the link. This field will only be present
     * if the {@link LinkPermissions#getCanRevoke} is {@code false}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public SharedLinkAccessFailureReason getRevokeFailureReason() {
        return revokeFailureReason;
    }

    /**
     * The type of audience who can benefit from the access level specified by
     * the `link_access_level` field.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public LinkAudience getEffectiveAudience() {
        return effectiveAudience;
    }

    /**
     * The access level that the link will grant to its users. A link can grant
     * additional rights to a user beyond their current access level. For
     * example, if a user was invited as a viewer to a file, and then opens a
     * link with `link_access_level` set to `editor`, then they will gain editor
     * privileges. The `link_access_level` is a property of the link, and does
     * not depend on who is calling this API. In particular, `link_access_level`
     * does not take into account the API caller's current permissions to the
     * content.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public LinkAccessLevel getLinkAccessLevel() {
        return linkAccessLevel;
    }

    /**
     * A list of link audience options the user might be able to set as the new
     * audience.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<LinkAudienceOption> getAudienceOptions() {
        return audienceOptions;
    }

    /**
     * Whether the user can set a password for the link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Boolean getCanSetPassword() {
        return canSetPassword;
    }

    /**
     * Whether the user can remove the password of the link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Boolean getCanRemovePassword() {
        return canRemovePassword;
    }

    /**
     * Whether the user is required to provide a password to view the link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Boolean getRequirePassword() {
        return requirePassword;
    }

    /**
     * Whether the user can use extended sharing controls, based on their
     * account type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Boolean getCanUseExtendedSharingControls() {
        return canUseExtendedSharingControls;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param canRevoke  Whether the caller can revoke the shared link.
     * @param visibilityPolicies  A list of policies that the user might be able
     *     to set for the visibility. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param canSetExpiry  Whether the user can set the expiry settings of the
     *     link. This refers to the ability to create a new expiry and modify an
     *     existing expiry.
     * @param canRemoveExpiry  Whether the user can remove the expiry of the
     *     link.
     * @param allowDownload  Whether the link can be downloaded or not.
     * @param canAllowDownload  Whether the user can allow downloads via the
     *     link. This refers to the ability to remove a no-download restriction
     *     on the link.
     * @param canDisallowDownload  Whether the user can disallow downloads via
     *     the link. This refers to the ability to impose a no-download
     *     restriction on the link.
     * @param allowComments  Whether comments are enabled for the linked file.
     *     This takes the team commenting policy into account.
     * @param teamRestrictsComments  Whether the team has disabled commenting
     *     globally.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(boolean canRevoke, List<VisibilityPolicy> visibilityPolicies, boolean canSetExpiry, boolean canRemoveExpiry, boolean allowDownload, boolean canAllowDownload, boolean canDisallowDownload, boolean allowComments, boolean teamRestrictsComments) {
        return new Builder(canRevoke, visibilityPolicies, canSetExpiry, canRemoveExpiry, allowDownload, canAllowDownload, canDisallowDownload, allowComments, teamRestrictsComments);
    }

    /**
     * Builder for {@link LinkPermissions}.
     */
    public static class Builder {
        protected final boolean canRevoke;
        protected final List<VisibilityPolicy> visibilityPolicies;
        protected final boolean canSetExpiry;
        protected final boolean canRemoveExpiry;
        protected final boolean allowDownload;
        protected final boolean canAllowDownload;
        protected final boolean canDisallowDownload;
        protected final boolean allowComments;
        protected final boolean teamRestrictsComments;

        protected ResolvedVisibility resolvedVisibility;
        protected RequestedVisibility requestedVisibility;
        protected SharedLinkAccessFailureReason revokeFailureReason;
        protected LinkAudience effectiveAudience;
        protected LinkAccessLevel linkAccessLevel;
        protected List<LinkAudienceOption> audienceOptions;
        protected Boolean canSetPassword;
        protected Boolean canRemovePassword;
        protected Boolean requirePassword;
        protected Boolean canUseExtendedSharingControls;

        protected Builder(boolean canRevoke, List<VisibilityPolicy> visibilityPolicies, boolean canSetExpiry, boolean canRemoveExpiry, boolean allowDownload, boolean canAllowDownload, boolean canDisallowDownload, boolean allowComments, boolean teamRestrictsComments) {
            this.canRevoke = canRevoke;
            if (visibilityPolicies == null) {
                throw new IllegalArgumentException("Required value for 'visibilityPolicies' is null");
            }
            for (VisibilityPolicy x : visibilityPolicies) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'visibilityPolicies' is null");
                }
            }
            this.visibilityPolicies = visibilityPolicies;
            this.canSetExpiry = canSetExpiry;
            this.canRemoveExpiry = canRemoveExpiry;
            this.allowDownload = allowDownload;
            this.canAllowDownload = canAllowDownload;
            this.canDisallowDownload = canDisallowDownload;
            this.allowComments = allowComments;
            this.teamRestrictsComments = teamRestrictsComments;
            this.resolvedVisibility = null;
            this.requestedVisibility = null;
            this.revokeFailureReason = null;
            this.effectiveAudience = null;
            this.linkAccessLevel = null;
            this.audienceOptions = null;
            this.canSetPassword = null;
            this.canRemovePassword = null;
            this.requirePassword = null;
            this.canUseExtendedSharingControls = null;
        }

        /**
         * Set value for optional field.
         *
         * @param resolvedVisibility  The current visibility of the link after
         *     considering the shared links policies of the the team (in case
         *     the link's owner is part of a team) and the shared folder (in
         *     case the linked file is part of a shared folder). This field is
         *     shown only if the caller has access to this info (the link's
         *     owner always has access to this data). For some links, an
         *     effective_audience value is returned instead.
         *
         * @return this builder
         */
        public Builder withResolvedVisibility(ResolvedVisibility resolvedVisibility) {
            this.resolvedVisibility = resolvedVisibility;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param requestedVisibility  The shared link's requested visibility.
         *     This can be overridden by the team and shared folder policies.
         *     The final visibility, after considering these policies, can be
         *     found in {@link LinkPermissions#getResolvedVisibility}. This is
         *     shown only if the caller is the link's owner and
         *     resolved_visibility is returned instead of effective_audience.
         *
         * @return this builder
         */
        public Builder withRequestedVisibility(RequestedVisibility requestedVisibility) {
            this.requestedVisibility = requestedVisibility;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param revokeFailureReason  The failure reason for revoking the link.
         *     This field will only be present if the {@link
         *     LinkPermissions#getCanRevoke} is {@code false}.
         *
         * @return this builder
         */
        public Builder withRevokeFailureReason(SharedLinkAccessFailureReason revokeFailureReason) {
            this.revokeFailureReason = revokeFailureReason;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param effectiveAudience  The type of audience who can benefit from
         *     the access level specified by the `link_access_level` field.
         *
         * @return this builder
         */
        public Builder withEffectiveAudience(LinkAudience effectiveAudience) {
            this.effectiveAudience = effectiveAudience;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linkAccessLevel  The access level that the link will grant to
         *     its users. A link can grant additional rights to a user beyond
         *     their current access level. For example, if a user was invited as
         *     a viewer to a file, and then opens a link with
         *     `link_access_level` set to `editor`, then they will gain editor
         *     privileges. The `link_access_level` is a property of the link,
         *     and does not depend on who is calling this API. In particular,
         *     `link_access_level` does not take into account the API caller's
         *     current permissions to the content.
         *
         * @return this builder
         */
        public Builder withLinkAccessLevel(LinkAccessLevel linkAccessLevel) {
            this.linkAccessLevel = linkAccessLevel;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param audienceOptions  A list of link audience options the user
         *     might be able to set as the new audience. Must not contain a
         *     {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAudienceOptions(List<LinkAudienceOption> audienceOptions) {
            if (audienceOptions != null) {
                for (LinkAudienceOption x : audienceOptions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'audienceOptions' is null");
                    }
                }
            }
            this.audienceOptions = audienceOptions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param canSetPassword  Whether the user can set a password for the
         *     link.
         *
         * @return this builder
         */
        public Builder withCanSetPassword(Boolean canSetPassword) {
            this.canSetPassword = canSetPassword;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param canRemovePassword  Whether the user can remove the password of
         *     the link.
         *
         * @return this builder
         */
        public Builder withCanRemovePassword(Boolean canRemovePassword) {
            this.canRemovePassword = canRemovePassword;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param requirePassword  Whether the user is required to provide a
         *     password to view the link.
         *
         * @return this builder
         */
        public Builder withRequirePassword(Boolean requirePassword) {
            this.requirePassword = requirePassword;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param canUseExtendedSharingControls  Whether the user can use
         *     extended sharing controls, based on their account type.
         *
         * @return this builder
         */
        public Builder withCanUseExtendedSharingControls(Boolean canUseExtendedSharingControls) {
            this.canUseExtendedSharingControls = canUseExtendedSharingControls;
            return this;
        }

        /**
         * Builds an instance of {@link LinkPermissions} configured with this
         * builder's values
         *
         * @return new instance of {@link LinkPermissions}
         */
        public LinkPermissions build() {
            return new LinkPermissions(canRevoke, visibilityPolicies, canSetExpiry, canRemoveExpiry, allowDownload, canAllowDownload, canDisallowDownload, allowComments, teamRestrictsComments, resolvedVisibility, requestedVisibility, revokeFailureReason, effectiveAudience, linkAccessLevel, audienceOptions, canSetPassword, canRemovePassword, requirePassword, canUseExtendedSharingControls);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            resolvedVisibility,
            requestedVisibility,
            canRevoke,
            revokeFailureReason,
            effectiveAudience,
            linkAccessLevel,
            visibilityPolicies,
            canSetExpiry,
            canRemoveExpiry,
            allowDownload,
            canAllowDownload,
            canDisallowDownload,
            allowComments,
            teamRestrictsComments,
            audienceOptions,
            canSetPassword,
            canRemovePassword,
            requirePassword,
            canUseExtendedSharingControls
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
            LinkPermissions other = (LinkPermissions) obj;
            return (this.canRevoke == other.canRevoke)
                && ((this.visibilityPolicies == other.visibilityPolicies) || (this.visibilityPolicies.equals(other.visibilityPolicies)))
                && (this.canSetExpiry == other.canSetExpiry)
                && (this.canRemoveExpiry == other.canRemoveExpiry)
                && (this.allowDownload == other.allowDownload)
                && (this.canAllowDownload == other.canAllowDownload)
                && (this.canDisallowDownload == other.canDisallowDownload)
                && (this.allowComments == other.allowComments)
                && (this.teamRestrictsComments == other.teamRestrictsComments)
                && ((this.resolvedVisibility == other.resolvedVisibility) || (this.resolvedVisibility != null && this.resolvedVisibility.equals(other.resolvedVisibility)))
                && ((this.requestedVisibility == other.requestedVisibility) || (this.requestedVisibility != null && this.requestedVisibility.equals(other.requestedVisibility)))
                && ((this.revokeFailureReason == other.revokeFailureReason) || (this.revokeFailureReason != null && this.revokeFailureReason.equals(other.revokeFailureReason)))
                && ((this.effectiveAudience == other.effectiveAudience) || (this.effectiveAudience != null && this.effectiveAudience.equals(other.effectiveAudience)))
                && ((this.linkAccessLevel == other.linkAccessLevel) || (this.linkAccessLevel != null && this.linkAccessLevel.equals(other.linkAccessLevel)))
                && ((this.audienceOptions == other.audienceOptions) || (this.audienceOptions != null && this.audienceOptions.equals(other.audienceOptions)))
                && ((this.canSetPassword == other.canSetPassword) || (this.canSetPassword != null && this.canSetPassword.equals(other.canSetPassword)))
                && ((this.canRemovePassword == other.canRemovePassword) || (this.canRemovePassword != null && this.canRemovePassword.equals(other.canRemovePassword)))
                && ((this.requirePassword == other.requirePassword) || (this.requirePassword != null && this.requirePassword.equals(other.requirePassword)))
                && ((this.canUseExtendedSharingControls == other.canUseExtendedSharingControls) || (this.canUseExtendedSharingControls != null && this.canUseExtendedSharingControls.equals(other.canUseExtendedSharingControls)))
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
    static class Serializer extends StructSerializer<LinkPermissions> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkPermissions value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("can_revoke");
            StoneSerializers.boolean_().serialize(value.canRevoke, g);
            g.writeFieldName("visibility_policies");
            StoneSerializers.list(VisibilityPolicy.Serializer.INSTANCE).serialize(value.visibilityPolicies, g);
            g.writeFieldName("can_set_expiry");
            StoneSerializers.boolean_().serialize(value.canSetExpiry, g);
            g.writeFieldName("can_remove_expiry");
            StoneSerializers.boolean_().serialize(value.canRemoveExpiry, g);
            g.writeFieldName("allow_download");
            StoneSerializers.boolean_().serialize(value.allowDownload, g);
            g.writeFieldName("can_allow_download");
            StoneSerializers.boolean_().serialize(value.canAllowDownload, g);
            g.writeFieldName("can_disallow_download");
            StoneSerializers.boolean_().serialize(value.canDisallowDownload, g);
            g.writeFieldName("allow_comments");
            StoneSerializers.boolean_().serialize(value.allowComments, g);
            g.writeFieldName("team_restricts_comments");
            StoneSerializers.boolean_().serialize(value.teamRestrictsComments, g);
            if (value.resolvedVisibility != null) {
                g.writeFieldName("resolved_visibility");
                StoneSerializers.nullable(ResolvedVisibility.Serializer.INSTANCE).serialize(value.resolvedVisibility, g);
            }
            if (value.requestedVisibility != null) {
                g.writeFieldName("requested_visibility");
                StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).serialize(value.requestedVisibility, g);
            }
            if (value.revokeFailureReason != null) {
                g.writeFieldName("revoke_failure_reason");
                StoneSerializers.nullable(SharedLinkAccessFailureReason.Serializer.INSTANCE).serialize(value.revokeFailureReason, g);
            }
            if (value.effectiveAudience != null) {
                g.writeFieldName("effective_audience");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(value.effectiveAudience, g);
            }
            if (value.linkAccessLevel != null) {
                g.writeFieldName("link_access_level");
                StoneSerializers.nullable(LinkAccessLevel.Serializer.INSTANCE).serialize(value.linkAccessLevel, g);
            }
            if (value.audienceOptions != null) {
                g.writeFieldName("audience_options");
                StoneSerializers.nullable(StoneSerializers.list(LinkAudienceOption.Serializer.INSTANCE)).serialize(value.audienceOptions, g);
            }
            if (value.canSetPassword != null) {
                g.writeFieldName("can_set_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.canSetPassword, g);
            }
            if (value.canRemovePassword != null) {
                g.writeFieldName("can_remove_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.canRemovePassword, g);
            }
            if (value.requirePassword != null) {
                g.writeFieldName("require_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.requirePassword, g);
            }
            if (value.canUseExtendedSharingControls != null) {
                g.writeFieldName("can_use_extended_sharing_controls");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.canUseExtendedSharingControls, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LinkPermissions deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LinkPermissions value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_canRevoke = null;
                List<VisibilityPolicy> f_visibilityPolicies = null;
                Boolean f_canSetExpiry = null;
                Boolean f_canRemoveExpiry = null;
                Boolean f_allowDownload = null;
                Boolean f_canAllowDownload = null;
                Boolean f_canDisallowDownload = null;
                Boolean f_allowComments = null;
                Boolean f_teamRestrictsComments = null;
                ResolvedVisibility f_resolvedVisibility = null;
                RequestedVisibility f_requestedVisibility = null;
                SharedLinkAccessFailureReason f_revokeFailureReason = null;
                LinkAudience f_effectiveAudience = null;
                LinkAccessLevel f_linkAccessLevel = null;
                List<LinkAudienceOption> f_audienceOptions = null;
                Boolean f_canSetPassword = null;
                Boolean f_canRemovePassword = null;
                Boolean f_requirePassword = null;
                Boolean f_canUseExtendedSharingControls = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("can_revoke".equals(field)) {
                        f_canRevoke = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("visibility_policies".equals(field)) {
                        f_visibilityPolicies = StoneSerializers.list(VisibilityPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("can_set_expiry".equals(field)) {
                        f_canSetExpiry = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("can_remove_expiry".equals(field)) {
                        f_canRemoveExpiry = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("allow_download".equals(field)) {
                        f_allowDownload = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("can_allow_download".equals(field)) {
                        f_canAllowDownload = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("can_disallow_download".equals(field)) {
                        f_canDisallowDownload = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("allow_comments".equals(field)) {
                        f_allowComments = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("team_restricts_comments".equals(field)) {
                        f_teamRestrictsComments = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("resolved_visibility".equals(field)) {
                        f_resolvedVisibility = StoneSerializers.nullable(ResolvedVisibility.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("requested_visibility".equals(field)) {
                        f_requestedVisibility = StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("revoke_failure_reason".equals(field)) {
                        f_revokeFailureReason = StoneSerializers.nullable(SharedLinkAccessFailureReason.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("effective_audience".equals(field)) {
                        f_effectiveAudience = StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("link_access_level".equals(field)) {
                        f_linkAccessLevel = StoneSerializers.nullable(LinkAccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("audience_options".equals(field)) {
                        f_audienceOptions = StoneSerializers.nullable(StoneSerializers.list(LinkAudienceOption.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("can_set_password".equals(field)) {
                        f_canSetPassword = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("can_remove_password".equals(field)) {
                        f_canRemovePassword = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("require_password".equals(field)) {
                        f_requirePassword = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("can_use_extended_sharing_controls".equals(field)) {
                        f_canUseExtendedSharingControls = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_canRevoke == null) {
                    throw new JsonParseException(p, "Required field \"can_revoke\" missing.");
                }
                if (f_visibilityPolicies == null) {
                    throw new JsonParseException(p, "Required field \"visibility_policies\" missing.");
                }
                if (f_canSetExpiry == null) {
                    throw new JsonParseException(p, "Required field \"can_set_expiry\" missing.");
                }
                if (f_canRemoveExpiry == null) {
                    throw new JsonParseException(p, "Required field \"can_remove_expiry\" missing.");
                }
                if (f_allowDownload == null) {
                    throw new JsonParseException(p, "Required field \"allow_download\" missing.");
                }
                if (f_canAllowDownload == null) {
                    throw new JsonParseException(p, "Required field \"can_allow_download\" missing.");
                }
                if (f_canDisallowDownload == null) {
                    throw new JsonParseException(p, "Required field \"can_disallow_download\" missing.");
                }
                if (f_allowComments == null) {
                    throw new JsonParseException(p, "Required field \"allow_comments\" missing.");
                }
                if (f_teamRestrictsComments == null) {
                    throw new JsonParseException(p, "Required field \"team_restricts_comments\" missing.");
                }
                value = new LinkPermissions(f_canRevoke, f_visibilityPolicies, f_canSetExpiry, f_canRemoveExpiry, f_allowDownload, f_canAllowDownload, f_canDisallowDownload, f_allowComments, f_teamRestrictsComments, f_resolvedVisibility, f_requestedVisibility, f_revokeFailureReason, f_effectiveAudience, f_linkAccessLevel, f_audienceOptions, f_canSetPassword, f_canRemovePassword, f_requirePassword, f_canUseExtendedSharingControls);
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
