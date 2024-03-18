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
 * Allowed non-collaborators to view links to files in shared folder.
 */
public class SfAllowNonMembersToViewSharedLinksDetails {
    // struct team_log.SfAllowNonMembersToViewSharedLinksDetails (team_log_generated.stone)

    protected final long targetAssetIndex;
    @Nonnull
    protected final String originalFolderName;
    @Nullable
    protected final String sharedFolderType;

    /**
     * Allowed non-collaborators to view links to files in shared folder.
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     * @param sharedFolderType  Shared folder type.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SfAllowNonMembersToViewSharedLinksDetails(long targetAssetIndex, @Nonnull String originalFolderName, @Nullable String sharedFolderType) {
        this.targetAssetIndex = targetAssetIndex;
        if (originalFolderName == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = originalFolderName;
        this.sharedFolderType = sharedFolderType;
    }

    /**
     * Allowed non-collaborators to view links to files in shared folder.
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
    public SfAllowNonMembersToViewSharedLinksDetails(long targetAssetIndex, @Nonnull String originalFolderName) {
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
    @Nonnull
    public String getOriginalFolderName() {
        return originalFolderName;
    }

    /**
     * Shared folder type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSharedFolderType() {
        return sharedFolderType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            targetAssetIndex,
            originalFolderName,
            sharedFolderType
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
            SfAllowNonMembersToViewSharedLinksDetails other = (SfAllowNonMembersToViewSharedLinksDetails) obj;
            return (this.targetAssetIndex == other.targetAssetIndex)
                && ((this.originalFolderName == other.originalFolderName) || (this.originalFolderName.equals(other.originalFolderName)))
                && ((this.sharedFolderType == other.sharedFolderType) || (this.sharedFolderType != null && this.sharedFolderType.equals(other.sharedFolderType)))
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
    static class Serializer extends StructSerializer<SfAllowNonMembersToViewSharedLinksDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SfAllowNonMembersToViewSharedLinksDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(value.targetAssetIndex, g);
            g.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(value.originalFolderName, g);
            if (value.sharedFolderType != null) {
                g.writeFieldName("shared_folder_type");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedFolderType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SfAllowNonMembersToViewSharedLinksDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SfAllowNonMembersToViewSharedLinksDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_targetAssetIndex = null;
                String f_originalFolderName = null;
                String f_sharedFolderType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("target_asset_index".equals(field)) {
                        f_targetAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("original_folder_name".equals(field)) {
                        f_originalFolderName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("shared_folder_type".equals(field)) {
                        f_sharedFolderType = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new SfAllowNonMembersToViewSharedLinksDetails(f_targetAssetIndex, f_originalFolderName, f_sharedFolderType);
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
