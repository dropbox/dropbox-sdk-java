/* DO NOT EDIT */
/* This file was generated from shared_content_links.stone */

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

/**
 * Permissions for actions that can be performed on a link.
 */
public class LinkPermission {
    // struct sharing.LinkPermission (shared_content_links.stone)

    protected final LinkAction action;
    protected final boolean allow;
    protected final PermissionDeniedReason reason;

    /**
     * Permissions for actions that can be performed on a link.
     *
     * @param action  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkPermission(LinkAction action, boolean allow, PermissionDeniedReason reason) {
        if (action == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = action;
        this.allow = allow;
        this.reason = reason;
    }

    /**
     * Permissions for actions that can be performed on a link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param action  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkPermission(LinkAction action, boolean allow) {
        this(action, allow, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public LinkAction getAction() {
        return action;
    }

    /**
     *
     * @return value for this field.
     */
    public boolean getAllow() {
        return allow;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public PermissionDeniedReason getReason() {
        return reason;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            action,
            allow,
            reason
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
            LinkPermission other = (LinkPermission) obj;
            return ((this.action == other.action) || (this.action.equals(other.action)))
                && (this.allow == other.allow)
                && ((this.reason == other.reason) || (this.reason != null && this.reason.equals(other.reason)))
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
    static class Serializer extends StructSerializer<LinkPermission> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkPermission value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("action");
            LinkAction.Serializer.INSTANCE.serialize(value.action, g);
            g.writeFieldName("allow");
            StoneSerializers.boolean_().serialize(value.allow, g);
            if (value.reason != null) {
                g.writeFieldName("reason");
                StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).serialize(value.reason, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LinkPermission deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LinkPermission value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                LinkAction f_action = null;
                Boolean f_allow = null;
                PermissionDeniedReason f_reason = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("action".equals(field)) {
                        f_action = LinkAction.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("allow".equals(field)) {
                        f_allow = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("reason".equals(field)) {
                        f_reason = StoneSerializers.nullable(PermissionDeniedReason.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_action == null) {
                    throw new JsonParseException(p, "Required field \"action\" missing.");
                }
                if (f_allow == null) {
                    throw new JsonParseException(p, "Required field \"allow\" missing.");
                }
                value = new LinkPermission(f_action, f_allow, f_reason);
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
