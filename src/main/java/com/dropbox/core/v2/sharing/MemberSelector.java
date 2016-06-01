/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Includes different ways to identify a member of a shared folder.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
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
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MemberSelector}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
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
     * @return {@code true} if this instance is tagged as {@link
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
     * @param value  value to assign to this instance.
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
     * @return {@code true} if this instance is tagged as {@link Tag#EMAIL},
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
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberSelector} with its tag set to {@link
     *     Tag#EMAIL}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
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
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
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
    static final class Serializer extends UnionSerializer<MemberSelector> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberSelector value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case DROPBOX_ID: {
                    g.writeStartObject();
                    writeTag("dropbox_id", g);
                    g.writeFieldName("dropbox_id");
                    StoneSerializers.string().serialize(value.dropboxIdValue, g);
                    g.writeEndObject();
                    break;
                }
                case EMAIL: {
                    g.writeStartObject();
                    writeTag("email", g);
                    g.writeFieldName("email");
                    StoneSerializers.string().serialize(value.emailValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MemberSelector deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberSelector value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("dropbox_id".equals(tag)) {
                String fieldValue = null;
                expectField("dropbox_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = MemberSelector.dropboxId(fieldValue);
            }
            else if ("email".equals(tag)) {
                String fieldValue = null;
                expectField("email", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = MemberSelector.email(fieldValue);
            }
            else {
                value = MemberSelector.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
