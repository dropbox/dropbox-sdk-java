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
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Added members as audience of shared link.
 */
public class SharedLinkShareDetails {
    // struct team_log.SharedLinkShareDetails (team_log_generated.stone)

    protected final UserLogInfo sharedLinkOwner;
    protected final List<ExternalUserLogInfo> externalUsers;

    /**
     * Added members as audience of shared link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sharedLinkOwner  Shared link owner details. Might be missing due
     *     to historical data gap.
     * @param externalUsers  Users without a Dropbox account that were added as
     *     shared link audience. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkShareDetails(@Nullable UserLogInfo sharedLinkOwner, @Nullable List<ExternalUserLogInfo> externalUsers) {
        this.sharedLinkOwner = sharedLinkOwner;
        if (externalUsers != null) {
            for (ExternalUserLogInfo x : externalUsers) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'externalUsers' is null");
                }
            }
        }
        this.externalUsers = externalUsers;
    }

    /**
     * Added members as audience of shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedLinkShareDetails() {
        this(null, null);
    }

    /**
     * Shared link owner details. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public UserLogInfo getSharedLinkOwner() {
        return sharedLinkOwner;
    }

    /**
     * Users without a Dropbox account that were added as shared link audience.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<ExternalUserLogInfo> getExternalUsers() {
        return externalUsers;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link SharedLinkShareDetails}.
     */
    public static class Builder {

        protected UserLogInfo sharedLinkOwner;
        protected List<ExternalUserLogInfo> externalUsers;

        protected Builder() {
            this.sharedLinkOwner = null;
            this.externalUsers = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedLinkOwner  Shared link owner details. Might be missing
         *     due to historical data gap.
         *
         * @return this builder
         */
        public Builder withSharedLinkOwner(UserLogInfo sharedLinkOwner) {
            this.sharedLinkOwner = sharedLinkOwner;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param externalUsers  Users without a Dropbox account that were added
         *     as shared link audience. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withExternalUsers(List<ExternalUserLogInfo> externalUsers) {
            if (externalUsers != null) {
                for (ExternalUserLogInfo x : externalUsers) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'externalUsers' is null");
                    }
                }
            }
            this.externalUsers = externalUsers;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkShareDetails} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedLinkShareDetails}
         */
        public SharedLinkShareDetails build() {
            return new SharedLinkShareDetails(sharedLinkOwner, externalUsers);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedLinkOwner,
            externalUsers
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
            SharedLinkShareDetails other = (SharedLinkShareDetails) obj;
            return ((this.sharedLinkOwner == other.sharedLinkOwner) || (this.sharedLinkOwner != null && this.sharedLinkOwner.equals(other.sharedLinkOwner)))
                && ((this.externalUsers == other.externalUsers) || (this.externalUsers != null && this.externalUsers.equals(other.externalUsers)))
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
    static class Serializer extends StructSerializer<SharedLinkShareDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkShareDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sharedLinkOwner != null) {
                g.writeFieldName("shared_link_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(value.sharedLinkOwner, g);
            }
            if (value.externalUsers != null) {
                g.writeFieldName("external_users");
                StoneSerializers.nullable(StoneSerializers.list(ExternalUserLogInfo.Serializer.INSTANCE)).serialize(value.externalUsers, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkShareDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkShareDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserLogInfo f_sharedLinkOwner = null;
                List<ExternalUserLogInfo> f_externalUsers = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_link_owner".equals(field)) {
                        f_sharedLinkOwner = StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("external_users".equals(field)) {
                        f_externalUsers = StoneSerializers.nullable(StoneSerializers.list(ExternalUserLogInfo.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedLinkShareDetails(f_sharedLinkOwner, f_externalUsers);
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
