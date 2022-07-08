package com.dropbox.core.v2.teamlog;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class GetTeamEventsResultTest {


    /**
     * Tests a known type that has extra fields
     *
     * Happy path for known objects
     */
    @Test
    public void known_with_body() throws IOException {
        GetTeamEventsResult result = readGetTeamEventsResultFromFile("known_with_body.json");
        TeamEvent event = result.events.get(0);
        assertEquals(EventDetails.Tag.FILE_LOCKING_LOCK_STATUS_CHANGED_DETAILS, event.details.tag());
    }

    /**
     * Tests a known type that should have extra fields, but does not, so should throw exception
     *
     * Sad path for known objects without required fields
     */
    @Test
    public void known_without_body() {
        try {
            GetTeamEventsResult result = readGetTeamEventsResultFromFile("known_without_body.json");
            assertEquals(EventDetails.Tag.OTHER, result.events.get(0).details.tag());
        } catch (Exception e) {
            assertTrue(e.getMessage().startsWith("Required field \"previous_value\" missing."));
        }
    }

    /**
     * Tests backwards compatibility when receiving unknown types that do have extra fields
     *
     * Basic test for a new tag with no fields.
     */
    @Test
    public void unknown_with_body() throws IOException {
        GetTeamEventsResult result = readGetTeamEventsResultFromFile("unknown_with_body.json");
        assertEquals(EventDetails.Tag.OTHER, result.events.get(0).details.tag());
    }

    /**
     * Tests backwards compatibility when receiving unknown types that don't have extra fields
     */
    @Test
    public void unknown_without_body() throws IOException {
        GetTeamEventsResult result = readGetTeamEventsResultFromFile("unknown_without_body.json");
        assertEquals(EventDetails.Tag.OTHER, result.events.get(0).details.tag());
    }

    private GetTeamEventsResult readGetTeamEventsResultFromFile(String filename) throws IOException {
        String json = readJsonFromFile(filename);
        return GetTeamEventsResult.Serializer.INSTANCE.deserialize(json);
    }

    private String readJsonFromFile(String filename) throws IOException {
        File file = new File("src/test/java/com/dropbox/core/v2/teamlog/" + filename);
        System.out.println(file.getCanonicalPath());
        return Files.readString(Path.of(file.toURI()), StandardCharsets.US_ASCII);
    }
}