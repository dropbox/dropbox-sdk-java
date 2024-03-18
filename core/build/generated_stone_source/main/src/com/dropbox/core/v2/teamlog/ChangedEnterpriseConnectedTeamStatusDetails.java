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

import javax.annotation.Nonnull;

/**
 * Changed enterprise-connected team status.
 */
public class ChangedEnterpriseConnectedTeamStatusDetails {
    // struct team_log.ChangedEnterpriseConnectedTeamStatusDetails (team_log_generated.stone)

    @Nonnull
    protected final FedHandshakeAction action;
    @Nonnull
    protected final FederationStatusChangeAdditionalInfo additionalInfo;
    @Nonnull
    protected final TrustedTeamsRequestState previousValue;
    @Nonnull
    protected final TrustedTeamsRequestState newValue;

    /**
     * Changed enterprise-connected team status.
     *
     * @param action  The preformed change in the team&amp;#x2019s connection
     *     status. Must not be {@code null}.
     * @param additionalInfo  Additional information about the organization or
     *     team. Must not be {@code null}.
     * @param previousValue  Previous request state. Must not be {@code null}.
     * @param newValue  New request state. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ChangedEnterpriseConnectedTeamStatusDetails(@Nonnull FedHandshakeAction action, @Nonnull FederationStatusChangeAdditionalInfo additionalInfo, @Nonnull TrustedTeamsRequestState previousValue, @Nonnull TrustedTeamsRequestState newValue) {
        if (action == null) {
            throw new IllegalArgumentException("Required value for 'action' is null");
        }
        this.action = action;
        if (additionalInfo == null) {
            throw new IllegalArgumentException("Required value for 'additionalInfo' is null");
        }
        this.additionalInfo = additionalInfo;
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
    }

    /**
     * The preformed change in the team&amp;#x2019s connection status.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FedHandshakeAction getAction() {
        return action;
    }

    /**
     * Additional information about the organization or team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FederationStatusChangeAdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Previous request state.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TrustedTeamsRequestState getPreviousValue() {
        return previousValue;
    }

    /**
     * New request state.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TrustedTeamsRequestState getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            action,
            additionalInfo,
            previousValue,
            newValue
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
            ChangedEnterpriseConnectedTeamStatusDetails other = (ChangedEnterpriseConnectedTeamStatusDetails) obj;
            return ((this.action == other.action) || (this.action.equals(other.action)))
                && ((this.additionalInfo == other.additionalInfo) || (this.additionalInfo.equals(other.additionalInfo)))
                && ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
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
    static class Serializer extends StructSerializer<ChangedEnterpriseConnectedTeamStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ChangedEnterpriseConnectedTeamStatusDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("action");
            FedHandshakeAction.Serializer.INSTANCE.serialize(value.action, g);
            g.writeFieldName("additional_info");
            FederationStatusChangeAdditionalInfo.Serializer.INSTANCE.serialize(value.additionalInfo, g);
            g.writeFieldName("previous_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ChangedEnterpriseConnectedTeamStatusDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ChangedEnterpriseConnectedTeamStatusDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FedHandshakeAction f_action = null;
                FederationStatusChangeAdditionalInfo f_additionalInfo = null;
                TrustedTeamsRequestState f_previousValue = null;
                TrustedTeamsRequestState f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("action".equals(field)) {
                        f_action = FedHandshakeAction.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("additional_info".equals(field)) {
                        f_additionalInfo = FederationStatusChangeAdditionalInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_action == null) {
                    throw new JsonParseException(p, "Required field \"action\" missing.");
                }
                if (f_additionalInfo == null) {
                    throw new JsonParseException(p, "Required field \"additional_info\" missing.");
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new ChangedEnterpriseConnectedTeamStatusDetails(f_action, f_additionalInfo, f_previousValue, f_newValue);
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
