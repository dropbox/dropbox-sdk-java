/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * The member and type of access the member should have when added to a shared
 * folder.
 */
public class AddMember {
    // struct AddMember

    private final MemberSelector member;
    private final AccessLevel accessLevel;

    /**
     * The member and type of access the member should have when added to a
     * shared folder.
     *
     * @param member  The member to add to the shared folder. Must not be {@code
     *     null}.
     * @param accessLevel  The access level to grant {@link AddMember#getMember}
     *     to the shared folder.  {@link AccessLevel#OWNER} is disallowed.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddMember(MemberSelector member, AccessLevel accessLevel) {
        if (member == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = member;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessLevel' is null");
        }
        this.accessLevel = accessLevel;
    }

    /**
     * The member and type of access the member should have when added to a
     * shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param member  The member to add to the shared folder. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddMember(MemberSelector member) {
        this(member, AccessLevel.VIEWER);
    }

    /**
     * The member to add to the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberSelector getMember() {
        return member;
    }

    /**
     * The access level to grant {@link AddMember#getMember} to the shared
     * folder.  {@link AccessLevel#OWNER} is disallowed.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AccessLevel.VIEWER.
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            member,
            accessLevel
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
            AddMember other = (AddMember) obj;
            return ((this.member == other.member) || (this.member.equals(other.member)))
                && ((this.accessLevel == other.accessLevel) || (this.accessLevel.equals(other.accessLevel)))
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

    public static AddMember fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AddMember> _JSON_WRITER = new JsonWriter<AddMember>() {
        public final void write(AddMember x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            AddMember._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(AddMember x, JsonGenerator g) throws IOException {
            g.writeFieldName("member");
            MemberSelector._JSON_WRITER.write(x.member, g);
            g.writeFieldName("access_level");
            AccessLevel._JSON_WRITER.write(x.accessLevel, g);
        }
    };

    public static final JsonReader<AddMember> _JSON_READER = new JsonReader<AddMember>() {
        public final AddMember read(JsonParser parser) throws IOException, JsonReadException {
            AddMember result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final AddMember readFields(JsonParser parser) throws IOException, JsonReadException {
            MemberSelector member = null;
            AccessLevel accessLevel = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("member".equals(fieldName)) {
                    member = MemberSelector._JSON_READER
                        .readField(parser, "member", member);
                }
                else if ("access_level".equals(fieldName)) {
                    accessLevel = AccessLevel._JSON_READER
                        .readField(parser, "access_level", accessLevel);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (member == null) {
                throw new JsonReadException("Required field \"member\" is missing.", parser.getTokenLocation());
            }
            return new AddMember(member, accessLevel);
        }
    };
}
