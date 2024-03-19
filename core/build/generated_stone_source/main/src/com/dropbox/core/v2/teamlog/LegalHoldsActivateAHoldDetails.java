/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Activated a hold.
 */
public class LegalHoldsActivateAHoldDetails {
    // struct team_log.LegalHoldsActivateAHoldDetails (team_log_generated.stone)

    @Nonnull
    protected final String legalHoldId;
    @Nonnull
    protected final String name;
    @Nonnull
    protected final Date startDate;
    @Nullable
    protected final Date endDate;

    /**
     * Activated a hold.
     *
     * @param legalHoldId  Hold ID. Must not be {@code null}.
     * @param name  Hold name. Must not be {@code null}.
     * @param startDate  Hold start date. Must not be {@code null}.
     * @param endDate  Hold end date.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsActivateAHoldDetails(@Nonnull String legalHoldId, @Nonnull String name, @Nonnull Date startDate, @Nullable Date endDate) {
        if (legalHoldId == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = legalHoldId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (startDate == null) {
            throw new IllegalArgumentException("Required value for 'startDate' is null");
        }
        this.startDate = LangUtil.truncateMillis(startDate);
        this.endDate = LangUtil.truncateMillis(endDate);
    }

    /**
     * Activated a hold.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param legalHoldId  Hold ID. Must not be {@code null}.
     * @param name  Hold name. Must not be {@code null}.
     * @param startDate  Hold start date. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsActivateAHoldDetails(@Nonnull String legalHoldId, @Nonnull String name, @Nonnull Date startDate) {
        this(legalHoldId, name, startDate, null);
    }

    /**
     * Hold ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getLegalHoldId() {
        return legalHoldId;
    }

    /**
     * Hold name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Hold start date.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Hold end date.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            legalHoldId,
            name,
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
            LegalHoldsActivateAHoldDetails other = (LegalHoldsActivateAHoldDetails) obj;
            return ((this.legalHoldId == other.legalHoldId) || (this.legalHoldId.equals(other.legalHoldId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.startDate == other.startDate) || (this.startDate.equals(other.startDate)))
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
    static class Serializer extends StructSerializer<LegalHoldsActivateAHoldDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsActivateAHoldDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(value.legalHoldId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("start_date");
            StoneSerializers.timestamp().serialize(value.startDate, g);
            if (value.endDate != null) {
                g.writeFieldName("end_date");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.endDate, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsActivateAHoldDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsActivateAHoldDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_legalHoldId = null;
                String f_name = null;
                Date f_startDate = null;
                Date f_endDate = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("legal_hold_id".equals(field)) {
                        f_legalHoldId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("start_date".equals(field)) {
                        f_startDate = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("end_date".equals(field)) {
                        f_endDate = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_legalHoldId == null) {
                    throw new JsonParseException(p, "Required field \"legal_hold_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_startDate == null) {
                    throw new JsonParseException(p, "Required field \"start_date\" missing.");
                }
                value = new LegalHoldsActivateAHoldDetails(f_legalHoldId, f_name, f_startDate, f_endDate);
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
