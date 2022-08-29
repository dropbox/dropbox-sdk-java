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

public class GetTemporaryUploadLinkResult {
    // struct files.GetTemporaryUploadLinkResult (files.stone)

    protected final String link;

    /**
     *
     * @param link  The temporary link which can be used to stream a file to a
     *     Dropbox location. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemporaryUploadLinkResult(String link) {
        if (link == null) {
            throw new IllegalArgumentException("Required value for 'link' is null");
        }
        this.link = link;
    }

    /**
     * The temporary link which can be used to stream a file to a Dropbox
     * location.
     *
     * @return value for this field, never {@code null}.
     */
    public String getLink() {
        return link;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            link
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
            GetTemporaryUploadLinkResult other = (GetTemporaryUploadLinkResult) obj;
            return (this.link == other.link) || (this.link.equals(other.link));
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
    static class Serializer extends StructSerializer<GetTemporaryUploadLinkResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTemporaryUploadLinkResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("link");
            StoneSerializers.string().serialize(value.link, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetTemporaryUploadLinkResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetTemporaryUploadLinkResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_link = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("link".equals(field)) {
                        f_link = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_link == null) {
                    throw new JsonParseException(p, "Required field \"link\" missing.");
                }
                value = new GetTemporaryUploadLinkResult(f_link);
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
