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
 * Invited Facebook users to shared folder.
 */
public class SfFbInviteDetails {
    // struct team_log.SfFbInviteDetails (team_log_generated.stone)

    protected final long targetAssetIndex;
    protected final String originalFolderName;
    protected final String sharingPermission;

    /**
     * Invited Facebook users to shared folder.
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     * @param sharingPermission  Sharing permission.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SfFbInviteDetails(long targetAssetIndex, String originalFolderName, String sharingPermission) {
        this.targetAssetIndex = targetAssetIndex;
        if (originalFolderName == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = originalFolderName;
        this.sharingPermission = sharingPermission;
    }

    /**
     * Invited Facebook users to shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SfFbInviteDetails(long targetAssetIndex, String originalFolderName) {
        this(targetAssetIndex, originalFolderName, null);
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
    @javax.annotation.Nonnull
    public String getOriginalFolderName() {
        return originalFolderName;
    }

    /**
     * Sharing permission.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getSharingPermission() {
        return sharingPermission;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            targetAssetIndex,
            originalFolderName,
            sharingPermission
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
            SfFbInviteDetails other = (SfFbInviteDetails) obj;
            return (this.targetAssetIndex == other.targetAssetIndex)
                && ((this.originalFolderName == other.originalFolderName) || (this.originalFolderName.equals(other.originalFolderName)))
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
    static class Serializer extends StructSerializer<SfFbInviteDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SfFbInviteDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(value.targetAssetIndex, g);
            g.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(value.originalFolderName, g);
            if (value.sharingPermission != null) {
                g.writeFieldName("sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharingPermission, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SfFbInviteDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SfFbInviteDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_targetAssetIndex = null;
                String f_originalFolderName = null;
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
                value = new SfFbInviteDetails(f_targetAssetIndex, f_originalFolderName, f_sharingPermission);
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
