/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * The access permission that can be requested by the caller for the shared
 * link. Note that the final resolved visibility of the shared link takes into
 * account other aspects, such as team and shared folder settings. Check the
 * {@link ResolvedVisibility} for more info on the possible resolved visibility
 * values of shared links.
 */
public enum RequestedVisibility {
    // union RequestedVisibility
    /**
     * Anyone who has received the link can access it. No login required.
     */
    PUBLIC,
    /**
     * Only members of the same team can access the link. Login is required.
     */
    TEAM_ONLY,
    /**
     * A link-specific password is required to access the link. Login is not
     * required.
     */
    PASSWORD;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<RequestedVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RequestedVisibility value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PUBLIC: {
                    g.writeString("public");
                    break;
                }
                case TEAM_ONLY: {
                    g.writeString("team_only");
                    break;
                }
                case PASSWORD: {
                    g.writeString("password");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public RequestedVisibility deserialize(JsonParser p) throws IOException, JsonParseException {
            RequestedVisibility value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("public".equals(tag)) {
                value = RequestedVisibility.PUBLIC;
            }
            else if ("team_only".equals(tag)) {
                value = RequestedVisibility.TEAM_ONLY;
            }
            else if ("password".equals(tag)) {
                value = RequestedVisibility.PASSWORD;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
