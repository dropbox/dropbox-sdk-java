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
 * Invited group to shared folder.
 */
public class SfInviteGroupDetails {
    // struct team_log.SfInviteGroupDetails (team_log_generated.stone)

    protected final long targetAssetIndex;

    /**
     * Invited group to shared folder.
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     */
    public SfInviteGroupDetails(long targetAssetIndex) {
        this.targetAssetIndex = targetAssetIndex;
    }

    /**
     * Target asset position in the Assets list.
     *
     * @return value for this field.
     */
    public long getTargetAssetIndex() {
        return targetAssetIndex;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.targetAssetIndex
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
            SfInviteGroupDetails other = (SfInviteGroupDetails) obj;
            return this.targetAssetIndex == other.targetAssetIndex;
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
    static class Serializer extends StructSerializer<SfInviteGroupDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SfInviteGroupDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(value.targetAssetIndex, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SfInviteGroupDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SfInviteGroupDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_targetAssetIndex = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("target_asset_index".equals(field)) {
                        f_targetAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_targetAssetIndex == null) {
                    throw new JsonParseException(p, "Required field \"target_asset_index\" missing.");
                }
                value = new SfInviteGroupDetails(f_targetAssetIndex);
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
