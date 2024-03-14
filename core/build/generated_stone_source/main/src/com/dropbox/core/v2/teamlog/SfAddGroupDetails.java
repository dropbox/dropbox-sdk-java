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
 * Added team to shared folder.
 */
public class SfAddGroupDetails {
    // struct team_log.SfAddGroupDetails (team_log_generated.stone)

    protected final long targetAssetIndex;
    protected final String originalFolderName;
    protected final String sharingPermission;
    protected final String teamName;

    /**
     * Added team to shared folder.
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     * @param teamName  Team name. Must not be {@code null}.
     * @param sharingPermission  Sharing permission.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SfAddGroupDetails(long targetAssetIndex, String originalFolderName, String teamName, String sharingPermission) {
        this.targetAssetIndex = targetAssetIndex;
        if (originalFolderName == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = originalFolderName;
        this.sharingPermission = sharingPermission;
        if (teamName == null) {
            throw new IllegalArgumentException("Required value for 'teamName' is null");
        }
        this.teamName = teamName;
    }

    /**
     * Added team to shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     * @param teamName  Team name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SfAddGroupDetails(long targetAssetIndex, String originalFolderName, String teamName) {
        this(targetAssetIndex, originalFolderName, teamName, null);
    }

    /**
     * Target asset position in the Assets list.
     *
     * @return value for this field.
     */
    public long getTargetAssetIndex() {
        return targetAssetIndex;
    }

    /**
     * Original shared folder name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getOriginalFolderName() {
        return originalFolderName;
    }

    /**
     * Team name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sharing permission.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getSharingPermission() {
        return sharingPermission;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            targetAssetIndex,
            originalFolderName,
            sharingPermission,
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
            SfAddGroupDetails other = (SfAddGroupDetails) obj;
            return (this.targetAssetIndex == other.targetAssetIndex)
                && ((this.originalFolderName == other.originalFolderName) || (this.originalFolderName.equals(other.originalFolderName)))
                && ((this.teamName == other.teamName) || (this.teamName.equals(other.teamName)))
                && ((this.sharingPermission == other.sharingPermission) || (this.sharingPermission != null && this.sharingPermission.equals(other.sharingPermission)))
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
    static class Serializer extends StructSerializer<SfAddGroupDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SfAddGroupDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(value.targetAssetIndex, g);
            g.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(value.originalFolderName, g);
            g.writeFieldName("team_name");
            StoneSerializers.string().serialize(value.teamName, g);
            if (value.sharingPermission != null) {
                g.writeFieldName("sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharingPermission, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SfAddGroupDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SfAddGroupDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_targetAssetIndex = null;
                String f_originalFolderName = null;
                String f_teamName = null;
                String f_sharingPermission = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("target_asset_index".equals(field)) {
                        f_targetAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("original_folder_name".equals(field)) {
                        f_originalFolderName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("team_name".equals(field)) {
                        f_teamName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sharing_permission".equals(field)) {
                        f_sharingPermission = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_targetAssetIndex == null) {
                    throw new JsonParseException(p, "Required field \"target_asset_index\" missing.");
                }
                if (f_originalFolderName == null) {
                    throw new JsonParseException(p, "Required field \"original_folder_name\" missing.");
                }
                if (f_teamName == null) {
                    throw new JsonParseException(p, "Required field \"team_name\" missing.");
                }
                value = new SfAddGroupDetails(f_targetAssetIndex, f_originalFolderName, f_teamName, f_sharingPermission);
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
