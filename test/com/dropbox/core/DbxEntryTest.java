package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v1.DbxEntry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DbxEntryTest
{
    private static <T> T loadJsonResource(JsonReader<T> reader, String resourceName)
    {
        InputStream in = DbxEntryTest.class.getResourceAsStream(resourceName);
        if (in == null) throw new AssertionError("Couldn't get resource " + StringUtil.jq(resourceName) + ".");
        try {
            return reader.readFully(in);
        }
        catch (JsonReadException ex) {
            throw LangUtil.mkAssert("Test file had invalid JSON", ex);
        }
        catch (IOException ex) {
            throw LangUtil.mkAssert("IO error reading from resource?", ex);
        }
        finally {
            IOUtil.closeInput(in);
        }
    }


    @Test
    public void parseFile() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "file.json").asFile();
        assertEquals(f.path, "/Photos/Sample Album/Boston City Flow.jpg");
        assertEquals(f.numBytes, 339773);
        assertEquals(f.mightHaveThumbnail, true);
        assertEquals(f.rev, "400113f659");
        assertEquals(f.humanSize, "331.8 KB");

        GregorianCalendar c = new GregorianCalendar(2013, GregorianCalendar.APRIL, 11, 17, 5, 17);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        assertEquals(f.lastModified, c.getTime());
    }

    @Test
    public void parseFileWithPhotoInfo() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "file-with-photo-info.json").asFile();
        assertNotNull(f.photoInfo, "Expected entry to have a photo info");
        assertNotNull(f.photoInfo.timeTaken, "Expected entry to have a time taken");
        assertNotNull(f.photoInfo.location, "Expected entry to have a location");
    }

    @Test
    public void parseFileWithVideoInfo() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "file-with-video-info.json").asFile();
        assertNotNull(f.videoInfo, "Expected entry to have a video info");
        assertNotNull(f.videoInfo.timeTaken, "Expected entry to have a time taken");
        assertNotNull(f.videoInfo.location, "Expected entry to have a location");
        assertEquals(f.videoInfo.duration, Long.valueOf(666), "Expected to have a duration");
    }

    @Test
    public void parseFileWithVideoInfoNullFields() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "file-with-video-info-null-fields.json").asFile();
        assertNull(f.videoInfo.duration);
        assertNull(f.videoInfo.location);
        assertNull(f.videoInfo.timeTaken);
    }

    @Test
    public void parseWithMediaInfoPending() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "file-with-media-info-pending.json").asFile();
        assertTrue(f.videoInfo == DbxEntry.File.VideoInfo.PENDING);
        assertTrue(f.photoInfo == DbxEntry.File.PhotoInfo.PENDING);
    }
}
