/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Deleted group.
 */
public class GroupDeleteDetails {
    // struct team_log.GroupDeleteDetails (team_log_generated.stone)

    @Nullable
    protected final Boolean isCompanyManaged;

    /**
     * Deleted group.
     *
     * @param isCompanyManaged  Is company managed group.
     */
    public GroupDeleteDetails(@Nullable Boolean isCompanyManaged) {
        this.isCompanyManaged = isCompanyManaged;
    }

    /**
     * Deleted group.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public GroupDeleteDetails() {
        this(null);
    }

    /**
     * Is company managed group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsCompanyManaged() {
        return isCompanyManaged;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            isCompanyManaged
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
            GroupDeleteDetails other = (GroupDeleteDetails) obj;
            return (this.isCompanyManaged == other.isCompanyManaged) || (this.isCompanyManaged != null && this.isCompanyManaged.equals(other.isCompanyManaged));
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
    static class Serializer extends StructSerializer<GroupDeleteDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupDeleteDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.isCompanyManaged != null) {
                g.writeFieldName("is_company_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isCompanyManaged, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupDeleteDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupDeleteDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isCompanyManaged = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_company_managed".equals(field)) {
                        f_isCompanyManaged = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new GroupDeleteDetails(f_isCompanyManaged);
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
