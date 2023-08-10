/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * There was an error deleting all closed file requests.
 */
public enum DeleteAllClosedFileRequestsError {
    // union file_requests.DeleteAllClosedFileRequestsError (file_requests.stone)
    /**
     * This user's Dropbox Business team doesn't allow file requests.
     */
    DISABLED_FOR_TEAM,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER,
    /**
     * This file request ID was not found.
     */
    NOT_FOUND,
    /**
     * The specified path is not a folder.
     */
    NOT_A_FOLDER,
    /**
     * This file request is not accessible to this app. Apps with the app folder
     * permission can only access file requests in their app folder.
     */
    APP_LACKS_ACCESS,
    /**
     * This user doesn't have permission to access or modify this file request.
     */
    NO_PERMISSION,
    /**
     * This user's email address is not verified. File requests are only
     * available on accounts with a verified email address. Users can verify
     * their email address <a href="https://www.dropbox.com/help/317">here</a>.
     */
    EMAIL_UNVERIFIED,
    /**
     * There was an error validating the request. For example, the title was
     * invalid, or there were disallowed characters in the destination path.
     */
    VALIDATION_ERROR;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<DeleteAllClosedFileRequestsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteAllClosedFileRequestsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DISABLED_FOR_TEAM: {
                    g.writeString("disabled_for_team");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case NOT_FOUND: {
                    g.writeString("not_found");
                    break;
                }
                case NOT_A_FOLDER: {
                    g.writeString("not_a_folder");
                    break;
                }
                case APP_LACKS_ACCESS: {
                    g.writeString("app_lacks_access");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                case EMAIL_UNVERIFIED: {
                    g.writeString("email_unverified");
                    break;
                }
                case VALIDATION_ERROR: {
                    g.writeString("validation_error");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public DeleteAllClosedFileRequestsError deserialize(JsonParser p) throws IOException, JsonParseException {
            DeleteAllClosedFileRequestsError value;
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
            else if ("disabled_for_team".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.DISABLED_FOR_TEAM;
            }
            else if ("other".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.OTHER;
            }
            else if ("not_found".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.NOT_FOUND;
            }
            else if ("not_a_folder".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.NOT_A_FOLDER;
            }
            else if ("app_lacks_access".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.APP_LACKS_ACCESS;
            }
            else if ("no_permission".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.NO_PERMISSION;
            }
            else if ("email_unverified".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.EMAIL_UNVERIFIED;
            }
            else if ("validation_error".equals(tag)) {
                value = DeleteAllClosedFileRequestsError.VALIDATION_ERROR;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
