/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teampolicies.OfficeAddInPolicy;
import com.dropbox.core.v2.teampolicies.TeamSharingPolicies;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Detailed information about a team.
 */
public class FullTeam extends Team {
    // struct users.FullTeam (users.stone)

    protected final TeamSharingPolicies sharingPolicies;
    protected final OfficeAddInPolicy officeAddinPolicy;

    /**
     * Detailed information about a team.
     *
     * @param id  The team's unique ID. Must not be {@code null}.
     * @param name  The name of the team. Must not be {@code null}.
     * @param sharingPolicies  Team policies governing sharing. Must not be
     *     {@code null}.
     * @param officeAddinPolicy  Team policy governing the use of the Office
     *     Add-In. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FullTeam(String id, String name, TeamSharingPolicies sharingPolicies, OfficeAddInPolicy officeAddinPolicy) {
        super(id, name);
        if (sharingPolicies == null) {
            throw new IllegalArgumentException("Required value for 'sharingPolicies' is null");
        }
        this.sharingPolicies = sharingPolicies;
        if (officeAddinPolicy == null) {
            throw new IllegalArgumentException("Required value for 'officeAddinPolicy' is null");
        }
        this.officeAddinPolicy = officeAddinPolicy;
    }

    /**
     * The team's unique ID.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * The name of the team.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * Team policies governing sharing.
     *
     * @return value for this field, never {@code null}.
     */
    public TeamSharingPolicies getSharingPolicies() {
        return sharingPolicies;
    }

    /**
     * Team policy governing the use of the Office Add-In.
     *
     * @return value for this field, never {@code null}.
     */
    public OfficeAddInPolicy getOfficeAddinPolicy() {
        return officeAddinPolicy;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharingPolicies,
            officeAddinPolicy
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
            FullTeam other = (FullTeam) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.sharingPolicies == other.sharingPolicies) || (this.sharingPolicies.equals(other.sharingPolicies)))
                && ((this.officeAddinPolicy == other.officeAddinPolicy) || (this.officeAddinPolicy.equals(other.officeAddinPolicy)))
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
    static class Serializer extends StructSerializer<FullTeam> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FullTeam value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("sharing_policies");
            TeamSharingPolicies.Serializer.INSTANCE.serialize(value.sharingPolicies, g);
            g.writeFieldName("office_addin_policy");
            OfficeAddInPolicy.Serializer.INSTANCE.serialize(value.officeAddinPolicy, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FullTeam deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FullTeam value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_name = null;
                TeamSharingPolicies f_sharingPolicies = null;
                OfficeAddInPolicy f_officeAddinPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sharing_policies".equals(field)) {
                        f_sharingPolicies = TeamSharingPolicies.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("office_addin_policy".equals(field)) {
                        f_officeAddinPolicy = OfficeAddInPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_sharingPolicies == null) {
                    throw new JsonParseException(p, "Required field \"sharing_policies\" missing.");
                }
                if (f_officeAddinPolicy == null) {
                    throw new JsonParseException(p, "Required field \"office_addin_policy\" missing.");
                }
                value = new FullTeam(f_id, f_name, f_sharingPolicies, f_officeAddinPolicy);
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
