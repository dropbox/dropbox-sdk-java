package com.dropbox.core;

import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.IOUtil;
import static com.dropbox.core.util.StringUtil.jq;

import com.dropbox.core.util.Maybe;
import com.dropbox.core.util.StringUtil;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DbxClientTest
{
    private String testFolder;
    private DbxClient client;

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

        DbxRequestConfig requestConfig = new DbxRequestConfig("sdk-test", null);
        DbxClient client = new DbxClient(requestConfig, authInfo.accessToken, authInfo.host);

        String timestamp = new SimpleDateFormat("yyyy-mm-dd HH.mm.ss").format(new Date());
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

        DbxEntry.WithChildren mwc = client.getMetadataWithChildren(p());
        assertEquals(mwc.children.size(), 1);

        // Folder metadata should be the same if we call /metadata again.
        Maybe<DbxEntry.WithChildren> r2 = client.getMetadataWithChildrenIfChanged(p(), mwc.hash);
        assert r2.isNothing();
    }

    @Test
    public void testDelta()
        throws DbxException, IOException
    {
        init();

        // Eat up all the deltas up to the current point.
        DbxDelta<DbxEntry> d = client.getDelta(null);
        assertTrue(d.reset);
        while (d.hasMore) {
            d = client.getDelta(d.cursor);
        }

        String path = p("make a delta.txt");
        addFile(path, 100);

        d = client.getDelta(d.cursor);
        assertEquals(d.entries.size(), 1);

        DbxDelta.Entry<DbxEntry> deltaEntry = d.entries.get(0);
        assertEquals(deltaEntry.lcPath, path.toLowerCase());

        DbxEntry.File md = deltaEntry.metadata.asFile();
        assertEquals(md.path, path);
        assertEquals(md.numBytes, 100);
    }

    @Test
    public void testRevisionsAndRestore()
        throws DbxException, IOException
    {
        init();

        String path = p("revisions.txt");
        DbxEntry.File e2 = uploadFile(path, 100, DbxWriteMode.force());
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
    public void testCopyRef()
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
    public void testThumbnail()
        throws DbxException, IOException
    {
        // TODO
    }

    @Test
    public void testChunkedUpload()
        throws DbxException, IOException
    {
        init();

        byte[] contents = StringUtil.stringToUtf8("A simple test file");

        String remotePath = p("test-fil" + E_ACCENT + ".txt");

        DbxEntry.File up = client.uploadFileChunked(6, remotePath, DbxWriteMode.add(), contents.length, new DbxStreamWriter.ByteArrayCopier(contents));
        assertEquals(up.path, remotePath);
        assertEquals(up.numBytes, contents.length);

        ByteArrayOutputStream downBodyStream = new ByteArrayOutputStream();
        DbxEntry.File down = client.getFile(remotePath, null, downBodyStream);
        byte[] downBody = downBodyStream.toByteArray();

        assertEquals(up.numBytes, down.numBytes);
        assertEquals(up.numBytes, downBody.length);
    }

    @Test
    public void testCopy()
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
        assert folderMd.isFolder();
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
    public void testMove()
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
}
