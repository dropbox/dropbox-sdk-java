/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * The information about a member of the shared folder.
 */
public class MembershipInfo {
    // struct MembershipInfo

    protected final AccessLevel accessType;
    protected final List<MemberPermission> permissions;
    protected final String initials;
    protected final boolean isInherited;

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
    static final class Serializer extends StructSerializer<MembershipInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembershipInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessType, g);
            if (value.permissions != null) {
                g.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).serialize(value.permissions, g);
            }
            if (value.initials != null) {
                g.writeFieldName("initials");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.initials, g);
            }
            g.writeFieldName("is_inherited");
            StoneSerializers.boolean_().serialize(value.isInherited, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembershipInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembershipInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_accessType = null;
                List<MemberPermission> f_permissions = null;
                String f_initials = null;
                Boolean f_isInherited = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_type".equals(field)) {
                        f_accessType = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("permissions".equals(field)) {
                        f_permissions = StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("initials".equals(field)) {
                        f_initials = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("is_inherited".equals(field)) {
                        f_isInherited = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                value = new MembershipInfo(f_accessType, f_permissions, f_initials, f_isInherited);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
