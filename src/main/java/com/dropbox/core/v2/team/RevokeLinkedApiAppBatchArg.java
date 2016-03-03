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

@JsonSerialize(using=RevokeLinkedApiAppBatchArg.Serializer.class)
@JsonDeserialize(using=RevokeLinkedApiAppBatchArg.Deserializer.class)
class RevokeLinkedApiAppBatchArg {
    // struct RevokeLinkedApiAppBatchArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<RevokeLinkedApiAppArg> revokeLinkedApp;

    /**
     *
     * @param revokeLinkedApp  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedApiAppBatchArg(List<RevokeLinkedApiAppArg> revokeLinkedApp) {
        if (revokeLinkedApp == null) {
            throw new IllegalArgumentException("Required value for 'revokeLinkedApp' is null");
        }
        for (RevokeLinkedApiAppArg x : revokeLinkedApp) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeLinkedApp' is null");
            }
        }
        this.revokeLinkedApp = revokeLinkedApp;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<RevokeLinkedApiAppArg> getRevokeLinkedApp() {
        return revokeLinkedApp;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            revokeLinkedApp
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
            RevokeLinkedApiAppBatchArg other = (RevokeLinkedApiAppBatchArg) obj;
            return (this.revokeLinkedApp == other.revokeLinkedApp) || (this.revokeLinkedApp.equals(other.revokeLinkedApp));
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

    static final class Serializer extends StructJsonSerializer<RevokeLinkedApiAppBatchArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeLinkedApiAppBatchArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(RevokeLinkedApiAppBatchArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RevokeLinkedApiAppBatchArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RevokeLinkedApiAppBatchArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("revoke_linked_app", value.revokeLinkedApp);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RevokeLinkedApiAppBatchArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeLinkedApiAppBatchArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RevokeLinkedApiAppBatchArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RevokeLinkedApiAppBatchArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RevokeLinkedApiAppBatchArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<RevokeLinkedApiAppArg> revokeLinkedApp = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("revoke_linked_app".equals(_field)) {
                    expectArrayStart(_p);
                    revokeLinkedApp = new java.util.ArrayList<RevokeLinkedApiAppArg>();
                    while (!isArrayEnd(_p)) {
                        RevokeLinkedApiAppArg _x = null;
                        _x = _p.readValueAs(RevokeLinkedApiAppArg.class);
                        _p.nextToken();
                        revokeLinkedApp.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (revokeLinkedApp == null) {
                throw new JsonParseException(_p, "Required field \"revoke_linked_app\" is missing.");
            }

            return new RevokeLinkedApiAppBatchArg(revokeLinkedApp);
        }
    }
}
