package com.dropbox.core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.fasterxml.jackson.core.JsonParseException;

import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.callbacks.DbxGlobalCallbackFactory;
import com.dropbox.core.v2.callbacks.DbxRouteErrorCallback;

/**
 * For internal use only.
 */
public final class DbxWrappedException extends Exception {
    private static final long serialVersionUID = 0L;

    private final Object errValue;  // Really an ErrT instance, but Throwable does not allow generic subclasses.
    private final String requestId;
    private final LocalizedText userMessage;

    public DbxWrappedException(Object errValue, String requestId, LocalizedText userMessage) {
        this.errValue = errValue;
        this.requestId = requestId;
        this.userMessage = userMessage;
    }

    public Object getErrorValue() {
        return errValue;
    }

    public String getRequestId() {
        return requestId;
    }

    public LocalizedText getUserMessage() {
        return userMessage;
    }

    public static <T> DbxWrappedException fromResponse(StoneSerializer<T> errSerializer, HttpRequestor.Response response, String userId)
        throws IOException, JsonParseException {
        String requestId = DbxRequestUtil.getRequestId(response);

        ApiErrorResponse<T> apiResponse = new ApiErrorResponse.Serializer<T>(errSerializer)
            .deserialize(response.getBody());

        T routeError = apiResponse.getError();

        DbxGlobalCallbackFactory factory = DbxRequestUtil.sharedCallbackFactory;
        DbxWrappedException.executeBlockForObject(factory, userId, routeError);
        DbxWrappedException.executeOtherBlocks(factory, userId, routeError);

        return new DbxWrappedException(routeError, requestId, apiResponse.getUserMessage());
    }

    public static void executeOtherBlocks(DbxGlobalCallbackFactory factory, String userId, Object routeError) {
        try {
            // Recursively looks at union errors and the union's current tag type. If there is a handler
            // for the current tag type, it is executed.
            Method m = routeError.getClass().getMethod("tag");
            Object result = m.invoke(routeError);
            String fName = result.toString().toLowerCase() + "value";
            for(Field f : routeError.getClass().getDeclaredFields() ) {
                if (f.getName().equalsIgnoreCase(fName) ) {
                    f.setAccessible(true);
                    Object fieldValue = f.get(routeError);
                    DbxWrappedException.executeBlockForObject(factory, userId, fieldValue);
                    break;
                }
            }
        } catch (Exception e) {
            // No handling
        }
    }

    public static <T> void executeBlockForObject(DbxGlobalCallbackFactory factory, String userId, T routeError) {
        if (factory != null) {
            DbxRouteErrorCallback<T> callback = factory.createRouteErrorCallback(userId, routeError);
            if (callback != null) {
                callback.setRouteError(routeError);
                callback.run();
            }
        }
    }
}
