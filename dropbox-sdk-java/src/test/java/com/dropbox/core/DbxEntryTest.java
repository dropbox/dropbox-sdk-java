package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v1.DbxEntry;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

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
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "/file.json").asFile();
        assertThat(f.path).isEqualTo("/Photos/Sample Album/Boston City Flow.jpg");
        assertThat(f.numBytes).isEqualTo(339773);
        assertThat(f.mightHaveThumbnail).isEqualTo(true);
        assertThat(f.rev).isEqualTo("400113f659");
        assertThat(f.humanSize).isEqualTo("331.8 KB");

        GregorianCalendar c = new GregorianCalendar(2013, GregorianCalendar.APRIL, 11, 17, 5, 17);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        assertThat(f.lastModified).isEqualTo(c.getTime());
    }

    @Test
    public void parseFileWithPhotoInfo() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "/file-with-photo-info.json").asFile();
        assertWithMessage("Expected entry to have a photo info").that(f.photoInfo).isNotNull();
        assertWithMessage("Expected entry to have a time taken").that(f.photoInfo.timeTaken).isNotNull();
        assertWithMessage("Expected entry to have a location").that(f.photoInfo.location).isNotNull();
    }

    @Test
    public void parseFileWithVideoInfo() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "/file-with-video-info.json").asFile();
        assertWithMessage("Expected entry to have a video info").that(f.videoInfo).isNotNull();
        assertWithMessage("Expected entry to have a time taken").that(f.videoInfo.timeTaken).isNotNull();
        assertWithMessage("Expected entry to have a location").that(f.videoInfo.location).isNotNull();
        assertWithMessage("Expected to have a duration").that(f.videoInfo.duration).isEqualTo(Long.valueOf(666));
    }

    @Test
    public void parseFileWithVideoInfoNullFields() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "/file-with-video-info-null-fields.json").asFile();
        assertThat(f.videoInfo.duration).isNull();
        assertThat(f.videoInfo.location).isNull();
        assertThat(f.videoInfo.timeTaken).isNull();
    }

    @Test
    public void parseWithMediaInfoPending() throws Exception
    {
        DbxEntry.File f = loadJsonResource(DbxEntry.Reader, "/file-with-media-info-pending.json").asFile();
        assertThat(f.videoInfo == DbxEntry.File.VideoInfo.PENDING).isTrue();
        assertThat(f.photoInfo == DbxEntry.File.PhotoInfo.PENDING).isTrue();
    }
}
