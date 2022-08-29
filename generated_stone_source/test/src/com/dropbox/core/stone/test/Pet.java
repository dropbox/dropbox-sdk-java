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

public class Pet {
    // struct test.Pet (test.stone)

    protected final String name;
    protected final Date born;

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Pet(String name, Date born) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.born = LangUtil.truncateMillis(born);
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
    public Pet(String name) {
        this(name, null);
    }

    /**
     * Used in {@link DbxTestTestRequests#testRouteV2(String,Date)}
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getBorn() {
        return born;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            name,
            born
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
            Pet other = (Pet) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.born == other.born) || (this.born != null && this.born.equals(other.born)))
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
    static class Serializer extends StructSerializer<Pet> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Pet value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (value instanceof Dog) {
                Dog.Serializer.INSTANCE.serialize((Dog) value, g, collapse);
                return;
            }
            if (value instanceof Cat) {
                Cat.Serializer.INSTANCE.serialize((Cat) value, g, collapse);
                return;
            }
            if (value instanceof Fish) {
                Fish.Serializer.INSTANCE.serialize((Fish) value, g, collapse);
                return;
            }
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (value.born != null) {
                g.writeFieldName("born");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.born, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Pet deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Pet value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                Date f_born = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("born".equals(field)) {
                        f_born = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                value = new Pet(f_name, f_born);
            }
            else if ("".equals(tag)) {
                value = Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("dog".equals(tag)) {
                value = Dog.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("cat".equals(tag)) {
                value = Cat.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("fish".equals(tag)) {
                value = Fish.Serializer.INSTANCE.deserialize(p, true);
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
