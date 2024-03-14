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
import java.util.List;

import javax.annotation.Nonnull;

/**
 * The total count and truncated list of information of content inside this
 * folder that has a different audience than the link on this folder. This is
 * only returned for folders.
 */
public class AudienceExceptions {
    // struct sharing.AudienceExceptions (shared_content_links.stone)

    protected final long count;
    protected final List<AudienceExceptionContentInfo> exceptions;

    /**
     * The total count and truncated list of information of content inside this
     * folder that has a different audience than the link on this folder. This
     * is only returned for folders.
     *
     * @param exceptions  A truncated list of some of the content that is an
     *     exception. The length of this list could be smaller than the count
     *     since it is only a sample but will not be empty as long as count is
     *     not 0. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AudienceExceptions(long count, @Nonnull List<AudienceExceptionContentInfo> exceptions) {
        this.count = count;
        if (exceptions == null) {
            throw new IllegalArgumentException("Required value for 'exceptions' is null");
        }
        for (AudienceExceptionContentInfo x : exceptions) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'exceptions' is null");
            }
        }
        this.exceptions = exceptions;
    }

    /**
     *
     * @return value for this field.
     */
    public long getCount() {
        return count;
    }

    /**
     * A truncated list of some of the content that is an exception. The length
     * of this list could be smaller than the count since it is only a sample
     * but will not be empty as long as count is not 0.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<AudienceExceptionContentInfo> getExceptions() {
        return exceptions;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            count,
            exceptions
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
            AudienceExceptions other = (AudienceExceptions) obj;
            return (this.count == other.count)
                && ((this.exceptions == other.exceptions) || (this.exceptions.equals(other.exceptions)))
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
    static class Serializer extends StructSerializer<AudienceExceptions> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AudienceExceptions value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("count");
            StoneSerializers.uInt32().serialize(value.count, g);
            g.writeFieldName("exceptions");
            StoneSerializers.list(AudienceExceptionContentInfo.Serializer.INSTANCE).serialize(value.exceptions, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AudienceExceptions deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AudienceExceptions value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_count = null;
                List<AudienceExceptionContentInfo> f_exceptions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("count".equals(field)) {
                        f_count = StoneSerializers.uInt32().deserialize(p);
                    }
                    else if ("exceptions".equals(field)) {
                        f_exceptions = StoneSerializers.list(AudienceExceptionContentInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_count == null) {
                    throw new JsonParseException(p, "Required field \"count\" missing.");
                }
                if (f_exceptions == null) {
                    throw new JsonParseException(p, "Required field \"exceptions\" missing.");
                }
                value = new AudienceExceptions(f_count, f_exceptions);
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
