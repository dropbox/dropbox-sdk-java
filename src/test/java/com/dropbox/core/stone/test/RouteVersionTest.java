package com.dropbox.core.stone.test;

import static com.google.common.truth.Truth.assertThat;

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
        assertThat(Arrays.asList(v1.getExceptionTypes()).contains(ParentUnionException.class)).isFalse();
        assertThat(Arrays.asList(v2NoOpition.getExceptionTypes()).contains(ParentUnionException.class)).isTrue();
        assertThat(Arrays.asList(v2Option.getExceptionTypes()).contains(ParentUnionException.class)).isTrue();
    }

    @Test
    public void testUploadRoutes() throws Exception {
        Class c = DbxTestTestRequests.class;
        Method v1 = c.getDeclaredMethod("testUpload", UninitializedReason.class, String.class);
        Method v2NoBuilder = c.getDeclaredMethod("testUploadV2", String.class, String.class);
        Method v2Builder = c.getDeclaredMethod("testUploadV2Builder", String.class, String.class);
        Method v3Builder = c.getDeclaredMethod("testUploadV3Builder", String.class, String.class);

        // Test return value
        assertThat(v1.getReturnType()).isEqualTo(TestUploadUploader.class);
        assertThat(v2NoBuilder.getReturnType()).isEqualTo(TestUploadV2Uploader.class);
        assertThat(v2Builder.getReturnType()).isEqualTo(TestUploadV2Builder.class);
        assertThat(v3Builder.getReturnType()).isEqualTo(DbxTestTestUploadV3Builder.class);

        // Test builder
        TestUploadV2Builder.class.getDeclaredMethod("withBorn", Date.class);
        TestUploadV2Builder.class.getDeclaredMethod("withSize", DogSize.class);
        Method start2 = TestUploadV2Builder.class.getDeclaredMethod("start");
        assertThat(Arrays.asList(start2.getExceptionTypes())).contains(ParentUnionException.class);

        // Test return value of uploader from generic type
        ParameterizedType genericV1 = (ParameterizedType)TestUploadUploader.class.getGenericSuperclass();
        assertThat(genericV1.getActualTypeArguments()[1]).isEqualTo(Void.class);
        ParameterizedType genericV2 = (ParameterizedType)TestUploadV2Uploader.class.getGenericSuperclass();
        assertThat(genericV2.getActualTypeArguments()[1]).isEqualTo(ParentUnion.class);

        // Test exception from generic type
        assertThat(genericV1.getActualTypeArguments()[1]).isEqualTo(Void.class);
        assertThat(genericV2.getActualTypeArguments()[1]).isEqualTo(ParentUnion.class);

        // Test builder with multiple auth types has prefix
        DbxTestTestUploadV3Builder.class.getDeclaredMethod("withBorn", Date.class);
        DbxTestTestUploadV3Builder.class.getDeclaredMethod("withSize", DogSize.class);
        Method start3 = DbxTestTestUploadV3Builder.class.getDeclaredMethod("start");
        assertThat(Arrays.asList(start3.getExceptionTypes())).contains(ParentUnionException.class);
    }

    @Test
    public void testDownloadRoutes() throws Exception {
        Class c = DbxTestTestRequests.class;
        Method v1NoBuilder = c.getDeclaredMethod("testDownload", String.class, String.class);
        Method v1Builder = c.getDeclaredMethod("testDownloadBuilder", String.class, String.class);
        Method v2NoBuilder = c.getDeclaredMethod("testDownloadV2", UninitializedReason.class, String.class);
        Method v2Builder = c.getDeclaredMethod("testDownloadV2Builder", UninitializedReason.class, String.class);

        // Test return type
        assertThat(v1Builder.getReturnType()).isEqualTo(TestDownloadBuilder.class);
        assertThat(v2Builder.getReturnType()).isEqualTo(TestDownloadV2Builder.class);

        // Test return type from generic type
        ParameterizedType genericV1 = (ParameterizedType)TestDownloadBuilder.class.getGenericSuperclass();
        assertThat(genericV1.getActualTypeArguments()[0]).isEqualTo(Fish.class);
        ParameterizedType genericV2 = (ParameterizedType)TestDownloadV2Builder.class.getGenericSuperclass();
        assertThat(genericV2.getActualTypeArguments()[0]).isEqualTo(Fish.class);


        // Test exception type
        assertThat(Arrays.asList(v1NoBuilder.getExceptionTypes())).doesNotContain(ParentUnionException.class);
        assertThat(Arrays.asList(v2NoBuilder.getExceptionTypes())).contains(ParentUnionException.class);
    }
}
