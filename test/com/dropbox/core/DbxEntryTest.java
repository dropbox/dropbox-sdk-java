package com.dropbox.core;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.io.InputStream;

public class DbxEntryTest {
    @Test
    public void parseEntryMetadata() throws Exception {
        InputStream in = this.getClass().getResourceAsStream("file-metadata.json");
        DbxEntry entry = DbxRequestUtil.readJsonFromResponse(DbxEntry.ReaderMaybeDeleted, in);
        assertEquals("/Photos/Sample Album/Boston City Flow.jpg", entry.path);
    }

    @Test
    public void parseFileWithPhotoInfoMetadata() throws Exception {
        InputStream in = this.getClass().getResourceAsStream("file-with-photo_info-metadata.json");
        DbxEntry entry = DbxRequestUtil.readJsonFromResponse(DbxEntry.ReaderMaybeDeleted, in);
        assertNotNull(entry.asFile().photoInfo, "Expected entry to have a photo info");
        assertNotNull(entry.asFile().photoInfo.timeTaken, "Expected entry to have a time taken");
        assertNotNull(entry.asFile().photoInfo.location, "Expected entry to have a location");
    }

    @Test
    public void parseFileWithVideoInfoMetadata() throws Exception {
        InputStream in = this.getClass().getResourceAsStream("file-with-video_info-metadata.json");
        DbxEntry entry = DbxRequestUtil.readJsonFromResponse(DbxEntry.ReaderMaybeDeleted, in);
        assertNotNull(entry.asFile().videoInfo, "Expected entry to have a video info");
        assertNotNull(entry.asFile().videoInfo.timeTaken, "Expected entry to have a time taken");
        assertNotNull(entry.asFile().videoInfo.location, "Expected entry to have a location");
        assertEquals(666, entry.asFile().videoInfo.duration, "Expected to have a duration");
    }

    @Test
    public void parseVideoWithLatLongAndTimeTakenNull() throws Exception {
        InputStream in = this.getClass().getResourceAsStream("file-with-video_info-null.json");
        DbxEntry entry = DbxRequestUtil.readJsonFromResponse(DbxEntry.ReaderMaybeDeleted, in);
        assertNull(entry.asFile().videoInfo.location);
        assertNull(entry.asFile().videoInfo.timeTaken);
    }
}
