/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Arguments for {@link
 * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
 */
public class RemoveFileMemberArg {
    // struct RemoveFileMemberArg

    protected final String file;
    protected final MemberSelector member;

    /**
     * Arguments for {@link
     * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     *
     * @param file  File from which to remove members. Must have length of at
     *     least 1, match pattern "{@code ((/|id:).*|nspath:[^:]*:[^:]*)}", and
     *     not be {@code null}.
     * @param member  Member to remove from this file. Note that even if an
     *     email is specified, it may result in the removal of a user (not an
     *     invitee) if the user's main account corresponds to that email
     *     address. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RemoveFileMemberArg(String file, MemberSelector member) {
        if (file == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (file.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*|nspath:[^:]*:[^:]*)", file)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = file;
        if (member == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = member;
    }

    /**
     * File from which to remove members.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFile() {
        return file;
    }

    /**
     * Member to remove from this file. Note that even if an email is specified,
     * it may result in the removal of a user (not an invitee) if the user's
     * main account corresponds to that email address.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberSelector getMember() {
        return member;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            file,
            member
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
            RemoveFileMemberArg other = (RemoveFileMemberArg) obj;
            return ((this.file == other.file) || (this.file.equals(other.file)))
                && ((this.member == other.member) || (this.member.equals(other.member)))
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
    static final class Serializer extends StructSerializer<RemoveFileMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RemoveFileMemberArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file");
            StoneSerializers.string().serialize(value.file, g);
            g.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(value.member, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RemoveFileMemberArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RemoveFileMemberArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_file = null;
                MemberSelector f_member = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file".equals(field)) {
                        f_file = StoneSerializers.string().deserialize(p);
                    }
                    else if ("member".equals(field)) {
                        f_member = MemberSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_file == null) {
                    throw new JsonParseException(p, "Required field \"file\" missing.");
                }
                if (f_member == null) {
                    throw new JsonParseException(p, "Required field \"member\" missing.");
                }
                value = new RemoveFileMemberArg(f_file, f_member);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
