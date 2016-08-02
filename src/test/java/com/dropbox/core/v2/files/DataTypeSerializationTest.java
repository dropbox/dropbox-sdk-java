package com.dropbox.core.v2.files;

import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.Test;

import java.util.Date;

public class DataTypeSerializationTest {

    @Test
    public void testPreClassInitializationDeserialization() throws Exception {
        // verify that we can deserialize JSON for a class that has not yet been initialized
        // (e.g. no instances or fields have been accessed for this class yet)
        String json = "{\"reason\":{\".tag\":\"conflict\",\"conflict\":\"file\"},\"upload_session_id\":\"uploadid:12345\"}";
        UploadWriteFailed actual = UploadWriteFailed.Serializer.INSTANCE.deserialize(json);
        assertEquals(actual.getUploadSessionId(), "uploadid:12345");
        assertEquals(actual.getReason().tag(), WriteError.Tag.CONFLICT);
        assertEquals(actual.getReason().getConflictValue(), WriteConflictError.FILE);
    }

    @Test
    public void testCatchAllDeserialization() throws Exception {
        String json = "{\".tag\":\"path\",\"path\":\"test_unknown_tag\"}";
        ListFolderError actual = ListFolderError.Serializer.INSTANCE.deserialize(json);
        assertEquals(actual.tag(), ListFolderError.Tag.PATH);
        assertEquals(actual.getPathValue(), LookupError.OTHER);

        json = "{\".tag\":\"path\",\"path\":{\".tag\":\"test_unknown_tag\",\"test\":true}}";
        actual = ListFolderError.Serializer.INSTANCE.deserialize(json);
        assertEquals(actual.tag(), ListFolderError.Tag.PATH);
        assertEquals(actual.getPathValue(), LookupError.OTHER);

        json = "\"test_unknown_tag\"";
        actual = ListFolderError.Serializer.INSTANCE.deserialize(json);
        assertNotNull(actual);
        assertEquals(actual.tag(), ListFolderError.Tag.OTHER);
    }

    @Test(expectedExceptions={IOException.class})
    public void testNoCatchAllDeserialization() throws Exception {
        String json = "\"fake_img_format\"";
        // ThumbnailFormat union has no catch-all
        ThumbnailFormat.Serializer.INSTANCE.deserialize(json);
    }

    @Test
    public void testOutOfOrderFields() throws Exception {
        String json = "{\"width\":1024,\"height\":768}";
        Dimensions expected = new Dimensions(768, 1024);
        Dimensions actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);

        json = "{\"height\":768,\"width\":1024}";
        actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);
    }

    @Test
    public void testUnknownStructFields() throws Exception {
        String json = "{\"height\":768,\"alpha\":0.5,\"width\":1024,\"foo\":{\"bar\":[1, 2, 3],\"baz\":false}}";
        Dimensions expected = new Dimensions(768, 1024);
        Dimensions actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);

        // change order of fields to ensure we parse valid fields at end of response
        json = "{\"height\":768,\"alpha\":0.5,\"foo\":{\"bar\":[1, 2, 3],\"baz\":false},\"width\":1024}";
        expected = new Dimensions(768, 1024);
        actual = Dimensions.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);
    }

    @Test
    public void testDateTimestamp() throws Exception {
        Date clientModified = new Date(1452816000000L); // 2016-01-15
        CommitInfo expected = CommitInfo.newBuilder("/path")
            .withClientModified(clientModified)
            .build();

        String json = CommitInfo.Serializer.INSTANCE.serialize(expected);
        CommitInfo actual = CommitInfo.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);

        // explicitly use long date
        json = "{\"path\":\"/path\",\"client_modified\":\"2016-01-15T00:00:00Z\"}";
        actual = CommitInfo.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);

        // use short date
        json = "{\"path\":\"/path\",\"client_modified\":\"2016-01-15\"}";
        actual = CommitInfo.Serializer.INSTANCE.deserialize(json);

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

        String json = FileMetadata.Serializer.INSTANCE.serialize(file);
        Metadata actual = Metadata.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual.getClass(), FileMetadata.class);
        assertEquals(actual, file);

        json = FolderMetadata.Serializer.INSTANCE.serialize(folder);
        actual = Metadata.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual.getClass(), FolderMetadata.class);
        assertEquals(actual, folder);

        json = DeletedMetadata.Serializer.INSTANCE.serialize(deleted);
        actual = Metadata.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual.getClass(), DeletedMetadata.class);
        assertEquals(actual, deleted);

        json = Metadata.Serializer.INSTANCE.serialize(metadata);
        actual = Metadata.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual.getClass(), Metadata.class);
        assertEquals(actual, metadata);

        // check that we can deserialize as the specific type if necessary.
        json = FileMetadata.Serializer.INSTANCE.serialize(file);
        actual = FileMetadata.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual.getClass(), FileMetadata.class);
        assertEquals(actual, file);
    }

    @Test
    public void testOptionalPrimitives() throws Exception {
        // make sure optional primitives are deserialized properly
        CommitInfo expected = CommitInfo.newBuilder("/foo/bar.txt")
            .build();

        String json = "{\"path\":\"/foo/bar.txt\"}";
        CommitInfo actual = CommitInfo.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);

        // set the optional fields
        expected = CommitInfo.newBuilder("/foo/bar.txt")
            .withMode(WriteMode.update("123456789"))
            .withAutorename(true)
            .withClientModified(new Date(123456789000L))
            .withMute(true)
            .build();

        json = CommitInfo.Serializer.INSTANCE.serialize(expected);
        actual = CommitInfo.Serializer.INSTANCE.deserialize(json);

        assertEquals(actual, expected);
    }
}
