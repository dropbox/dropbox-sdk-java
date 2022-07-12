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
        System.out.println("Path to Tags: " + pathToTag.getTags());
        return pathToTag.getTags();
    }

    @Test
    public void testTagging() throws Exception {
        DbxClientV2 client = ITUtil.newClientV2();

        int randomInt = new Random().nextInt();


        byte[] contents = ("Tagging Test " + randomInt).getBytes();
        String dropboxPath = ITUtil.path(getClass(), "/tagging-test-" + randomInt + ".txt");

        // Upload File
        client.files().uploadBuilder(dropboxPath)
                .withMode(WriteMode.OVERWRITE)
                .uploadAndFinish(new ByteArrayInputStream(contents));

        // Add Tag "a" to file
        client.files().tagsAdd(dropboxPath, "a");
        assertEquals("a", getTagsForPath(client, dropboxPath).get(0).getUserGeneratedTagValue().getTagText());

        // Add Tag "b" to file
        client.files().tagsAdd(dropboxPath, "b");
        List<TagObject> tagsAandB = getTagsForPath(client, dropboxPath);
        assertEquals(2, tagsAandB.size());
        assertEquals("a", tagsAandB.get(0).getUserGeneratedTagValue().getTagText());
        assertEquals("b", tagsAandB.get(1).getUserGeneratedTagValue().getTagText());

        // Remove Tag "a" from file
        client.files().tagsRemove(dropboxPath, "a");
        List<TagObject> tagsJustB = getTagsForPath(client, dropboxPath);
        assertEquals(1, tagsJustB.size());
        assertEquals("b", tagsJustB.get(0).getUserGeneratedTagValue().getTagText());

        // Remove Tag "b" from file
        client.files().tagsRemove(dropboxPath, "b");
        List<TagObject> tagsNone = getTagsForPath(client, dropboxPath);
        assertEquals(0, tagsNone.size());

        // Cleanup, delete our test directory.
        client.files().deleteV2(dropboxPath);
    }
}
