/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

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

/**
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account. At least one of new_email, new_external_id,
 * new_given_name, and/or new_surname must be provided.
 */
class MembersSetProfileArg {
    // struct team.MembersSetProfileArg (team_members.stone)

    protected final UserSelectorArg user;
    protected final String newEmail;
    protected final String newExternalId;
    protected final String newGivenName;
    protected final String newSurname;
    protected final String newPersistentId;
    protected final Boolean newIsDirectoryRestricted;

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
     * @param newEmail  New email for member. Must have length of at most 255
     *     and match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}".
     * @param newExternalId  New external ID for member. Must have length of at
     *     most 64.
     * @param newGivenName  New given name for member. Must have length of at
     *     most 100 and match pattern "{@code [^/:?*<>\"|]*}".
     * @param newSurname  New surname for member. Must have length of at most
     *     100 and match pattern "{@code [^/:?*<>\"|]*}".
     * @param newPersistentId  New persistent ID. This field only available to
     *     teams using persistent ID SAML configuration.
     * @param newIsDirectoryRestricted  New value for whether the user is a
     *     directory restricted user.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileArg(UserSelectorArg user, String newEmail, String newExternalId, String newGivenName, String newSurname, String newPersistentId, Boolean newIsDirectoryRestricted) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (newEmail != null) {
            if (newEmail.length() > 255) {
                throw new IllegalArgumentException("String 'newEmail' is longer than 255");
            }
            if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", newEmail)) {
                throw new IllegalArgumentException("String 'newEmail' does not match pattern");
            }
        }
        this.newEmail = newEmail;
        if (newExternalId != null) {
            if (newExternalId.length() > 64) {
                throw new IllegalArgumentException("String 'newExternalId' is longer than 64");
            }
        }
        this.newExternalId = newExternalId;
        if (newGivenName != null) {
            if (newGivenName.length() > 100) {
                throw new IllegalArgumentException("String 'newGivenName' is longer than 100");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", newGivenName)) {
                throw new IllegalArgumentException("String 'newGivenName' does not match pattern");
            }
        }
        this.newGivenName = newGivenName;
        if (newSurname != null) {
            if (newSurname.length() > 100) {
                throw new IllegalArgumentException("String 'newSurname' is longer than 100");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", newSurname)) {
                throw new IllegalArgumentException("String 'newSurname' does not match pattern");
            }
        }
        this.newSurname = newSurname;
        this.newPersistentId = newPersistentId;
        this.newIsDirectoryRestricted = newIsDirectoryRestricted;
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
        this(user, null, null, null, null, null, null);
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
     * New persistent ID. This field only available to teams using persistent ID
     * SAML configuration.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewPersistentId() {
        return newPersistentId;
    }

    /**
     * New value for whether the user is a directory restricted user.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getNewIsDirectoryRestricted() {
        return newIsDirectoryRestricted;
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
        protected String newPersistentId;
        protected Boolean newIsDirectoryRestricted;

        protected Builder(UserSelectorArg user) {
            if (user == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = user;
            this.newEmail = null;
            this.newExternalId = null;
            this.newGivenName = null;
            this.newSurname = null;
            this.newPersistentId = null;
            this.newIsDirectoryRestricted = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newEmail  New email for member. Must have length of at most
         *     255 and match pattern "{@code
         *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withNewEmail(String newEmail) {
            if (newEmail != null) {
                if (newEmail.length() > 255) {
                    throw new IllegalArgumentException("String 'newEmail' is longer than 255");
                }
                if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", newEmail)) {
                    throw new IllegalArgumentException("String 'newEmail' does not match pattern");
                }
            }
            this.newEmail = newEmail;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newExternalId  New external ID for member. Must have length of
         *     at most 64.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withNewExternalId(String newExternalId) {
            if (newExternalId != null) {
                if (newExternalId.length() > 64) {
                    throw new IllegalArgumentException("String 'newExternalId' is longer than 64");
                }
            }
            this.newExternalId = newExternalId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newGivenName  New given name for member. Must have length of
         *     at most 100 and match pattern "{@code [^/:?*<>\"|]*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withNewGivenName(String newGivenName) {
            if (newGivenName != null) {
                if (newGivenName.length() > 100) {
                    throw new IllegalArgumentException("String 'newGivenName' is longer than 100");
                }
                if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", newGivenName)) {
                    throw new IllegalArgumentException("String 'newGivenName' does not match pattern");
                }
            }
            this.newGivenName = newGivenName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newSurname  New surname for member. Must have length of at
         *     most 100 and match pattern "{@code [^/:?*<>\"|]*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withNewSurname(String newSurname) {
            if (newSurname != null) {
                if (newSurname.length() > 100) {
                    throw new IllegalArgumentException("String 'newSurname' is longer than 100");
                }
                if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", newSurname)) {
                    throw new IllegalArgumentException("String 'newSurname' does not match pattern");
                }
            }
            this.newSurname = newSurname;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newPersistentId  New persistent ID. This field only available
         *     to teams using persistent ID SAML configuration.
         *
         * @return this builder
         */
        public Builder withNewPersistentId(String newPersistentId) {
            this.newPersistentId = newPersistentId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newIsDirectoryRestricted  New value for whether the user is a
         *     directory restricted user.
         *
         * @return this builder
         */
        public Builder withNewIsDirectoryRestricted(Boolean newIsDirectoryRestricted) {
            this.newIsDirectoryRestricted = newIsDirectoryRestricted;
            return this;
        }

        /**
         * Builds an instance of {@link MembersSetProfileArg} configured with
         * this builder's values
         *
         * @return new instance of {@link MembersSetProfileArg}
         */
        public MembersSetProfileArg build() {
            return new MembersSetProfileArg(user, newEmail, newExternalId, newGivenName, newSurname, newPersistentId, newIsDirectoryRestricted);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            user,
            newEmail,
            newExternalId,
            newGivenName,
            newSurname,
            newPersistentId,
            newIsDirectoryRestricted
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
            MembersSetProfileArg other = (MembersSetProfileArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.newEmail == other.newEmail) || (this.newEmail != null && this.newEmail.equals(other.newEmail)))
                && ((this.newExternalId == other.newExternalId) || (this.newExternalId != null && this.newExternalId.equals(other.newExternalId)))
                && ((this.newGivenName == other.newGivenName) || (this.newGivenName != null && this.newGivenName.equals(other.newGivenName)))
                && ((this.newSurname == other.newSurname) || (this.newSurname != null && this.newSurname.equals(other.newSurname)))
                && ((this.newPersistentId == other.newPersistentId) || (this.newPersistentId != null && this.newPersistentId.equals(other.newPersistentId)))
                && ((this.newIsDirectoryRestricted == other.newIsDirectoryRestricted) || (this.newIsDirectoryRestricted != null && this.newIsDirectoryRestricted.equals(other.newIsDirectoryRestricted)))
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
    static class Serializer extends StructSerializer<MembersSetProfileArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersSetProfileArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            if (value.newEmail != null) {
                g.writeFieldName("new_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newEmail, g);
            }
            if (value.newExternalId != null) {
                g.writeFieldName("new_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newExternalId, g);
            }
            if (value.newGivenName != null) {
                g.writeFieldName("new_given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newGivenName, g);
            }
            if (value.newSurname != null) {
                g.writeFieldName("new_surname");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newSurname, g);
            }
            if (value.newPersistentId != null) {
                g.writeFieldName("new_persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newPersistentId, g);
            }
            if (value.newIsDirectoryRestricted != null) {
                g.writeFieldName("new_is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.newIsDirectoryRestricted, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersSetProfileArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersSetProfileArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                String f_newEmail = null;
                String f_newExternalId = null;
                String f_newGivenName = null;
                String f_newSurname = null;
                String f_newPersistentId = null;
                Boolean f_newIsDirectoryRestricted = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_email".equals(field)) {
                        f_newEmail = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_external_id".equals(field)) {
                        f_newExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_given_name".equals(field)) {
                        f_newGivenName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_surname".equals(field)) {
                        f_newSurname = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_persistent_id".equals(field)) {
                        f_newPersistentId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_is_directory_restricted".equals(field)) {
                        f_newIsDirectoryRestricted = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                value = new MembersSetProfileArg(f_user, f_newEmail, f_newExternalId, f_newGivenName, f_newSurname, f_newPersistentId, f_newIsDirectoryRestricted);
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
