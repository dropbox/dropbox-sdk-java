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
 * Removed Paper doc/folder from folder.
 */
public class PaperContentRemoveFromFolderDetails {
    // struct team_log.PaperContentRemoveFromFolderDetails (team_log_generated.stone)

    protected final String eventUuid;
    protected final long targetAssetIndex;
    protected final long parentAssetIndex;

    /**
     * Removed Paper doc/folder from folder.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param parentAssetIndex  Parent asset position in the Assets list.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperContentRemoveFromFolderDetails(String eventUuid, long targetAssetIndex, long parentAssetIndex) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        this.targetAssetIndex = targetAssetIndex;
        this.parentAssetIndex = parentAssetIndex;
    }

    /**
     * Event unique identifier.
     *
     * @return value for this field, never {@code null}.
     */
    public String getEventUuid() {
        return eventUuid;
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
     * Parent asset position in the Assets list.
     *
     * @return value for this field.
     */
    public long getParentAssetIndex() {
        return parentAssetIndex;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            eventUuid,
            targetAssetIndex,
            parentAssetIndex
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
            PaperContentRemoveFromFolderDetails other = (PaperContentRemoveFromFolderDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && (this.targetAssetIndex == other.targetAssetIndex)
                && (this.parentAssetIndex == other.parentAssetIndex)
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
    static class Serializer extends StructSerializer<PaperContentRemoveFromFolderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperContentRemoveFromFolderDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            g.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(value.targetAssetIndex, g);
            g.writeFieldName("parent_asset_index");
            StoneSerializers.uInt64().serialize(value.parentAssetIndex, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperContentRemoveFromFolderDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperContentRemoveFromFolderDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                Long f_targetAssetIndex = null;
                Long f_parentAssetIndex = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("target_asset_index".equals(field)) {
                        f_targetAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("parent_asset_index".equals(field)) {
                        f_parentAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                if (f_targetAssetIndex == null) {
                    throw new JsonParseException(p, "Required field \"target_asset_index\" missing.");
                }
                if (f_parentAssetIndex == null) {
                    throw new JsonParseException(p, "Required field \"parent_asset_index\" missing.");
                }
                value = new PaperContentRemoveFromFolderDetails(f_eventUuid, f_targetAssetIndex, f_parentAssetIndex);
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
