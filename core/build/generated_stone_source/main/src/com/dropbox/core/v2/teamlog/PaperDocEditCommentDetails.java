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
 * Edited Paper doc comment.
 */
public class PaperDocEditCommentDetails {
    // struct team_log.PaperDocEditCommentDetails (team_log_generated.stone)

    protected final String eventUuid;
    protected final String commentText;

    /**
     * Edited Paper doc comment.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param commentText  Comment text.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocEditCommentDetails(String eventUuid, String commentText) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        this.commentText = commentText;
    }

    /**
     * Edited Paper doc comment.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocEditCommentDetails(String eventUuid) {
        this(eventUuid, null);
    }

    /**
     * Event unique identifier.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getEventUuid() {
        return eventUuid;
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
            eventUuid,
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
            PaperDocEditCommentDetails other = (PaperDocEditCommentDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
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
    static class Serializer extends StructSerializer<PaperDocEditCommentDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocEditCommentDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            if (value.commentText != null) {
                g.writeFieldName("comment_text");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.commentText, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocEditCommentDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocEditCommentDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                String f_commentText = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("comment_text".equals(field)) {
                        f_commentText = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                value = new PaperDocEditCommentDetails(f_eventUuid, f_commentText);
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
