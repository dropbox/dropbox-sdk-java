package com.dropbox.core.examples.upload_file;

import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.RetryException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxPathV2;
import com.dropbox.core.v2.files.CommitInfo;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.dropbox.core.v2.files.UploadSessionCursor;
import com.dropbox.core.v2.files.UploadSessionFinishErrorException;
import com.dropbox.core.v2.files.UploadSessionLookupErrorException;
import com.dropbox.core.v2.files.UploadSessionOffsetError;
import com.dropbox.core.v2.files.WriteMode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Locale;

/**
 * An example command-line application that runs through the web-based OAuth
 * flow (using {@link DbxWebAuth}).
 */
public class Main {
    private static final long CHUNKED_UPLOAD_CHUNK_SIZE = 4L << 20; // 4MiB
    private static final int CHUNKED_UPLOAD_MAX_ATTEMPTS = 20;

    private static void uploadFile(DbxClientV2 dbxClient, File localFile, String dropboxPath) {
        try (InputStream in = new FileInputStream(localFile)) {
            FileMetadata metadata = dbxClient.files().uploadBuilder(dropboxPath)
                .withMode(WriteMode.ADD)
                .withClientModified(new Date(localFile.lastModified()))
                .uploadAndFinish(in);

            System.out.println(metadata.toStringMultiline());
        } catch (UploadErrorException ex) {
            System.err.println("Error uploading to Dropbox: " + ex.getMessage());
            System.exit(1);
        } catch (DbxException ex) {
            System.err.println("Error uploading to Dropbox: " + ex.getMessage());
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error reading from file \"" + localFile + "\": " + ex.getMessage());
            System.exit(1);
        }
    }

    private static void chunkedUploadFile(DbxClientV2 dbxClient, File localFile, String dropboxPath) {
        long size = localFile.length();

        // assert our file is at least the chunk upload size
        if (size < CHUNKED_UPLOAD_CHUNK_SIZE) {
            System.err.println("File too small, use upload() instead.");
            System.exit(1);
            return;
        }

        long uploaded = 0L;
        DbxException thrown = null;

        // Chunked uploads have 3 phases, each of which can accept uploaded bytes:
        //
        //    (1)  Start: initiate the upload and get an upload session ID
        //    (2) Append: upload chunks of the file to append to our session
        //    (3) Finish: commit the upload and close the session
        //
        // We track how many bytes we uploaded to determine which phase we should be in.
        String sessionId = null;
        for (int i = 0; i < CHUNKED_UPLOAD_MAX_ATTEMPTS; ++i) {
            if (i > 0) {
                System.out.printf("Retrying chunked upload (%d / %d attempts)\n", i + 1, CHUNKED_UPLOAD_MAX_ATTEMPTS);
            }

            try (InputStream in = new FileInputStream(localFile)) {
                // if this is a retry, make sure seek to the correct offset
                in.skip(uploaded);

                // (1) Start
                if (sessionId == null) {
                    sessionId = dbxClient.files().uploadSessionStart()
                        .uploadAndFinish(in, CHUNKED_UPLOAD_CHUNK_SIZE)
                        .getSessionId();
                    uploaded += CHUNKED_UPLOAD_CHUNK_SIZE;
                    printProgress(uploaded, size);
                }

                // (2) Append
                while ((size - uploaded) > CHUNKED_UPLOAD_CHUNK_SIZE) {
                    dbxClient.files().uploadSessionAppend(sessionId, uploaded)
                        .uploadAndFinish(in, CHUNKED_UPLOAD_CHUNK_SIZE);
                    uploaded += CHUNKED_UPLOAD_CHUNK_SIZE;
                    printProgress(uploaded, size);
                }

                // (3) Finish
                long remaining = size - uploaded;
                UploadSessionCursor cursor = new UploadSessionCursor(sessionId, uploaded);
                CommitInfo commitInfo = CommitInfo.newBuilder(dropboxPath)
                    .withMode(WriteMode.ADD)
                    .withClientModified(new Date(localFile.lastModified()))
                    .build();
                FileMetadata metadata = dbxClient.files().uploadSessionFinish(cursor, commitInfo)
                    .uploadAndFinish(in, remaining);

                System.out.println(metadata.toStringMultiline());
                return;
            } catch (RetryException ex) {
                thrown = ex;
                // RetryExceptions are never automatically retried by the client for uploads. Must
                // catch this exception even if DbxRequestConfig.getMaxRetries() > 0.
                sleepQuietly(ex.getBackoffMillis());
                continue;
            } catch (NetworkIOException ex) {
                thrown = ex;
                // network issue with Dropbox (maybe a timeout?) try again
                continue;
            } catch (UploadSessionLookupErrorException ex) {
                thrown = ex;
                // server offset into the stream doesn't match our offset (uploaded). Seek to
                // the expected offset according to the server and try again.
                if (ex.errorValue.isIncorrectOffset()) {
                    System.out.printf("%s: current offset: %d, expected offset: %d\n", sessionId, uploaded, ex.errorValue
                                      .getIncorrectOffsetValue()
                                      .getCorrectOffset());
                    uploaded = ex.errorValue
                        .getIncorrectOffsetValue()
                        .getCorrectOffset();
                    continue;
                }
                System.err.println("Error uploading to Dropbox: " + ex.getMessage());
                System.exit(1);
                return;
            } catch (UploadSessionFinishErrorException ex) {
                thrown = ex;
                // server offset into the stream doesn't match our offset (uploaded). Seek to
                // the expected offset according to the server and try again.
                if (ex.errorValue.isLookupFailed() && ex.errorValue.getLookupFailedValue().isIncorrectOffset()) {
                    uploaded = ex.errorValue
                        .getLookupFailedValue()
                        .getIncorrectOffsetValue()
                        .getCorrectOffset();
                    continue;
                }
                System.err.println("Error uploading to Dropbox: " + ex.getMessage());
                System.exit(1);
                return;
            } catch (DbxException ex) {
                System.err.println("Error uploading to Dropbox: " + ex.getMessage());
                System.exit(1);
                return;
            } catch (IOException ex) {
                System.err.println("Error reading from file \"" + localFile + "\": " + ex.getMessage());
                System.exit(1);
                return;
            }
        }

        // if we made it here, then we must have run out of attempts
        System.err.println("Maxed out upload attempts to Dropbox. Most recent error: " + thrown.getMessage());
        System.exit(1);
    }

    private static void printProgress(long uploaded, long size) {
        System.out.printf("Uploaded %12d / %12d bytes (%5.2f%%)\n", uploaded, size, 100 * (uploaded / (double) size));
    }

    private static void sleepQuietly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            // just exit
            System.err.println("Error uploading to Dropbox: interrupted during backoff.");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws IOException {
        // Only display important log messages.
        Logger.getLogger("").setLevel(Level.WARNING);

        if (args.length == 0) {
            System.out.println("");
            System.out.println("Usage: COMMAND <auth-file> <local-path> <dropbox-path>");
            System.out.println("");
            System.out.println(" <auth-file>: An \"auth file\" that contains the information necessary to make");
            System.out.println("    an authorized Dropbox API request.  Generate this file using the \"authorize\"");
            System.out.println("    example program.");
            System.out.println("");
            System.out.println(" <local-path>: The path to a local file whose contents you want to upload.");
            System.out.println("");
            System.out.println(" <dropbox-path>: The path on Dropbox to save the file to.");
            System.out.println("");
            System.exit(1);
        }

        if (args.length != 3) {
            System.err.println("Expecting exactly 3 arguments, got " + args.length + ".");
            System.err.println("Run with no arguments for help.");
            System.exit(1);
        }

        String argAuthFile = args[0];
        String localPath = args[1];
        String dropboxPath = args[2];

        // Read auth info file.
        DbxAuthInfo authInfo;
        try {
            authInfo = DbxAuthInfo.Reader.readFromFile(argAuthFile);
        } catch (JsonReader.FileLoadException ex) {
            System.err.println("Error loading <auth-file>: " + ex.getMessage());
            System.exit(1);
            return;
        }

        String pathError = DbxPathV2.findError(dropboxPath);
        if (pathError != null) {
            System.err.println("Invalid <dropbox-path>: " + pathError);
            System.exit(1);
            return;
        }

        File localFile = new File(localPath);
        if (!localFile.exists()) {
            System.err.println("Invalid <local-path>: file does not exist.");
            System.exit(1);
            return;
        }

        if (!localFile.isFile()) {
            System.err.println("Invalid <local-path>: not a file.");
            System.exit(1);
            return;
        }


        // Create a DbxClientV2, which is what you use to make API calls.
        String userLocale = Locale.getDefault().toString();
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-upload-file", userLocale);
        DbxClientV2 dbxClient = new DbxClientV2(requestConfig, authInfo.getAccessToken(), authInfo.getHost());

        // upload the file with simple upload API if it is small enough, otherwise use chunked
        // upload API for better performance.
        if (localFile.length() < CHUNKED_UPLOAD_CHUNK_SIZE) {
            uploadFile(dbxClient, localFile, dropboxPath);
        } else {
            chunkedUploadFile(dbxClient, localFile, dropboxPath);
        }

        System.exit(0);
    }
}
