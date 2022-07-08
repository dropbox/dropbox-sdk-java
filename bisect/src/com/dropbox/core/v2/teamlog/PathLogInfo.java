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
 * Path's details.
 */
public class PathLogInfo {
    // struct team_log.PathLogInfo (team_log_generated.stone)

    protected final String contextual;
    protected final NamespaceRelativePathLogInfo namespaceRelative;

    /**
     * Path's details.
     *
     * @param namespaceRelative  Path relative to the namespace containing the
     *     content. Must not be {@code null}.
     * @param contextual  Fully qualified path relative to event's context.
     *     Might be missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PathLogInfo(NamespaceRelativePathLogInfo namespaceRelative, String contextual) {
        this.contextual = contextual;
        if (namespaceRelative == null) {
            throw new IllegalArgumentException("Required value for 'namespaceRelative' is null");
        }
        this.namespaceRelative = namespaceRelative;
    }

    /**
     * Path's details.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param namespaceRelative  Path relative to the namespace containing the
     *     content. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PathLogInfo(NamespaceRelativePathLogInfo namespaceRelative) {
        this(namespaceRelative, null);
    }

    /**
     * Path relative to the namespace containing the content.
     *
     * @return value for this field, never {@code null}.
     */
    public NamespaceRelativePathLogInfo getNamespaceRelative() {
        return namespaceRelative;
    }

    /**
     * Fully qualified path relative to event's context. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getContextual() {
        return contextual;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            contextual,
            namespaceRelative
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
            PathLogInfo other = (PathLogInfo) obj;
            return ((this.namespaceRelative == other.namespaceRelative) || (this.namespaceRelative.equals(other.namespaceRelative)))
                && ((this.contextual == other.contextual) || (this.contextual != null && this.contextual.equals(other.contextual)))
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
    static class Serializer extends StructSerializer<PathLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PathLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("namespace_relative");
            NamespaceRelativePathLogInfo.Serializer.INSTANCE.serialize(value.namespaceRelative, g);
            if (value.contextual != null) {
                g.writeFieldName("contextual");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.contextual, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PathLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PathLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                NamespaceRelativePathLogInfo f_namespaceRelative = null;
                String f_contextual = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("namespace_relative".equals(field)) {
                        f_namespaceRelative = NamespaceRelativePathLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("contextual".equals(field)) {
                        f_contextual = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_namespaceRelative == null) {
                    throw new JsonParseException(p, "Required field \"namespace_relative\" missing.");
                }
                value = new PathLogInfo(f_namespaceRelative, f_contextual);
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
