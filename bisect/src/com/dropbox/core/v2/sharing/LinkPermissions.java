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

public class LinkPermissions {
    // struct sharing.LinkPermissions (shared_links.stone)

    protected final ResolvedVisibility resolvedVisibility;
    protected final RequestedVisibility requestedVisibility;
    protected final boolean canRevoke;
    protected final SharedLinkAccessFailureReason revokeFailureReason;
    protected final LinkAudience effectiveAudience;
    protected final LinkAccessLevel linkAccessLevel;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param canRevoke  Whether the caller can revoke the shared link.
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
     */
    public LinkPermissions(boolean canRevoke, ResolvedVisibility resolvedVisibility, RequestedVisibility requestedVisibility, SharedLinkAccessFailureReason revokeFailureReason, LinkAudience effectiveAudience, LinkAccessLevel linkAccessLevel) {
        this.resolvedVisibility = resolvedVisibility;
        this.requestedVisibility = requestedVisibility;
        this.canRevoke = canRevoke;
        this.revokeFailureReason = revokeFailureReason;
        this.effectiveAudience = effectiveAudience;
        this.linkAccessLevel = linkAccessLevel;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param canRevoke  Whether the caller can revoke the shared link.
     */
    public LinkPermissions(boolean canRevoke) {
        this(canRevoke, null, null, null, null, null);
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
     * The current visibility of the link after considering the shared links
     * policies of the the team (in case the link's owner is part of a team) and
     * the shared folder (in case the linked file is part of a shared folder).
     * This field is shown only if the caller has access to this info (the
     * link's owner always has access to this data). For some links, an
     * effective_audience value is returned instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
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
    public RequestedVisibility getRequestedVisibility() {
        return requestedVisibility;
    }

    /**
     * The failure reason for revoking the link. This field will only be present
     * if the {@link LinkPermissions#getCanRevoke} is {@code false}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public SharedLinkAccessFailureReason getRevokeFailureReason() {
        return revokeFailureReason;
    }

    /**
     * The type of audience who can benefit from the access level specified by
     * the `link_access_level` field.
     *
     * @return value for this field, or {@code null} if not present.
     */
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
    public LinkAccessLevel getLinkAccessLevel() {
        return linkAccessLevel;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param canRevoke  Whether the caller can revoke the shared link.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder(boolean canRevoke) {
        return new Builder(canRevoke);
    }

    /**
     * Builder for {@link LinkPermissions}.
     */
    public static class Builder {
        protected final boolean canRevoke;

        protected ResolvedVisibility resolvedVisibility;
        protected RequestedVisibility requestedVisibility;
        protected SharedLinkAccessFailureReason revokeFailureReason;
        protected LinkAudience effectiveAudience;
        protected LinkAccessLevel linkAccessLevel;

        protected Builder(boolean canRevoke) {
            this.canRevoke = canRevoke;
            this.resolvedVisibility = null;
            this.requestedVisibility = null;
            this.revokeFailureReason = null;
            this.effectiveAudience = null;
            this.linkAccessLevel = null;
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
         * Builds an instance of {@link LinkPermissions} configured with this
         * builder's values
         *
         * @return new instance of {@link LinkPermissions}
         */
        public LinkPermissions build() {
            return new LinkPermissions(canRevoke, resolvedVisibility, requestedVisibility, revokeFailureReason, effectiveAudience, linkAccessLevel);
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
            linkAccessLevel
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
                && ((this.resolvedVisibility == other.resolvedVisibility) || (this.resolvedVisibility != null && this.resolvedVisibility.equals(other.resolvedVisibility)))
                && ((this.requestedVisibility == other.requestedVisibility) || (this.requestedVisibility != null && this.requestedVisibility.equals(other.requestedVisibility)))
                && ((this.revokeFailureReason == other.revokeFailureReason) || (this.revokeFailureReason != null && this.revokeFailureReason.equals(other.revokeFailureReason)))
                && ((this.effectiveAudience == other.effectiveAudience) || (this.effectiveAudience != null && this.effectiveAudience.equals(other.effectiveAudience)))
                && ((this.linkAccessLevel == other.linkAccessLevel) || (this.linkAccessLevel != null && this.linkAccessLevel.equals(other.linkAccessLevel)))
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
                ResolvedVisibility f_resolvedVisibility = null;
                RequestedVisibility f_requestedVisibility = null;
                SharedLinkAccessFailureReason f_revokeFailureReason = null;
                LinkAudience f_effectiveAudience = null;
                LinkAccessLevel f_linkAccessLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("can_revoke".equals(field)) {
                        f_canRevoke = StoneSerializers.boolean_().deserialize(p);
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
                    else {
                        skipValue(p);
                    }
                }
                if (f_canRevoke == null) {
                    throw new JsonParseException(p, "Required field \"can_revoke\" missing.");
                }
                value = new LinkPermissions(f_canRevoke, f_resolvedVisibility, f_requestedVisibility, f_revokeFailureReason, f_effectiveAudience, f_linkAccessLevel);
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
