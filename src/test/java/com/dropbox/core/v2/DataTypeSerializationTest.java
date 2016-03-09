package com.dropbox.core.v2;

import static org.testng.Assert.*;

import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.v2.files.CommitInfo;
import com.dropbox.core.v2.files.DeletedMetadata;
import com.dropbox.core.v2.files.Dimensions;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FileSharingInfo;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.MediaInfo;
import com.dropbox.core.v2.files.MediaMetadata;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.WriteMode;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;

import java.util.Date;

public class DataTypeSerializationTest {
    private static final ObjectMapper JSON = JsonUtil.getMapper();

    @Test
    public void testDateTimestamp() throws Exception {
        Date clientModified = new Date(1452816000000L); // 2016-01-15
        CommitInfo expected = CommitInfo.newBuilder("/path")
            .withClientModified(clientModified)
            .build();

        String json = JSON.writeValueAsString(expected);
        CommitInfo actual = JSON.readValue(json, CommitInfo.class);

        assertEquals(actual, expected);

        // explicitly use long date
        json = "{\"path\":\"/path\",\"client_modified\":\"2016-01-15T00:00:00Z\"}";
        actual = JSON.readValue(json, CommitInfo.class);

        assertEquals(actual, expected);

        // use short date
        json = "{\"path\":\"/path\",\"client_modified\":\"2016-01-15\"}";
        actual = JSON.readValue(json, CommitInfo.class);

        assertEquals(actual, expected);
    }

    @Test
    public void testEnumeratedSubtypes() throws Exception {
        FileMetadata file = FileMetadata.newBuilder(
            "foo.PNG",
            "/path/foo.png",
            "/path/foo.PNG",
            "id:fyte8AYWx_AAAAAAAAAfgg",
            new Date(1457477907029L),
            new Date(1457479027750L),
            "3cee38735597",
            18480
        )
            .withParentSharedFolderId("2")
            .withSharingInfo(new FileSharingInfo(false, "2"))
            .withMediaInfo(
                MediaInfo.metadata(
                    MediaMetadata.newBuilder()
                        .withDimensions(new Dimensions(344, 373))
                        .withTimeTaken(new Date(1457477906315L))
                        .build()
                )
            )
            .build();

        FolderMetadata folder = new FolderMetadata(
            "/Photos",
            "/photos",
            "/Photos",
            "id:fyte8AYWx_AAAAAAAAAf8w"
        );

        DeletedMetadata deleted = new DeletedMetadata(
            "Old.log",
            "/logs/old.log",
            "/logs/Old.log"
        );

        Metadata metadata = new Metadata(
            "generic",
            "/generic",
            "/generic"
        );

        String json = JSON.writeValueAsString(file);
        Metadata actual = JSON.readValue(json, Metadata.class);

        assertEquals(actual.getClass(), FileMetadata.class);
        assertEquals(actual, file);

        json = JSON.writeValueAsString(folder);
        actual = JSON.readValue(json, Metadata.class);

        assertEquals(actual.getClass(), FolderMetadata.class);
        assertEquals(actual, folder);

        json = JSON.writeValueAsString(deleted);
        actual = JSON.readValue(json, Metadata.class);

        assertEquals(actual.getClass(), DeletedMetadata.class);
        assertEquals(actual, deleted);

        json = JSON.writeValueAsString(metadata);
        actual = JSON.readValue(json, Metadata.class);

        assertEquals(actual.getClass(), Metadata.class);
        assertEquals(actual, metadata);

        // check that we can deserialize as the specific type if necessary.
        json = JSON.writeValueAsString(file);
        actual = JSON.readValue(json, FileMetadata.class);

        assertEquals(actual.getClass(), FileMetadata.class);
        assertEquals(actual, file);
    }

    @Test
    public void testOptionalPrimitives() throws Exception {
        // make sure optional primitives are deserialized properly
        CommitInfo expected = CommitInfo.newBuilder("/foo/bar.txt")
            .build();

        String json = "{\"path\":\"/foo/bar.txt\"}";
        CommitInfo actual = JSON.readValue(json, CommitInfo.class);

        assertEquals(actual, expected);

        // set the optional fields
        expected = CommitInfo.newBuilder("/foo/bar.txt")
            .withMode(WriteMode.update("123456789"))
            .withAutorename(true)
            .withClientModified(new Date(123456789000L))
            .withMute(true)
            .build();

        json = JSON.writeValueAsString(expected);
        actual = JSON.readValue(json, CommitInfo.class);

        assertEquals(actual, expected);
    }
}
