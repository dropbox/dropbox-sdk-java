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
 * The information about a user invited to become a member a shared folder.
 */
public final class InviteeInfo {
    // union InviteeInfo

    /**
     * Discriminating tag type for {@link InviteeInfo}.
     */
    public enum Tag {
        /**
         * E-mail address of invited user.
         */
        EMAIL, // String
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("email", Tag.EMAIL);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final InviteeInfo OTHER = new InviteeInfo(Tag.OTHER, null);

    private final Tag tag;
    private final String emailValue;

    /**
     * The information about a user invited to become a member a shared folder.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private InviteeInfo(Tag tag, String emailValue) {
        this.tag = tag;
        this.emailValue = emailValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code InviteeInfo}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#EMAIL},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#EMAIL},
     *     {@code false} otherwise.
     */
    public boolean isEmail() {
        return this.tag == Tag.EMAIL;
    }

    /**
     * Returns an instance of {@code InviteeInfo} that has its tag set to {@link
     * Tag#EMAIL}.
     *
     * <p> E-mail address of invited user. </p>
     *
     * @param value  {@link InviteeInfo#email} value to assign to this instance.
     *
     * @return Instance of {@code InviteeInfo} with its tag set to {@link
     *     Tag#EMAIL}.
     *
     * @throws IllegalArgumentException  if {@code value} does not match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}" or
     *     is {@code null}.
     */
    public static InviteeInfo email(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new InviteeInfo(Tag.EMAIL, value);
    }

    /**
     * E-mail address of invited user.
     *
     * <p> This instance must be tagged as {@link Tag#EMAIL}. </p>
     *
     * @return The {@link InviteeInfo#email} value associated with this instance
     *     if {@link #isEmail} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEmail} is {@code false}.
     */
    public String getEmailValue() {
        if (this.tag != Tag.EMAIL) {
            throw new IllegalStateException("Invalid tag: required Tag.EMAIL, but was Tag." + tag.name());
        }
        return emailValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            emailValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof InviteeInfo) {
            InviteeInfo other = (InviteeInfo) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case EMAIL:
                    return (this.emailValue == other.emailValue) || (this.emailValue.equals(other.emailValue));
                case OTHER:
                    return true;
                default:
                    return false;
            }
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

    public static InviteeInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<InviteeInfo> _JSON_WRITER = new JsonWriter<InviteeInfo>() {
        public final void write(InviteeInfo x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case EMAIL:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email");
                    g.writeFieldName("email");
                    g.writeString(x.getEmailValue());
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<InviteeInfo> _JSON_READER = new JsonReader<InviteeInfo>() {

        public final InviteeInfo read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return InviteeInfo.OTHER;
                }
                switch (tag) {
                    case OTHER: return InviteeInfo.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            InviteeInfo value = null;
            if (tag != null) {
                switch (tag) {
                    case EMAIL: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "email", v);
                        value = InviteeInfo.email(v);
                        break;
                    }
                    case OTHER: {
                        value = InviteeInfo.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return InviteeInfo.OTHER;
            }
            return value;
        }

    };
}
