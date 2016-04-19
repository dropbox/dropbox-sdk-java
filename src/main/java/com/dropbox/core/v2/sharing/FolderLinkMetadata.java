/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

/**
 * The metadata of a folder shared link
 */
@JsonSerialize(using=FolderLinkMetadata.Serializer.class)
@JsonDeserialize(using=FolderLinkMetadata.Deserializer.class)
public class FolderLinkMetadata extends SharedLinkMetadata {
    // struct FolderLinkMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();


    /**
     * The metadata of a folder shared link
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     * @param id  A unique identifier for the linked file. Must have length of
     *     at least 1.
     * @param expires  Expiration time, if set. By default the link won't
     *     expire.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. This field will only be present only if
     *     the linked file is in the authenticated user's  dropbox.
     * @param teamMemberInfo  The team membership information of the link's
     *     owner.  This field will only be present  if the link's owner is a
     *     team member.
     * @param contentOwnerTeamInfo  The team information of the content's owner.
     *     This field will only be present if the content's owner is a team
     *     member and the content's owner team is different from the link's
     *     owner team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderLinkMetadata(String url, String name, LinkPermissions linkPermissions, String id, Date expires, String pathLower, TeamMemberInfo teamMemberInfo, Team contentOwnerTeamInfo) {
        super(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
    }

    /**
     * The metadata of a folder shared link
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderLinkMetadata(String url, String name, LinkPermissions linkPermissions) {
        this(url, name, linkPermissions, null, null, null, null, null);
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param name  The linked file name (including extension). This never
     *     contains a slash. Must not be {@code null}.
     * @param linkPermissions  The link's access permissions. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String url, String name, LinkPermissions linkPermissions) {
        return new Builder(url, name, linkPermissions);
    }

    /**
     * Builder for {@link FolderLinkMetadata}.
     */
    public static class Builder extends SharedLinkMetadata.Builder {

        protected Builder(String url, String name, LinkPermissions linkPermissions) {
            super(url, name, linkPermissions);
        }

        /**
         * Builds an instance of {@link FolderLinkMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderLinkMetadata}
         */
        public FolderLinkMetadata build() {
            return new FolderLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            FolderLinkMetadata other = (FolderLinkMetadata) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.linkPermissions == other.linkPermissions) || (this.linkPermissions.equals(other.linkPermissions)))
                && ((this.id == other.id) || (this.id != null && this.id.equals(other.id)))
                && ((this.expires == other.expires) || (this.expires != null && this.expires.equals(other.expires)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.teamMemberInfo == other.teamMemberInfo) || (this.teamMemberInfo != null && this.teamMemberInfo.equals(other.teamMemberInfo)))
                && ((this.contentOwnerTeamInfo == other.contentOwnerTeamInfo) || (this.contentOwnerTeamInfo != null && this.contentOwnerTeamInfo.equals(other.contentOwnerTeamInfo)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<FolderLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FolderLinkMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(FolderLinkMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(FolderLinkMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeStringField(".tag", "folder");
            g.writeObjectField("url", value.url);
            g.writeObjectField("name", value.name);
            g.writeObjectField("link_permissions", value.linkPermissions);
            if (value.id != null) {
                g.writeObjectField("id", value.id);
            }
            if (value.expires != null) {
                g.writeObjectField("expires", value.expires);
            }
            if (value.pathLower != null) {
                g.writeObjectField("path_lower", value.pathLower);
            }
            if (value.teamMemberInfo != null) {
                g.writeObjectField("team_member_info", value.teamMemberInfo);
            }
            if (value.contentOwnerTeamInfo != null) {
                g.writeObjectField("content_owner_team_info", value.contentOwnerTeamInfo);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<FolderLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FolderLinkMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(FolderLinkMetadata.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<FolderLinkMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public FolderLinkMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p, "folder");

            String url = null;
            String name = null;
            LinkPermissions linkPermissions = null;
            String id = null;
            Date expires = null;
            String pathLower = null;
            TeamMemberInfo teamMemberInfo = null;
            Team contentOwnerTeamInfo = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("url".equals(_field)) {
                    url = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("link_permissions".equals(_field)) {
                    linkPermissions = _p.readValueAs(LinkPermissions.class);
                    _p.nextToken();
                }
                else if ("id".equals(_field)) {
                    id = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("expires".equals(_field)) {
                    expires = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("path_lower".equals(_field)) {
                    pathLower = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("team_member_info".equals(_field)) {
                    teamMemberInfo = _p.readValueAs(TeamMemberInfo.class);
                    _p.nextToken();
                }
                else if ("content_owner_team_info".equals(_field)) {
                    contentOwnerTeamInfo = _p.readValueAs(Team.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (url == null) {
                throw new JsonParseException(_p, "Required field \"url\" is missing.");
            }
            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (linkPermissions == null) {
                throw new JsonParseException(_p, "Required field \"link_permissions\" is missing.");
            }

            return new FolderLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
    }
}
