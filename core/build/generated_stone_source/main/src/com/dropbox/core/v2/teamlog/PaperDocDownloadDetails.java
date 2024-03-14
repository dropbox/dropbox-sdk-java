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
 * Downloaded Paper doc in specific format.
 */
public class PaperDocDownloadDetails {
    // struct team_log.PaperDocDownloadDetails (team_log_generated.stone)

    protected final String eventUuid;
    protected final PaperDownloadFormat exportFileFormat;

    /**
     * Downloaded Paper doc in specific format.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param exportFileFormat  Export file format. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocDownloadDetails(@javax.annotation.Nonnull String eventUuid, @javax.annotation.Nonnull PaperDownloadFormat exportFileFormat) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        if (exportFileFormat == null) {
            throw new IllegalArgumentException("Required value for 'exportFileFormat' is null");
        }
        this.exportFileFormat = exportFileFormat;
    }

    /**
     * Event unique identifier.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getEventUuid() {
        return eventUuid;
    }

    /**
     * Export file format.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public PaperDownloadFormat getExportFileFormat() {
        return exportFileFormat;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            eventUuid,
            exportFileFormat
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
            PaperDocDownloadDetails other = (PaperDocDownloadDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && ((this.exportFileFormat == other.exportFileFormat) || (this.exportFileFormat.equals(other.exportFileFormat)))
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
    static class Serializer extends StructSerializer<PaperDocDownloadDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocDownloadDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            g.writeFieldName("export_file_format");
            PaperDownloadFormat.Serializer.INSTANCE.serialize(value.exportFileFormat, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocDownloadDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocDownloadDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                PaperDownloadFormat f_exportFileFormat = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("export_file_format".equals(field)) {
                        f_exportFileFormat = PaperDownloadFormat.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                if (f_exportFileFormat == null) {
                    throw new JsonParseException(p, "Required field \"export_file_format\" missing.");
                }
                value = new PaperDocDownloadDetails(f_eventUuid, f_exportFileFormat);
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
