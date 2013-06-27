package com.dropbox.core;

import java.io.IOException;

/**
 * The base exception thrown by Dropbox API calls.  Normally, you'll need to
 * do something specific for {@link InvalidAccessToken} and possibly for
 * {@link RetryLater}.  The rest you should probably just log and investigate
 * manually.
 */
public class DbxException extends Exception
{
	public DbxException(String message) { super(message); }
    public DbxException(String message, Throwable cause) { super(message, cause); }
	public static final long serialVersionUID = 0;

	/**
	 * The server said that something went wrong on its end (HTTP 500 error code).
     * This indicates bug on the Dropbox server, but there are multiple potential causes.
     *
     * <ul>
     * <li>Sometimes it's just a bug and there's nothing you can
     *     do about it until its fixed.  Report it on the Dropbox API forums.
     *     </li>
     * <li>Sometimes you're actually making an invalid request, but for some reason
     *     the server's validation logic isn't catching the problem and it's
     *     causing the server to error-out somewhere down the line.  You may be able to
     *     fix your request and get things working.  This is still a bug on Dropbox's end,
     *     so you should still report it on the Dropbox API forums.</li>
     * <li>Sometimes the error is intermittent.  It may only happen once every few
     *     requests, in which case you can temporarily work around the issue by
     *     retrying the request.  Again, this still counts as a bug so report it on
     *     the forums.</li>
     * <li>Sometimes the error is temporary.  For example, Dropbox might be experiencing
     *     a temporary network or hardware issue.  If you wait a few minutes, the error
     *     might stop happening.  You might want to check the forums to see if other
     *     people are seeing the same thing.</li>
     * </ul>
	 */
	public static final class ServerError extends DbxException
	{
		public ServerError(String message) { super(message); }
		public static final long serialVersionUID = 0;
	}

    /**
     * The server is overloaded, or you have hit a rate limit.  Try again later.
     */
    public static final class RetryLater extends DbxException
    {
        // TODO: Maybe parse out the server's recommended delay
        public RetryLater(String message)
        {
            super(message);
        }
		public static final long serialVersionUID = 0;
    }

    /**
     * Something unexpected happened with either the request or the response.
     * This can happen if there's a bug in the client code (including this
     * library), if there's a bug in on the Dropbox server, or if Dropbox
     * made a change to the API that changed the behavior of something and
     * we haven't upgraded our SDK yet.
     *
     * <p>
     * Typically, these kinds of exceptions should be logged, so you can
     * investigate later.
     * </p>
     */
    public static abstract class ProtocolError extends DbxException
    {
        public ProtocolError(String message) { super(message); }
        public ProtocolError(String message, Throwable cause) { super(message, cause); }
		public static final long serialVersionUID = 0;
    }

    /**
     * This is what is thrown when the Dropbox server tells us that it didn't
     * like something about our request.  This corresponds to the HTTP 400 status code.
     */
	public static final class BadRequest extends ProtocolError
	{
		public BadRequest(String message) { super(message); }
		public static final long serialVersionUID = 0;
	}

    /**
     * Thrown when we the response from the Dropbox server isn't something we expect.
     * For example, if the JSON returned by the server is malformed or missing fields.
     */
    public static class BadResponse extends ProtocolError
    {
        public BadResponse(String message) { super(message); }
        public BadResponse(String message, Throwable cause) { super(message, cause); }
        public static final long serialVersionUID = 0;
    }

    /**
     * Thrown when the Dropbox server responds with an HTTP status code we didn't expect.
     */
	public static class BadResponseCode extends BadResponse
	{
        public final int statusCode;

        public BadResponseCode(String message, int statusCode)
        {
            super(message);
            this.statusCode = statusCode;
        }

		public BadResponseCode(String message, int statusCode, Throwable cause)
        {
            super(message, cause);
            this.statusCode = statusCode;
        }

		public static final long serialVersionUID = 0;
	}

    /**
     * This is what gets thrown when there's an IOException when reading or writing
     * to the network (when communicating with the Dropbox API servers).
     *
     * <p>
     * We use a separate exception class (instead of just relaying IOException) to
     * make it easier for you to distinguish between I/O errors communicating with
     * Dropbox and I/O errors from your own code.
     * </p>
     */
    public static final class NetworkIO extends DbxException
    {
        public final IOException underlying;
        public NetworkIO(IOException underlying)
        {
            super(underlying.toString(), underlying);
            this.underlying = underlying;
        }
		public static final long serialVersionUID = 0;
    }

    /**
     * Gets thrown when the access token you're using to make API calls is invalid.
     *
     * <p>
     * One potential cause of the error is a programming error on your end.  Make sure
     * the access token you are passing in to {@link DbxClient} is valid.
     * </p>
     *
     * <p>
     * A more typical situation is that your access token <em>was</em> valid, but the
     * user has since "unlinked" your application via the Dropbox website
     * (<a href="http://www.dropbox.com/account#applications">http://www.dropbox.com/account#applications</a>).
     * When a user unlinks your application, your access tokens for that user become
     * invalid.  You can re-run the authorization process to obtain a new access token.
     * </p>
     */
    public static final class InvalidAccessToken extends DbxException
    {
        public InvalidAccessToken(String message) { super(message); }
		public static final long serialVersionUID = 0;
    }
}
