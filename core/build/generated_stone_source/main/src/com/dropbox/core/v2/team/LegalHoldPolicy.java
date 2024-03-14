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
import java.util.regex.Pattern;

public class LegalHoldPolicy {
    // struct team.LegalHoldPolicy (team_legal_holds.stone)

    protected final String id;
    protected final String name;
    protected final String description;
    protected final Date activationTime;
    protected final MembersInfo members;
    protected final LegalHoldStatus status;
    protected final Date startDate;
    protected final Date endDate;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param id  The legal hold id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  Team members IDs and number of permanently deleted
     *     members under hold. Must not be {@code null}.
     * @param status  The current state of the hold. Must not be {@code null}.
     * @param startDate  Start date of the legal hold policy. Must not be {@code
     *     null}.
     * @param description  A description of the legal hold policy. Must have
     *     length of at most 501.
     * @param activationTime  The time at which the legal hold was activated.
     * @param endDate  End date of the legal hold policy.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldPolicy(String id, String name, MembersInfo members, LegalHoldStatus status, Date startDate, String description, Date activationTime, Date endDate) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (!Pattern.matches("^pid_dbhid:.+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
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
        this.activationTime = LangUtil.truncateMillis(activationTime);
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        this.members = members;
        if (status == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = status;
        if (startDate == null) {
            throw new IllegalArgumentException("Required value for 'startDate' is null");
        }
        this.startDate = LangUtil.truncateMillis(startDate);
        this.endDate = LangUtil.truncateMillis(endDate);
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param id  The legal hold id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  Team members IDs and number of permanently deleted
     *     members under hold. Must not be {@code null}.
     * @param status  The current state of the hold. Must not be {@code null}.
     * @param startDate  Start date of the legal hold policy. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldPolicy(String id, String name, MembersInfo members, LegalHoldStatus status, Date startDate) {
        this(id, name, members, status, startDate, null, null, null);
    }

    /**
     * The legal hold id.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    /**
     * Policy name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    /**
     * Team members IDs and number of permanently deleted members under hold.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public MembersInfo getMembers() {
        return members;
    }

    /**
     * The current state of the hold.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public LegalHoldStatus getStatus() {
        return status;
    }

    /**
     * Start date of the legal hold policy.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public Date getStartDate() {
        return startDate;
    }

    /**
     * A description of the legal hold policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    /**
     * The time at which the legal hold was activated.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getActivationTime() {
        return activationTime;
    }

    /**
     * End date of the legal hold policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param id  The legal hold id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  Team members IDs and number of permanently deleted
     *     members under hold. Must not be {@code null}.
     * @param status  The current state of the hold. Must not be {@code null}.
     * @param startDate  Start date of the legal hold policy. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String id, String name, MembersInfo members, LegalHoldStatus status, Date startDate) {
        return new Builder(id, name, members, status, startDate);
    }

    /**
     * Builder for {@link LegalHoldPolicy}.
     */
    public static class Builder {
        protected final String id;
        protected final String name;
        protected final MembersInfo members;
        protected final LegalHoldStatus status;
        protected final Date startDate;

        protected String description;
        protected Date activationTime;
        protected Date endDate;

        protected Builder(String id, String name, MembersInfo members, LegalHoldStatus status, Date startDate) {
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (!Pattern.matches("^pid_dbhid:.+", id)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.id = id;
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
            this.members = members;
            if (status == null) {
                throw new IllegalArgumentException("Required value for 'status' is null");
            }
            this.status = status;
            if (startDate == null) {
                throw new IllegalArgumentException("Required value for 'startDate' is null");
            }
            this.startDate = LangUtil.truncateMillis(startDate);
            this.description = null;
            this.activationTime = null;
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
         * @param activationTime  The time at which the legal hold was
         *     activated.
         *
         * @return this builder
         */
        public Builder withActivationTime(Date activationTime) {
            this.activationTime = LangUtil.truncateMillis(activationTime);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param endDate  End date of the legal hold policy.
         *
         * @return this builder
         */
        public Builder withEndDate(Date endDate) {
            this.endDate = LangUtil.truncateMillis(endDate);
            return this;
        }

        /**
         * Builds an instance of {@link LegalHoldPolicy} configured with this
         * builder's values
         *
         * @return new instance of {@link LegalHoldPolicy}
         */
        public LegalHoldPolicy build() {
            return new LegalHoldPolicy(id, name, members, status, startDate, description, activationTime, endDate);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id,
            name,
            description,
            activationTime,
            members,
            status,
            startDate,
            endDate
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
            LegalHoldPolicy other = (LegalHoldPolicy) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.members == other.members) || (this.members.equals(other.members)))
                && ((this.status == other.status) || (this.status.equals(other.status)))
                && ((this.startDate == other.startDate) || (this.startDate.equals(other.startDate)))
                && ((this.description == other.description) || (this.description != null && this.description.equals(other.description)))
                && ((this.activationTime == other.activationTime) || (this.activationTime != null && this.activationTime.equals(other.activationTime)))
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
    static class Serializer extends StructSerializer<LegalHoldPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldPolicy value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("members");
            MembersInfo.Serializer.INSTANCE.serialize(value.members, g);
            g.writeFieldName("status");
            LegalHoldStatus.Serializer.INSTANCE.serialize(value.status, g);
            g.writeFieldName("start_date");
            StoneSerializers.timestamp().serialize(value.startDate, g);
            if (value.description != null) {
                g.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.description, g);
            }
            if (value.activationTime != null) {
                g.writeFieldName("activation_time");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.activationTime, g);
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
        public LegalHoldPolicy deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldPolicy value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_name = null;
                MembersInfo f_members = null;
                LegalHoldStatus f_status = null;
                Date f_startDate = null;
                String f_description = null;
                Date f_activationTime = null;
                Date f_endDate = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("members".equals(field)) {
                        f_members = MembersInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("status".equals(field)) {
                        f_status = LegalHoldStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("activation_time".equals(field)) {
                        f_activationTime = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("end_date".equals(field)) {
                        f_endDate = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_members == null) {
                    throw new JsonParseException(p, "Required field \"members\" missing.");
                }
                if (f_status == null) {
                    throw new JsonParseException(p, "Required field \"status\" missing.");
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                value = new LegalHoldPolicy(f_id, f_name, f_members, f_status, f_startDate, f_description, f_activationTime, f_endDate);
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
