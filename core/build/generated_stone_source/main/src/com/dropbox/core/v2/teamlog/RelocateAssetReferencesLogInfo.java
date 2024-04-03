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
 * Provides the indices of the source asset and the destination asset for a
 * relocate action.
 */
public class RelocateAssetReferencesLogInfo {
    // struct team_log.RelocateAssetReferencesLogInfo (team_log_generated.stone)

    protected final long srcAssetIndex;
    protected final long destAssetIndex;

    /**
     * Provides the indices of the source asset and the destination asset for a
     * relocate action.
     *
     * @param srcAssetIndex  Source asset position in the Assets list.
     * @param destAssetIndex  Destination asset position in the Assets list.
     */
    public RelocateAssetReferencesLogInfo(long srcAssetIndex, long destAssetIndex) {
        this.srcAssetIndex = srcAssetIndex;
        this.destAssetIndex = destAssetIndex;
    }

    /**
     * Source asset position in the Assets list.
     *
     * @return value for this field.
     */
    public long getSrcAssetIndex() {
        return srcAssetIndex;
    }

    /**
     * Destination asset position in the Assets list.
     *
     * @return value for this field.
     */
    public long getDestAssetIndex() {
        return destAssetIndex;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.srcAssetIndex,
            this.destAssetIndex
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
            RelocateAssetReferencesLogInfo other = (RelocateAssetReferencesLogInfo) obj;
            return (this.srcAssetIndex == other.srcAssetIndex)
                && (this.destAssetIndex == other.destAssetIndex)
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
    static class Serializer extends StructSerializer<RelocateAssetReferencesLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocateAssetReferencesLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("src_asset_index");
            StoneSerializers.uInt64().serialize(value.srcAssetIndex, g);
            g.writeFieldName("dest_asset_index");
            StoneSerializers.uInt64().serialize(value.destAssetIndex, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RelocateAssetReferencesLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RelocateAssetReferencesLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_srcAssetIndex = null;
                Long f_destAssetIndex = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("src_asset_index".equals(field)) {
                        f_srcAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("dest_asset_index".equals(field)) {
                        f_destAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_srcAssetIndex == null) {
                    throw new JsonParseException(p, "Required field \"src_asset_index\" missing.");
                }
                if (f_destAssetIndex == null) {
                    throw new JsonParseException(p, "Required field \"dest_asset_index\" missing.");
                }
                value = new RelocateAssetReferencesLogInfo(f_srcAssetIndex, f_destAssetIndex);
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
