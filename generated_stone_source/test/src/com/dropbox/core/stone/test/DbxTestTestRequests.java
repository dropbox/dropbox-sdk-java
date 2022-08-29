/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.DbxUploadStyleBuilder;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "test".
 */
public class DbxTestTestRequests {
    // namespace test (test.stone)

    private final DbxRawClientV2 client;

    public DbxTestTestRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/test/test_download
    //

    /**
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<Fish> testDownload(Dog arg, List<HttpRequestor.Header> _headers) throws DbxApiException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/test/test_download",
                                             arg,
                                             false,
                                             _headers,
                                             Dog.Serializer.INSTANCE,
                                             Fish.Serializer.INSTANCE,
                                             com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"test_download\":" + ex.getErrorValue());
        }
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param breed  Must not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<Fish> testDownload(String name, String breed) throws DbxApiException, DbxException {
        Dog _arg = new Dog(name, breed);
        return testDownload(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param breed  Must not be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TestDownloadBuilder testDownloadBuilder(String name, String breed) {
        Dog.Builder argBuilder_ = Dog.newBuilder(name, breed);
        return new TestDownloadBuilder(this, argBuilder_);
    }

    //
    // route 2/test/test_download_v2
    //

    /**
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<Fish> testDownloadV2(Uninitialized arg, List<HttpRequestor.Header> _headers) throws ParentUnionException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/test/test_download_v2",
                                             arg,
                                             false,
                                             _headers,
                                             Uninitialized.Serializer.INSTANCE,
                                             Fish.Serializer.INSTANCE,
                                             ParentUnion.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ParentUnionException("2/test/test_download_v2", ex.getRequestId(), ex.getUserMessage(), (ParentUnion) ex.getErrorValue());
        }
    }

    /**
     *
     * @param reason  Must not be {@code null}.
     * @param sessionId  Must not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<Fish> testDownloadV2(UninitializedReason reason, String sessionId) throws ParentUnionException, DbxException {
        Uninitialized _arg = new Uninitialized(reason, sessionId);
        return testDownloadV2(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     *
     * @param reason  Must not be {@code null}.
     * @param sessionId  Must not be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TestDownloadV2Builder testDownloadV2Builder(UninitializedReason reason, String sessionId) {
        return new TestDownloadV2Builder(this, reason, sessionId);
    }

    //
    // route 2/test/test_route
    //

    /**
     * {@link DbxTestTestRequests#testRouteV2(String,Date)}
     */
    public void testRoute() throws DbxApiException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/test/test_route",
                                 null,
                                 false,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"test_route\":" + ex.getErrorValue());
        }
    }

    //
    // route 2/test/test_route_v2
    //

    /**
     *
     */
    void testRouteV2(Pet arg) throws ParentUnionException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/test/test_route_v2",
                                 arg,
                                 false,
                                 Pet.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 ParentUnion.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ParentUnionException("2/test/test_route_v2", ex.getRequestId(), ex.getUserMessage(), (ParentUnion) ex.getErrorValue());
        }
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void testRouteV2(String name) throws ParentUnionException, DbxException {
        Pet _arg = new Pet(name);
        testRouteV2(_arg);
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void testRouteV2(String name, Date born) throws ParentUnionException, DbxException {
        Pet _arg = new Pet(name, born);
        testRouteV2(_arg);
    }

    //
    // route 2/test/test_upload
    //

    /**
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    TestUploadUploader testUpload(Uninitialized arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getApi(),
                                                                   "2/test/test_upload",
                                                                   arg,
                                                                   false,
                                                                   Uninitialized.Serializer.INSTANCE);
        return new TestUploadUploader(_uploader, this.client.getUserId());
    }

    /**
     *
     * @param reason  Must not be {@code null}.
     * @param sessionId  Must not be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TestUploadUploader testUpload(UninitializedReason reason, String sessionId) throws DbxException {
        Uninitialized _arg = new Uninitialized(reason, sessionId);
        return testUpload(_arg);
    }

    //
    // route 2/test/test_upload_v2
    //

    /**
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    TestUploadV2Uploader testUploadV2(Dog arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getApi(),
                                                                   "2/test/test_upload_v2",
                                                                   arg,
                                                                   false,
                                                                   Dog.Serializer.INSTANCE);
        return new TestUploadV2Uploader(_uploader, this.client.getUserId());
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param breed  Must not be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TestUploadV2Uploader testUploadV2(String name, String breed) throws DbxException {
        Dog _arg = new Dog(name, breed);
        return testUploadV2(_arg);
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param breed  Must not be {@code null}.
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TestUploadV2Builder testUploadV2Builder(String name, String breed) {
        Dog.Builder argBuilder_ = Dog.newBuilder(name, breed);
        return new TestUploadV2Builder(this, argBuilder_);
    }

    //
    // route 2/test/test_upload_v3
    //

    /**
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    TestUploadV3Uploader testUploadV3(Dog arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getApi(),
                                                                   "2/test/test_upload_v3",
                                                                   arg,
                                                                   false,
                                                                   Dog.Serializer.INSTANCE);
        return new TestUploadV3Uploader(_uploader, this.client.getUserId());
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param breed  Must not be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TestUploadV3Uploader testUploadV3(String name, String breed) throws DbxException {
        Dog _arg = new Dog(name, breed);
        return testUploadV3(_arg);
    }

    /**
     *
     * @param name  Used in {@link
     *     DbxTestTestRequests#testRouteV2(String,Date)}. Must not be {@code
     *     null}.
     * @param breed  Must not be {@code null}.
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxTestTestUploadV3Builder testUploadV3Builder(String name, String breed) {
        Dog.Builder argBuilder_ = Dog.newBuilder(name, breed);
        return new DbxTestTestUploadV3Builder(this, argBuilder_);
    }
}
