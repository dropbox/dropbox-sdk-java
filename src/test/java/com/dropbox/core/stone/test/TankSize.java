/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

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
public final class TankSize {
    // union TankSize

    /**
     * Discriminating tag type for {@link TankSize}.
     */
    public enum Tag {
        BOWL,
        MEDIUM, // Dimensions
        AQUARIUM, // String
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

    public static final TankSize BOWL = new TankSize(Tag.BOWL, null, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final TankSize OTHER = new TankSize(Tag.OTHER, null, null);

    private final Tag tag;
    private final Dimensions mediumValue;
    private final String aquariumValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private TankSize(Tag tag, Dimensions mediumValue, String aquariumValue) {
        this.tag = tag;
        this.mediumValue = mediumValue;
        this.aquariumValue = aquariumValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TankSize}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#BOWL},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#BOWL},
     *     {@code false} otherwise.
     */
    public boolean isBowl() {
        return this.tag == Tag.BOWL;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#MEDIUM},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#MEDIUM},
     *     {@code false} otherwise.
     */
    public boolean isMedium() {
        return this.tag == Tag.MEDIUM;
    }

    /**
     * Returns an instance of {@code TankSize} that has its tag set to {@link
     * Tag#MEDIUM}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TankSize} with its tag set to {@link
     *     Tag#MEDIUM}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TankSize medium(Dimensions value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TankSize(Tag.MEDIUM, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#MEDIUM}.
     *
     * @return The {@link TankSize#medium} value associated with this instance
     *     if {@link #isMedium} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMedium} is {@code false}.
     */
    public Dimensions getMediumValue() {
        if (this.tag != Tag.MEDIUM) {
            throw new IllegalStateException("Invalid tag: required Tag.MEDIUM, but was Tag." + tag.name());
        }
        return mediumValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#AQUARIUM},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#AQUARIUM},
     *     {@code false} otherwise.
     */
    public boolean isAquarium() {
        return this.tag == Tag.AQUARIUM;
    }

    /**
     * Returns an instance of {@code TankSize} that has its tag set to {@link
     * Tag#AQUARIUM}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TankSize} with its tag set to {@link
     *     Tag#AQUARIUM}.
     */
    public static TankSize aquarium(String value) {
        return new TankSize(Tag.AQUARIUM, null, value);
    }

    /**
     * Returns an instance of {@code TankSize} that has its tag set to {@link
     * Tag#AQUARIUM}.
     *
     * @return Instance of {@code TankSize} with its tag set to {@link
     *     Tag#AQUARIUM}.
     */
    public static TankSize aquarium() {
        return aquarium(null);
    }

    /**
     * This instance must be tagged as {@link Tag#AQUARIUM}.
     *
     * @return The {@link TankSize#aquarium} value associated with this instance
     *     if {@link #isAquarium} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAquarium} is {@code false}.
     */
    public String getAquariumValue() {
        if (this.tag != Tag.AQUARIUM) {
            throw new IllegalStateException("Invalid tag: required Tag.AQUARIUM, but was Tag." + tag.name());
        }
        return aquariumValue;
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
            mediumValue,
            aquariumValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof TankSize) {
            TankSize other = (TankSize) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case BOWL:
                    return true;
                case MEDIUM:
                    return (this.mediumValue == other.mediumValue) || (this.mediumValue.equals(other.mediumValue));
                case AQUARIUM:
                    return (this.aquariumValue == other.aquariumValue) || (this.aquariumValue != null && this.aquariumValue.equals(other.aquariumValue));
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
    static final class Serializer extends UnionSerializer<TankSize> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TankSize value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case BOWL: {
                    g.writeString("bowl");
                    break;
                }
                case MEDIUM: {
                    g.writeStartObject();
                    writeTag("medium", g);
                    Dimensions.Serializer.INSTANCE.serialize(value.mediumValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case AQUARIUM: {
                    g.writeStartObject();
                    writeTag("aquarium", g);
                    g.writeFieldName("aquarium");
                    StoneSerializers.nullable(StoneSerializers.string()).serialize(value.aquariumValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TankSize deserialize(JsonParser p) throws IOException, JsonParseException {
            TankSize value;
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
            else if ("bowl".equals(tag)) {
                value = TankSize.BOWL;
            }
            else if ("medium".equals(tag)) {
                Dimensions fieldValue = null;
                fieldValue = Dimensions.Serializer.INSTANCE.deserialize(p, true);
                value = TankSize.medium(fieldValue);
            }
            else if ("aquarium".equals(tag)) {
                String fieldValue = null;
                if (p.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("aquarium", p);
                    fieldValue = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                }
                if (fieldValue == null) {
                    value = TankSize.aquarium();
                }
                else {
                    value = TankSize.aquarium(fieldValue);
                }
            }
            else {
                value = TankSize.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
