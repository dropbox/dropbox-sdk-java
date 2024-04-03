/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * User and their custom quota in GB (1 TB = 1024 GB).  No quota returns if the
 * user has no custom quota set.
 */
public class UserCustomQuotaResult {
    // struct team.UserCustomQuotaResult (team_member_space_limits.stone)

    @Nonnull
    protected final UserSelectorArg user;
    @Nullable
    protected final Long quotaGb;

    /**
     * User and their custom quota in GB (1 TB = 1024 GB).  No quota returns if
     * the user has no custom quota set.
     *
     * @param user  Must not be {@code null}.
     * @param quotaGb  Must be greater than or equal to 15.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserCustomQuotaResult(@Nonnull UserSelectorArg user, @Nullable Long quotaGb) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (quotaGb != null) {
            if (quotaGb < 15L) {
                throw new IllegalArgumentException("Number 'quotaGb' is smaller than 15L");
            }
        }
        this.quotaGb = quotaGb;
    }

    /**
     * User and their custom quota in GB (1 TB = 1024 GB).  No quota returns if
     * the user has no custom quota set.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param user  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserCustomQuotaResult(@Nonnull UserSelectorArg user) {
        this(user, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Long getQuotaGb() {
        return quotaGb;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.user,
            this.quotaGb
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
            UserCustomQuotaResult other = (UserCustomQuotaResult) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.quotaGb == other.quotaGb) || (this.quotaGb != null && this.quotaGb.equals(other.quotaGb)))
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
    static class Serializer extends StructSerializer<UserCustomQuotaResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserCustomQuotaResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            if (value.quotaGb != null) {
                g.writeFieldName("quota_gb");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(value.quotaGb, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserCustomQuotaResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserCustomQuotaResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                Long f_quotaGb = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("quota_gb".equals(field)) {
                        f_quotaGb = StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                value = new UserCustomQuotaResult(f_user, f_quotaGb);
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
