/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum SharedLinkAccessFailureReason {
    // union SharedLinkAccessFailureReason
    /**
     * User is not logged in.
     */
    LOGIN_REQUIRED,
    /**
     * User's email is not verified.
     */
    EMAIL_VERIFY_REQUIRED,
    /**
     * The link is password protected.
     */
    PASSWORD_REQUIRED,
    /**
     * Access is allowed for team members only.
     */
    TEAM_ONLY,
    /**
     * Access is allowed for the shared link's owner only.
     */
    OWNER_ONLY,
    /**
     * An unknown accessibility failure.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, SharedLinkAccessFailureReason> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharedLinkAccessFailureReason>();
        VALUES_.put("login_required", LOGIN_REQUIRED);
        VALUES_.put("email_verify_required", EMAIL_VERIFY_REQUIRED);
        VALUES_.put("password_required", PASSWORD_REQUIRED);
        VALUES_.put("team_only", TEAM_ONLY);
        VALUES_.put("owner_only", OWNER_ONLY);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedLinkAccessFailureReason fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedLinkAccessFailureReason> _JSON_WRITER = new JsonWriter<SharedLinkAccessFailureReason>() {
        public void write(SharedLinkAccessFailureReason x, JsonGenerator g) throws IOException {
            switch (x) {
                case LOGIN_REQUIRED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("login_required");
                    g.writeEndObject();
                    break;
                case EMAIL_VERIFY_REQUIRED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email_verify_required");
                    g.writeEndObject();
                    break;
                case PASSWORD_REQUIRED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("password_required");
                    g.writeEndObject();
                    break;
                case TEAM_ONLY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_only");
                    g.writeEndObject();
                    break;
                case OWNER_ONLY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("owner_only");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<SharedLinkAccessFailureReason> _JSON_READER = new JsonReader<SharedLinkAccessFailureReason>() {
        public final SharedLinkAccessFailureReason read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
