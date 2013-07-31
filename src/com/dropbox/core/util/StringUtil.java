package com.dropbox.core.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class StringUtil
{
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final char[] HexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f',};

    public static String utf8ToString(byte[] utf8data)
        throws CharacterCodingException
    {
        CharsetDecoder decoder = UTF8.newDecoder();
        CharBuffer result = decoder.decode(ByteBuffer.wrap(utf8data));
        return result.toString();
    }

    public static byte[] stringToUtf8(String s)
    {
        try {
            // Java 1.5 doesn't have the version of getBytes that takes a Charset object, so we
            // just use this one and catch the exception.
            return s.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError("UTF-8 is unsupported: " + ex.getMessage());
        }
    }

    /**
     * Given a string, returns the representation of that string
     * as a Java string literal.
     */
    public static String javaQuotedLiteral(String value)
    {
        StringBuilder b = new StringBuilder(value.length() * 2);
        b.append('"');
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '"': b.append("\\\""); break;
                case '\\': b.append("\\\\"); break;
                case '\n': b.append("\\n"); break;
                case '\r': b.append("\\t"); break;
                case '\t': b.append("\\r"); break;
                case '\0': b.append("\\000"); break;  // Inserting '\0' isn't safe if there's a digit after
                default:
                    if (c >= 0x20 && c <= 0x7e) {
                        b.append(c);
                    } else {
                        int h1 = (c >> 12) & 0xf;
                        int h2 = (c >> 8) & 0xf;
                        int h3 = (c >> 4) & 0xf;
                        int h4 = c & 0xf;
                        b.append("\\u");
                        b.append(HexDigits[h1]);
                        b.append(HexDigits[h2]);
                        b.append(HexDigits[h3]);
                        b.append(HexDigits[h4]);
                    }
                    break;
            }
        }
        b.append('"');
        return b.toString();
    }

    /** Shorthand for {@link #javaQuotedLiteral}. */
    public static String jq(String value) { return javaQuotedLiteral(value); }

    public static String binaryToHex(byte[] data)
    {
        return binaryToHex(data, 0, data.length);
    }

    /**
     * Convert a string of binary bytes to the equivalent hexadecimal string.
     * The resulting String will have two characters for every byte in the
     * input.
     */
    public static String binaryToHex(byte[] data, int offset, int length)
    {
        assert offset < data.length && offset >= 0 : offset + ", " + data.length;
        int end = offset + length;
        assert end <= data.length && end >= 0 : offset + ", " + length + ", " + data.length;

        char[] chars = new char[length*2];
        int j = 0;
        for (int i = offset; i < end; i++) {
            int b = data[i];
            chars[j++] = StringUtil.HexDigits[b >>> 4 & 0xF];
            chars[j++] = StringUtil.HexDigits[b & 0xF];
        }

        return new String(chars);
    }

    /**
     * When you're compating two strings for equality and one of them is a value that could be
     * provided by an attacker and the other is a value that the attacker shouldn't know, use
     * this function to check for equality.  Using regular {@code String.equals} is not
     * secure.
     */
    public static boolean secureStringEquals(String a, String b)
    {
        if (a.length() != b.length()) return false;

        // Prevent timing attacks by making sure the running time of this loop doesn't
        // depend on the contents of the two strings.
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            result |= (ca ^ cb);
        }
        return result == 0;
    }

    public static final String Base64Digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static final String UrlSafeBase64Digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    static {
        assert Base64Digits.length() == 64 : Base64Digits.length();
        assert UrlSafeBase64Digits.length() == 64 : UrlSafeBase64Digits.length();
    }

    public static String base64Encode(byte[] data)
    {
        return base64EncodeGeneric(Base64Digits, data);
    }

    public static String urlSafeBase64Encode(byte[] data)
    {
        return base64EncodeGeneric(UrlSafeBase64Digits, data);
    }

    public static String base64EncodeGeneric(String digits, byte[] data)
    {
        if (data == null) throw new IllegalArgumentException("'data' can't be null");
        if (digits == null) throw new IllegalArgumentException("'digits' can't be null");
        if (digits.length() != 64) throw new IllegalArgumentException("'digits' must be 64 characters long: " + jq(digits));

        int numGroupsOfThreeInputBytes = (data.length + 2) / 3;
        int numOutputChars = numGroupsOfThreeInputBytes * 4;
        StringBuilder buf = new StringBuilder(numOutputChars);

        // Do chunks of three bytes at a time.
        int i = 0;
        while ((i + 3) <= data.length) {
            int b1 = ((int) data[i++]) & 0xff;
            int b2 = ((int) data[i++]) & 0xff;
            int b3 = ((int) data[i++]) & 0xff;

            int d1 = b1 >>> 2;
            int d2 = ((b1 & 0x3) << 4) | (b2 >>> 4);
            int d3 = ((b2 & 0xf) << 2) | (b3 >>> 6);
            int d4 = b3 & 0x3f;

            buf.append(digits.charAt(d1));
            buf.append(digits.charAt(d2));
            buf.append(digits.charAt(d3));
            buf.append(digits.charAt(d4));
        }

        // Do the leftover bytes (either 1 or 2)
        int remaining = data.length - i;
        if (remaining == 0) {
            // All done.
        }
        else if (remaining == 1) {
            int b1 = ((int) data[i++]) & 0xff;

            int d1 = b1 >>> 2;
            int d2 = (b1 & 0x3) << 4;

            buf.append(digits.charAt(d1));
            buf.append(digits.charAt(d2));
            buf.append("==");
        }
        else if (remaining == 2) {
            int b1 = ((int) data[i++]) & 0xff;
            int b2 = ((int) data[i++]) & 0xff;

            int d1 = b1 >>> 2;
            int d2 = ((b1 & 0x3) << 4) | (b2 >>> 4);
            int d3 = ((b2 & 0xf) << 2);

            buf.append(digits.charAt(d1));
            buf.append(digits.charAt(d2));
            buf.append(digits.charAt(d3));
            buf.append('=');
        }
        else {
            throw new AssertionError("data.length: " + data.length + ", i: " + i);
        }

        return buf.toString();
    }
}
