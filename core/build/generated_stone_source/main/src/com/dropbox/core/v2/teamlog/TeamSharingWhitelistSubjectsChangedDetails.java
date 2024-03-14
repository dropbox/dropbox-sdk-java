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
import java.util.List;

/**
 * Edited the approved list for sharing externally.
 */
public class TeamSharingWhitelistSubjectsChangedDetails {
    // struct team_log.TeamSharingWhitelistSubjectsChangedDetails (team_log_generated.stone)

    protected final List<String> addedWhitelistSubjects;
    protected final List<String> removedWhitelistSubjects;

    /**
     * Edited the approved list for sharing externally.
     *
     * @param addedWhitelistSubjects  Domains or emails added to the approved
     *     list for sharing externally. Must not contain a {@code null} item and
     *     not be {@code null}.
     * @param removedWhitelistSubjects  Domains or emails removed from the
     *     approved list for sharing externally. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamSharingWhitelistSubjectsChangedDetails(@javax.annotation.Nonnull List<String> addedWhitelistSubjects, @javax.annotation.Nonnull List<String> removedWhitelistSubjects) {
        if (addedWhitelistSubjects == null) {
            throw new IllegalArgumentException("Required value for 'addedWhitelistSubjects' is null");
        }
        for (String x : addedWhitelistSubjects) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'addedWhitelistSubjects' is null");
            }
        }
        this.addedWhitelistSubjects = addedWhitelistSubjects;
        if (removedWhitelistSubjects == null) {
            throw new IllegalArgumentException("Required value for 'removedWhitelistSubjects' is null");
        }
        for (String x : removedWhitelistSubjects) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'removedWhitelistSubjects' is null");
            }
        }
        this.removedWhitelistSubjects = removedWhitelistSubjects;
    }

    /**
     * Domains or emails added to the approved list for sharing externally.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<String> getAddedWhitelistSubjects() {
        return addedWhitelistSubjects;
    }

    /**
     * Domains or emails removed from the approved list for sharing externally.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<String> getRemovedWhitelistSubjects() {
        return removedWhitelistSubjects;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            addedWhitelistSubjects,
            removedWhitelistSubjects
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
            TeamSharingWhitelistSubjectsChangedDetails other = (TeamSharingWhitelistSubjectsChangedDetails) obj;
            return ((this.addedWhitelistSubjects == other.addedWhitelistSubjects) || (this.addedWhitelistSubjects.equals(other.addedWhitelistSubjects)))
                && ((this.removedWhitelistSubjects == other.removedWhitelistSubjects) || (this.removedWhitelistSubjects.equals(other.removedWhitelistSubjects)))
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
    static class Serializer extends StructSerializer<TeamSharingWhitelistSubjectsChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamSharingWhitelistSubjectsChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("added_whitelist_subjects");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.addedWhitelistSubjects, g);
            g.writeFieldName("removed_whitelist_subjects");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.removedWhitelistSubjects, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamSharingWhitelistSubjectsChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamSharingWhitelistSubjectsChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_addedWhitelistSubjects = null;
                List<String> f_removedWhitelistSubjects = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("added_whitelist_subjects".equals(field)) {
                        f_addedWhitelistSubjects = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("removed_whitelist_subjects".equals(field)) {
                        f_removedWhitelistSubjects = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_addedWhitelistSubjects == null) {
                    throw new JsonParseException(p, "Required field \"added_whitelist_subjects\" missing.");
                }
                if (f_removedWhitelistSubjects == null) {
                    throw new JsonParseException(p, "Required field \"removed_whitelist_subjects\" missing.");
                }
                value = new TeamSharingWhitelistSubjectsChangedDetails(f_addedWhitelistSubjects, f_removedWhitelistSubjects);
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
