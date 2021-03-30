package com.dropbox.core.v2;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Locale;

import com.dropbox.core.util.IOUtil.ProgressListener;
import org.testng.annotations.Test;

import com.dropbox.core.BadRequestException;
import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.ITUtil;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.GetMetadataError;
import com.dropbox.core.v2.files.GetMetadataErrorException;
import com.dropbox.core.v2.files.LookupError;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.WriteMode;
import com.dropbox.core.v2.users.BasicAccount;
import com.dropbox.core.v2.users.FullAccount;

public class DbxClientV2IT {
    @Test
    public void testAccountInfo() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2();

        FullAccount full = client.users().getCurrentAccount();
        assertThat(full).isNotNull();
        assertThat(full.getName()).isNotNull();
        assertThat(full.getAccountId()).isNotNull();

        BasicAccount basic = client.users().getAccount(full.getAccountId());
        assertThat(basic).isNotNull();
        assertThat(basic.getName()).isNotNull();
        assertThat(basic.getAccountId()).isEqualTo(full.getAccountId());
    }

    @Test
    public void testUploadAndDownload() throws Exception {
        testUploadAndDownload(ITUtil.newClientV2(), false);
    }

    @Test
    public void testUploadAndDownloadWithProgress() throws Exception {

        testUploadAndDownload(ITUtil.newClientV2(), true);
    }

    @Test
    public void testOkHttpClientStreamingUpload() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2(ITUtil.newRequestConfig()
            .withHttpRequestor(ITUtil.newOkHttpRequestor())
            .build()
        );
        testUploadAndDownload(client, false);
    }

    @Test
    public void testOkHttp3ClientStreamingUpload() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2(ITUtil.newRequestConfig()
            .withHttpRequestor(ITUtil.newOkHttp3Requestor())
            .build()
        );
        testUploadAndDownload(client, false);
    }

    @Test
    public void testOkHttp3ClientStreamingUploadWithProgress() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2(ITUtil.newRequestConfig()
                .withHttpRequestor(ITUtil.newOkHttp3Requestor())
                .build()
        );
        testUploadAndDownload(client, true);
    }

    private void testUploadAndDownload(DbxClientV2 client, boolean trackProgress) throws Exception {
        final byte [] contents = ITUtil.randomBytes(1024 << 8);
        String filename = "testUploadAndDownload.dat";
        String path = ITUtil.path(getClass(), "/" + filename);

        ProgressListener progressListener = null;
        if (trackProgress) {
            progressListener = createTestListener(contents.length);
        }

        FileMetadata metadata = client.files().uploadBuilder(path)
                .withAutorename(false)
                .withMode(WriteMode.ADD)
                .withMute(true)
                .uploadAndFinish(new ByteArrayInputStream(contents), progressListener);

        assertThat(metadata.getName()).isEqualTo(filename);
        assertThat(metadata.getPathLower()).isEqualTo(path.toLowerCase());
        assertThat(metadata.getSize()).isEqualTo(contents.length);

        Metadata actual = client.files().getMetadata(path);
        assertWithMessage(actual.getClass().getCanonicalName()).that(actual instanceof FileMetadata).isTrue();
        assertThat(actual).isEqualTo(metadata);

        if (trackProgress) {
            progressListener = createTestListener(contents.length);
        }

        DbxDownloader<FileMetadata> downloader = client.files().download(path);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        downloader.download(out, progressListener);

        byte [] actualContents = out.toByteArray();
        FileMetadata actualResult = downloader.getResult();

        assertThat(actualResult).isEqualTo(metadata);
        assertThat(actualContents).isEqualTo(contents);
        assertThat(downloader.getContentType()).isEqualTo("application/octet-stream");

        Metadata deleted = client.files().delete(path);
        assertThat(deleted).isEqualTo(metadata);
    }

    @Test
    public void testRangeDownload() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2();

        byte [] contents = ITUtil.randomBytes(500);
        String path = ITUtil.path(getClass(), "/testRangeDownload.dat");

        FileMetadata metadata = client.files().uploadBuilder(path)
            .withAutorename(false)
            .withMode(WriteMode.OVERWRITE)
            .withMute(true)
            .uploadAndFinish(new ByteArrayInputStream(contents));

        assertThat(metadata.getSize()).isEqualTo(contents.length);

        assertRangeDownload(client, path, contents, 0, contents.length);
        assertRangeDownload(client, path, contents, 0, 200);
        assertRangeDownload(client, path, contents, 300, 200);
        assertRangeDownload(client, path, contents, 499, 1);
        assertRangeDownload(client, path, contents, 0, 600);
        assertRangeDownload(client, path, contents, 250, null);
    }

    @Test
    public void testDownloadBuilder() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2();
        String now = ITUtil.format(new Date());

        byte [] rtfV1 = ITUtil.toBytes("{\rtf1 sample {\b v1} (" + now + ")}");
        byte [] rtfV2 = ITUtil.toBytes("{\rtf1 sample {\b v2} (" + now + ")}");

        String path = ITUtil.path(getClass(), "/testDownloadBuilder/" + now + ".rtf");

        FileMetadata metadataV1 = client.files().uploadBuilder(path)
            .withAutorename(false)
            .withMode(WriteMode.ADD)
            .withMute(true)
            .uploadAndFinish(new ByteArrayInputStream(rtfV1));

        assertThat(metadataV1.getPathLower()).isEqualTo(path.toLowerCase());

        FileMetadata metadataV2 = client.files().uploadBuilder(path)
            .withAutorename(false)
            .withMode(WriteMode.OVERWRITE)
            .withMute(true)
            .uploadAndFinish(new ByteArrayInputStream(rtfV2));

        assertThat(metadataV2.getPathLower()).isEqualTo(path.toLowerCase());

        // ensure we have separate revisions
        assertThat(metadataV1.getRev()).isNotEqualTo(metadataV2.getRev());

        // now use download builder to set revision and make sure it works properly
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        client.files().downloadBuilder(path)
            .withRev(metadataV1.getRev())
            .download(out);
        assertThat(out.toByteArray()).isEqualTo(rtfV1);

        out = new ByteArrayOutputStream();
        client.files().downloadBuilder(path)
            .withRev(metadataV2.getRev())
            .download(out);
        assertThat(out.toByteArray()).isEqualTo(rtfV2);

        // ensure we still keep the non-builder optional route in our generator (for
        // backwards-compatibility)
        out = new ByteArrayOutputStream();
        client.files().download(path, metadataV1.getRev()).download(out);
        assertThat(out.toByteArray()).isEqualTo(rtfV1);

        out = new ByteArrayOutputStream();
        client.files().download(path, metadataV2.getRev()).download(out);
        assertThat(out.toByteArray()).isEqualTo(rtfV2);

        // and ensure we keep the required-only route
        out = new ByteArrayOutputStream();
        client.files().download(path).download(out);
        assertThat(out.toByteArray()).isEqualTo(rtfV2);
    }

    @Test(expectedExceptions={GetMetadataErrorException.class})
    public void testError409() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2();

        String path = ITUtil.path(getClass(), "/testError409/" + ITUtil.format(new Date()));

        try {
            client.files().getMetadata(path);
        } catch (GetMetadataErrorException ex) {
            assertThat(ex.getRequestId()).isNotNull();
            if (ex.getUserMessage() != null) {
                assertThat(ex.getUserMessage().getLocale()).isNotNull();
                assertThat(ex.getUserMessage().getText()).isNotNull();
                assertThat(ex.getUserMessage().toString()).isNotNull();
            }

            GetMetadataError err = ex.errorValue;
            assertThat(err).isNotNull();
            assertThat(err.tag()).isEqualTo(GetMetadataError.Tag.PATH);
            assertThat(err.isPath()).isTrue();

            LookupError lookup = err.getPathValue();
            assertThat(lookup).isNotNull();
            assertThat(lookup.tag()).isEqualTo(LookupError.Tag.NOT_FOUND);
            assertThat(lookup.isNotFound()).isTrue();
            assertThat(lookup.isNotFile()).isFalse();
            assertThat(lookup.isOther()).isFalse();
            assertThat(lookup.isMalformedPath()).isFalse();

            // raise so test can confirm an exception was thrown
            throw ex;
        }
    }

    @Test(expectedExceptions={BadRequestException.class})
    public void testError400() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2();

        // NOTE: if we become more lenient on the server, this test will have to change.
        String badCursor = "thisisabadcursor_dropbox-sdk-java_test";

        try {
            client.files().listFolderContinue(badCursor);
        } catch (BadRequestException ex) {
            assertThat(ex.getRequestId()).isNotNull();
            throw ex;
        }
    }

    @Test(enabled=false) // re-enable after T90620 is fixed
    public void testUserLocale() throws Exception {
        assertUserMessageLocale(Locale.ENGLISH); // en
        assertUserMessageLocale(Locale.UK); // en-UK
        assertUserMessageLocale(Locale.FRENCH); // fr
        assertUserMessageLocale(Locale.FRANCE); // fr-FR

        // Use user's Dropbox locale preference
        DbxClientV2 client = ITUtil.newClientV2(ITUtil.newRequestConfig().withUserLocaleFromPreferences());
        try {
            client.sharing().getFolderMetadata("-1");
        } catch (DbxApiException ex) {
            assertThat(ex.getUserMessage()).isNotNull();
            assertThat(ex.getUserMessage().getLocale()).isNotNull();
            assertThat(ex.getUserMessage().getLocale()).isNotEqualTo(""); // make sure something is specified
        }
    }

    private static void assertRangeDownload(DbxClientV2 client, String path, byte [] contents, int start, Integer length) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream(contents.length);
        byte [] expected;
        if (length != null) {
            expected = new byte[Math.min(length, contents.length - start)];
            client.files().downloadBuilder(path)
                .range(start, length.intValue())
                .download(out);
        } else {
            expected = new byte[contents.length - start];
            client.files().downloadBuilder(path)
                .range(start)
                .download(out);
        }

        System.arraycopy(contents, start, expected, 0, expected.length);
        byte [] actual = out.toByteArray();

        assertThat(actual).isEqualTo(expected);
    }

    private static void assertUserMessageLocale(Locale locale) throws Exception {
        DbxClientV2 client = ITUtil.newClientV2(ITUtil.newRequestConfig().withUserLocaleFrom(locale));
        try {
            client.sharing().getFolderMetadata("-1");
        } catch (DbxApiException ex) {
            assertThat(ex.getUserMessage()).isNotNull();
            assertThat(ex.getUserMessage().getLocale()).isNotNull();
            if (ex.getUserMessage().getLocale().contains("-")) {
                // TODO: update this test to properly support language tags when we upgrade away
                // from Java 6
                assertThat(ex.getUserMessage().getLocale()).isEqualTo(toLanguageTag(locale));
            } else {
                // omit the country code
                assertThat(ex.getUserMessage().getLocale()).isEqualTo(locale.getLanguage());
            }
        }
    }

    private static String toLanguageTag(Locale locale) {
        StringBuilder sb = new StringBuilder();

        sb.append(locale.getLanguage().toLowerCase());

        if (!locale.getCountry().isEmpty()) {
            sb.append("-");
            sb.append(locale.getCountry().toUpperCase());
        }

        return sb.toString();
    }

    private static ProgressListener createTestListener(final long totalLength) {
        return new ProgressListener() {
            private long lastBytesWritten = 0;
            @Override
            public void onProgress(long bytesWritten) {
                assertThat(bytesWritten > lastBytesWritten).isTrue();
                assertThat(bytesWritten <= totalLength).isTrue();
                lastBytesWritten = bytesWritten;
            }
        };
    }
}
