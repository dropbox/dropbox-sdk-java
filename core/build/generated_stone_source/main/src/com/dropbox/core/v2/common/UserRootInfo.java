/* DO NOT EDIT */
/* This file was generated from common_common.stone */

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Root info when user is not member of a team or the user is a member of a team
 * and the team does not have a separate root namespace.
 */
public class UserRootInfo extends RootInfo {
    // struct common.UserRootInfo (common_common.stone)

    @Nullable
    protected final String homePath;

    /**
     * Root info when user is not member of a team or the user is a member of a
     * team and the team does not have a separate root namespace.
     *
     * @param rootNamespaceId  The namespace ID for user's root namespace. It
     *     will be the namespace ID of the shared team root if the user is
     *     member of a team with a separate team root, or the user root if user
     *     is member of a team with separate distinct roots for users. Otherwise
     *     it will be the same as {@link RootInfo#getHomeNamespaceId}. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param homeNamespaceId  The namespace ID for user's home namespace. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param homePath  The path for user's home directory under the distinct
     *     user root.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserRootInfo(@Nonnull String rootNamespaceId, @Nonnull String homeNamespaceId, @Nullable String homePath) {
        super(rootNamespaceId, homeNamespaceId);
        this.homePath = homePath;
    }

    /**
     * Root info when user is not member of a team or the user is a member of a
     * team and the team does not have a separate root namespace.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param rootNamespaceId  The namespace ID for user's root namespace. It
     *     will be the namespace ID of the shared team root if the user is
     *     member of a team with a separate team root, or the user root if user
     *     is member of a team with separate distinct roots for users. Otherwise
     *     it will be the same as {@link RootInfo#getHomeNamespaceId}. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param homeNamespaceId  The namespace ID for user's home namespace. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserRootInfo(@Nonnull String rootNamespaceId, @Nonnull String homeNamespaceId) {
        this(rootNamespaceId, homeNamespaceId, null);
    }

    /**
     * The namespace ID for user's root namespace. It will be the namespace ID
     * of the shared team root if the user is member of a team with a separate
     * team root, or the user root if user is member of a team with separate
     * distinct roots for users. Otherwise it will be the same as {@link
     * RootInfo#getHomeNamespaceId}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getRootNamespaceId() {
        return rootNamespaceId;
    }

    /**
     * The namespace ID for user's home namespace.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getHomeNamespaceId() {
        return homeNamespaceId;
    }

    /**
     * The path for user's home directory under the distinct user root.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getHomePath() {
        return homePath;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.homePath
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
            UserRootInfo other = (UserRootInfo) obj;
            return ((this.rootNamespaceId == other.rootNamespaceId) || (this.rootNamespaceId.equals(other.rootNamespaceId)))
                && ((this.homeNamespaceId == other.homeNamespaceId) || (this.homeNamespaceId.equals(other.homeNamespaceId)))
                && ((this.homePath == other.homePath) || (this.homePath != null && this.homePath.equals(other.homePath)))
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
    static class Serializer extends StructSerializer<UserRootInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserRootInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("user", g);
            g.writeFieldName("root_namespace_id");
            StoneSerializers.string().serialize(value.rootNamespaceId, g);
            g.writeFieldName("home_namespace_id");
            StoneSerializers.string().serialize(value.homeNamespaceId, g);
            if (value.homePath != null) {
                g.writeFieldName("home_path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.homePath, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserRootInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserRootInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("user".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_rootNamespaceId = null;
                String f_homeNamespaceId = null;
                String f_homePath = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("root_namespace_id".equals(field)) {
                        f_rootNamespaceId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("home_namespace_id".equals(field)) {
                        f_homeNamespaceId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("home_path".equals(field)) {
                        f_homePath = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new UserRootInfo(f_rootNamespaceId, f_homeNamespaceId, f_homePath);
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
