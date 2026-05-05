/* DO NOT EDIT */
/* This file was generated from team_log_stone_gen_team_log_generated.stone */

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
 * Created shared link in Replay.
 */
public class ReplayFileSharedLinkCreatedDetails {
    // struct team_log.ReplayFileSharedLinkCreatedDetails (team_log_stone_gen_team_log_generated.stone)

    @Nullable
    protected final Boolean isWatermarked;
    @Nullable
    protected final ReplayLinkAccess access;

    /**
     * Created shared link in Replay.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param isWatermarked  Indicates whether it was a watermark share link.
     * @param access  The Replay sharing policy in place when the link was
     *     created. Might be missing due to historical data gap.
     */
    public ReplayFileSharedLinkCreatedDetails(@Nullable Boolean isWatermarked, @Nullable ReplayLinkAccess access) {
        this.isWatermarked = isWatermarked;
        this.access = access;
    }

    /**
     * Created shared link in Replay.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ReplayFileSharedLinkCreatedDetails() {
        this(null, null);
    }

    /**
     * Indicates whether it was a watermark share link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsWatermarked() {
        return isWatermarked;
    }

    /**
     * The Replay sharing policy in place when the link was created. Might be
     * missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public ReplayLinkAccess getAccess() {
        return access;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link ReplayFileSharedLinkCreatedDetails}.
     */
    public static class Builder {

        protected Boolean isWatermarked;
        protected ReplayLinkAccess access;

        protected Builder() {
            this.isWatermarked = null;
            this.access = null;
        }

        /**
         * Set value for optional field.
         *
         * @param isWatermarked  Indicates whether it was a watermark share
         *     link.
         *
         * @return this builder
         */
        public Builder withIsWatermarked(Boolean isWatermarked) {
            this.isWatermarked = isWatermarked;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param access  The Replay sharing policy in place when the link was
         *     created. Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withAccess(ReplayLinkAccess access) {
            this.access = access;
            return this;
        }

        /**
         * Builds an instance of {@link ReplayFileSharedLinkCreatedDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link ReplayFileSharedLinkCreatedDetails}
         */
        public ReplayFileSharedLinkCreatedDetails build() {
            return new ReplayFileSharedLinkCreatedDetails(isWatermarked, access);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.isWatermarked,
            this.access
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
            ReplayFileSharedLinkCreatedDetails other = (ReplayFileSharedLinkCreatedDetails) obj;
            return ((this.isWatermarked == other.isWatermarked) || (this.isWatermarked != null && this.isWatermarked.equals(other.isWatermarked)))
                && ((this.access == other.access) || (this.access != null && this.access.equals(other.access)))
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
    static class Serializer extends StructSerializer<ReplayFileSharedLinkCreatedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ReplayFileSharedLinkCreatedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.isWatermarked != null) {
                g.writeFieldName("is_watermarked");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isWatermarked, g);
            }
            if (value.access != null) {
                g.writeFieldName("access");
                StoneSerializers.nullable(ReplayLinkAccess.Serializer.INSTANCE).serialize(value.access, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ReplayFileSharedLinkCreatedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ReplayFileSharedLinkCreatedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isWatermarked = null;
                ReplayLinkAccess f_access = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_watermarked".equals(field)) {
                        f_isWatermarked = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("access".equals(field)) {
                        f_access = StoneSerializers.nullable(ReplayLinkAccess.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ReplayFileSharedLinkCreatedDetails(f_isWatermarked, f_access);
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
