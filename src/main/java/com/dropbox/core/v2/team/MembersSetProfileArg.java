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

/**
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account. At least one of new_email, new_external_id,
 * new_given_name, and/or new_surname must be provided.
 */
public class MembersSetProfileArg {
    // struct MembersSetProfileArg

    private final UserSelectorArg user;
    private final String newEmail;
    private final String newExternalId;
    private final String newGivenName;
    private final String newSurname;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account. At least one of new_email, new_external_id,
     * new_given_name, and/or new_surname must be provided.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param user  Identity of user whose profile will be set. Must not be
     *     {@code null}.
     * @param newEmail  New email for member.
     * @param newExternalId  New external ID for member.
     * @param newGivenName  New given name for member.
     * @param newSurname  New surname for member.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileArg(UserSelectorArg user, String newEmail, String newExternalId, String newGivenName, String newSurname) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        this.newEmail = newEmail;
        this.newExternalId = newExternalId;
        this.newGivenName = newGivenName;
        this.newSurname = newSurname;
    }

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account. At least one of new_email, new_external_id,
     * new_given_name, and/or new_surname must be provided.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param user  Identity of user whose profile will be set. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileArg(UserSelectorArg user) {
        this(user, null, null, null, null);
    }

    /**
     * Identity of user whose profile will be set.
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * New email for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewEmail() {
        return newEmail;
    }

    /**
     * New external ID for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewExternalId() {
        return newExternalId;
    }

    /**
     * New given name for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewGivenName() {
        return newGivenName;
    }

    /**
     * New surname for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewSurname() {
        return newSurname;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param user  Identity of user whose profile will be set. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(UserSelectorArg user) {
        return new Builder(user);
    }

    /**
     * Builder for {@link MembersSetProfileArg}.
     */
    public static class Builder {
        protected final UserSelectorArg user;

        protected String newEmail;
        protected String newExternalId;
        protected String newGivenName;
        protected String newSurname;

        protected Builder(UserSelectorArg user) {
            if (user == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = user;
            this.newEmail = null;
            this.newExternalId = null;
            this.newGivenName = null;
            this.newSurname = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newEmail  New email for member.
         *
         * @return this builder
         */
        public Builder withNewEmail(String newEmail) {
            this.newEmail = newEmail;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newExternalId  New external ID for member.
         *
         * @return this builder
         */
        public Builder withNewExternalId(String newExternalId) {
            this.newExternalId = newExternalId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newGivenName  New given name for member.
         *
         * @return this builder
         */
        public Builder withNewGivenName(String newGivenName) {
            this.newGivenName = newGivenName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newSurname  New surname for member.
         *
         * @return this builder
         */
        public Builder withNewSurname(String newSurname) {
            this.newSurname = newSurname;
            return this;
        }

        /**
         * Builds an instance of {@link MembersSetProfileArg} configured with
         * this builder's values
         *
         * @return new instance of {@link MembersSetProfileArg}
         */
        public MembersSetProfileArg build() {
            return new MembersSetProfileArg(user, newEmail, newExternalId, newGivenName, newSurname);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user,
            newEmail,
            newExternalId,
            newGivenName,
            newSurname
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
            MembersSetProfileArg other = (MembersSetProfileArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.newEmail == other.newEmail) || (this.newEmail != null && this.newEmail.equals(other.newEmail)))
                && ((this.newExternalId == other.newExternalId) || (this.newExternalId != null && this.newExternalId.equals(other.newExternalId)))
                && ((this.newGivenName == other.newGivenName) || (this.newGivenName != null && this.newGivenName.equals(other.newGivenName)))
                && ((this.newSurname == other.newSurname) || (this.newSurname != null && this.newSurname.equals(other.newSurname)))
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

    public static MembersSetProfileArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersSetProfileArg> _JSON_WRITER = new JsonWriter<MembersSetProfileArg>() {
        public final void write(MembersSetProfileArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersSetProfileArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersSetProfileArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("user");
            UserSelectorArg._JSON_WRITER.write(x.user, g);
            if (x.newEmail != null) {
                g.writeFieldName("new_email");
                g.writeString(x.newEmail);
            }
            if (x.newExternalId != null) {
                g.writeFieldName("new_external_id");
                g.writeString(x.newExternalId);
            }
            if (x.newGivenName != null) {
                g.writeFieldName("new_given_name");
                g.writeString(x.newGivenName);
            }
            if (x.newSurname != null) {
                g.writeFieldName("new_surname");
                g.writeString(x.newSurname);
            }
        }
    };

    public static final JsonReader<MembersSetProfileArg> _JSON_READER = new JsonReader<MembersSetProfileArg>() {
        public final MembersSetProfileArg read(JsonParser parser) throws IOException, JsonReadException {
            MembersSetProfileArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersSetProfileArg readFields(JsonParser parser) throws IOException, JsonReadException {
            UserSelectorArg user = null;
            String newEmail = null;
            String newExternalId = null;
            String newGivenName = null;
            String newSurname = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("user".equals(fieldName)) {
                    user = UserSelectorArg._JSON_READER
                        .readField(parser, "user", user);
                }
                else if ("new_email".equals(fieldName)) {
                    newEmail = JsonReader.StringReader
                        .readField(parser, "new_email", newEmail);
                }
                else if ("new_external_id".equals(fieldName)) {
                    newExternalId = JsonReader.StringReader
                        .readField(parser, "new_external_id", newExternalId);
                }
                else if ("new_given_name".equals(fieldName)) {
                    newGivenName = JsonReader.StringReader
                        .readField(parser, "new_given_name", newGivenName);
                }
                else if ("new_surname".equals(fieldName)) {
                    newSurname = JsonReader.StringReader
                        .readField(parser, "new_surname", newSurname);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            return new MembersSetProfileArg(user, newEmail, newExternalId, newGivenName, newSurname);
        }
    };
}
