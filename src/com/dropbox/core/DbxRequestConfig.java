package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.StandardHttpRequestor;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * A grouping of a few configuration parameters for how we should make requests to the
 * Dropbox servers.
 */
public class DbxRequestConfig
{
    /**
     * An identifier for the API client, typically of the form "Name/Version".
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
     */
    public final String clientIdentifier;

    /**
     * The locale of the user of your app.  This is used by the Dropbox server to localize
     * user-visible strings returned by API calls.  For example,
     * {@link com.dropbox.core.DbxEntry.File#humanSize} is a localized string.
     *
     * <p>
     * If the value is {@code null} or some locale that Dropbox doesn't support, the localized
     * strings will be in English.
     * </p>
     */
	public final /*@Nullable*/String userLocale;
	
	/** The as member id. */
	public final /*@Nullable*/String asMemberId; 

    /**
     * The {@link HttpRequestor} implementation to use when making
     * HTTP requests to the Dropbox API servers.  If you don't specify one, this defaults to
     * {@link StandardHttpRequestor#Instance}.
     */
    public final HttpRequestor httpRequestor;

    /**
     * @param clientIdentifier {@link #clientIdentifier}
     * @param userLocale {@link #userLocale}
     * @param httpRequestor {@link #httpRequestor}
     */
    public DbxRequestConfig(String clientIdentifier, /*@Nullable*/String userLocale, /*@Nullable*/String asMemberId, HttpRequestor httpRequestor)
    {
		if (clientIdentifier == null) throw new IllegalArgumentException("'clientIdentifier' should not be null");
        if (httpRequestor == null) throw new IllegalArgumentException("'httpRequestor' should not be null");

        this.clientIdentifier = clientIdentifier;
        this.userLocale = userLocale;
        this.httpRequestor = httpRequestor;
        this.asMemberId = asMemberId;
    }

    /**
     * @param clientIdentifier {@link #clientIdentifier}
     * @param userLocale {@link #userLocale}
     */
    public DbxRequestConfig(String clientIdentifier, String userLocale)
    {
        this(clientIdentifier, userLocale, null, StandardHttpRequestor.Instance);
    }

	/**
	 * Instantiates a new dbx request config.
	 *
	 * @param clientIdentifier the client identifier
	 * @param memberId the member id
	 * @param userLocale the user locale
	 */
	public DbxRequestConfig(String clientIdentifier, String memberId, String userLocale) {
		this(clientIdentifier, userLocale, memberId, StandardHttpRequestor.Instance);
	}

	/**
	 * Member id present.
	 *
	 * @return true, if successful
	 */
	public boolean memberIdPresent() {
		return asMemberId != null && asMemberId.length() > 0;
	}
}
