/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

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

public class FileRequestDeadline {
    // struct file_requests.FileRequestDeadline (file_requests.stone)

    @Nonnull
    protected final Date deadline;
    @Nullable
    protected final GracePeriod allowLateUploads;

    /**
     *
     * @param deadline  The deadline for this file request. Must not be {@code
     *     null}.
     * @param allowLateUploads  If set, allow uploads after the deadline has
     *     passed. These     uploads will be marked overdue.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequestDeadline(@Nonnull Date deadline, @Nullable GracePeriod allowLateUploads) {
        if (deadline == null) {
            throw new IllegalArgumentException("Required value for 'deadline' is null");
        }
        this.deadline = LangUtil.truncateMillis(deadline);
        this.allowLateUploads = allowLateUploads;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param deadline  The deadline for this file request. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequestDeadline(@Nonnull Date deadline) {
        this(deadline, null);
    }

    /**
     * The deadline for this file request.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Date getDeadline() {
        return deadline;
    }

    /**
     * If set, allow uploads after the deadline has passed. These     uploads
     * will be marked overdue.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public GracePeriod getAllowLateUploads() {
        return allowLateUploads;
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
            return ((this.deadline == other.deadline) || (this.deadline.equals(other.deadline)))
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
            g.writeFieldName("deadline");
            StoneSerializers.timestamp().serialize(value.deadline, g);
            if (value.allowLateUploads != null) {
                g.writeFieldName("allow_late_uploads");
                StoneSerializers.nullable(GracePeriod.Serializer.INSTANCE).serialize(value.allowLateUploads, g);
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
                GracePeriod f_allowLateUploads = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("deadline".equals(field)) {
                        f_deadline = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("allow_late_uploads".equals(field)) {
                        f_allowLateUploads = StoneSerializers.nullable(GracePeriod.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_deadline == null) {
                    throw new JsonParseException(p, "Required field \"deadline\" missing.");
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
