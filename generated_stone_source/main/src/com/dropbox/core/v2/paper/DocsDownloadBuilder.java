/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;

/**
 * The request builder returned by {@link
 * DbxUserPaperRequests#docsDownloadBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class DocsDownloadBuilder extends DbxDownloadStyleBuilder<PaperDocExportResult> {
    private final DbxUserPaperRequests _client;
    private final String docId;
    private final ExportFormat exportFormat;

    /**
     * Creates a new instance of this builder.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param exportFormat  Must not be {@code null}.
     * @param _client  Dropbox namespace-specific client used to issue paper
     *     requests.
     *
     * @return instsance of this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    DocsDownloadBuilder(DbxUserPaperRequests _client, String docId, ExportFormat exportFormat) {
        if (_client == null) {
            throw new NullPointerException("_client");
        }
        this._client = _client;
        this.docId = docId;
        this.exportFormat = exportFormat;
    }

    @Override
    @SuppressWarnings("deprecation")
    public DbxDownloader<PaperDocExportResult> start() throws DocLookupErrorException, DbxException {
        PaperDocExport arg_ = new PaperDocExport(docId, exportFormat);
        return _client.docsDownload(arg_, getHeaders());
    }
}
