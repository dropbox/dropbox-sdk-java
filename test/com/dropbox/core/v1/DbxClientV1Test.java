package com.dropbox.core.v1;

import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxStreamWriter;
import com.dropbox.core.http.OkHttpRequestor;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.IOUtil;
import static com.dropbox.core.util.StringUtil.jq;

import com.dropbox.core.util.Maybe;
import com.dropbox.core.util.StringUtil;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class DbxClientV1Test
{
    private String testFolder;
    private DbxClientV1 client;

    /**
     * Every test must explicitly invoke this function so the reporting.
     */
    // I tried using an @BeforeMethod annotation, but when I did that, any exceptions that this
    // method threw weren't reported in the output.
    private void init()
        throws DbxException
    {
        String authInfoFile = System.getProperty("dbxAuthInfoFile");
        if (authInfoFile == null) {
            throw new RuntimeException("System property \"dbxAuthInfoFile\" not set.");
        }

        DbxAuthInfo authInfo;
        try {
            authInfo = DbxAuthInfo.Reader.readFromFile(authInfoFile);
        }
        catch (JsonReader.FileLoadException ex) {
            throw new RuntimeException("Error reading auth info from \"" + authInfoFile + "\": " + ex.getMessage());
        }

        DbxRequestConfig requestConfig;
        String okHttp = System.getProperty("okHttp");
        if (okHttp == null || okHttp.equals("false")) {
            requestConfig = new DbxRequestConfig("sdk-test", null);
        } else if (okHttp.equals("true")) {
            requestConfig = new DbxRequestConfig("sdk-test", null, OkHttpRequestor.Instance);
        } else {
            throw new RuntimeException("Invalid value for System property \"okHttp\"." +
                    " Expecting \"true\" or \"false\", got " + jq(okHttp) + ".");
        }

        DbxClientV1 client = new DbxClientV1(requestConfig, authInfo.accessToken, authInfo.host);

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
        String basePath = "/Java SDK Tests/" + timestamp;

        DbxEntry entry = client.createFolder(basePath);
        int i = 2;
        while (entry == null) {
            String tryPath = basePath + "(" + i + ")";
            i++;
            if (i > 100) throw new RuntimeException("Unable to create folder " + jq(basePath));
            entry = client.createFolder(tryPath);
        }

        this.testFolder = entry.path;
        this.client = client;
    }

    @AfterMethod
    private void cleanup()
        throws DbxException
    {
        if (client != null) {
            client.delete(testFolder);
        }
        client =  null;
        testFolder = null;
    }

    private String p(String path)
    {
        return this.testFolder + "/" + path;
    }

    private String p()
    {
        return this.testFolder;
    }

    private static final String E_ACCENT = "\u00e9";

    @Test
    public void testAccountInfo()
        throws DbxException, IOException
    {
        init();

        client.getAccountInfo();
    }

    @Test
    public void testUploadAndDownload()
        throws DbxException, IOException
    {
        init();

        byte[] contents = StringUtil.stringToUtf8("A simple test file");

        String remotePath = p("test-fil" + E_ACCENT + ".txt");

        DbxEntry.File up = client.uploadFile(remotePath, DbxWriteMode.add(), contents.length, new ByteArrayInputStream(contents));
        assertEquals(up.path, remotePath);
        assertEquals(up.numBytes, contents.length);

        ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
        DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
        byte[] downBody = downBodyStream.toByteArray();

        assertEquals(up.numBytes, down.numBytes);
        assertEquals(up.numBytes, downBody.length);
    }

    private DbxEntry.File addFile(String path, int length)
        throws DbxException, IOException
    {
        return uploadFile(path, length, DbxWriteMode.add());
    }

    private DbxEntry.File uploadFile(String path, int length, DbxWriteMode writeMode)
        throws DbxException, IOException
    {
        return client.uploadFile(path, writeMode, length, new ByteArrayInputStream(generateRandomBytes(length)));
    }

    private static byte[] generateRandomBytes(int numBytes)
    {
        byte[] data = new byte[numBytes];
        Random random = new Random();
        for (int i = 0; i < numBytes; i++) {
            String randomFileData = "\nabcdefghijklmnopqrstuvwxyz0123456789";
            data[i] = (byte) randomFileData.charAt(random.nextInt(randomFileData.length()));
        }
        return data;
    }

    @Test
    public void testMetadata()
        throws DbxException, IOException
    {
        init();

        addFile(p("a.txt"), 100);

        {
            DbxEntry entry = client.getMetadata(p("a.txt"));
            assertEquals(entry.path, p("a.txt"));
            assertTrue(entry instanceof DbxEntry.File);
            DbxEntry.File f = (DbxEntry.File) entry;
            assertEquals(f.numBytes, 100);

            DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p("a.txt"));
            assertEquals(mwc.entry, entry);
        }

        // Containing folder.
        {
            DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
            assertEquals(mwc.children.size(), 1);

            // Folder metadata should be the same if we call /metadata again.
            Maybe<DbxEntry.WithChildren> r2 = client.getMetadataWithChildrenIfChanged(p(), mwc.hash);
            assertTrue(r2.isNothing());
        }

        // File not found.
        {
            DbxEntry entry = client.getMetadata(p("does not exists.txt"));
            assertNull(entry);

            DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p("does not exist.txt"));
            assertNull(mwc);
        }
    }

    @Test
    public void testDelta()
        throws DbxException, IOException
    {
        init();

        // NOTE: In these tests, we never actually perform a non-path-prefix /delta call.  This is so that
        // you can run these tests against a Dropbox account that is having modifications performed on it
        // by other clients.  This is unfortunate, so maybe we should switch to requiring that the test
        // be run on an account that has nothing else going on?

        // Get latest cursors before modifying dropbox folders
        String latestCursor = client.getDeltaLatestCursor();
        String latestCursorWithPath = client.getDeltaLatestCursorWithPathPrefix(p("b"));
        assertNotNull(latestCursor);
        assertNotNull(latestCursorWithPath);

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
                        assertNotNull(e.metadata);  // We shouldn't see deletes in our test folder.
                        boolean removed = expected.remove(e.metadata);
                        assertTrue(removed);
                    }
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertEquals(expected.size(), 0);
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
                    assertTrue(e.lcPath.startsWith(lcPrefix+"/") || e.lcPath.equals(lcPrefix));
                    assertNotNull(e.metadata);  // We should never see deletes.
                    boolean removed = expected.remove(e.metadata);
                    assertTrue(removed);
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertEquals(expected.size(), 0);
        }

        // Test latest cursor responses
        {
            HashSet<DbxEntry> expected = new HashSet<DbxEntry>(Arrays.asList(a, b, b_1, b_2, c, c_1, c_2));
            String lcPrefix = p().toLowerCase();
            String cursor = latestCursor;
            while (true) {
                DbxDelta<DbxEntry> d = client.getDelta(cursor);
                for (DbxDelta.Entry<DbxEntry> e : d.entries) {
                    assertTrue(e.lcPath.startsWith(lcPrefix+"/") || e.lcPath.equals(lcPrefix));
                    assertNotNull(e.metadata);  // We shouldn't see deletes in our test folder.
                    boolean removed = expected.remove(e.metadata);
                    assertTrue(removed);
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertEquals(expected.size(), 0);
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
                    assertTrue(e.lcPath.startsWith(lcPrefix+"/") || e.lcPath.equals(lcPrefix));
                    assertNotNull(e.metadata);  // We should never see deletes.
                    boolean removed = expected.remove(e.metadata);
                    assertTrue(removed);
                }
                cursor = d.cursor;
                if (!d.hasMore) break;
            }

            assertEquals(expected.size(), 0);
        }

        // Test longpoll_delta
        {
            DbxLongpollDeltaResult longpollDelta = client.getLongpollDelta(latestCursor, 30);
            assertTrue(longpollDelta.mightHaveChanges);
        }
    }

    @Test
    public void testRevisionsAndRestore()
        throws DbxException, IOException
    {
        init();

        String path = p("r"+E_ACCENT+"visions.txt");

        DbxEntry.File e2 = uploadFile(path, 100, DbxWriteMode.force());
        assertEquals(client.getRevisions(path).size(), 1);
        client.delete(path);
        assertEquals(client.getRevisions(path).size(), 1);
        DbxEntry.File e1 = uploadFile(path, 200, DbxWriteMode.force());
        DbxEntry.File e0 = uploadFile(path, 300, DbxWriteMode.force());

        List<DbxEntry.File> mds = client.getRevisions(path);
        assertEquals(mds.size(), 3);

        assertEquals(mds.get(0), e0);
        assertEquals(mds.get(1), e1);
        assertEquals(mds.get(2), e2);

        DbxEntry.File r1 = client.restoreFile(path, e1.rev);
        assertEquals(r1.numBytes, e1.numBytes);
        DbxEntry.File r2 = client.restoreFile(path, e2.rev);
        assertEquals(r2.numBytes, e2.numBytes);
    }

    @Test
    public void testSearch()
        throws DbxException, IOException
    {
        init();

        addFile(p("search - a.txt"), 100);
        client.createFolder(p("sub"));
        addFile(p("sub/search - b.txt"), 200);
        addFile(p("search - c.txt"), 300);
        client.delete(p("search - c.txt"));

        List<DbxEntry> results;

        results = client.searchFileAndFolderNames(p(), "search");
        assertEquals(results.size(), 2);

        results = client.searchFileAndFolderNames(p("sub"), "search");
        assertEquals(results.size(), 1);

        results = client.searchFileAndFolderNames(p(), "a.txt");
        assertEquals(results.size(), 1);
        assertEquals(results.get(0).name, "search - a.txt");
    }

    private static byte[] downloadUrl(String urlS)
        throws IOException
    {
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
    public void testSharableUrl()
        throws DbxException, IOException
    {
        init();

        byte[] contents = StringUtil.stringToUtf8("A shared text file");
        String path = p("share-me.txt");
        client.uploadFile(path, DbxWriteMode.add(), contents.length, new ByteArrayInputStream(contents));

        String previewUrl = client.createShareableUrl(path);

        // Preview page should be larger than the original content.
        byte[] previewPage = downloadUrl(previewUrl);
        assertTrue(previewPage.length > (contents.length + 1000));

        // Direct download should match exactly.
        String directUrl = previewUrl.replace("://www.", "://dl.");
        byte[] directContents = downloadUrl(directUrl);
        assertEquals(directContents, contents);
    }

    @Test
    public void testTemporaryDirectUrl()
        throws DbxException, IOException
    {
        init();

        byte[] contents = StringUtil.stringToUtf8("A media text file");
        String path = p("media-me.txt");
        client.uploadFile(path, DbxWriteMode.add(), contents.length, new ByteArrayInputStream(contents));

        DbxUrlWithExpiration uwe = client.createTemporaryDirectUrl(path);

        byte[] downloadedContents = downloadUrl(uwe.url);
        assertEquals(downloadedContents, contents);
    }

    @Test
    public void testCopyRefFile()
        throws DbxException, IOException
    {
        init();

        String source = p("copy-ref me.txt");
        String dest = p("done!.txt");
        int size = 1024;

        addFile(source, size);
        String copyRef = client.createCopyRef(source);

        DbxEntry.File destMd = client.copyFromCopyRef(copyRef, dest).asFile();
        assertEquals(size, destMd.numBytes);

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 2);
    }

    @Test
    public void testCopyRefFolder()
        throws DbxException, IOException
    {
        init();

        String source = p("some folder");
        client.createFolder(source);
        addFile(source + "/a.txt", 10);
        addFile(source + "/b.txt", 20);

        String dest = p("copied folder");
        String copyRef = client.createCopyRef(source);
        DbxEntry r = client.copyFromCopyRef(copyRef, dest);

        assertTrue(r.isFolder());
        assertEquals(r.path, dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertEquals(c.children.size(), 2);
    }

    @Test
    public void testCopyRefEmptyFolder()
        throws DbxException, IOException
    {
        init();

        String source = p("empty folder");
        client.createFolder(source);

        String dest = p("copied empty folder");
        String copyRef = client.createCopyRef(source);
        DbxEntry r = client.copyFromCopyRef(copyRef, dest);

        assertTrue(r.isFolder());
        assertEquals(r.path, dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertEquals(c.children.size(), 0);
    }

    @Test
    public void testPhotoInfo()
        throws DbxException, IOException, InterruptedException
    {
        init();

        final String folder = p("photo-info-folder");
        final String orig = folder + "/test-imag"+E_ACCENT+".jpeg";

        // Upload an image.
        InputStream in = this.getClass().getResourceAsStream("test-image.jpeg");
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
        assertEquals(uploadEntry.path.toLowerCase(), orig.toLowerCase());

        // Get metadata with photo info (keep trying until photo info is available)
        int maxTries = 20;
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

        assertEquals(origEntry.path.toLowerCase(), orig.toLowerCase());
        assertNotNull(origEntry.photoInfo);

        // List folder with photo info.
        DbxEntry.File childEntry = client.getMetadataWithChildren(folder, true).children.get(0).asFile();
        assertEquals(childEntry, origEntry);
    }

    @Test
    public void testThumbnail()
        throws DbxException, IOException
    {
        init();

        String orig = p("test-imag" + E_ACCENT + ".jpeg");

        // Upload an image.
        InputStream in = this.getClass().getResourceAsStream("test-image.jpeg");
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

        BufferedImage origImage = ImageIO.read(getClass().getResource("test-image.jpeg"));
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

                assertEquals(removeMediaInfo(origMD), removeMediaInfo(md));

                // We're getting bigger and bigger thumbnails, so they should have more bytes
                // than the previous ones.
                assertTrue(data.length > prevSize);

                reader.setInput(new MemoryCacheImageInputStream(new ByteArrayInputStream(data)));
                int w = reader.getWidth(0);
                int h = reader.getHeight(0);
                int expectedW = Math.min(size.width, origW);
                int expectedH = Math.min(size.width, origH);
                assertTrue((w == expectedW && h <= expectedH) || (h == expectedH && w <= expectedW),
                    "expected = " + expectedW + "x" + expectedH + ", got = " + w + "x" + h);
            }
        }
    }

    private static DbxEntry.File removeMediaInfo(DbxEntry.File e)
    {
        return new DbxEntry.File(e.path, e.iconName, e.mightHaveThumbnail, e.numBytes, e.humanSize,
                                 e.lastModified, e.clientMtime, e.rev);
    }

    private static ImageReader getImageReaderForFormat(DbxThumbnailFormat format)
    {
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
    public void testChunkedUpload()
        throws DbxException, IOException
    {
        init();

        byte[] contents = StringUtil.stringToUtf8("A simple test file");
        int chunkSize = 7;
        assertNotEquals(contents.length % chunkSize, 0);  // Make sure the last chunk is not full-sized.


        // Pass in the correct file size.
        {
            String remotePath = p("test-fil" + E_ACCENT + ".txt");
            DbxEntry.File up = client.uploadFileChunked(chunkSize, remotePath, DbxWriteMode.add(),
                                                        contents.length, new DbxStreamWriter.ByteArrayCopier(contents));
            assertEquals(up.path, remotePath);
            assertEquals(up.numBytes, contents.length);

            ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
            DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
            byte[] downBody = downBodyStream.toByteArray();

            assertEquals(up.numBytes, down.numBytes);
            assertEquals(downBody, contents);
        }

        // Pass in "-1" for file size.
        {
            String remotePath = p("test-fil" + E_ACCENT + "-2.txt");
            DbxEntry.File up = client.uploadFileChunked(chunkSize, remotePath, DbxWriteMode.add(),
                                                        -1, new DbxStreamWriter.ByteArrayCopier(contents));
            assertEquals(up.path, remotePath);
            assertEquals(up.numBytes, contents.length);

            ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
            DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
            byte[] downBody = downBodyStream.toByteArray();

            assertEquals(up.numBytes, down.numBytes);
            assertEquals(downBody, contents);
        }

        // Try uploading a file that is smaller than the first chunk.
        {
            String remotePath = p("test-fil" + E_ACCENT + "-3.txt");
            DbxEntry.File up = client.uploadFileChunked(contents.length + 2, remotePath, DbxWriteMode.add(),
                                                        -1, new DbxStreamWriter.ByteArrayCopier(contents));
            assertEquals(up.path, remotePath);
            assertEquals(up.numBytes, contents.length);

            ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
            DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
            byte[] downBody = downBodyStream.toByteArray();

            assertEquals(up.numBytes, down.numBytes);
            assertEquals(downBody, contents);
        }
    }

    @Test
    public void testCopyFile()
        throws DbxException, IOException
    {
        init();

        String source = p("copy m" + E_ACCENT + ".txt");
        String dest = p("ok - copi" + E_ACCENT + "d.txt");
        int size = 1024;

        addFile(source, size);
        DbxEntry.File md = client.copy(source, dest).asFile();
        assertEquals(md.numBytes, size);
        assertEquals(md.path, dest);

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 2);
    }

    @Test
    public void testCopyFolder()
        throws DbxException, IOException
    {
        init();

        String source = p("some folder");
        client.createFolder(source);
        addFile(source + "/a.txt", 10);
        addFile(source + "/b.txt", 20);

        String dest = p("copied folder");
        DbxEntry r = client.copy(source, dest);

        assertTrue(r.isFolder());
        assertEquals(r.path, dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertEquals(c.children.size(), 2);
    }

    @Test
    public void testCopyEmptyFolder()
        throws DbxException, IOException
    {
        init();

        String source = p("empty folder");
        client.createFolder(source);

        String dest = p("copied empty folder");
        DbxEntry r = client.copy(source, dest);

        assertTrue(r.isFolder());
        assertEquals(r.path, dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertEquals(c.children.size(), 0);
    }

    @Test
    public void testCreateFolder()
        throws DbxException, IOException
    {
        init();

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 0);

        client.createFolder(p("a"));
        mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 1);

        DbxEntry folderMd = client.getMetadata(p("a"));
        assertTrue(folderMd.isFolder());
    }

    @Test
    public void testDelete()
        throws DbxException, IOException
    {
        init();

        String path = p("delete m" + E_ACCENT + ".txt");
        int size = 1024;

        addFile(path, size);
        client.delete(path);

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 0);
    }

    @Test
    public void testMoveFile()
        throws DbxException, IOException
    {
        init();

        String source = p("move me.txt");
        String dest = p("ok - moved.txt");
        int size = 1024;

        addFile(source, size);
        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 1);

        DbxEntry.File destMd = client.move(source, dest).asFile();
        assertEquals(destMd.numBytes, size);

        mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 1);
    }

    @Test
    public void testMoveFolder()
        throws DbxException, IOException
    {
        init();

        String source = p("some folder");
        client.createFolder(source);
        addFile(source + "/a.txt", 10);
        addFile(source + "/b.txt", 20);

        String dest = p("moved folder");
        DbxEntry r = client.move(source, dest);

        assertTrue(r.isFolder());
        assertEquals(r.path, dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertEquals(c.children.size(), 2);

        // Make sure source is now gone.
        DbxEntry deleted = client.getMetadata(source);
        assertTrue(deleted == null);
    }

    @Test
    public void testMoveEmptyFolder()
        throws DbxException, IOException
    {
        init();

        String source = p("empty folder");
        client.createFolder(source);

        String dest = p("moved empty folder");
        DbxEntry r = client.move(source, dest);

        assertTrue(r.isFolder());
        assertEquals(r.path, dest);

        DbxEntry.WithChildren c = client.getMetadataWithChildren(dest);
        assertEquals(c.children.size(), 0);

        // Make sure source is now gone.
        DbxEntry deleted = client.getMetadata(source);
        assertTrue(deleted == null);
    }
}
