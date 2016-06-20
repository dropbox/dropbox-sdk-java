/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#listFileMembersBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListFileMembersBuilder {
    private final DbxUserSharingRequests sharing_;
    private final ListFileMembersArg.Builder listFileMembersArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing_  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param listFileMembersArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListFileMembersBuilder(DbxUserSharingRequests sharing_, ListFileMembersArg.Builder listFileMembersArgBuilder) {
        if (sharing_ == null) {
            throw new NullPointerException("sharing_");
        }
        this.sharing_ = sharing_;
        if (listFileMembersArgBuilder == null) {
            throw new NullPointerException("listFileMembersArgBuilder");
        }
        this.listFileMembersArgBuilder = listFileMembersArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param actions  The actions for which to return permissions on a member.
     *     Must not contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersBuilder withActions(List<MemberAction> actions) {
        this.listFileMembersArgBuilder.withActions(actions);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeInherited  Whether to include members who only have access
     *     from a parent shared folder. Defaults to {@code true} when set to
     *     {@code null}.
     *
     * @return this builder
     */
    public ListFileMembersBuilder withIncludeInherited(Boolean includeInherited) {
        this.listFileMembersArgBuilder.withIncludeInherited(includeInherited);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code 100L}. </p>
     *
     * @param limit  Number of members to return max per query. Defaults to 100
     *     if no limit is specified. Must be greater than or equal to 1 and be
     *     less than or equal to 300. Defaults to {@code 100L} when set to
     *     {@code null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersBuilder withLimit(Long limit) {
        this.listFileMembersArgBuilder.withLimit(limit);
        return this;
    }

    /**
     * Issues the request.
     */
    public SharedFileMembers start() throws ListFileMembersErrorException, DbxException {
        ListFileMembersArg arg_ = this.listFileMembersArgBuilder.build();
        return sharing_.listFileMembers(arg_);
    }
}
