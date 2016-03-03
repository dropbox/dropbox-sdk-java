/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

/**
 * The information about a member of the shared folder.
 */
@JsonSerialize(using=MembershipInfo.Serializer.class)
@JsonDeserialize(using=MembershipInfo.Deserializer.class)
public class MembershipInfo {
    // struct MembershipInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<MembershipInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembershipInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembershipInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembershipInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembershipInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("access_type", value.accessType);
            if (value.permissions != null) {
                g.writeObjectField("permissions", value.permissions);
            }
            if (value.initials != null) {
                g.writeObjectField("initials", value.initials);
            }
            g.writeObjectField("is_inherited", value.isInherited);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembershipInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembershipInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembershipInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembershipInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembershipInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            AccessLevel accessType = null;
            List<MemberPermission> permissions = null;
            String initials = null;
            Boolean isInherited = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("access_type".equals(_field)) {
                    accessType = _p.readValueAs(AccessLevel.class);
                    _p.nextToken();
                }
                else if ("permissions".equals(_field)) {
                    expectArrayStart(_p);
                    permissions = new java.util.ArrayList<MemberPermission>();
                    while (!isArrayEnd(_p)) {
                        MemberPermission _x = null;
                        _x = _p.readValueAs(MemberPermission.class);
                        _p.nextToken();
                        permissions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("initials".equals(_field)) {
                    initials = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("is_inherited".equals(_field)) {
                    isInherited = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (accessType == null) {
                throw new JsonParseException(_p, "Required field \"access_type\" is missing.");
            }

            return new MembershipInfo(accessType, permissions, initials, isInherited);
        }
    }
}
