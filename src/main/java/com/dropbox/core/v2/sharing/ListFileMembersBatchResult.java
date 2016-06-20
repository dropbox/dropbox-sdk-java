/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Per-file result for {@link
 * DbxUserSharingRequests#listFileMembersBatch(java.util.List)}.
 */
public class ListFileMembersBatchResult {
    // struct ListFileMembersBatchResult

    protected final String file;
    protected final ListFileMembersIndividualResult result;

    /**
     * Per-file result for {@link
     * DbxUserSharingRequests#listFileMembersBatch(java.util.List)}.
     *
     * @param file  This is the input file identifier, whether an ID or a path.
     *     Must have length of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[^:]*:[^:]*)}", and not be {@code null}.
     * @param result  The result for this particular file. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersBatchResult(String file, ListFileMembersIndividualResult result) {
        if (file == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (file.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*|nspath:[^:]*:[^:]*)", file)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = file;
        if (result == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = result;
    }

    /**
     * This is the input file identifier, whether an ID or a path.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFile() {
        return file;
    }

    /**
     * The result for this particular file
     *
     * @return value for this field, never {@code null}.
     */
    public ListFileMembersIndividualResult getResult() {
        return result;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            file,
            result
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ListFileMembersBatchResult other = (ListFileMembersBatchResult) obj;
            return ((this.file == other.file) || (this.file.equals(other.file)))
                && ((this.result == other.result) || (this.result.equals(other.result)))
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
    static final class Serializer extends StructSerializer<ListFileMembersBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileMembersBatchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file");
            StoneSerializers.string().serialize(value.file, g);
            g.writeFieldName("result");
            ListFileMembersIndividualResult.Serializer.INSTANCE.serialize(value.result, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFileMembersBatchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileMembersBatchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_file = null;
                ListFileMembersIndividualResult f_result = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file".equals(field)) {
                        f_file = StoneSerializers.string().deserialize(p);
                    }
                    else if ("result".equals(field)) {
                        f_result = ListFileMembersIndividualResult.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_file == null) {
                    throw new JsonParseException(p, "Required field \"file\" missing.");
                }
                if (f_result == null) {
                    throw new JsonParseException(p, "Required field \"result\" missing.");
                }
                value = new ListFileMembersBatchResult(f_file, f_result);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
