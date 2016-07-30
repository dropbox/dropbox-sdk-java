/* DO NOT EDIT */
/* This file was generated from team_policies.stone */

package com.dropbox.core.v2.teampolicies;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Policy governing the visibility of newly created shared links.
 */
public enum SharedLinkCreatePolicy {
    // union SharedLinkCreatePolicy
    /**
     * By default, anyone can access newly created shared links. No login will
     * be required to access the shared links unless overridden.
     */
    DEFAULT_PUBLIC,
    /**
     * By default, only members of the same team can access newly created shared
     * links. Login will be required to access the shared links unless
     * overridden.
     */
    DEFAULT_TEAM_ONLY,
    /**
     * Only members of the same team can access newly created shared links.
     * Login will be required to access the shared links.
     */
    TEAM_ONLY,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    public static final class Serializer extends UnionSerializer<SharedLinkCreatePolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkCreatePolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DEFAULT_PUBLIC: {
                    g.writeString("default_public");
                    break;
                }
                case DEFAULT_TEAM_ONLY: {
                    g.writeString("default_team_only");
                    break;
                }
                case TEAM_ONLY: {
                    g.writeString("team_only");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedLinkCreatePolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedLinkCreatePolicy value;
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
            else if ("default_public".equals(tag)) {
                value = SharedLinkCreatePolicy.DEFAULT_PUBLIC;
            }
            else if ("default_team_only".equals(tag)) {
                value = SharedLinkCreatePolicy.DEFAULT_TEAM_ONLY;
            }
            else if ("team_only".equals(tag)) {
                value = SharedLinkCreatePolicy.TEAM_ONLY;
            }
            else {
                value = SharedLinkCreatePolicy.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
