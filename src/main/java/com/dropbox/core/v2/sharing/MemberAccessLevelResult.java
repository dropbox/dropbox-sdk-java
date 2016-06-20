/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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
 * Contains information about a member's access level to content after an
 * operation.
 */
public class MemberAccessLevelResult {
    // struct MemberAccessLevelResult

    protected final AccessLevel accessLevel;
    protected final String warning;

    /**
     * Contains information about a member's access level to content after an
     * operation.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessLevel  The member still has this level of access to the
     *     content through a parent folder.
     * @param warning  A localized string with additional information about why
     *     the user has this access level to the content.
     */
    public MemberAccessLevelResult(AccessLevel accessLevel, String warning) {
        this.accessLevel = accessLevel;
        this.warning = warning;
    }

    /**
     * Contains information about a member's access level to content after an
     * operation.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public MemberAccessLevelResult() {
        this(null, null);
    }

    /**
     * The member still has this level of access to the content through a parent
     * folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * A localized string with additional information about why the user has
     * this access level to the content.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getWarning() {
        return warning;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link MemberAccessLevelResult}.
     */
    public static class Builder {

        protected AccessLevel accessLevel;
        protected String warning;

        protected Builder() {
            this.accessLevel = null;
            this.warning = null;
        }

        /**
         * Set value for optional field.
         *
         * @param accessLevel  The member still has this level of access to the
         *     content through a parent folder.
         *
         * @return this builder
         */
        public Builder withAccessLevel(AccessLevel accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param warning  A localized string with additional information about
         *     why the user has this access level to the content.
         *
         * @return this builder
         */
        public Builder withWarning(String warning) {
            this.warning = warning;
            return this;
        }

        /**
         * Builds an instance of {@link MemberAccessLevelResult} configured with
         * this builder's values
         *
         * @return new instance of {@link MemberAccessLevelResult}
         */
        public MemberAccessLevelResult build() {
            return new MemberAccessLevelResult(accessLevel, warning);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accessLevel,
            warning
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
            MemberAccessLevelResult other = (MemberAccessLevelResult) obj;
            return ((this.accessLevel == other.accessLevel) || (this.accessLevel != null && this.accessLevel.equals(other.accessLevel)))
                && ((this.warning == other.warning) || (this.warning != null && this.warning.equals(other.warning)))
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
    static final class Serializer extends StructSerializer<MemberAccessLevelResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberAccessLevelResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.accessLevel != null) {
                g.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(value.accessLevel, g);
            }
            if (value.warning != null) {
                g.writeFieldName("warning");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.warning, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberAccessLevelResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberAccessLevelResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_accessLevel = null;
                String f_warning = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_level".equals(field)) {
                        f_accessLevel = StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("warning".equals(field)) {
                        f_warning = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new MemberAccessLevelResult(f_accessLevel, f_warning);
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
