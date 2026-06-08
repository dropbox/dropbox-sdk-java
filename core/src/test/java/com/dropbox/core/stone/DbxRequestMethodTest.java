package com.dropbox.core.stone;

import static org.mockito.Mockito.*;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxRequest;
import com.dropbox.core.stone.test.DbxTestTestRequests;
import com.dropbox.core.stone.test.Fish;
import com.dropbox.core.stone.test.TestUploadUploader;
import com.dropbox.core.stone.test.UninitializedReason;
import com.dropbox.core.v2.DbxRawClientV2;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DbxRequestMethodTest {

    @Test
    public void testVoidRouteRequestReturnsDbxRequest() {
        DbxRawClientV2 mockClient = mock(DbxRawClientV2.class, RETURNS_DEEP_STUBS);
        DbxTestTestRequests requests = new DbxTestTestRequests(mockClient);

        DbxRequest<Void> request = requests.testRouteRequest();
        assertNotNull(request);
    }

    @Test
    public void testDownloadRouteRequestReturnsDbxRequest() {
        DbxRawClientV2 mockClient = mock(DbxRawClientV2.class, RETURNS_DEEP_STUBS);
        DbxTestTestRequests requests = new DbxTestTestRequests(mockClient);

        DbxRequest<DbxDownloader<Fish>> request = requests.testDownloadRequest("fido", "lab");
        assertNotNull(request);
    }

    @Test
    public void testUploadRouteRequestReturnsDbxRequest() {
        DbxRawClientV2 mockClient = mock(DbxRawClientV2.class, RETURNS_DEEP_STUBS);
        DbxTestTestRequests requests = new DbxTestTestRequests(mockClient);

        DbxRequest<TestUploadUploader> request = requests.testUploadRequest(UninitializedReason.BAD_REQUEST, "session123");
        assertNotNull(request);
    }

    @Test
    public void testRouteV2RequestWithParams() {
        DbxRawClientV2 mockClient = mock(DbxRawClientV2.class, RETURNS_DEEP_STUBS);
        DbxTestTestRequests requests = new DbxTestTestRequests(mockClient);

        DbxRequest<Void> request = requests.testRouteV2Request("buddy");
        assertNotNull(request);
    }
}
