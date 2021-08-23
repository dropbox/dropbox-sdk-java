package com.dropbox.core;

import static org.testng.Assert.fail;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalURLFetchServiceTestConfig;

import com.squareup.okhttp.OkHttpClient;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.dropbox.core.http.GoogleAppEngineRequestor;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.OkHttpRequestor;
import com.dropbox.core.http.OkHttp3Requestor;
import com.dropbox.core.http.StandardHttpRequestor;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DeleteErrorException;

// integration test utility class
public final class ITUtil {
    private static final String AUTH_INFO_FILE_PROPERTY = "com.dropbox.test.authInfoFile";
    private static final String HTTP_REQUESTOR_PROPERTY = "com.dropbox.test.httpRequestor";

    private static final Random RAND = new Random(0L);
    private static final long READ_TIMEOUT = TimeUnit.SECONDS.toMillis(20);
    private static final int MAX_RETRIES = 3;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH.mm.ss";
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    // required if we use a GoogleAppEngine HttpRequestor
    private static final LocalServiceTestHelper GAE_TEST_HELPER = new LocalServiceTestHelper(
        new LocalURLFetchServiceTestConfig());

    public static DbxRequestConfig.Builder newRequestConfig() {
        return DbxRequestConfig.newBuilder("sdk-integration-test")
            // enable auto-retry to avoid flakiness
            .withAutoRetryEnabled(MAX_RETRIES)
            .withUserLocaleFrom(Locale.US)
            .withHttpRequestor(newHttpRequestor());
    }

    /**
     * Gets the default HttpRequestor implementation configurable by
     * System property.
     */
    public static HttpRequestor newHttpRequestor() {
        String val = System.getProperty(HTTP_REQUESTOR_PROPERTY);
        Class [] classes = new Class [] {
            StandardHttpRequestor.class,
            OkHttpRequestor.class,
            OkHttp3Requestor.class,
            GoogleAppEngineRequestor.class
        };
        Map<String, Class<?>> validNames = new HashMap<String, Class<?>>();
        for (Class<?> clazz : classes) {
            validNames.put(clazz.getSimpleName(), clazz);
        }

        Class<?> type = validNames.get(val);
        if (type == null || type.equals(StandardHttpRequestor.class)) {
            return newStandardHttpRequestor();
        } else if(type.equals(OkHttpRequestor.class)) {
            return newOkHttpRequestor();
        } else if(type.equals(OkHttp3Requestor.class)) {
            return newOkHttp3Requestor();
        } else if(type.equals(GoogleAppEngineRequestor.class)) {
            return newGoogleAppEngineRequestor();
        } else {
            StringBuilder message = new StringBuilder()
                .append("Invalid value for System property \"")
                .append(HTTP_REQUESTOR_PROPERTY)
                .append("\". Expected ");
            for (String validName : validNames.keySet()) {
                message.append("\"").append(validName).append("\", ");
            }
            message.append("but was: \"").append(val).append("\".");
            fail(message.toString());
            return null;
        }
    }

    public static OkHttpRequestor newOkHttpRequestor() {
        OkHttpClient httpClient = OkHttpRequestor.defaultOkHttpClient().clone();
        httpClient.setReadTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);
        return new OkHttpRequestor(httpClient);
    }

    public static OkHttp3Requestor newOkHttp3Requestor() {
        okhttp3.OkHttpClient httpClient = OkHttp3Requestor.defaultOkHttpClient().newBuilder()
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .build();
        return new OkHttp3Requestor(httpClient);
    }

    public static StandardHttpRequestor newStandardHttpRequestor() {
        StandardHttpRequestor.Config config = StandardHttpRequestor.Config.builder()
            .withReadTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .build();
        return new StandardHttpRequestor(config);
    }

    public static GoogleAppEngineRequestor newGoogleAppEngineRequestor() {
        GoogleAppEngineRequestor requestor = new GoogleAppEngineRequestor();
        requestor.getOptions()
            // seconds
            .setDeadline((HttpRequestor.DEFAULT_CONNECT_TIMEOUT_MILLIS + READ_TIMEOUT) / 1000.0);
        return requestor;
    }

    private static class AuthContainer {
        public static final DbxAuthInfo AUTH = loadAuth();

        private static DbxAuthInfo loadAuth() {
            String path = System.getProperty(AUTH_INFO_FILE_PROPERTY);


            if (path == null) {
                fail("System property \"" + AUTH_INFO_FILE_PROPERTY + "\" not set.");
            }
            try {
                return DbxAuthInfo.Reader.readFromFile(path);
            } catch (JsonReader.FileLoadException ex) {
                fail("Error reading auth info from \"" + path + "\"", ex);
                throw new RuntimeException(ex);
            }
        }
    }

    public static DbxAuthInfo getAuth() {
        return AuthContainer.AUTH;
    }

    public static DbxClientV1 newClientV1() {
        return newClientV1(newRequestConfig());
    }

    public static DbxClientV1 newClientV1(DbxRequestConfig.Builder config) {
        return newClientV1(config.build());
    }

    public static DbxClientV1 newClientV1(DbxRequestConfig config) {
        DbxAuthInfo auth = getAuth();
        return new DbxClientV1(
            config,
            auth.getAccessToken(),
            auth.getHost()
        );
    }

    public static DbxClientV2 newClientV2() {
        return newClientV2(newRequestConfig());
    }

    public static DbxClientV2 newClientV2(DbxRequestConfig.Builder config) {
        return newClientV2(config.build());
    }

    public static DbxClientV2 newClientV2(DbxRequestConfig config) {
        DbxAuthInfo auth = getAuth();
        return new DbxClientV2(
            config,
            auth.getAccessToken(),
            auth.getHost()
        );
    }

    private static final class RootContainer {
        public static String ROOT = "/test/dropbox-sdk-java/" + format(new Date());
    }

    public static String root(Class<?> clazz) {
        return RootContainer.ROOT + "/" + clazz.getCanonicalName();
    }

    public static String path(Class<?> clazz, String path) {
        if (!path.startsWith("/") && !path.isEmpty()) {
            path = "/" + path;
        }
        return root(clazz) + path;
    }

    public static String format(Date date) {
        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        format.setTimeZone(UTC);
        return format.format(date);
    }

    public static byte [] randomBytes(int num) {
        byte [] data = new byte[num];
        RAND.nextBytes(data);
        return data;
    }

    public static byte [] toBytes(String content) {
        return content.getBytes(UTF8);
    }

    @BeforeSuite
    public static void setUpGoogleAppEngine() {
        if ("GoogleAppEngine".equals(System.getProperty(HTTP_REQUESTOR_PROPERTY))) {
            GAE_TEST_HELPER.setUp();
        }
    }

    @AfterSuite(alwaysRun=true)
    public static void tearDownGoogleAppEngine() {
        if ("GoogleAppEngine".equals(System.getProperty(HTTP_REQUESTOR_PROPERTY))) {
            GAE_TEST_HELPER.tearDown();
        }
    }

    @BeforeSuite
    @AfterSuite(alwaysRun=true)
    public static void deleteRoot() throws Exception {
        // always use standard HTTP requestor for delete root
        DbxClientV2 client = newClientV2(
            newRequestConfig()
                .withHttpRequestor(newStandardHttpRequestor())
        );
        try {
            client.files().delete(RootContainer.ROOT);
        } catch (DeleteErrorException ex) {
            if (ex.errorValue.isPathLookup() &&
                ex.errorValue.getPathLookupValue().isNotFound()) {
                // ignore
            } else {
                throw ex;
            }
        }
    }
}
