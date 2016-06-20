/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#addFileMemberBuilder(String,java.util.List)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class AddFileMemberBuilder {
    private final DbxUserSharingRequests sharing_;
    private final AddFileMemberArgs.Builder addFileMemberArgsBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing_  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param addFileMemberArgsBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    AddFileMemberBuilder(DbxUserSharingRequests sharing_, AddFileMemberArgs.Builder addFileMemberArgsBuilder) {
        if (sharing_ == null) {
            throw new NullPointerException("sharing_");
        }
        this.sharing_ = sharing_;
        if (addFileMemberArgsBuilder == null) {
            throw new NullPointerException("addFileMemberArgsBuilder");
        }
        this.addFileMemberArgsBuilder = addFileMemberArgsBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param customMessage  Message to send to added members in their
     *     invitation.
     *
     * @return this builder
     */
    public AddFileMemberBuilder withCustomMessage(String customMessage) {
        this.addFileMemberArgsBuilder.withCustomMessage(customMessage);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param quiet  Whether added members should be notified via device
     *     notifications of their invitation. Defaults to {@code false} when set
     *     to {@code null}.
     *
     * @return this builder
     */
    public AddFileMemberBuilder withQuiet(Boolean quiet) {
        this.addFileMemberArgsBuilder.withQuiet(quiet);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code
     * AccessLevel.VIEWER}. </p>
     *
     * @param accessLevel  AccessLevel union object, describing what access
     *     level we want to give new members. Defaults to {@code
     *     AccessLevel.VIEWER} when set to {@code null}.
     *
     * @return this builder
     */
    public AddFileMemberBuilder withAccessLevel(AccessLevel accessLevel) {
        this.addFileMemberArgsBuilder.withAccessLevel(accessLevel);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param addMessageAsComment  If the custom message should be added as a
     *     comment on the file. Defaults to {@code false} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public AddFileMemberBuilder withAddMessageAsComment(Boolean addMessageAsComment) {
        this.addFileMemberArgsBuilder.withAddMessageAsComment(addMessageAsComment);
        return this;
    }

    /**
     * Issues the request.
     */
    public java.util.List<FileMemberActionResult> start() throws AddFileMemberErrorException, DbxException {
        AddFileMemberArgs arg_ = this.addFileMemberArgsBuilder.build();
        return sharing_.addFileMember(arg_);
    }
}
