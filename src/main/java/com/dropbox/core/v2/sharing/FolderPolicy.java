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

/**
 * A set of policies governing membership and privileges for a shared folder.
 */
@JsonSerialize(using=FolderPolicy.Serializer.class)
@JsonDeserialize(using=FolderPolicy.Deserializer.class)
public class FolderPolicy {
    // struct FolderPolicy

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final MemberPolicy memberPolicy;
    protected final AclUpdatePolicy aclUpdatePolicy;
    protected final SharedLinkPolicy sharedLinkPolicy;

    /**
     * A set of policies governing membership and privileges for a shared
     * folder.
     *
     * @param aclUpdatePolicy  Who can add and remove members from this shared
     *     folder. Must not be {@code null}.
     * @param sharedLinkPolicy  Who links can be shared with. Must not be {@code
     *     null}.
     * @param memberPolicy  Who can be a member of this shared folder. Only set
     *     if the user is a member of a team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderPolicy(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy, MemberPolicy memberPolicy) {
        this.memberPolicy = memberPolicy;
        if (aclUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
        }
        this.aclUpdatePolicy = aclUpdatePolicy;
        if (sharedLinkPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
        }
        this.sharedLinkPolicy = sharedLinkPolicy;
    }

    /**
     * A set of policies governing membership and privileges for a shared
     * folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param aclUpdatePolicy  Who can add and remove members from this shared
     *     folder. Must not be {@code null}.
     * @param sharedLinkPolicy  Who links can be shared with. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderPolicy(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
        this(aclUpdatePolicy, sharedLinkPolicy, null);
    }

    /**
     * Who can be a member of this shared folder. Only set if the user is a
     * member of a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public MemberPolicy getMemberPolicy() {
        return memberPolicy;
    }

    /**
     * Who can add and remove members from this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public AclUpdatePolicy getAclUpdatePolicy() {
        return aclUpdatePolicy;
    }

    /**
     * Who links can be shared with.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedLinkPolicy getSharedLinkPolicy() {
        return sharedLinkPolicy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            memberPolicy,
            aclUpdatePolicy,
            sharedLinkPolicy
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
            FolderPolicy other = (FolderPolicy) obj;
            return ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
                && ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy != null && this.memberPolicy.equals(other.memberPolicy)))
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

    static final class Serializer extends StructJsonSerializer<FolderPolicy> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FolderPolicy.class);
        }

        public Serializer(boolean unwrapping) {
            super(FolderPolicy.class, unwrapping);
        }

        @Override
        protected JsonSerializer<FolderPolicy> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(FolderPolicy value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("acl_update_policy", value.aclUpdatePolicy);
            g.writeObjectField("shared_link_policy", value.sharedLinkPolicy);
            if (value.memberPolicy != null) {
                g.writeObjectField("member_policy", value.memberPolicy);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<FolderPolicy> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FolderPolicy.class);
        }

        public Deserializer(boolean unwrapping) {
            super(FolderPolicy.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<FolderPolicy> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public FolderPolicy deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            AclUpdatePolicy aclUpdatePolicy = null;
            SharedLinkPolicy sharedLinkPolicy = null;
            MemberPolicy memberPolicy = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("acl_update_policy".equals(_field)) {
                    aclUpdatePolicy = _p.readValueAs(AclUpdatePolicy.class);
                    _p.nextToken();
                }
                else if ("shared_link_policy".equals(_field)) {
                    sharedLinkPolicy = _p.readValueAs(SharedLinkPolicy.class);
                    _p.nextToken();
                }
                else if ("member_policy".equals(_field)) {
                    memberPolicy = _p.readValueAs(MemberPolicy.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (aclUpdatePolicy == null) {
                throw new JsonParseException(_p, "Required field \"acl_update_policy\" is missing.");
            }
            if (sharedLinkPolicy == null) {
                throw new JsonParseException(_p, "Required field \"shared_link_policy\" is missing.");
            }

            return new FolderPolicy(aclUpdatePolicy, sharedLinkPolicy, memberPolicy);
        }
    }
}
