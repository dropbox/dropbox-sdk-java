/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

public class Dog extends Pet {
    // struct Dog

    protected final String breed;
    protected final DogSize size;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  Must not be {@code null}.
     * @param breed  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Dog(String name, String breed, Date born, DogSize size) {
        super(name, born);
        if (breed == null) {
            throw new IllegalArgumentException("Required value for 'breed' is null");
        }
        this.breed = breed;
        this.size = size;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param name  Must not be {@code null}.
     * @param breed  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Dog(String name, String breed) {
        this(name, breed, null, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getBreed() {
        return breed;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    public DogSize getSize() {
        return size;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  Must not be {@code null}.
     * @param breed  Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, String breed) {
        return new Builder(name, breed);
    }

    /**
     * Builder for {@link Dog}.
     */
    public static class Builder {
        protected final String name;
        protected final String breed;

        protected Date born;
        protected DogSize size;

        protected Builder(String name, String breed) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (breed == null) {
                throw new IllegalArgumentException("Required value for 'breed' is null");
            }
            this.breed = breed;
            this.born = null;
            this.size = null;
        }

        /**
         * Set value for optional field.
         *
         * @return this builder
         */
        public Builder withBorn(Date born) {
            this.born = com.dropbox.core.util.LangUtil.truncateMillis(born);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @return this builder
         */
        public Builder withSize(DogSize size) {
            this.size = size;
            return this;
        }

        /**
         * Builds an instance of {@link Dog} configured with this builder's
         * values
         *
         * @return new instance of {@link Dog}
         */
        public Dog build() {
            return new Dog(name, breed, born, size);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            breed,
            size
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            Dog other = (Dog) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.breed == other.breed) || (this.breed.equals(other.breed)))
                && ((this.born == other.born) || (this.born != null && this.born.equals(other.born)))
                && ((this.size == other.size) || (this.size != null && this.size.equals(other.size)))
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
    static final class Serializer extends StructSerializer<Dog> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Dog value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("dog", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("breed");
            StoneSerializers.string().serialize(value.breed, g);
            if (value.born != null) {
                g.writeFieldName("born");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.born, g);
            }
            if (value.size != null) {
                g.writeFieldName("size");
                StoneSerializers.nullable(DogSize.Serializer.INSTANCE).serialize(value.size, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Dog deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Dog value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("dog".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                String f_breed = null;
                Date f_born = null;
                DogSize f_size = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("breed".equals(field)) {
                        f_breed = StoneSerializers.string().deserialize(p);
                    }
                    else if ("born".equals(field)) {
                        f_born = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("size".equals(field)) {
                        f_size = StoneSerializers.nullable(DogSize.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_breed == null) {
                    throw new JsonParseException(p, "Required field \"breed\" missing.");
                }
                value = new Dog(f_name, f_breed, f_born, f_size);
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
