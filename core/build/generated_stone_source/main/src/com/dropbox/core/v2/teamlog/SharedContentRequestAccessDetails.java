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
 * Requested access to shared file/folder.
 */
public class SharedContentRequestAccessDetails {
    // struct team_log.SharedContentRequestAccessDetails (team_log_generated.stone)

    protected final String sharedContentLink;

    /**
     * Requested access to shared file/folder.
     *
     * @param sharedContentLink  Shared content link.
     */
    public SharedContentRequestAccessDetails(@javax.annotation.Nullable String sharedContentLink) {
        this.sharedContentLink = sharedContentLink;
    }

    /**
     * Requested access to shared file/folder.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedContentRequestAccessDetails() {
        this(null);
    }

    /**
     * Shared content link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getSharedContentLink() {
        return sharedContentLink;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedContentLink
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
            SharedContentRequestAccessDetails other = (SharedContentRequestAccessDetails) obj;
            return (this.sharedContentLink == other.sharedContentLink) || (this.sharedContentLink != null && this.sharedContentLink.equals(other.sharedContentLink));
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
    static class Serializer extends StructSerializer<SharedContentRequestAccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentRequestAccessDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sharedContentLink != null) {
                g.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedContentLink, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentRequestAccessDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentRequestAccessDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedContentLink = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_content_link".equals(field)) {
                        f_sharedContentLink = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedContentRequestAccessDetails(f_sharedContentLink);
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
