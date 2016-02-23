/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ShareFolderArg {
    // struct ShareFolderArg

    private final String path;
    private final MemberPolicy memberPolicy;
    private final AclUpdatePolicy aclUpdatePolicy;
    private final SharedLinkPolicy sharedLinkPolicy;
    private final boolean forceAsync;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ShareFolderArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ShareFolderArg> _JSON_WRITER = new JsonWriter<ShareFolderArg>() {
        public final void write(ShareFolderArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ShareFolderArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ShareFolderArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("member_policy");
            MemberPolicy._JSON_WRITER.write(x.memberPolicy, g);
            g.writeFieldName("acl_update_policy");
            AclUpdatePolicy._JSON_WRITER.write(x.aclUpdatePolicy, g);
            g.writeFieldName("shared_link_policy");
            SharedLinkPolicy._JSON_WRITER.write(x.sharedLinkPolicy, g);
            g.writeFieldName("force_async");
            g.writeBoolean(x.forceAsync);
        }
    };

    public static final JsonReader<ShareFolderArg> _JSON_READER = new JsonReader<ShareFolderArg>() {
        public final ShareFolderArg read(JsonParser parser) throws IOException, JsonReadException {
            ShareFolderArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ShareFolderArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            MemberPolicy memberPolicy = null;
            AclUpdatePolicy aclUpdatePolicy = null;
            SharedLinkPolicy sharedLinkPolicy = null;
            Boolean forceAsync = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("member_policy".equals(fieldName)) {
                    memberPolicy = MemberPolicy._JSON_READER
                        .readField(parser, "member_policy", memberPolicy);
                }
                else if ("acl_update_policy".equals(fieldName)) {
                    aclUpdatePolicy = AclUpdatePolicy._JSON_READER
                        .readField(parser, "acl_update_policy", aclUpdatePolicy);
                }
                else if ("shared_link_policy".equals(fieldName)) {
                    sharedLinkPolicy = SharedLinkPolicy._JSON_READER
                        .readField(parser, "shared_link_policy", sharedLinkPolicy);
                }
                else if ("force_async".equals(fieldName)) {
                    forceAsync = JsonReader.BooleanReader
                        .readField(parser, "force_async", forceAsync);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new ShareFolderArg(path, memberPolicy, aclUpdatePolicy, sharedLinkPolicy, forceAsync);
        }
    };
}
