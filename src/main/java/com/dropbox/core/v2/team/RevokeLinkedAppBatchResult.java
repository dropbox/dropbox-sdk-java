/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

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
import java.util.List;

@JsonSerialize(using=RevokeLinkedAppBatchResult.Serializer.class)
@JsonDeserialize(using=RevokeLinkedAppBatchResult.Deserializer.class)
public class RevokeLinkedAppBatchResult {
    // struct RevokeLinkedAppBatchResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
    public List<RevokeLinkedAppStatus> getRevokeLinkedAppStatus() {
        return revokeLinkedAppStatus;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            revokeLinkedAppStatus
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
            RevokeLinkedAppBatchResult other = (RevokeLinkedAppBatchResult) obj;
            return (this.revokeLinkedAppStatus == other.revokeLinkedAppStatus) || (this.revokeLinkedAppStatus.equals(other.revokeLinkedAppStatus));
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

    static final class Serializer extends StructJsonSerializer<RevokeLinkedAppBatchResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeLinkedAppBatchResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(RevokeLinkedAppBatchResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RevokeLinkedAppBatchResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RevokeLinkedAppBatchResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("revoke_linked_app_status", value.revokeLinkedAppStatus);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RevokeLinkedAppBatchResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeLinkedAppBatchResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RevokeLinkedAppBatchResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RevokeLinkedAppBatchResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RevokeLinkedAppBatchResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<RevokeLinkedAppStatus> revokeLinkedAppStatus = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("revoke_linked_app_status".equals(_field)) {
                    expectArrayStart(_p);
                    revokeLinkedAppStatus = new java.util.ArrayList<RevokeLinkedAppStatus>();
                    while (!isArrayEnd(_p)) {
                        RevokeLinkedAppStatus _x = null;
                        _x = _p.readValueAs(RevokeLinkedAppStatus.class);
                        _p.nextToken();
                        revokeLinkedAppStatus.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (revokeLinkedAppStatus == null) {
                throw new JsonParseException(_p, "Required field \"revoke_linked_app_status\" is missing.");
            }

            return new RevokeLinkedAppBatchResult(revokeLinkedAppStatus);
        }
    }
}
