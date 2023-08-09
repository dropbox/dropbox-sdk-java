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
    protected final Long targetAssetIndex;
    protected final Long parentAssetIndex;

    /**
     * Removed Paper doc/folder from folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param parentAssetIndex  Parent asset position in the Assets list.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperContentRemoveFromFolderDetails(String eventUuid, Long targetAssetIndex, Long parentAssetIndex) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        this.targetAssetIndex = targetAssetIndex;
        this.parentAssetIndex = parentAssetIndex;
    }

    /**
     * Removed Paper doc/folder from folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperContentRemoveFromFolderDetails(String eventUuid) {
        this(eventUuid, null, null);
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
     * @return value for this field, or {@code null} if not present.
     */
    public Long getTargetAssetIndex() {
        return targetAssetIndex;
    }

    /**
     * Parent asset position in the Assets list.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Long getParentAssetIndex() {
        return parentAssetIndex;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String eventUuid) {
        return new Builder(eventUuid);
    }

    /**
     * Builder for {@link PaperContentRemoveFromFolderDetails}.
     */
    public static class Builder {
        protected final String eventUuid;

        protected Long targetAssetIndex;
        protected Long parentAssetIndex;

        protected Builder(String eventUuid) {
            if (eventUuid == null) {
                throw new IllegalArgumentException("Required value for 'eventUuid' is null");
            }
            this.eventUuid = eventUuid;
            this.targetAssetIndex = null;
            this.parentAssetIndex = null;
        }

        /**
         * Set value for optional field.
         *
         * @param targetAssetIndex  Target asset position in the Assets list.
         *
         * @return this builder
         */
        public Builder withTargetAssetIndex(Long targetAssetIndex) {
            this.targetAssetIndex = targetAssetIndex;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param parentAssetIndex  Parent asset position in the Assets list.
         *
         * @return this builder
         */
        public Builder withParentAssetIndex(Long parentAssetIndex) {
            this.parentAssetIndex = parentAssetIndex;
            return this;
        }

        /**
         * Builds an instance of {@link PaperContentRemoveFromFolderDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link PaperContentRemoveFromFolderDetails}
         */
        public PaperContentRemoveFromFolderDetails build() {
            return new PaperContentRemoveFromFolderDetails(eventUuid, targetAssetIndex, parentAssetIndex);
        }
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
                && ((this.targetAssetIndex == other.targetAssetIndex) || (this.targetAssetIndex != null && this.targetAssetIndex.equals(other.targetAssetIndex)))
                && ((this.parentAssetIndex == other.parentAssetIndex) || (this.parentAssetIndex != null && this.parentAssetIndex.equals(other.parentAssetIndex)))
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
            if (value.targetAssetIndex != null) {
                g.writeFieldName("target_asset_index");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.targetAssetIndex, g);
            }
            if (value.parentAssetIndex != null) {
                g.writeFieldName("parent_asset_index");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.parentAssetIndex, g);
            }
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
                        f_targetAssetIndex = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else if ("parent_asset_index".equals(field)) {
                        f_parentAssetIndex = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
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
