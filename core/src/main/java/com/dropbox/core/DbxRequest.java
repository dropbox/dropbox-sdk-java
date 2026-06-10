package com.dropbox.core;

import java.util.concurrent.Callable;

/**
 * A functional interface representing a request that produces a result {@code <T>} and may throw a checked
 * exception. Extends {@link java.util.concurrent.Callable} but is intended for use in contexts
 * where the operation represents an API request.
 *
 * @param <T> the type of result produced by this request
 */
@FunctionalInterface
public interface DbxRequest<T> extends Callable<T> { }
