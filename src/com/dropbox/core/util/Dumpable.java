package com.dropbox.core.util;

/**
 * A common superclass for pure-data classes.  Contains a function to dump
 * the data (for debugging purposes).
 */
public abstract class Dumpable
{
    public final String toString()
    {
        StringBuilder buf = new StringBuilder();
        toString(buf);
        return buf.toString();
    }

    public final void toString(StringBuilder buf)
    {
        new DumpWriter.Plain(buf).value(this);
    }

    /**
     * Like {@link #toString} except returns a multi-line string.  Every line will
     * always end in a {@code "\n"}.
     *
     * <p>
     * Don't depend on the format of the output to stay the same.  Newer versions of the SDK
     * may change the format.
     * </p>
     */
    public final String toStringMultiline()
    {
        StringBuilder buf = new StringBuilder();
        toString(buf);
        return buf.toString();
    }

    /**
     * Like {@link #toStringMultiline()}, but appends the result to {@code buf}
     * instead of returning a string.
     *
     * <p>
     * Don't depend on the format of the output to stay the same.  Newer versions of the SDK
     * may change the format.
     * </p>
     *
     * @param currentIndent
     *    The number of spaces to use as the initial indentation level.
     */
    public final void toStringMultiline(StringBuilder buf, int currentIndent)
    {
        new DumpWriter.Multiline(buf, currentIndent, 2).value(this);
    }

    protected String getTypeName() { return null; }
    protected abstract void dumpFields(DumpWriter out);
}
