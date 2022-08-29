/* DO NOT EDIT */
/* This file was generated from contacts.stone */

package com.dropbox.core.v2.contacts;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class DeleteManualContactsError {
    // union contacts.DeleteManualContactsError (contacts.stone)

    /**
     * Discriminating tag type for {@link DeleteManualContactsError}.
     */
    public enum Tag {
        /**
         * Can't delete contacts from this list. Make sure the list only has
         * manually added contacts. The deletion was cancelled.
         */
        CONTACTS_NOT_FOUND, // List<String>
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
    public static final DeleteManualContactsError OTHER = new DeleteManualContactsError().withTag(Tag.OTHER);

    private Tag _tag;
    private List<String> contactsNotFoundValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private DeleteManualContactsError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private DeleteManualContactsError withTag(Tag _tag) {
        DeleteManualContactsError result = new DeleteManualContactsError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param contactsNotFoundValue  Can't delete contacts from this list. Make
     *     sure the list only has manually added contacts. The deletion was
     *     cancelled. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private DeleteManualContactsError withTagAndContactsNotFound(Tag _tag, List<String> contactsNotFoundValue) {
        DeleteManualContactsError result = new DeleteManualContactsError();
        result._tag = _tag;
        result.contactsNotFoundValue = contactsNotFoundValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code DeleteManualContactsError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONTACTS_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONTACTS_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isContactsNotFound() {
        return this._tag == Tag.CONTACTS_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code DeleteManualContactsError} that has its tag
     * set to {@link Tag#CONTACTS_NOT_FOUND}.
     *
     * <p> Can't delete contacts from this list. Make sure the list only has
     * manually added contacts. The deletion was cancelled. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code DeleteManualContactsError} with its tag set to
     *     {@link Tag#CONTACTS_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static DeleteManualContactsError contactsNotFound(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
            if (x.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list is longer than 255");
            }
            if (!java.util.regex.Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", x)) {
                throw new IllegalArgumentException("Stringan item in list does not match pattern");
            }
        }
        return new DeleteManualContactsError().withTagAndContactsNotFound(Tag.CONTACTS_NOT_FOUND, value);
    }

    /**
     * Can't delete contacts from this list. Make sure the list only has
     * manually added contacts. The deletion was cancelled.
     *
     * <p> This instance must be tagged as {@link Tag#CONTACTS_NOT_FOUND}. </p>
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isContactsNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isContactsNotFound} is {@code
     *     false}.
     */
    public List<String> getContactsNotFoundValue() {
        if (this._tag != Tag.CONTACTS_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.CONTACTS_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return contactsNotFoundValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            contactsNotFoundValue
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
        else if (obj instanceof DeleteManualContactsError) {
            DeleteManualContactsError other = (DeleteManualContactsError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case CONTACTS_NOT_FOUND:
                    return (this.contactsNotFoundValue == other.contactsNotFoundValue) || (this.contactsNotFoundValue.equals(other.contactsNotFoundValue));
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
    static class Serializer extends UnionSerializer<DeleteManualContactsError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteManualContactsError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case CONTACTS_NOT_FOUND: {
                    g.writeStartObject();
                    writeTag("contacts_not_found", g);
                    g.writeFieldName("contacts_not_found");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.contactsNotFoundValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public DeleteManualContactsError deserialize(JsonParser p) throws IOException, JsonParseException {
            DeleteManualContactsError value;
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
            else if ("contacts_not_found".equals(tag)) {
                List<String> fieldValue = null;
                expectField("contacts_not_found", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = DeleteManualContactsError.contactsNotFound(fieldValue);
            }
            else {
                value = DeleteManualContactsError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
