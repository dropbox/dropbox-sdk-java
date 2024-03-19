/* DO NOT EDIT */
/* This file was generated from account.stone */

package com.dropbox.core.v2.account;

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

import javax.annotation.Nonnull;

class SetProfilePhotoArg {
    // struct account.SetProfilePhotoArg (account.stone)

    @Nonnull
    protected final PhotoSourceArg photo;

    /**
     *
     * @param photo  Image to set as the user's new profile photo. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SetProfilePhotoArg(@Nonnull PhotoSourceArg photo) {
        if (photo == null) {
            throw new IllegalArgumentException("Required value for 'photo' is null");
        }
        this.photo = photo;
    }

    /**
     * Image to set as the user's new profile photo.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public PhotoSourceArg getPhoto() {
        return photo;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            photo
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
            SetProfilePhotoArg other = (SetProfilePhotoArg) obj;
            return (this.photo == other.photo) || (this.photo.equals(other.photo));
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
    static class Serializer extends StructSerializer<SetProfilePhotoArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SetProfilePhotoArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("photo");
            PhotoSourceArg.Serializer.INSTANCE.serialize(value.photo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SetProfilePhotoArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SetProfilePhotoArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                PhotoSourceArg f_photo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("photo".equals(field)) {
                        f_photo = PhotoSourceArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_photo == null) {
                    throw new JsonParseException(p, "Required field \"photo\" missing.");
                }
                value = new SetProfilePhotoArg(f_photo);
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
