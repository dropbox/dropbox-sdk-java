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

@JsonSerialize(using=ShareFolderArg.Serializer.class)
@JsonDeserialize(using=ShareFolderArg.Deserializer.class)
class ShareFolderArg {
    // struct ShareFolderArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final MemberPolicy memberPolicy;
    protected final AclUpdatePolicy aclUpdatePolicy;
    protected final SharedLinkPolicy sharedLinkPolicy;
    protected final boolean forceAsync;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /.*}" and not be
     *     {@code null}.
     * @param memberPolicy  Who can be a member of this shared folder.
     * @param aclUpdatePolicy  Who can add and remove members of this shared
     *     folder.
     * @param sharedLinkPolicy  The policy to apply to shared links created for
     *     content inside this shared folder.
     * @param forceAsync  Whether to force the share to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderArg(String path, MemberPolicy memberPolicy, AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy, boolean forceAsync) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (memberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'memberPolicy' is null");
        }
        this.memberPolicy = memberPolicy;
        if (aclUpdatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
        }
        this.aclUpdatePolicy = aclUpdatePolicy;
        if (sharedLinkPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
        }
        this.sharedLinkPolicy = sharedLinkPolicy;
        this.forceAsync = forceAsync;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /.*}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderArg(String path) {
        this(path, MemberPolicy.ANYONE, AclUpdatePolicy.OWNER, SharedLinkPolicy.ANYONE, false);
    }

    /**
     * The path to the folder to share. If it does not exist, then a new one is
     * created.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Who can be a member of this shared folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     MemberPolicy.ANYONE.
     */
    public MemberPolicy getMemberPolicy() {
        return memberPolicy;
    }

    /**
     * Who can add and remove members of this shared folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AclUpdatePolicy.OWNER.
     */
    public AclUpdatePolicy getAclUpdatePolicy() {
        return aclUpdatePolicy;
    }

    /**
     * The policy to apply to shared links created for content inside this
     * shared folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     SharedLinkPolicy.ANYONE.
     */
    public SharedLinkPolicy getSharedLinkPolicy() {
        return sharedLinkPolicy;
    }

    /**
     * Whether to force the share to happen asynchronously.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getForceAsync() {
        return forceAsync;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /.*}" and not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link ShareFolderArg}.
     */
    public static class Builder {
        protected final String path;

        protected MemberPolicy memberPolicy;
        protected AclUpdatePolicy aclUpdatePolicy;
        protected SharedLinkPolicy sharedLinkPolicy;
        protected boolean forceAsync;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.memberPolicy = MemberPolicy.ANYONE;
            this.aclUpdatePolicy = AclUpdatePolicy.OWNER;
            this.sharedLinkPolicy = SharedLinkPolicy.ANYONE;
            this.forceAsync = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * MemberPolicy.ANYONE}. </p>
         *
         * @param memberPolicy  Who can be a member of this shared folder.
         *     Defaults to {@code MemberPolicy.ANYONE} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withMemberPolicy(MemberPolicy memberPolicy) {
            if (memberPolicy != null) {
                this.memberPolicy = memberPolicy;
            }
            else {
                this.memberPolicy = MemberPolicy.ANYONE;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * AclUpdatePolicy.OWNER}. </p>
         *
         * @param aclUpdatePolicy  Who can add and remove members of this shared
         *     folder. Defaults to {@code AclUpdatePolicy.OWNER} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
            if (aclUpdatePolicy != null) {
                this.aclUpdatePolicy = aclUpdatePolicy;
            }
            else {
                this.aclUpdatePolicy = AclUpdatePolicy.OWNER;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * SharedLinkPolicy.ANYONE}. </p>
         *
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder. Defaults to {@code
         *     SharedLinkPolicy.ANYONE} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
            if (sharedLinkPolicy != null) {
                this.sharedLinkPolicy = sharedLinkPolicy;
            }
            else {
                this.sharedLinkPolicy = SharedLinkPolicy.ANYONE;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param forceAsync  Whether to force the share to happen
         *     asynchronously. Defaults to {@code false} when set to {@code
         *     null}.
         *
         * @return this builder
         */
        public Builder withForceAsync(Boolean forceAsync) {
            if (forceAsync != null) {
                this.forceAsync = forceAsync;
            }
            else {
                this.forceAsync = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ShareFolderArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ShareFolderArg}
         */
        public ShareFolderArg build() {
            return new ShareFolderArg(path, memberPolicy, aclUpdatePolicy, sharedLinkPolicy, forceAsync);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            memberPolicy,
            aclUpdatePolicy,
            sharedLinkPolicy,
            forceAsync
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
            ShareFolderArg other = (ShareFolderArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy.equals(other.memberPolicy)))
                && ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
                && (this.forceAsync == other.forceAsync)
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

    static final class Serializer extends StructJsonSerializer<ShareFolderArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ShareFolderArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ShareFolderArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ShareFolderArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ShareFolderArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("member_policy", value.memberPolicy);
            g.writeObjectField("acl_update_policy", value.aclUpdatePolicy);
            g.writeObjectField("shared_link_policy", value.sharedLinkPolicy);
            g.writeObjectField("force_async", value.forceAsync);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ShareFolderArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ShareFolderArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ShareFolderArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ShareFolderArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ShareFolderArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            MemberPolicy memberPolicy = null;
            AclUpdatePolicy aclUpdatePolicy = null;
            SharedLinkPolicy sharedLinkPolicy = null;
            Boolean forceAsync = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_policy".equals(_field)) {
                    memberPolicy = _p.readValueAs(MemberPolicy.class);
                    _p.nextToken();
                }
                else if ("acl_update_policy".equals(_field)) {
                    aclUpdatePolicy = _p.readValueAs(AclUpdatePolicy.class);
                    _p.nextToken();
                }
                else if ("shared_link_policy".equals(_field)) {
                    sharedLinkPolicy = _p.readValueAs(SharedLinkPolicy.class);
                    _p.nextToken();
                }
                else if ("force_async".equals(_field)) {
                    forceAsync = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new ShareFolderArg(path, memberPolicy, aclUpdatePolicy, sharedLinkPolicy, forceAsync);
        }
    }
}
