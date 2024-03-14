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
 * Joined team member's shared folder from link.
 */
public class SfTeamJoinFromOobLinkDetails {
    // struct team_log.SfTeamJoinFromOobLinkDetails (team_log_generated.stone)

    protected final long targetAssetIndex;
    protected final String originalFolderName;
    protected final String tokenKey;
    protected final String sharingPermission;

    /**
     * Joined team member's shared folder from link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param targetAssetIndex  Target asset position in the Assets list.
     * @param originalFolderName  Original shared folder name. Must not be
     *     {@code null}.
     * @param tokenKey  Shared link token key.
     * @param sharingPermission  Sharing permission.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SfTeamJoinFromOobLinkDetails(long targetAssetIndex, @Nonnull String originalFolderName, @Nullable String tokenKey, @Nullable String sharingPermission) {
        this.targetAssetIndex = targetAssetIndex;
        if (originalFolderName == null) {
            throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
        }
        this.originalFolderName = originalFolderName;
        this.tokenKey = tokenKey;
        this.sharingPermission = sharingPermission;
    }

    /**
     * Joined team member's shared folder from link.
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
    public SfTeamJoinFromOobLinkDetails(long targetAssetIndex, String originalFolderName) {
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
    @Nonnull
    public String getOriginalFolderName() {
        return originalFolderName;
    }

    /**
     * Shared link token key.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getTokenKey() {
        return tokenKey;
    }

    /**
     * Sharing permission.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSharingPermission() {
        return sharingPermission;
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
     * Builder for {@link SfTeamJoinFromOobLinkDetails}.
     */
    public static class Builder {
        protected final long targetAssetIndex;
        protected final String originalFolderName;

        protected String tokenKey;
        protected String sharingPermission;

        protected Builder(long targetAssetIndex, String originalFolderName) {
            this.targetAssetIndex = targetAssetIndex;
            if (originalFolderName == null) {
                throw new IllegalArgumentException("Required value for 'originalFolderName' is null");
            }
            this.originalFolderName = originalFolderName;
            this.tokenKey = null;
            this.sharingPermission = null;
        }

        /**
         * Set value for optional field.
         *
         * @param tokenKey  Shared link token key.
         *
         * @return this builder
         */
        public Builder withTokenKey(String tokenKey) {
            this.tokenKey = tokenKey;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharingPermission  Sharing permission.
         *
         * @return this builder
         */
        public Builder withSharingPermission(String sharingPermission) {
            this.sharingPermission = sharingPermission;
            return this;
        }

        /**
         * Builds an instance of {@link SfTeamJoinFromOobLinkDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link SfTeamJoinFromOobLinkDetails}
         */
        public SfTeamJoinFromOobLinkDetails build() {
            return new SfTeamJoinFromOobLinkDetails(targetAssetIndex, originalFolderName, tokenKey, sharingPermission);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            targetAssetIndex,
            originalFolderName,
            tokenKey,
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
            SfTeamJoinFromOobLinkDetails other = (SfTeamJoinFromOobLinkDetails) obj;
            return (this.targetAssetIndex == other.targetAssetIndex)
                && ((this.originalFolderName == other.originalFolderName) || (this.originalFolderName.equals(other.originalFolderName)))
                && ((this.tokenKey == other.tokenKey) || (this.tokenKey != null && this.tokenKey.equals(other.tokenKey)))
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
    static class Serializer extends StructSerializer<SfTeamJoinFromOobLinkDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SfTeamJoinFromOobLinkDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(value.targetAssetIndex, g);
            g.writeFieldName("original_folder_name");
            StoneSerializers.string().serialize(value.originalFolderName, g);
            if (value.tokenKey != null) {
                g.writeFieldName("token_key");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.tokenKey, g);
            }
            if (value.sharingPermission != null) {
                g.writeFieldName("sharing_permission");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharingPermission, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SfTeamJoinFromOobLinkDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SfTeamJoinFromOobLinkDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_targetAssetIndex = null;
                String f_originalFolderName = null;
                String f_tokenKey = null;
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
                    else if ("token_key".equals(field)) {
                        f_tokenKey = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new SfTeamJoinFromOobLinkDetails(f_targetAssetIndex, f_originalFolderName, f_tokenKey, f_sharingPermission);
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
