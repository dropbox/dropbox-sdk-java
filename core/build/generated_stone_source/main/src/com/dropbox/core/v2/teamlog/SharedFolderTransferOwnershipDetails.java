/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Transferred ownership of shared folder to another member.
 */
public class SharedFolderTransferOwnershipDetails {
    // struct team_log.SharedFolderTransferOwnershipDetails (team_log_generated.stone)

    @Nullable
    protected final String previousOwnerEmail;
    @Nonnull
    protected final String newOwnerEmail;

    /**
     * Transferred ownership of shared folder to another member.
     *
     * @param newOwnerEmail  The email address of the new shared folder owner.
     *     Must have length of at most 255 and not be {@code null}.
     * @param previousOwnerEmail  The email address of the previous shared
     *     folder owner. Must have length of at most 255.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderTransferOwnershipDetails(@Nonnull String newOwnerEmail, @Nullable String previousOwnerEmail) {
        if (previousOwnerEmail != null) {
            if (previousOwnerEmail.length() > 255) {
                throw new IllegalArgumentException("String 'previousOwnerEmail' is longer than 255");
            }
        }
        this.previousOwnerEmail = previousOwnerEmail;
        if (newOwnerEmail == null) {
            throw new IllegalArgumentException("Required value for 'newOwnerEmail' is null");
        }
        if (newOwnerEmail.length() > 255) {
            throw new IllegalArgumentException("String 'newOwnerEmail' is longer than 255");
        }
        this.newOwnerEmail = newOwnerEmail;
    }

    /**
     * Transferred ownership of shared folder to another member.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newOwnerEmail  The email address of the new shared folder owner.
     *     Must have length of at most 255 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderTransferOwnershipDetails(@Nonnull String newOwnerEmail) {
        this(newOwnerEmail, null);
    }

    /**
     * The email address of the new shared folder owner.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getNewOwnerEmail() {
        return newOwnerEmail;
    }

    /**
     * The email address of the previous shared folder owner.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPreviousOwnerEmail() {
        return previousOwnerEmail;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousOwnerEmail,
            newOwnerEmail
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
            SharedFolderTransferOwnershipDetails other = (SharedFolderTransferOwnershipDetails) obj;
            return ((this.newOwnerEmail == other.newOwnerEmail) || (this.newOwnerEmail.equals(other.newOwnerEmail)))
                && ((this.previousOwnerEmail == other.previousOwnerEmail) || (this.previousOwnerEmail != null && this.previousOwnerEmail.equals(other.previousOwnerEmail)))
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
    static class Serializer extends StructSerializer<SharedFolderTransferOwnershipDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderTransferOwnershipDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_owner_email");
            StoneSerializers.string().serialize(value.newOwnerEmail, g);
            if (value.previousOwnerEmail != null) {
                g.writeFieldName("previous_owner_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previousOwnerEmail, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedFolderTransferOwnershipDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFolderTransferOwnershipDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_newOwnerEmail = null;
                String f_previousOwnerEmail = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_owner_email".equals(field)) {
                        f_newOwnerEmail = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_owner_email".equals(field)) {
                        f_previousOwnerEmail = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newOwnerEmail == null) {
                    throw new JsonParseException(p, "Required field \"new_owner_email\" missing.");
                }
                value = new SharedFolderTransferOwnershipDetails(f_newOwnerEmail, f_previousOwnerEmail);
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
