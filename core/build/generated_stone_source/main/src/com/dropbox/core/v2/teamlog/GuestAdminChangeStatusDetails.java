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
import javax.annotation.Nullable;

/**
 * Changed guest team admin status.
 */
public class GuestAdminChangeStatusDetails {
    // struct team_log.GuestAdminChangeStatusDetails (team_log_generated.stone)

    protected final boolean isGuest;
    @Nullable
    protected final String guestTeamName;
    @Nullable
    protected final String hostTeamName;
    @Nonnull
    protected final TrustedTeamsRequestState previousValue;
    @Nonnull
    protected final TrustedTeamsRequestState newValue;
    @Nonnull
    protected final TrustedTeamsRequestAction actionDetails;

    /**
     * Changed guest team admin status.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param isGuest  True for guest, false for host.
     * @param previousValue  Previous request state. Must not be {@code null}.
     * @param newValue  New request state. Must not be {@code null}.
     * @param actionDetails  Action details. Must not be {@code null}.
     * @param guestTeamName  The name of the guest team.
     * @param hostTeamName  The name of the host team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GuestAdminChangeStatusDetails(boolean isGuest, @Nonnull TrustedTeamsRequestState previousValue, @Nonnull TrustedTeamsRequestState newValue, @Nonnull TrustedTeamsRequestAction actionDetails, @Nullable String guestTeamName, @Nullable String hostTeamName) {
        this.isGuest = isGuest;
        this.guestTeamName = guestTeamName;
        this.hostTeamName = hostTeamName;
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        if (actionDetails == null) {
            throw new IllegalArgumentException("Required value for 'actionDetails' is null");
        }
        this.actionDetails = actionDetails;
    }

    /**
     * Changed guest team admin status.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param isGuest  True for guest, false for host.
     * @param previousValue  Previous request state. Must not be {@code null}.
     * @param newValue  New request state. Must not be {@code null}.
     * @param actionDetails  Action details. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GuestAdminChangeStatusDetails(boolean isGuest, @Nonnull TrustedTeamsRequestState previousValue, @Nonnull TrustedTeamsRequestState newValue, @Nonnull TrustedTeamsRequestAction actionDetails) {
        this(isGuest, previousValue, newValue, actionDetails, null, null);
    }

    /**
     * True for guest, false for host.
     *
     * @return value for this field.
     */
    public boolean getIsGuest() {
        return isGuest;
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

    /**
     * Action details.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TrustedTeamsRequestAction getActionDetails() {
        return actionDetails;
    }

    /**
     * The name of the guest team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getGuestTeamName() {
        return guestTeamName;
    }

    /**
     * The name of the host team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getHostTeamName() {
        return hostTeamName;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param isGuest  True for guest, false for host.
     * @param previousValue  Previous request state. Must not be {@code null}.
     * @param newValue  New request state. Must not be {@code null}.
     * @param actionDetails  Action details. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(boolean isGuest, TrustedTeamsRequestState previousValue, TrustedTeamsRequestState newValue, TrustedTeamsRequestAction actionDetails) {
        return new Builder(isGuest, previousValue, newValue, actionDetails);
    }

    /**
     * Builder for {@link GuestAdminChangeStatusDetails}.
     */
    public static class Builder {
        protected final boolean isGuest;
        protected final TrustedTeamsRequestState previousValue;
        protected final TrustedTeamsRequestState newValue;
        protected final TrustedTeamsRequestAction actionDetails;

        protected String guestTeamName;
        protected String hostTeamName;

        protected Builder(boolean isGuest, TrustedTeamsRequestState previousValue, TrustedTeamsRequestState newValue, TrustedTeamsRequestAction actionDetails) {
            this.isGuest = isGuest;
            if (previousValue == null) {
                throw new IllegalArgumentException("Required value for 'previousValue' is null");
            }
            this.previousValue = previousValue;
            if (newValue == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = newValue;
            if (actionDetails == null) {
                throw new IllegalArgumentException("Required value for 'actionDetails' is null");
            }
            this.actionDetails = actionDetails;
            this.guestTeamName = null;
            this.hostTeamName = null;
        }

        /**
         * Set value for optional field.
         *
         * @param guestTeamName  The name of the guest team.
         *
         * @return this builder
         */
        public Builder withGuestTeamName(String guestTeamName) {
            this.guestTeamName = guestTeamName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param hostTeamName  The name of the host team.
         *
         * @return this builder
         */
        public Builder withHostTeamName(String hostTeamName) {
            this.hostTeamName = hostTeamName;
            return this;
        }

        /**
         * Builds an instance of {@link GuestAdminChangeStatusDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link GuestAdminChangeStatusDetails}
         */
        public GuestAdminChangeStatusDetails build() {
            return new GuestAdminChangeStatusDetails(isGuest, previousValue, newValue, actionDetails, guestTeamName, hostTeamName);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            isGuest,
            guestTeamName,
            hostTeamName,
            previousValue,
            newValue,
            actionDetails
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
            GuestAdminChangeStatusDetails other = (GuestAdminChangeStatusDetails) obj;
            return (this.isGuest == other.isGuest)
                && ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.actionDetails == other.actionDetails) || (this.actionDetails.equals(other.actionDetails)))
                && ((this.guestTeamName == other.guestTeamName) || (this.guestTeamName != null && this.guestTeamName.equals(other.guestTeamName)))
                && ((this.hostTeamName == other.hostTeamName) || (this.hostTeamName != null && this.hostTeamName.equals(other.hostTeamName)))
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
    static class Serializer extends StructSerializer<GuestAdminChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GuestAdminChangeStatusDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("is_guest");
            StoneSerializers.boolean_().serialize(value.isGuest, g);
            g.writeFieldName("previous_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            TrustedTeamsRequestState.Serializer.INSTANCE.serialize(value.newValue, g);
            g.writeFieldName("action_details");
            TrustedTeamsRequestAction.Serializer.INSTANCE.serialize(value.actionDetails, g);
            if (value.guestTeamName != null) {
                g.writeFieldName("guest_team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.guestTeamName, g);
            }
            if (value.hostTeamName != null) {
                g.writeFieldName("host_team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.hostTeamName, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GuestAdminChangeStatusDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GuestAdminChangeStatusDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isGuest = null;
                TrustedTeamsRequestState f_previousValue = null;
                TrustedTeamsRequestState f_newValue = null;
                TrustedTeamsRequestAction f_actionDetails = null;
                String f_guestTeamName = null;
                String f_hostTeamName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_guest".equals(field)) {
                        f_isGuest = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = TrustedTeamsRequestState.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("action_details".equals(field)) {
                        f_actionDetails = TrustedTeamsRequestAction.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("guest_team_name".equals(field)) {
                        f_guestTeamName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("host_team_name".equals(field)) {
                        f_hostTeamName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_isGuest == null) {
                    throw new JsonParseException(p, "Required field \"is_guest\" missing.");
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                if (f_actionDetails == null) {
                    throw new JsonParseException(p, "Required field \"action_details\" missing.");
                }
                value = new GuestAdminChangeStatusDetails(f_isGuest, f_previousValue, f_newValue, f_actionDetails, f_guestTeamName, f_hostTeamName);
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
