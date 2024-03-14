/* DO NOT EDIT */
/* This file was generated from shared_content_links.stone */

package com.dropbox.core.v2.sharing;

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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

/**
 * Information about the shared folder that prevents the link audience for this
 * link from being more restrictive.
 */
public class AudienceRestrictingSharedFolder {
    // struct sharing.AudienceRestrictingSharedFolder (shared_content_links.stone)

    protected final String sharedFolderId;
    protected final String name;
    protected final LinkAudience audience;

    /**
     * Information about the shared folder that prevents the link audience for
     * this link from being more restrictive.
     *
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param name  The name of the shared folder. Must not be {@code null}.
     * @param audience  The link audience of the shared folder. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AudienceRestrictingSharedFolder(@Nonnull String sharedFolderId, @Nonnull String name, @Nonnull LinkAudience audience) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (audience == null) {
            throw new IllegalArgumentException("Required value for 'audience' is null");
        }
        this.audience = audience;
    }

    /**
     * The ID of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * The name of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * The link audience of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public LinkAudience getAudience() {
        return audience;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedFolderId,
            name,
            audience
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
            AudienceRestrictingSharedFolder other = (AudienceRestrictingSharedFolder) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.audience == other.audience) || (this.audience.equals(other.audience)))
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
    static class Serializer extends StructSerializer<AudienceRestrictingSharedFolder> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AudienceRestrictingSharedFolder value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("audience");
            LinkAudience.Serializer.INSTANCE.serialize(value.audience, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AudienceRestrictingSharedFolder deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AudienceRestrictingSharedFolder value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                String f_name = null;
                LinkAudience f_audience = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("audience".equals(field)) {
                        f_audience = LinkAudience.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_audience == null) {
                    throw new JsonParseException(p, "Required field \"audience\" missing.");
                }
                value = new AudienceRestrictingSharedFolder(f_sharedFolderId, f_name, f_audience);
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
