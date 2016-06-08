package com.dropbox.core;

import java.util.Locale;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.StandardHttpRequestor;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * A grouping of a few configuration parameters for how we should make requests to the
 * Dropbox servers.
 */
public class DbxRequestConfig {
    private final String clientIdentifier;
    private final /*@Nullable*/String userLocale;
    private final HttpRequestor httpRequestor;
    private final int maxRetries;

    private DbxRequestConfig(String clientIdentifier, /*@Nullable*/ String userLocale, HttpRequestor httpRequestor, int maxRetries) {
        if (clientIdentifier == null) throw new NullPointerException("clientIdentifier");
        if (httpRequestor == null) throw new NullPointerException("httpRequestor");
        if (maxRetries < 0) throw new IllegalArgumentException("maxRetries");

        this.clientIdentifier = clientIdentifier;
        this.userLocale = toLanguageTag(userLocale);
        this.httpRequestor = httpRequestor;
        this.maxRetries = maxRetries;
    }

    /**
     * Creates a new configuration.
     *
     * @param clientIdentifier client identifier typically in the form "Name/Version" to be used in
     *                         the User-Agent header (see {@link #getClientIdentifier}).
     */
    public DbxRequestConfig(String clientIdentifier) {
        this(clientIdentifier, null);
    }

    /**
     * Creates a new configuration.
     *
     * @param clientIdentifier client identifier typically in the form "Name/Version" to be used in
     *                         the User-Agent header (see {@link #getClientIdentifier}).
     * @param userLocale IETF BCP 47 language tag of locale to use for user-visible text in responses, or
     *                   {@code null} to use the user's Dropbox locale preference.
     *
     * @deprecated Use {@link #newBuilder} to customize configuration
     */
    @Deprecated
    public DbxRequestConfig(String clientIdentifier, /*@Nullable*/ String userLocale) {
        this(clientIdentifier, userLocale, StandardHttpRequestor.INSTANCE);
    }

    /**
     * Creates a new configuration.
     *
     * @param clientIdentifier client identifier typically in the form "Name/Version" to be used in
     *                         the User-Agent header (see {@link #getClientIdentifier}).
     * @param userLocale IETF BCP 47 language tag of locale to use for user-visible text in responses, or
     *                   {@code null} to use the user's Dropbox locale preference.
     * @param httpRequestor HTTP client to use for issuing requests.
     *
     * @deprecated Use {@link #newBuilder} to customize configuration
     */
    @Deprecated
    public DbxRequestConfig(String clientIdentifier, /*@Nullable*/ String userLocale, HttpRequestor httpRequestor) {
        this(clientIdentifier, userLocale, httpRequestor, 0);
    }

    /**
     * Returns an identifier for the API client, typically of the form "Name/Version".
     * This is used to set the HTTP {@code User-Agent} header when making API requests.
     * Example: {@code "PhotoEditServer/1.3"}
     *
     * <p>
     * If you're the author a higher-level library on top of the basic SDK, and the
     * "Photo Edit" Android app is using your library to access Dropbox, you should append
     * your library's name and version to form the full identifier.  For example,
     * if your library is called "File Picker", you might set this field to:
     * {@code "PhotoEditAndroid/2.4 FilePicker/0.1-beta"}
     * </p>
     *
     * <p>
     * The exact format of the {@code User-Agent} header is described in
     * <a href="http://tools.ietf.org/html/rfc2616#section-3.8">section 3.8 of the HTTP specification</a>.
     * </p>
     *
     * <p>
     * Note that the underlying {@link com.dropbox.core.http.HttpRequestor HttpRequestor} may
     * append other things to the {@code User-Agent}, such as the name of the library being used to
     * actually make the HTTP request, or the version of the Java VM.
     * </p>
     *
     * @return HTTP User-Agent identifier for the API client
     */
    public String getClientIdentifier() {
        return clientIdentifier;
    }

    /**
     * Returns the locale of the user of your app as an IETF BCP 47 language tag.  This is used by
     * the Dropbox server to localize user-visible strings returned by API calls.
     *
     * <p> If the value is {@code null} or some locale that Dropbox doesn't support, the strings
     * will be localized based on the user's Dropbox locale preference.
     *
     * <p> Defaults to {@code null}.
     *
     * @return locale of app user, or {@code null} to use user's Dropbox locale settings.
     */
    public String getUserLocale() {
        return userLocale;
    }

    /**
     * The {@link HttpRequestor} implementation to use when making HTTP requests to the Dropbox API
     * servers.
     *
     * <p> Defaults to {@link StandardHttpRequestor#INSTANCE}.
     *
     * @return HTTP requestor to use for issuing HTTP requests.
     */
    public HttpRequestor getHttpRequestor() {
        return httpRequestor;
    }

    /**
     * Returns whether or not the client should automatically retry RPC and download requests after
     * recieving a {@link RetryException}.
     *
     * <p> If enabled, the client will retry the request a max number of times (specified by {@link
     * #getMaxRetries}) before propagating the {@link RetryException}.</p>
     *
     * <p> Defaults to {@code false} (the client will not automatically retry any requests).
     *
     * @return whether this client will automatically retry requests that fail with a {@link
     * RetryException}
     */
    public boolean isAutoRetryEnabled() {
        return maxRetries > 0;
    }

    /**
     * Returns the maximum number of times the client should automatically retry RPC and download
     * requests that fail with a {@link RetryException}.
     *
     * <p> This value does not count the initial request attempt. For example, if maximum retries is
     * 3, the client may issue a request a total of 4 times: once for the initial call, then 3
     * additional times for the 3 retries.</p>
     *
     * <p> This value is ignored unless {@link #isAutoRetryEnabled} is {@code true}.
     *
     * <p> The value returned by this method is always positive if retries are enabled, otherwise it
     * is {@code 0}.
     *
     * <p> Defaults to {@code 3} when retries are enabled.
     *
     * @return maximum number of times the client will retry a request that throws a {@link
     * RetryException}.
     */
    public int getMaxRetries() {
        return maxRetries;
    }

    /**
     * Returns a builder for building a copy of this configuration. Useful for modifying an existing
     * configuration.
     *
     * @return builder configured to build a copy of this instance
     */
    public Builder copy() {
        return new Builder(clientIdentifier, userLocale, httpRequestor, maxRetries);
    }


    /**
     * Returns a new builder for creating a {@link DbxRequestConfig} instance.
     *
     * Identifiers are typically of the form "Name/Version" (e.g. {@code
     * "PhotoEditServer/1.3"}). See {@link #getClientIdentifier} for more details.
     *
     * @param clientIdentifier HTTP User-Agent identifier for the API app (see {@link
     * #getClientIdentifier}), never {@code null}
     */
    public static Builder newBuilder(String clientIdentifier) {
        if (clientIdentifier == null) throw new NullPointerException("clientIdentifier");
        return new Builder(clientIdentifier);
    }

    // Available in Java 7, but not in Java 6. Do a hacky version of it here.
    private static String toLanguageTag(Locale locale) {
        if (locale == null) {
            return null;
        }
        StringBuilder tag = new StringBuilder();

        tag.append(locale.getLanguage().toLowerCase());

        if (!locale.getCountry().isEmpty()) {
            tag.append("-");
            tag.append(locale.getCountry().toUpperCase());
        }

        return tag.toString();
    }

    // APIv1 accepts Locale.toString() formatted locales (e.g. 'en_US'), but APIv2 will return an
    // error if the locale is not in proper Language Tag format. Attempt to convert old locale
    // formats to the new one.
    private static String toLanguageTag(String locale) {
        if (locale == null) {
            return null;
        }
        // assume we are already a language tag
        if (!locale.contains("_")) {
            return locale;
        }

        // language can be missing, in which case we don't even bother
        if (locale.startsWith("_")) {
            return locale;
        }

        // Java 6 does "lang_country_variant". If country is missing, then "lang__variant". If no
        // variant, then just "lang_country".
        String [] parts = locale.split("_", 3);

        String lang = parts[0];
        String country = parts[1];
        String variant = parts.length == 3 ? parts[2] : "";

        return toLanguageTag(new Locale(lang, country, variant));
    }

    /**
     * Builder for {@link DbxRequestConfig}.
     */
    public static final class Builder {
        private final String clientIdentifier;

        private /*@Nullable*/ String userLocale;
        private HttpRequestor httpRequestor;
        private int maxRetries;

        private Builder(String clientIdentifier,
                        /*@Nullable*/ String userLocale,
                        HttpRequestor httpRequestor,
                        int maxRetries) {
            this.clientIdentifier = clientIdentifier;
            this.userLocale = userLocale;
            this.httpRequestor = httpRequestor;
            this.maxRetries = maxRetries;
        }

        private Builder(String clientIdentifier) {
            this.clientIdentifier = clientIdentifier;

            this.userLocale = null;
            this.httpRequestor = StandardHttpRequestor.INSTANCE;
            this.maxRetries = 0;
        }

        /**
         * Set the locale of the app user. User-visible messages returned by the Dropbox servers
         * will be localized to this locale.
         *
         * <p> Defaults to {@code null}, which means strings will be localized according to the
         * user's Dropbox locale preference.
         *
         * @param userLocale locale of app user as an IETF BCP 47 language tag, or {@code null} to
         *                   use the user's Dropbox locale settings.
         *
         * @return this builder
         */
        public Builder withUserLocale(/*@Nullable*/ String userLocale) {
            this.userLocale = userLocale;
            return this;
        }

        /**
         * Set the locale of user-visible messages returned by the Dropbox servers to the user's
         * Dropbox locale.
         *
         * <p> User-visible strings will be localized according to the user's Dropbox locale
         * preference.
         *
         * @return this builder
         */
        public Builder withUserLocaleFromPreferences() {
            this.userLocale = null;
            return this;
        }

        /**
         * Set the locale of the app user. User-visible messages returned by the Dropbox servers
         * will be localized to this locale.
         *
         * <p> Defaults to {@code null}, which means strings will be localized according to the
         * user's Dropbox locale preference.
         *
         * @param userLocale Locale of app user, or {@code null} to use user's Dropbox locale settings.
         *
         * @return this builder
         */
        public Builder withUserLocaleFrom(/*@Nullable*/ Locale userLocale) { // not named withUserLocale because of ambiguous calls when passing 'null'
            this.userLocale = toLanguageTag(userLocale);
            return this;
        }

        /**
         * Set the HTTP requestor to use for issuing network requests to the Dropbox servers.
         *
         * <p> Defaults to {@link StandardHttpRequestor#INSTANCE}.
         *
         * @param httpRequestor HTTP requestor to use for network requests, never {@code null}
         *
         * @return this builder
         */
        public Builder withHttpRequestor(HttpRequestor httpRequestor) {
            if (httpRequestor == null) throw new NullPointerException("httpRequestor");
            this.httpRequestor = httpRequestor;
            return this;
        }

        /**
         * Enables automatic retry of RPC and download requests that fail with a {@link
         * RetryException}.
         *
         * <p> The default number of {@code 3} retries will be used in addition to the initial
         * request. To specify the maximum number of retries, see {@link
         * #withAutoRetryEnabled(int)}.
         *
         * <p> By default, the client will not automatically retry any requests.
         *
         * @return this builder
         */
        public Builder withAutoRetryEnabled() {
            return withAutoRetryEnabled(3);
        }

        /**
         * Disables automatic retry of RPC and download requests that fail with a {@link
         * RetryException}.
         *
         * <p> By default, the client will not automatically retry any requests.
         *
         * @return this builder
         *
         * @see #withAutoRetryEnabled
         */
        public Builder withAutoRetryDisabled() {
            this.maxRetries = 0;
            return this;
        }

        /**
         * Enables automatic retry of RPC and download requests that fail with a {@link
         * RetryException}.
         *
         * <p> The client will retry failed requests a maximum of {@code maxRetries} times before
         * propogating the exception.  Note that {@code maxRetries} does not count the initial
         * request attempt. For example, if {@code maxRetries} is 3, the client may issue a request
         * a total of 4 times: once for the initial call, then 3 additional times for the 3
         * retries. </p>
         *
         * <p> By default, the client will not automatically retry any requests.
         *
         * <p> To enable automatic retries with the default maximum number of attempts, use {@link
         * #withAutoRetryEnabled()}.
         *
         * @param maxRetries maximum number of times to retry a retriable failed request. Must be
         * positive.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException if {@code maxRetries} is not positive.
         */
        public Builder withAutoRetryEnabled(int maxRetries) {
            if (maxRetries <= 0) throw new IllegalArgumentException("maxRetries must be positive");
            this.maxRetries = maxRetries;
            return this;
        }

        /**
         * Builds an instance of {@link DbxRequestConfig} with this builder's configured parameters
         * or defaults.
         *
         * @return new {@code DbxRequestConfig} instance.
         */
        public DbxRequestConfig build() {
            return new DbxRequestConfig(clientIdentifier, userLocale, httpRequestor, maxRetries);
        }
    }
}
