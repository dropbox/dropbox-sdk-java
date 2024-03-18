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
import java.util.List;

import javax.annotation.Nonnull;

/**
 * Copied files and/or folders.
 */
public class FileCopyDetails {
    // struct team_log.FileCopyDetails (team_log_generated.stone)

    @Nonnull
    protected final List<RelocateAssetReferencesLogInfo> relocateActionDetails;

    /**
     * Copied files and/or folders.
     *
     * @param relocateActionDetails  Relocate action details. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileCopyDetails(@Nonnull List<RelocateAssetReferencesLogInfo> relocateActionDetails) {
        if (relocateActionDetails == null) {
            throw new IllegalArgumentException("Required value for 'relocateActionDetails' is null");
        }
        for (RelocateAssetReferencesLogInfo x : relocateActionDetails) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'relocateActionDetails' is null");
            }
        }
        this.relocateActionDetails = relocateActionDetails;
    }

    /**
     * Relocate action details.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<RelocateAssetReferencesLogInfo> getRelocateActionDetails() {
        return relocateActionDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            relocateActionDetails
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
            FileCopyDetails other = (FileCopyDetails) obj;
            return (this.relocateActionDetails == other.relocateActionDetails) || (this.relocateActionDetails.equals(other.relocateActionDetails));
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
    static class Serializer extends StructSerializer<FileCopyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileCopyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("relocate_action_details");
            StoneSerializers.list(RelocateAssetReferencesLogInfo.Serializer.INSTANCE).serialize(value.relocateActionDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileCopyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileCopyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<RelocateAssetReferencesLogInfo> f_relocateActionDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("relocate_action_details".equals(field)) {
                        f_relocateActionDetails = StoneSerializers.list(RelocateAssetReferencesLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_relocateActionDetails == null) {
                    throw new JsonParseException(p, "Required field \"relocate_action_details\" missing.");
                }
                value = new FileCopyDetails(f_relocateActionDetails);
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
