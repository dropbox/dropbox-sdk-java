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
 * Added Binder page.
 */
public class BinderAddPageDetails {
    // struct team_log.BinderAddPageDetails (team_log_generated.stone)

    protected final String eventUuid;
    protected final String docTitle;
    protected final String binderItemName;

    /**
     * Added Binder page.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param docTitle  Title of the Binder doc. Must not be {@code null}.
     * @param binderItemName  Name of the Binder page/section. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BinderAddPageDetails(String eventUuid, String docTitle, String binderItemName) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        if (docTitle == null) {
            throw new IllegalArgumentException("Required value for 'docTitle' is null");
        }
        this.docTitle = docTitle;
        if (binderItemName == null) {
            throw new IllegalArgumentException("Required value for 'binderItemName' is null");
        }
        this.binderItemName = binderItemName;
    }

    /**
     * Event unique identifier.
     *
     * @return value for this field, never {@code null}.
     */
    public String getEventUuid() {
        return eventUuid;
    }

    /**
     * Title of the Binder doc.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDocTitle() {
        return docTitle;
    }

    /**
     * Name of the Binder page/section.
     *
     * @return value for this field, never {@code null}.
     */
    public String getBinderItemName() {
        return binderItemName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            eventUuid,
            docTitle,
            binderItemName
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
            BinderAddPageDetails other = (BinderAddPageDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && ((this.docTitle == other.docTitle) || (this.docTitle.equals(other.docTitle)))
                && ((this.binderItemName == other.binderItemName) || (this.binderItemName.equals(other.binderItemName)))
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
    static class Serializer extends StructSerializer<BinderAddPageDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(BinderAddPageDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            g.writeFieldName("doc_title");
            StoneSerializers.string().serialize(value.docTitle, g);
            g.writeFieldName("binder_item_name");
            StoneSerializers.string().serialize(value.binderItemName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public BinderAddPageDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            BinderAddPageDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                String f_docTitle = null;
                String f_binderItemName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("doc_title".equals(field)) {
                        f_docTitle = StoneSerializers.string().deserialize(p);
                    }
                    else if ("binder_item_name".equals(field)) {
                        f_binderItemName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                if (f_docTitle == null) {
                    throw new JsonParseException(p, "Required field \"doc_title\" missing.");
                }
                if (f_binderItemName == null) {
                    throw new JsonParseException(p, "Required field \"binder_item_name\" missing.");
                }
                value = new BinderAddPageDetails(f_eventUuid, f_docTitle, f_binderItemName);
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
