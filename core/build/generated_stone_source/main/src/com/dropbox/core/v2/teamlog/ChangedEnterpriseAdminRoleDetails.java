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
 * Changed enterprise admin role.
 */
public class ChangedEnterpriseAdminRoleDetails {
    // struct team_log.ChangedEnterpriseAdminRoleDetails (team_log_generated.stone)

    protected final FedAdminRole previousValue;
    protected final FedAdminRole newValue;
    protected final String teamName;

    /**
     * Changed enterprise admin role.
     *
     * @param previousValue  The member&amp;#x2019s previous enterprise admin
     *     role. Must not be {@code null}.
     * @param newValue  The member&amp;#x2019s new enterprise admin role. Must
     *     not be {@code null}.
     * @param teamName  The name of the member&amp;#x2019s team. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ChangedEnterpriseAdminRoleDetails(FedAdminRole previousValue, FedAdminRole newValue, String teamName) {
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        if (teamName == null) {
            throw new IllegalArgumentException("Required value for 'teamName' is null");
        }
        this.teamName = teamName;
    }

    /**
     * The member&amp;#x2019s previous enterprise admin role.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public FedAdminRole getPreviousValue() {
        return previousValue;
    }

    /**
     * The member&amp;#x2019s new enterprise admin role.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public FedAdminRole getNewValue() {
        return newValue;
    }

    /**
     * The name of the member&amp;#x2019s team.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamName() {
        return teamName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousValue,
            newValue,
            teamName
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
            ChangedEnterpriseAdminRoleDetails other = (ChangedEnterpriseAdminRoleDetails) obj;
            return ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.teamName == other.teamName) || (this.teamName.equals(other.teamName)))
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
    static class Serializer extends StructSerializer<ChangedEnterpriseAdminRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ChangedEnterpriseAdminRoleDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            FedAdminRole.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            FedAdminRole.Serializer.INSTANCE.serialize(value.newValue, g);
            g.writeFieldName("team_name");
            StoneSerializers.string().serialize(value.teamName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ChangedEnterpriseAdminRoleDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ChangedEnterpriseAdminRoleDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FedAdminRole f_previousValue = null;
                FedAdminRole f_newValue = null;
                String f_teamName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = FedAdminRole.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = FedAdminRole.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("team_name".equals(field)) {
                        f_teamName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                if (f_teamName == null) {
                    throw new JsonParseException(p, "Required field \"team_name\" missing.");
                }
                value = new ChangedEnterpriseAdminRoleDetails(f_previousValue, f_newValue, f_teamName);
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
