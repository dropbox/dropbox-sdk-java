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

/**
 * Per-member result for {@link
 * DbxUserPaperRequests#docsUsersAdd(String,java.util.List)}.
 */
public class AddPaperDocUserMemberResult {
    // struct paper.AddPaperDocUserMemberResult (paper.stone)

    protected final MemberSelector member;
    protected final AddPaperDocUserResult result;

    /**
     * Per-member result for {@link
     * DbxUserPaperRequests#docsUsersAdd(String,java.util.List)}.
     *
     * @param member  One of specified input members. Must not be {@code null}.
     * @param result  The outcome of the action on this member. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddPaperDocUserMemberResult(@Nonnull MemberSelector member, @Nonnull AddPaperDocUserResult result) {
        if (member == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = member;
        if (result == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = result;
    }

    /**
     * One of specified input members.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public MemberSelector getMember() {
        return member;
    }

    /**
     * The outcome of the action on this member.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AddPaperDocUserResult getResult() {
        return result;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            member,
            result
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
            AddPaperDocUserMemberResult other = (AddPaperDocUserMemberResult) obj;
            return ((this.member == other.member) || (this.member.equals(other.member)))
                && ((this.result == other.result) || (this.result.equals(other.result)))
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
    static class Serializer extends StructSerializer<AddPaperDocUserMemberResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddPaperDocUserMemberResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(value.member, g);
            g.writeFieldName("result");
            AddPaperDocUserResult.Serializer.INSTANCE.serialize(value.result, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AddPaperDocUserMemberResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AddPaperDocUserMemberResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                MemberSelector f_member = null;
                AddPaperDocUserResult f_result = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("member".equals(field)) {
                        f_member = MemberSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("result".equals(field)) {
                        f_result = AddPaperDocUserResult.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_member == null) {
                    throw new JsonParseException(p, "Required field \"member\" missing.");
                }
                if (f_result == null) {
                    throw new JsonParseException(p, "Required field \"result\" missing.");
                }
                value = new AddPaperDocUserMemberResult(f_member, f_result);
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
