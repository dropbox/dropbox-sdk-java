package com.dropbox.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Base class for API-specific exceptions raised by API v2 routes.
 */
public class DbxApiException extends DbxException {
    private static final long serialVersionUID = 0L;

    private final @Nullable LocalizedText userMessage;

    public DbxApiException(@Nullable String requestId,
                           @Nullable LocalizedText userMessage,
                           @Nonnull String message) {
        super(requestId, message);
        this.userMessage = userMessage;
    }

    public DbxApiException(@Nullable String requestId,
                           @Nullable LocalizedText userMessage,
                           @Nonnull String message,
                           @Nonnull Throwable cause) {
        super(requestId, message, cause);
        this.userMessage = userMessage;
    }

    /**
     * Returns a human-readable message that can be displayed to the end user.
     *
     * <p> If no such message is available, then this method returns {@code null}.
     *
     * @return human-readable message to display to end user, or {@code null} if unavailable
     */
    @Nullable
    public @Nullable LocalizedText getUserMessage() {
        return userMessage;
    }

    protected static @Nonnull String buildMessage(@Nonnull String routeName, @Nullable LocalizedText userMessage) {
        return buildMessage(routeName, userMessage, null);
    }

    protected static @Nonnull String buildMessage(@Nonnull String routeName,
                                                  @Nullable LocalizedText userMessage,
                                                  @Nullable Object errorValue) {
        StringBuilder sb = new StringBuilder();
        sb.append("Exception in ").append(routeName);
        if (errorValue != null) {
            sb.append(": ").append(errorValue);
        }
        if (userMessage != null) {
            sb.append(" (user message: ").append(userMessage).append(")");
        }
        return sb.toString();
    }
}
