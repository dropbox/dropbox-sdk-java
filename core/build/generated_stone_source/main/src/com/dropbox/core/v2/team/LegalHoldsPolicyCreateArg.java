/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class LegalHoldsPolicyCreateArg {
    // struct team.LegalHoldsPolicyCreateArg (team_legal_holds.stone)

    @Nonnull
    protected final String name;
    @Nullable
    protected final String description;
    @Nonnull
    protected final List<String> members;
    @Nullable
    protected final Date startDate;
    @Nullable
    protected final Date endDate;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  List of team member IDs added to the hold. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param description  A description of the legal hold policy. Must have
     *     length of at most 501.
     * @param startDate  start date of the legal hold policy.
     * @param endDate  end date of the legal hold policy.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsPolicyCreateArg(@Nonnull String name, @Nonnull List<String> members, @Nullable String description, @Nullable Date startDate, @Nullable Date endDate) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        if (name.length() > 140) {
            throw new IllegalArgumentException("String 'name' is longer than 140");
        }
        this.name = name;
        if (description != null) {
            if (description.length() > 501) {
                throw new IllegalArgumentException("String 'description' is longer than 501");
            }
        }
        this.description = description;
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (String x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        this.startDate = LangUtil.truncateMillis(startDate);
        this.endDate = LangUtil.truncateMillis(endDate);
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  List of team member IDs added to the hold. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsPolicyCreateArg(@Nonnull String name, @Nonnull List<String> members) {
        this(name, members, null, null, null);
    }

    /**
     * Policy name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * List of team member IDs added to the hold.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getMembers() {
        return members;
    }

    /**
     * A description of the legal hold policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     * start date of the legal hold policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getStartDate() {
        return startDate;
    }

    /**
     * end date of the legal hold policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  List of team member IDs added to the hold. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, List<String> members) {
        return new Builder(name, members);
    }

    /**
     * Builder for {@link LegalHoldsPolicyCreateArg}.
     */
    public static class Builder {
        protected final String name;
        protected final List<String> members;

        protected String description;
        protected Date startDate;
        protected Date endDate;

        protected Builder(String name, List<String> members) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            if (name.length() > 140) {
                throw new IllegalArgumentException("String 'name' is longer than 140");
            }
            this.name = name;
            if (members == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            for (String x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = members;
            this.description = null;
            this.startDate = null;
            this.endDate = null;
        }

        /**
         * Set value for optional field.
         *
         * @param description  A description of the legal hold policy. Must have
         *     length of at most 501.
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
         * @param startDate  start date of the legal hold policy.
         *
         * @return this builder
         */
        public Builder withStartDate(Date startDate) {
            this.startDate = LangUtil.truncateMillis(startDate);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param endDate  end date of the legal hold policy.
         *
         * @return this builder
         */
        public Builder withEndDate(Date endDate) {
            this.endDate = LangUtil.truncateMillis(endDate);
            return this;
        }

        /**
         * Builds an instance of {@link LegalHoldsPolicyCreateArg} configured
         * with this builder's values
         *
         * @return new instance of {@link LegalHoldsPolicyCreateArg}
         */
        public LegalHoldsPolicyCreateArg build() {
            return new LegalHoldsPolicyCreateArg(name, members, description, startDate, endDate);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.name,
            this.description,
            this.members,
            this.startDate,
            this.endDate
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
            LegalHoldsPolicyCreateArg other = (LegalHoldsPolicyCreateArg) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.members == other.members) || (this.members.equals(other.members)))
                && ((this.description == other.description) || (this.description != null && this.description.equals(other.description)))
                && ((this.startDate == other.startDate) || (this.startDate != null && this.startDate.equals(other.startDate)))
                && ((this.endDate == other.endDate) || (this.endDate != null && this.endDate.equals(other.endDate)))
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
    static class Serializer extends StructSerializer<LegalHoldsPolicyCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsPolicyCreateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("members");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.members, g);
            if (value.description != null) {
                g.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.description, g);
            }
            if (value.startDate != null) {
                g.writeFieldName("start_date");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.startDate, g);
            }
            if (value.endDate != null) {
                g.writeFieldName("end_date");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.endDate, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsPolicyCreateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsPolicyCreateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                List<String> f_members = null;
                String f_description = null;
                Date f_startDate = null;
                Date f_endDate = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("members".equals(field)) {
                        f_members = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("end_date".equals(field)) {
                        f_endDate = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_members == null) {
                    throw new JsonParseException(p, "Required field \"members\" missing.");
                }
                value = new LegalHoldsPolicyCreateArg(f_name, f_members, f_description, f_startDate, f_endDate);
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
