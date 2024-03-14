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
 * Updated folder overview.
 */
public class FolderOverviewDescriptionChangedDetails {
    // struct team_log.FolderOverviewDescriptionChangedDetails (team_log_generated.stone)

    protected final long folderOverviewLocationAsset;

    /**
     * Updated folder overview.
     *
     * @param folderOverviewLocationAsset  Folder Overview location position in
     *     the Assets list.
     */
    public FolderOverviewDescriptionChangedDetails(long folderOverviewLocationAsset) {
        this.folderOverviewLocationAsset = folderOverviewLocationAsset;
    }

    /**
     * Folder Overview location position in the Assets list.
     *
     * @return value for this field.
     */
    public long getFolderOverviewLocationAsset() {
        return folderOverviewLocationAsset;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            folderOverviewLocationAsset
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
            FolderOverviewDescriptionChangedDetails other = (FolderOverviewDescriptionChangedDetails) obj;
            return this.folderOverviewLocationAsset == other.folderOverviewLocationAsset;
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
    static class Serializer extends StructSerializer<FolderOverviewDescriptionChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderOverviewDescriptionChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("folder_overview_location_asset");
            StoneSerializers.uInt64().serialize(value.folderOverviewLocationAsset, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FolderOverviewDescriptionChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderOverviewDescriptionChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_folderOverviewLocationAsset = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("folder_overview_location_asset".equals(field)) {
                        f_folderOverviewLocationAsset = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_folderOverviewLocationAsset == null) {
                    throw new JsonParseException(p, "Required field \"folder_overview_location_asset\" missing.");
                }
                value = new FolderOverviewDescriptionChangedDetails(f_folderOverviewLocationAsset);
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
