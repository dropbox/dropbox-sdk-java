/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

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
import java.util.regex.Pattern;

class SetAccessInheritanceArg {
    // struct sharing.SetAccessInheritanceArg (sharing_folders.stone)

    protected final AccessInheritance accessInheritance;
    protected final String sharedFolderId;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param accessInheritance  The access inheritance settings for the folder.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SetAccessInheritanceArg(@javax.annotation.Nonnull String sharedFolderId, @javax.annotation.Nonnull AccessInheritance accessInheritance) {
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        this.accessInheritance = accessInheritance;
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SetAccessInheritanceArg(String sharedFolderId) {
        this(sharedFolderId, AccessInheritance.INHERIT);
    }

    /**
     * The ID for the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * The access inheritance settings for the folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AccessInheritance.INHERIT.
     */
    @javax.annotation.Nonnull
    public AccessInheritance getAccessInheritance() {
        return accessInheritance;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            accessInheritance,
            sharedFolderId
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
            SetAccessInheritanceArg other = (SetAccessInheritanceArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.accessInheritance == other.accessInheritance) || (this.accessInheritance.equals(other.accessInheritance)))
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
    static class Serializer extends StructSerializer<SetAccessInheritanceArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SetAccessInheritanceArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("access_inheritance");
            AccessInheritance.Serializer.INSTANCE.serialize(value.accessInheritance, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SetAccessInheritanceArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SetAccessInheritanceArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                AccessInheritance f_accessInheritance = AccessInheritance.INHERIT;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("access_inheritance".equals(field)) {
                        f_accessInheritance = AccessInheritance.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                value = new SetAccessInheritanceArg(f_sharedFolderId, f_accessInheritance);
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
