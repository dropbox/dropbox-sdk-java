/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class UpdateFolderPolicyError {
    // union UpdateFolderPolicyError

    /**
     * Discriminating tag type for {@link UpdateFolderPolicyError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * {@link UpdateFolderPolicyArg#getMemberPolicy} was set even though
         * user is not on a team.
         */
        NOT_ON_TEAM,
        /**
         * Team policy is more restrictive than {@link
         * ShareFolderArg#getMemberPolicy}.
         */
        TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
        /**
         * The current account is not allowed to select the specified {@link
         * ShareFolderArg#getSharedLinkPolicy}.
         */
        DISALLOWED_SHARED_LINK_POLICY,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("not_on_team", Tag.NOT_ON_TEAM);
        VALUES_.put("team_policy_disallows_member_policy", Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
        VALUES_.put("disallowed_shared_link_policy", Tag.DISALLOWED_SHARED_LINK_POLICY);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final UpdateFolderPolicyError NOT_ON_TEAM = new UpdateFolderPolicyError(Tag.NOT_ON_TEAM, null);
    public static final UpdateFolderPolicyError TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new UpdateFolderPolicyError(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY, null);
    public static final UpdateFolderPolicyError DISALLOWED_SHARED_LINK_POLICY = new UpdateFolderPolicyError(Tag.DISALLOWED_SHARED_LINK_POLICY, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code UpdateFolderPolicyError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code UpdateFolderPolicyError} that has its tag
     * set to {@link Tag#ACCESS_ERROR}.
     *
     * @param value  {@link UpdateFolderPolicyError#accessError} value to assign
     *     to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NOT_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isNotOnTeam() {
        return this.tag == Tag.NOT_ON_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     */
    public boolean isTeamPolicyDisallowsMemberPolicy() {
        return this.tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     */
    public boolean isDisallowedSharedLinkPolicy() {
        return this.tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UpdateFolderPolicyError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UpdateFolderPolicyError> _JSON_WRITER = new JsonWriter<UpdateFolderPolicyError>() {
        public final void write(UpdateFolderPolicyError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case NOT_ON_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_on_team");
                    g.writeEndObject();
                    break;
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_policy_disallows_member_policy");
                    g.writeEndObject();
                    break;
                case DISALLOWED_SHARED_LINK_POLICY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("disallowed_shared_link_policy");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<UpdateFolderPolicyError> _JSON_READER = new JsonReader<UpdateFolderPolicyError>() {

        public final UpdateFolderPolicyError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return UpdateFolderPolicyError.OTHER;
                }
                switch (tag) {
                    case NOT_ON_TEAM: return UpdateFolderPolicyError.NOT_ON_TEAM;
                    case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: return UpdateFolderPolicyError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
                    case DISALLOWED_SHARED_LINK_POLICY: return UpdateFolderPolicyError.DISALLOWED_SHARED_LINK_POLICY;
                    case OTHER: return UpdateFolderPolicyError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            UpdateFolderPolicyError value = null;
            if (tag != null) {
                switch (tag) {
                    case ACCESS_ERROR: {
                        SharedFolderAccessError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharedFolderAccessError._JSON_READER
                            .readField(parser, "access_error", v);
                        value = UpdateFolderPolicyError.accessError(v);
                        break;
                    }
                    case NOT_ON_TEAM: {
                        value = UpdateFolderPolicyError.NOT_ON_TEAM;
                        break;
                    }
                    case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: {
                        value = UpdateFolderPolicyError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
                        break;
                    }
                    case DISALLOWED_SHARED_LINK_POLICY: {
                        value = UpdateFolderPolicyError.DISALLOWED_SHARED_LINK_POLICY;
                        break;
                    }
                    case OTHER: {
                        value = UpdateFolderPolicyError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return UpdateFolderPolicyError.OTHER;
            }
            return value;
        }

    };
}
