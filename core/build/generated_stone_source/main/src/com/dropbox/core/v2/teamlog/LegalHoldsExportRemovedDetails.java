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
 * Removed export for a hold.
 */
public class LegalHoldsExportRemovedDetails {
    // struct team_log.LegalHoldsExportRemovedDetails (team_log_generated.stone)

    protected final String legalHoldId;
    protected final String name;
    protected final String exportName;

    /**
     * Removed export for a hold.
     *
     * @param legalHoldId  Hold ID. Must not be {@code null}.
     * @param name  Hold name. Must not be {@code null}.
     * @param exportName  Export name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsExportRemovedDetails(String legalHoldId, String name, String exportName) {
        if (legalHoldId == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = legalHoldId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (exportName == null) {
            throw new IllegalArgumentException("Required value for 'exportName' is null");
        }
        this.exportName = exportName;
    }

    /**
     * Hold ID.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getLegalHoldId() {
        return legalHoldId;
    }

    /**
     * Hold name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    /**
     * Export name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getExportName() {
        return exportName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            legalHoldId,
            name,
            exportName
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
            LegalHoldsExportRemovedDetails other = (LegalHoldsExportRemovedDetails) obj;
            return ((this.legalHoldId == other.legalHoldId) || (this.legalHoldId.equals(other.legalHoldId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.exportName == other.exportName) || (this.exportName.equals(other.exportName)))
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
    static class Serializer extends StructSerializer<LegalHoldsExportRemovedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsExportRemovedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(value.legalHoldId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("export_name");
            StoneSerializers.string().serialize(value.exportName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsExportRemovedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsExportRemovedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_legalHoldId = null;
                String f_name = null;
                String f_exportName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("legal_hold_id".equals(field)) {
                        f_legalHoldId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("export_name".equals(field)) {
                        f_exportName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_legalHoldId == null) {
                    throw new JsonParseException(p, "Required field \"legal_hold_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_exportName == null) {
                    throw new JsonParseException(p, "Required field \"export_name\" missing.");
                }
                value = new LegalHoldsExportRemovedDetails(f_legalHoldId, f_name, f_exportName);
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
