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

/**
 * A set of policies governing membership and privileges for a shared folder.
 */
public class FolderPolicy {
    // struct FolderPolicy

    private final MemberPolicy memberPolicy;
    private final AclUpdatePolicy aclUpdatePolicy;
    private final SharedLinkPolicy sharedLinkPolicy;

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
            return ((this.memberPolicy == other.memberPolicy) || (this.memberPolicy != null && this.memberPolicy.equals(other.memberPolicy)))
                && ((this.aclUpdatePolicy == other.aclUpdatePolicy) || (this.aclUpdatePolicy.equals(other.aclUpdatePolicy)))
                && ((this.sharedLinkPolicy == other.sharedLinkPolicy) || (this.sharedLinkPolicy.equals(other.sharedLinkPolicy)))
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

    public static FolderPolicy fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FolderPolicy> _JSON_WRITER = new JsonWriter<FolderPolicy>() {
        public final void write(FolderPolicy x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            FolderPolicy._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FolderPolicy x, JsonGenerator g) throws IOException {
            if (x.memberPolicy != null) {
                g.writeFieldName("member_policy");
                MemberPolicy._JSON_WRITER.write(x.memberPolicy, g);
            }
            g.writeFieldName("acl_update_policy");
            AclUpdatePolicy._JSON_WRITER.write(x.aclUpdatePolicy, g);
            g.writeFieldName("shared_link_policy");
            SharedLinkPolicy._JSON_WRITER.write(x.sharedLinkPolicy, g);
        }
    };

    public static final JsonReader<FolderPolicy> _JSON_READER = new JsonReader<FolderPolicy>() {
        public final FolderPolicy read(JsonParser parser) throws IOException, JsonReadException {
            FolderPolicy result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FolderPolicy readFields(JsonParser parser) throws IOException, JsonReadException {
            AclUpdatePolicy aclUpdatePolicy = null;
            SharedLinkPolicy sharedLinkPolicy = null;
            MemberPolicy memberPolicy = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("acl_update_policy".equals(fieldName)) {
                    aclUpdatePolicy = AclUpdatePolicy._JSON_READER
                        .readField(parser, "acl_update_policy", aclUpdatePolicy);
                }
                else if ("shared_link_policy".equals(fieldName)) {
                    sharedLinkPolicy = SharedLinkPolicy._JSON_READER
                        .readField(parser, "shared_link_policy", sharedLinkPolicy);
                }
                else if ("member_policy".equals(fieldName)) {
                    memberPolicy = MemberPolicy._JSON_READER
                        .readField(parser, "member_policy", memberPolicy);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (aclUpdatePolicy == null) {
                throw new JsonReadException("Required field \"acl_update_policy\" is missing.", parser.getTokenLocation());
            }
            if (sharedLinkPolicy == null) {
                throw new JsonReadException("Required field \"shared_link_policy\" is missing.", parser.getTokenLocation());
            }
            return new FolderPolicy(aclUpdatePolicy, sharedLinkPolicy, memberPolicy);
        }
    };
}
