/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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
 * Enabled/disabled network control.
 */
public class NetworkControlChangePolicyDetails {
    // struct team_log.NetworkControlChangePolicyDetails (team_log_generated.stone)

    protected final NetworkControlPolicy newValue;
    protected final NetworkControlPolicy previousValue;

    /**
     * Enabled/disabled network control.
     *
     * @param newValue  New network control policy. Must not be {@code null}.
     * @param previousValue  Previous network control policy. Might be missing
     *     due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public NetworkControlChangePolicyDetails(NetworkControlPolicy newValue, NetworkControlPolicy previousValue) {
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        this.previousValue = previousValue;
    }

    /**
     * Enabled/disabled network control.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newValue  New network control policy. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public NetworkControlChangePolicyDetails(NetworkControlPolicy newValue) {
        this(newValue, null);
    }

    /**
     * New network control policy.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public NetworkControlPolicy getNewValue() {
        return newValue;
    }

    /**
     * Previous network control policy. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public NetworkControlPolicy getPreviousValue() {
        return previousValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            newValue,
            previousValue
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
            NetworkControlChangePolicyDetails other = (NetworkControlChangePolicyDetails) obj;
            return ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
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
    static class Serializer extends StructSerializer<NetworkControlChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(NetworkControlChangePolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_value");
            NetworkControlPolicy.Serializer.INSTANCE.serialize(value.newValue, g);
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(NetworkControlPolicy.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public NetworkControlChangePolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            NetworkControlChangePolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                NetworkControlPolicy f_newValue = null;
                NetworkControlPolicy f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = NetworkControlPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(NetworkControlPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new NetworkControlChangePolicyDetails(f_newValue, f_previousValue);
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
