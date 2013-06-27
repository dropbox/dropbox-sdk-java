package com.dropbox.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.*;

/**
 * <p>
 * Use this class to make remote calls to the Dropbox API.  You'll need an access token first,
 * normally acquired via {@link DbxWebAuth}.
 * </p>
 *
 * <p>
 * This class has no mutable state, so it's thread safe as long as you pass in a thread safe
 * {@link HttpRequestor} implementation.
 * </p>
 */
public final class DbxClient
{
    private final DbxRequestConfig requestConfig;
	private final String accessToken;
    private final DbxHost host;

    /**
     * @param accessToken
     *     The OAuth 2 access token (that you got from Dropbox) that gives your app the ability
     *     to make Dropbox API calls against some particular user's account.  The standard way
     *     to get one of these is to use {@link DbxWebAuth} to send your user through Dropbox's
     *     OAuth 2 authorization flow.
     */
    public DbxClient(DbxRequestConfig requestConfig, String accessToken)
    {
        this(requestConfig, accessToken, DbxHost.Default);
    }

    /**
     * The same as {@link #DbxClient(DbxRequestConfig, String)} except you can also set the
     * hostnames of the Dropbox API servers.  This is used in testing.  You don't normally need
     * to call this.
     */
    public DbxClient(DbxRequestConfig requestConfig, String accessToken, DbxHost host)
    {
        if (requestConfig == null) throw new IllegalArgumentException("'requestConfig' is null");
        if (accessToken == null) throw new IllegalArgumentException("'accessToken' is null");
        if (host == null) throw new IllegalArgumentException("'host' is null");

        this.requestConfig = requestConfig;
        this.accessToken = accessToken;
        this.host = host;
    }

    /**
     * Returns the {@code DbxRequestConfig} that was passed in to the constructor.
     */
    public DbxRequestConfig getRequestConfig() { return requestConfig; }

    /**
     * Returns the {@code DbxAccessToken} that was passed in to the constructor.
     */
    public String getAccessToken() { return accessToken; }

    // -----------------------------------------------------------------
    // /metadata

    /**
     * Get the file or folder metadata for a given path.
     *
     * <pre>
     * DbxClient dbxClient = ...
     * DbxEntry entry = dbxClient.getMetadata("/Photos");
     * if (entry == null) {
     *     System.out.println("No file or folder at that path.");
     * } else {
     *     System.out.print(entry.toStringMultiline());
     * }
     * </pre>
     *
     * @param path
     *     The path to the file or folder (see {@link DbxPath}).
     *
     * @return If there is a file or folder at the given path, return the
     *    metadata for that path.  If there is no file or folder there,
     *    return {@code null}.
     */
    public DbxEntry getMetadata(final String path)
        throws DbxException
    {
        DbxPath.checkArg("path", path);

        String host = this.host.api;
        String apiPath = "1/metadata/auto" + path;
        String[] params = { "list", "false", };

        return doGet(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<DbxEntry>() {
            @Override
            public DbxEntry handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                // Will return 'null' for "is_deleted=true" entries.
                return DbxRequestUtil.extractJsonFromResponse(DbxEntry.Reader, response.body);
            }
        });
    }

    /**
     * Get the metadata for a given path; if the path refers to a folder,
     * get all the children's metadata as well.
     *
     * <pre>
     * DbxClient dbxClient = ...
     * DbxEntry entry = dbxClient.getMetadata("/Photos");
     * if (entry == null) {
     *     System.out.println("No file or folder at that path.");
     * } else {
     *     System.out.print(entry.toStringMultiline());
     * }
     * </pre>
     *
     * @param path
     *     The path (starting with "/") to the file or folder (see {@link DbxPath}).
     *
     * @return If there is no file or folder at the given path, return {@code null}.
     *    Otherwise, return the metadata for that path and the metadata for all its immediate
     *    children (if it's a folder).
     */
    public DbxEntry.WithChildren getMetadataWithChildren(String path)
        throws DbxException
    {
        return getMetadataWithChildrenBase(path, DbxEntry.WithChildren.Reader);
    }

    /**
     * Same as {@link #getMetadataWithChildren} except instead of always returning a list of
     * {@link DbxEntry} objects, you specify a {@link Collector} that processes the {@link DbxEntry}
     * objects one by one and aggregates them however you want.
     *
     * <p>
     * This allows your to process the {@link DbxEntry} values as they arrive, instead of having to
     * wait for the entire API call to finish before processing the first one.  Be careful, though,
     * because the API call may fail in the middle (after you've already processed some entries).
     * Make sure your code can handle that situation.  For example, if you're inserting stuff into a
     * database as they arrive, you might want do everything in a transaction and commit only if
     * the entire call succeeds.
     * </p>
     */
    public <C> DbxEntry.WithChildrenC<C> getMetadataWithChildrenC(String path, final Collector<DbxEntry, ? extends C> collector)
        throws DbxException
    {
        return getMetadataWithChildrenBase(path, new DbxEntry.WithChildrenC.Reader<C>(collector));
    }

    private <T> T getMetadataWithChildrenBase(String path, final JsonReader<? extends T> extractor)
        throws DbxException
    {
        DbxPath.checkArg("path", path);

        String host = this.host.api;
        String apiPath = "1/metadata/auto" + path;

        String[] params = { "list", "true", "file_limit", "25000", };

        return doGet(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<T>() {
            @Override
            public T handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                // Will return 'null' for "is_deleted=true" entries.
                return DbxRequestUtil.extractJsonFromResponse(extractor, response.body);
            }
        });
    }

    /**
     * Get the metadata for a given path and its children if anything has
     * changed since the last time you got them (as determined by the value
     * of {@link DbxEntry.WithChildren#hash} from the last result).
     *
     * @param path
     *     The path (starting with "/") to the file or folder (see {@link DbxPath}).
     *
     * @param previousFolderHash
     *     The value of {@link DbxEntry.WithChildren#hash} from the last time
     *     you got the metadata for this folder (and children).
     *
     * @return Never returns {@code null}.  If the folder at the given path hasn't changed
     *    since you last retrieved it (i.e. its contents match {@code previousFolderHash}), return
     *    {@code Maybe.Nothing}.  If it doesn't match {@code previousFolderHash} return either
     *    {@code Maybe.Just(null)} if there's nothing there or {@code Maybe.Just} with the
     *    metadata.
     */
    public Maybe<DbxEntry.WithChildren> getMetadataWithChildrenIfChanged(String path, String previousFolderHash)
        throws DbxException
    {
        return getMetadataWithChildrenIfChangedBase(path, previousFolderHash, DbxEntry.WithChildren.Reader);
    }

    /**
     * Same as {@link #getMetadataWithChildrenIfChanged} except instead of always returning a list of
     * {@link DbxEntry} objects, you specify a {@link Collector} that processes the {@link DbxEntry}
     * objects one by one and aggregates them however you want.
     *
     * <p>
     * This allows your to process the {@link DbxEntry} values as they arrive, instead of having to
     * wait for the entire API call to finish before processing the first one.  Be careful, though,
     * because the API call may fail in the middle (after you've already processed some entries).
     * Make sure your code can handle that situation.  For example, if you're inserting stuff into a
     * database as they arrive, you might want do everything in a transaction and commit only if
     * the entire call succeeds.
     * </p>
     */
    public <C> Maybe<DbxEntry.WithChildrenC<C>> getMetadataWithChildrenIfChangedC(
            String path, String previousFolderHash, Collector<DbxEntry,? extends C> collector)
        throws DbxException
    {
        return getMetadataWithChildrenIfChangedBase(path, previousFolderHash, new DbxEntry.WithChildrenC.Reader<C>(collector));
    }

    private <T> Maybe<T> getMetadataWithChildrenIfChangedBase(
            String path, String previousFolderHash, final JsonReader<T> extractor)
        throws DbxException
    {
        if (previousFolderHash == null) throw new IllegalArgumentException("'previousFolderHash' must not be null");
        if (previousFolderHash.length() == 0) throw new IllegalArgumentException("'previousFolderHash' must not be empty");
        DbxPath.checkArg("path", path);

        String host = this.host.api;
        String apiPath = "1/metadata/auto" + path;

        String[] params = { "list", "true", "file_limit", "25000", "hash", previousFolderHash, };

        return doGet(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<Maybe<T>>() {
            @Override
            public Maybe<T> handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode == 404) return Maybe.Just(null);
                if (response.statusCode == 304) return Maybe.Nothing();
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return Maybe.Just(DbxRequestUtil.extractJsonFromResponse(extractor, response.body));
            }
        });
    }

    // -----------------------------------------------------------------
    // /account_info

    /**
     * Retrieve the user's account information.
     */
    public DbxAccountInfo getAccountInfo()
        throws DbxException
    {
        String host = this.host.api;
        String apiPath = "1/account/info";

        return doGet(host, apiPath, null, null, new DbxRequestUtil.ResponseHandler<DbxAccountInfo>() {
            @Override
            public DbxAccountInfo handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode != 200) throw new DbxException.BadResponse("unexpected response code: " + response.statusCode);
                return DbxRequestUtil.extractJsonFromResponse(DbxAccountInfo.Reader, response.body);
            }
        });
    }

    // -----------------------------------------------------------------
    // /files (GET)

    /**
     * Retrieves a file's content and writes it to the given {@code OutputStream}.
     *
     * <pre>
     * DbxClient dbxClient = ...
     * DbxEntry.File md;
     * File target = new File("Copy of House.jpeg");
     * OutputStream out = new FileOutputStream(target);
     * try {
     *     md = dbxClient.getFile("/Photos/House.jpeg", out);
     * }
     * finally {
     *     out.close();
     * }
     * </pre>
     *
     * @param revision
     *    The {@link DbxEntry.File#revision }revision} of the file to retrieve,
     *    or {@code null} if you want the latest revision of the file.
     *
     * @throws IOException
     *    If there's an error writing to {@code target}.
     */
    public DbxEntry.File getFile(String path, String revision, OutputStream target)
        throws DbxException, IOException
    {
        Downloader downloader = startGetFile(path, revision);
        if (downloader == null) return null;
        return downloader.copyBodyAndClose(target);
    }

    /**
     * Retrieve a file's content and content metadata.  Returns a {@link Downloader}
     * which is just an {@link InputStream} (can be used to read the file contents) and
     * a {@link DbxEntry.File} (the file's metadata).
     *
     * <p>
     * You need to close the {@link Downloader} yourself.
     * Use a {@code try}/{@code finally} to make sure you close it in all cases.
     * </p>
     *
     * <pre>
     * DbxClient dbxClient = ...
     * DbxClient.Downloader downloader = dbxClient.getFileStart("/ReadMe.txt")
     * try {
     *     printStream(downloader.body)
     * }
     * finally {
     *     downloader.close()
     * }
     * </pre>
     *
     * @param revision
     *    The {@link DbxEntry.File#revision }revision} of the file to retrieve,
     *    or {@code null} if you want the latest revision of the file.
     *
     * @param path
     *     The path (starting with "/") to the file or folder on Dropbox.
     *     (see {@link DbxPath}).
     */
    public Downloader startGetFile(final String path, String revision)
            throws DbxException
    {
        DbxPath.checkArgNonRoot("path", path);
        String apiPath = "1/files/auto" + path;
        String[] params = new String[] { "rev", revision };
        return startGetSomething(apiPath, params);
    }

    /**
     * Generic function that downloads either files or thumbnails.
     */
    private Downloader startGetSomething(final String apiPath, String[] params)
        throws DbxException
    {
        String host = this.host.content;

        boolean passedOwnershipOfStream = false;
        HttpRequestor.Response response = DbxRequestUtil.startGet(requestConfig, accessToken, host, apiPath, params, null);
        try {
            if (response.statusCode == 404) return null;
            if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);

            String metadataString = DbxRequestUtil.getFirstHeader(response, "x-dropbox-metadata");
            DbxEntry metadata;
            try {
                metadata = DbxEntry.Reader.readFully(metadataString);
            }
            catch (JsonReadException ex) {
                throw new DbxException.BadResponse("Bad JSON in X-Dropbox-Metadata header: " + ex.getMessage(), ex);
            }
            if (metadata instanceof DbxEntry.Folder) {
                throw new DbxException.BadResponse("downloaded file, but server returned metadata entry for a folder");
            }
            DbxEntry.File fileMetadata = (DbxEntry.File) metadata;

            // Package up the metadata with the response body's InputStream.
            Downloader result = new Downloader(fileMetadata, response.body);

            passedOwnershipOfStream = true;
            return result;
        }
        finally {
            // If we haven't passed ownership the stream to the caller, then close it.
            if (!passedOwnershipOfStream) {
                try {
                    response.body.close();
                }
                catch (IOException ex) {
                    // Ignore, since we don't actually care about the data in this method.
                    // We only care about IOExceptions when actually reading from the stream.
                }
            }
        }
    }

    /**
     * A pairing of the file content's metadata and an {@link InputStream} to read the
     * file content.  Make sure you always close the {@code InputStream}.
     */
    public static final class Downloader
    {
        public final DbxEntry.File metadata;
        public final InputStream body;

        public Downloader(DbxEntry.File metadata, InputStream body)
        {
            this.metadata = metadata;
            this.body = body;
        }

        DbxEntry.File copyBodyAndClose(OutputStream target)
            throws DbxException, IOException
        {
            try {
                IOUtil.copyStreamToStream(this.body, target);
            }
            catch (IOUtil.ReadException ex) {
                // Error reading from the network.  Convert it to a DbxException.
                throw new DbxException.NetworkIO(ex.underlying);
            }
            catch (IOUtil.WriteException ex) {
                // Error writing to 'target'.  Relay the underlying IOException.
                throw ex.underlying;
            }
            finally {
                this.close();
            }
            return this.metadata;
        }

        public void close()
        {
            IOUtil.closeInput(body);
        }
    }

    // --------------------------------------------------------
    // /files_put

    // TODO: Maybe switch to /files (POST) so we won't accidentally upload partial
    // files (multi-part form encoding will ensure that the server knows when the
    // upload is actually complete).

    /**
     * A wrapper around {@link #uploadFile(String, DbxWriteMode, long, DbxStreamWriter)} that
     * lets you pass in an {@link InputStream}.  The entire stream {@code contents} will
     * be uploaded and the stream will be closed automatically (whether or not the upload
     * succeeds or fails).
     *
     * <pre>
     * DbxClient dbxClient = ...
     * File f = new File("ReadMe.txt")
     * dbxClient.uploadFile("/ReadMe.txt", {@link DbxWriteMode#add()}, f.length(), new FileInputStream(f))
     * </pre>
     *
     * @param targetPath
     *     The path to the file on Dropbox (see {@link DbxPath}).  If a file at
     *     that path already exists on Dropbox, then the {@code writeMode} parameter
     *     will determine what happens.
     *
     * @param writeMode
     *     Determines what to do if there's already a file at the given {@code targetPath}.
     *
     * @param numBytes
     *     The number of bytes in the given stream.  Use {@code -1} if you don't know.
     *
     * @param contents
     *     The source of file contents.  This stream will be automatically closed (whether or not the
     *     upload succeeds).
     *
     * @throws IOException
     *     If there's an error reading from {@code in}.
     */
    public DbxEntry.File uploadFile(String targetPath, DbxWriteMode writeMode, long numBytes, InputStream contents)
        throws DbxException, IOException
    {
        DbxPath.checkArgNonRoot("targetPath", targetPath);

        return uploadFile(targetPath, writeMode, numBytes, new DbxStreamWriter.InputStreamCopier(contents));
    }

    /**
     * Upload file contents to Dropbox, getting contents from the given {@link DbxStreamWriter}.
     *
     * <pre>
     * DbxClient dbxClient = ...
     * <b>// Create a file on Dropbox with 100 3-digit random numbers, one per line.</b>
     * final int numRandoms = 100;
     * int fileSize = numRandoms * 4;  <b>3 digits, plus a newline</b>
     * dbxClient.uploadFile("/Randoms.txt", {@link DbxWriteMode#add()}, fileSize,
     *     new DbxStreamWriter&lt;RuntimeException&gt;() {
     *         public void write(OutputStream out) throws IOException
     *         {
     *             Random rand = new Random();
     *             PrintWriter pw = new PrintWriter(out);
     *             for (int i = 0; i < numRandoms; i++) {
     *                 pw.printf("%03d\n", rand.nextInt(1000));
     *             }
     *             pw.flush();
     *         }
     *     });
     * </pre>
     *
     * @param targetPath
     *     The path to the file on Dropbox (see {@link DbxPath}).  If a file at
     *     that path already exists on Dropbox, then the {@code writeMode} parameter
     *     will determine what happens.
     *
     * @param writeMode
     *     Determines what to do if there's already a file at the given {@code targetPath}.
     *
     * @param numBytes
     *     The number of bytes you're going to upload via the returned {@link DbxClient.Uploader}.
     *     Use {@code -1} if you don't know ahead of time.
     *
     * @param writer
     *     A callback that will be called when it's time to actually write out the
     *     body of the file.  We will always call {@link DbxStreamWriter#close} on it (whether
     *     or not the upload succeeds) so you can put resource cleanup code in it (for example,
     *     closing an {@code InputStream}).
     *
     * @throws E
     *     If {@code writer.write()} throws an exception, it will propagate out of this function.
     */
    public <E extends Throwable> DbxEntry.File uploadFile(String targetPath, DbxWriteMode writeMode, long numBytes, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        DbxPath.checkArgNonRoot("targetPath", targetPath);

        try {
            Uploader uploader = startUploadFile(targetPath, writeMode, numBytes);
            NoThrowOutputStream streamWrapper = new NoThrowOutputStream(uploader.body);
            try {
                writer.write(streamWrapper);
                return uploader.finish();
            }
            catch (NoThrowOutputStream.HiddenException ex) {
                // We hid our OutputStream's IOException from their writer.write() function so that
                // we could properly raise a NetworkIO exception if something went wrong with the
                // network stream.
                throw new DbxException.NetworkIO(ex.underlying);
            }
            finally {
                uploader.close();
            }
        }
        finally {
            writer.close();
        }
    }

    /**
     * Start an API request to upload a file to Dropbox.  Returns a {@link DbxClient.Uploader} object
     * that lets you actually send the file contents via {@link DbxClient.Uploader#body}.  When
     * you're done copying the file body, call {@link DbxClient.Uploader#finish}.
     *
     * <p>
     * You need to close the {@link Uploader} when you're done with it.
     * Use a {@code try}/{@code finally} to make sure you close it in all cases.
     * </p>
     *
     * <pre>
     * DbxClient dbxClient = ...
     * DbxClient.Uploader uploader = dbxClient.startUploadFile(...)
     * DbxEntry.File md;
     * try {
     *     writeMyData(uploader.body);
     *     md = uploader.finish();
     * }
     * finally {
     *     uploader.close();
     * }
     * </pre>
     *
     * @param targetPath
     *     The path to the file on Dropbox (see {@link DbxPath}).  If a file at
     *     that path already exists on Dropbox, then the {@code writeMode} parameter
     *     will determine what happens.
     *
     * @param writeMode
     *     Determines what to do if there's already a file at the given {@code targetPath}.
     *
     * @param numBytes
     *     The number of bytes you're going to upload via the returned {@link DbxClient.Uploader}.
     *     Use {@code -1} if you don't know ahead of time.
     */
    public Uploader startUploadFile(String targetPath, DbxWriteMode writeMode, long numBytes)
        throws DbxException
    {
        DbxPath.checkArg("targetPath", targetPath);

        String host = this.host.content;
        String apiPath = "1/files_put/auto" + targetPath;

        HttpRequestor.Uploader uploader = DbxRequestUtil.startPut(requestConfig, accessToken, host, apiPath, writeMode.params, null);

        return new Uploader(uploader, numBytes);
    }

    // -----------------------------------------------------------------
    // /delta

    /**
     * Return "delta" entries for the contents of a user's Dropbox.  This lets you
     * efficiently keep up with the latest state of the files and folders.  See
     * {@link DbxDelta} for more documentation on what each entry means.
     *
     * <p>
     * To start, pass in {@code null} for {@code cursor}.  For subsequent calls
     * To get the next set of delta entries, pass in the {@link DbxDelta#cursor cursor} returned
     * by the previous call.
     * </p>
     *
     * <p>
     * To catch up to the current state, keep calling this method until the returned
     * object's {@link DbxDelta#hasMore hasMore} field is {@code false}.
     * </p>
     *
     * <p>
     * If your app is a "Full Dropbox" app, this will return all entries for the user's entire
     * Dropbox folder.  If your app is an "App Folder" app, this will only return entries
     * for the App Folder's contents.
     * </p>
     */
    public DbxDelta<DbxEntry> getDelta(String cursor)
        throws DbxException
    {
        String host = this.host.api;
        String apiPath = "1/delta";

        String[] params = {"cursor", cursor};

        return doPost(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<DbxDelta<DbxEntry>>() {
            @Override
            public DbxDelta<DbxEntry> handle(HttpRequestor.Response response) throws DbxException {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.extractJsonFromResponse(
                        new DbxDelta.Reader<DbxEntry>(DbxEntry.Reader), response.body);
            }
        });
    }

    /**
     * This is a more generic version of {@link #getDelta}.  It allows you to specify
     * a <em>collector</em>, which lets you process the delta entries as they arrive over
     * the network, and aggregate them however you want.
     */
    public <C> DbxDeltaC<C, DbxEntry> getDeltaC(String cursor, final Collector<DbxDeltaC.Entry<DbxEntry>, C> collector)
        throws DbxException
    {
        String host = this.host.api;
        String apiPath = "1/delta";

        return doPost(host, apiPath, new String[]{"cursor", cursor}, null, new DbxRequestUtil.ResponseHandler<DbxDeltaC<C, DbxEntry>>() {
            @Override
            public DbxDeltaC<C, DbxEntry> handle(HttpRequestor.Response response) throws DbxException {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.extractJsonFromResponse(
                        new DbxDeltaC.Reader<C,DbxEntry>(DbxEntry.Reader, collector), response.body);
            }
        });
    }

    // -----------------------------------------------------------------
    // /thumbnails

    public DbxEntry.File getThumbnail(DbxThumbnailSize size, DbxThumbnailFormat format,
                                      String path, String revision, OutputStream target)
            throws DbxException, IOException
    {
        if (target == null) throw new IllegalArgumentException("'target' can't be null");

        Downloader downloader = startGetThumbnail(size, format, path, revision);
        if (downloader == null) return null;
        return downloader.copyBodyAndClose(target);
    }

    public Downloader startGetThumbnail(DbxThumbnailSize size, DbxThumbnailFormat format,
                                        String path, String revision)
        throws DbxException
    {
        DbxPath.checkArgNonRoot("path", path);
        if (size == null) throw new IllegalArgumentException("'size' can't be null");
        if (format == null) throw new IllegalArgumentException("'format' can't be null");

        String apiPath = "1/thumbnails/auto" + path;
        String[] params = {
            "size", size.ident,
            "format", format.ident,
            "rev", revision,
        };

        return startGetSomething(apiPath, params);
    }

    // --------------------------------------------------------

    // Convenience function that calls RequestUtil.doGet with the first two parameters filled in.
    private <T> T doGet(String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers, DbxRequestUtil.ResponseHandler<T> handler)
        throws DbxException
    {
        return DbxRequestUtil.doGet(requestConfig, accessToken, host, path, params, headers, handler);
    }

    // Convenience function that calls RequestUtil.doPost with the first two parameters filled in.
    public <T> T doPost(String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers, DbxRequestUtil.ResponseHandler<T> handler)
            throws DbxException
    {
        return DbxRequestUtil.doPost(requestConfig, accessToken, host, path, params, headers, handler);
    }

    /**
     * For uploading file content to Dropbox.  Write stuff to the {@link #body} stream.
     *
     * <p>
     * Don't call {@code close()} directly on the {@link #body}.  Instead call either
     * call either {@link #finish} or {@link #close} to make sure the stream and other
     * resources are released.  A safe idiom is to use the object within a {@code try}
     * block and put a call to {@link #close()} in the {@code finally} block.
     * </p>
     *
     * <pre>
     * DbxClient.Uploader uploader = ...
     * try {
     *     uploader.body.write("Hello, world!".getBytes("UTF-8"));
     *     uploader.finish();
     * }
     * finally {
     *     uploader.close();
     * }
     * </pre>
     */
    public static final class Uploader
    {
        private HttpRequestor.Uploader httpUploader;
        private final long claimedBytes;
        private final CountingOutputStream countingStream;

        public final OutputStream body;

        public Uploader(HttpRequestor.Uploader httpUploader, long claimedBytes)
        {
            if (claimedBytes < 0) {
                throw new IllegalArgumentException("'numBytes' must be greater than or equal to 0");
            }

            this.httpUploader = httpUploader;
            this.claimedBytes = claimedBytes;
            this.countingStream = new CountingOutputStream(httpUploader.body);

            this.body = countingStream;
        }

        /**
         * Cancel the upload.
         */
        public void abort()
        {
            if (httpUploader == null) {
                throw new IllegalStateException("already called 'finish', 'abort', or 'close'");
            }
            HttpRequestor.Uploader p = httpUploader;
            httpUploader = null;

            p.abort();
        }

        /**
         * Release the resources related to this {@code Uploader} instance.  If
         * {@code close()} or {@link #abort()} has already been called, this does nothing.
         * If neither has been called, this is equivalent to calling {@link #abort()}.
         */
        public void close()
        {
            // If already close'd or aborted, then don't do anything.
            if (httpUploader == null) return;

            abort();
        }

        /**
         * When you're done writing the file contents to {@link #body}, call this
         * to indicate that you're done.  This will actually finish the underlying HTTP
         * request and return the uploaded file's {@link DbxEntry}.
         */
        public DbxEntry.File finish()
            throws DbxException
        {
            if (httpUploader == null) {
                throw new IllegalStateException("already called 'finish', 'abort', or 'close'");
            }
            HttpRequestor.Uploader u = httpUploader;
            httpUploader = null;

            HttpRequestor.Response response;
            final long bytesWritten;
            try {
                bytesWritten = this.countingStream.getBytesWritten();

                // Make sure the uploaded the same number of bytes they said they were going to upload.
                if (claimedBytes != bytesWritten) {
                    u.abort();
                    throw new IllegalStateException("You said you were going to upload " + claimedBytes + " bytes, but you wrote "
                        + bytesWritten + " bytes to the Uploader's 'body' stream.");
                }

                response = u.finish();
            }
            catch (IOException ex) {
                throw new DbxException.NetworkIO(ex);
            }
            finally {
                u.close();
            }

            return DbxRequestUtil.finishResponse(response, new DbxRequestUtil.ResponseHandler<DbxEntry.File>() {
                @Override
                public DbxEntry.File handle(HttpRequestor.Response response) throws DbxException
                {
                    if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                    DbxEntry entry = DbxRequestUtil.extractJsonFromResponse(DbxEntry.Reader, response.body);
                    if (entry instanceof DbxEntry.Folder) {
                        throw new DbxException.BadResponse("uploaded file, but server returned metadata entry for a folder");
                    }
                    DbxEntry.File f = (DbxEntry.File) entry;
                    // Make sure the server agrees with us on how many bytes are in the file.
                    if (f.numBytes != bytesWritten) {
                        throw new DbxException.BadResponse("we uploaded " + bytesWritten + ", but server returned metadata entry with file size " + f.numBytes);
                    }
                    return f;
                }
            });
        }
    }
}
