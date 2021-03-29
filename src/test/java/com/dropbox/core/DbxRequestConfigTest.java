package com.dropbox.core;

import static org.testng.Assert.*;

import java.util.Locale;

import org.testng.annotations.Test;

public class DbxRequestConfigTest {

    @Test
    @SuppressWarnings("deprecation")
    public void testUserLocales() {
        String clientId = "testBasicLocales";

        // APIv1 is more lenient about locale formats, but APIv2 is not. Ensure we are converting
        // all non-standard locale formats to IETF BCP 47 Language Tags for APIv2.

        // default should not be "en"
        assertEquals(new DbxRequestConfig(clientId).getUserLocale(), null);
        assertEquals(newConfigBuilder(clientId)
                     .withUserLocaleFromPreferences().build().getUserLocale(), null);
        assertEquals(newConfig(clientId, (String) null).getUserLocale(), null);
        assertEquals(newConfig(clientId, (Locale) null).getUserLocale(), null);

        // basic english
        assertEquals(new DbxRequestConfig(clientId, "en").getUserLocale(), "en");
        assertEquals(newConfig(clientId, "en").getUserLocale(), "en");
        assertEquals(newConfig(clientId, Locale.ENGLISH).getUserLocale(), "en");

        // UK english
        assertEquals(new DbxRequestConfig(clientId, "en_GB").getUserLocale(), "en-GB");
        assertEquals(newConfig(clientId, "en_GB").getUserLocale(), "en-GB");
        assertEquals(newConfig(clientId, "en-GB").getUserLocale(), "en-GB");
        assertEquals(newConfig(clientId, Locale.UK).getUserLocale(), "en-GB");

        // Custom, variant gets truncated
        Locale custom = new Locale("ko", "KR", "dropbox_variant");
        assertEquals(new DbxRequestConfig(clientId, custom.toString()).getUserLocale(), "ko-KR");
        assertEquals(newConfig(clientId, custom.toString()).getUserLocale(), "ko-KR");
        assertEquals(newConfig(clientId, "ko-KR-Dropbox-x-lvariant-foo").getUserLocale(), "ko-KR-Dropbox-x-lvariant-foo");
        assertEquals(newConfig(clientId, "ko_KR_Dropbox_foo").getUserLocale(), "ko-KR");
        assertEquals(newConfig(clientId, custom).getUserLocale(), "ko-KR");

        // Casing
        assertEquals(new DbxRequestConfig(clientId, "FR_CA").getUserLocale(), "fr-CA");
        assertEquals(newConfig(clientId, "FR_CA").getUserLocale(), "fr-CA");

        // Missing lang (no translation is done)
        assertEquals(new DbxRequestConfig(clientId, "_FR").getUserLocale(), "_FR");
        assertEquals(newConfig(clientId, "_FR").getUserLocale(), "_FR");

        // Missing region
        assertEquals(new DbxRequestConfig(clientId, "de__POSIX").getUserLocale(), "de");
        assertEquals(newConfig(clientId, "de__POSIX").getUserLocale(), "de");
    }

    private static DbxRequestConfig.Builder newConfigBuilder(String clientId) {
        return DbxRequestConfig.newBuilder(clientId);
    }

    private static DbxRequestConfig newConfig(String clientId, String locale) {
        return DbxRequestConfig.newBuilder(clientId).withUserLocale(locale).build();
    }

    private static DbxRequestConfig newConfig(String clientId, Locale locale) {
        return DbxRequestConfig.newBuilder(clientId).withUserLocaleFrom(locale).build();
    }
}
