/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class ListMemberDevicesResult {
    // struct ListMemberDevicesResult

    private final List<ActiveWebSession> activeWebSessions;
    private final List<DesktopClientSession> desktopClientSessions;
    private final List<MobileClientSession> mobileClientSessions;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param activeWebSessions  List of web sessions made by this team member.
     *     Must not contain a {@code null} item.
     * @param desktopClientSessions  List of desktop clients used by this team
     *     member. Must not contain a {@code null} item.
     * @param mobileClientSessions  List of mobile client used by this team
     *     member. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberDevicesResult(List<ActiveWebSession> activeWebSessions, List<DesktopClientSession> desktopClientSessions, List<MobileClientSession> mobileClientSessions) {
        if (activeWebSessions != null) {
            for (ActiveWebSession x : activeWebSessions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'activeWebSessions' is null");
                }
            }
        }
        this.activeWebSessions = activeWebSessions;
        if (desktopClientSessions != null) {
            for (DesktopClientSession x : desktopClientSessions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'desktopClientSessions' is null");
                }
            }
        }
        this.desktopClientSessions = desktopClientSessions;
        if (mobileClientSessions != null) {
            for (MobileClientSession x : mobileClientSessions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'mobileClientSessions' is null");
                }
            }
        }
        this.mobileClientSessions = mobileClientSessions;
    }

    /**
     * The default values for unset fields will be used.
     */
    public ListMemberDevicesResult() {
        this(null, null, null);
    }

    /**
     * List of web sessions made by this team member
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<ActiveWebSession> getActiveWebSessions() {
        return activeWebSessions;
    }

    /**
     * List of desktop clients used by this team member
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<DesktopClientSession> getDesktopClientSessions() {
        return desktopClientSessions;
    }

    /**
     * List of mobile client used by this team member
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<MobileClientSession> getMobileClientSessions() {
        return mobileClientSessions;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link ListMemberDevicesResult}.
     */
    public static class Builder {

        protected List<ActiveWebSession> activeWebSessions;
        protected List<DesktopClientSession> desktopClientSessions;
        protected List<MobileClientSession> mobileClientSessions;

        protected Builder() {
            this.activeWebSessions = null;
            this.desktopClientSessions = null;
            this.mobileClientSessions = null;
        }

        /**
         * Set value for optional field.
         *
         * @param activeWebSessions  List of web sessions made by this team
         *     member. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withActiveWebSessions(List<ActiveWebSession> activeWebSessions) {
            if (activeWebSessions != null) {
                for (ActiveWebSession x : activeWebSessions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'activeWebSessions' is null");
                    }
                }
            }
            this.activeWebSessions = activeWebSessions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param desktopClientSessions  List of desktop clients used by this
         *     team member. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withDesktopClientSessions(List<DesktopClientSession> desktopClientSessions) {
            if (desktopClientSessions != null) {
                for (DesktopClientSession x : desktopClientSessions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'desktopClientSessions' is null");
                    }
                }
            }
            this.desktopClientSessions = desktopClientSessions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param mobileClientSessions  List of mobile client used by this team
         *     member. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMobileClientSessions(List<MobileClientSession> mobileClientSessions) {
            if (mobileClientSessions != null) {
                for (MobileClientSession x : mobileClientSessions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'mobileClientSessions' is null");
                    }
                }
            }
            this.mobileClientSessions = mobileClientSessions;
            return this;
        }

        /**
         * Builds an instance of {@link ListMemberDevicesResult} configured with
         * this builder's values
         *
         * @return new instance of {@link ListMemberDevicesResult}
         */
        public ListMemberDevicesResult build() {
            return new ListMemberDevicesResult(activeWebSessions, desktopClientSessions, mobileClientSessions);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            activeWebSessions,
            desktopClientSessions,
            mobileClientSessions
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
            ListMemberDevicesResult other = (ListMemberDevicesResult) obj;
            return ((this.activeWebSessions == other.activeWebSessions) || (this.activeWebSessions != null && this.activeWebSessions.equals(other.activeWebSessions)))
                && ((this.desktopClientSessions == other.desktopClientSessions) || (this.desktopClientSessions != null && this.desktopClientSessions.equals(other.desktopClientSessions)))
                && ((this.mobileClientSessions == other.mobileClientSessions) || (this.mobileClientSessions != null && this.mobileClientSessions.equals(other.mobileClientSessions)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListMemberDevicesResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListMemberDevicesResult> _JSON_WRITER = new JsonWriter<ListMemberDevicesResult>() {
        public final void write(ListMemberDevicesResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListMemberDevicesResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListMemberDevicesResult x, JsonGenerator g) throws IOException {
            if (x.activeWebSessions != null) {
                g.writeFieldName("active_web_sessions");
                g.writeStartArray();
                for (ActiveWebSession item: x.activeWebSessions) {
                    if (item != null) {
                        ActiveWebSession._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
            if (x.desktopClientSessions != null) {
                g.writeFieldName("desktop_client_sessions");
                g.writeStartArray();
                for (DesktopClientSession item: x.desktopClientSessions) {
                    if (item != null) {
                        DesktopClientSession._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
            if (x.mobileClientSessions != null) {
                g.writeFieldName("mobile_client_sessions");
                g.writeStartArray();
                for (MobileClientSession item: x.mobileClientSessions) {
                    if (item != null) {
                        MobileClientSession._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        }
    };

    public static final JsonReader<ListMemberDevicesResult> _JSON_READER = new JsonReader<ListMemberDevicesResult>() {
        public final ListMemberDevicesResult read(JsonParser parser) throws IOException, JsonReadException {
            ListMemberDevicesResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListMemberDevicesResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<ActiveWebSession> activeWebSessions = null;
            List<DesktopClientSession> desktopClientSessions = null;
            List<MobileClientSession> mobileClientSessions = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("active_web_sessions".equals(fieldName)) {
                    activeWebSessions = JsonArrayReader.mk(ActiveWebSession._JSON_READER)
                        .readField(parser, "active_web_sessions", activeWebSessions);
                }
                else if ("desktop_client_sessions".equals(fieldName)) {
                    desktopClientSessions = JsonArrayReader.mk(DesktopClientSession._JSON_READER)
                        .readField(parser, "desktop_client_sessions", desktopClientSessions);
                }
                else if ("mobile_client_sessions".equals(fieldName)) {
                    mobileClientSessions = JsonArrayReader.mk(MobileClientSession._JSON_READER)
                        .readField(parser, "mobile_client_sessions", mobileClientSessions);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new ListMemberDevicesResult(activeWebSessions, desktopClientSessions, mobileClientSessions);
        }
    };
}
