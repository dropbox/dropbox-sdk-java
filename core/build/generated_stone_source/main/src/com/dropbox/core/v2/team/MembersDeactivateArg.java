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

class MembersDeactivateArg extends MembersDeactivateBaseArg {
    // struct team.MembersDeactivateArg (team_members.stone)

    protected final boolean wipeData;

    /**
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersDeactivateArg(UserSelectorArg user, boolean wipeData) {
        super(user);
        this.wipeData = wipeData;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersDeactivateArg(UserSelectorArg user) {
        this(user, true);
    }

    /**
     * Identity of user to remove/suspend/have their files moved.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * If provided, controls if the user's data will be deleted on their linked
     * devices.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getWipeData() {
        return wipeData;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            wipeData
        });
        hash = (31 * super.hashCode()) + hash;
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
            MembersDeactivateArg other = (MembersDeactivateArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && (this.wipeData == other.wipeData)
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
    static class Serializer extends StructSerializer<MembersDeactivateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersDeactivateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("wipe_data");
            StoneSerializers.boolean_().serialize(value.wipeData, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersDeactivateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersDeactivateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                Boolean f_wipeData = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("wipe_data".equals(field)) {
                        f_wipeData = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                value = new MembersDeactivateArg(f_user, f_wipeData);
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
