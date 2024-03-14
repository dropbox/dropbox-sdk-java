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

import javax.annotation.Nonnull;

/**
 * Showcase document's logged information.
 */
public class ShowcaseDocumentLogInfo {
    // struct team_log.ShowcaseDocumentLogInfo (team_log_generated.stone)

    protected final String showcaseId;
    protected final String showcaseTitle;

    /**
     * Showcase document's logged information.
     *
     * @param showcaseId  Showcase document Id. Must not be {@code null}.
     * @param showcaseTitle  Showcase document title. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShowcaseDocumentLogInfo(@Nonnull String showcaseId, @Nonnull String showcaseTitle) {
        if (showcaseId == null) {
            throw new IllegalArgumentException("Required value for 'showcaseId' is null");
        }
        this.showcaseId = showcaseId;
        if (showcaseTitle == null) {
            throw new IllegalArgumentException("Required value for 'showcaseTitle' is null");
        }
        this.showcaseTitle = showcaseTitle;
    }

    /**
     * Showcase document Id.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getShowcaseId() {
        return showcaseId;
    }

    /**
     * Showcase document title.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getShowcaseTitle() {
        return showcaseTitle;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            showcaseId,
            showcaseTitle
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
            ShowcaseDocumentLogInfo other = (ShowcaseDocumentLogInfo) obj;
            return ((this.showcaseId == other.showcaseId) || (this.showcaseId.equals(other.showcaseId)))
                && ((this.showcaseTitle == other.showcaseTitle) || (this.showcaseTitle.equals(other.showcaseTitle)))
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
    static class Serializer extends StructSerializer<ShowcaseDocumentLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ShowcaseDocumentLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("showcase_id");
            StoneSerializers.string().serialize(value.showcaseId, g);
            g.writeFieldName("showcase_title");
            StoneSerializers.string().serialize(value.showcaseTitle, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ShowcaseDocumentLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ShowcaseDocumentLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_showcaseId = null;
                String f_showcaseTitle = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("showcase_id".equals(field)) {
                        f_showcaseId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("showcase_title".equals(field)) {
                        f_showcaseTitle = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_showcaseId == null) {
                    throw new JsonParseException(p, "Required field \"showcase_id\" missing.");
                }
                if (f_showcaseTitle == null) {
                    throw new JsonParseException(p, "Required field \"showcase_title\" missing.");
                }
                value = new ShowcaseDocumentLogInfo(f_showcaseId, f_showcaseTitle);
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
