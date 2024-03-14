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
import java.util.List;

import javax.annotation.Nonnull;

/**
 * Pinned item to folder overview.
 */
public class FolderOverviewItemPinnedDetails {
    // struct team_log.FolderOverviewItemPinnedDetails (team_log_generated.stone)

    protected final long folderOverviewLocationAsset;
    protected final List<Long> pinnedItemsAssetIndices;

    /**
     * Pinned item to folder overview.
     *
     * @param folderOverviewLocationAsset  Folder Overview location position in
     *     the Assets list.
     * @param pinnedItemsAssetIndices  Pinned items positions in the Assets
     *     list. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderOverviewItemPinnedDetails(long folderOverviewLocationAsset, @Nonnull List<Long> pinnedItemsAssetIndices) {
        this.folderOverviewLocationAsset = folderOverviewLocationAsset;
        if (pinnedItemsAssetIndices == null) {
            throw new IllegalArgumentException("Required value for 'pinnedItemsAssetIndices' is null");
        }
        for (Long x : pinnedItemsAssetIndices) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'pinnedItemsAssetIndices' is null");
            }
        }
        this.pinnedItemsAssetIndices = pinnedItemsAssetIndices;
    }

    /**
     * Folder Overview location position in the Assets list.
     *
     * @return value for this field.
     */
    public long getFolderOverviewLocationAsset() {
        return folderOverviewLocationAsset;
    }

    /**
     * Pinned items positions in the Assets list.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<Long> getPinnedItemsAssetIndices() {
        return pinnedItemsAssetIndices;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            folderOverviewLocationAsset,
            pinnedItemsAssetIndices
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
            FolderOverviewItemPinnedDetails other = (FolderOverviewItemPinnedDetails) obj;
            return (this.folderOverviewLocationAsset == other.folderOverviewLocationAsset)
                && ((this.pinnedItemsAssetIndices == other.pinnedItemsAssetIndices) || (this.pinnedItemsAssetIndices.equals(other.pinnedItemsAssetIndices)))
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
    static class Serializer extends StructSerializer<FolderOverviewItemPinnedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderOverviewItemPinnedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("folder_overview_location_asset");
            StoneSerializers.uInt64().serialize(value.folderOverviewLocationAsset, g);
            g.writeFieldName("pinned_items_asset_indices");
            StoneSerializers.list(StoneSerializers.uInt64()).serialize(value.pinnedItemsAssetIndices, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FolderOverviewItemPinnedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderOverviewItemPinnedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_folderOverviewLocationAsset = null;
                List<Long> f_pinnedItemsAssetIndices = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("folder_overview_location_asset".equals(field)) {
                        f_folderOverviewLocationAsset = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("pinned_items_asset_indices".equals(field)) {
                        f_pinnedItemsAssetIndices = StoneSerializers.list(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_folderOverviewLocationAsset == null) {
                    throw new JsonParseException(p, "Required field \"folder_overview_location_asset\" missing.");
                }
                if (f_pinnedItemsAssetIndices == null) {
                    throw new JsonParseException(p, "Required field \"pinned_items_asset_indices\" missing.");
                }
                value = new FolderOverviewItemPinnedDetails(f_folderOverviewLocationAsset, f_pinnedItemsAssetIndices);
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
