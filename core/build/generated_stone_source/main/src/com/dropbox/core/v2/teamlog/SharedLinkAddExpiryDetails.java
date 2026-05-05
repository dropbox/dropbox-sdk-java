/* DO NOT EDIT */
/* This file was generated from team_log_stone_gen_team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Added shared link expiration date.
 */
public class SharedLinkAddExpiryDetails {
    // struct team_log.SharedLinkAddExpiryDetails (team_log_stone_gen_team_log_generated.stone)

    @Nonnull
    protected final Date newValue;
    @Nullable
    protected final Boolean isConsolidationAction;

    /**
     * Added shared link expiration date.
     *
     * @param newValue  New shared link expiration date. Must not be {@code
     *     null}.
     * @param isConsolidationAction  Indicates whether this was a consolidation
     *     action by system.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkAddExpiryDetails(@Nonnull Date newValue, @Nullable Boolean isConsolidationAction) {
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = LangUtil.truncateMillis(newValue);
        this.isConsolidationAction = isConsolidationAction;
    }

    /**
     * Added shared link expiration date.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newValue  New shared link expiration date. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkAddExpiryDetails(@Nonnull Date newValue) {
        this(newValue, null);
    }

    /**
     * New shared link expiration date.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Date getNewValue() {
        return newValue;
    }

    /**
     * Indicates whether this was a consolidation action by system.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsConsolidationAction() {
        return isConsolidationAction;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.newValue,
            this.isConsolidationAction
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
            SharedLinkAddExpiryDetails other = (SharedLinkAddExpiryDetails) obj;
            return ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.isConsolidationAction == other.isConsolidationAction) || (this.isConsolidationAction != null && this.isConsolidationAction.equals(other.isConsolidationAction)))
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
    static class Serializer extends StructSerializer<SharedLinkAddExpiryDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkAddExpiryDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_value");
            StoneSerializers.timestamp().serialize(value.newValue, g);
            if (value.isConsolidationAction != null) {
                g.writeFieldName("is_consolidation_action");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isConsolidationAction, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkAddExpiryDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkAddExpiryDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_newValue = null;
                Boolean f_isConsolidationAction = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("is_consolidation_action".equals(field)) {
                        f_isConsolidationAction = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new SharedLinkAddExpiryDetails(f_newValue, f_isConsolidationAction);
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
