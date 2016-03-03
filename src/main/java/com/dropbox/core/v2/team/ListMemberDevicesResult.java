/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

@JsonSerialize(using=ListMemberDevicesResult.Serializer.class)
@JsonDeserialize(using=ListMemberDevicesResult.Deserializer.class)
public class ListMemberDevicesResult {
    // struct ListMemberDevicesResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<ActiveWebSession> activeWebSessions;
    protected final List<DesktopClientSession> desktopClientSessions;
    protected final List<MobileClientSession> mobileClientSessions;

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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ListMemberDevicesResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListMemberDevicesResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListMemberDevicesResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListMemberDevicesResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListMemberDevicesResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value.activeWebSessions != null) {
                g.writeObjectField("active_web_sessions", value.activeWebSessions);
            }
            if (value.desktopClientSessions != null) {
                g.writeObjectField("desktop_client_sessions", value.desktopClientSessions);
            }
            if (value.mobileClientSessions != null) {
                g.writeObjectField("mobile_client_sessions", value.mobileClientSessions);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListMemberDevicesResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListMemberDevicesResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListMemberDevicesResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListMemberDevicesResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListMemberDevicesResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<ActiveWebSession> activeWebSessions = null;
            List<DesktopClientSession> desktopClientSessions = null;
            List<MobileClientSession> mobileClientSessions = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("active_web_sessions".equals(_field)) {
                    expectArrayStart(_p);
                    activeWebSessions = new java.util.ArrayList<ActiveWebSession>();
                    while (!isArrayEnd(_p)) {
                        ActiveWebSession _x = null;
                        _x = _p.readValueAs(ActiveWebSession.class);
                        _p.nextToken();
                        activeWebSessions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("desktop_client_sessions".equals(_field)) {
                    expectArrayStart(_p);
                    desktopClientSessions = new java.util.ArrayList<DesktopClientSession>();
                    while (!isArrayEnd(_p)) {
                        DesktopClientSession _x = null;
                        _x = _p.readValueAs(DesktopClientSession.class);
                        _p.nextToken();
                        desktopClientSessions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("mobile_client_sessions".equals(_field)) {
                    expectArrayStart(_p);
                    mobileClientSessions = new java.util.ArrayList<MobileClientSession>();
                    while (!isArrayEnd(_p)) {
                        MobileClientSession _x = null;
                        _x = _p.readValueAs(MobileClientSession.class);
                        _p.nextToken();
                        mobileClientSessions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new ListMemberDevicesResult(activeWebSessions, desktopClientSessions, mobileClientSessions);
        }
    }
}
