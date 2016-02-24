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
 * The information about a member of the shared folder.
 */
public class MembershipInfo {
    // struct MembershipInfo

    private final AccessLevel accessType;
    private final List<MemberPermission> permissions;
    private final String initials;
    private final boolean isInherited;

    /**
     * The information about a member of the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
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
    public MembershipInfo(AccessLevel accessType, List<MemberPermission> permissions, String initials, boolean isInherited) {
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
        if (permissions != null) {
            for (MemberPermission x : permissions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = permissions;
        this.initials = initials;
        this.isInherited = isInherited;
    }

    /**
     * The information about a member of the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembershipInfo(AccessLevel accessType) {
        this(accessType, null, null, false);
    }

    /**
     * The access type for this member.
     *
     * @return value for this field, never {@code null}.
     */
    public AccessLevel getAccessType() {
        return accessType;
    }

    /**
     * The permissions that requesting user has on this member. The set of
     * permissions corresponds to the MemberActions in the request.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<MemberPermission> getPermissions() {
        return permissions;
    }

    /**
     * Suggested name initials for a member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getInitials() {
        return initials;
    }

    /**
     * True if the member's access to the file is inherited from a parent
     * folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIsInherited() {
        return isInherited;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType) {
        return new Builder(accessType);
    }

    /**
     * Builder for {@link MembershipInfo}.
     */
    public static class Builder {
        protected final AccessLevel accessType;

        protected List<MemberPermission> permissions;
        protected String initials;
        protected boolean isInherited;

        protected Builder(AccessLevel accessType) {
            if (accessType == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.accessType = accessType;
            this.permissions = null;
            this.initials = null;
            this.isInherited = false;
        }

        /**
         * Set value for optional field.
         *
         * @param permissions  The permissions that requesting user has on this
         *     member. The set of permissions corresponds to the MemberActions
         *     in the request. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPermissions(List<MemberPermission> permissions) {
            if (permissions != null) {
                for (MemberPermission x : permissions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'permissions' is null");
                    }
                }
            }
            this.permissions = permissions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param initials  Suggested name initials for a member.
         *
         * @return this builder
         */
        public Builder withInitials(String initials) {
            this.initials = initials;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param isInherited  True if the member's access to the file is
         *     inherited from a parent folder. Defaults to {@code false} when
         *     set to {@code null}.
         *
         * @return this builder
         */
        public Builder withIsInherited(Boolean isInherited) {
            if (isInherited != null) {
                this.isInherited = isInherited;
            }
            else {
                this.isInherited = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link MembershipInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link MembershipInfo}
         */
        public MembershipInfo build() {
            return new MembershipInfo(accessType, permissions, initials, isInherited);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accessType,
            permissions,
            initials,
            isInherited
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            MembershipInfo other = (MembershipInfo) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                && ((this.initials == other.initials) || (this.initials != null && this.initials.equals(other.initials)))
                && (this.isInherited == other.isInherited)
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

    public static MembershipInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembershipInfo> _JSON_WRITER = new JsonWriter<MembershipInfo>() {
        public final void write(MembershipInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembershipInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembershipInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("access_type");
            AccessLevel._JSON_WRITER.write(x.accessType, g);
            if (x.permissions != null) {
                g.writeFieldName("permissions");
                g.writeStartArray();
                for (MemberPermission item: x.permissions) {
                    if (item != null) {
                        MemberPermission._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
            if (x.initials != null) {
                g.writeFieldName("initials");
                g.writeString(x.initials);
            }
            g.writeFieldName("is_inherited");
            g.writeBoolean(x.isInherited);
        }
    };

    public static final JsonReader<MembershipInfo> _JSON_READER = new JsonReader<MembershipInfo>() {
        public final MembershipInfo read(JsonParser parser) throws IOException, JsonReadException {
            MembershipInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembershipInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            AccessLevel accessType = null;
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
            return new MembershipInfo(accessType, permissions, initials, isInherited);
        }
    };
}
