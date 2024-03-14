/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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
import javax.annotation.Nullable;

public class ListFolderLongpollResult {
    // struct files.ListFolderLongpollResult (files.stone)

    protected final boolean changes;
    protected final Long backoff;

    /**
     *
     * @param changes  Indicates whether new changes are available. If true,
     *     call {@link DbxUserFilesRequests#listFolderContinue(String)} to
     *     retrieve the changes.
     * @param backoff  If present, backoff for at least this many seconds before
     *     calling {@link DbxUserFilesRequests#listFolderLongpoll(String,long)}
     *     again.
     */
    public ListFolderLongpollResult(boolean changes, @Nullable Long backoff) {
        this.changes = changes;
        this.backoff = backoff;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param changes  Indicates whether new changes are available. If true,
     *     call {@link DbxUserFilesRequests#listFolderContinue(String)} to
     *     retrieve the changes.
     */
    public ListFolderLongpollResult(boolean changes) {
        this(changes, null);
    }

    /**
     * Indicates whether new changes are available. If true, call {@link
     * DbxUserFilesRequests#listFolderContinue(String)} to retrieve the changes.
     *
     * @return value for this field.
     */
    public boolean getChanges() {
        return changes;
    }

    /**
     * If present, backoff for at least this many seconds before calling {@link
     * DbxUserFilesRequests#listFolderLongpoll(String,long)} again.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Long getBackoff() {
        return backoff;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            changes,
            backoff
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
            ListFolderLongpollResult other = (ListFolderLongpollResult) obj;
            return (this.changes == other.changes)
                && ((this.backoff == other.backoff) || (this.backoff != null && this.backoff.equals(other.backoff)))
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
    static class Serializer extends StructSerializer<ListFolderLongpollResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderLongpollResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("changes");
            StoneSerializers.boolean_().serialize(value.changes, g);
            if (value.backoff != null) {
                g.writeFieldName("backoff");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.backoff, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFolderLongpollResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFolderLongpollResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_changes = null;
                Long f_backoff = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("changes".equals(field)) {
                        f_changes = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("backoff".equals(field)) {
                        f_backoff = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_changes == null) {
                    throw new JsonParseException(p, "Required field \"changes\" missing.");
                }
                value = new ListFolderLongpollResult(f_changes, f_backoff);
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
