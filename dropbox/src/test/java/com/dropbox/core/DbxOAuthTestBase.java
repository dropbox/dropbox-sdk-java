package com.dropbox.core;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.fail;

public class DbxOAuthTestBase {

    protected static String extractQueryParam(String query, String param) {
        Map<String, List<String>> params = toParamsMap(query);

        if (!params.containsKey(param)) {
            fail("Param \"" + param + "\" not found in: " + query);
            return null;
        }

        List<String> values = params.get(param);
        if (values.size() > 1) {
            fail("Param \"" + param + "\" appears more than once in: " + query);
            return null;
        }

        return values.get(0);
    }

    protected static void assertAuthorizationUrls(String actual, String expected) {
        try {
            URL a = new URL(actual);
            URL b = new URL(expected);

            assertThat(a.getProtocol()).isEqualTo(b.getProtocol());
            assertThat(a.getAuthority()).isEqualTo(b.getAuthority());
            assertThat(a.getPath()).isEqualTo(b.getPath());
            assertThat(a.getRef()).isEqualTo(b.getRef());

            Map<String, List<String>> pa = toParamsMap(new URL(actual));
            Map<String, List<String>> pb = toParamsMap(new URL(actual));

            assertThat(pa.keySet()).isEqualTo(pb.keySet());
            for (String key : pa.keySet()) {
                if ("state".equals(key)) {
                    continue;
                }
                assertThat(pa.get(key)).isEqualTo(pb.get(key));
            }
        } catch (Exception ex) {
            fail("Couldn't compare authorization URLs", ex);
        }
    }

    protected static Map<String, String[]> params(String ... pairs) {
        if ((pairs.length % 2) != 0) {
            fail("pairs must be a multiple of 2.");
        }

        Map<String, String[]> query = new HashMap<String, String[]>();
        for (int i = 0; i < pairs.length; i += 2) {
            query.put(pairs[i], new String [] { pairs[i + 1] });
        }
        return query;
    }

    protected static Map<String, List<String>> toParamsMap(URL url) {
        return toParamsMap(url.getQuery());
    }

    protected static Map<String, List<String>> toParamsMap(String query) {
        try {
            String [] pairs = query.split("&");
            Map<String, List<String>> params = new HashMap<String, List<String>>(pairs.length);

            for (String pair : pairs) {
                String [] keyValue = pair.split("=", 2);
                String key = keyValue[0];
                String value = keyValue.length == 2 ? keyValue[1] : "";

                List<String> others = params.get(key);
                if (others == null) {
                    others = new ArrayList<String>();
                    params.put(key, others);
                }

                others.add(URLDecoder.decode(value, "UTF-8"));
            }

            return params;
        } catch (Exception ex) {
            fail("Couldn't build query parameter map from: " + query, ex);
            return null;
        }
    }

    protected static final class SimpleSessionStore implements DbxSessionStore {
        private String token;

        public SimpleSessionStore() {
            this.token = null;
        }

        @Override
        public String get() {
            return token;
        }

        @Override
        public void set(String value) {
            this.token = value;
        }

        @Override
        public void clear() {
            this.token = null;
        }
    }
}
