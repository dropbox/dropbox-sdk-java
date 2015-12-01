package com.dropbox.core.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dropbox.core.*;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.*;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import static com.dropbox.core.util.StringUtil.jq;

/*>>> import checkers.nullness.quals.NonNull; */
/*>>> import checkers.nullness.quals.Nullable; */
/*>>> import checkers.nullness.quals.MonotonicNonNull; */
/*>>> import checkers.initialization.quals.Initialized; */

/**
 * Use this class to make remote calls to the Dropbox API.  You'll need an access token first,
 * normally acquired via {@link DbxWebAuth}.
 *
 * <p>
 * This class has no mutable state, so it's thread safe as long as you pass in a thread safe
 * {@link HttpRequestor} implementation.
 * </p>
 */
public final class DbxClientV1
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
    public DbxClientV1(DbxRequestConfig requestConfig, String accessToken)
    {
        this(requestConfig, accessToken, DbxHost.Default);
    }

    /**
     * The same as {@link #DbxClientV1(DbxRequestConfig, String)} except you can also set the
     * hostnames of the Dropbox API servers.  This is used in testing.  You don't normally need
     * to call this.
     */
    public DbxClientV1(DbxRequestConfig requestConfig, String accessToken, DbxHost host)
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

    /**
     * Returns the {@code DbxHost} that was passed in to the constructor.
     */
    public DbxHost getHost() { return host; }

    // -----------------------------------------------------------------
    // /metadata

    /**
     * Get the file or folder metadata for a given path.
     *
     * <pre>
     * DbxClientV1 dbxClient = ...
     * DbxEntry entry = dbxClient.getMetadata("/Photos");
     * if (entry == null) {
     *     System.out.println("No file or folder at that path.");
     * } else {
     *     System.out.print(entry.toStringMultiline());
     * }
     * </pre>
     *
     * @param path
     *     The path to the file or folder (see {@link DbxPathV1}).
     *
     * @param includeMediaInfo
     *     If {@code true}, then if the return value is a {@link DbxEntry.File}, it might have
     *     its {@code photoInfo} and {@code mediaInfo} fields filled in.
     *
     * @return If there is a file or folder at the given path, return the
     *    metadata for that path.  If there is no file or folder there,
     *    return {@code null}.
     */
    public /*@Nullable*/DbxEntry getMetadata(final String path, boolean includeMediaInfo)
        throws DbxException
    {
        DbxPathV1.checkArg("path", path);

        String host = this.host.api;
        String apiPath = "1/metadata/auto" + path;
        /*@Nullable*/String[] params = {
            "list", "false",
            "include_media_info", includeMediaInfo ? "true" : null,
        };

        return doGet(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/DbxEntry>() {
            @Override
            public /*@Nullable*/DbxEntry handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                // Will return 'null' for "is_deleted=true" entries.
                return DbxRequestUtil.readJsonFromResponse(DbxEntry.ReaderMaybeDeleted, response.body);
            }
        });
    }

    /**
     * Same as {@link #getMetadata(String, boolean)} with {@code includeMediaInfo} set
     * to {@code false}.
     */
    public /*@Nullable*/DbxEntry getMetadata(final String path)
        throws DbxException
    {
        return getMetadata(path, false);
    }

    /**
     * Get the metadata for a given path; if the path refers to a folder,
     * get all the children's metadata as well.
     *
     * <pre>
     * DbxClientV1 dbxClient = ...
     * DbxEntry entry = dbxClient.getMetadata("/Photos");
     * if (entry == null) {
     *     System.out.println("No file or folder at that path.");
     * } else {
     *     System.out.print(entry.toStringMultiline());
     * }
     * </pre>
     *
     * @param path
     *     The path (starting with "/") to the file or folder (see {@link DbxPathV1}).
     *
     * @param includeMediaInfo
     *     If {@code true}, then if the return value is a {@link DbxEntry.File}, it might have
     *     its {@code photoInfo} and {@code mediaInfo} fields filled in.
     *
     * @return If there is no file or folder at the given path, return {@code null}.
     *    Otherwise, return the metadata for that path and the metadata for all its immediate
     *    children (if it's a folder).
     */
    public DbxEntry./*@Nullable*/WithChildren getMetadataWithChildren(String path, boolean includeMediaInfo)
        throws DbxException
    {
        return getMetadataWithChildrenBase(path, includeMediaInfo, DbxEntry.WithChildren.ReaderMaybeDeleted);
    }

    /**
     * Same as {@link #getMetadataWithChildren(String, boolean)} with {@code includeMediaInfo} set
     * to {@code false}.
     */
    public DbxEntry./*@Nullable*/WithChildren getMetadataWithChildren(String path)
        throws DbxException
    {
        return getMetadataWithChildren(path, false);
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
    public <C> DbxEntry./*@Nullable*/WithChildrenC<C> getMetadataWithChildrenC(String path, boolean includeMediaInfo, final Collector<DbxEntry, ? extends C> collector)
        throws DbxException
    {
        return getMetadataWithChildrenBase(path, includeMediaInfo, new DbxEntry.WithChildrenC.ReaderMaybeDeleted<C>(collector));
    }

    /**
     * Same as {@link #getMetadataWithChildrenC(String, boolean, Collector)} with {@code includeMediaInfo} set
     * to {@code false}.
     */
    public <C> DbxEntry./*@Nullable*/WithChildrenC<C> getMetadataWithChildrenC(String path, final Collector<DbxEntry, ? extends C> collector)
        throws DbxException
    {
        return getMetadataWithChildrenC(path, false, collector);
    }

    private <T> /*@Nullable*/T getMetadataWithChildrenBase(String path, boolean includeMediaInfo, final JsonReader<? extends T> reader)
        throws DbxException
    {
        DbxPathV1.checkArg("path", path);

        String host = this.host.api;
        String apiPath = "1/metadata/auto" + path;

        /*@Nullable*/String[] params = {
            "list", "true",
            "file_limit", "25000",
            "include_media_info", includeMediaInfo ? "true" : null,
        };

        return doGet(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/T>() {
            @Override
            public /*@Nullable*/T handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                // Will return 'null' for "is_deleted=true" entries.
                return DbxRequestUtil.readJsonFromResponse(reader, response.body);
            }
        });
    }

    /**
     * Get the metadata for a given path and its children if anything has
     * changed since the last time you got them (as determined by the value
     * of {@link DbxEntry.WithChildren#hash} from the last result).
     *
     * @param path
     *     The path (starting with "/") to the file or folder (see {@link DbxPathV1}).
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
    public Maybe<DbxEntry./*@Nullable*/WithChildren> getMetadataWithChildrenIfChanged(String path, boolean includeMediaInfo, /*@Nullable*/String previousFolderHash)
        throws DbxException
    {
        return getMetadataWithChildrenIfChangedBase(path, includeMediaInfo, previousFolderHash, DbxEntry.WithChildren.ReaderMaybeDeleted);
    }

    /**
     * Same as {@link #getMetadataWithChildrenIfChanged(String, boolean, String)} with {@code includeMediaInfo} set
     * to {@code false}.
     */
    public Maybe<DbxEntry./*@Nullable*/WithChildren> getMetadataWithChildrenIfChanged(String path, /*@Nullable*/String previousFolderHash)
        throws DbxException
    {
        return getMetadataWithChildrenIfChanged(path, false, previousFolderHash);
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
    public <C> Maybe<DbxEntry./*@Nullable*/WithChildrenC<C>> getMetadataWithChildrenIfChangedC(
            String path, boolean includeMediaInfo, /*@Nullable*/String previousFolderHash, Collector<DbxEntry,? extends C> collector)
        throws DbxException
    {
        return getMetadataWithChildrenIfChangedBase(path, includeMediaInfo, previousFolderHash, new DbxEntry.WithChildrenC.ReaderMaybeDeleted<C>(collector));
    }

    /**
     * Same as {@link #getMetadataWithChildrenIfChangedC(String, boolean, String, Collector)} with
     * {@code includeMediaInfo} set to {@code false}.
     */
    public <C> Maybe<DbxEntry./*@Nullable*/WithChildrenC<C>> getMetadataWithChildrenIfChangedC(
            String path, /*@Nullable*/String previousFolderHash, Collector<DbxEntry,? extends C> collector)
        throws DbxException
    {
        return getMetadataWithChildrenIfChangedC(path, false, previousFolderHash, collector);
    }

    private <T> Maybe</*@Nullable*/T> getMetadataWithChildrenIfChangedBase(
            String path, boolean includeMediaInfo, /*@Nullable*/String previousFolderHash, final JsonReader<T> reader)
        throws DbxException
    {
        if (previousFolderHash == null) throw new IllegalArgumentException("'previousFolderHash' must not be null");
        if (previousFolderHash.length() == 0) throw new IllegalArgumentException("'previousFolderHash' must not be empty");
        DbxPathV1.checkArg("path", path);

        String host = this.host.api;
        String apiPath = "1/metadata/auto" + path;

        /*@Nullable*/String[] params = {
            "list", "true",
            "file_limit", "25000",
            "hash", previousFolderHash,
            "include_media_info", includeMediaInfo ? "true" : null,
        };

        return doGet(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<Maybe</*@Nullable*/T>>() {
            @Override
            public Maybe</*@Nullable*/T> handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode == 404) return Maybe.</*@Nullable*/T>Just(null);
                if (response.statusCode == 304) return Maybe.</*@Nullable*/T>Nothing();
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return Maybe.</*@Nullable*/T>Just(DbxRequestUtil.readJsonFromResponse(reader, response.body));
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
                return DbxRequestUtil.readJsonFromResponse(DbxAccountInfo.Reader, response.body);
            }
        });
    }

    // -----------------------------------------------------------------
    // /disable_access_token

    /**
     * Disable the access token that you constructed this {@code DbxClientV1}
     * with.  After calling this, API calls made with this {@code DbxClientV1} will
     * fail.
     */
    public void disableAccessToken()
        throws DbxException
    {
        String host = this.host.api;
        String apiPath = "1/disable_access_token";

        doPost(host, apiPath, null, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/Void>() {
            @Override
            public /*@Nullable*/Void handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode != 200) throw new DbxException.BadResponse("unexpected response code: " + response.statusCode);
                return null;
            }
        });
    }

    // -----------------------------------------------------------------
    // /files (GET)

    /**
     * Retrieves a file's content and writes it to the given {@code OutputStream}.
     *
     * <pre>
     * DbxClientV1 dbxClient = ...
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
     * @param rev
     *    The {@link DbxEntry.File#rev rev} of the file to retrieve,
     *    or {@code null} if you want the latest revision of the file.
     *
     * @return
     *    The downloaded file's metadata, or {@code null}
     *
     * @throws IOException
     *    If there's an error writing to {@code target}.
     */
    public DbxEntry./*@Nullable*/File getFile(String path, /*@Nullable*/String rev, OutputStream target)
        throws DbxException, IOException
    {
        Downloader downloader = startGetFile(path, rev);
        if (downloader == null) return null;
        return downloader.copyBodyAndClose(target);
    }

    /**
     * Retrieve a file's content and content metadata.  You must call the {@link Downloader}'s
     * {@code close()} method; use a {@code try}/{@code finally}.
     *
     * <pre>
     * DbxClientV1 dbxClient = ...
     * DbxClientV1.Downloader downloader = dbxClient.startGetFile("/ReadMe.txt")
     * try {
     *     printStream(downloader.body)
     * }
     * finally {
     *     downloader.close()
     * }
     * </pre>
     *
     * @param rev
     *    The {@link DbxEntry.File#rev rev} of the file to retrieve,
     *    or {@code null} if you want the latest revision of the file.
     *
     * @param path
     *     The path (starting with "/") to the file or folder on Dropbox.
     *     (see {@link DbxPathV1}).
     *
     * @return
     *     An object that can be used to download the file contents, or
     *     {@code null} if there is no file at the requested path.
     */
    public /*@Nullable*/Downloader startGetFile(final String path, /*@Nullable*/String rev)
            throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);
        String apiPath = "1/files/auto" + path;
        /*@Nullable*/String[] params = {
            "rev", rev
        };
        return startGetSomething(apiPath, params);
    }

    /**
     * Generic function that downloads either files or thumbnails.
     */
    private /*@Nullable*/Downloader startGetSomething(final String apiPath, /*@Nullable*/String[] params)
        throws DbxException
    {
        String host = this.host.content;

        boolean passedOwnershipOfStream = false;
        HttpRequestor.Response response = DbxRequestUtil.startGet(requestConfig, accessToken, host, apiPath, params, null);
        try {
            if (response.statusCode == 404) return null;
            if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);

            String metadataString = DbxRequestUtil.getFirstHeader(response, "x-dropbox-metadata");
            DbxEntry.File metadata;
            try {
                metadata = DbxEntry.File.Reader.readFully(metadataString);
            }
            catch (JsonReadException ex) {
                throw new DbxException.BadResponse("Bad JSON in X-Dropbox-Metadata header: " + ex.getMessage(), ex);
            }

            // Package up the metadata with the response body's InputStream.
            Downloader result = new Downloader(metadata, response.body);

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
     * A pairing of a metadata and main content of a download.  Make sure you always
     * call {@code close()}.
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

        /**
         * Copies all of {@code #body} to the given output stream.  As a convenience, also
         * returns {@code #metadata}.
         */
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
    // File uploads -- automatically choose between /files_put and /chunked_upload

    /**
     * A wrapper around {@link #uploadFile(String, DbxWriteMode, long, DbxStreamWriter)} that
     * lets you pass in an {@link InputStream}.  The entire stream {@code contents} will
     * be uploaded.
     *
     * <pre>
     * DbxClientV1 dbxClient = ...
     * File f = new File("ReadMe.txt")
     * dbxClient.uploadFile("/ReadMe.txt", {@link DbxWriteMode#add()}, f.length(), new FileInputStream(f))
     * </pre>
     *
     * @param targetPath
     *     The path to the file on Dropbox (see {@link DbxPathV1}).  If a file at
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
        return uploadFile(targetPath, writeMode, numBytes, new DbxStreamWriter.InputStreamCopier(contents));
    }

    /**
     * Upload file contents to Dropbox, getting contents from the given {@link DbxStreamWriter}.
     *
     * <pre>
     * DbxClientV1 dbxClient = ...
     * <b>// Create a file on Dropbox with 100 3-digit random numbers, one per line.</b>
     * final int numRandoms = 100;
     * int fileSize = numRandoms * 4;  <b>3 digits, plus a newline</b>
     * dbxClient.uploadFile("/Randoms.txt", {@link DbxWriteMode#add()}, fileSize,
     *     new DbxStreamWriter&lt;RuntimeException&gt;() {
     *         public void write(OutputStream out) throws IOException
     *         {
     *             Random rand = new Random();
     *             PrintWriter pw = new PrintWriter(out);
     *             for (int i = 0; i &lt; numRandoms; i++) {
     *                 pw.printf("%03d\n", rand.nextInt(1000));
     *             }
     *             pw.flush();
     *         }
     *     });
     * </pre>
     *
     * @param targetPath
     *     The path to the file on Dropbox (see {@link DbxPathV1}).  If a file at
     *     that path already exists on Dropbox, then the {@code writeMode} parameter
     *     will determine what happens.
     *
     * @param writeMode
     *     Determines what to do if there's already a file at the given {@code targetPath}.
     *
     * @param numBytes
     *     The number of bytes you're going to upload via the returned {@link DbxClientV1.Uploader}.
     *     Use {@code -1} if you don't know ahead of time.
     *
     * @param writer
     *     A callback that will be called when it's time to actually write out the
     *     body of the file.
     *
     * @throws E
     *     If {@code writer.write()} throws an exception, it will propagate out of this function.
     */
    public <E extends Throwable> DbxEntry.File uploadFile(String targetPath, DbxWriteMode writeMode, long numBytes, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        Uploader uploader = startUploadFile(targetPath, writeMode, numBytes);
        return finishUploadFile(uploader, writer);
    }

    private static final long ChunkedUploadThreshold = 8 * 1024 * 1024;
    private static final int ChunkedUploadChunkSize = 4 * 1024 * 1024;

    /**
     * Start an API request to upload a file to Dropbox.  Returns a {@link DbxClientV1.Uploader} object
     * that lets you actually send the file contents via {@link DbxClientV1.Uploader#getBody()}.  When
     * you're done copying the file body, call {@link DbxClientV1.Uploader#finish}.
     *
     * <p>
     * You need to close the {@link Uploader} when you're done with it.
     * Use a {@code try}/{@code finally} to make sure you close it in all cases.
     * </p>
     *
     * <pre>
     * DbxClientV1 dbxClient = ...
     * DbxClientV1.Uploader uploader = dbxClient.startUploadFile(...)
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
     *     The path to the file on Dropbox (see {@link DbxPathV1}).  If a file at
     *     that path already exists on Dropbox, then the {@code writeMode} parameter
     *     will determine what happens.
     *
     * @param writeMode
     *     Determines what to do if there's already a file at the given {@code targetPath}.
     *
     * @param numBytes
     *     The number of bytes you're going to upload via the returned {@link DbxClientV1.Uploader}.
     *     Use {@code -1} if you don't know ahead of time.
     */
    public Uploader startUploadFile(String targetPath, DbxWriteMode writeMode, long numBytes)
        throws DbxException
    {
        if (numBytes < 0) {
            if (numBytes != -1) {
                throw new IllegalArgumentException("numBytes must be -1 or greater; given " + numBytes);
            }
            // If the number of bytes isn't given in advance, use chunked uploads.
            return startUploadFileChunked(targetPath, writeMode, numBytes);
        }
        else if (numBytes > ChunkedUploadThreshold) {
            // If the number of bytes is more than some threshold, use chunked uploads.
            return startUploadFileChunked(targetPath, writeMode, numBytes);
        }
        else {
            // Otherwise, use the regular /files_put upload.
            return startUploadFileSingle(targetPath, writeMode, numBytes);
        }
    }

    public <E extends Throwable> DbxEntry.File finishUploadFile(Uploader uploader, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        NoThrowOutputStream streamWrapper = new NoThrowOutputStream(uploader.getBody());
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

    // --------------------------------------------------------
    // /files_put

    /**
     * Similar to {@link #uploadFile}, except always uses the /files_put API call.
     * One difference is that {@code numBytes} must not be negative.
     */
    public Uploader startUploadFileSingle(String targetPath, DbxWriteMode writeMode, long numBytes)
        throws DbxException
    {
        DbxPathV1.checkArg("targetPath", targetPath);
        if (numBytes < 0) throw new IllegalArgumentException("numBytes must be zero or greater");

        String host = this.host.content;
        String apiPath = "1/files_put/auto" + targetPath;

        ArrayList<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        headers.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        headers.add(new HttpRequestor.Header("Content-Length", Long.toString(numBytes)));

        HttpRequestor.Uploader uploader = DbxRequestUtil.startPut(requestConfig, accessToken, host, apiPath, writeMode.params, headers);

        return new SingleUploader(uploader, numBytes);
    }

    public <E extends Throwable> DbxEntry.File uploadFileSingle(String targetPath, DbxWriteMode writeMode, long numBytes, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        Uploader uploader = startUploadFileSingle(targetPath, writeMode, numBytes);
        return finishUploadFile(uploader, writer);
    }

    private static final class SingleUploader extends Uploader
    {
        private HttpRequestor./*@Nullable*/Uploader httpUploader;
        private final long claimedBytes;
        private final CountingOutputStream body;

        public SingleUploader(HttpRequestor.Uploader httpUploader, long claimedBytes)
        {
            if (claimedBytes < 0) {
                throw new IllegalArgumentException("'numBytes' must be greater than or equal to 0");
            }

            this.httpUploader = httpUploader;
            this.claimedBytes = claimedBytes;
            this.body = new CountingOutputStream(httpUploader.body);
        }

        public OutputStream getBody()
        {
            return this.body;
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
                bytesWritten = this.body.getBytesWritten();

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

            @SuppressWarnings("nullness")  // Workaround for bug in Checker Framework: https://code.google.com/p/checker-framework/issues/detail?id=293
            final HttpRequestor./*@Initialized*//*@NonNull*/Response nonNullResponse = response;

            return DbxRequestUtil.finishResponse(nonNullResponse, new DbxRequestUtil.ResponseHandler<DbxEntry.File>() {
                @Override
                public DbxEntry.File handle(HttpRequestor.Response response) throws DbxException
                {
                    if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                    DbxEntry.File f = DbxRequestUtil.readJsonFromResponse(DbxEntry.File.Reader, response.body);
                    // Make sure the server agrees with us on how many bytes are in the file.
                    if (f.numBytes != bytesWritten) {
                        throw new DbxException.BadResponse("we uploaded " + bytesWritten + ", but server returned metadata entry with file size " + f.numBytes);
                    }
                    return f;
                }
            });
        }
    }

    // -----------------------------------------------------------------
    // /chunked_upload, /commit_chunked_upload

    private static final class ChunkedUploadState extends Dumpable
    {
        public final String uploadId;
        public final long offset;

        public ChunkedUploadState(String uploadId, long offset)
        {
            if (uploadId == null) throw new IllegalArgumentException("'uploadId' can't be null");
            if (uploadId.length() == 0) throw new IllegalArgumentException("'uploadId' can't be empty");
            if (offset < 0) throw new IllegalArgumentException("'offset' can't be negative");
            this.uploadId = uploadId;
            this.offset = offset;
        }

        protected void dumpFields(DumpWriter w)
        {
            w.f("uploadId").v(uploadId);
            w.f("offset").v(offset);
        }

        public static final JsonReader<ChunkedUploadState> Reader = new JsonReader<ChunkedUploadState>()
        {
            @Override
            public ChunkedUploadState read(JsonParser parser) throws IOException, JsonReadException
            {
                JsonLocation top = JsonReader.expectObjectStart(parser);

                String uploadId = null;
                long bytesComplete = -1;

                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();

                    try {
                        if (fieldName.equals("upload_id")) {
                            uploadId = JsonReader.StringReader.readField(parser, fieldName, uploadId);
                        }
                        else if (fieldName.equals("offset")) {
                            bytesComplete = JsonReader.readUnsignedLongField(parser, fieldName, bytesComplete);
                        }
                        else {
                            JsonReader.skipValue(parser);
                        }
                    }
                    catch (JsonReadException ex) {
                        throw ex.addFieldContext(fieldName);
                    }
                }

                JsonReader.expectObjectEnd(parser);

                if (uploadId == null) throw new JsonReadException("missing field \"upload_id\"", top);
                if (bytesComplete == -1) throw new JsonReadException("missing field \"offset\"", top);

                return new ChunkedUploadState(uploadId, bytesComplete);
            }
        };
    }
    /**
     * Internal function called by both chunkedUploadFirst and chunkedUploadAppend.
     */
    private <E extends Throwable> HttpRequestor.Response chunkedUploadCommon(String[] params, long chunkSize, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        String apiPath = "1/chunked_upload";

        ArrayList<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        headers.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        headers.add(new HttpRequestor.Header("Content-Length", Long.toString(chunkSize)));

        HttpRequestor.Uploader uploader = DbxRequestUtil.startPut(requestConfig, accessToken, host.content, apiPath, params, headers);
        try {
            try {
                NoThrowOutputStream nt = new NoThrowOutputStream(uploader.body);
                writer.write(nt);
                long bytesWritten = nt.getBytesWritten();
                if (bytesWritten != chunkSize) {
                    throw new IllegalStateException("'chunkSize' is " + chunkSize + ", but 'writer' only wrote " + bytesWritten + " bytes");
                }
                return uploader.finish();
            }
            catch (IOException ex) {
                throw new DbxException.NetworkIO(ex);
            }
            catch (NoThrowOutputStream.HiddenException ex) {
                throw new DbxException.NetworkIO(ex.underlying);
            }
        }
        finally {
            uploader.close();
        }
    }

    private /*@Nullable*/ChunkedUploadState chunkedUploadCheckForOffsetCorrection(HttpRequestor.Response response)
        throws DbxException
    {
        if (response.statusCode != 400) return null;

        byte[] data = DbxRequestUtil.loadErrorBody(response);

        try {
            return ChunkedUploadState.Reader.readFully(data);
        }
        catch (JsonReadException ex) {
            // Couldn't parse out an offset correction message.  Treat it like a regular HTTP 400 then.
            throw new DbxException.BadRequest(DbxRequestUtil.parseErrorBody(400, data));
        }
    }

    private ChunkedUploadState chunkedUploadParse200(HttpRequestor.Response response)
        throws DbxException.BadResponse, DbxException.NetworkIO
    {
        assert response.statusCode == 200 : response.statusCode;
        return DbxRequestUtil.readJsonFromResponse(ChunkedUploadState.Reader, response.body);
    }

    /**
     * Equivalent to {@link #chunkedUploadFirst(byte[], int, int)
     * chunkedUploadFirst(data, 0, data.length)}.
     */
    public String chunkedUploadFirst(byte[] data)
        throws DbxException
    {
        return chunkedUploadFirst(data, 0, data.length);
    }

    /**
     * Upload the first chunk of a multi-chunk upload.
     *
     * @param data
     *    The data to append.
     * @param dataOffset
     *    The start offset in {@code data} to read from.
     * @param dataLength
     *    The number of bytes to read from {@code data}, starting from {@code dataOffset}.
     *
     * @return
     *    The ID designated by the Dropbox server to identify the chunked upload.
     */
    public String chunkedUploadFirst(byte[] data, int dataOffset, int dataLength)
        throws DbxException
    {
        return chunkedUploadFirst(dataLength, new DbxStreamWriter.ByteArrayCopier(data, dataOffset, dataLength));
    }

    /**
     * Upload the first chunk of a multi-chunk upload.
     *
     * @param chunkSize
     *    The number of bytes you're going to upload in this chunk.
     *
     * @param writer
     *     A callback that will be called when it's time to actually write out the
     *     body of the chunk.
     *
     * @return
     *    The ID designated by the Dropbox server to identify the chunked upload.
     */
    public <E extends Throwable> String chunkedUploadFirst(int chunkSize, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        HttpRequestor.Response response = chunkedUploadCommon(new String[0], chunkSize, writer);
        try {
            ChunkedUploadState correctedState = chunkedUploadCheckForOffsetCorrection(response);
            if (correctedState != null) {
                throw new DbxException.BadResponse("Got offset correction response on first chunk.");
            }

            if (response.statusCode == 404) {
                throw new DbxException.BadResponse("Got a 404, but we didn't send an upload_id");
            }

            if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
            ChunkedUploadState returnedState = chunkedUploadParse200(response);

            if (returnedState.offset != chunkSize) {
                throw new DbxException.BadResponse("Sent " + chunkSize + " bytes, but returned offset is " + returnedState.offset);
            }

            return returnedState.uploadId;
        }
        finally {
            IOUtil.closeInput(response.body);
        }
    }

    /**
     * Equivalent to {@link #chunkedUploadAppend(String, long, byte[], int, int)
     * chunkedUploadAppend(uploadId, uploadOffset, data, 0, data.length)}.
     */
    public long chunkedUploadAppend(String uploadId, long uploadOffset, byte[] data)
        throws DbxException
    {
        return chunkedUploadAppend(uploadId, uploadOffset, data, 0, data.length);
    }

    /**
     * Append data to a chunked upload session.
     *
     * @param uploadId
     *    The identifier returned by {@link #chunkedUploadFirst} to identify the chunked upload
     *    session.
     *
     * @param uploadOffset
     *    The current number of bytes uploaded to the chunked upload session.  The server checks
     *    this value to make sure it is correct.  If it is correct, the contents of {@code data}
     *    is appended and -1 is returned.  If it is incorrect, the correct offset is returned.
     *
     * @param data
     *    The data to append.
     *
     * @param dataOffset
     *    The start offset in {@code data} to read from.
     *
     * @param dataLength
     *    The number of bytes to read from {@code data}, starting from {@code dataOffset}.
     *
     * @return
     *    If everything goes correctly, returns {@code -1}.  If the given {@code offset} didn't
     *    match the actual number of bytes in the chunked upload session, returns the correct
     *    number of bytes.
     */
    public long chunkedUploadAppend(String uploadId, long uploadOffset, byte[] data, int dataOffset, int dataLength)
        throws DbxException
    {
        return chunkedUploadAppend(uploadId, uploadOffset, dataLength, new DbxStreamWriter.ByteArrayCopier(data, dataOffset, dataLength));
    }

    /**
     * Append a chunk of data to a chunked upload session.
     *
     * @param uploadId
     *    The identifier returned by {@link #chunkedUploadFirst} to identify the chunked upload
     *    session.
     *
     * @param uploadOffset
     *    The current number of bytes uploaded to the chunked upload session.  The server checks
     *    this value to make sure it is correct.  If it is correct, the contents of {@code data}
     *    is appended and -1 is returned.  If it is incorrect, the correct offset is returned.
     *
     * @param chunkSize
     *    The size of the chunk.
     *
     * @param writer
     *    A callback that will be called when it's time to actually write out the
     *    body of the chunk.
     *
     * @return
     *    If everything goes correctly, returns {@code -1}.  If the given {@code offset} didn't
     *    match the actual number of bytes in the chunked upload session, returns the correct
     *    number of bytes.
     */
    public <E extends Throwable> long chunkedUploadAppend(String uploadId, long uploadOffset, long chunkSize, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        if (uploadId == null) throw new IllegalArgumentException("'uploadId' can't be null");
        if (uploadId.length() == 0) throw new IllegalArgumentException("'uploadId' can't be empty");
        if (uploadOffset < 0) throw new IllegalArgumentException("'offset' can't be negative");

        String[] params = {
            "upload_id", uploadId,
            "offset", Long.toString(uploadOffset),
        };
        HttpRequestor.Response response = chunkedUploadCommon(params, chunkSize, writer);
        try {
            ChunkedUploadState correctedState = chunkedUploadCheckForOffsetCorrection(response);
            if (correctedState != null) {
                if (!correctedState.uploadId.equals(uploadId)) {
                    throw new DbxException.BadResponse("uploadId mismatch: us=" + jq(uploadId)
                                                       + ", server=" + jq(correctedState.uploadId));
                }

                if (correctedState.offset == uploadOffset) {
                    throw new DbxException.BadResponse("Corrected offset is same as given: " + uploadOffset);
                }

                return correctedState.offset;
            }

            if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
            ChunkedUploadState returnedState = chunkedUploadParse200(response);

            long expectedOffset = uploadOffset + chunkSize;
            if (returnedState.offset != expectedOffset) {
                throw new DbxException.BadResponse("Expected offset " + expectedOffset + " bytes, but returned offset is " + returnedState.offset);
            }

            return -1;
        }
        finally {
            IOUtil.closeInput(response.body);
        }
    }

    /**
     * Creates a file in the user's Dropbox at the given path, with file data previously uploaded
     * via {@link #chunkedUploadFirst} and {@link #chunkedUploadAppend}.
     *
     * @param targetPath
     *     The path to the file on Dropbox (see {@link DbxPathV1}).  If a file at
     *     that path already exists on Dropbox, then the {@code writeMode} parameter
     *     will determine what happens.
     *
     * @param writeMode
     *     Determines what to do if there's already a file at the given {@code targetPath}.
     *
     * @param uploadId
     *     The identifier returned by {@link #chunkedUploadFirst} to identify the uploaded data.
     */
    public DbxEntry.File chunkedUploadFinish(String targetPath, DbxWriteMode writeMode, String uploadId)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("targetPath", targetPath);

        String apiPath = "1/commit_chunked_upload/auto" + targetPath;

        String[] params = {
            "upload_id", uploadId,
        };
        params = LangUtil.arrayConcat(params, writeMode.params);

        return doPost(host.content, apiPath, params, null, new DbxRequestUtil.ResponseHandler<DbxEntry.File>() {
            @Override
            public DbxEntry.File handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(DbxEntry.File.Reader, response.body);
            }
        });
    }

    /**
     * Similar to {@link #startUploadFile}, except always uses the chunked upload API.
     */
    public Uploader startUploadFileChunked(String targetPath, DbxWriteMode writeMode, long numBytes)
    {
        return startUploadFileChunked(ChunkedUploadChunkSize, targetPath, writeMode, numBytes);
    }

    /**
     * Similar to {@link #startUploadFile}, except always uses the chunked upload API.
     */
    public Uploader startUploadFileChunked(int chunkSize, String targetPath, DbxWriteMode writeMode, long numBytes)
    {
        DbxPathV1.checkArg("targetPath", targetPath);
        if (writeMode == null) throw new IllegalArgumentException("'writeMode' can't be null");

        return new ChunkedUploader(targetPath, writeMode, numBytes, new ChunkedUploadOutputStream(chunkSize));
    }

    /**
     * Similar to {@link #uploadFile}, except always uses the chunked upload API.
     */
    public <E extends Throwable> DbxEntry.File uploadFileChunked(String targetPath, DbxWriteMode writeMode, long numBytes, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        Uploader uploader = startUploadFileChunked(targetPath, writeMode, numBytes);
        return finishUploadFile(uploader, writer);
    }

    /**
     * Similar to {@link #uploadFile}, except always uses the chunked upload API.
     */
    public <E extends Throwable> DbxEntry.File uploadFileChunked(int chunkSize, String targetPath, DbxWriteMode writeMode, long numBytes, DbxStreamWriter<E> writer)
        throws DbxException, E
    {
        Uploader uploader = startUploadFileChunked(chunkSize, targetPath, writeMode, numBytes);
        return finishUploadFile(uploader, writer);
    }

    private final class ChunkedUploader extends Uploader
    {
        private final String targetPath;
        private final DbxWriteMode writeMode;
        private final long numBytes;
        private final ChunkedUploadOutputStream body;

        private ChunkedUploader(String targetPath, DbxWriteMode writeMode, long numBytes, ChunkedUploadOutputStream body)
        {
            this.targetPath = targetPath;
            this.writeMode = writeMode;
            this.numBytes = numBytes;
            this.body = body;
        }

        @Override
        public OutputStream getBody()
        {
            return body;
        }

        @Override
        public void abort()
        {
            // TODO: Figure out how to abort chunked uploads.
        }

        @Override
        public DbxEntry.File finish()
            throws DbxException
        {
            if (body.uploadId == null) {
                // They didn't write enough data to fill up a chunk.  Use the regular file upload
                // call to create the file with a single call.
                return uploadFileSingle(targetPath, writeMode, body.chunkPos,
                                        new DbxStreamWriter.ByteArrayCopier(body.chunk, 0, body.chunkPos));
            }
            else {
                final String uploadId = body.uploadId;  // To help Checker Framework
                body.finishChunk();

                // Upload whatever is left in the current chunk.
                if (numBytes != -1) {
                    // Make sure the number of bytes they sent matches what they said they'd send.
                    if (numBytes != body.uploadOffset) {
                        throw new IllegalStateException("'numBytes' is " + numBytes + " but you wrote " + body.uploadOffset + " bytes");
                    }
                }
                return DbxRequestUtil.runAndRetry(3, new DbxRequestUtil.RequestMaker<DbxEntry.File, RuntimeException>() {
                    public DbxEntry.File run() throws DbxException {
                        return chunkedUploadFinish(targetPath, writeMode, uploadId);
                    }
                });
            }
        }

        @Override
        public void close()
        {
            // TODO: Figure out how to abort chunked uploads.
        }
    }

    private final class ChunkedUploadOutputStream extends OutputStream
    {
        private final byte[] chunk;
        private int chunkPos = 0;
        private /*@MonotonicNonNull*/String uploadId;
        private long uploadOffset;

        private ChunkedUploadOutputStream(int chunkSize)
        {
            this.chunk = new byte[chunkSize];
            this.chunkPos = 0;
        }

        @Override
        public void write(int i)
            throws IOException
        {
            chunk[chunkPos++] = (byte) i;
            try {
                finishChunkIfNecessary();
            }
            catch (DbxException ex) {
                throw new IODbxException(ex);
            }
        }

        private void finishChunkIfNecessary()
            throws DbxException
        {
            assert chunkPos <= chunk.length;
            if (chunkPos == chunk.length) {
                finishChunk();
            }
        }

        private void finishChunk()
            throws DbxException
        {
            if (chunkPos == 0) return;

            if (uploadId == null) {
                uploadId = DbxRequestUtil.runAndRetry(3, new DbxRequestUtil.RequestMaker<String, RuntimeException>() {
                    public String run() throws DbxException {
                        return chunkedUploadFirst(chunk, 0, chunkPos);
                    }
                });
                uploadOffset = chunkPos;
            } else {
                final String uploadId = this.uploadId;  // To help Checker Framework
                int arrayOffset = 0;
                while (true) {
                    final int arrayOffsetFinal = arrayOffset;
                    long correctedOffset = DbxRequestUtil.runAndRetry(3, new DbxRequestUtil.RequestMaker<Long, RuntimeException>() {
                        public Long run() throws DbxException {
                            return chunkedUploadAppend(uploadId, uploadOffset, chunk, arrayOffsetFinal, chunkPos-arrayOffsetFinal);
                        }
                    });
                    long expectedOffset = uploadOffset + chunkPos;
                    if (correctedOffset == -1) {
                        // Everything went ok.
                        uploadOffset = expectedOffset;
                        break;
                    } else {
                        // Make sure the returned offset is within what we expect.
                        assert correctedOffset != expectedOffset;
                        if (correctedOffset < uploadOffset) {
                            // Somehow the server lost track of the previous data we sent it.
                            throw new DbxException.BadResponse("we were at offset " + uploadOffset + ", server said " + correctedOffset);
                        }
                        else if (correctedOffset > expectedOffset) {
                            // Somehow the server has more data than we gave it!
                            throw new DbxException.BadResponse("we were at offset " + uploadOffset + ", server said " + correctedOffset);
                        }
                        // Server needs us to resend partial data.
                        int adjustAmount = (int) (correctedOffset - uploadOffset);
                        arrayOffset += adjustAmount;
                    }
                }
            }
            chunkPos = 0;
        }

        @Override
        public void write(byte[] bytes, int offset, int length)
            throws IOException
        {
            int inputEnd = offset + length;
            int inputPos = offset;
            while (inputPos < inputEnd) {
                int spaceInChunk = chunk.length - chunkPos;
                int leftToWrite = inputEnd - inputPos;
                int bytesToCopy = Math.min(leftToWrite, spaceInChunk);
                System.arraycopy(bytes, inputPos, chunk, chunkPos, bytesToCopy);
                chunkPos += bytesToCopy;
                inputPos += bytesToCopy;
                try {
                    finishChunkIfNecessary();
                }
                catch (DbxException ex) {
                    throw new IODbxException(ex);
                }
            }
        }

        @Override
        public void close()
            throws IOException
        {
        }
    }

    /**
     * A DbxException wrapped inside an IOException.  This is necessary because sometimes we
     * present an interface (such as OutputStream.write) that is only declared to throw
     * {@code IOException}, but we need to throw {@code DbxException}.
     */
    public static final class IODbxException extends IOException
    {
        public final DbxException underlying;

        public IODbxException(DbxException underlying)
        {
            super(underlying);
            this.underlying = underlying;
        }
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
    public DbxDelta<DbxEntry> getDelta(/*@Nullable*/String cursor, boolean includeMediaInfo)
        throws DbxException
    {
        return _getDelta(cursor, null, includeMediaInfo);
    }

    /**
     * Same as {@link #getDelta(String, boolean)} with {@code includeMediaInfo} set to {@code false}.
     */
    public DbxDelta<DbxEntry> getDelta(/*@Nullable*/String cursor)
        throws DbxException
    {
        return getDelta(cursor, false);
    }

    /**
     * A more generic version of {@link #getDelta}.  You provide a <em>collector</em>,
     * which lets you process the delta entries as they arrive over the network.
     */
    public <C> DbxDeltaC<C> getDeltaC(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector, /*@Nullable*/String cursor,
                                      boolean includeMediaInfo)
        throws DbxException
    {
        return _getDeltaC(collector, cursor, null, includeMediaInfo);
    }

    /**
     * Same as {@link #getDeltaC(Collector, String, boolean)} with {@code includeMediaInfo} set to {@code false}.
     */
    public <C> DbxDeltaC<C> getDeltaC(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector, /*@Nullable*/String cursor)
        throws DbxException
    {
        return getDeltaC(collector, cursor, false);
    }

    /**
     * Same as {@link #getDelta}, except results are limited to files and folders whose
     * paths are equal to or under the specified {@code pathPrefix}.
     *
     * <p>
     * The {@code pathPrefix} is fixed for a given cursor.  Whatever {@code pathPrefix}
     * you use on the first call to {@code getDelta()} must also be passed in on
     * subsequent calls that use the returned cursor.
     * </p>
     *
     * @param pathPrefix
     *    A path on Dropbox to limit results to.
     */
    public DbxDelta<DbxEntry> getDeltaWithPathPrefix(/*@Nullable*/String cursor, String pathPrefix,
                                                     boolean includeMediaInfo)
        throws DbxException
    {
        DbxPathV1.checkArg("path", pathPrefix);
        return _getDelta(cursor, pathPrefix, includeMediaInfo);
    }

    /**
     * Same as {@link #getDeltaWithPathPrefix(String, String, boolean)} with {@code includeMediaInfo}
     * set to {@code false}.
     */
    public DbxDelta<DbxEntry> getDeltaWithPathPrefix(/*@Nullable*/String cursor, String pathPrefix)
        throws DbxException
    {
        DbxPathV1.checkArg("path", pathPrefix);
        return _getDelta(cursor, pathPrefix, false);
    }

    /**
     * A more generic version of {@link #getDeltaWithPathPrefix}.  You provide a <em>collector</em>,
     * which lets you process the delta entries as they arrive over the network.
     */
    public <C> DbxDeltaC<C> getDeltaCWithPathPrefix(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector,
                                                    /*@Nullable*/String cursor, String pathPrefix,
                                                    boolean includeMediaInfo)
        throws DbxException
    {
        DbxPathV1.checkArg("path", pathPrefix);
        return _getDeltaC(collector, cursor, pathPrefix, includeMediaInfo);
    }

    /**
     * Same as {@link #getDeltaCWithPathPrefix(Collector, String, String, boolean)} with {@code includeMediaInfo}
     * set to {@code false}.
     */
    public <C> DbxDeltaC<C> getDeltaCWithPathPrefix(Collector<DbxDeltaC.Entry<DbxEntry>, C> collector,
                                                    /*@Nullable*/String cursor, String pathPrefix)
        throws DbxException
    {
        return getDeltaCWithPathPrefix(collector, cursor, pathPrefix, false);
    }

    private DbxDelta<DbxEntry> _getDelta(/*@Nullable*/String cursor, /*@Nullable*/String pathPrefix, boolean includeMediaInfo)
        throws DbxException
    {
        String host = this.host.api;
        String apiPath = "1/delta";

        /*@Nullable*/String[] params = {
            "cursor", cursor,
            "path_prefix", pathPrefix,
            "include_media_info", includeMediaInfo ? "true" : null,
        };

        return doPost(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<DbxDelta<DbxEntry>>() {
            @Override
            public DbxDelta<DbxEntry> handle(HttpRequestor.Response response) throws DbxException {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(
                        new DbxDelta.Reader<DbxEntry>(DbxEntry.Reader), response.body);
            }
        });
    }

    private <C> DbxDeltaC<C> _getDeltaC(final Collector<DbxDeltaC.Entry<DbxEntry>, C> collector,
                                        /*@Nullable*/String cursor, /*@Nullable*/String pathPrefix,
                                        boolean includeMediaInfo)
        throws DbxException
    {
        String host = this.host.api;
        String apiPath = "1/delta";

        /*@Nullable*/String[] params = {
            "cursor", cursor,
            "path_prefix", pathPrefix,
            "include_media_info", includeMediaInfo ? "true" : null,
        };

        return doPost(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<DbxDeltaC<C>>() {
            @Override
            public DbxDeltaC<C> handle(HttpRequestor.Response response) throws DbxException {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(
                        new DbxDeltaC.Reader<C, DbxEntry>(DbxEntry.Reader, collector), response.body);
            }
        });
    }

    /**
     * Get a cursor for the current state of a user's Dropbox folder. Can be passed to {@link #getDelta}
     * to retrieve changes since this method was called.
     */
    public String getDeltaLatestCursor(boolean includeMediaInfo) throws DbxException
    {
        return _getDeltaLatestCursor(null, includeMediaInfo);
    }

    /**
     * Same as {@link #getDeltaLatestCursor(boolean)} with {@code includeMediaInfo}
     * set to {@code false}.
     */
    public String getDeltaLatestCursor() throws DbxException
    {
        return _getDeltaLatestCursor(null, false);
    }

    /**
     * Same as {@link #getDeltaLatestCursor}, except the cursor is limited to files and folders whose
     * paths are equal to or under the specified {@code pathPrefix}.
     *
     * @param pathPrefix
     *    A path on Dropbox to limit the cursor to.
     */
    public String getDeltaLatestCursorWithPathPrefix(String pathPrefix, boolean includeMediaInfo) throws DbxException
    {
        DbxPathV1.checkArg("path", pathPrefix);
        return _getDeltaLatestCursor(pathPrefix, includeMediaInfo);
    }

    /**
     * Same as {@link #getDeltaLatestCursorWithPathPrefix(String, boolean)} with {@code includeMediaInfo}
     * set to {@code false}.
     */
    public String getDeltaLatestCursorWithPathPrefix(String pathPrefix) throws DbxException
    {
        return getDeltaLatestCursorWithPathPrefix(pathPrefix, false);
    }

    private String _getDeltaLatestCursor(/*@Nullable*/String pathPrefix, boolean includeMediaInfo) throws DbxException
    {
        String host = this.host.api;
        String apiPath = "1/delta/latest_cursor";

        /*@Nullable*/String[] params = {
            "path_prefix", pathPrefix,
            "include_media_info", includeMediaInfo ? "true" : null,
        };

        return doPost(host, apiPath, params, null, new DbxRequestUtil.ResponseHandler<String>() {
            @Override
            public String handle(HttpRequestor.Response response) throws DbxException {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(LatestCursorReader, response.body);
            }
        });
    }

    private static JsonReader<String> LatestCursorReader = new JsonReader<String>() {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String cursorId = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("cursor")) {
                        cursorId = JsonReader.StringReader.readField(parser, fieldName, cursorId);
                    } else {
                        JsonReader.skipValue(parser);
                    }
                } catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);

            if (cursorId == null) throw new JsonReadException("missing field \"cursor\"", top);

            return cursorId;
        }
    };

    /**
     * Waits for changes to files on an account, starting from the state represented by {@code cursor}.
     *
     * @param cursor
     *          A cursor returned by ono of the "delta" methods.
     *
     * @param timeout
     *          How long poll should run before timing out, in seconds.
     */
    public DbxLongpollDeltaResult getLongpollDelta(String cursor, int timeout)
        throws DbxException
    {
        if (cursor == null) throw new IllegalArgumentException("'cursor' can't be null");
        if (timeout < 30 || timeout > 480) throw new IllegalArgumentException("'timeout' must be >=30 and <= 480");
        String[] params = {
                "cursor", cursor,
                "timeout", Integer.toString(timeout),
        };

        return DbxRequestUtil.doGet(getRequestConfig(), getAccessToken(), host.notify,
            "1/longpoll_delta", params, null,
            new DbxRequestUtil.ResponseHandler<DbxLongpollDeltaResult>()
            {
                @Override
                public DbxLongpollDeltaResult handle(HttpRequestor.Response response)
                    throws DbxException
                {
                    if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                    return DbxRequestUtil.readJsonFromResponse(DbxLongpollDeltaResult.Reader, response.body);
                }
            });
    }

    // -----------------------------------------------------------------
    // /thumbnails

    /**
     * Downloads a thumbnail for the image file at the given path in Dropbox.
     *
     * @param sizeBound
     *    The returned thumbnail will never be greater than the dimensions given here.
     *
     * @param format
     *    The image format to use for thumbnail data.
     *
     * @param path
     *    The path to the image file on Dropbox.
     *
     * @param rev
     *    The {@link DbxEntry.File#rev rev} of the file on Dropbox
     *    or {@code null} if you want the latest revision of the file.
     *
     * @param target
     *    The stream to write the thumbnail image data to.
     *
     * @return
     *    The metadata for the original file (not the thumbnail) or {@code null} if there
     *    is no file at that path.
     */
    public DbxEntry./*@Nullable*/File getThumbnail(
            DbxThumbnailSize sizeBound, DbxThumbnailFormat format,
            String path, /*@Nullable*/String rev, OutputStream target)
            throws DbxException, IOException
    {
        if (target == null) throw new IllegalArgumentException("'target' can't be null");

        Downloader downloader = startGetThumbnail(sizeBound, format, path, rev);
        if (downloader == null) return null;
        return downloader.copyBodyAndClose(target);
    }

    /**
     * Similar to {@link #getThumbnail}, except the thumbnail contents are returned via
     * a {@link Downloader}.
     */
    public /*@Nullable*/Downloader startGetThumbnail(
            DbxThumbnailSize sizeBound, DbxThumbnailFormat format, String path, /*@Nullable*/String rev)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);
        if (sizeBound == null) throw new IllegalArgumentException("'size' can't be null");
        if (format == null) throw new IllegalArgumentException("'format' can't be null");

        String apiPath = "1/thumbnails/auto" + path;
        /*@Nullable*/String[] params = {
            "size", sizeBound.ident,
            "format", format.ident,
            "rev", rev,
        };

        return startGetSomething(apiPath, params);
    }

    // -----------------------------------------------------------------

    /**
     * Gets the metadata for the current and past revisions of a file (up to some limit) at
     * a given path.
     *
     * @param path
     *     The Dropbox path that you want file revision metadata for.
     *
     * @return
     *     A list of metadata objects, one for each file revision.
     */
    public List<DbxEntry.File> getRevisions(String path)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);

        String apiPath = "1/revisions/auto" + path;

        return doGet(host.api, apiPath, null, null, new DbxRequestUtil.ResponseHandler<List<DbxEntry.File>>() {
            public List<DbxEntry.File> handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                Collector<DbxEntry./*@Nullable*/File,ArrayList<DbxEntry.File>> collector =
                    Collector.NullSkipper.<DbxEntry.File,ArrayList<DbxEntry.File>>mk(new Collector.ArrayListCollector<DbxEntry.File>());
                return DbxRequestUtil.readJsonFromResponse(JsonArrayReader.mk(DbxEntry.File.ReaderMaybeDeleted, collector), response.body);
            }
        });
    }

    /**
     * Takes a copy of the file at the given revision and saves it over the current latest copy.
     * This will create a new revision, but the file contents will match the revision you
     * specified.
     *
     * @param path
     *     The Dropbox path of the file to restore.
     *
     * @param rev
     *     The revision of the file you want to use to overwrite the latest revision.
     *
     * @return
     *     If the specified {@code path}/{@code rev} couldn't be found, return {@code null}.
     *     Otherwise, return metadata for the newly-created latest revision of the file.
     */
    public DbxEntry./*@Nullable*/File restoreFile(String path, String rev)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);
        if (rev == null) throw new IllegalArgumentException("'rev' can't be null");
        if (rev.length() == 0) throw new IllegalArgumentException("'rev' can't be empty");

        String apiPath = "1/restore/auto" + path;
        /*@Nullable*/String[] params = {
            "rev", rev,
        };

        return doGet(host.api, apiPath, params, null, new DbxRequestUtil.ResponseHandler<DbxEntry./*@Nullable*/File>() {
            public DbxEntry./*@Nullable*/File handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(DbxEntry.File.Reader, response.body);
            }
        });
    }

    /**
     * Returns metadata for all files and folders whose name matches the query string.
     *
     * @param basePath
     *    The path to search under (recursively).  Pass in {@code "/"} to search everything.
     * @param query
     *    A space-separated list of substrings to search for.  A file matches only if it contains
     *    all the substrings.
     * @return
     *    The list of metadata entries that match the search query.
     */
    public List<DbxEntry> searchFileAndFolderNames(String basePath, String query)
        throws DbxException
    {
        DbxPathV1.checkArg("basePath", basePath);
        if (query == null) throw new IllegalArgumentException("'query' can't be null");
        if (query.length() == 0) throw new IllegalArgumentException("'query' can't be empty");

        String apiPath = "1/search/auto" + basePath;
        String[] params = {"query", query};

        return doPost(host.api, apiPath, params, null, new DbxRequestUtil.ResponseHandler<List<DbxEntry>>()
        {
            @Override
            public List<DbxEntry> handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(JsonArrayReader.mk(DbxEntry.Reader), response.body);
            }
        });
    }

    /**
     * Creates and returns a publicly-shareable URL to a file or folder's "preview page".
     * This URL can be used without authentication.  The preview page may contain a thumbnail or
     * some other preview of the file, along with a link to download the actual filel.
     *
     * @param path
     *     The Dropbox path to a file or folder.
     *
     * @return
     *     If there is no file or folder at that path, return {@code null}.  Otherwise return
     *     a shareable URL.
     */
    public /*@Nullable*/String createShareableUrl(String path)
        throws DbxException
    {
        DbxPathV1.checkArg("path", path);

        String apiPath = "1/shares/auto" + path;
        String[] params = {"short_url", "false"};

        return doPost(host.api, apiPath, params, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/String>() {
            @Override
            public /*@Nullable*/String handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                DbxUrlWithExpiration uwe = DbxRequestUtil.readJsonFromResponse(DbxUrlWithExpiration.Reader, response.body);
                return uwe.url;
            }
        });
    }

    /**
     * Creates and returns a publicly-shareable URL to a file's contents.  This URL can be used
     * without authentication.  This link will stop working after a few hours.
     *
     * @param path
     *     The Dropbox path to a file.
     *
     * @return
     *     If there is no file at that path, return {@code null}.  Otherwise return
     *     a shareable URL along with the expiration time.
     */
    public /*@Nullable*/DbxUrlWithExpiration createTemporaryDirectUrl(String path)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);

        String apiPath = "1/media/auto" + path;

        return doPost(host.api, apiPath, null, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/DbxUrlWithExpiration>() {
            @Override
            public /*@Nullable*/DbxUrlWithExpiration handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(DbxUrlWithExpiration.Reader, response.body);
            }
        });
    }

    /**
     * Creates and returns a "copy ref" to a file.  A copy ref can be used to copy a file across
     * different Dropbox accounts without downloading and re-uploading.
     *
     * <p>
     * For example, create a {@code DbxClientV1} using the access token from one account and call
     * {@code createCopyRef}.  Then, create a {@code DbxClientV1} using the access token for another
     * account and call {@code copyFromCopyRef} using the copy ref.
     * </p>
     *
     * <p>
     * A copy ref created by an app can only be used by that app.
     * </p>
     *
     * @param path
     *     The Dropbox path to a file.
     *
     * @return
     *     The copy ref's identifier, suitable for passing in to {@link #copyFromCopyRef},
     *     or {@code null} if the specified path does not exist.
     */
    public /*@Nullable*/String createCopyRef(String path)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);

        String apiPath = "1/copy_ref/auto" + path;

        return doPost(host.api, apiPath, null, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/String>()
        {
            @Override
            public /*@Nullable*/String handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode == 404) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                CopyRef copyRef = DbxRequestUtil.readJsonFromResponse(CopyRef.Reader, response.body);
                return copyRef.id;
            }
        });
    }

    private static final class CopyRef
    {
        public final String id;
        public final Date expires;

        private CopyRef(String id, Date expires)
        {
            this.id = id;
            this.expires = expires;
        }

        public static final JsonReader<CopyRef> Reader = new JsonReader<CopyRef>() {
            @Override
            public CopyRef read(JsonParser parser)
                throws IOException, JsonReadException
            {
                JsonLocation top = JsonReader.expectObjectStart(parser);

                String id = null;
                Date expires = null;

                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();

                    try {
                        if (fieldName.equals("copy_ref")) {
                            id = JsonReader.StringReader.readField(parser, fieldName, id);
                        }
                        else if (fieldName.equals("expires")) {
                            expires = JsonDateReader.Dropbox.readField(parser, fieldName, expires);
                        }
                        else {
                            JsonReader.skipValue(parser);
                        }
                    }
                    catch (JsonReadException ex) {
                        throw ex.addFieldContext(fieldName);
                    }
                }

                JsonReader.expectObjectEnd(parser);

                if (id == null) throw new JsonReadException("missing field \"copy_ref\"", top);
                if (expires == null) throw new JsonReadException("missing field \"expires\"", top);

                return new CopyRef(id, expires);
            }
        };
    }

    /**
     * Copy a file or folder from one path in Dropbox to another path in Dropbox.
     *
     * @return
     *    If successful, returns the metadata for new copy of the file or folder,
     *    otherwise returns {@code null}.
     */
    public /*@Nullable*/DbxEntry copy(String fromPath, String toPath)
        throws DbxException
    {
        DbxPathV1.checkArg("fromPath", fromPath);
        DbxPathV1.checkArgNonRoot("toPath", toPath);

        String[] params = {
            "root", "auto",
            "from_path", fromPath,
            "to_path", toPath,
        };

        return doPost(host.api, "1/fileops/copy", params, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/DbxEntry>() {
            @Override
            public /*@Nullable*/DbxEntry handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode == 403) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                DbxEntry.WithChildren dwc = DbxRequestUtil.readJsonFromResponse(DbxEntry.WithChildren.Reader, response.body);
                if (dwc == null) return null;  // TODO: When can this happen?
                return dwc.entry;
            }
        });
    }

    /**
     * Create a file or folder at {@code toPath} based on the given copy ref (created with
     * {@link #createCopyRef}).
     */
    public /*@Nullable*/DbxEntry copyFromCopyRef(String copyRef, String toPath)
        throws DbxException
    {
        if (copyRef == null) throw new IllegalArgumentException("'copyRef' can't be null");
        if (copyRef.length() == 0) throw new IllegalArgumentException("'copyRef' can't be empty");
        DbxPathV1.checkArgNonRoot("toPath", toPath);

        String[] params = {
            "root", "auto",
            "from_copy_ref", copyRef,
            "to_path", toPath,
        };

        return doPost(host.api, "1/fileops/copy", params, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/DbxEntry>()
        {
            @Override
            public /*@Nullable*/DbxEntry handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                DbxEntry.WithChildren dwc = DbxRequestUtil.readJsonFromResponse(DbxEntry.WithChildren.Reader, response.body);
                if (dwc == null) return null;  // TODO: When can this happen?
                return dwc.entry;
            }
        });
    }

    /**
     * Create a new folder in Dropbox.
     *
     * @return
     *    If successful, returns the metadata for the newly created folder, otherwise
     *    returns {@code null}.
     */
    public DbxEntry./*@Nullable*/Folder createFolder(String path)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);

        String[] params = {
            "root", "auto",
            "path", path,
        };

        return doPost(host.api, "1/fileops/create_folder", params, null, new DbxRequestUtil.ResponseHandler<DbxEntry./*@Nullable*/Folder>() {
            @Override
            public DbxEntry./*@Nullable*/Folder handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode == 403) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(DbxEntry.Folder.Reader, response.body);
            }
        });
    }

    /**
     * Delete a file or folder from Dropbox.
     */
    public void delete(String path)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("path", path);

        String[] params = {
            "root", "auto",
            "path", path,
        };

        doPost(host.api, "1/fileops/delete", params, null, new DbxRequestUtil.ResponseHandler<Void>() {
            @Override
            public Void handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return null;
            }
        });
    }

    /**
     * Move a file or folder from one path in Dropbox to another path in Dropbox.
     *
     * @return
     *    If successful, returns the metadata for the file or folder at its new location,
     *    otherwise returns {@code null}.
     */
    public /*@Nullable*/DbxEntry move(String fromPath, String toPath)
        throws DbxException
    {
        DbxPathV1.checkArgNonRoot("fromPath", fromPath);
        DbxPathV1.checkArgNonRoot("toPath", toPath);

        String[] params = {
            "root", "auto",
            "from_path", fromPath,
            "to_path", toPath,
        };

        return doPost(host.api, "1/fileops/move", params, null, new DbxRequestUtil.ResponseHandler</*@Nullable*/DbxEntry>()
        {
            @Override
            public /*@Nullable*/DbxEntry handle(HttpRequestor.Response response)
                throws DbxException
            {
                if (response.statusCode == 403) return null;
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                DbxEntry.WithChildren dwc = DbxRequestUtil.readJsonFromResponse(DbxEntry.WithChildren.Reader, response.body);
                if (dwc == null) return null;  // TODO: In what situations can this happen?
                return dwc.entry;
            }
        });
    }

    // --------------------------------------------------------

    // Convenience function that calls RequestUtil.doGet with the first two parameters filled in.
    private <T> T doGet(String host, String path, /*@Nullable*/String/*@Nullable*/[] params,
                        /*@Nullable*/ArrayList<HttpRequestor.Header> headers,
                        DbxRequestUtil.ResponseHandler<T> handler)
        throws DbxException
    {
        return DbxRequestUtil.doGet(requestConfig, accessToken, host, path, params, headers, handler);
    }

    // Convenience function that calls RequestUtil.doPost with the first two parameters filled in.
    public <T> T doPost(String host, String path,
                        /*@Nullable*/String/*@Nullable*/[] params,
                        /*@Nullable*/ArrayList<HttpRequestor.Header> headers,
                        DbxRequestUtil.ResponseHandler<T> handler)
        throws DbxException
    {
        return DbxRequestUtil.doPost(requestConfig, accessToken, host, path, params, headers, handler);
    }

    /**
     * For uploading file content to Dropbox.  Write stuff to the {@link #getBody} stream.
     *
     * <p>
     * Don't call {@code close()} directly on the {@link #getBody}.  Instead call either
     * call either {@link #finish} or {@link #close} to make sure the stream and other
     * resources are released.  A safe idiom is to use the object within a {@code try}
     * block and put a call to {@link #close()} in the {@code finally} block.
     * </p>
     *
     * <pre>
     * DbxClientV1.Uploader uploader = ...
     * try {
     *     uploader.body.write("Hello, world!".getBytes("UTF-8"));
     *     uploader.finish();
     * }
     * finally {
     *     uploader.close();
     * }
     * </pre>
     */
    public static abstract class Uploader
    {
        public abstract OutputStream getBody();

        /**
         * Cancel the upload.
         */
        public abstract void abort();

        /**
         * Release the resources related to this {@code Uploader} instance.  If
         * {@code close()} or {@link #abort()} has already been called, this does nothing.
         * If neither has been called, this is equivalent to calling {@link #abort()}.
         */
        public abstract void close();

        /**
         * When you're done writing the file contents to {@link #getBody}, call this
         * to indicate that you're done.  This will actually finish the underlying HTTP
         * request and return the uploaded file's {@link DbxEntry}.
         */
        public abstract DbxEntry.File finish() throws DbxException;
    }
}
