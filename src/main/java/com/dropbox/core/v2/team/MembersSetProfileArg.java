/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

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
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account. At least one of new_email, new_external_id,
 * new_given_name, and/or new_surname must be provided.
 */
@JsonSerialize(using=MembersSetProfileArg.Serializer.class)
@JsonDeserialize(using=MembersSetProfileArg.Deserializer.class)
class MembersSetProfileArg {
    // struct MembersSetProfileArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UserSelectorArg user;
    protected final String newEmail;
    protected final String newExternalId;
    protected final String newGivenName;
    protected final String newSurname;

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
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}".
     * @param newExternalId  New external ID for member. Must have length of at
     *     most 64.
     * @param newGivenName  New given name for member. Must have length of at
     *     least 1, have length of at most 100, and match pattern "{@code
     *     [^/:?*<>\"|]*}".
     * @param newSurname  New surname for member. Must have length of at least
     *     1, have length of at most 100, and match pattern "{@code
     *     [^/:?*<>\"|]*}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileArg(UserSelectorArg user, String newEmail, String newExternalId, String newGivenName, String newSurname) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (newEmail != null) {
            if (newEmail.length() > 255) {
                throw new IllegalArgumentException("String 'newEmail' is longer than 255");
            }
            if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", newEmail)) {
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
            if (newGivenName.length() < 1) {
                throw new IllegalArgumentException("String 'newGivenName' is shorter than 1");
            }
            if (newGivenName.length() > 100) {
                throw new IllegalArgumentException("String 'newGivenName' is longer than 100");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", newGivenName)) {
                throw new IllegalArgumentException("String 'newGivenName' does not match pattern");
            }
        }
        this.newGivenName = newGivenName;
        if (newSurname != null) {
            if (newSurname.length() < 1) {
                throw new IllegalArgumentException("String 'newSurname' is shorter than 1");
            }
            if (newSurname.length() > 100) {
                throw new IllegalArgumentException("String 'newSurname' is longer than 100");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", newSurname)) {
                throw new IllegalArgumentException("String 'newSurname' does not match pattern");
            }
        }
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
         * @param newEmail  New email for member. Must have length of at most
         *     255 and match pattern "{@code
         *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}".
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
                if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", newEmail)) {
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
         *     at least 1, have length of at most 100, and match pattern "{@code
         *     [^/:?*<>\"|]*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withNewGivenName(String newGivenName) {
            if (newGivenName != null) {
                if (newGivenName.length() < 1) {
                    throw new IllegalArgumentException("String 'newGivenName' is shorter than 1");
                }
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
         *     least 1, have length of at most 100, and match pattern "{@code
         *     [^/:?*<>\"|]*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withNewSurname(String newSurname) {
            if (newSurname != null) {
                if (newSurname.length() < 1) {
                    throw new IllegalArgumentException("String 'newSurname' is shorter than 1");
                }
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

    static final class Serializer extends StructJsonSerializer<MembersSetProfileArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersSetProfileArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersSetProfileArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersSetProfileArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersSetProfileArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("user", value.user);
            if (value.newEmail != null) {
                g.writeObjectField("new_email", value.newEmail);
            }
            if (value.newExternalId != null) {
                g.writeObjectField("new_external_id", value.newExternalId);
            }
            if (value.newGivenName != null) {
                g.writeObjectField("new_given_name", value.newGivenName);
            }
            if (value.newSurname != null) {
                g.writeObjectField("new_surname", value.newSurname);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersSetProfileArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersSetProfileArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersSetProfileArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersSetProfileArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersSetProfileArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            UserSelectorArg user = null;
            String newEmail = null;
            String newExternalId = null;
            String newGivenName = null;
            String newSurname = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("user".equals(_field)) {
                    user = _p.readValueAs(UserSelectorArg.class);
                    _p.nextToken();
                }
                else if ("new_email".equals(_field)) {
                    newEmail = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("new_external_id".equals(_field)) {
                    newExternalId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("new_given_name".equals(_field)) {
                    newGivenName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("new_surname".equals(_field)) {
                    newSurname = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (user == null) {
                throw new JsonParseException(_p, "Required field \"user\" is missing.");
            }

            return new MembersSetProfileArg(user, newEmail, newExternalId, newGivenName, newSurname);
        }
    }
}
