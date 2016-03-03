/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#listSharedLinksBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListSharedLinksBuilder {
    private final DbxUserSharingRequests sharing;
    private final ListSharedLinksArg.Builder listSharedLinksArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param listSharedLinksArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListSharedLinksBuilder(DbxUserSharingRequests sharing, ListSharedLinksArg.Builder listSharedLinksArgBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (listSharedLinksArgBuilder == null) {
            throw new NullPointerException("listSharedLinksArgBuilder");
        }
        this.sharing = sharing;
        this.listSharedLinksArgBuilder = listSharedLinksArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param path  See {@link DbxUserSharingRequests#listSharedLinks()}
     *     description. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}".
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListSharedLinksBuilder withPath(String path) {
        this.listSharedLinksArgBuilder.withPath(path);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserSharingRequests#listSharedLinks()}.
     *
     * @return this builder
     */
    public ListSharedLinksBuilder withCursor(String cursor) {
        this.listSharedLinksArgBuilder.withCursor(cursor);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param directOnly  See {@link DbxUserSharingRequests#listSharedLinks()}
     *     description.
     *
     * @return this builder
     */
    public ListSharedLinksBuilder withDirectOnly(Boolean directOnly) {
        this.listSharedLinksArgBuilder.withDirectOnly(directOnly);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListSharedLinksResult start() throws ListSharedLinksErrorException, DbxException {
        ListSharedLinksArg arg = this.listSharedLinksArgBuilder.build();
        return sharing.listSharedLinks(arg);
    }
}
