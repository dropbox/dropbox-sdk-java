/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

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

/**
 * Result for {@link DbxUserFileRequestsRequests#listV2(long)} and {@link
 * DbxUserFileRequestsRequests#listContinue(String)}.
 */
public class ListFileRequestsV2Result {
    // struct file_requests.ListFileRequestsV2Result (file_requests.stone)

    @Nonnull
    protected final List<FileRequest> fileRequests;
    @Nonnull
    protected final String cursor;
    protected final boolean hasMore;

    /**
     * Result for {@link DbxUserFileRequestsRequests#listV2(long)} and {@link
     * DbxUserFileRequestsRequests#listContinue(String)}.
     *
     * @param fileRequests  The file requests owned by this user. Apps with the
     *     app folder permission will only see file requests in their app
     *     folder. Must not contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserFileRequestsRequests#listContinue(String)} to obtain
     *     additional file requests. Must not be {@code null}.
     * @param hasMore  Is true if there are additional file requests that have
     *     not been returned yet. An additional call to :route:list/continue`
     *     can retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileRequestsV2Result(@Nonnull List<FileRequest> fileRequests, @Nonnull String cursor, boolean hasMore) {
        if (fileRequests == null) {
            throw new IllegalArgumentException("Required value for 'fileRequests' is null");
        }
        for (FileRequest x : fileRequests) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'fileRequests' is null");
            }
        }
        this.fileRequests = fileRequests;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * The file requests owned by this user. Apps with the app folder permission
     * will only see file requests in their app folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<FileRequest> getFileRequests() {
        return fileRequests;
    }

    /**
     * Pass the cursor into {@link
     * DbxUserFileRequestsRequests#listContinue(String)} to obtain additional
     * file requests.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there are additional file requests that have not been returned
     * yet. An additional call to :route:list/continue` can retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.fileRequests,
            this.cursor,
            this.hasMore
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
            ListFileRequestsV2Result other = (ListFileRequestsV2Result) obj;
            return ((this.fileRequests == other.fileRequests) || (this.fileRequests.equals(other.fileRequests)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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
    static class Serializer extends StructSerializer<ListFileRequestsV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileRequestsV2Result value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file_requests");
            StoneSerializers.list(FileRequest.Serializer.INSTANCE).serialize(value.fileRequests, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFileRequestsV2Result deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileRequestsV2Result value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<FileRequest> f_fileRequests = null;
                String f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file_requests".equals(field)) {
                        f_fileRequests = StoneSerializers.list(FileRequest.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_fileRequests == null) {
                    throw new JsonParseException(p, "Required field \"file_requests\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ListFileRequestsV2Result(f_fileRequests, f_cursor, f_hasMore);
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
