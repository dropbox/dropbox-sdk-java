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
 * Changed who can update a setting.
 */
public class EnterpriseSettingsLockingDetails {
    // struct team_log.EnterpriseSettingsLockingDetails (team_log_generated.stone)

    @Nonnull
    protected final String teamName;
    @Nonnull
    protected final String settingsPageName;
    @Nonnull
    protected final String previousSettingsPageLockingState;
    @Nonnull
    protected final String newSettingsPageLockingState;

    /**
     * Changed who can update a setting.
     *
     * @param teamName  The secondary team name. Must not be {@code null}.
     * @param settingsPageName  Settings page name. Must not be {@code null}.
     * @param previousSettingsPageLockingState  Previous locked settings page
     *     state. Must not be {@code null}.
     * @param newSettingsPageLockingState  New locked settings page state. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public EnterpriseSettingsLockingDetails(@Nonnull String teamName, @Nonnull String settingsPageName, @Nonnull String previousSettingsPageLockingState, @Nonnull String newSettingsPageLockingState) {
        if (teamName == null) {
            throw new IllegalArgumentException("Required value for 'teamName' is null");
        }
        this.teamName = teamName;
        if (settingsPageName == null) {
            throw new IllegalArgumentException("Required value for 'settingsPageName' is null");
        }
        this.settingsPageName = settingsPageName;
        if (previousSettingsPageLockingState == null) {
            throw new IllegalArgumentException("Required value for 'previousSettingsPageLockingState' is null");
        }
        this.previousSettingsPageLockingState = previousSettingsPageLockingState;
        if (newSettingsPageLockingState == null) {
            throw new IllegalArgumentException("Required value for 'newSettingsPageLockingState' is null");
        }
        this.newSettingsPageLockingState = newSettingsPageLockingState;
    }

    /**
     * The secondary team name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTeamName() {
        return teamName;
    }

    /**
     * Settings page name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSettingsPageName() {
        return settingsPageName;
    }

    /**
     * Previous locked settings page state.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPreviousSettingsPageLockingState() {
        return previousSettingsPageLockingState;
    }

    /**
     * New locked settings page state.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getNewSettingsPageLockingState() {
        return newSettingsPageLockingState;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.teamName,
            this.settingsPageName,
            this.previousSettingsPageLockingState,
            this.newSettingsPageLockingState
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
            EnterpriseSettingsLockingDetails other = (EnterpriseSettingsLockingDetails) obj;
            return ((this.teamName == other.teamName) || (this.teamName.equals(other.teamName)))
                && ((this.settingsPageName == other.settingsPageName) || (this.settingsPageName.equals(other.settingsPageName)))
                && ((this.previousSettingsPageLockingState == other.previousSettingsPageLockingState) || (this.previousSettingsPageLockingState.equals(other.previousSettingsPageLockingState)))
                && ((this.newSettingsPageLockingState == other.newSettingsPageLockingState) || (this.newSettingsPageLockingState.equals(other.newSettingsPageLockingState)))
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
    static class Serializer extends StructSerializer<EnterpriseSettingsLockingDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(EnterpriseSettingsLockingDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_name");
            StoneSerializers.string().serialize(value.teamName, g);
            g.writeFieldName("settings_page_name");
            StoneSerializers.string().serialize(value.settingsPageName, g);
            g.writeFieldName("previous_settings_page_locking_state");
            StoneSerializers.string().serialize(value.previousSettingsPageLockingState, g);
            g.writeFieldName("new_settings_page_locking_state");
            StoneSerializers.string().serialize(value.newSettingsPageLockingState, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public EnterpriseSettingsLockingDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            EnterpriseSettingsLockingDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamName = null;
                String f_settingsPageName = null;
                String f_previousSettingsPageLockingState = null;
                String f_newSettingsPageLockingState = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_name".equals(field)) {
                        f_teamName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("settings_page_name".equals(field)) {
                        f_settingsPageName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_settings_page_locking_state".equals(field)) {
                        f_previousSettingsPageLockingState = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_settings_page_locking_state".equals(field)) {
                        f_newSettingsPageLockingState = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamName == null) {
                    throw new JsonParseException(p, "Required field \"team_name\" missing.");
                }
                if (f_settingsPageName == null) {
                    throw new JsonParseException(p, "Required field \"settings_page_name\" missing.");
                }
                if (f_previousSettingsPageLockingState == null) {
                    throw new JsonParseException(p, "Required field \"previous_settings_page_locking_state\" missing.");
                }
                if (f_newSettingsPageLockingState == null) {
                    throw new JsonParseException(p, "Required field \"new_settings_page_locking_state\" missing.");
                }
                value = new EnterpriseSettingsLockingDetails(f_teamName, f_settingsPageName, f_previousSettingsPageLockingState, f_newSettingsPageLockingState);
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
