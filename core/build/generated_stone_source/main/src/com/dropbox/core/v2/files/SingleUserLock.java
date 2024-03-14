/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

public class SingleUserLock {
    // struct files.SingleUserLock (files.stone)

    protected final Date created;
    protected final String lockHolderAccountId;
    protected final String lockHolderTeamId;

    /**
     *
     * @param created  The time the lock was created. Must not be {@code null}.
     * @param lockHolderAccountId  The account ID of the lock holder if known.
     *     Must have length of at least 40, have length of at most 40, and not
     *     be {@code null}.
     * @param lockHolderTeamId  The id of the team of the account holder if it
     *     exists.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SingleUserLock(@javax.annotation.Nonnull Date created, @javax.annotation.Nonnull String lockHolderAccountId, @javax.annotation.Nullable String lockHolderTeamId) {
        if (created == null) {
            throw new IllegalArgumentException("Required value for 'created' is null");
        }
        this.created = LangUtil.truncateMillis(created);
        if (lockHolderAccountId == null) {
            throw new IllegalArgumentException("Required value for 'lockHolderAccountId' is null");
        }
        if (lockHolderAccountId.length() < 40) {
            throw new IllegalArgumentException("String 'lockHolderAccountId' is shorter than 40");
        }
        if (lockHolderAccountId.length() > 40) {
            throw new IllegalArgumentException("String 'lockHolderAccountId' is longer than 40");
        }
        this.lockHolderAccountId = lockHolderAccountId;
        this.lockHolderTeamId = lockHolderTeamId;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param created  The time the lock was created. Must not be {@code null}.
     * @param lockHolderAccountId  The account ID of the lock holder if known.
     *     Must have length of at least 40, have length of at most 40, and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SingleUserLock(Date created, String lockHolderAccountId) {
        this(created, lockHolderAccountId, null);
    }

    /**
     * The time the lock was created.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public Date getCreated() {
        return created;
    }

    /**
     * The account ID of the lock holder if known.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getLockHolderAccountId() {
        return lockHolderAccountId;
    }

    /**
     * The id of the team of the account holder if it exists.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getLockHolderTeamId() {
        return lockHolderTeamId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            created,
            lockHolderAccountId,
            lockHolderTeamId
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
            SingleUserLock other = (SingleUserLock) obj;
            return ((this.created == other.created) || (this.created.equals(other.created)))
                && ((this.lockHolderAccountId == other.lockHolderAccountId) || (this.lockHolderAccountId.equals(other.lockHolderAccountId)))
                && ((this.lockHolderTeamId == other.lockHolderTeamId) || (this.lockHolderTeamId != null && this.lockHolderTeamId.equals(other.lockHolderTeamId)))
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
    static class Serializer extends StructSerializer<SingleUserLock> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SingleUserLock value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("created");
            StoneSerializers.timestamp().serialize(value.created, g);
            g.writeFieldName("lock_holder_account_id");
            StoneSerializers.string().serialize(value.lockHolderAccountId, g);
            if (value.lockHolderTeamId != null) {
                g.writeFieldName("lock_holder_team_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.lockHolderTeamId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SingleUserLock deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SingleUserLock value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_created = null;
                String f_lockHolderAccountId = null;
                String f_lockHolderTeamId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("created".equals(field)) {
                        f_created = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("lock_holder_account_id".equals(field)) {
                        f_lockHolderAccountId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("lock_holder_team_id".equals(field)) {
                        f_lockHolderTeamId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_created == null) {
                    throw new JsonParseException(p, "Required field \"created\" missing.");
                }
                if (f_lockHolderAccountId == null) {
                    throw new JsonParseException(p, "Required field \"lock_holder_account_id\" missing.");
                }
                value = new SingleUserLock(f_created, f_lockHolderAccountId, f_lockHolderTeamId);
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
