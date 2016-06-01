/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#addFolderMemberBuilder(String,java.util.List)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class AddFolderMemberBuilder {
    private final DbxUserSharingRequests sharing_;
    private final AddFolderMemberArg.Builder addFolderMemberArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing_  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param addFolderMemberArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    AddFolderMemberBuilder(DbxUserSharingRequests sharing_, AddFolderMemberArg.Builder addFolderMemberArgBuilder) {
        if (sharing_ == null) {
            throw new NullPointerException("sharing_");
        }
        this.sharing_ = sharing_;
        if (addFolderMemberArgBuilder == null) {
            throw new NullPointerException("addFolderMemberArgBuilder");
        }
        this.addFolderMemberArgBuilder = addFolderMemberArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param quiet  Whether added members should be notified via email and
     *     device notifications of their invite. Defaults to {@code false} when
     *     set to {@code null}.
     *
     * @return this builder
     */
    public AddFolderMemberBuilder withQuiet(Boolean quiet) {
        this.addFolderMemberArgBuilder.withQuiet(quiet);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param customMessage  Optional message to display to added members in
     *     their invitation. Must have length of at least 1.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddFolderMemberBuilder withCustomMessage(String customMessage) {
        this.addFolderMemberArgBuilder.withCustomMessage(customMessage);
        return this;
    }

    /**
     * Issues the request.
     */
    public void start() throws AddFolderMemberErrorException, DbxException {
        AddFolderMemberArg arg_ = this.addFolderMemberArgBuilder.build();
        sharing_.addFolderMember(arg_);
    }
}
