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
        assertEquals(entry.asFile().mimeType,"image/jpeg");
    }
}
