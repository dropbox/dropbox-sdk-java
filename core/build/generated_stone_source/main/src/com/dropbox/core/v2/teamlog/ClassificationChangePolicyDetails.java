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

/**
 * Changed classification policy for team.
 */
public class ClassificationChangePolicyDetails {
    // struct team_log.ClassificationChangePolicyDetails (team_log_generated.stone)

    protected final ClassificationPolicyEnumWrapper previousValue;
    protected final ClassificationPolicyEnumWrapper newValue;
    protected final ClassificationType classificationType;

    /**
     * Changed classification policy for team.
     *
     * @param previousValue  Previous classification policy. Must not be {@code
     *     null}.
     * @param newValue  New classification policy. Must not be {@code null}.
     * @param classificationType  Policy type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ClassificationChangePolicyDetails(ClassificationPolicyEnumWrapper previousValue, ClassificationPolicyEnumWrapper newValue, ClassificationType classificationType) {
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        if (classificationType == null) {
            throw new IllegalArgumentException("Required value for 'classificationType' is null");
        }
        this.classificationType = classificationType;
    }

    /**
     * Previous classification policy.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public ClassificationPolicyEnumWrapper getPreviousValue() {
        return previousValue;
    }

    /**
     * New classification policy.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public ClassificationPolicyEnumWrapper getNewValue() {
        return newValue;
    }

    /**
     * Policy type.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public ClassificationType getClassificationType() {
        return classificationType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousValue,
            newValue,
            classificationType
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
            ClassificationChangePolicyDetails other = (ClassificationChangePolicyDetails) obj;
            return ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.classificationType == other.classificationType) || (this.classificationType.equals(other.classificationType)))
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
    static class Serializer extends StructSerializer<ClassificationChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ClassificationChangePolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            ClassificationPolicyEnumWrapper.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            ClassificationPolicyEnumWrapper.Serializer.INSTANCE.serialize(value.newValue, g);
            g.writeFieldName("classification_type");
            ClassificationType.Serializer.INSTANCE.serialize(value.classificationType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ClassificationChangePolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ClassificationChangePolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                ClassificationPolicyEnumWrapper f_previousValue = null;
                ClassificationPolicyEnumWrapper f_newValue = null;
                ClassificationType f_classificationType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = ClassificationPolicyEnumWrapper.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = ClassificationPolicyEnumWrapper.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("classification_type".equals(field)) {
                        f_classificationType = ClassificationType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                if (f_classificationType == null) {
                    throw new JsonParseException(p, "Required field \"classification_type\" missing.");
                }
                value = new ClassificationChangePolicyDetails(f_previousValue, f_newValue, f_classificationType);
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
