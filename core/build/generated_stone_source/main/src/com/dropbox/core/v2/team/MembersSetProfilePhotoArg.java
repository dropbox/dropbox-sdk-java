/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.account.PhotoSourceArg;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

class MembersSetProfilePhotoArg {
    // struct team.MembersSetProfilePhotoArg (team_members.stone)

    @Nonnull
    protected final UserSelectorArg user;
    @Nonnull
    protected final PhotoSourceArg photo;

    /**
     *
     * @param user  Identity of the user whose profile photo will be set. Must
     *     not be {@code null}.
     * @param photo  Image to set as the member's new profile photo. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfilePhotoArg(@Nonnull UserSelectorArg user, @Nonnull PhotoSourceArg photo) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (photo == null) {
            throw new IllegalArgumentException("Required value for 'photo' is null");
        }
        this.photo = photo;
    }

    /**
     * Identity of the user whose profile photo will be set.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * Image to set as the member's new profile photo.
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
            user,
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
            MembersSetProfilePhotoArg other = (MembersSetProfilePhotoArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.photo == other.photo) || (this.photo.equals(other.photo)))
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
    static class Serializer extends StructSerializer<MembersSetProfilePhotoArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetProfilePhotoArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("photo");
            PhotoSourceArg.Serializer.INSTANCE.serialize(value.photo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersSetProfilePhotoArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersSetProfilePhotoArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                PhotoSourceArg f_photo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("photo".equals(field)) {
                        f_photo = PhotoSourceArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_photo == null) {
                    throw new JsonParseException(p, "Required field \"photo\" missing.");
                }
                value = new MembersSetProfilePhotoArg(f_user, f_photo);
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
