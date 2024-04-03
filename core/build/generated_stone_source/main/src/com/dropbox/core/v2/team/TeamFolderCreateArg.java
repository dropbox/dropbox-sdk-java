/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.files.SyncSettingArg;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class TeamFolderCreateArg {
    // struct team.TeamFolderCreateArg (team_folders.stone)

    @Nonnull
    protected final String name;
    @Nullable
    protected final SyncSettingArg syncSetting;

    /**
     *
     * @param name  Name for the new team folder. Must not be {@code null}.
     * @param syncSetting  The sync setting to apply to this team folder. Only
     *     permitted if the team has team selective sync enabled.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderCreateArg(@Nonnull String name, @Nullable SyncSettingArg syncSetting) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.syncSetting = syncSetting;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  Name for the new team folder. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderCreateArg(@Nonnull String name) {
        this(name, null);
    }

    /**
     * Name for the new team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * The sync setting to apply to this team folder. Only permitted if the team
     * has team selective sync enabled.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SyncSettingArg getSyncSetting() {
        return syncSetting;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.name,
            this.syncSetting
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
            TeamFolderCreateArg other = (TeamFolderCreateArg) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.syncSetting == other.syncSetting) || (this.syncSetting != null && this.syncSetting.equals(other.syncSetting)))
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
    static class Serializer extends StructSerializer<TeamFolderCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderCreateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (value.syncSetting != null) {
                g.writeFieldName("sync_setting");
                StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).serialize(value.syncSetting, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderCreateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderCreateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                SyncSettingArg f_syncSetting = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sync_setting".equals(field)) {
                        f_syncSetting = StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                value = new TeamFolderCreateArg(f_name, f_syncSetting);
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
