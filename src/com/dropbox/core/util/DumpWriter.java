package com.dropbox.core.util;

import com.dropbox.core.json.JsonDateReader;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class DumpWriter
{
    public abstract DumpWriter recordStart(String name);
    public abstract DumpWriter recordEnd();
    public abstract DumpWriter fieldStart(String name);
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
        public DumpWriter recordStart(String name)
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
        public DumpWriter fieldStart(String name)
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
        public DumpWriter recordStart(String name)
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
        public DumpWriter fieldStart(String name)
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

    public DumpWriter fieldVebatim(String name, String s)
    {
        return fieldStart(name).verbatim(s);
    }

    public DumpWriter field(String name, String v) { return fieldStart(name).value(v); }
    public DumpWriter field(String name, int v) { return fieldStart(name).value(v); }
    public DumpWriter field(String name, long v) { return fieldStart(name).value(v); }
    public DumpWriter field(String name, boolean v) { return fieldStart(name).value(v); }
    public DumpWriter field(String name, Date v) { return fieldStart(name).value(v); }
    public DumpWriter field(String name, Dumpable v) { return fieldStart(name).value(v); }

    public DumpWriter list(Iterable<? extends Dumpable> list)
    {
        listStart();
        values(list);
        return listEnd();
    }

    public DumpWriter value(String v)
    {
        if (v == null) {
            verbatim("null");
        } else {
            verbatim(StringUtil.jq(v));
        }
        return this;
    }

    public DumpWriter value(int v) { return verbatim(Integer.toString(v)); }
    public DumpWriter value(long v) { return verbatim(Long.toString(v)); }
    public DumpWriter value(boolean v) { return verbatim(Boolean.toString(v)); }
    public DumpWriter value(Date v) { return verbatim(toStringDate(v)); }

    public DumpWriter value(Dumpable v)
    {
        recordStart(v.getTypeName());
        v.dumpFields(this);
        return recordEnd();
    }

    public DumpWriter values(Iterable<? extends Dumpable> list)
    {
        listStart();
        for (Dumpable d : list) {
            value(d);
        }
        return listEnd();
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
}
