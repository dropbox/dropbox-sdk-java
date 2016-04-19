/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

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

@JsonSerialize(using=LinkPermissions.Serializer.class)
@JsonDeserialize(using=LinkPermissions.Deserializer.class)
public class LinkPermissions {
    // struct LinkPermissions

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final ResolvedVisibility resolvedVisibility;
    protected final RequestedVisibility requestedVisibility;
    protected final boolean canRevoke;
    protected final SharedLinkAccessFailureReason revokeFailureReason;

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
     *     access to this data).
     * @param requestedVisibility  The shared link's requested visibility. This
     *     can be overridden by the team and shared folder policies. The final
     *     visibility, after considering these policies, can be found in {@link
     *     LinkPermissions#getResolvedVisibility}. This is shown only if the
     *     caller is the link's owner.
     * @param revokeFailureReason  The failure reason for revoking the link.
     *     This field will only be present if the {@link
     *     LinkPermissions#getCanRevoke} is {@code false}.
     */
    public LinkPermissions(boolean canRevoke, ResolvedVisibility resolvedVisibility, RequestedVisibility requestedVisibility, SharedLinkAccessFailureReason revokeFailureReason) {
        this.resolvedVisibility = resolvedVisibility;
        this.requestedVisibility = requestedVisibility;
        this.canRevoke = canRevoke;
        this.revokeFailureReason = revokeFailureReason;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param canRevoke  Whether the caller can revoke the shared link.
     */
    public LinkPermissions(boolean canRevoke) {
        this(canRevoke, null, null, null);
    }

    /**
     * The current visibility of the link after considering the shared links
     * policies of the the team (in case the link's owner is part of a team) and
     * the shared folder (in case the linked file is part of a shared folder).
     * This field is shown only if the caller has access to this info (the
     * link's owner always has access to this data).
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
     * is the link's owner.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public RequestedVisibility getRequestedVisibility() {
        return requestedVisibility;
    }

    /**
     * Whether the caller can revoke the shared link
     *
     * @return value for this field.
     */
    public boolean getCanRevoke() {
        return canRevoke;
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

        protected Builder(boolean canRevoke) {
            this.canRevoke = canRevoke;
            this.resolvedVisibility = null;
            this.requestedVisibility = null;
            this.revokeFailureReason = null;
        }

        /**
         * Set value for optional field.
         *
         * @param resolvedVisibility  The current visibility of the link after
         *     considering the shared links policies of the the team (in case
         *     the link's owner is part of a team) and the shared folder (in
         *     case the linked file is part of a shared folder). This field is
         *     shown only if the caller has access to this info (the link's
         *     owner always has access to this data).
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
         *     shown only if the caller is the link's owner.
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
         * Builds an instance of {@link LinkPermissions} configured with this
         * builder's values
         *
         * @return new instance of {@link LinkPermissions}
         */
        public LinkPermissions build() {
            return new LinkPermissions(canRevoke, resolvedVisibility, requestedVisibility, revokeFailureReason);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            resolvedVisibility,
            requestedVisibility,
            canRevoke,
            revokeFailureReason
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
            LinkPermissions other = (LinkPermissions) obj;
            return (this.canRevoke == other.canRevoke)
                && ((this.resolvedVisibility == other.resolvedVisibility) || (this.resolvedVisibility != null && this.resolvedVisibility.equals(other.resolvedVisibility)))
                && ((this.requestedVisibility == other.requestedVisibility) || (this.requestedVisibility != null && this.requestedVisibility.equals(other.requestedVisibility)))
                && ((this.revokeFailureReason == other.revokeFailureReason) || (this.revokeFailureReason != null && this.revokeFailureReason.equals(other.revokeFailureReason)))
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

    static final class Serializer extends StructJsonSerializer<LinkPermissions> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(LinkPermissions.class);
        }

        public Serializer(boolean unwrapping) {
            super(LinkPermissions.class, unwrapping);
        }

        @Override
        protected JsonSerializer<LinkPermissions> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(LinkPermissions value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("can_revoke", value.canRevoke);
            if (value.resolvedVisibility != null) {
                g.writeObjectField("resolved_visibility", value.resolvedVisibility);
            }
            if (value.requestedVisibility != null) {
                g.writeObjectField("requested_visibility", value.requestedVisibility);
            }
            if (value.revokeFailureReason != null) {
                g.writeObjectField("revoke_failure_reason", value.revokeFailureReason);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<LinkPermissions> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(LinkPermissions.class);
        }

        public Deserializer(boolean unwrapping) {
            super(LinkPermissions.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<LinkPermissions> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public LinkPermissions deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Boolean canRevoke = null;
            ResolvedVisibility resolvedVisibility = null;
            RequestedVisibility requestedVisibility = null;
            SharedLinkAccessFailureReason revokeFailureReason = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("can_revoke".equals(_field)) {
                    canRevoke = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("resolved_visibility".equals(_field)) {
                    resolvedVisibility = _p.readValueAs(ResolvedVisibility.class);
                    _p.nextToken();
                }
                else if ("requested_visibility".equals(_field)) {
                    requestedVisibility = _p.readValueAs(RequestedVisibility.class);
                    _p.nextToken();
                }
                else if ("revoke_failure_reason".equals(_field)) {
                    revokeFailureReason = _p.readValueAs(SharedLinkAccessFailureReason.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (canRevoke == null) {
                throw new JsonParseException(_p, "Required field \"can_revoke\" is missing.");
            }

            return new LinkPermissions(canRevoke, resolvedVisibility, requestedVisibility, revokeFailureReason);
        }
    }
}
