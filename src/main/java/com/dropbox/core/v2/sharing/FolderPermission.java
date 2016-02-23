/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Whether the user is allowed to take the action on the shared folder.
 */
public class FolderPermission {
    // struct FolderPermission

    private final FolderAction action;
    private final boolean allow;
    private final PermissionDeniedReason reason;

    /**
     * Whether the user is allowed to take the action on the shared folder.
     *
     * @param action  The action that the user may wish to take on the folder.
     *     Must not be {@code null}.
     * @param allow  True if the user is allowed to take the action.
     * @param reason  The reason why the user is denied the permission. Not
     *     present if the action is allowed.
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
     * action is allowed
     *
     * @return value for this field, or {@code null} if not present.
     */
    public PermissionDeniedReason getReason() {
        return reason;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static FolderPermission fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FolderPermission> _JSON_WRITER = new JsonWriter<FolderPermission>() {
        public final void write(FolderPermission x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            FolderPermission._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FolderPermission x, JsonGenerator g) throws IOException {
            g.writeFieldName("action");
            FolderAction._JSON_WRITER.write(x.action, g);
            g.writeFieldName("allow");
            g.writeBoolean(x.allow);
            if (x.reason != null) {
                g.writeFieldName("reason");
                PermissionDeniedReason._JSON_WRITER.write(x.reason, g);
            }
        }
    };

    public static final JsonReader<FolderPermission> _JSON_READER = new JsonReader<FolderPermission>() {
        public final FolderPermission read(JsonParser parser) throws IOException, JsonReadException {
            FolderPermission result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FolderPermission readFields(JsonParser parser) throws IOException, JsonReadException {
            FolderAction action = null;
            Boolean allow = null;
            PermissionDeniedReason reason = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("action".equals(fieldName)) {
                    action = FolderAction._JSON_READER
                        .readField(parser, "action", action);
                }
                else if ("allow".equals(fieldName)) {
                    allow = JsonReader.BooleanReader
                        .readField(parser, "allow", allow);
                }
                else if ("reason".equals(fieldName)) {
                    reason = PermissionDeniedReason._JSON_READER
                        .readField(parser, "reason", reason);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (action == null) {
                throw new JsonReadException("Required field \"action\" is missing.", parser.getTokenLocation());
            }
            if (allow == null) {
                throw new JsonReadException("Required field \"allow\" is missing.", parser.getTokenLocation());
            }
            return new FolderPermission(action, allow, reason);
        }
    };
}
