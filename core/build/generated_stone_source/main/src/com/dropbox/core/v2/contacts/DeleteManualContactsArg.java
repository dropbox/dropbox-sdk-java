/* DO NOT EDIT */
/* This file was generated from contacts.stone */

package com.dropbox.core.v2.contacts;

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

import javax.annotation.Nonnull;

class DeleteManualContactsArg {
    // struct contacts.DeleteManualContactsArg (contacts.stone)

    protected final List<String> emailAddresses;

    /**
     *
     * @param emailAddresses  List of manually added contacts to be deleted.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteManualContactsArg(@Nonnull List<String> emailAddresses) {
        if (emailAddresses == null) {
            throw new IllegalArgumentException("Required value for 'emailAddresses' is null");
        }
        for (String x : emailAddresses) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'emailAddresses' is null");
            }
            if (x.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list 'emailAddresses' is longer than 255");
            }
            if (!java.util.regex.Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", x)) {
                throw new IllegalArgumentException("Stringan item in list 'emailAddresses' does not match pattern");
            }
        }
        this.emailAddresses = emailAddresses;
    }

    /**
     * List of manually added contacts to be deleted.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            emailAddresses
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
            DeleteManualContactsArg other = (DeleteManualContactsArg) obj;
            return (this.emailAddresses == other.emailAddresses) || (this.emailAddresses.equals(other.emailAddresses));
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
    static class Serializer extends StructSerializer<DeleteManualContactsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteManualContactsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("email_addresses");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.emailAddresses, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeleteManualContactsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeleteManualContactsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_emailAddresses = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("email_addresses".equals(field)) {
                        f_emailAddresses = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_emailAddresses == null) {
                    throw new JsonParseException(p, "Required field \"email_addresses\" missing.");
                }
                value = new DeleteManualContactsArg(f_emailAddresses);
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
