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

/**
 * Resolved file comment.
 */
public class FileResolveCommentDetails {
    // struct team_log.FileResolveCommentDetails (team_log_generated.stone)

    protected final String commentText;

    /**
     * Resolved file comment.
     *
     * @param commentText  Comment text.
     */
    public FileResolveCommentDetails(String commentText) {
        this.commentText = commentText;
    }

    /**
     * Resolved file comment.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public FileResolveCommentDetails() {
        this(null);
    }

    /**
     * Comment text.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCommentText() {
        return commentText;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            commentText
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
            FileResolveCommentDetails other = (FileResolveCommentDetails) obj;
            return (this.commentText == other.commentText) || (this.commentText != null && this.commentText.equals(other.commentText));
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
    static class Serializer extends StructSerializer<FileResolveCommentDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileResolveCommentDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.commentText != null) {
                g.writeFieldName("comment_text");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.commentText, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileResolveCommentDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileResolveCommentDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_commentText = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("comment_text".equals(field)) {
                        f_commentText = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new FileResolveCommentDetails(f_commentText);
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
