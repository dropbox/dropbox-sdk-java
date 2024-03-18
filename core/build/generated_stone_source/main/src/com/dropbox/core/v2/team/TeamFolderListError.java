/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

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

import javax.annotation.Nonnull;

public class TeamFolderListError {
    // struct team.TeamFolderListError (team_folders.stone)

    @Nonnull
    protected final TeamFolderAccessError accessError;

    /**
     *
     * @param accessError  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderListError(@Nonnull TeamFolderAccessError accessError) {
        if (accessError == null) {
            throw new IllegalArgumentException("Required value for 'accessError' is null");
        }
        this.accessError = accessError;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TeamFolderAccessError getAccessError() {
        return accessError;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            accessError
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
            TeamFolderListError other = (TeamFolderListError) obj;
            return (this.accessError == other.accessError) || (this.accessError.equals(other.accessError));
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
    static class Serializer extends StructSerializer<TeamFolderListError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderListError value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_error");
            TeamFolderAccessError.Serializer.INSTANCE.serialize(value.accessError, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderListError deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderListError value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamFolderAccessError f_accessError = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_error".equals(field)) {
                        f_accessError = TeamFolderAccessError.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accessError == null) {
                    throw new JsonParseException(p, "Required field \"access_error\" missing.");
                }
                value = new TeamFolderListError(f_accessError);
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
