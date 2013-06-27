package com.dropbox.core.util;

import java.util.Arrays;

public class LangUtil
{
    public static RuntimeException mkAssert(String messagePrefix, Throwable cause)
    {
        RuntimeException ae = new RuntimeException(messagePrefix + ": " + cause.getMessage());
        ae.initCause(cause);
        return ae;
        // XXX: Using AssertionError doesn't work for some reason (maybe Android bug).  Trying
        // to call initCause results in "cause already initialized" exception.  Switching to
        // RuntimeException worked.
    }

    public static <T> T[] arrayConcat(T[] a, T[] b)
    {
        if (a == null) throw new IllegalArgumentException("'a' can't be null");
        if (b == null) throw new IllegalArgumentException("'b' can't be null");
        T[] r = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }
}
