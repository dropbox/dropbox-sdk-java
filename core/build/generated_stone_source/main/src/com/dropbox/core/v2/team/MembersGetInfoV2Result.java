/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

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

public class MembersGetInfoV2Result {
    // struct team.MembersGetInfoV2Result (team_members.stone)

    protected final List<MembersGetInfoItemV2> membersInfo;

    /**
     *
     * @param membersInfo  List of team members info. Must not contain a {@code
     *     null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersGetInfoV2Result(List<MembersGetInfoItemV2> membersInfo) {
        if (membersInfo == null) {
            throw new IllegalArgumentException("Required value for 'membersInfo' is null");
        }
        for (MembersGetInfoItemV2 x : membersInfo) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'membersInfo' is null");
            }
        }
        this.membersInfo = membersInfo;
    }

    /**
     * List of team members info.
     *
     * @return value for this field, never {@code null}.
     */
    public List<MembersGetInfoItemV2> getMembersInfo() {
        return membersInfo;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            membersInfo
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
            MembersGetInfoV2Result other = (MembersGetInfoV2Result) obj;
            return (this.membersInfo == other.membersInfo) || (this.membersInfo.equals(other.membersInfo));
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
    static class Serializer extends StructSerializer<MembersGetInfoV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersGetInfoV2Result value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("members_info");
            StoneSerializers.list(MembersGetInfoItemV2.Serializer.INSTANCE).serialize(value.membersInfo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersGetInfoV2Result deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersGetInfoV2Result value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<MembersGetInfoItemV2> f_membersInfo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("members_info".equals(field)) {
                        f_membersInfo = StoneSerializers.list(MembersGetInfoItemV2.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_membersInfo == null) {
                    throw new JsonParseException(p, "Required field \"members_info\" missing.");
                }
                value = new MembersGetInfoV2Result(f_membersInfo);
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
