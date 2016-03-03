/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
@JsonSerialize(using=UpdateFolderPolicyError.Serializer.class)
@JsonDeserialize(using=UpdateFolderPolicyError.Deserializer.class)
public final class UpdateFolderPolicyError {
    // union UpdateFolderPolicyError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link UpdateFolderPolicyError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * the {@code memberPolicy} argument to {@link
         * DbxUserSharingRequests#updateFolderPolicy(String)} was set even
         * though user is not on a team.
         */
        NOT_ON_TEAM,
        /**
         * Team policy is more restrictive than the {@code memberPolicy}
         * argument to {@link DbxUserSharingRequests#shareFolder(String)}.
         */
        TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
        /**
         * The current account is not allowed to select the specified the {@code
         * sharedLinkPolicy} argument to {@link
         * DbxUserSharingRequests#shareFolder(String)}.
         */
        DISALLOWED_SHARED_LINK_POLICY,
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * the {@code memberPolicy} argument to {@link
     * DbxUserSharingRequests#updateFolderPolicy(String)} was set even though
     * user is not on a team.
     */
    public static final UpdateFolderPolicyError NOT_ON_TEAM = new UpdateFolderPolicyError(Tag.NOT_ON_TEAM, null);
    /**
     * Team policy is more restrictive than the {@code memberPolicy} argument to
     * {@link DbxUserSharingRequests#shareFolder(String)}.
     */
    public static final UpdateFolderPolicyError TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new UpdateFolderPolicyError(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY, null);
    /**
     * The current account is not allowed to select the specified the {@code
     * sharedLinkPolicy} argument to {@link
     * DbxUserSharingRequests#shareFolder(String)}.
     */
    public static final UpdateFolderPolicyError DISALLOWED_SHARED_LINK_POLICY = new UpdateFolderPolicyError(Tag.DISALLOWED_SHARED_LINK_POLICY, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UpdateFolderPolicyError OTHER = new UpdateFolderPolicyError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UpdateFolderPolicyError(Tag tag, SharedFolderAccessError accessErrorValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UpdateFolderPolicyError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code UpdateFolderPolicyError} that has its tag
     * set to {@link Tag#ACCESS_ERROR}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UpdateFolderPolicyError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UpdateFolderPolicyError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderPolicyError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link UpdateFolderPolicyError#accessError} value associated
     *     with this instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this.tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NOT_ON_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NOT_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isNotOnTeam() {
        return this.tag == Tag.NOT_ON_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     */
    public boolean isTeamPolicyDisallowsMemberPolicy() {
        return this.tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     */
    public boolean isDisallowedSharedLinkPolicy() {
        return this.tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            accessErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UpdateFolderPolicyError) {
            UpdateFolderPolicyError other = (UpdateFolderPolicyError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case NOT_ON_TEAM:
                    return true;
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                    return true;
                case DISALLOWED_SHARED_LINK_POLICY:
                    return true;
                case OTHER:
                    return true;
                default:
                    return false;
            }
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

    static final class Serializer extends UnionJsonSerializer<UpdateFolderPolicyError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UpdateFolderPolicyError.class);
        }

        @Override
        public void serialize(UpdateFolderPolicyError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "access_error");
                    g.writeObjectField("access_error", value.accessErrorValue);
                    g.writeEndObject();
                    break;
                case NOT_ON_TEAM:
                    g.writeString("not_on_team");
                    break;
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                    g.writeString("team_policy_disallows_member_policy");
                    break;
                case DISALLOWED_SHARED_LINK_POLICY:
                    g.writeString("disallowed_shared_link_policy");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<UpdateFolderPolicyError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UpdateFolderPolicyError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public UpdateFolderPolicyError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ACCESS_ERROR: {
                    SharedFolderAccessError value = null;
                    expectField(_p, "access_error");
                    value = _p.readValueAs(SharedFolderAccessError.class);
                    _p.nextToken();
                    return UpdateFolderPolicyError.accessError(value);
                }
                case NOT_ON_TEAM: {
                    return UpdateFolderPolicyError.NOT_ON_TEAM;
                }
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: {
                    return UpdateFolderPolicyError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
                }
                case DISALLOWED_SHARED_LINK_POLICY: {
                    return UpdateFolderPolicyError.DISALLOWED_SHARED_LINK_POLICY;
                }
                case OTHER: {
                    return UpdateFolderPolicyError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, UpdateFolderPolicyError.Tag> getTagMapping() {
            Map<String, UpdateFolderPolicyError.Tag> values = new HashMap<String, UpdateFolderPolicyError.Tag>();
            values.put("access_error", UpdateFolderPolicyError.Tag.ACCESS_ERROR);
            values.put("not_on_team", UpdateFolderPolicyError.Tag.NOT_ON_TEAM);
            values.put("team_policy_disallows_member_policy", UpdateFolderPolicyError.Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
            values.put("disallowed_shared_link_policy", UpdateFolderPolicyError.Tag.DISALLOWED_SHARED_LINK_POLICY);
            values.put("other", UpdateFolderPolicyError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
