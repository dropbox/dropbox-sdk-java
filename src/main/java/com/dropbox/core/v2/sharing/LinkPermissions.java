/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class LinkPermissions {
    // struct LinkPermissions

    private final ResolvedVisibility resolvedVisibility;
    private final RequestedVisibility requestedVisibility;
    private final boolean canRevoke;
    private final SharedLinkAccessFailureReason revokeFailureReason;

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
            return ((this.resolvedVisibility == other.resolvedVisibility) || (this.resolvedVisibility != null && this.resolvedVisibility.equals(other.resolvedVisibility)))
                && ((this.requestedVisibility == other.requestedVisibility) || (this.requestedVisibility != null && this.requestedVisibility.equals(other.requestedVisibility)))
                && (this.canRevoke == other.canRevoke)
                && ((this.revokeFailureReason == other.revokeFailureReason) || (this.revokeFailureReason != null && this.revokeFailureReason.equals(other.revokeFailureReason)))
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

    public static LinkPermissions fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<LinkPermissions> _JSON_WRITER = new JsonWriter<LinkPermissions>() {
        public final void write(LinkPermissions x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            LinkPermissions._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(LinkPermissions x, JsonGenerator g) throws IOException {
            if (x.resolvedVisibility != null) {
                g.writeFieldName("resolved_visibility");
                ResolvedVisibility._JSON_WRITER.write(x.resolvedVisibility, g);
            }
            if (x.requestedVisibility != null) {
                g.writeFieldName("requested_visibility");
                RequestedVisibility._JSON_WRITER.write(x.requestedVisibility, g);
            }
            g.writeFieldName("can_revoke");
            g.writeBoolean(x.canRevoke);
            if (x.revokeFailureReason != null) {
                g.writeFieldName("revoke_failure_reason");
                SharedLinkAccessFailureReason._JSON_WRITER.write(x.revokeFailureReason, g);
            }
        }
    };

    public static final JsonReader<LinkPermissions> _JSON_READER = new JsonReader<LinkPermissions>() {
        public final LinkPermissions read(JsonParser parser) throws IOException, JsonReadException {
            LinkPermissions result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final LinkPermissions readFields(JsonParser parser) throws IOException, JsonReadException {
            Boolean canRevoke = null;
            ResolvedVisibility resolvedVisibility = null;
            RequestedVisibility requestedVisibility = null;
            SharedLinkAccessFailureReason revokeFailureReason = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("can_revoke".equals(fieldName)) {
                    canRevoke = JsonReader.BooleanReader
                        .readField(parser, "can_revoke", canRevoke);
                }
                else if ("resolved_visibility".equals(fieldName)) {
                    resolvedVisibility = ResolvedVisibility._JSON_READER
                        .readField(parser, "resolved_visibility", resolvedVisibility);
                }
                else if ("requested_visibility".equals(fieldName)) {
                    requestedVisibility = RequestedVisibility._JSON_READER
                        .readField(parser, "requested_visibility", requestedVisibility);
                }
                else if ("revoke_failure_reason".equals(fieldName)) {
                    revokeFailureReason = SharedLinkAccessFailureReason._JSON_READER
                        .readField(parser, "revoke_failure_reason", revokeFailureReason);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (canRevoke == null) {
                throw new JsonReadException("Required field \"can_revoke\" is missing.", parser.getTokenLocation());
            }
            return new LinkPermissions(canRevoke, resolvedVisibility, requestedVisibility, revokeFailureReason);
        }
    };
}
