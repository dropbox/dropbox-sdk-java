package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.ITUtil;
import com.dropbox.core.v2.DbxClientV2;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Tests to ensure that the "Tag" related APIs are working.  This is important because we have a name conflict
 * resolution of changing Tag -> TagObject, and we want to ensure it's working as expected.
 */
public class TagObjectIT {

    private List<TagObject> getTagsForPath(DbxClientV2 client, String dropboxPath) throws DbxException {
        List<PathToTags> pathToTags = client.files().tagsGet(List.of(dropboxPath)).getPathsToTags();
        assertEquals(1, pathToTags.size()); // There is only one path (the one we asked for)
        PathToTags pathToTag = pathToTags.get(0);
        assertEquals(dropboxPath, pathToTag.getPath()); // This is the path we are looking for
        return pathToTag.getTags();
    }

    @Test
    public void testTagging() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2();

        byte[] contents = ("Tagging Test").getBytes();
        String dropboxPath = ITUtil.path(getClass(), "/tagging-test.txt");

        // Upload File
        client.files().uploadBuilder(dropboxPath)
                .withMode(WriteMode.OVERWRITE)
                .uploadAndFinish(new ByteArrayInputStream(contents));
        Thread.sleep(1000);

        // Add Tag "a" to file
        client.files().tagsAdd(dropboxPath, "a");
        Thread.sleep(1000);

        List<TagObject> tagsWithA = getTagsForPath(client, dropboxPath);
        assertEquals("a", tagsWithA.get(0).getUserGeneratedTagValue().getTagText());
        Thread.sleep(1000);
        
        // Remove Tag "a" from file
        client.files().tagsRemove(dropboxPath, "a");
        Thread.sleep(1000);

        List<TagObject> tagsNone = getTagsForPath(client, dropboxPath);
        assertEquals(0, tagsNone.size());
        Thread.sleep(1000);

        // Cleanup, delete our test directory.
        client.files().deleteV2(dropboxPath);
    }
}
