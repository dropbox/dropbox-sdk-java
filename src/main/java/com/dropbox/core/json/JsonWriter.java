package com.dropbox.core.json;

import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.dropbox.core.json.JsonDateReader;

public abstract class JsonWriter<T>
{
    public abstract void write(T value, JsonGenerator g)
        throws IOException;

    public void write(T value, JsonGenerator g, int level)
            throws IOException
    {
        write(value, g);
    }

    public void writeFields(T value, JsonGenerator g)
        throws IOException
    {
        // Default does nothing.  Override for struct fields.
    }

    public final String writeToString(T value, boolean indent)
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            JsonGenerator g = JsonReader.jsonFactory.createGenerator(out);
            if (indent) {
                g = g.useDefaultPrettyPrinter();
            }
            try {
                write(value, g);
            }
            finally {
                g.flush();
            }
            return new String(out.toByteArray(), "UTF-8");

        }
        catch (IOException ex) {
            // We don't want to see exceptions.
            throw LangUtil.mkAssert("Impossible", ex);
        }
    }

    public final String writeToString(T value)
    {
        return writeToString(value, true);
    }

    public final void writeToStream(T value, OutputStream out, boolean indent)
        throws IOException
    {
        JsonGenerator g = JsonReader.jsonFactory.createGenerator(out);
        if (indent) {
            g = g.useDefaultPrettyPrinter();
        }
        try {
            write(value, g);
        }
        finally {
            g.flush();
        }
    }

    public final void writeToStream(T value, OutputStream out)
            throws IOException
    {
        writeToStream(value, out, true);
    }

    public final void writeToFile(T value, File file, boolean indent)
        throws IOException
    {
        FileOutputStream fout = new FileOutputStream(file);
        try {
            writeToStream(value, fout, indent);
        }
        finally {
            fout.close();
        }
    }

    public final void writeToFile(T value, File file)
            throws IOException
    {
        writeToFile(value, file, true);
    }

    public final void writeToFile(T value, String fileName, boolean indent)
            throws IOException
    {
        writeToFile(value, new File(fileName), indent);
    }

    public final void writeToFile(T value, String fileName)
        throws IOException
    {
        writeToFile(value, fileName, true);
    }

    public final void writeDateIso(java.util.Date date, JsonGenerator g)
            throws IOException
    {
        // TODO: Make df static (but then need this method to be synchronized)
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String dateFormatted = df.format(date);
        g.writeString(dateFormatted);
    }

    static private final String weekdays[] = {null, "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    static private final String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", null};

    public final void writeDate(java.util.Date date, JsonGenerator g)
        throws IOException
    {
        GregorianCalendar c = new GregorianCalendar(JsonDateReader.UTC);
        c.setTime(date);

        String year = Integer.toString(c.get(Calendar.YEAR));
        String month = months[c.get(Calendar.MONTH)];
        String day = zeroPad(Integer.toString(c.get(Calendar.DAY_OF_MONTH)), 2);
        String hour = zeroPad(Integer.toString(c.get(Calendar.HOUR_OF_DAY)), 2);
        String minute = zeroPad(Integer.toString(c.get(Calendar.MINUTE)), 2);
        String second = zeroPad(Integer.toString(c.get(Calendar.SECOND)), 2);
        String weekday = weekdays[c.get(Calendar.DAY_OF_WEEK)];

        StringBuilder buf = new StringBuilder();

        buf.append(weekday).append(", ");
        buf.append(day).append(" ").append(month).append(" ").append(year).append(" ");
        buf.append(hour).append(":").append(minute).append(":").append(second).append(" +0000");

        g.writeString(buf.toString());
    }

    private static String zeroPad(String v, int desiredLength)
    {
        while (v.length() < desiredLength) {
            v = "0" + v;
        }
        return v;
    }

    // TODO: Convert JsonGenerationExceptions to RuntimeExceptions.
}
