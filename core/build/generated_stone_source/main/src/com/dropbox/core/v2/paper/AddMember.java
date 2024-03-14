/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.sharing.MemberSelector;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

public class AddMember {
    // struct paper.AddMember (paper.stone)

    protected final PaperDocPermissionLevel permissionLevel;
    protected final MemberSelector member;

    /**
     *
     * @param member  User which should be added to the Paper doc. Specify only
     *     email address or Dropbox account ID. Must not be {@code null}.
     * @param permissionLevel  Permission for the user. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddMember(@Nonnull MemberSelector member, @Nonnull PaperDocPermissionLevel permissionLevel) {
        if (permissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'permissionLevel' is null");
        }
        this.permissionLevel = permissionLevel;
        if (member == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = member;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param member  User which should be added to the Paper doc. Specify only
     *     email address or Dropbox account ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddMember(MemberSelector member) {
        this(member, PaperDocPermissionLevel.EDIT);
    }

    /**
     * User which should be added to the Paper doc. Specify only email address
     * or Dropbox account ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public MemberSelector getMember() {
        return member;
    }

    /**
     * Permission for the user.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     PaperDocPermissionLevel.EDIT.
     */
    @Nonnull
    public PaperDocPermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            permissionLevel,
            member
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
            AddMember other = (AddMember) obj;
            return ((this.member == other.member) || (this.member.equals(other.member)))
                && ((this.permissionLevel == other.permissionLevel) || (this.permissionLevel.equals(other.permissionLevel)))
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
    static class Serializer extends StructSerializer<AddMember> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddMember value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(value.member, g);
            g.writeFieldName("permission_level");
            PaperDocPermissionLevel.Serializer.INSTANCE.serialize(value.permissionLevel, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AddMember deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AddMember value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                MemberSelector f_member = null;
                PaperDocPermissionLevel f_permissionLevel = PaperDocPermissionLevel.EDIT;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("member".equals(field)) {
                        f_member = MemberSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("permission_level".equals(field)) {
                        f_permissionLevel = PaperDocPermissionLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_member == null) {
                    throw new JsonParseException(p, "Required field \"member\" missing.");
                }
                value = new AddMember(f_member, f_permissionLevel);
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
