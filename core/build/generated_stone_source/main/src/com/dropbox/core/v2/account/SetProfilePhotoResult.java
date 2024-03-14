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

public class SetProfilePhotoResult {
    // struct account.SetProfilePhotoResult (account.stone)

    protected final String profilePhotoUrl;

    /**
     *
     * @param profilePhotoUrl  URL for the photo representing the user, if one
     *     is set. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SetProfilePhotoResult(String profilePhotoUrl) {
        if (profilePhotoUrl == null) {
            throw new IllegalArgumentException("Required value for 'profilePhotoUrl' is null");
        }
        this.profilePhotoUrl = profilePhotoUrl;
    }

    /**
     * URL for the photo representing the user, if one is set.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            profilePhotoUrl
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
            SetProfilePhotoResult other = (SetProfilePhotoResult) obj;
            return (this.profilePhotoUrl == other.profilePhotoUrl) || (this.profilePhotoUrl.equals(other.profilePhotoUrl));
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
    static class Serializer extends StructSerializer<SetProfilePhotoResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SetProfilePhotoResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("profile_photo_url");
            StoneSerializers.string().serialize(value.profilePhotoUrl, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SetProfilePhotoResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SetProfilePhotoResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_profilePhotoUrl = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("profile_photo_url".equals(field)) {
                        f_profilePhotoUrl = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_profilePhotoUrl == null) {
                    throw new JsonParseException(p, "Required field \"profile_photo_url\" missing.");
                }
                value = new SetProfilePhotoResult(f_profilePhotoUrl);
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
