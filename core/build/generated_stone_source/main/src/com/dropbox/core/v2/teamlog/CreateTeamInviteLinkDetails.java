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

/**
 * Created team invite link.
 */
public class CreateTeamInviteLinkDetails {
    // struct team_log.CreateTeamInviteLinkDetails (team_log_generated.stone)

    @Nonnull
    protected final String linkUrl;
    @Nonnull
    protected final String expiryDate;

    /**
     * Created team invite link.
     *
     * @param linkUrl  The invite link url that was created. Must not be {@code
     *     null}.
     * @param expiryDate  The expiration date of the invite link. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateTeamInviteLinkDetails(@Nonnull String linkUrl, @Nonnull String expiryDate) {
        if (linkUrl == null) {
            throw new IllegalArgumentException("Required value for 'linkUrl' is null");
        }
        this.linkUrl = linkUrl;
        if (expiryDate == null) {
            throw new IllegalArgumentException("Required value for 'expiryDate' is null");
        }
        this.expiryDate = expiryDate;
    }

    /**
     * The invite link url that was created.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * The expiration date of the invite link.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            linkUrl,
            expiryDate
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
            CreateTeamInviteLinkDetails other = (CreateTeamInviteLinkDetails) obj;
            return ((this.linkUrl == other.linkUrl) || (this.linkUrl.equals(other.linkUrl)))
                && ((this.expiryDate == other.expiryDate) || (this.expiryDate.equals(other.expiryDate)))
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
    static class Serializer extends StructSerializer<CreateTeamInviteLinkDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CreateTeamInviteLinkDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("link_url");
            StoneSerializers.string().serialize(value.linkUrl, g);
            g.writeFieldName("expiry_date");
            StoneSerializers.string().serialize(value.expiryDate, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CreateTeamInviteLinkDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CreateTeamInviteLinkDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_linkUrl = null;
                String f_expiryDate = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("link_url".equals(field)) {
                        f_linkUrl = StoneSerializers.string().deserialize(p);
                    }
                    else if ("expiry_date".equals(field)) {
                        f_expiryDate = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_linkUrl == null) {
                    throw new JsonParseException(p, "Required field \"link_url\" missing.");
                }
                if (f_expiryDate == null) {
                    throw new JsonParseException(p, "Required field \"expiry_date\" missing.");
                }
                value = new CreateTeamInviteLinkDetails(f_linkUrl, f_expiryDate);
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
