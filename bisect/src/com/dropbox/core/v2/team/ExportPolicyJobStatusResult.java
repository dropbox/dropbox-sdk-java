/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

package com.dropbox.core.v2.team;

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

public class ExportPolicyJobStatusResult {
    // struct team.ExportPolicyJobStatusResult (team_legal_holds.stone)

    protected final ExportPolicyJobStatus status;

    /**
     *
     * @param status  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExportPolicyJobStatusResult(ExportPolicyJobStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = status;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public ExportPolicyJobStatus getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            status
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
            ExportPolicyJobStatusResult other = (ExportPolicyJobStatusResult) obj;
            return (this.status == other.status) || (this.status.equals(other.status));
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
    static class Serializer extends StructSerializer<ExportPolicyJobStatusResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExportPolicyJobStatusResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("status");
            ExportPolicyJobStatus.Serializer.INSTANCE.serialize(value.status, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExportPolicyJobStatusResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExportPolicyJobStatusResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                ExportPolicyJobStatus f_status = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("status".equals(field)) {
                        f_status = ExportPolicyJobStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_status == null) {
                    throw new JsonParseException(p, "Required field \"status\" missing.");
                }
                value = new ExportPolicyJobStatusResult(f_status);
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
