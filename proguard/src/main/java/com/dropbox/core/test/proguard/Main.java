package com.dropbox.core.test.proguard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.*;

import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.CreateFolderErrorException;
import com.dropbox.core.v2.files.DeleteErrorException;
import com.dropbox.core.v2.files.DeletedMetadata;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.GetMetadataErrorException;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.WriteConflictError;
import com.dropbox.core.v2.files.WriteMode;
import com.dropbox.core.v2.users.BasicAccount;
import com.dropbox.core.v2.users.FullAccount;

/**
 * An example command-line application that runs through the web-based OAuth
 * flow (using {@link DbxWebAuth}).
 */
public class Main {
    private static final Random RAND = new Random(0L);

    private static void testBasicSerialization(DbxClientV2 client) throws DbxException, IOException {
        // Make the /account/info API call.
        FullAccount expected = client.users().getCurrentAccount();
        assertNotNull(expected);

        String accountId = expected.getAccountId();
        assertNotNull(accountId);
        assertNotNull(expected.getName());

        BasicAccount actual = client.users().getAccount(accountId);
        assertNotNull(actual);
        assertEquals(actual.getAccountId(), expected.getAccountId());
        assertEquals(actual.getEmail(), expected.getEmail());
    }

    private static void testEnumeratedSubtypeSerialization(DbxClientV2 client) throws DbxException, IOException {
        String rootPath = "/test/proguard-tests";

        try {
            FolderMetadata root = client.files().createFolder(rootPath);
            assertNotNull(root);
            assertEquals(root.getPathLower(), rootPath);
            assertEquals(root.getPathDisplay(), rootPath);
        } catch (CreateFolderErrorException ex) {
            if (ex.errorValue.isPath() &&
                ex.errorValue.getPathValue().isConflict() &&
                ex.errorValue.getPathValue().getConflictValue() == WriteConflictError.FOLDER) {
                // ignore duplicate folder exception
            } else {
                throw ex;
            }
        }

        Map<String, byte[]> files = new LinkedHashMap<String, byte []>();
        files.put(rootPath + "/foo.blob", bytes(1024));
        files.put(rootPath + "/bar.blob", bytes(512));
        files.put(rootPath + "/sub/a.dat", bytes(4096));
        files.put(rootPath + "/sub/b/c.dat", bytes(64));
        files.put(rootPath + "/pics/cat.rawb", bytes(8196));

        try {
            for (Map.Entry<String, byte[]> entry : files.entrySet()) {
                String path = entry.getKey();
                byte [] data = entry.getValue();
                FileMetadata file = client.files().uploadBuilder(path)
                    .withMode(WriteMode.OVERWRITE)
                    .withAutorename(false)
                    .withMute(true)
                    .uploadAndFinish(new ByteArrayInputStream(data));

                assertNotNull(file);
                assertEquals(file.getPathLower(), path);
                assertEquals(file.getSize(), data.length);

                Metadata metadata = client.files().getMetadata(path);
                assertEquals(metadata, file);
            }

            for (String path : files.keySet()) {
                Metadata file = client.files().delete(path);
                assertNotNull(file);
                assertEquals(file.getPathLower(), path);
                assertTrue(file instanceof FileMetadata);

                Metadata deleted = client.files().getMetadataBuilder(path)
                    .withIncludeDeleted(true)
                    .start();
                assertNotNull(deleted);

                assertTrue(deleted instanceof DeletedMetadata, deleted.getClass().toString());
                assertEquals(deleted.getPathLower(), path);
            }
        } finally {
            client.files().delete(rootPath);
        }
    }

    private static void testErrorSerialization(DbxClientV2 client) throws IOException, DbxException {
        // either getting the metadata or deleting will always fail.
        String fakePath = "/tests/_fake_path.txt";
        try {
            client.files().getMetadata(fakePath);
            client.files().delete(fakePath);
        } catch (GetMetadataErrorException ex) {
            if (ex.errorValue.isPath() &&
                ex.errorValue.getPathValue().isNotFound()) {
                // safely ignore
                return;
            }
            throw ex;
        } catch (DeleteErrorException ex) {
            if (ex.errorValue.isPathLookup() &&
                ex.errorValue.getPathLookupValue().isNotFound()) {
                // safely ignore
                return;
            }
            throw ex;
        }

        fail("No exception thrown");
    }

    public static void main(String[] args) throws IOException {
        // Only display important log messages.
        Logger.getLogger("").setLevel(Level.WARNING);

        if (args.length != 1) {
            System.out.println("");
            System.out.println("Usage: COMMAND <auth-file>");
            System.out.println("");
            System.out.println(" <auth-file>: An \"auth file\" that contains the information necessary to make");
            System.out.println("    an authorized Dropbox API request.  Generate this file using the \"authorize\"");
            System.out.println("    example program.");
            System.out.println("");
            System.exit(1);
            return;
        }

        DbxClientV2 client = createClient(args[0]);

        runTest(client, Main::testBasicSerialization, "testBasicSerialization");
        runTest(client, Main::testEnumeratedSubtypeSerialization, "testEnumeratedSubtypeSerialization");
        runTest(client, Main::testErrorSerialization, "testErrorSerialization");
    }

    private static void runTest(DbxClientV2 client, ClientTest test, String name) {
        System.out.print(String.format("TEST %45s: ", name));
        try {
            test.run(client);
            System.out.println("PASS");
        } catch (IOException|DbxException ex) {
            System.out.println("FAILED");
            System.out.println("");
            System.err.println("Error making API call: " + ex.getMessage());
            ex.printStackTrace(System.err);
            System.exit(1);
            return;
        } catch (RuntimeException|Error ex) {
            System.out.println("FAILED");
            throw ex;
        }
    }

    private static DbxClientV2 createClient(String authFile) {
        DbxAuthInfo authInfo;
        try {
            authInfo = DbxAuthInfo.Reader.readFromFile(authFile);
        } catch (JsonReader.FileLoadException ex) {
            System.err.println("Error loading <auth-file>: " + ex.getMessage());
            System.exit(1);
            return null;
        }

        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-proguard");
        return new DbxClientV2(requestConfig, authInfo.getAccessToken(), authInfo.getHost());
    }

    private static byte [] bytes(int num) {
        byte [] data = new byte[num];
        RAND.nextBytes(data);
        return data;
    }

    @FunctionalInterface
    private interface ClientTest {
        void run(DbxClientV2 client) throws DbxException, IOException;
    }
}
