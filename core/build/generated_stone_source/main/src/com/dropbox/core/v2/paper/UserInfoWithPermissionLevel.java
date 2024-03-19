/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.sharing.UserInfo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

public class UserInfoWithPermissionLevel {
    // struct paper.UserInfoWithPermissionLevel (paper.stone)

    @Nonnull
    protected final UserInfo user;
    @Nonnull
    protected final PaperDocPermissionLevel permissionLevel;

    /**
     *
     * @param user  User shared on the Paper doc. Must not be {@code null}.
     * @param permissionLevel  Permission level for the user. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserInfoWithPermissionLevel(@Nonnull UserInfo user, @Nonnull PaperDocPermissionLevel permissionLevel) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (permissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'permissionLevel' is null");
        }
        this.permissionLevel = permissionLevel;
    }

    /**
     * User shared on the Paper doc.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserInfo getUser() {
        return user;
    }

    /**
     * Permission level for the user.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public PaperDocPermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            user,
            permissionLevel
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
            UserInfoWithPermissionLevel other = (UserInfoWithPermissionLevel) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.permissionLevel == other.permissionLevel) || (this.permissionLevel.equals(other.permissionLevel)))
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
    static class Serializer extends StructSerializer<UserInfoWithPermissionLevel> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserInfoWithPermissionLevel value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserInfo.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("permission_level");
            PaperDocPermissionLevel.Serializer.INSTANCE.serialize(value.permissionLevel, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserInfoWithPermissionLevel deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserInfoWithPermissionLevel value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserInfo f_user = null;
                PaperDocPermissionLevel f_permissionLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("permission_level".equals(field)) {
                        f_permissionLevel = PaperDocPermissionLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_permissionLevel == null) {
                    throw new JsonParseException(p, "Required field \"permission_level\" missing.");
                }
                value = new UserInfoWithPermissionLevel(f_user, f_permissionLevel);
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
