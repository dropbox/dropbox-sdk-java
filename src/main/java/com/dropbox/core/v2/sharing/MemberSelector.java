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
 * Includes different ways to identify a member of a shared folder.
 */
public final class MemberSelector {
    // union MemberSelector

    /**
     * Discriminating tag type for {@link MemberSelector}.
     */
    public enum Tag {
        /**
         * Dropbox account, team member, or group ID of member.
         */
        DROPBOX_ID, // String
        /**
         * E-mail address of member.
         */
        EMAIL, // String
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("dropbox_id", Tag.DROPBOX_ID);
        VALUES_.put("email", Tag.EMAIL);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final MemberSelector OTHER = new MemberSelector(Tag.OTHER, null, null);

    private final Tag tag;
    private final String dropboxIdValue;
    private final String emailValue;

    /**
     * Includes different ways to identify a member of a shared folder.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MemberSelector(Tag tag, String dropboxIdValue, String emailValue) {
        this.tag = tag;
        this.dropboxIdValue = dropboxIdValue;
        this.emailValue = emailValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code MemberSelector}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#DROPBOX_ID},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#DROPBOX_ID}, {@code false} otherwise.
     */
    public boolean isDropboxId() {
        return this.tag == Tag.DROPBOX_ID;
    }

    /**
     * Returns an instance of {@code MemberSelector} that has its tag set to
     * {@link Tag#DROPBOX_ID}.
     *
     * <p> Dropbox account, team member, or group ID of member. </p>
     *
     * @param value  {@link MemberSelector#dropboxId} value to assign to this
     *     instance.
     *
     * @return Instance of {@code MemberSelector} with its tag set to {@link
     *     Tag#DROPBOX_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1 or
     *     is {@code null}.
     */
    public static MemberSelector dropboxId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        return new MemberSelector(Tag.DROPBOX_ID, value, null);
    }

    /**
     * Dropbox account, team member, or group ID of member.
     *
     * <p> This instance must be tagged as {@link Tag#DROPBOX_ID}. </p>
     *
     * @return The {@link MemberSelector#dropboxId} value associated with this
     *     instance if {@link #isDropboxId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isDropboxId} is {@code false}.
     */
    public String getDropboxIdValue() {
        if (this.tag != Tag.DROPBOX_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.DROPBOX_ID, but was Tag." + tag.name());
        }
        return dropboxIdValue;
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
     * Returns an instance of {@code MemberSelector} that has its tag set to
     * {@link Tag#EMAIL}.
     *
     * <p> E-mail address of member. </p>
     *
     * @param value  {@link MemberSelector#email} value to assign to this
     *     instance.
     *
     * @return Instance of {@code MemberSelector} with its tag set to {@link
     *     Tag#EMAIL}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberSelector email(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberSelector(Tag.EMAIL, null, value);
    }

    /**
     * E-mail address of member.
     *
     * <p> This instance must be tagged as {@link Tag#EMAIL}. </p>
     *
     * @return The {@link MemberSelector#email} value associated with this
     *     instance if {@link #isEmail} is {@code true}.
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
            dropboxIdValue,
            emailValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof MemberSelector) {
            MemberSelector other = (MemberSelector) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case DROPBOX_ID:
                    return (this.dropboxIdValue == other.dropboxIdValue) || (this.dropboxIdValue.equals(other.dropboxIdValue));
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

    public static MemberSelector fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberSelector> _JSON_WRITER = new JsonWriter<MemberSelector>() {
        public final void write(MemberSelector x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case DROPBOX_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("dropbox_id");
                    g.writeFieldName("dropbox_id");
                    g.writeString(x.getDropboxIdValue());
                    g.writeEndObject();
                    break;
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

    public static final JsonReader<MemberSelector> _JSON_READER = new JsonReader<MemberSelector>() {

        public final MemberSelector read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return MemberSelector.OTHER;
                }
                switch (tag) {
                    case OTHER: return MemberSelector.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            MemberSelector value = null;
            if (tag != null) {
                switch (tag) {
                    case DROPBOX_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "dropbox_id", v);
                        value = MemberSelector.dropboxId(v);
                        break;
                    }
                    case EMAIL: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "email", v);
                        value = MemberSelector.email(v);
                        break;
                    }
                    case OTHER: {
                        value = MemberSelector.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return MemberSelector.OTHER;
            }
            return value;
        }

    };
}
