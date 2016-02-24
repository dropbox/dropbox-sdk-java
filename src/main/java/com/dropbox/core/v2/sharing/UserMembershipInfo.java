/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * The information about a user member of the shared folder.
 */
public class UserMembershipInfo extends MembershipInfo {
    // struct UserMembershipInfo

    private final UserInfo user;

    /**
     * The information about a user member of the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param user  The account information for the membership user. Must not be
     *     {@code null}.
     * @param permissions  The permissions that requesting user has on this
     *     member. The set of permissions corresponds to the MemberActions in
     *     the request. Must not contain a {@code null} item.
     * @param initials  Suggested name initials for a member.
     * @param isInherited  True if the member's access to the file is inherited
     *     from a parent folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserMembershipInfo(AccessLevel accessType, UserInfo user, List<MemberPermission> permissions, String initials, boolean isInherited) {
        super(accessType, permissions, initials, isInherited);
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
    }

    /**
     * The information about a user member of the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param user  The account information for the membership user. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserMembershipInfo(AccessLevel accessType, UserInfo user) {
        this(accessType, user, null, null, false);
    }

    /**
     * The account information for the membership user.
     *
     * @return value for this field, never {@code null}.
     */
    public UserInfo getUser() {
        return user;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param user  The account information for the membership user. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, UserInfo user) {
        return new Builder(accessType, user);
    }

    /**
     * Builder for {@link UserMembershipInfo}.
     */
    public static class Builder extends MembershipInfo.Builder {
        protected final UserInfo user;

        protected Builder(AccessLevel accessType, UserInfo user) {
            super(accessType);
            if (user == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = user;
        }

        /**
         * Builds an instance of {@link UserMembershipInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link UserMembershipInfo}
         */
        public UserMembershipInfo build() {
            return new UserMembershipInfo(accessType, user, permissions, initials, isInherited);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            UserMembershipInfo other = (UserMembershipInfo) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.getAccessType() == other.getAccessType()) || (this.getAccessType().equals(other.getAccessType())))
                && ((this.getPermissions() == other.getPermissions()) || (this.getPermissions() != null && this.getPermissions().equals(other.getPermissions())))
                && ((this.getInitials() == other.getInitials()) || (this.getInitials() != null && this.getInitials().equals(other.getInitials())))
                && (this.getIsInherited() == other.getIsInherited())
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UserMembershipInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UserMembershipInfo> _JSON_WRITER = new JsonWriter<UserMembershipInfo>() {
        public final void write(UserMembershipInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembershipInfo._JSON_WRITER.writeFields(x, g);
            UserMembershipInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UserMembershipInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("user");
            UserInfo._JSON_WRITER.write(x.user, g);
        }
    };

    public static final JsonReader<UserMembershipInfo> _JSON_READER = new JsonReader<UserMembershipInfo>() {
        public final UserMembershipInfo read(JsonParser parser) throws IOException, JsonReadException {
            UserMembershipInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UserMembershipInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            AccessLevel accessType = null;
            UserInfo user = null;
            List<MemberPermission> permissions = null;
            String initials = null;
            Boolean isInherited = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("access_type".equals(fieldName)) {
                    accessType = AccessLevel._JSON_READER
                        .readField(parser, "access_type", accessType);
                }
                else if ("user".equals(fieldName)) {
                    user = UserInfo._JSON_READER
                        .readField(parser, "user", user);
                }
                else if ("permissions".equals(fieldName)) {
                    permissions = JsonArrayReader.mk(MemberPermission._JSON_READER)
                        .readField(parser, "permissions", permissions);
                }
                else if ("initials".equals(fieldName)) {
                    initials = JsonReader.StringReader
                        .readField(parser, "initials", initials);
                }
                else if ("is_inherited".equals(fieldName)) {
                    isInherited = JsonReader.BooleanReader
                        .readField(parser, "is_inherited", isInherited);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (accessType == null) {
                throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            return new UserMembershipInfo(accessType, user, permissions, initials, isInherited);
        }
    };
}
