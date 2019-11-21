package com.dropbox.core.stone.test;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Date;

public class RouteVersionTest {
    @Test
    public void testRpcRoutes() throws Exception {
        Class c = DbxTestTestRequests.class;
        Method v1 = c.getDeclaredMethod("testRoute");
        Method v2NoOpition = c.getDeclaredMethod("testRouteV2", String.class);
        Method v2Option = c.getDeclaredMethod("testRouteV2", String.class, Date.class);

        // Test exception
        assertFalse(Arrays.asList(v1.getExceptionTypes()).contains(ParentUnionException.class));
        assertTrue(Arrays.asList(v2NoOpition.getExceptionTypes()).contains(ParentUnionException.class));
        assertTrue(Arrays.asList(v2Option.getExceptionTypes()).contains(ParentUnionException.class));
    }

    @Test
    public void testUploadRoutes() throws Exception {
        Class c = DbxTestTestRequests.class;
        Method v1 = c.getDeclaredMethod("testUpload", UninitializedReason.class, String.class);
        Method v2NoBuilder = c.getDeclaredMethod("testUploadV2", String.class, String.class);
        Method v2Builder = c.getDeclaredMethod("testUploadV2Builder", String.class, String.class);
        Method v3Builder = c.getDeclaredMethod("testUploadV3Builder", String.class, String.class);

        // Test return value
        assertEquals(v1.getReturnType(), TestUploadUploader.class);
        assertEquals(v2NoBuilder.getReturnType(), TestUploadV2Uploader.class);
        assertEquals(v2Builder.getReturnType(), TestUploadV2Builder.class);
        assertEquals(v3Builder.getReturnType(), DbxTestTestUploadV3Builder.class);

        // Test builder
        TestUploadV2Builder.class.getDeclaredMethod("withBorn", Date.class);
        TestUploadV2Builder.class.getDeclaredMethod("withSize", DogSize.class);
        Method start2 = TestUploadV2Builder.class.getDeclaredMethod("start");
        assertTrue(Arrays.asList(start2.getExceptionTypes()).contains(ParentUnionException.class));

        // Test return value of uploader from generic type
        ParameterizedType genericV1 = (ParameterizedType)TestUploadUploader.class.getGenericSuperclass();
        assertEquals(genericV1.getActualTypeArguments()[1], Void.class);
        ParameterizedType genericV2 = (ParameterizedType)TestUploadV2Uploader.class.getGenericSuperclass();
        assertEquals(genericV2.getActualTypeArguments()[1], ParentUnion.class);

        // Test exception from generic type
        assertEquals(genericV1.getActualTypeArguments()[1], Void.class);
        assertEquals(genericV2.getActualTypeArguments()[1], ParentUnion.class);

        // Test builder with multiple auth types has prefix
        DbxTestTestUploadV3Builder.class.getDeclaredMethod("withBorn", Date.class);
        DbxTestTestUploadV3Builder.class.getDeclaredMethod("withSize", DogSize.class);
        Method start3 = DbxTestTestUploadV3Builder.class.getDeclaredMethod("start");
        assertTrue(Arrays.asList(start3.getExceptionTypes()).contains(ParentUnionException.class));
    }

    @Test
    public void testDownloadRoutes() throws Exception {
        Class c = DbxTestTestRequests.class;
        Method v1NoBuilder = c.getDeclaredMethod("testDownload", String.class, String.class);
        Method v1Builder = c.getDeclaredMethod("testDownloadBuilder", String.class, String.class);
        Method v2NoBuilder = c.getDeclaredMethod("testDownloadV2", UninitializedReason.class, String.class);
        Method v2Builder = c.getDeclaredMethod("testDownloadV2Builder", UninitializedReason.class, String.class);

        // Test return type
        assertEquals(v1Builder.getReturnType(), TestDownloadBuilder.class);
        assertEquals(v2Builder.getReturnType(), TestDownloadV2Builder.class);

        // Test return type from generic type
        ParameterizedType genericV1 = (ParameterizedType)TestDownloadBuilder.class.getGenericSuperclass();
        assertEquals(genericV1.getActualTypeArguments()[0], Fish.class);
        ParameterizedType genericV2 = (ParameterizedType)TestDownloadV2Builder.class.getGenericSuperclass();
        assertEquals(genericV2.getActualTypeArguments()[0], Fish.class);


        // Test exception type
        assertFalse(Arrays.asList(v1NoBuilder.getExceptionTypes()).contains(ParentUnionException.class));
        assertTrue(Arrays.asList(v2NoBuilder.getExceptionTypes()).contains(ParentUnionException.class));
    }
}
