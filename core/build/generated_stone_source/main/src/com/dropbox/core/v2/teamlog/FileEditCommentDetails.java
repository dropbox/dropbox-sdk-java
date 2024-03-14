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
 * Edited file comment.
 */
public class FileEditCommentDetails {
    // struct team_log.FileEditCommentDetails (team_log_generated.stone)

    protected final String commentText;
    protected final String previousCommentText;

    /**
     * Edited file comment.
     *
     * @param previousCommentText  Previous comment text. Must not be {@code
     *     null}.
     * @param commentText  Comment text.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileEditCommentDetails(@javax.annotation.Nonnull String previousCommentText, @javax.annotation.Nullable String commentText) {
        this.commentText = commentText;
        if (previousCommentText == null) {
            throw new IllegalArgumentException("Required value for 'previousCommentText' is null");
        }
        this.previousCommentText = previousCommentText;
    }

    /**
     * Edited file comment.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param previousCommentText  Previous comment text. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileEditCommentDetails(String previousCommentText) {
        this(previousCommentText, null);
    }

    /**
     * Previous comment text.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPreviousCommentText() {
        return previousCommentText;
    }

    /**
     * Comment text.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getCommentText() {
        return commentText;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            commentText,
            previousCommentText
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
            FileEditCommentDetails other = (FileEditCommentDetails) obj;
            return ((this.previousCommentText == other.previousCommentText) || (this.previousCommentText.equals(other.previousCommentText)))
                && ((this.commentText == other.commentText) || (this.commentText != null && this.commentText.equals(other.commentText)))
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
    static class Serializer extends StructSerializer<FileEditCommentDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileEditCommentDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_comment_text");
            StoneSerializers.string().serialize(value.previousCommentText, g);
            if (value.commentText != null) {
                g.writeFieldName("comment_text");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.commentText, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileEditCommentDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileEditCommentDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_previousCommentText = null;
                String f_commentText = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_comment_text".equals(field)) {
                        f_previousCommentText = StoneSerializers.string().deserialize(p);
                    }
                    else if ("comment_text".equals(field)) {
                        f_commentText = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousCommentText == null) {
                    throw new JsonParseException(p, "Required field \"previous_comment_text\" missing.");
                }
                value = new FileEditCommentDetails(f_previousCommentText, f_commentText);
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
