/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

public class GetCopyReferenceResult {
    // struct files.GetCopyReferenceResult (files.stone)

    protected final Metadata metadata;
    protected final String copyReference;
    protected final Date expires;

    /**
     *
     * @param metadata  Metadata of the file or folder. Must not be {@code
     *     null}.
     * @param copyReference  A copy reference to the file or folder. Must not be
     *     {@code null}.
     * @param expires  The expiration date of the copy reference. This value is
     *     currently set to be far enough in the future so that expiration is
     *     effectively not an issue. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetCopyReferenceResult(@javax.annotation.Nonnull Metadata metadata, @javax.annotation.Nonnull String copyReference, @javax.annotation.Nonnull Date expires) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        if (copyReference == null) {
            throw new IllegalArgumentException("Required value for 'copyReference' is null");
        }
        this.copyReference = copyReference;
        if (expires == null) {
            throw new IllegalArgumentException("Required value for 'expires' is null");
        }
        this.expires = LangUtil.truncateMillis(expires);
    }

    /**
     * Metadata of the file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * A copy reference to the file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getCopyReference() {
        return copyReference;
    }

    /**
     * The expiration date of the copy reference. This value is currently set to
     * be far enough in the future so that expiration is effectively not an
     * issue.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public Date getExpires() {
        return expires;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            metadata,
            copyReference,
            expires
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
            GetCopyReferenceResult other = (GetCopyReferenceResult) obj;
            return ((this.metadata == other.metadata) || (this.metadata.equals(other.metadata)))
                && ((this.copyReference == other.copyReference) || (this.copyReference.equals(other.copyReference)))
                && ((this.expires == other.expires) || (this.expires.equals(other.expires)))
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
    static class Serializer extends StructSerializer<GetCopyReferenceResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetCopyReferenceResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("metadata");
            Metadata.Serializer.INSTANCE.serialize(value.metadata, g);
            g.writeFieldName("copy_reference");
            StoneSerializers.string().serialize(value.copyReference, g);
            g.writeFieldName("expires");
            StoneSerializers.timestamp().serialize(value.expires, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetCopyReferenceResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetCopyReferenceResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Metadata f_metadata = null;
                String f_copyReference = null;
                Date f_expires = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("metadata".equals(field)) {
                        f_metadata = Metadata.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("copy_reference".equals(field)) {
                        f_copyReference = StoneSerializers.string().deserialize(p);
                    }
                    else if ("expires".equals(field)) {
                        f_expires = StoneSerializers.timestamp().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_metadata == null) {
                    throw new JsonParseException(p, "Required field \"metadata\" missing.");
                }
                if (f_copyReference == null) {
                    throw new JsonParseException(p, "Required field \"copy_reference\" missing.");
                }
                if (f_expires == null) {
                    throw new JsonParseException(p, "Required field \"expires\" missing.");
                }
                value = new GetCopyReferenceResult(f_metadata, f_copyReference, f_expires);
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
