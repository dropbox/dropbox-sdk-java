/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * File request deadline
 */
public class FileRequestDeadline {
    // struct team_log.FileRequestDeadline (team_log_generated.stone)

    protected final Date deadline;
    protected final String allowLateUploads;

    /**
     * File request deadline
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param deadline  The deadline for this file request. Might be missing due
     *     to historical data gap.
     * @param allowLateUploads  If set, allow uploads after the deadline has
     *     passed.
     */
    public FileRequestDeadline(@Nullable Date deadline, @Nullable String allowLateUploads) {
        this.deadline = LangUtil.truncateMillis(deadline);
        this.allowLateUploads = allowLateUploads;
    }

    /**
     * File request deadline
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public FileRequestDeadline() {
        this(null, null);
    }

    /**
     * The deadline for this file request. Might be missing due to historical
     * data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getDeadline() {
        return deadline;
    }

    /**
     * If set, allow uploads after the deadline has passed.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getAllowLateUploads() {
        return allowLateUploads;
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
     * Builder for {@link FileRequestDeadline}.
     */
    public static class Builder {

        protected Date deadline;
        protected String allowLateUploads;

        protected Builder() {
            this.deadline = null;
            this.allowLateUploads = null;
        }

        /**
         * Set value for optional field.
         *
         * @param deadline  The deadline for this file request. Might be missing
         *     due to historical data gap.
         *
         * @return this builder
         */
        public Builder withDeadline(Date deadline) {
            this.deadline = LangUtil.truncateMillis(deadline);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param allowLateUploads  If set, allow uploads after the deadline has
         *     passed.
         *
         * @return this builder
         */
        public Builder withAllowLateUploads(String allowLateUploads) {
            this.allowLateUploads = allowLateUploads;
            return this;
        }

        /**
         * Builds an instance of {@link FileRequestDeadline} configured with
         * this builder's values
         *
         * @return new instance of {@link FileRequestDeadline}
         */
        public FileRequestDeadline build() {
            return new FileRequestDeadline(deadline, allowLateUploads);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            deadline,
            allowLateUploads
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
            FileRequestDeadline other = (FileRequestDeadline) obj;
            return ((this.deadline == other.deadline) || (this.deadline != null && this.deadline.equals(other.deadline)))
                && ((this.allowLateUploads == other.allowLateUploads) || (this.allowLateUploads != null && this.allowLateUploads.equals(other.allowLateUploads)))
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
    static class Serializer extends StructSerializer<FileRequestDeadline> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileRequestDeadline value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.deadline != null) {
                g.writeFieldName("deadline");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.deadline, g);
            }
            if (value.allowLateUploads != null) {
                g.writeFieldName("allow_late_uploads");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.allowLateUploads, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileRequestDeadline deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileRequestDeadline value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_deadline = null;
                String f_allowLateUploads = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("deadline".equals(field)) {
                        f_deadline = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("allow_late_uploads".equals(field)) {
                        f_allowLateUploads = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new FileRequestDeadline(f_deadline, f_allowLateUploads);
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
