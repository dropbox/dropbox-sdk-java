/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

package com.dropbox.core.v2.team;

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

public class RevokeLinkedAppBatchResult {
    // struct team.RevokeLinkedAppBatchResult (team_linked_apps.stone)

    protected final List<RevokeLinkedAppStatus> revokeLinkedAppStatus;

    /**
     *
     * @param revokeLinkedAppStatus  Must not contain a {@code null} item and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedAppBatchResult(List<RevokeLinkedAppStatus> revokeLinkedAppStatus) {
        if (revokeLinkedAppStatus == null) {
            throw new IllegalArgumentException("Required value for 'revokeLinkedAppStatus' is null");
        }
        for (RevokeLinkedAppStatus x : revokeLinkedAppStatus) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeLinkedAppStatus' is null");
            }
        }
        this.revokeLinkedAppStatus = revokeLinkedAppStatus;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<RevokeLinkedAppStatus> getRevokeLinkedAppStatus() {
        return revokeLinkedAppStatus;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            revokeLinkedAppStatus
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
            RevokeLinkedAppBatchResult other = (RevokeLinkedAppBatchResult) obj;
            return (this.revokeLinkedAppStatus == other.revokeLinkedAppStatus) || (this.revokeLinkedAppStatus.equals(other.revokeLinkedAppStatus));
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
    static class Serializer extends StructSerializer<RevokeLinkedAppBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeLinkedAppBatchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("revoke_linked_app_status");
            StoneSerializers.list(RevokeLinkedAppStatus.Serializer.INSTANCE).serialize(value.revokeLinkedAppStatus, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RevokeLinkedAppBatchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RevokeLinkedAppBatchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<RevokeLinkedAppStatus> f_revokeLinkedAppStatus = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("revoke_linked_app_status".equals(field)) {
                        f_revokeLinkedAppStatus = StoneSerializers.list(RevokeLinkedAppStatus.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_revokeLinkedAppStatus == null) {
                    throw new JsonParseException(p, "Required field \"revoke_linked_app_status\" missing.");
                }
                value = new RevokeLinkedAppBatchResult(f_revokeLinkedAppStatus);
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
