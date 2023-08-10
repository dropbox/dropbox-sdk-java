package com.dropbox.core.json;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateReaderBench
{
    /**
     * Compare our specialized date parser to Java's more generic
     * SimpleDateFormat parser.
     */
    public static class ParseDropboxDate
    {
        // Not 'final' to avoid constant folding.
        static String[] dates = {
            "Sun, 01 Jan 1971 00:02:03 +0000",
            "Mon, 06 Feb 1982 01:13:14 +0000",
            "Tue, 10 Mar 1993 22:24:25 +0000",
            "Wed, 15 Apr 2004 23:35:36 +0000",
            "Thu, 19 May 2015 14:46:47 +0000",
            "Fri, 22 Jun 2026 15:57:58 +0000",
            "Sat, 27 Jul 2037 16:48:49 +0000",
            "Mon, 30 Aug 2048 17:39:30 +0000",
            "Tue, 03 Sep 2059 18:20:21 +0000",
            "Wed, 12 Oct 2060 19:11:12 +0000",
            "Thu, 25 Nov 2071 20:02:03 +0000",
            "Fri, 31 Dec 2082 21:13:14 +0000",
        };

        static char[][] dateBufs = new char[dates.length][];

        static {
            for (int i = 0; i < dates.length; i++) {
                dateBufs[i] = dates[i].toCharArray();
            }
        }

        @Benchmark
        public Date specialized(Blackhole bh)
        {
            for (char[] dateBuf : dateBufs) {
                try {
                    bh.consume(JsonDateReader.parseDropboxDate(dateBuf, 0, dateBuf.length));
                }
                catch (java.text.ParseException ex) {
                    throw new AssertionError(ex);
                }
            }
            return null;
        }

        @State(Scope.Thread)
        public static class SimpleDateFormatHolder
        {
            public final SimpleDateFormat f = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZZZ");

            {
                f.setTimeZone(JsonDateReader.UTC);
            }
        }

        @Benchmark
        public void standard(Blackhole bh, SimpleDateFormatHolder h)
        {
            for (String date : dates) {
                try {
                    bh.consume(h.f.parse(date));
                }
                catch (java.text.ParseException ex) {
                    throw new AssertionError(ex);
                }
            }
        }

        @Benchmark
        public void standardThreadLocal(Blackhole bh)
        {
            for (String date : dates) {
                try {
                    bh.consume(dateFormatThreadLocal.get().parse(date));
                }
                catch (java.text.ParseException ex) {
                    throw new AssertionError(ex);
                }
            }
        }

        static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
            protected SimpleDateFormat initialValue()
            {
                SimpleDateFormat f = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZZZ");
                f.setTimeZone(JsonDateReader.UTC);
                return f;
            }
        };
    }
}
