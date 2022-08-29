/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

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
import java.util.List;
import java.util.regex.Pattern;

class LegalHoldsPolicyUpdateArg {
    // struct team.LegalHoldsPolicyUpdateArg (team_legal_holds.stone)

    protected final String id;
    protected final String name;
    protected final String description;
    protected final List<String> members;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     * @param name  Policy new name. Must have length of at most 140.
     * @param description  Policy new description. Must have length of at most
     *     501.
     * @param members  List of team member IDs to apply the policy on. Must not
     *     contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsPolicyUpdateArg(String id, String name, String description, List<String> members) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
        if (name != null) {
            if (name.length() > 140) {
                throw new IllegalArgumentException("String 'name' is longer than 140");
            }
        }
        this.name = name;
        if (description != null) {
            if (description.length() > 501) {
                throw new IllegalArgumentException("String 'description' is longer than 501");
            }
        }
        this.description = description;
        if (members != null) {
            for (String x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
        }
        this.members = members;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsPolicyUpdateArg(String id) {
        this(id, null, null, null);
    }

    /**
     * The legal hold Id.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * Policy new name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getName() {
        return name;
    }

    /**
     * Policy new description.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getDescription() {
        return description;
    }

    /**
     * List of team member IDs to apply the policy on.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String id) {
        return new Builder(id);
    }

    /**
     * Builder for {@link LegalHoldsPolicyUpdateArg}.
     */
    public static class Builder {
        protected final String id;

        protected String name;
        protected String description;
        protected List<String> members;

        protected Builder(String id) {
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (!Pattern.matches("^pid_dbhid:.+", id)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.id = id;
            this.name = null;
            this.description = null;
            this.members = null;
        }

        /**
         * Set value for optional field.
         *
         * @param name  Policy new name. Must have length of at most 140.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withName(String name) {
            if (name != null) {
                if (name.length() > 140) {
                    throw new IllegalArgumentException("String 'name' is longer than 140");
                }
            }
            this.name = name;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param description  Policy new description. Must have length of at
         *     most 501.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withDescription(String description) {
            if (description != null) {
                if (description.length() > 501) {
                    throw new IllegalArgumentException("String 'description' is longer than 501");
                }
            }
            this.description = description;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param members  List of team member IDs to apply the policy on. Must
         *     not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMembers(List<String> members) {
            if (members != null) {
                for (String x : members) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'members' is null");
                    }
                }
            }
            this.members = members;
            return this;
        }

        /**
         * Builds an instance of {@link LegalHoldsPolicyUpdateArg} configured
         * with this builder's values
         *
         * @return new instance of {@link LegalHoldsPolicyUpdateArg}
         */
        public LegalHoldsPolicyUpdateArg build() {
            return new LegalHoldsPolicyUpdateArg(id, name, description, members);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id,
            name,
            description,
            members
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
            LegalHoldsPolicyUpdateArg other = (LegalHoldsPolicyUpdateArg) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.name == other.name) || (this.name != null && this.name.equals(other.name)))
                && ((this.description == other.description) || (this.description != null && this.description.equals(other.description)))
                && ((this.members == other.members) || (this.members != null && this.members.equals(other.members)))
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
    static class Serializer extends StructSerializer<LegalHoldsPolicyUpdateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsPolicyUpdateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (value.name != null) {
                g.writeFieldName("name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.name, g);
            }
            if (value.description != null) {
                g.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.description, g);
            }
            if (value.members != null) {
                g.writeFieldName("members");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.members, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsPolicyUpdateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsPolicyUpdateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_name = null;
                String f_description = null;
                List<String> f_members = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("members".equals(field)) {
                        f_members = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                value = new LegalHoldsPolicyUpdateArg(f_id, f_name, f_description, f_members);
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
