/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

class UploadSessionStartBatchArg {
    // struct files.UploadSessionStartBatchArg (files.stone)

    protected final UploadSessionType sessionType;
    protected final long numSessions;

    /**
     *
     * @param numSessions  The number of upload sessions to start. Must be
     *     greater than or equal to 1 and be less than or equal to 1000.
     * @param sessionType  Type of upload session you want to start. If not
     *     specified, default is {@link UploadSessionType#SEQUENTIAL}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartBatchArg(long numSessions, @javax.annotation.Nullable UploadSessionType sessionType) {
        this.sessionType = sessionType;
        if (numSessions < 1L) {
            throw new IllegalArgumentException("Number 'numSessions' is smaller than 1L");
        }
        if (numSessions > 1000L) {
            throw new IllegalArgumentException("Number 'numSessions' is larger than 1000L");
        }
        this.numSessions = numSessions;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param numSessions  The number of upload sessions to start. Must be
     *     greater than or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartBatchArg(long numSessions) {
        this(numSessions, null);
    }

    /**
     * The number of upload sessions to start.
     *
     * @return value for this field.
     */
    public long getNumSessions() {
        return numSessions;
    }

    /**
     * Type of upload session you want to start. If not specified, default is
     * {@link UploadSessionType#SEQUENTIAL}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public UploadSessionType getSessionType() {
        return sessionType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionType,
            numSessions
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
            UploadSessionStartBatchArg other = (UploadSessionStartBatchArg) obj;
            return (this.numSessions == other.numSessions)
                && ((this.sessionType == other.sessionType) || (this.sessionType != null && this.sessionType.equals(other.sessionType)))
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
    static class Serializer extends StructSerializer<UploadSessionStartBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionStartBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("num_sessions");
            StoneSerializers.uInt64().serialize(value.numSessions, g);
            if (value.sessionType != null) {
                g.writeFieldName("session_type");
                StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).serialize(value.sessionType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionStartBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionStartBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_numSessions = null;
                UploadSessionType f_sessionType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("num_sessions".equals(field)) {
                        f_numSessions = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("session_type".equals(field)) {
                        f_sessionType = StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_numSessions == null) {
                    throw new JsonParseException(p, "Required field \"num_sessions\" missing.");
                }
                value = new UploadSessionStartBatchArg(f_numSessions, f_sessionType);
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
