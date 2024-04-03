/* DO NOT EDIT */
/* This file was generated from team_namespaces.stone */

package com.dropbox.core.v2.team;

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
import java.util.List;

import javax.annotation.Nonnull;

/**
 * Result for {@link DbxTeamTeamRequests#namespacesList(long)}.
 */
public class TeamNamespacesListResult {
    // struct team.TeamNamespacesListResult (team_namespaces.stone)

    @Nonnull
    protected final List<NamespaceMetadata> namespaces;
    @Nonnull
    protected final String cursor;
    protected final boolean hasMore;

    /**
     * Result for {@link DbxTeamTeamRequests#namespacesList(long)}.
     *
     * @param namespaces  List of all namespaces the team can access. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#namespacesListContinue(String)} to obtain
     *     additional namespaces. Note that duplicate namespaces may be
     *     returned. Must not be {@code null}.
     * @param hasMore  Is true if there are additional namespaces that have not
     *     been returned yet.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamNamespacesListResult(@Nonnull List<NamespaceMetadata> namespaces, @Nonnull String cursor, boolean hasMore) {
        if (namespaces == null) {
            throw new IllegalArgumentException("Required value for 'namespaces' is null");
        }
        for (NamespaceMetadata x : namespaces) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'namespaces' is null");
            }
        }
        this.namespaces = namespaces;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * List of all namespaces the team can access.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<NamespaceMetadata> getNamespaces() {
        return namespaces;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#namespacesListContinue(String)} to obtain additional
     * namespaces. Note that duplicate namespaces may be returned.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there are additional namespaces that have not been returned
     * yet.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.namespaces,
            this.cursor,
            this.hasMore
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
            TeamNamespacesListResult other = (TeamNamespacesListResult) obj;
            return ((this.namespaces == other.namespaces) || (this.namespaces.equals(other.namespaces)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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
    static class Serializer extends StructSerializer<TeamNamespacesListResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamNamespacesListResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("namespaces");
            StoneSerializers.list(NamespaceMetadata.Serializer.INSTANCE).serialize(value.namespaces, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamNamespacesListResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamNamespacesListResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<NamespaceMetadata> f_namespaces = null;
                String f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("namespaces".equals(field)) {
                        f_namespaces = StoneSerializers.list(NamespaceMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_namespaces == null) {
                    throw new JsonParseException(p, "Required field \"namespaces\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new TeamNamespacesListResult(f_namespaces, f_cursor, f_hasMore);
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
