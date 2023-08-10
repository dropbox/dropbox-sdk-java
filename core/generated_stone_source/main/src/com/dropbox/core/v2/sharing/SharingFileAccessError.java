/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * User could not access this file.
 */
public enum SharingFileAccessError {
    // union sharing.SharingFileAccessError (sharing_files.stone)
    /**
     * Current user does not have sufficient privileges to perform the desired
     * action.
     */
    NO_PERMISSION,
    /**
     * File specified was not found.
     */
    INVALID_FILE,
    /**
     * A folder can't be shared this way. Use folder sharing or a shared link
     * instead.
     */
    IS_FOLDER,
    /**
     * A file inside a public folder can't be shared this way. Use a public link
     * instead.
     */
    INSIDE_PUBLIC_FOLDER,
    /**
     * A Mac OS X package can't be shared this way. Use a shared link instead.
     */
    INSIDE_OSX_PACKAGE,
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
    static class Serializer extends UnionSerializer<SharingFileAccessError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingFileAccessError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                case INVALID_FILE: {
                    g.writeString("invalid_file");
                    break;
                }
                case IS_FOLDER: {
                    g.writeString("is_folder");
                    break;
                }
                case INSIDE_PUBLIC_FOLDER: {
                    g.writeString("inside_public_folder");
                    break;
                }
                case INSIDE_OSX_PACKAGE: {
                    g.writeString("inside_osx_package");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharingFileAccessError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharingFileAccessError value;
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
            else if ("no_permission".equals(tag)) {
                value = SharingFileAccessError.NO_PERMISSION;
            }
            else if ("invalid_file".equals(tag)) {
                value = SharingFileAccessError.INVALID_FILE;
            }
            else if ("is_folder".equals(tag)) {
                value = SharingFileAccessError.IS_FOLDER;
            }
            else if ("inside_public_folder".equals(tag)) {
                value = SharingFileAccessError.INSIDE_PUBLIC_FOLDER;
            }
            else if ("inside_osx_package".equals(tag)) {
                value = SharingFileAccessError.INSIDE_OSX_PACKAGE;
            }
            else {
                value = SharingFileAccessError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
