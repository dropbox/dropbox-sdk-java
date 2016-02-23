package com.dropbox.core.json;

import static com.dropbox.core.util.StringUtil.jq;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class JsonDateReaderTest
{
    @Test
    public void parseDropboxDateTestFew()
    {
        validateDropboxDateParser("Thu, 01 Jan 1970 00:00:00 +0000");
        validateDropboxDateParser("Mon, 18 Jul 2011 20:13:43 +0000");
        validateDropboxDateParser("Sat, 02 Apr 2011 16:20:19 +0000");
    }

    @Test
    public void parseDropboxDateTestMany()
    {
        GregorianCalendar current = new GregorianCalendar(1970, GregorianCalendar.JANUARY, 1, 0, 0, 0);
        current.setTimeZone(JsonDateReader.UTC);

        GregorianCalendar end = new GregorianCalendar(3000, GregorianCalendar.JANUARY, 1, 0, 0, 0);
        end.setTimeZone(JsonDateReader.UTC);

        int count = 0;
        while (current.compareTo(end) < 0) {
            count++;
            validateDropboxDateParser(dateFormatHolder.get().format(current.getTime()));
            current.add(GregorianCalendar.DAY_OF_MONTH, 1);
            validateDropboxDateParser(dateFormatHolder.get().format(current.getTime()));
            current.add(GregorianCalendar.HOUR, 1);
            validateDropboxDateParser(dateFormatHolder.get().format(current.getTime()));
            current.add(GregorianCalendar.MINUTE, 1);
            validateDropboxDateParser(dateFormatHolder.get().format(current.getTime()));
            current.add(GregorianCalendar.SECOND, 1);
        }

        if (count < 1000) throw new AssertionError("Loop didn't run enough: " + count);
    }

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder =  new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue()
        {
            SimpleDateFormat f = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZZZ");
            f.setTimeZone(JsonDateReader.UTC);
            return f;
        }
    };

    private static final ThreadLocal<SimpleDateFormat> preciseDateFormatHolder =  new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue()
        {
            SimpleDateFormat f = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss.SSS ZZZZZ");
            f.setTimeZone(JsonDateReader.UTC);
            return f;
        }
    };

    private static void validateDropboxDateParser(String date)
    {
        Date libResult;
        String libError = null;
        try {
            libResult = dateFormatHolder.get().parse(date);
        }
        catch (java.text.ParseException ex) {
            libResult = null;
            libError = ex.getErrorOffset() + ": " + ex.getMessage();
        }

        char[] buf = date.toCharArray();
        Date ourResult;
        String ourError = null;
        try {
            ourResult = JsonDateReader.parseDropboxDate(buf, 0, buf.length);
        }
        catch (java.text.ParseException ex) {
            ourResult = null;
            ourError = ex.getErrorOffset() + ": " + ex.getMessage();
        }


        if (ourResult == null && libResult != null) {
            throw new AssertionError(jq(date) + ": us=Error(" + ourError + "), lib=Date(" + preciseDateFormatHolder.get().format(libResult) + ")");
        } else if (ourResult != null && libResult == null) {
            throw new AssertionError(jq(date) + ": us=Date(" + ourResult + "), lib=Error(" + libError + ")");
        } else if (ourResult != null && !ourResult.equals(libResult)) {
            throw new AssertionError(jq(date) + ": us=Date(" + preciseDateFormatHolder.get().format(ourResult) + "), lib=Date(" + preciseDateFormatHolder.get().format(libResult) + ")");
        }
    }
}