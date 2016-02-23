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
 * Whether the user is allowed to take the action on the associated member.
 */
public class MemberPermission {
    // struct MemberPermission

    private final MemberAction action;
    private final boolean allow;
    private final PermissionDeniedReason reason;

    /**
     * Whether the user is allowed to take the action on the associated member.
     *
     * @param action  The action that the user may wish to take on the member.
     *     Must not be {@code null}.
     * @param allow  True if the user is allowed to take the action.
     * @param reason  The reason why the user is denied the permission. Not
     *     present if the action is allowed.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberPermission(MemberAction action, boolean allow, PermissionDeniedReason reason) {
        if (action == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = action;
        this.allow = allow;
        this.reason = reason;
    }

    /**
     * Whether the user is allowed to take the action on the associated member.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param action  The action that the user may wish to take on the member.
     *     Must not be {@code null}.
     * @param allow  True if the user is allowed to take the action.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberPermission(MemberAction action, boolean allow) {
        this(action, allow, null);
    }

    /**
     * The action that the user may wish to take on the member.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberAction getAction() {
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
            MemberPermission other = (MemberPermission) obj;
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

    public static MemberPermission fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberPermission> _JSON_WRITER = new JsonWriter<MemberPermission>() {
        public final void write(MemberPermission x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MemberPermission._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MemberPermission x, JsonGenerator g) throws IOException {
            g.writeFieldName("action");
            MemberAction._JSON_WRITER.write(x.action, g);
            g.writeFieldName("allow");
            g.writeBoolean(x.allow);
            if (x.reason != null) {
                g.writeFieldName("reason");
                PermissionDeniedReason._JSON_WRITER.write(x.reason, g);
            }
        }
    };

    public static final JsonReader<MemberPermission> _JSON_READER = new JsonReader<MemberPermission>() {
        public final MemberPermission read(JsonParser parser) throws IOException, JsonReadException {
            MemberPermission result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MemberPermission readFields(JsonParser parser) throws IOException, JsonReadException {
            MemberAction action = null;
            Boolean allow = null;
            PermissionDeniedReason reason = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("action".equals(fieldName)) {
                    action = MemberAction._JSON_READER
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
            return new MemberPermission(action, allow, reason);
        }
    };
}
