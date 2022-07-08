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

/**
 * Whether the user is allowed to take the action on the shared folder.
 */
public class FolderPermission {
    // struct sharing.FolderPermission (sharing_folders.stone)

    protected final FolderAction action;
    protected final boolean allow;
    protected final PermissionDeniedReason reason;

    /**
     * Whether the user is allowed to take the action on the shared folder.
     *
     * @param action  The action that the user may wish to take on the folder.
     *     Must not be {@code null}.
     * @param allow  True if the user is allowed to take the action.
     * @param reason  The reason why the user is denied the permission. Not
     *     present if the action is allowed, or if no reason is available.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderPermission(FolderAction action, boolean allow, PermissionDeniedReason reason) {
        if (action == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = action;
        this.allow = allow;
        this.reason = reason;
    }

    /**
     * Whether the user is allowed to take the action on the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param action  The action that the user may wish to take on the folder.
     *     Must not be {@code null}.
     * @param allow  True if the user is allowed to take the action.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderPermission(FolderAction action, boolean allow) {
        this(action, allow, null);
    }

    /**
     * The action that the user may wish to take on the folder.
     *
     * @return value for this field, never {@code null}.
     */
    public FolderAction getAction() {
        return action;
    }

    /**
     * True if the user is allowed to take the action.
     *
     * @return value for this field.
     */
    public boolean getAllow() {
        return allow;
    }

    /**
     * The reason why the user is denied the permission. Not present if the
     * action is allowed, or if no reason is available.
     *
     * @return value for this field, or {@code null} if not present.
     */
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
            FolderPermission other = (FolderPermission) obj;
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
    static class Serializer extends StructSerializer<FolderPermission> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderPermission value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("action");
            FolderAction.Serializer.INSTANCE.serialize(value.action, g);
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
        public FolderPermission deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderPermission value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FolderAction f_action = null;
                Boolean f_allow = null;
                PermissionDeniedReason f_reason = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("action".equals(field)) {
                        f_action = FolderAction.Serializer.INSTANCE.deserialize(p);
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
                value = new FolderPermission(f_action, f_allow, f_reason);
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
