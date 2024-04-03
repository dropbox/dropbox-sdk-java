/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Cat extends Pet {
    // struct test.Cat (test.stone)

    @Nullable
    protected final String breed;
    @Nullable
    protected final Boolean indoor;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Cat(@Nonnull String name, @Nullable Date born, @Nullable String breed, @Nullable Boolean indoor) {
        super(name, born);
        this.breed = breed;
        this.indoor = indoor;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Cat(@Nonnull String name) {
        this(name, null, null, null);
    }

    /**
     * Used in {@link DbxTestTestRequests#testRouteV2(String,Date)}
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getBorn() {
        return born;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getBreed() {
        return breed;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIndoor() {
        return indoor;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name) {
        return new Builder(name);
    }

    /**
     * Builder for {@link Cat}.
     */
    public static class Builder {
        protected final String name;

        protected Date born;
        protected String breed;
        protected Boolean indoor;

        protected Builder(String name) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            this.born = null;
            this.breed = null;
            this.indoor = null;
        }

        /**
         * Set value for optional field.
         *
         * @return this builder
         */
        public Builder withBorn(Date born) {
            this.born = LangUtil.truncateMillis(born);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @return this builder
         */
        public Builder withBreed(String breed) {
            this.breed = breed;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @return this builder
         */
        public Builder withIndoor(Boolean indoor) {
            this.indoor = indoor;
            return this;
        }

        /**
         * Builds an instance of {@link Cat} configured with this builder's
         * values
         *
         * @return new instance of {@link Cat}
         */
        public Cat build() {
            return new Cat(name, born, breed, indoor);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.breed,
            this.indoor
        });
        hash = (31 * super.hashCode()) + hash;
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
            Cat other = (Cat) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.born == other.born) || (this.born != null && this.born.equals(other.born)))
                && ((this.breed == other.breed) || (this.breed != null && this.breed.equals(other.breed)))
                && ((this.indoor == other.indoor) || (this.indoor != null && this.indoor.equals(other.indoor)))
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
    static class Serializer extends StructSerializer<Cat> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Cat value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("cat", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (value.born != null) {
                g.writeFieldName("born");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.born, g);
            }
            if (value.breed != null) {
                g.writeFieldName("breed");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.breed, g);
            }
            if (value.indoor != null) {
                g.writeFieldName("indoor");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.indoor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Cat deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Cat value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("cat".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                Date f_born = null;
                String f_breed = null;
                Boolean f_indoor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("born".equals(field)) {
                        f_born = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("breed".equals(field)) {
                        f_breed = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("indoor".equals(field)) {
                        f_indoor = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                value = new Cat(f_name, f_born, f_breed, f_indoor);
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
