/* DO NOT EDIT */
/* This file was generated from common.stone */

package com.dropbox.core.v2.common;

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

/**
 * Information about current user's root.
 */
public class RootInfo {
    // struct common.RootInfo (common.stone)

    protected final String rootNamespaceId;
    protected final String homeNamespaceId;

    /**
     * Information about current user's root.
     *
     * @param rootNamespaceId  The namespace ID for user's root namespace. It
     *     will be the namespace ID of the shared team root if the user is
     *     member of a team with a separate team root. Otherwise it will be same
     *     as {@link RootInfo#getHomeNamespaceId}. Must match pattern "{@code
     *     [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param homeNamespaceId  The namespace ID for user's home namespace. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RootInfo(String rootNamespaceId, String homeNamespaceId) {
        if (rootNamespaceId == null) {
            throw new IllegalArgumentException("Required value for 'rootNamespaceId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", rootNamespaceId)) {
            throw new IllegalArgumentException("String 'rootNamespaceId' does not match pattern");
        }
        this.rootNamespaceId = rootNamespaceId;
        if (homeNamespaceId == null) {
            throw new IllegalArgumentException("Required value for 'homeNamespaceId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", homeNamespaceId)) {
            throw new IllegalArgumentException("String 'homeNamespaceId' does not match pattern");
        }
        this.homeNamespaceId = homeNamespaceId;
    }

    /**
     * The namespace ID for user's root namespace. It will be the namespace ID
     * of the shared team root if the user is member of a team with a separate
     * team root. Otherwise it will be same as {@link
     * RootInfo#getHomeNamespaceId}.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getRootNamespaceId() {
        return rootNamespaceId;
    }

    /**
     * The namespace ID for user's home namespace.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getHomeNamespaceId() {
        return homeNamespaceId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            rootNamespaceId,
            homeNamespaceId
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
            RootInfo other = (RootInfo) obj;
            return ((this.rootNamespaceId == other.rootNamespaceId) || (this.rootNamespaceId.equals(other.rootNamespaceId)))
                && ((this.homeNamespaceId == other.homeNamespaceId) || (this.homeNamespaceId.equals(other.homeNamespaceId)))
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
    public static class Serializer extends StructSerializer<RootInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RootInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (value instanceof TeamRootInfo) {
                TeamRootInfo.Serializer.INSTANCE.serialize((TeamRootInfo) value, g, collapse);
                return;
            }
            if (value instanceof UserRootInfo) {
                UserRootInfo.Serializer.INSTANCE.serialize((UserRootInfo) value, g, collapse);
                return;
            }
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("root_namespace_id");
            StoneSerializers.string().serialize(value.rootNamespaceId, g);
            g.writeFieldName("home_namespace_id");
            StoneSerializers.string().serialize(value.homeNamespaceId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RootInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RootInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_rootNamespaceId = null;
                String f_homeNamespaceId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("root_namespace_id".equals(field)) {
                        f_rootNamespaceId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("home_namespace_id".equals(field)) {
                        f_homeNamespaceId = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_rootNamespaceId == null) {
                    throw new JsonParseException(p, "Required field \"root_namespace_id\" missing.");
                }
                if (f_homeNamespaceId == null) {
                    throw new JsonParseException(p, "Required field \"home_namespace_id\" missing.");
                }
                value = new RootInfo(f_rootNamespaceId, f_homeNamespaceId);
            }
            else if ("".equals(tag)) {
                value = Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("team".equals(tag)) {
                value = TeamRootInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("user".equals(tag)) {
                value = UserRootInfo.Serializer.INSTANCE.deserialize(p, true);
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
