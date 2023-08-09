/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Possible reasons the user is denied a permission.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class PermissionDeniedReason {
    // union sharing.PermissionDeniedReason (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link PermissionDeniedReason}.
     */
    public enum Tag {
        /**
         * User is not on the same team as the folder owner.
         */
        USER_NOT_SAME_TEAM_AS_OWNER,
        /**
         * User is prohibited by the owner from taking the action.
         */
        USER_NOT_ALLOWED_BY_OWNER,
        /**
         * Target is indirectly a member of the folder, for example by being
         * part of a group.
         */
        TARGET_IS_INDIRECT_MEMBER,
        /**
         * Target is the owner of the folder.
         */
        TARGET_IS_OWNER,
        /**
         * Target is the user itself.
         */
        TARGET_IS_SELF,
        /**
         * Target is not an active member of the team.
         */
        TARGET_NOT_ACTIVE,
        /**
         * Folder is team folder for a limited team.
         */
        FOLDER_IS_LIMITED_TEAM_FOLDER,
        /**
         * The content owner needs to be on a Dropbox team to perform this
         * action.
         */
        OWNER_NOT_ON_TEAM,
        /**
         * The user does not have permission to perform this action on the link.
         */
        PERMISSION_DENIED,
        /**
         * The user's team policy prevents performing this action on the link.
         */
        RESTRICTED_BY_TEAM,
        /**
         * The user's account type does not support this action.
         */
        USER_ACCOUNT_TYPE,
        /**
         * The user needs to be on a Dropbox team to perform this action.
         */
        USER_NOT_ON_TEAM,
        /**
         * Folder is inside of another shared folder.
         */
        FOLDER_IS_INSIDE_SHARED_FOLDER,
        /**
         * Policy cannot be changed due to restrictions from parent folder.
         */
        RESTRICTED_BY_PARENT_FOLDER,
        INSUFFICIENT_PLAN, // InsufficientPlan
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
     * User is not on the same team as the folder owner.
     */
    public static final PermissionDeniedReason USER_NOT_SAME_TEAM_AS_OWNER = new PermissionDeniedReason().withTag(Tag.USER_NOT_SAME_TEAM_AS_OWNER);
    /**
     * User is prohibited by the owner from taking the action.
     */
    public static final PermissionDeniedReason USER_NOT_ALLOWED_BY_OWNER = new PermissionDeniedReason().withTag(Tag.USER_NOT_ALLOWED_BY_OWNER);
    /**
     * Target is indirectly a member of the folder, for example by being part of
     * a group.
     */
    public static final PermissionDeniedReason TARGET_IS_INDIRECT_MEMBER = new PermissionDeniedReason().withTag(Tag.TARGET_IS_INDIRECT_MEMBER);
    /**
     * Target is the owner of the folder.
     */
    public static final PermissionDeniedReason TARGET_IS_OWNER = new PermissionDeniedReason().withTag(Tag.TARGET_IS_OWNER);
    /**
     * Target is the user itself.
     */
    public static final PermissionDeniedReason TARGET_IS_SELF = new PermissionDeniedReason().withTag(Tag.TARGET_IS_SELF);
    /**
     * Target is not an active member of the team.
     */
    public static final PermissionDeniedReason TARGET_NOT_ACTIVE = new PermissionDeniedReason().withTag(Tag.TARGET_NOT_ACTIVE);
    /**
     * Folder is team folder for a limited team.
     */
    public static final PermissionDeniedReason FOLDER_IS_LIMITED_TEAM_FOLDER = new PermissionDeniedReason().withTag(Tag.FOLDER_IS_LIMITED_TEAM_FOLDER);
    /**
     * The content owner needs to be on a Dropbox team to perform this action.
     */
    public static final PermissionDeniedReason OWNER_NOT_ON_TEAM = new PermissionDeniedReason().withTag(Tag.OWNER_NOT_ON_TEAM);
    /**
     * The user does not have permission to perform this action on the link.
     */
    public static final PermissionDeniedReason PERMISSION_DENIED = new PermissionDeniedReason().withTag(Tag.PERMISSION_DENIED);
    /**
     * The user's team policy prevents performing this action on the link.
     */
    public static final PermissionDeniedReason RESTRICTED_BY_TEAM = new PermissionDeniedReason().withTag(Tag.RESTRICTED_BY_TEAM);
    /**
     * The user's account type does not support this action.
     */
    public static final PermissionDeniedReason USER_ACCOUNT_TYPE = new PermissionDeniedReason().withTag(Tag.USER_ACCOUNT_TYPE);
    /**
     * The user needs to be on a Dropbox team to perform this action.
     */
    public static final PermissionDeniedReason USER_NOT_ON_TEAM = new PermissionDeniedReason().withTag(Tag.USER_NOT_ON_TEAM);
    /**
     * Folder is inside of another shared folder.
     */
    public static final PermissionDeniedReason FOLDER_IS_INSIDE_SHARED_FOLDER = new PermissionDeniedReason().withTag(Tag.FOLDER_IS_INSIDE_SHARED_FOLDER);
    /**
     * Policy cannot be changed due to restrictions from parent folder.
     */
    public static final PermissionDeniedReason RESTRICTED_BY_PARENT_FOLDER = new PermissionDeniedReason().withTag(Tag.RESTRICTED_BY_PARENT_FOLDER);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final PermissionDeniedReason OTHER = new PermissionDeniedReason().withTag(Tag.OTHER);

    private Tag _tag;
    private InsufficientPlan insufficientPlanValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private PermissionDeniedReason() {
    }


    /**
     * Possible reasons the user is denied a permission.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private PermissionDeniedReason withTag(Tag _tag) {
        PermissionDeniedReason result = new PermissionDeniedReason();
        result._tag = _tag;
        return result;
    }

    /**
     * Possible reasons the user is denied a permission.
     *
     * @param insufficientPlanValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private PermissionDeniedReason withTagAndInsufficientPlan(Tag _tag, InsufficientPlan insufficientPlanValue) {
        PermissionDeniedReason result = new PermissionDeniedReason();
        result._tag = _tag;
        result.insufficientPlanValue = insufficientPlanValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PermissionDeniedReason}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_NOT_SAME_TEAM_AS_OWNER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_NOT_SAME_TEAM_AS_OWNER}, {@code false} otherwise.
     */
    public boolean isUserNotSameTeamAsOwner() {
        return this._tag == Tag.USER_NOT_SAME_TEAM_AS_OWNER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_NOT_ALLOWED_BY_OWNER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_NOT_ALLOWED_BY_OWNER}, {@code false} otherwise.
     */
    public boolean isUserNotAllowedByOwner() {
        return this._tag == Tag.USER_NOT_ALLOWED_BY_OWNER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TARGET_IS_INDIRECT_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TARGET_IS_INDIRECT_MEMBER}, {@code false} otherwise.
     */
    public boolean isTargetIsIndirectMember() {
        return this._tag == Tag.TARGET_IS_INDIRECT_MEMBER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TARGET_IS_OWNER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TARGET_IS_OWNER}, {@code false} otherwise.
     */
    public boolean isTargetIsOwner() {
        return this._tag == Tag.TARGET_IS_OWNER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TARGET_IS_SELF}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TARGET_IS_SELF}, {@code false} otherwise.
     */
    public boolean isTargetIsSelf() {
        return this._tag == Tag.TARGET_IS_SELF;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TARGET_NOT_ACTIVE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TARGET_NOT_ACTIVE}, {@code false} otherwise.
     */
    public boolean isTargetNotActive() {
        return this._tag == Tag.TARGET_NOT_ACTIVE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FOLDER_IS_LIMITED_TEAM_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FOLDER_IS_LIMITED_TEAM_FOLDER}, {@code false} otherwise.
     */
    public boolean isFolderIsLimitedTeamFolder() {
        return this._tag == Tag.FOLDER_IS_LIMITED_TEAM_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#OWNER_NOT_ON_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#OWNER_NOT_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isOwnerNotOnTeam() {
        return this._tag == Tag.OWNER_NOT_ON_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PERMISSION_DENIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PERMISSION_DENIED}, {@code false} otherwise.
     */
    public boolean isPermissionDenied() {
        return this._tag == Tag.PERMISSION_DENIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#RESTRICTED_BY_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RESTRICTED_BY_TEAM}, {@code false} otherwise.
     */
    public boolean isRestrictedByTeam() {
        return this._tag == Tag.RESTRICTED_BY_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_ACCOUNT_TYPE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_ACCOUNT_TYPE}, {@code false} otherwise.
     */
    public boolean isUserAccountType() {
        return this._tag == Tag.USER_ACCOUNT_TYPE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_NOT_ON_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_NOT_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isUserNotOnTeam() {
        return this._tag == Tag.USER_NOT_ON_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FOLDER_IS_INSIDE_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FOLDER_IS_INSIDE_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isFolderIsInsideSharedFolder() {
        return this._tag == Tag.FOLDER_IS_INSIDE_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#RESTRICTED_BY_PARENT_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RESTRICTED_BY_PARENT_FOLDER}, {@code false} otherwise.
     */
    public boolean isRestrictedByParentFolder() {
        return this._tag == Tag.RESTRICTED_BY_PARENT_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     */
    public boolean isInsufficientPlan() {
        return this._tag == Tag.INSUFFICIENT_PLAN;
    }

    /**
     * Returns an instance of {@code PermissionDeniedReason} that has its tag
     * set to {@link Tag#INSUFFICIENT_PLAN}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PermissionDeniedReason} with its tag set to
     *     {@link Tag#INSUFFICIENT_PLAN}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PermissionDeniedReason insufficientPlan(InsufficientPlan value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PermissionDeniedReason().withTagAndInsufficientPlan(Tag.INSUFFICIENT_PLAN, value);
    }

    /**
     * This instance must be tagged as {@link Tag#INSUFFICIENT_PLAN}.
     *
     * @return The {@link InsufficientPlan} value associated with this instance
     *     if {@link #isInsufficientPlan} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInsufficientPlan} is {@code
     *     false}.
     */
    public InsufficientPlan getInsufficientPlanValue() {
        if (this._tag != Tag.INSUFFICIENT_PLAN) {
            throw new IllegalStateException("Invalid tag: required Tag.INSUFFICIENT_PLAN, but was Tag." + this._tag.name());
        }
        return insufficientPlanValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            insufficientPlanValue
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
        else if (obj instanceof PermissionDeniedReason) {
            PermissionDeniedReason other = (PermissionDeniedReason) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case USER_NOT_SAME_TEAM_AS_OWNER:
                    return true;
                case USER_NOT_ALLOWED_BY_OWNER:
                    return true;
                case TARGET_IS_INDIRECT_MEMBER:
                    return true;
                case TARGET_IS_OWNER:
                    return true;
                case TARGET_IS_SELF:
                    return true;
                case TARGET_NOT_ACTIVE:
                    return true;
                case FOLDER_IS_LIMITED_TEAM_FOLDER:
                    return true;
                case OWNER_NOT_ON_TEAM:
                    return true;
                case PERMISSION_DENIED:
                    return true;
                case RESTRICTED_BY_TEAM:
                    return true;
                case USER_ACCOUNT_TYPE:
                    return true;
                case USER_NOT_ON_TEAM:
                    return true;
                case FOLDER_IS_INSIDE_SHARED_FOLDER:
                    return true;
                case RESTRICTED_BY_PARENT_FOLDER:
                    return true;
                case INSUFFICIENT_PLAN:
                    return (this.insufficientPlanValue == other.insufficientPlanValue) || (this.insufficientPlanValue.equals(other.insufficientPlanValue));
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
    static class Serializer extends UnionSerializer<PermissionDeniedReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PermissionDeniedReason value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case USER_NOT_SAME_TEAM_AS_OWNER: {
                    g.writeString("user_not_same_team_as_owner");
                    break;
                }
                case USER_NOT_ALLOWED_BY_OWNER: {
                    g.writeString("user_not_allowed_by_owner");
                    break;
                }
                case TARGET_IS_INDIRECT_MEMBER: {
                    g.writeString("target_is_indirect_member");
                    break;
                }
                case TARGET_IS_OWNER: {
                    g.writeString("target_is_owner");
                    break;
                }
                case TARGET_IS_SELF: {
                    g.writeString("target_is_self");
                    break;
                }
                case TARGET_NOT_ACTIVE: {
                    g.writeString("target_not_active");
                    break;
                }
                case FOLDER_IS_LIMITED_TEAM_FOLDER: {
                    g.writeString("folder_is_limited_team_folder");
                    break;
                }
                case OWNER_NOT_ON_TEAM: {
                    g.writeString("owner_not_on_team");
                    break;
                }
                case PERMISSION_DENIED: {
                    g.writeString("permission_denied");
                    break;
                }
                case RESTRICTED_BY_TEAM: {
                    g.writeString("restricted_by_team");
                    break;
                }
                case USER_ACCOUNT_TYPE: {
                    g.writeString("user_account_type");
                    break;
                }
                case USER_NOT_ON_TEAM: {
                    g.writeString("user_not_on_team");
                    break;
                }
                case FOLDER_IS_INSIDE_SHARED_FOLDER: {
                    g.writeString("folder_is_inside_shared_folder");
                    break;
                }
                case RESTRICTED_BY_PARENT_FOLDER: {
                    g.writeString("restricted_by_parent_folder");
                    break;
                }
                case INSUFFICIENT_PLAN: {
                    g.writeStartObject();
                    writeTag("insufficient_plan", g);
                    InsufficientPlan.Serializer.INSTANCE.serialize(value.insufficientPlanValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PermissionDeniedReason deserialize(JsonParser p) throws IOException, JsonParseException {
            PermissionDeniedReason value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("user_not_same_team_as_owner".equals(tag)) {
                value = PermissionDeniedReason.USER_NOT_SAME_TEAM_AS_OWNER;
            }
            else if ("user_not_allowed_by_owner".equals(tag)) {
                value = PermissionDeniedReason.USER_NOT_ALLOWED_BY_OWNER;
            }
            else if ("target_is_indirect_member".equals(tag)) {
                value = PermissionDeniedReason.TARGET_IS_INDIRECT_MEMBER;
            }
            else if ("target_is_owner".equals(tag)) {
                value = PermissionDeniedReason.TARGET_IS_OWNER;
            }
            else if ("target_is_self".equals(tag)) {
                value = PermissionDeniedReason.TARGET_IS_SELF;
            }
            else if ("target_not_active".equals(tag)) {
                value = PermissionDeniedReason.TARGET_NOT_ACTIVE;
            }
            else if ("folder_is_limited_team_folder".equals(tag)) {
                value = PermissionDeniedReason.FOLDER_IS_LIMITED_TEAM_FOLDER;
            }
            else if ("owner_not_on_team".equals(tag)) {
                value = PermissionDeniedReason.OWNER_NOT_ON_TEAM;
            }
            else if ("permission_denied".equals(tag)) {
                value = PermissionDeniedReason.PERMISSION_DENIED;
            }
            else if ("restricted_by_team".equals(tag)) {
                value = PermissionDeniedReason.RESTRICTED_BY_TEAM;
            }
            else if ("user_account_type".equals(tag)) {
                value = PermissionDeniedReason.USER_ACCOUNT_TYPE;
            }
            else if ("user_not_on_team".equals(tag)) {
                value = PermissionDeniedReason.USER_NOT_ON_TEAM;
            }
            else if ("folder_is_inside_shared_folder".equals(tag)) {
                value = PermissionDeniedReason.FOLDER_IS_INSIDE_SHARED_FOLDER;
            }
            else if ("restricted_by_parent_folder".equals(tag)) {
                value = PermissionDeniedReason.RESTRICTED_BY_PARENT_FOLDER;
            }
            else if ("insufficient_plan".equals(tag)) {
                InsufficientPlan fieldValue = null;
                fieldValue = InsufficientPlan.Serializer.INSTANCE.deserialize(p, true);
                value = PermissionDeniedReason.insufficientPlan(fieldValue);
            }
            else {
                value = PermissionDeniedReason.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
