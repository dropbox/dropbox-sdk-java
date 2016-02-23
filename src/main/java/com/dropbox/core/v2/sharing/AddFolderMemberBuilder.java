/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxSharing#addFolderMemberBuilder(String,java.util.List)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class AddFolderMemberBuilder {
    private final DbxSharing sharing;
    private final AddFolderMemberArg.Builder addFolderMemberArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param addFolderMemberArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    AddFolderMemberBuilder(DbxSharing sharing, AddFolderMemberArg.Builder addFolderMemberArgBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (addFolderMemberArgBuilder == null) {
            throw new NullPointerException("addFolderMemberArgBuilder");
        }
        this.sharing = sharing;
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
        AddFolderMemberArg arg = this.addFolderMemberArgBuilder.build();
        sharing.addFolderMember(arg);
    }
}
