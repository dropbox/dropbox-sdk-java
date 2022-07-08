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
 * Set team members to see warning before sharing folders outside team.
 */
public class SfExternalInviteWarnDetails {
    // struct team_log.SfExternalInviteWarnDetails (team_log_generated.stone)

    protected final long targetAssetIndex;
    protected final String originalFolderName;
    protected final String newSharingPermission;
    protected final String previousSharingPermission;

    /**
     * Set team members to see warning before sharing folders outside team.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     * @param newSharingPermission  New sharing permission. Might be missing due
     *     to historical data gap.
     * @param previousSharingPermission  Previous sharing permission. Might be
     *     missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SfExternalInviteWarnDetails(long targetAssetIndex, String originalFolderName, String newSharingPermission, String previousSharingPermission) {
        this.targetAssetIndex = targetAssetIndex;
        if (originalFolderName == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = originalFolderName;
        this.newSharingPermission = newSharingPermission;
        this.previousSharingPermission = previousSharingPermission;
    }

    /**
     * Set team members to see warning before sharing folders outside team.
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
    public SfExternalInviteWarnDetails(long targetAssetIndex, String originalFolderName) {
        this(targetAssetIndex, originalFolderName, null, null);
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
     * New sharing permission. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewSharingPermission() {
        return newSharingPermission;
    }

    /**
     * Previous sharing permission. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPreviousSharingPermission() {
        return previousSharingPermission;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(long targetAssetIndex, String originalFolderName) {
        return new Builder(targetAssetIndex, originalFolderName);
    }

    /**
     * Builder for {@link SfExternalInviteWarnDetails}.
     */
    public static class Builder {
        protected final long targetAssetIndex;
        protected final String originalFolderName;

        protected String newSharingPermission;
        protected String previousSharingPermission;

        protected Builder(long targetAssetIndex, String originalFolderName) {
            this.targetAssetIndex = targetAssetIndex;
            if (originalFolderName == null) {
                throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
            }
            this.originalFolderName = originalFolderName;
            this.newSharingPermission = null;
            this.previousSharingPermission = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newSharingPermission  New sharing permission. Might be missing
         *     due to historical data gap.
         *
         * @return this builder
         */
        public Builder withNewSharingPermission(String newSharingPermission) {
            this.newSharingPermission = newSharingPermission;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousSharingPermission  Previous sharing permission. Might
         *     be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousSharingPermission(String previousSharingPermission) {
            this.previousSharingPermission = previousSharingPermission;
            return this;
        }

        /**
         * Builds an instance of {@link SfExternalInviteWarnDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link SfExternalInviteWarnDetails}
         */
        public SfExternalInviteWarnDetails build() {
            return new SfExternalInviteWarnDetails(targetAssetIndex, originalFolderName, newSharingPermission, previousSharingPermission);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            targetAssetIndex,
            originalFolderName,
            newSharingPermission,
            previousSharingPermission
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
            SfExternalInviteWarnDetails other = (SfExternalInviteWarnDetails) obj;
            return (this.targetAssetIndex == other.targetAssetIndex)
                && ((this.originalFolderName == other.originalFolderName) || (this.originalFolderName.equals(other.originalFolderName)))
                && ((this.newSharingPermission == other.newSharingPermission) || (this.newSharingPermission != null && this.newSharingPermission.equals(other.newSharingPermission)))
                && ((this.previousSharingPermission == other.previousSharingPermission) || (this.previousSharingPermission != null && this.previousSharingPermission.equals(other.previousSharingPermission)))
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
    static class Serializer extends StructSerializer<SfExternalInviteWarnDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SfExternalInviteWarnDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(value.targetAssetIndex, g);
            g.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(value.originalFolderName, g);
            if (value.newSharingPermission != null) {
                g.writeFieldName("new_sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newSharingPermission, g);
            }
            if (value.previousSharingPermission != null) {
                g.writeFieldName("previous_sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previousSharingPermission, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SfExternalInviteWarnDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SfExternalInviteWarnDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_targetAssetIndex = null;
                String f_originalFolderName = null;
                String f_newSharingPermission = null;
                String f_previousSharingPermission = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("target_asset_index".equals(field)) {
                        f_targetAssetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("original_folder_name".equals(field)) {
                        f_originalFolderName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_sharing_permission".equals(field)) {
                        f_newSharingPermission = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("previous_sharing_permission".equals(field)) {
                        f_previousSharingPermission = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new SfExternalInviteWarnDetails(f_targetAssetIndex, f_originalFolderName, f_newSharingPermission, f_previousSharingPermission);
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
