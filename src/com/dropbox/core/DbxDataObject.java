package com.dropbox.core;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.util.DumpWriter;
import static com.dropbox.core.util.StringUtil.jq;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A common superclass for the data model classes.  Contains a function to dump
 * the data (for debugging purposes).
 */
public abstract class DbxDataObject
{
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
        dump(new DumpWriter(buf, 0, 2));
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
        dump(new DumpWriter(buf, currentIndent, 2));
    }

    public final void dump(DumpWriter out)
    {
        String typeName = getTypeName();
        if (typeName != null) {
            out.write(typeName).write(" ");
        }
        out.structStart();
        dumpFields(out);
        out.structEnd();
    }

    protected String getTypeName() { return null; }
    protected abstract void dumpFields(DumpWriter out);

    public static void dump(DumpWriter out, DbxDataObject v)
    {
        if (v == null) {
            out.writeln("null");
        } else {
            v.dump(out);
        }
    }

    public static void dump(DumpWriter out, Date v)
    {
        out.writeln(toStringDate(v));
    }

    public static String toStringDate(Date date)
    {
        if (date == null) {
            return "null";
        } else {
            StringBuilder buf = new StringBuilder();
            GregorianCalendar c = new GregorianCalendar(JsonDateReader.UTC);
            c.setTime(date);
            String year = Integer.toString(c.get(Calendar.YEAR));
            String month = zeroPad(Integer.toString(c.get(Calendar.MONTH) + 1), 2);
            String day = zeroPad(Integer.toString(c.get(Calendar.DAY_OF_MONTH)), 2);
            String hour = zeroPad(Integer.toString(c.get(Calendar.HOUR_OF_DAY)), 2);
            String minute = zeroPad(Integer.toString(c.get(Calendar.MINUTE)), 2);
            String second = zeroPad(Integer.toString(c.get(Calendar.SECOND)), 2);
            buf.append('"');
            buf.append(year).append("/").append(month).append("/").append(day).append(" ");
            buf.append(hour).append(":").append(minute).append(":").append(second).append(" UTC");
            buf.append('"');
            return buf.toString();
        }
    }

    private static String zeroPad(String v, int desiredLength)
    {
        while (v.length() < desiredLength) {
            v = "0" + v;
        }
        return v;
    }

    public static void dump(DumpWriter out, Collection<? extends DbxDataObject> v)
    {
        if (v.isEmpty()) {
            out.writeln("[]");
        }
        else {
            out.startIndent("(" + v.size() + ") [");
            for (DbxDataObject o : v) {
                dump(out, o);
            }
            out.endIndent("]");
        }
    }

    public static void dump(DumpWriter out, String v)
    {
        if (v == null) {
            out.writeln("null");
        } else {
            out.writeln(jq(v));
        }
    }
}
