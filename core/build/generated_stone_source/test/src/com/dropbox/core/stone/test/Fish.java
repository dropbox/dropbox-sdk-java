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

public class Fish extends Pet {
    // struct test.Fish (test.stone)

    @Nonnull
    protected final String species;
    @Nonnull
    protected final TankSize tankSize;

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param species  Must not be {@code null}.
     * @param tankSize  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Fish(@Nonnull String name, @Nonnull String species, @Nonnull TankSize tankSize, @Nullable Date born) {
        super(name, born);
        if (species == null) {
            throw new IllegalArgumentException("Required value for 'species' is null");
        }
        this.species = species;
        if (tankSize == null) {
            throw new IllegalArgumentException("Required value for 'tankSize' is null");
        }
        this.tankSize = tankSize;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param species  Must not be {@code null}.
     * @param tankSize  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Fish(@Nonnull String name, @Nonnull String species, @Nonnull TankSize tankSize) {
        this(name, species, tankSize, null);
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
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSpecies() {
        return species;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TankSize getTankSize() {
        return tankSize;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getBorn() {
        return born;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            species,
            tankSize
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
            Fish other = (Fish) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.species == other.species) || (this.species.equals(other.species)))
                && ((this.tankSize == other.tankSize) || (this.tankSize.equals(other.tankSize)))
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
    static class Serializer extends StructSerializer<Fish> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Fish value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("fish", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("species");
            StoneSerializers.string().serialize(value.species, g);
            g.writeFieldName("tank_size");
            TankSize.Serializer.INSTANCE.serialize(value.tankSize, g);
            if (value.born != null) {
                g.writeFieldName("born");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.born, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Fish deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Fish value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("fish".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                String f_species = null;
                TankSize f_tankSize = null;
                Date f_born = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("species".equals(field)) {
                        f_species = StoneSerializers.string().deserialize(p);
                    }
                    else if ("tank_size".equals(field)) {
                        f_tankSize = TankSize.Serializer.INSTANCE.deserialize(p);
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
                if (f_species == null) {
                    throw new JsonParseException(p, "Required field \"species\" missing.");
                }
                if (f_tankSize == null) {
                    throw new JsonParseException(p, "Required field \"tank_size\" missing.");
                }
                value = new Fish(f_name, f_species, f_tankSize, f_born);
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
