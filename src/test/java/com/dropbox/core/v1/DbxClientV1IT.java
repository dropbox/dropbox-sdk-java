package com.dropbox.core.v1;

import static com.dropbox.core.util.StringUtil.jq;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.dropbox.core.DbxStreamWriter;
import com.dropbox.core.ITUtil;
import com.dropbox.core.util.Dumpable;
import com.dropbox.core.util.IOUtil;

import com.dropbox.core.util.Maybe;
import com.dropbox.core.util.StringUtil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

// integration test
public class DbxClientV1IT {
    private String testFolder;
    private DbxClientV1 client;

    @BeforeMethod
    private void setup() throws Exception {
        this.client = ITUtil.newClientV1();
        this.testFolder = ITUtil.root(DbxClientV1IT.class);
        assertThat(client.createFolder(testFolder)).isNotNull();
    }

    @AfterMethod
    private void cleanup() throws Exception {
        if (client != null) {
            client.delete(testFolder);
        }
        client =  null;
        testFolder = null;
    }

    private String p(String path) {
        return this.testFolder + "/" + path;
    }

    private String p() {
        return this.testFolder;
    }

    private static final String E_ACCENT = "\u00e9";

    @Test
    public void testAccountInfo() throws Exception {
        client.getAccountInfo();
    }

    @Test
    public void testUploadAndDownload() throws Exception {
        byte[] contents = StringUtil.stringToUtf8("A simple test file");

        String remotePath = p("test-fil" + E_ACCENT + ".txt");

        DbxEntry.File up = client.uploadFile(remotePath, DbxWriteMode.add(), contents.length, new ByteArrayInputStream(contents));
        assertThat(up.path).isEqualTo(remotePath);
        assertThat(up.numBytes).isEqualTo(contents.length);

        ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
        DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
        byte[] downBody = downBodyStream.toByteArray();

        assertThat(up.numBytes).isEqualTo(down.numBytes);
        assertThat(up.numBytes).isEqualTo(downBody.length);
    }

    private DbxEntry.File addFile(String path, int length) throws Exception {
        return uploadFile(path, length, DbxWriteMode.add());
    }

    private DbxEntry.File uploadFile(String path, int length, DbxWriteMode writeMode) throws Exception {
        return client.uploadFile(path, writeMode, length, new ByteArrayInputStream(generateRandomBytes(length)));
    }

    private static byte[] generateRandomBytes(int numBytes) {
        byte[] data = new byte[numBytes];
        Random random = new Random();
        for (int i = 0; i < numBytes; i++) {
            String randomFileData = "\nabcdefghijklmnopqrstuvwxyz0123456789";
            data[i] = (byte) randomFileData.charAt(random.nextInt(randomFileData.length()));
        }
        return data;
    }

    @Test
    public void testMetadata() throws Exception {
        addFile(p("a.txt"), 100);

        {
            DbxEntry entry = client.getMetadata(p("a.txt"));
            assertThat(entry.path).isEqualTo(p("a.txt"));
            assertThat(entry instanceof DbxEntry.File).isTrue();
            DbxEntry.File f = (DbxEntry.File) entry;
            assertThat(f.numBytes).isEqualTo(100);

            DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p("a.txt"));
            assertThat(mwc.entry).isEqualTo(entry);
        }

        // Containing folder.
        {
            DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
            assertThat(mwc.children.size()).isEqualTo(1);

            // Folder metadata should be the same if we call /metadata again.
            Maybe<DbxEntry.WithChildren> r2 = client.getMetadataWithChildrenIfChanged(p(), mwc.hash);
            assertThat(r2.isNothing()).isTrue();
        }

        // File not found.
        {
            DbxEntry entry = client.getMetadata(p("does not exists.txt"));
            assertThat(entry).isNull();

            DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p("does not exist.txt"));
            assertThat(mwc).isNull();
        }
    }

    // too flaky, enable once fixed
    @Test(enabled=false)
    public void testDelta() throws Exception {
        // NOTE: In these tests, we never actually perform a non-path-prefix /delta call.  This is so that
        // you can run these tests against a Dropbox account that is having modifications performed on it
        // by other clients.  This is unfortunate, so maybe we should switch to requiring that the test
        // be run on an account that has nothing else going on?

        // Get latest cursors before modifying dropbox folders
        String latestCursor = client.getDeltaLatestCursor();
        String latestCursorWithPath = client.getDeltaLatestCursorWithPathPrefix(p("b"));
        assertThat(latestCursor).isNotNull();
        assertThat(latestCursorWithPath).isNotNull();

        DbxEntry.Folder top = (DbxEntry.Folder) client.getMetadata(p());
        DbxEntry.File a = addFile(p("a.txt"), 10);
        DbxEntry.Folder b = client.createFolder(p("b"));
        DbxEntry.File b_1 = addFile(p("b/1.txt"), 20);
        DbxEntry.File b_2 = addFile(p("b/2.txt"), 30);
        DbxEntry.Folder c = client.createFolder(p("b/c"));
        DbxEntry.File c_1 = addFile(p("b/c/1.txt"), 40);
        DbxEntry.File c_2 = addFile(p("b/c/2.txt"), 50);

        // getDelta
        {
            HashSet<DbxEntry> expected = new HashSet<DbxEntry>(Arrays.asList(top, a, b, b_1, b_2, c, c_1, c_2));

            String lcPrefix = p().toLowerCase();
            String cursor = null;
            while (true) {
                DbxDelta<DbxEntry> d = client.getDelta(cursor);
                for (DbxDelta.Entry<DbxEntry> e : d.entries) {
                    if (e.lcPath.startsWith(lcPrefix+"/") || e.lcPath.equals(lcPrefix)) {
                        assertThat(e.metadata).isNotNull();  // We shouldn't see deletes in our test folder.
                        boolean removed = expected.remove(e.metadata);
                        assertThat(removed).isTrue();
                    }
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertThat(expected.size()).isEqualTo(0);
        }

        // getDeltaWithPathPrefix
        {
            HashSet<DbxEntry> expected = new HashSet<DbxEntry>(Arrays.asList(b, b_1, b_2, c, c_1, c_2));

            String prefix = b.path;
            String lcPrefix = prefix.toLowerCase();
            String cursor = null;
            while (true) {
                DbxDelta<DbxEntry> d = client.getDeltaWithPathPrefix(cursor, prefix);
                for (DbxDelta.Entry<DbxEntry> e : d.entries) {
                    assertThat(e.lcPath.startsWith(lcPrefix+"/") || e.lcPath.equals(lcPrefix)).isTrue();
                    assertThat(e.metadata).isNotNull();  // We should never see deletes.
                    boolean removed = expected.remove(e.metadata);
                    assertThat(removed).isTrue();
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertThat(expected.size()).isEqualTo(0);
        }

        // Test latest cursor responses
        {
            HashSet<DbxEntry> expected = new HashSet<DbxEntry>(Arrays.asList(a, b, b_1, b_2, c, c_1, c_2));
            String lcPrefix = p().toLowerCase();
            String cursor = latestCursor;
            while (true) {
                DbxDelta<DbxEntry> d = client.getDelta(cursor);
                for (DbxDelta.Entry<DbxEntry> e : d.entries) {
                    assertThat(e.lcPath.startsWith(lcPrefix+"/") || e.lcPath.equals(lcPrefix)).isTrue();
                    assertThat(e.metadata).isNotNull();  // We shouldn't see deletes in our test folder.
                    boolean removed = expected.remove(e.metadata);
                    assertThat(removed).isTrue();
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertThat(expected.size()).isEqualTo(0);
        }

        // Test latest cursor with path prefix
        {
            HashSet<DbxEntry> expected = new HashSet<DbxEntry>(Arrays.asList(b, b_1, b_2, c, c_1, c_2));

            String prefix = b.path;
            String lcPrefix = prefix.toLowerCase();
            String cursor = latestCursorWithPath;
            while (true) {
                DbxDelta<DbxEntry> d = client.getDeltaWithPathPrefix(cursor, prefix);
                for (DbxDelta.Entry<DbxEntry> e : d.entries) {
                    assertThat(e.lcPath.startsWith(lcPrefix+"/") || e.lcPath.equals(lcPrefix)).isTrue();
                    assertThat(e.metadata).isNotNull();  // We should never see deletes.
                    boolean removed = expected.remove(e.metadata);
                    assertThat(removed).isTrue();
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertThat(expected.size()).isEqualTo(0);
        }

        // Test longpoll_delta
        {
            DbxLongpollDeltaResult longpollDelta = client.getLongpollDelta(latestCursor, 30);
            assertThat(longpollDelta.mightHaveChanges).isTrue();
        }
    }

    @Test
    public void testRevisionsAndRestore() throws Exception {
        String path = p("r"+E_ACCENT+"visions.txt");

        DbxEntry.File e2 = uploadFile(path, 100, DbxWriteMode.force());
        assertThat(client.getRevisions(path).size()).isEqualTo(1);
        client.delete(path);
        assertThat(client.getRevisions(path).size()).isEqualTo(1);
        DbxEntry.File e1 = uploadFile(path, 200, DbxWriteMode.force());
        DbxEntry.File e0 = uploadFile(path, 300, DbxWriteMode.force());

        List<DbxEntry.File> mds = client.getRevisions(path);
        assertThat(mds.size()).isEqualTo(3);

        assertThat(mds.get(0)).isEqualTo(e0);
        assertThat(mds.get(1)).isEqualTo(e1);
        assertThat(mds.get(2)).isEqualTo(e2);

        DbxEntry.File r1 = client.restoreFile(path, e1.rev);
        assertThat(r1.numBytes).isEqualTo(e1.numBytes);
        DbxEntry.File r2 = client.restoreFile(path, e2.rev);
        assertThat(r2.numBytes).isEqualTo(e2.numBytes);
    }

    @Test
    public void testSearch() throws Exception {
        addFile(p("search - a.txt"), 100);
        client.createFolder(p("sub"));
        addFile(p("sub/search - b.txt"), 200);

        List<DbxEntry> results;

        results = client.searchFileAndFolderNames(p(), "search");
        assertThat(results.size()).isEqualTo(2);

        results = client.searchFileAndFolderNames(p("sub"), "search");
        assertThat(results.size()).isEqualTo(1);

        results = client.searchFileAndFolderNames(p(), "a.txt");
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).name).isEqualTo("search - a.txt");
    }

    private static byte[] downloadUrl(String urlS) throws Exception {
        URL url = new URL(urlS);
        InputStream in = url.openStream();
        try {
            return IOUtil.slurp(in, 10 * 1000);
        }
        finally {
            IOUtil.closeInput(in);
        }
    }

    @Test
    public void testSharableUrl() throws Exception {
        byte[] contents = StringUtil.stringToUtf8("A shared text file");
        String path = p("share-me.txt");
        client.uploadFile(path, DbxWriteMode.add(), contents.length, new ByteArrayInputStream(contents));

        URL previewUrl = new URL(client.createShareableUrl(path));

        // Preview page should be larger than the original content.
        byte[] previewPage = downloadUrl(previewUrl.toString());
        assertThat(previewPage.length > contents.length).isTrue();

        // Direct download should match exactly.
        URL directUrl = new URL(
            previewUrl.getProtocol(),
            client.getHost().getContent(),
            previewUrl.getPort(),
            previewUrl.getFile()
        );
        byte[] directContents = downloadUrl(directUrl.toString());
        assertThat(directContents).isEqualTo(contents);
    }

    @Test
    public void testTemporaryDirectUrl() throws Exception {
        byte[] contents = StringUtil.stringToUtf8("A media text file");
        String path = p("media-me.txt");
        client.uploadFile(path, DbxWriteMode.add(), contents.length, new ByteArrayInputStream(contents));

        DbxUrlWithExpiration uwe = client.createTemporaryDirectUrl(path);

        byte[] downloadedContents = downloadUrl(uwe.url);
        assertThat(downloadedContents).isEqualTo(contents);
    }

    @Test
    public void testCopyRefFile() throws Exception {
        String source = p("copy-ref me.txt");
        String dest = p("done!.txt");
        int size = 1024;

        addFile(source, size);
        String copyRef = client.createCopyRef(source);

        DbxEntry.File destMd = client.copyFromCopyRef(copyRef, dest).asFile();
        assertThat(size).isEqualTo(destMd.numBytes);

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertThat(mwc.children.size()).isEqualTo(2);
    }

    @Test
    public void testCopyRefFolder() throws Exception {
        String source = p("some folder");
        client.createFolder(source);
        addFile(source + "/a.txt", 10);
        addFile(source + "/b.txt", 20);

        String dest = p("copied folder");
        String copyRef = client.createCopyRef(source);
        DbxEntry r = client.copyFromCopyRef(copyRef, dest);

        assertThat(r.isFolder()).isTrue();
        assertThat(r.path).isEqualTo(dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertThat(c.children.size()).isEqualTo(2);
    }

    @Test
    public void testCopyRefEmptyFolder() throws Exception {
        String source = p("empty folder");
        client.createFolder(source);

        String dest = p("copied empty folder");
        String copyRef = client.createCopyRef(source);
        DbxEntry r = client.copyFromCopyRef(copyRef, dest);

        assertThat(r.isFolder()).isTrue();
        assertThat(r.path).isEqualTo(dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertThat(c.children.size()).isEqualTo(0);
    }

    @Test
    public void testPhotoInfo() throws Exception {
        final String folder = p("photo-info-folder");
        final String orig = folder + "/test-imag"+E_ACCENT+".jpeg";

        // Upload an image.
        InputStream in = this.getClass().getResourceAsStream("/test-image.jpeg");
        if (in == null) {
            throw new AssertionError("couldn't load test image \"test-image.jpeg\"");
        }
        DbxEntry.File uploadEntry;
        try {
            uploadEntry = client.uploadFile(orig, DbxWriteMode.add(), -1, in).asFile();
        }
        finally {
            IOUtil.closeInput(in);
        }
        assertThat(uploadEntry.path.toLowerCase()).isEqualTo(orig.toLowerCase());

        // Get metadata with photo info (keep trying until photo info is available)
        int maxTries = 30;
        int delaySeconds = 2;
        DbxEntry.File origEntry;
        for (int tries = 0; ; tries++) {
            if (tries == maxTries) {
                int waited = delaySeconds * tries;
                throw new AssertionError("Photo info was pending after " + waited + " seconds.  Server slowness?");
            }
            Thread.sleep(delaySeconds * 1000);
            origEntry = client.getMetadata(orig, true).asFile();
            if (origEntry.photoInfo == DbxEntry.File.PhotoInfo.PENDING) break;
        }

        assertThat(origEntry.path.toLowerCase()).isEqualTo(orig.toLowerCase());
        assertThat(origEntry.photoInfo).isNotNull();

        // List folder with photo info.
        DbxEntry.File childEntry = client.getMetadataWithChildren(folder, true).children.get(0).asFile();
        assertThat(childEntry).isEqualTo(origEntry);
    }

    @Test
    public void testThumbnail() throws Exception {
        String orig = p("test-imag" + E_ACCENT + ".jpeg");

        // Upload an image.
        InputStream in = this.getClass().getResourceAsStream("/test-image.jpeg");
        if (in == null) {
            throw new AssertionError("couldn't load test image \"test-image.jpeg\"");
        }
        DbxEntry.File origMD;
        try {
            origMD = client.uploadFile(orig, DbxWriteMode.add(), -1, in);
        }
        finally {
            IOUtil.closeInput(in);
        }

        BufferedImage origImage = ImageIO.read(getClass().getResource("/test-image.jpeg"));
        int origW = origImage.getWidth();
        int origH = origImage.getHeight();

        DbxThumbnailFormat[] formats = { DbxThumbnailFormat.JPEG, DbxThumbnailFormat.PNG, };
        DbxThumbnailSize[] sizes = {
            DbxThumbnailSize.w32h32,
            DbxThumbnailSize.w64h64,
            DbxThumbnailSize.w64h64,
            DbxThumbnailSize.w640h480,
            DbxThumbnailSize.w1024h768,
        };

        for (DbxThumbnailFormat format : formats) {

            long prevSize = 0;
            ImageReader reader = getImageReaderForFormat(format);

            for (DbxThumbnailSize size : sizes) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                DbxEntry.File md = client.getThumbnail(size, format, orig, null, out);
                byte[] data = out.toByteArray();

                assertThat(removeMediaInfo(origMD)).isEqualTo(removeMediaInfo(md));

                // We're getting bigger and bigger thumbnails, so they should have more bytes
                // than the previous ones.
                assertThat(data.length > prevSize).isTrue();

                reader.setInput(new MemoryCacheImageInputStream(new ByteArrayInputStream(data)));
                int w = reader.getWidth(0);
                int h = reader.getHeight(0);
                int expectedW = Math.min(size.width, origW);
                int expectedH = Math.min(size.width, origH);
                assertWithMessage("expected = " + expectedW + "x" + expectedH + ", got = " + w + "x" + h)
                        .that((w == expectedW && h <= expectedH) || (h == expectedH && w <= expectedW)).isTrue();
            }
        }
    }

    private static DbxEntry.File removeMediaInfo(DbxEntry.File e) {
        return new DbxEntry.File(e.path, e.iconName, e.mightHaveThumbnail, e.numBytes, e.humanSize,
                                 e.lastModified, e.clientMtime, e.rev);
    }

    private static ImageReader getImageReaderForFormat(DbxThumbnailFormat format) {
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(format.ident);

        if (!readers.hasNext()) {
            throw new AssertionError("no ImageReader for " + jq(format.ident));
        }
        ImageReader reader = readers.next();
        if (readers.hasNext()) {
            throw new AssertionError("multiple ImageReaders for " + jq(format.ident));
        }
        return reader;
    }

    @Test
    public void testChunkedUpload() throws Exception {
        byte[] contents = StringUtil.stringToUtf8("A simple test file");
        int chunkSize = 7;
        assertThat(contents.length % chunkSize).isNotEqualTo(0);  // Make sure the last chunk is not full-sized.


        // Pass in the correct file size.
        {
            String remotePath = p("test-fil" + E_ACCENT + ".txt");
            DbxEntry.File up = client.uploadFileChunked(chunkSize, remotePath, DbxWriteMode.add(),
                                                        contents.length, new DbxStreamWriter.ByteArrayCopier(contents));
            assertThat(up.path).isEqualTo(remotePath);
            assertThat(up.numBytes).isEqualTo(contents.length);

            ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
            DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
            byte[] downBody = downBodyStream.toByteArray();

            assertThat(up.numBytes).isEqualTo(down.numBytes);
            assertThat(downBody).isEqualTo(contents);
        }

        // Pass in "-1" for file size.
        {
            String remotePath = p("test-fil" + E_ACCENT + "-2.txt");
            DbxEntry.File up = client.uploadFileChunked(chunkSize, remotePath, DbxWriteMode.add(),
                                                        -1, new DbxStreamWriter.ByteArrayCopier(contents));
            assertThat(up.path).isEqualTo(remotePath);
            assertThat(up.numBytes).isEqualTo(contents.length);

            ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
            DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
            byte[] downBody = downBodyStream.toByteArray();

            assertThat(up.numBytes).isEqualTo(down.numBytes);
            assertThat(downBody).isEqualTo(contents);
        }

        // Try uploading a file that is smaller than the first chunk.
        {
            String remotePath = p("test-fil" + E_ACCENT + "-3.txt");
            DbxEntry.File up = client.uploadFileChunked(contents.length + 2, remotePath, DbxWriteMode.add(),
                                                        -1, new DbxStreamWriter.ByteArrayCopier(contents));
            assertThat(up.path).isEqualTo(remotePath);
            assertThat(up.numBytes).isEqualTo(contents.length);

            ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
            DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
            byte[] downBody = downBodyStream.toByteArray();

            assertThat(up.numBytes).isEqualTo(down.numBytes);
            assertThat(downBody).isEqualTo(contents);
        }
    }

    @Test
    public void testCopyFile() throws Exception {
        String source = p("copy m" + E_ACCENT + ".txt");
        String dest = p("ok - copi" + E_ACCENT + "d.txt");
        int size = 1024;

        addFile(source, size);
        DbxEntry.File md = client.copy(source, dest).asFile();
        assertThat(md.numBytes).isEqualTo(size);
        assertThat(md.path).isEqualTo(dest);

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertThat(mwc.children.size()).isEqualTo(2);
    }

    @Test
    public void testCopyFolder() throws Exception {
        String source = p("some folder");
        client.createFolder(source);
        addFile(source + "/a.txt", 10);
        addFile(source + "/b.txt", 20);

        String dest = p("copied folder");
        DbxEntry r = client.copy(source, dest);

        assertThat(r.isFolder()).isTrue();
        assertThat(r.path).isEqualTo(dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertThat(c.children.size()).isEqualTo(2);
    }

    @Test
    public void testCopyEmptyFolder() throws Exception {
        String source = p("empty folder");
        client.createFolder(source);

        String dest = p("copied empty folder");
        DbxEntry r = client.copy(source, dest);

        assertThat(r.isFolder()).isTrue();
        assertThat(r.path).isEqualTo(dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertThat(c.children.size()).isEqualTo(0);
    }

    @Test
    public void testCreateFolder() throws Exception {
        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertThat(mwc.children.size()).isEqualTo(0);

        client.createFolder(p("a"));
        mwc = client.getMetadataWithChildren(p());
        assertThat(mwc.children.size()).isEqualTo(1);

        DbxEntry folderMd = client.getMetadata(p("a"));
        assertThat(folderMd.isFolder()).isTrue();
    }

    @Test
    public void testDelete() throws Exception {
        String path = p("delete m" + E_ACCENT + ".txt");
        int size = 1024;

        addFile(path, size);
        client.delete(path);

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertThat(mwc.children.size()).isEqualTo(0);
    }

    @Test
    public void testMoveFile() throws Exception {
        String source = p("move me.txt");
        String dest = p("ok - moved.txt");
        int size = 1024;

        addFile(source, size);
        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertThat(mwc.children.size()).isEqualTo(1);

        DbxEntry.File destMd = client.move(source, dest).asFile();
        assertThat(destMd.numBytes).isEqualTo(size);

        mwc = client.getMetadataWithChildren(p());
        assertThat(mwc.children.size()).isEqualTo(1);
    }

    @Test
    public void testMoveFolder() throws Exception {
        String source = p("some folder");
        client.createFolder(source);
        addFile(source + "/a.txt", 10);
        addFile(source + "/b.txt", 20);

        String dest = p("moved folder");
        DbxEntry r = client.move(source, dest);

        assertThat(r.isFolder()).isTrue();
        assertThat(r.path).isEqualTo(dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertThat(c.children.size()).isEqualTo(2);

        // Make sure source is now gone.
        DbxEntry deleted = client.getMetadata(source);
        assertThat(deleted == null).isTrue();
    }

    @Test
    public void testMoveEmptyFolder() throws Exception {
        String source = p("empty folder");
        client.createFolder(source);

        String dest = p("moved empty folder");
        DbxEntry r = client.move(source, dest);

        assertThat(r.isFolder()).isTrue();
        assertThat(r.path).isEqualTo(dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertThat(c.children.size()).isEqualTo(0);

        // Make sure source is now gone.
        DbxEntry deleted = client.getMetadata(source);
        assertThat(deleted == null).isTrue();
    }
}
