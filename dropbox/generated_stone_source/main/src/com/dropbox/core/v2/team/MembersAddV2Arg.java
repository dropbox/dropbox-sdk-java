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

class MembersAddV2Arg extends MembersAddArgBase {
    // struct team.MembersAddV2Arg (team_members.stone)

    protected final List<MemberAddV2Arg> newMembers;

    /**
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param forceAsync  Whether to force the add to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddV2Arg(List<MemberAddV2Arg> newMembers, boolean forceAsync) {
        super(forceAsync);
        if (newMembers == null) {
            throw new IllegalArgumentException("Required value for 'newMembers' is null");
        }
        for (MemberAddV2Arg x : newMembers) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'newMembers' is null");
            }
        }
        this.newMembers = newMembers;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddV2Arg(List<MemberAddV2Arg> newMembers) {
        this(newMembers, false);
    }

    /**
     * Details of new members to be added to the team.
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberAddV2Arg> getNewMembers() {
        return newMembers;
    }

    /**
     * Whether to force the add to happen asynchronously.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getForceAsync() {
        return forceAsync;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            newMembers
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
            MembersAddV2Arg other = (MembersAddV2Arg) obj;
            return ((this.newMembers == other.newMembers) || (this.newMembers.equals(other.newMembers)))
                && (this.forceAsync == other.forceAsync)
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
    static class Serializer extends StructSerializer<MembersAddV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersAddV2Arg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_members");
            StoneSerializers.list(MemberAddV2Arg.Serializer.INSTANCE).serialize(value.newMembers, g);
            g.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(value.forceAsync, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersAddV2Arg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersAddV2Arg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<MemberAddV2Arg> f_newMembers = null;
                Boolean f_forceAsync = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_members".equals(field)) {
                        f_newMembers = StoneSerializers.list(MemberAddV2Arg.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("force_async".equals(field)) {
                        f_forceAsync = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newMembers == null) {
                    throw new JsonParseException(p, "Required field \"new_members\" missing.");
                }
                value = new MembersAddV2Arg(f_newMembers, f_forceAsync);
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
