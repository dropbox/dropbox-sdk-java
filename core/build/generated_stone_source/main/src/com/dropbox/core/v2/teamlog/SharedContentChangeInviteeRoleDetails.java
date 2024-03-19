/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.sharing.AccessLevel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Changed access type of invitee to shared file/folder before invite was
 * accepted.
 */
public class SharedContentChangeInviteeRoleDetails {
    // struct team_log.SharedContentChangeInviteeRoleDetails (team_log_generated.stone)

    @Nullable
    protected final AccessLevel previousAccessLevel;
    @Nonnull
    protected final AccessLevel newAccessLevel;
    @Nonnull
    protected final String invitee;

    /**
     * Changed access type of invitee to shared file/folder before invite was
     * accepted.
     *
     * @param newAccessLevel  New access level. Must not be {@code null}.
     * @param invitee  The invitee whose role was changed. Must have length of
     *     at most 255 and not be {@code null}.
     * @param previousAccessLevel  Previous access level. Might be missing due
     *     to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedContentChangeInviteeRoleDetails(@Nonnull AccessLevel newAccessLevel, @Nonnull String invitee, @Nullable AccessLevel previousAccessLevel) {
        this.previousAccessLevel = previousAccessLevel;
        if (newAccessLevel == null) {
            throw new IllegalArgumentException("Required value for 'newAccessLevel' is null");
        }
        this.newAccessLevel = newAccessLevel;
        if (invitee == null) {
            throw new IllegalArgumentException("Required value for 'invitee' is null");
        }
        if (invitee.length() > 255) {
            throw new IllegalArgumentException("String 'invitee' is longer than 255");
        }
        this.invitee = invitee;
    }

    /**
     * Changed access type of invitee to shared file/folder before invite was
     * accepted.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newAccessLevel  New access level. Must not be {@code null}.
     * @param invitee  The invitee whose role was changed. Must have length of
     *     at most 255 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedContentChangeInviteeRoleDetails(@Nonnull AccessLevel newAccessLevel, @Nonnull String invitee) {
        this(newAccessLevel, invitee, null);
    }

    /**
     * New access level.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AccessLevel getNewAccessLevel() {
        return newAccessLevel;
    }

    /**
     * The invitee whose role was changed.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getInvitee() {
        return invitee;
    }

    /**
     * Previous access level. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AccessLevel getPreviousAccessLevel() {
        return previousAccessLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousAccessLevel,
            newAccessLevel,
            invitee
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
            SharedContentChangeInviteeRoleDetails other = (SharedContentChangeInviteeRoleDetails) obj;
            return ((this.newAccessLevel == other.newAccessLevel) || (this.newAccessLevel.equals(other.newAccessLevel)))
                && ((this.invitee == other.invitee) || (this.invitee.equals(other.invitee)))
                && ((this.previousAccessLevel == other.previousAccessLevel) || (this.previousAccessLevel != null && this.previousAccessLevel.equals(other.previousAccessLevel)))
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
    static class Serializer extends StructSerializer<SharedContentChangeInviteeRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentChangeInviteeRoleDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(value.newAccessLevel, g);
            g.writeFieldName("invitee");
            StoneSerializers.string().serialize(value.invitee, g);
            if (value.previousAccessLevel != null) {
                g.writeFieldName("previous_access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(value.previousAccessLevel, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentChangeInviteeRoleDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentChangeInviteeRoleDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_newAccessLevel = null;
                String f_invitee = null;
                AccessLevel f_previousAccessLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_access_level".equals(field)) {
                        f_newAccessLevel = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("invitee".equals(field)) {
                        f_invitee = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_access_level".equals(field)) {
                        f_previousAccessLevel = StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newAccessLevel == null) {
                    throw new JsonParseException(p, "Required field \"new_access_level\" missing.");
                }
                if (f_invitee == null) {
                    throw new JsonParseException(p, "Required field \"invitee\" missing.");
                }
                value = new SharedContentChangeInviteeRoleDetails(f_newAccessLevel, f_invitee, f_previousAccessLevel);
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
