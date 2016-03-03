/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

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
 * Describes the result of attempting to add a single user to the team.
 * 'success' is the only value indicating that a user was indeed added to the
 * team - the other values explain the type of failure that occurred, and
 * include the email of the user for which the operation has failed.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=MemberAddResult.Serializer.class)
@JsonDeserialize(using=MemberAddResult.Deserializer.class)
public final class MemberAddResult {
    // union MemberAddResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link MemberAddResult}.
     */
    public enum Tag {
        /**
         * Describes a user that was successfully added to the team.
         */
        SUCCESS, // TeamMemberInfo
        /**
         * Team is already full. The organization has no available licenses.
         */
        TEAM_LICENSE_LIMIT, // String
        /**
         * Team is already full. The free team member limit has been reached.
         */
        FREE_TEAM_MEMBER_LIMIT_REACHED, // String
        /**
         * User is already on this team. The provided email address is
         * associated with a user who is already a member of or invited to the
         * team.
         */
        USER_ALREADY_ON_TEAM, // String
        /**
         * User is already on another team. The provided email address is
         * associated with a user that is already a member or invited to another
         * team.
         */
        USER_ON_ANOTHER_TEAM, // String
        /**
         * User is already paired.
         */
        USER_ALREADY_PAIRED, // String
        /**
         * User migration has failed.
         */
        USER_MIGRATION_FAILED, // String
        /**
         * A user with the given external member ID already exists on the team.
         */
        DUPLICATE_EXTERNAL_MEMBER_ID, // String
        /**
         * User creation has failed.
         */
        USER_CREATION_FAILED; // String
    }

    private final Tag tag;
    private final TeamMemberInfo successValue;
    private final String teamLicenseLimitValue;
    private final String freeTeamMemberLimitReachedValue;
    private final String userAlreadyOnTeamValue;
    private final String userOnAnotherTeamValue;
    private final String userAlreadyPairedValue;
    private final String userMigrationFailedValue;
    private final String duplicateExternalMemberIdValue;
    private final String userCreationFailedValue;

    /**
     * Describes the result of attempting to add a single user to the team.
     * 'success' is the only value indicating that a user was indeed added to
     * the team - the other values explain the type of failure that occurred,
     * and include the email of the user for which the operation has failed.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MemberAddResult(Tag tag, TeamMemberInfo successValue, String teamLicenseLimitValue, String freeTeamMemberLimitReachedValue, String userAlreadyOnTeamValue, String userOnAnotherTeamValue, String userAlreadyPairedValue, String userMigrationFailedValue, String duplicateExternalMemberIdValue, String userCreationFailedValue) {
        this.tag = tag;
        this.successValue = successValue;
        this.teamLicenseLimitValue = teamLicenseLimitValue;
        this.freeTeamMemberLimitReachedValue = freeTeamMemberLimitReachedValue;
        this.userAlreadyOnTeamValue = userAlreadyOnTeamValue;
        this.userOnAnotherTeamValue = userOnAnotherTeamValue;
        this.userAlreadyPairedValue = userAlreadyPairedValue;
        this.userMigrationFailedValue = userMigrationFailedValue;
        this.duplicateExternalMemberIdValue = duplicateExternalMemberIdValue;
        this.userCreationFailedValue = userCreationFailedValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MemberAddResult}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#SUCCESS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#SUCCESS},
     *     {@code false} otherwise.
     */
    public boolean isSuccess() {
        return this.tag == Tag.SUCCESS;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#SUCCESS}.
     *
     * <p> Describes a user that was successfully added to the team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#SUCCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MemberAddResult success(TeamMemberInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MemberAddResult(Tag.SUCCESS, value, null, null, null, null, null, null, null, null);
    }

    /**
     * Describes a user that was successfully added to the team.
     *
     * <p> This instance must be tagged as {@link Tag#SUCCESS}. </p>
     *
     * @return The {@link MemberAddResult#success} value associated with this
     *     instance if {@link #isSuccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSuccess} is {@code false}.
     */
    public TeamMemberInfo getSuccessValue() {
        if (this.tag != Tag.SUCCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.SUCCESS, but was Tag." + tag.name());
        }
        return successValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_LICENSE_LIMIT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_LICENSE_LIMIT}, {@code false} otherwise.
     */
    public boolean isTeamLicenseLimit() {
        return this.tag == Tag.TEAM_LICENSE_LIMIT;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#TEAM_LICENSE_LIMIT}.
     *
     * <p> Team is already full. The organization has no available licenses.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#TEAM_LICENSE_LIMIT}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult teamLicenseLimit(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.TEAM_LICENSE_LIMIT, null, value, null, null, null, null, null, null, null);
    }

    /**
     * Team is already full. The organization has no available licenses.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM_LICENSE_LIMIT}. </p>
     *
     * @return The {@link MemberAddResult#teamLicenseLimit} value associated
     *     with this instance if {@link #isTeamLicenseLimit} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamLicenseLimit} is {@code
     *     false}.
     */
    public String getTeamLicenseLimitValue() {
        if (this.tag != Tag.TEAM_LICENSE_LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_LICENSE_LIMIT, but was Tag." + tag.name());
        }
        return teamLicenseLimitValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FREE_TEAM_MEMBER_LIMIT_REACHED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FREE_TEAM_MEMBER_LIMIT_REACHED}, {@code false} otherwise.
     */
    public boolean isFreeTeamMemberLimitReached() {
        return this.tag == Tag.FREE_TEAM_MEMBER_LIMIT_REACHED;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#FREE_TEAM_MEMBER_LIMIT_REACHED}.
     *
     * <p> Team is already full. The free team member limit has been reached.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#FREE_TEAM_MEMBER_LIMIT_REACHED}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult freeTeamMemberLimitReached(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.FREE_TEAM_MEMBER_LIMIT_REACHED, null, null, value, null, null, null, null, null, null);
    }

    /**
     * Team is already full. The free team member limit has been reached.
     *
     * <p> This instance must be tagged as {@link
     * Tag#FREE_TEAM_MEMBER_LIMIT_REACHED}. </p>
     *
     * @return The {@link MemberAddResult#freeTeamMemberLimitReached} value
     *     associated with this instance if {@link
     *     #isFreeTeamMemberLimitReached} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFreeTeamMemberLimitReached}
     *     is {@code false}.
     */
    public String getFreeTeamMemberLimitReachedValue() {
        if (this.tag != Tag.FREE_TEAM_MEMBER_LIMIT_REACHED) {
            throw new IllegalStateException("Invalid tag: required Tag.FREE_TEAM_MEMBER_LIMIT_REACHED, but was Tag." + tag.name());
        }
        return freeTeamMemberLimitReachedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_ALREADY_ON_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_ALREADY_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isUserAlreadyOnTeam() {
        return this.tag == Tag.USER_ALREADY_ON_TEAM;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#USER_ALREADY_ON_TEAM}.
     *
     * <p> User is already on this team. The provided email address is
     * associated with a user who is already a member of or invited to the team.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#USER_ALREADY_ON_TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult userAlreadyOnTeam(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.USER_ALREADY_ON_TEAM, null, null, null, value, null, null, null, null, null);
    }

    /**
     * User is already on this team. The provided email address is associated
     * with a user who is already a member of or invited to the team.
     *
     * <p> This instance must be tagged as {@link Tag#USER_ALREADY_ON_TEAM}.
     * </p>
     *
     * @return The {@link MemberAddResult#userAlreadyOnTeam} value associated
     *     with this instance if {@link #isUserAlreadyOnTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUserAlreadyOnTeam} is {@code
     *     false}.
     */
    public String getUserAlreadyOnTeamValue() {
        if (this.tag != Tag.USER_ALREADY_ON_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ALREADY_ON_TEAM, but was Tag." + tag.name());
        }
        return userAlreadyOnTeamValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_ON_ANOTHER_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_ON_ANOTHER_TEAM}, {@code false} otherwise.
     */
    public boolean isUserOnAnotherTeam() {
        return this.tag == Tag.USER_ON_ANOTHER_TEAM;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#USER_ON_ANOTHER_TEAM}.
     *
     * <p> User is already on another team. The provided email address is
     * associated with a user that is already a member or invited to another
     * team. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#USER_ON_ANOTHER_TEAM}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult userOnAnotherTeam(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.USER_ON_ANOTHER_TEAM, null, null, null, null, value, null, null, null, null);
    }

    /**
     * User is already on another team. The provided email address is associated
     * with a user that is already a member or invited to another team.
     *
     * <p> This instance must be tagged as {@link Tag#USER_ON_ANOTHER_TEAM}.
     * </p>
     *
     * @return The {@link MemberAddResult#userOnAnotherTeam} value associated
     *     with this instance if {@link #isUserOnAnotherTeam} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUserOnAnotherTeam} is {@code
     *     false}.
     */
    public String getUserOnAnotherTeamValue() {
        if (this.tag != Tag.USER_ON_ANOTHER_TEAM) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ON_ANOTHER_TEAM, but was Tag." + tag.name());
        }
        return userOnAnotherTeamValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_ALREADY_PAIRED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_ALREADY_PAIRED}, {@code false} otherwise.
     */
    public boolean isUserAlreadyPaired() {
        return this.tag == Tag.USER_ALREADY_PAIRED;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#USER_ALREADY_PAIRED}.
     *
     * <p> User is already paired. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#USER_ALREADY_PAIRED}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult userAlreadyPaired(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.USER_ALREADY_PAIRED, null, null, null, null, null, value, null, null, null);
    }

    /**
     * User is already paired.
     *
     * <p> This instance must be tagged as {@link Tag#USER_ALREADY_PAIRED}. </p>
     *
     * @return The {@link MemberAddResult#userAlreadyPaired} value associated
     *     with this instance if {@link #isUserAlreadyPaired} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUserAlreadyPaired} is {@code
     *     false}.
     */
    public String getUserAlreadyPairedValue() {
        if (this.tag != Tag.USER_ALREADY_PAIRED) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ALREADY_PAIRED, but was Tag." + tag.name());
        }
        return userAlreadyPairedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_MIGRATION_FAILED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_MIGRATION_FAILED}, {@code false} otherwise.
     */
    public boolean isUserMigrationFailed() {
        return this.tag == Tag.USER_MIGRATION_FAILED;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#USER_MIGRATION_FAILED}.
     *
     * <p> User migration has failed. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#USER_MIGRATION_FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult userMigrationFailed(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.USER_MIGRATION_FAILED, null, null, null, null, null, null, value, null, null);
    }

    /**
     * User migration has failed.
     *
     * <p> This instance must be tagged as {@link Tag#USER_MIGRATION_FAILED}.
     * </p>
     *
     * @return The {@link MemberAddResult#userMigrationFailed} value associated
     *     with this instance if {@link #isUserMigrationFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUserMigrationFailed} is
     *     {@code false}.
     */
    public String getUserMigrationFailedValue() {
        if (this.tag != Tag.USER_MIGRATION_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_MIGRATION_FAILED, but was Tag." + tag.name());
        }
        return userMigrationFailedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DUPLICATE_EXTERNAL_MEMBER_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DUPLICATE_EXTERNAL_MEMBER_ID}, {@code false} otherwise.
     */
    public boolean isDuplicateExternalMemberId() {
        return this.tag == Tag.DUPLICATE_EXTERNAL_MEMBER_ID;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#DUPLICATE_EXTERNAL_MEMBER_ID}.
     *
     * <p> A user with the given external member ID already exists on the team.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#DUPLICATE_EXTERNAL_MEMBER_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult duplicateExternalMemberId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.DUPLICATE_EXTERNAL_MEMBER_ID, null, null, null, null, null, null, null, value, null);
    }

    /**
     * A user with the given external member ID already exists on the team.
     *
     * <p> This instance must be tagged as {@link
     * Tag#DUPLICATE_EXTERNAL_MEMBER_ID}. </p>
     *
     * @return The {@link MemberAddResult#duplicateExternalMemberId} value
     *     associated with this instance if {@link #isDuplicateExternalMemberId}
     *     is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isDuplicateExternalMemberId} is
     *     {@code false}.
     */
    public String getDuplicateExternalMemberIdValue() {
        if (this.tag != Tag.DUPLICATE_EXTERNAL_MEMBER_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.DUPLICATE_EXTERNAL_MEMBER_ID, but was Tag." + tag.name());
        }
        return duplicateExternalMemberIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_CREATION_FAILED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_CREATION_FAILED}, {@code false} otherwise.
     */
    public boolean isUserCreationFailed() {
        return this.tag == Tag.USER_CREATION_FAILED;
    }

    /**
     * Returns an instance of {@code MemberAddResult} that has its tag set to
     * {@link Tag#USER_CREATION_FAILED}.
     *
     * <p> User creation has failed. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MemberAddResult} with its tag set to {@link
     *     Tag#USER_CREATION_FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}", or
     *     is {@code null}.
     */
    public static MemberAddResult userCreationFailed(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new MemberAddResult(Tag.USER_CREATION_FAILED, null, null, null, null, null, null, null, null, value);
    }

    /**
     * User creation has failed.
     *
     * <p> This instance must be tagged as {@link Tag#USER_CREATION_FAILED}.
     * </p>
     *
     * @return The {@link MemberAddResult#userCreationFailed} value associated
     *     with this instance if {@link #isUserCreationFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUserCreationFailed} is {@code
     *     false}.
     */
    public String getUserCreationFailedValue() {
        if (this.tag != Tag.USER_CREATION_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_CREATION_FAILED, but was Tag." + tag.name());
        }
        return userCreationFailedValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            successValue,
            teamLicenseLimitValue,
            freeTeamMemberLimitReachedValue,
            userAlreadyOnTeamValue,
            userOnAnotherTeamValue,
            userAlreadyPairedValue,
            userMigrationFailedValue,
            duplicateExternalMemberIdValue,
            userCreationFailedValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof MemberAddResult) {
            MemberAddResult other = (MemberAddResult) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case SUCCESS:
                    return (this.successValue == other.successValue) || (this.successValue.equals(other.successValue));
                case TEAM_LICENSE_LIMIT:
                    return (this.teamLicenseLimitValue == other.teamLicenseLimitValue) || (this.teamLicenseLimitValue.equals(other.teamLicenseLimitValue));
                case FREE_TEAM_MEMBER_LIMIT_REACHED:
                    return (this.freeTeamMemberLimitReachedValue == other.freeTeamMemberLimitReachedValue) || (this.freeTeamMemberLimitReachedValue.equals(other.freeTeamMemberLimitReachedValue));
                case USER_ALREADY_ON_TEAM:
                    return (this.userAlreadyOnTeamValue == other.userAlreadyOnTeamValue) || (this.userAlreadyOnTeamValue.equals(other.userAlreadyOnTeamValue));
                case USER_ON_ANOTHER_TEAM:
                    return (this.userOnAnotherTeamValue == other.userOnAnotherTeamValue) || (this.userOnAnotherTeamValue.equals(other.userOnAnotherTeamValue));
                case USER_ALREADY_PAIRED:
                    return (this.userAlreadyPairedValue == other.userAlreadyPairedValue) || (this.userAlreadyPairedValue.equals(other.userAlreadyPairedValue));
                case USER_MIGRATION_FAILED:
                    return (this.userMigrationFailedValue == other.userMigrationFailedValue) || (this.userMigrationFailedValue.equals(other.userMigrationFailedValue));
                case DUPLICATE_EXTERNAL_MEMBER_ID:
                    return (this.duplicateExternalMemberIdValue == other.duplicateExternalMemberIdValue) || (this.duplicateExternalMemberIdValue.equals(other.duplicateExternalMemberIdValue));
                case USER_CREATION_FAILED:
                    return (this.userCreationFailedValue == other.userCreationFailedValue) || (this.userCreationFailedValue.equals(other.userCreationFailedValue));
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

    static final class Serializer extends UnionJsonSerializer<MemberAddResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberAddResult.class, TeamMemberInfo.class);
        }

        @Override
        public void serialize(MemberAddResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case SUCCESS:
                    g.writeStartObject();
                    g.writeStringField(".tag", "success");
                    getUnwrappingSerializer(TeamMemberInfo.class).serialize(value.successValue, g, provider);
                    g.writeEndObject();
                    break;
                case TEAM_LICENSE_LIMIT:
                    g.writeStartObject();
                    g.writeStringField(".tag", "team_license_limit");
                    g.writeObjectField("team_license_limit", value.teamLicenseLimitValue);
                    g.writeEndObject();
                    break;
                case FREE_TEAM_MEMBER_LIMIT_REACHED:
                    g.writeStartObject();
                    g.writeStringField(".tag", "free_team_member_limit_reached");
                    g.writeObjectField("free_team_member_limit_reached", value.freeTeamMemberLimitReachedValue);
                    g.writeEndObject();
                    break;
                case USER_ALREADY_ON_TEAM:
                    g.writeStartObject();
                    g.writeStringField(".tag", "user_already_on_team");
                    g.writeObjectField("user_already_on_team", value.userAlreadyOnTeamValue);
                    g.writeEndObject();
                    break;
                case USER_ON_ANOTHER_TEAM:
                    g.writeStartObject();
                    g.writeStringField(".tag", "user_on_another_team");
                    g.writeObjectField("user_on_another_team", value.userOnAnotherTeamValue);
                    g.writeEndObject();
                    break;
                case USER_ALREADY_PAIRED:
                    g.writeStartObject();
                    g.writeStringField(".tag", "user_already_paired");
                    g.writeObjectField("user_already_paired", value.userAlreadyPairedValue);
                    g.writeEndObject();
                    break;
                case USER_MIGRATION_FAILED:
                    g.writeStartObject();
                    g.writeStringField(".tag", "user_migration_failed");
                    g.writeObjectField("user_migration_failed", value.userMigrationFailedValue);
                    g.writeEndObject();
                    break;
                case DUPLICATE_EXTERNAL_MEMBER_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "duplicate_external_member_id");
                    g.writeObjectField("duplicate_external_member_id", value.duplicateExternalMemberIdValue);
                    g.writeEndObject();
                    break;
                case USER_CREATION_FAILED:
                    g.writeStartObject();
                    g.writeStringField(".tag", "user_creation_failed");
                    g.writeObjectField("user_creation_failed", value.userCreationFailedValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MemberAddResult, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberAddResult.class, getTagMapping(), null, TeamMemberInfo.class);
        }

        @Override
        public MemberAddResult deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case SUCCESS: {
                    TeamMemberInfo value = null;
                    value = readCollapsedStructValue(TeamMemberInfo.class, _p, _ctx);
                    return MemberAddResult.success(value);
                }
                case TEAM_LICENSE_LIMIT: {
                    String value = null;
                    expectField(_p, "team_license_limit");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.teamLicenseLimit(value);
                }
                case FREE_TEAM_MEMBER_LIMIT_REACHED: {
                    String value = null;
                    expectField(_p, "free_team_member_limit_reached");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.freeTeamMemberLimitReached(value);
                }
                case USER_ALREADY_ON_TEAM: {
                    String value = null;
                    expectField(_p, "user_already_on_team");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.userAlreadyOnTeam(value);
                }
                case USER_ON_ANOTHER_TEAM: {
                    String value = null;
                    expectField(_p, "user_on_another_team");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.userOnAnotherTeam(value);
                }
                case USER_ALREADY_PAIRED: {
                    String value = null;
                    expectField(_p, "user_already_paired");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.userAlreadyPaired(value);
                }
                case USER_MIGRATION_FAILED: {
                    String value = null;
                    expectField(_p, "user_migration_failed");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.userMigrationFailed(value);
                }
                case DUPLICATE_EXTERNAL_MEMBER_ID: {
                    String value = null;
                    expectField(_p, "duplicate_external_member_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.duplicateExternalMemberId(value);
                }
                case USER_CREATION_FAILED: {
                    String value = null;
                    expectField(_p, "user_creation_failed");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MemberAddResult.userCreationFailed(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, MemberAddResult.Tag> getTagMapping() {
            Map<String, MemberAddResult.Tag> values = new HashMap<String, MemberAddResult.Tag>();
            values.put("success", MemberAddResult.Tag.SUCCESS);
            values.put("team_license_limit", MemberAddResult.Tag.TEAM_LICENSE_LIMIT);
            values.put("free_team_member_limit_reached", MemberAddResult.Tag.FREE_TEAM_MEMBER_LIMIT_REACHED);
            values.put("user_already_on_team", MemberAddResult.Tag.USER_ALREADY_ON_TEAM);
            values.put("user_on_another_team", MemberAddResult.Tag.USER_ON_ANOTHER_TEAM);
            values.put("user_already_paired", MemberAddResult.Tag.USER_ALREADY_PAIRED);
            values.put("user_migration_failed", MemberAddResult.Tag.USER_MIGRATION_FAILED);
            values.put("duplicate_external_member_id", MemberAddResult.Tag.DUPLICATE_EXTERNAL_MEMBER_ID);
            values.put("user_creation_failed", MemberAddResult.Tag.USER_CREATION_FAILED);
            return Collections.unmodifiableMap(values);
        }
    }
}
