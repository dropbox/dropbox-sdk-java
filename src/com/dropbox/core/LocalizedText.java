package com.dropbox.core;

/**
 * Human-readable text localized to a specific locale.
 */
public final class LocalizedText
{
    /**
     * Localized, human-readable text, never {@code null}.
     */
    public final String text;
    /**
     * Locale of {@link #text} in IETF BCP 47 language tag format, never {@code null}.
     */
    public final String locale;

    /**
     * Create a {@link LocalizedText} object that contains the given {@code text} already localized
     * to {@code locale}.
     *
     * @param text    Localized, human-readable text. Must not be {@code null}
     * @param locale  IETF BCP 47 language tag of text locale. Must not be {@code null}
     */
    public LocalizedText(String text, String locale)
    {
        if (text == null) {
            throw new NullPointerException("text");
        }
        if (locale == null) {
            throw new NullPointerException("locale");
        }

        this.text = text;
        this.locale = locale;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
