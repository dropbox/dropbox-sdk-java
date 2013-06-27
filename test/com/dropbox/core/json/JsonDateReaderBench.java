package com.dropbox.core.json;

import com.google.caliper.Benchmark;

import java.text.SimpleDateFormat;

public class JsonDateReaderBench
{
    /**
     * Compare our specialized date parser to Java's more generic
     * SimpleDateFormat parser.
     */
    public static final class ParseDropboxDate extends Benchmark
    {
        private static final String[] dates = {
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

        private static final char[][] dateBufs = new char[dates.length][];

        static {
            for (int i = 0; i < dates.length; i++) {
                dateBufs[i] = dates[i].toCharArray();
            }
        }

        public void timeSpecialized(int reps)
        {
            for (int i = 0; i < reps; i++) {
                for (char[] dateBuf : dateBufs) {
                    try {
                        JsonDateReader.parseDropboxDate(dateBuf, 0, dateBuf.length);
                    }
                    catch (java.text.ParseException ex) {
                        throw new AssertionError(ex);
                    }
                }
            }
        }

        public void timeStandard(int reps)
        {
            SimpleDateFormat f = dateFormatHolder.get();
            for (int i = 0; i < reps; i++) {
                for (String date : dates) {
                    try {
                        f.parse(date);
                    }
                    catch (java.text.ParseException ex) {
                        throw new AssertionError(ex);
                    }
                }
            }
        }

        public void timeStandardThreadLocal(int reps)
        {
            for (int i = 0; i < reps; i++) {
                for (String date : dates) {
                    try {
                        dateFormatHolder.get().parse(date);
                    }
                    catch (java.text.ParseException ex) {
                        throw new AssertionError(ex);
                    }
                }
            }
        }

        private static final ThreadLocal<SimpleDateFormat> dateFormatHolder =  new ThreadLocal<SimpleDateFormat>() {
            protected SimpleDateFormat initialValue()
            {
                SimpleDateFormat f = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZZZ");
                f.setTimeZone(JsonDateReader.UTC);
                return f;
            }
        };
    }
}
