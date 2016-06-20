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
import java.util.List;

/**
 * Arguments for {@link DbxUserSharingRequests#listFileMembersBatch(List)}.
 */
class ListFileMembersBatchArg {
    // struct ListFileMembersBatchArg

    protected final List<String> files;
    protected final long limit;

    /**
     * Arguments for {@link DbxUserSharingRequests#listFileMembersBatch(List)}.
     *
     * @param files  Files for which to return members. Must contain at most 100
     *     items, not contain a {@code null} item, and not be {@code null}.
     * @param limit  Number of members to return max per query. Defaults to 10
     *     if no limit is specified. Must be less than or equal to 20.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersBatchArg(List<String> files, long limit) {
        if (files == null) {
            throw new IllegalArgumentException("Required value for 'files' is null");
        }
        if (files.size() > 100) {
            throw new IllegalArgumentException("List 'files' has more than 100 items");
        }
        for (String x : files) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'files' is null");
            }
            if (x.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'files' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*|nspath:[^:]*:[^:]*)", x)) {
                throw new IllegalArgumentException("Stringan item in list 'files' does not match pattern");
            }
        }
        this.files = files;
        if (limit > 20L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 20L");
        }
        this.limit = limit;
    }

    /**
     * Arguments for {@link DbxUserSharingRequests#listFileMembersBatch(List)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param files  Files for which to return members. Must contain at most 100
     *     items, not contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersBatchArg(List<String> files) {
        this(files, 10L);
    }

    /**
     * Files for which to return members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<String> getFiles() {
        return files;
    }

    /**
     * Number of members to return max per query. Defaults to 10 if no limit is
     * specified.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     10L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            files,
            limit
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
            ListFileMembersBatchArg other = (ListFileMembersBatchArg) obj;
            return ((this.files == other.files) || (this.files.equals(other.files)))
                && (this.limit == other.limit)
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
    static final class Serializer extends StructSerializer<ListFileMembersBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileMembersBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("files");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.files, g);
            g.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFileMembersBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileMembersBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_files = null;
                Long f_limit = 10L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("files".equals(field)) {
                        f_files = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_files == null) {
                    throw new JsonParseException(p, "Required field \"files\" missing.");
                }
                value = new ListFileMembersBatchArg(f_files, f_limit);
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
