/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Per-member result for {@link
 * DbxUserSharingRequests#addFileMember(String,List)}.
 */
public class FileMemberActionResult {
    // struct sharing.FileMemberActionResult (sharing_files.stone)

    protected final MemberSelector member;
    protected final FileMemberActionIndividualResult result;
    protected final String sckeySha1;
    protected final List<String> invitationSignature;

    /**
     * Per-member result for {@link
     * DbxUserSharingRequests#addFileMember(String,List)}.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param member  One of specified input members. Must not be {@code null}.
     * @param result  The outcome of the action on this member. Must not be
     *     {@code null}.
     * @param sckeySha1  The SHA-1 encrypted shared content key.
     * @param invitationSignature  The sharing sender-recipient invitation
     *     signatures for the input member_id. A member_id can be a group and
     *     thus have multiple users and multiple invitation signatures. Must not
     *     contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMemberActionResult(@Nonnull MemberSelector member, @Nonnull FileMemberActionIndividualResult result, @Nullable String sckeySha1, @Nullable List<String> invitationSignature) {
        if (member == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = member;
        if (result == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = result;
        this.sckeySha1 = sckeySha1;
        if (invitationSignature != null) {
            for (String x : invitationSignature) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'invitationSignature' is null");
                }
            }
        }
        this.invitationSignature = invitationSignature;
    }

    /**
     * Per-member result for {@link
     * DbxUserSharingRequests#addFileMember(String,List)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param member  One of specified input members. Must not be {@code null}.
     * @param result  The outcome of the action on this member. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMemberActionResult(MemberSelector member, FileMemberActionIndividualResult result) {
        this(member, result, null, null);
    }

    /**
     * One of specified input members.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public MemberSelector getMember() {
        return member;
    }

    /**
     * The outcome of the action on this member.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FileMemberActionIndividualResult getResult() {
        return result;
    }

    /**
     * The SHA-1 encrypted shared content key.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSckeySha1() {
        return sckeySha1;
    }

    /**
     * The sharing sender-recipient invitation signatures for the input
     * member_id. A member_id can be a group and thus have multiple users and
     * multiple invitation signatures.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getInvitationSignature() {
        return invitationSignature;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param member  One of specified input members. Must not be {@code null}.
     * @param result  The outcome of the action on this member. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(MemberSelector member, FileMemberActionIndividualResult result) {
        return new Builder(member, result);
    }

    /**
     * Builder for {@link FileMemberActionResult}.
     */
    public static class Builder {
        protected final MemberSelector member;
        protected final FileMemberActionIndividualResult result;

        protected String sckeySha1;
        protected List<String> invitationSignature;

        protected Builder(MemberSelector member, FileMemberActionIndividualResult result) {
            if (member == null) {
                throw new IllegalArgumentException("Required value for 'member' is null");
            }
            this.member = member;
            if (result == null) {
                throw new IllegalArgumentException("Required value for 'result' is null");
            }
            this.result = result;
            this.sckeySha1 = null;
            this.invitationSignature = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sckeySha1  The SHA-1 encrypted shared content key.
         *
         * @return this builder
         */
        public Builder withSckeySha1(String sckeySha1) {
            this.sckeySha1 = sckeySha1;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param invitationSignature  The sharing sender-recipient invitation
         *     signatures for the input member_id. A member_id can be a group
         *     and thus have multiple users and multiple invitation signatures.
         *     Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withInvitationSignature(List<String> invitationSignature) {
            if (invitationSignature != null) {
                for (String x : invitationSignature) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'invitationSignature' is null");
                    }
                }
            }
            this.invitationSignature = invitationSignature;
            return this;
        }

        /**
         * Builds an instance of {@link FileMemberActionResult} configured with
         * this builder's values
         *
         * @return new instance of {@link FileMemberActionResult}
         */
        public FileMemberActionResult build() {
            return new FileMemberActionResult(member, result, sckeySha1, invitationSignature);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            member,
            result,
            sckeySha1,
            invitationSignature
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
            FileMemberActionResult other = (FileMemberActionResult) obj;
            return ((this.member == other.member) || (this.member.equals(other.member)))
                && ((this.result == other.result) || (this.result.equals(other.result)))
                && ((this.sckeySha1 == other.sckeySha1) || (this.sckeySha1 != null && this.sckeySha1.equals(other.sckeySha1)))
                && ((this.invitationSignature == other.invitationSignature) || (this.invitationSignature != null && this.invitationSignature.equals(other.invitationSignature)))
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
    static class Serializer extends StructSerializer<FileMemberActionResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileMemberActionResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(value.member, g);
            g.writeFieldName("result");
            FileMemberActionIndividualResult.Serializer.INSTANCE.serialize(value.result, g);
            if (value.sckeySha1 != null) {
                g.writeFieldName("sckey_sha1");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sckeySha1, g);
            }
            if (value.invitationSignature != null) {
                g.writeFieldName("invitation_signature");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.invitationSignature, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileMemberActionResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileMemberActionResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                MemberSelector f_member = null;
                FileMemberActionIndividualResult f_result = null;
                String f_sckeySha1 = null;
                List<String> f_invitationSignature = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("member".equals(field)) {
                        f_member = MemberSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("result".equals(field)) {
                        f_result = FileMemberActionIndividualResult.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("sckey_sha1".equals(field)) {
                        f_sckeySha1 = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("invitation_signature".equals(field)) {
                        f_invitationSignature = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_member == null) {
                    throw new JsonParseException(p, "Required field \"member\" missing.");
                }
                if (f_result == null) {
                    throw new JsonParseException(p, "Required field \"result\" missing.");
                }
                value = new FileMemberActionResult(f_member, f_result, f_sckeySha1, f_invitationSignature);
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
