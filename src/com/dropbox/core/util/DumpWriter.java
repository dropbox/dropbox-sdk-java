package com.dropbox.core.util;

import com.dropbox.core.json.JsonDateReader;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*>>> import checkers.nullness.quals.Nullable; */

public abstract class DumpWriter
{
    public abstract DumpWriter recordStart(/*@Nullable*/String name);
    public abstract DumpWriter recordEnd();
    public abstract DumpWriter f(String name);  // Write a field name.  You should write a value after.
    public abstract DumpWriter listStart();
    public abstract DumpWriter listEnd();
    public abstract DumpWriter verbatim(String s);

    public static final class Multiline extends DumpWriter
    {
        private final StringBuilder buf;
        private final int indentAmount;
        private int currentIndent;

        public Multiline(StringBuilder buf, int indentAmount, int currentIndent, boolean nl)
        {
            if (buf == null) throw new IllegalArgumentException("'buf' must not be null");
            if (indentAmount < 0) throw new IllegalArgumentException("'indentAmount' must be non-negative");
            if (currentIndent < 0) throw new IllegalArgumentException("'currentIndent' must be non-negative");
            this.buf = buf;
            this.indentAmount = indentAmount;
            this.currentIndent = currentIndent;
            this.nl = nl;
        }

        public Multiline(StringBuilder buf, int indentAmount, boolean nl)
        {
            this(buf, indentAmount, 0, nl);
        }

        boolean nl = true;

        private void prefix()
        {
            if (nl) {
                int l = currentIndent;
                for (int i = 0; i < l; i++) {
                    buf.append(' ');
                }
            }
        }

        private void indentMore()
        {
            currentIndent += indentAmount;
        }

        private void indentLess()
        {
            if (indentAmount > currentIndent) throw new IllegalStateException("indent went negative");
            currentIndent -= indentAmount;
        }

        @Override
        public DumpWriter recordStart(/*@Nullable*/String name)
        {
            prefix();
            if (name != null) {
                buf.append(name).append(" ");
            }
            buf.append("{\n");
            nl = true;
            indentMore();
            return this;
        }

        @Override
        public DumpWriter recordEnd()
        {
            if (!nl) throw new AssertionError("called recordEnd() in a bad state");
            indentLess();
            prefix();
            buf.append("}\n");
            nl = true;
            return this;
        }

        @Override
        public DumpWriter f(String name)
        {
            if (!nl) throw new AssertionError("called fieldStart() in a bad state");
            prefix();
            buf.append(name).append(" = ");
            nl = false;
            return this;
        }

        @Override
        public DumpWriter listStart()
        {
            prefix();
            buf.append("[\n");
            nl = true;
            indentMore();
            return this;
        }

        @Override
        public DumpWriter listEnd()
        {
            if (!nl) throw new AssertionError("called listEnd() in a bad state");
            indentLess();
            prefix();
            buf.append("]\n");
            nl = true;
            return this;
        }

        @Override
        public DumpWriter verbatim(String s)
        {
            prefix();
            buf.append(s);
            buf.append('\n');
            nl = true;
            return this;
        }
    }

    public static final class Plain extends DumpWriter
    {
        private StringBuilder buf;

        public Plain(StringBuilder buf)
        {
            this.buf = buf;
        }

        private boolean needSep = false;

        private void sep()
        {
            if (needSep) {
                buf.append(", ");
            } else {
                needSep = true;
            }
        }

        @Override
        public DumpWriter recordStart(/*@Nullable*/String name)
        {
            if (name != null) {
                buf.append(name);
            }
            buf.append("(");
            needSep = false;
            return this;
        }

        @Override
        public DumpWriter recordEnd()
        {
            buf.append(")");
            needSep = true;
            return this;
        }

        @Override
        public DumpWriter f(String name)
        {
            sep();
            buf.append(name).append('=');
            needSep = false;
            return this;
        }

        @Override
        public DumpWriter listStart()
        {
            sep();
            buf.append("[");
            needSep = false;
            return this;
        }

        @Override
        public DumpWriter listEnd()
        {
            buf.append("]");
            needSep = true;
            return this;
        }

        @Override
        public DumpWriter verbatim(String s)
        {
            sep();
            buf.append(s);
            return this;
        }
    }

    public DumpWriter fieldVerbatim(String name, String s)
    {
        return f(name).verbatim(s);
    }

    public DumpWriter v(/*@Nullable*/Iterable<? extends Dumpable> list)
    {
        if (list == null) {
            verbatim("null");
        } else {
            listStart();
            for (Dumpable d : list) {
                v(d);
            }
            listEnd();
        }
        return this;
    }

    public DumpWriter v(/*@Nullable*/String v)
    {
        if (v == null) {
            verbatim("null");
        } else {
            verbatim(StringUtil.jq(v));
        }
        return this;
    }

    public DumpWriter v(int v) { return verbatim(Integer.toString(v)); }
    public DumpWriter v(long v) { return verbatim(Long.toString(v)); }
    public DumpWriter v(boolean v) { return verbatim(Boolean.toString(v)); }
    public DumpWriter v(float v) { return verbatim(Float.toString(v)); }
    public DumpWriter v(double v) { return verbatim(Double.toString(v)); }
    public DumpWriter v(/*@Nullable*/Date v) { return verbatim(toStringDate(v)); }
    public DumpWriter v(/*@Nullable*/Long v) { return verbatim(v == null ? "null" : Long.toString(v)); }

    public DumpWriter v(/*@Nullable*/Dumpable v)
    {
        if (v == null) {
            verbatim("null");
        }
        else {
            recordStart(v.getTypeName());
            v.dumpFields(this);
            recordEnd();
        }
        return this;
    }

    public static String toStringDate(/*@Nullable*/Date date)
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
}
