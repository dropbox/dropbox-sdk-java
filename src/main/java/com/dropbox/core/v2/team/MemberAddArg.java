/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class MemberAddArg {
    // struct MemberAddArg

    private final String memberEmail;
    private final String memberGivenName;
    private final String memberSurname;
    private final String memberExternalId;
    private final boolean sendWelcomeEmail;
    private final AdminTier role;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param memberEmail  Must match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}" and
     *     not be {@code null}.
     * @param memberGivenName  Member's first name. Must have length of at least
     *     1, match pattern "{@code [^/:?*<>\"|]*}", and not be {@code null}.
     * @param memberSurname  Member's last name. Must have length of at least 1,
     *     match pattern "{@code [^/:?*<>\"|]*}", and not be {@code null}.
     * @param memberExternalId  External ID for member. Must have length of at
     *     most 64.
     * @param sendWelcomeEmail  Whether to send a welcome email to the member.
     *     If send_welcome_email is false, no email invitation will be sent to
     *     the user. This may be useful for apps using single sign-on (SSO)
     *     flows for onboarding that want to handle announcements themselves.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail, String memberGivenName, String memberSurname, String memberExternalId, boolean sendWelcomeEmail, AdminTier role) {
        if (memberEmail == null) {
            throw new IllegalArgumentException("Required value for 'memberEmail' is null");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", memberEmail)) {
            throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
        }
        this.memberEmail = memberEmail;
        if (memberGivenName == null) {
            throw new IllegalArgumentException("Required value for 'memberGivenName' is null");
        }
        if (memberGivenName.length() < 1) {
            throw new IllegalArgumentException("String 'memberGivenName' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberGivenName)) {
            throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
        }
        this.memberGivenName = memberGivenName;
        if (memberSurname == null) {
            throw new IllegalArgumentException("Required value for 'memberSurname' is null");
        }
        if (memberSurname.length() < 1) {
            throw new IllegalArgumentException("String 'memberSurname' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberSurname)) {
            throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
        }
        this.memberSurname = memberSurname;
        if (memberExternalId != null) {
            if (memberExternalId.length() > 64) {
                throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
            }
        }
        this.memberExternalId = memberExternalId;
        this.sendWelcomeEmail = sendWelcomeEmail;
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param memberEmail  Must match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}" and
     *     not be {@code null}.
     * @param memberGivenName  Member's first name. Must have length of at least
     *     1, match pattern "{@code [^/:?*<>\"|]*}", and not be {@code null}.
     * @param memberSurname  Member's last name. Must have length of at least 1,
     *     match pattern "{@code [^/:?*<>\"|]*}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail, String memberGivenName, String memberSurname) {
        this(memberEmail, memberGivenName, memberSurname, null, true, AdminTier.MEMBER_ONLY);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * Member's first name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getMemberGivenName() {
        return memberGivenName;
    }

    /**
     * Member's last name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getMemberSurname() {
        return memberSurname;
    }

    /**
     * External ID for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getMemberExternalId() {
        return memberExternalId;
    }

    /**
     * Whether to send a welcome email to the member. If send_welcome_email is
     * false, no email invitation will be sent to the user. This may be useful
     * for apps using single sign-on (SSO) flows for onboarding that want to
     * handle announcements themselves.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getSendWelcomeEmail() {
        return sendWelcomeEmail;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AdminTier.MEMBER_ONLY.
     */
    public AdminTier getRole() {
        return role;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param memberEmail  Must match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}" and
     *     not be {@code null}.
     * @param memberGivenName  Member's first name. Must have length of at least
     *     1, match pattern "{@code [^/:?*<>\"|]*}", and not be {@code null}.
     * @param memberSurname  Member's last name. Must have length of at least 1,
     *     match pattern "{@code [^/:?*<>\"|]*}", and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String memberEmail, String memberGivenName, String memberSurname) {
        return new Builder(memberEmail, memberGivenName, memberSurname);
    }

    /**
     * Builder for {@link MemberAddArg}.
     */
    public static class Builder {
        protected final String memberEmail;
        protected final String memberGivenName;
        protected final String memberSurname;

        protected String memberExternalId;
        protected boolean sendWelcomeEmail;
        protected AdminTier role;

        protected Builder(String memberEmail, String memberGivenName, String memberSurname) {
            if (memberEmail == null) {
                throw new IllegalArgumentException("Required value for 'memberEmail' is null");
            }
            if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", memberEmail)) {
                throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
            }
            this.memberEmail = memberEmail;
            if (memberGivenName == null) {
                throw new IllegalArgumentException("Required value for 'memberGivenName' is null");
            }
            if (memberGivenName.length() < 1) {
                throw new IllegalArgumentException("String 'memberGivenName' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberGivenName)) {
                throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
            }
            this.memberGivenName = memberGivenName;
            if (memberSurname == null) {
                throw new IllegalArgumentException("Required value for 'memberSurname' is null");
            }
            if (memberSurname.length() < 1) {
                throw new IllegalArgumentException("String 'memberSurname' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberSurname)) {
                throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
            }
            this.memberSurname = memberSurname;
            this.memberExternalId = null;
            this.sendWelcomeEmail = true;
            this.role = AdminTier.MEMBER_ONLY;
        }

        /**
         * Set value for optional field.
         *
         * @param memberExternalId  External ID for member. Must have length of
         *     at most 64.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMemberExternalId(String memberExternalId) {
            if (memberExternalId != null) {
                if (memberExternalId.length() > 64) {
                    throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
                }
            }
            this.memberExternalId = memberExternalId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param sendWelcomeEmail  Whether to send a welcome email to the
         *     member. If send_welcome_email is false, no email invitation will
         *     be sent to the user. This may be useful for apps using single
         *     sign-on (SSO) flows for onboarding that want to handle
         *     announcements themselves. Defaults to {@code true} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withSendWelcomeEmail(Boolean sendWelcomeEmail) {
            if (sendWelcomeEmail != null) {
                this.sendWelcomeEmail = sendWelcomeEmail;
            }
            else {
                this.sendWelcomeEmail = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * AdminTier.MEMBER_ONLY}. </p>
         *
         * @param role  Defaults to {@code AdminTier.MEMBER_ONLY} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withRole(AdminTier role) {
            if (role != null) {
                this.role = role;
            }
            else {
                this.role = AdminTier.MEMBER_ONLY;
            }
            return this;
        }

        /**
         * Builds an instance of {@link MemberAddArg} configured with this
         * builder's values
         *
         * @return new instance of {@link MemberAddArg}
         */
        public MemberAddArg build() {
            return new MemberAddArg(memberEmail, memberGivenName, memberSurname, memberExternalId, sendWelcomeEmail, role);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            memberEmail,
            memberGivenName,
            memberSurname,
            memberExternalId,
            sendWelcomeEmail,
            role
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
            MemberAddArg other = (MemberAddArg) obj;
            return ((this.memberEmail == other.memberEmail) || (this.memberEmail.equals(other.memberEmail)))
                && ((this.memberGivenName == other.memberGivenName) || (this.memberGivenName.equals(other.memberGivenName)))
                && ((this.memberSurname == other.memberSurname) || (this.memberSurname.equals(other.memberSurname)))
                && ((this.memberExternalId == other.memberExternalId) || (this.memberExternalId != null && this.memberExternalId.equals(other.memberExternalId)))
                && (this.sendWelcomeEmail == other.sendWelcomeEmail)
                && ((this.role == other.role) || (this.role.equals(other.role)))
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

    public static MemberAddArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberAddArg> _JSON_WRITER = new JsonWriter<MemberAddArg>() {
        public final void write(MemberAddArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MemberAddArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MemberAddArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("member_email");
            g.writeString(x.memberEmail);
            g.writeFieldName("member_given_name");
            g.writeString(x.memberGivenName);
            g.writeFieldName("member_surname");
            g.writeString(x.memberSurname);
            if (x.memberExternalId != null) {
                g.writeFieldName("member_external_id");
                g.writeString(x.memberExternalId);
            }
            g.writeFieldName("send_welcome_email");
            g.writeBoolean(x.sendWelcomeEmail);
            g.writeFieldName("role");
            AdminTier._JSON_WRITER.write(x.role, g);
        }
    };

    public static final JsonReader<MemberAddArg> _JSON_READER = new JsonReader<MemberAddArg>() {
        public final MemberAddArg read(JsonParser parser) throws IOException, JsonReadException {
            MemberAddArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MemberAddArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String memberEmail = null;
            String memberGivenName = null;
            String memberSurname = null;
            String memberExternalId = null;
            Boolean sendWelcomeEmail = null;
            AdminTier role = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("member_email".equals(fieldName)) {
                    memberEmail = JsonReader.StringReader
                        .readField(parser, "member_email", memberEmail);
                }
                else if ("member_given_name".equals(fieldName)) {
                    memberGivenName = JsonReader.StringReader
                        .readField(parser, "member_given_name", memberGivenName);
                }
                else if ("member_surname".equals(fieldName)) {
                    memberSurname = JsonReader.StringReader
                        .readField(parser, "member_surname", memberSurname);
                }
                else if ("member_external_id".equals(fieldName)) {
                    memberExternalId = JsonReader.StringReader
                        .readField(parser, "member_external_id", memberExternalId);
                }
                else if ("send_welcome_email".equals(fieldName)) {
                    sendWelcomeEmail = JsonReader.BooleanReader
                        .readField(parser, "send_welcome_email", sendWelcomeEmail);
                }
                else if ("role".equals(fieldName)) {
                    role = AdminTier._JSON_READER
                        .readField(parser, "role", role);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (memberEmail == null) {
                throw new JsonReadException("Required field \"member_email\" is missing.", parser.getTokenLocation());
            }
            if (memberGivenName == null) {
                throw new JsonReadException("Required field \"member_given_name\" is missing.", parser.getTokenLocation());
            }
            if (memberSurname == null) {
                throw new JsonReadException("Required field \"member_surname\" is missing.", parser.getTokenLocation());
            }
            return new MemberAddArg(memberEmail, memberGivenName, memberSurname, memberExternalId, sendWelcomeEmail, role);
        }
    };
}
