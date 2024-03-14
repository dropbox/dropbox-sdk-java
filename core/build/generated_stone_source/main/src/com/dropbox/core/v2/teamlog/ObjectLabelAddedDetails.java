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
 * Added a label.
 */
public class ObjectLabelAddedDetails {
    // struct team_log.ObjectLabelAddedDetails (team_log_generated.stone)

    protected final LabelType labelType;

    /**
     * Added a label.
     *
     * @param labelType  Labels mark a file or folder. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ObjectLabelAddedDetails(LabelType labelType) {
        if (labelType == null) {
            throw new IllegalArgumentException("Required value for 'labelType' is null");
        }
        this.labelType = labelType;
    }

    /**
     * Labels mark a file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    public LabelType getLabelType() {
        return labelType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            labelType
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
            ObjectLabelAddedDetails other = (ObjectLabelAddedDetails) obj;
            return (this.labelType == other.labelType) || (this.labelType.equals(other.labelType));
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
    static class Serializer extends StructSerializer<ObjectLabelAddedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ObjectLabelAddedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("label_type");
            LabelType.Serializer.INSTANCE.serialize(value.labelType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ObjectLabelAddedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ObjectLabelAddedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                LabelType f_labelType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("label_type".equals(field)) {
                        f_labelType = LabelType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_labelType == null) {
                    throw new JsonParseException(p, "Required field \"label_type\" missing.");
                }
                value = new ObjectLabelAddedDetails(f_labelType);
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
