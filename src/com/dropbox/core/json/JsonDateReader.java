package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class JsonDateReader
{
    /**
     * A parser for dates returned by the Dropbox API.
     */
    public static final JsonReader<Date> Dropbox = new JsonReader<Date>() {
        @Override
        public Date read(JsonParser parser) throws IOException, JsonReadException
        {
            JsonLocation l = parser.getCurrentLocation();
            try {
                char[] buffer = parser.getTextCharacters();
                int offset = parser.getTextOffset();
                int length = parser.getTextLength();
                Date d = parseDropboxDate(buffer, offset, length);
                parser.nextToken();
                return d;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
            catch (java.text.ParseException ex) {
                throw new JsonReadException("bad date: \"" + ex.getMessage() + " at offset " + ex.getErrorOffset(), l);
            }
        }
    };


    public static Date parseDropboxDate(char[] buffer, int offset, int length)
        throws java.text.ParseException
    {
        int i = offset;
        char[] b = buffer;

        if (length != 31) {
            throw new java.text.ParseException("expecting date to be 31 characters, got " + length, 0);
        }

        // Hopefully this check lets the JVM eliminate array bounds checks for the rest of the function.
        if (b.length < i + 31 || i < 0) {
            throw new IllegalArgumentException("range is not within 'b'");
        }

        // 0         1         2         3
        // 0123456789012345678901234567890
        // DDD, DD MMM YYYY HH:MM:SS +0000

        // Check for fixed values.  Using non-short-circuit OR because it's faster
        // for the common case of them all being correct.
        if (b[i+3] != ',' | b[i+4] != ' ' | b[i+7] != ' ' | b[i+11] != ' '
            | b[i+16] != ' ' | b[i+19] != ':' | b[i+22] != ':' | b[i+25] != ' '
            | b[i+26] != '+' | b[i+27] != '0' | b[i+28] != '0' | b[i+29] != '0' | b[i+30] != '0') {
            if (b[i+3] != ',') throw new java.text.ParseException("expecting ','", 3);
            if (b[i+4] != ' ') throw new java.text.ParseException("expecting ' '", 4);
            if (b[i+7] != ' ') throw new java.text.ParseException("expecting ' '", 7);
            if (b[i+11] != ' ') throw new java.text.ParseException("expecting ' '", 11);
            if (b[i+16] != ' ') throw new java.text.ParseException("expecting ' '", 16);
            if (b[i+19] != ':') throw new java.text.ParseException("expecting ':'", 19);
            if (b[i+22] != ':') throw new java.text.ParseException("expecting ':'", 22);
            if (b[i+25] != ' ') throw new java.text.ParseException("expecting ' '", 25);
            if (b[i+26] != '+') throw new java.text.ParseException("expecting '+'", 26);
            if (b[i+27] != '0') throw new java.text.ParseException("expecting '0'", 27);
            if (b[i+28] != '0') throw new java.text.ParseException("expecting '0'", 28);
            if (b[i+29] != '0') throw new java.text.ParseException("expecting '0'", 29);
            if (b[i+30] != '0') throw new java.text.ParseException("expecting '0'", 30);
            throw new AssertionError("unreachable");
        }

        // Parse day of week string.
        if (!isValidDayOfWeek(b[i], b[i+1], b[i+2])) {
            throw new java.text.ParseException("invalid day of week", i);
        }

        // Month string.
        int month = getMonthIndex(b[i+8], b[i+9], b[i+10]);
        if (month == -1) {
            throw new java.text.ParseException("invalid month", 8);
        }

        // Day of month.
        char d1 = b[i+5];
        char d2 = b[i+6];

        if (!isDigit(d1) || !isDigit(d2)) {
            throw new java.text.ParseException("invalid day of month", 5);
        }

        int dayOfMonth = d1*10 + d2 - ('0' * 11);

        // Year
        char y1 = b[i+12];
        char y2 = b[i+13];
        char y3 = b[i+14];
        char y4 = b[i+15];

        if (!isDigit(y1) | !isDigit(y2) | !isDigit(y3) | !isDigit(y4)) {
            throw new java.text.ParseException("invalid year", 12);
        }

        int year = y1*1000 + y2*100 + y3*10 + y4 - ('0' * 1111);

        // Hour
        char h1 = b[i+17];
        char h2 = b[i+18];

        if (!isDigit(h1) | !isDigit(h2)) {
            throw new java.text.ParseException("invalid hour", 17);
        }

        int hour = h1*10 + h2 - ('0' * 11);

        // Minute
        char m1 = b[i+20];
        char m2 = b[i+21];

        if (!isDigit(m1) | !isDigit(m2)) {
            throw new java.text.ParseException("invalid minute", 20);
        }

        int minute = m1*10 + m2 - ('0' * 11);

        // Second
        char s1 = b[i+23];
        char s2 = b[i+24];

        if (!isDigit(s1) | !isDigit(s2)) {
            throw new java.text.ParseException("invalid second", 23);
        }

        int second = s1*10 + s2 - ('0' * 11);

        // TODO: How do we validate that the numbers are in range?
        GregorianCalendar c = new GregorianCalendar(year, month, dayOfMonth, hour, minute, second);
        c.setTimeZone(UTC);
        return c.getTime();
    }

    public static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    private static boolean isDigit(char c)
    {
        return c >= '0' && c <= '9';
    }

    public static boolean isValidDayOfWeek(char a, char b, char c)
    {
        // Using non-short-circuit AND because it's faster for the common case of the values being correct.
        switch (a) {
            case 'S':
                if (b == 'u' & c == 'n') return true;
                if (b == 'a' & c == 't') return true;
                return false;
            case 'M':
                if (b == 'o' & c == 'n') return true;
                return false;
            case 'T':
                if (b == 'u' & c == 'e') return true;
                if (b == 'h' & c == 'u') return true;
                return false;
            case 'W':
                if (b == 'e' & c == 'd') return true;
                return false;
            case 'F':
                if (b == 'r' & c == 'i') return true;
                return false;
            default:
                return false;
        }
    }

    public static int getMonthIndex(char a, char b, char c)
    {
        switch (a) {
            case 'J':
                if (b == 'a' & c == 'n') return 0;
                if (b == 'u') {
                    if (c == 'n') return 5;
                    if (c == 'l') return 6;
                    return -1;
                }
                return -1;
            case 'F':
                if (b == 'e' & c == 'b') return 1;
                return 0;
            case 'M':
                if (b == 'a') {
                    if (c == 'r') return 2;
                    if (c == 'y') return 4;
                    return -1;
                }
                return -1;
            case 'A':
                if (b == 'p' & c == 'r') return 3;
                if (b == 'u' & c == 'g') return 7;
                return -1;
            case 'S':
                if (b == 'e' & c == 'p') return 8;
                return -1;
            case 'O':
                if (b == 'c' & c == 't') return 9;
                return -1;
            case 'N':
                if (b == 'o' & c == 'v') return 10;
                return -1;
            case 'D':
                if (b == 'e' & c == 'c') return 11;
                return -1;
            default:
                return -1;
        }
    }
}
