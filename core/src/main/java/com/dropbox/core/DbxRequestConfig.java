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
     * @param clientIdentifier see {@link #getClientIdentifier}
     */
    public DbxRequestConfig(String clientIdentifier) {
        this(clientIdentifier, null);
    }

    /**
     * Creates a new configuration.
     *
     * @param clientIdentifier see {@link #getClientIdentifier}
     * @param userLocale see {@link #getUserLocale}
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
     * @param clientIdentifier see {@link #getClientIdentifier}
     * @param userLocale see {@link #getUserLocale}
     * @param httpRequestor see {@link #getHttpRequestor}
     *
     * @deprecated Use {@link #newBuilder} to customize configuration
     */
    @Deprecated
    public DbxRequestConfig(String clientIdentifier, /*@Nullable*/ String userLocale, HttpRequestor httpRequestor) {
        this(clientIdentifier, userLocale, httpRequestor, 0);
    }

    /**
     * Returns the {@link clientIdentifier} you passed in when constructing this object.
     *
     * <p>
     * The client identifier is usually of the form "SoftwareName/SoftwareVersion".
     * For example, if you have a project named "PhotoEdit", your might set the client
     * identifier to {@code "PhotoEditServer/1.3"} in your server software and to
     * {@code "PhotoEditAndroid/1.8"} in your Android app.
     * </p>
     *
     * <p>
     * This value is prepended to the
     * <a href="https://tools.ietf.org/html/rfc7231#section-5.5.3">"User-Agent"
     * HTTP header</a> on all requests made to the Dropbox API.  This has no effect on the
     * behavior of the Dropbox API, but it may help identify your application when
     * debugging things later.
     * </p>
     */
    public String getClientIdentifier() {
        return clientIdentifier;
    }

    /**
     * Returns the {@code userLocale} you passed in when constructing this object, which
     * defaults to {@code null}.
     *
     * <p>
     * This should be set to the <a href="https://tools.ietf.org/html/bcp47">IETF BCP 47
     * language tag</a> of the end user currently using your software.  Example: "en-US".
     * </p>
     *
     * <p>
     * This value is passed in as the "Dropbox-API-User-Locale" HTTP header on all requests
     * made to the Dropbox API.  It controls the language used by the Dropbox API for certain
     * return values, e.g. like error messages intended for the user.
     * </p>
     *
     * <p>
     * If {@code null}, or if set to a value Dropbox doesn't support, the server will default
     * to the user's configured locale setting.
     * </p>
     */
    public String getUserLocale() {
        return userLocale;
    }

    /**
     * Returns the {@link HttpRequestor} you passed in when constructing this object, which
     * defaults to {@link StandardHttpRequestor#INSTANCE}.
     */
    public HttpRequestor getHttpRequestor() {
        return httpRequestor;
    }

    /**
     * Returns whether or not the client should automatically retry RPC and download requests after
     * receiving a {@link RetryException}.
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
     * @param clientIdentifier see {@link #getClientIdentifier}
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
