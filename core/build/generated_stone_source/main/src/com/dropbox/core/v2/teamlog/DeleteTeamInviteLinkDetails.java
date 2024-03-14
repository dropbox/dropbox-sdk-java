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
 * Deleted team invite link.
 */
public class DeleteTeamInviteLinkDetails {
    // struct team_log.DeleteTeamInviteLinkDetails (team_log_generated.stone)

    protected final String linkUrl;

    /**
     * Deleted team invite link.
     *
     * @param linkUrl  The invite link url that was deleted. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteTeamInviteLinkDetails(@Nonnull String linkUrl) {
        if (linkUrl == null) {
            throw new IllegalArgumentException("Required value for 'linkUrl' is null");
        }
        this.linkUrl = linkUrl;
    }

    /**
     * The invite link url that was deleted.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getLinkUrl() {
        return linkUrl;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            linkUrl
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
            DeleteTeamInviteLinkDetails other = (DeleteTeamInviteLinkDetails) obj;
            return (this.linkUrl == other.linkUrl) || (this.linkUrl.equals(other.linkUrl));
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
    static class Serializer extends StructSerializer<DeleteTeamInviteLinkDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteTeamInviteLinkDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("link_url");
            StoneSerializers.string().serialize(value.linkUrl, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeleteTeamInviteLinkDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeleteTeamInviteLinkDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_linkUrl = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("link_url".equals(field)) {
                        f_linkUrl = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_linkUrl == null) {
                    throw new JsonParseException(p, "Required field \"link_url\" missing.");
                }
                value = new DeleteTeamInviteLinkDetails(f_linkUrl);
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
