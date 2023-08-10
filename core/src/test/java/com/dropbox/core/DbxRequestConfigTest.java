package com.dropbox.core;

import static com.google.common.truth.Truth.assertThat;

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
        assertThat(new DbxRequestConfig(clientId).getUserLocale()).isNull();
        assertThat(newConfigBuilder(clientId)
                     .withUserLocaleFromPreferences().build().getUserLocale()).isNull();
        assertThat(newConfig(clientId, (String) null).getUserLocale()).isNull();
        assertThat(newConfig(clientId, (Locale) null).getUserLocale()).isNull();

        // basic english
        assertThat(new DbxRequestConfig(clientId, "en").getUserLocale()).isEqualTo("en");
        assertThat(newConfig(clientId, "en").getUserLocale()).isEqualTo("en");
        assertThat(newConfig(clientId, Locale.ENGLISH).getUserLocale()).isEqualTo("en");

        // UK english
        assertThat(new DbxRequestConfig(clientId, "en_GB").getUserLocale()).isEqualTo("en-GB");
        assertThat(newConfig(clientId, "en_GB").getUserLocale()).isEqualTo("en-GB");
        assertThat(newConfig(clientId, "en-GB").getUserLocale()).isEqualTo("en-GB");
        assertThat(newConfig(clientId, Locale.UK).getUserLocale()).isEqualTo("en-GB");

        // Custom, variant gets truncated
        Locale custom = new Locale("ko", "KR", "dropbox_variant");
        assertThat(new DbxRequestConfig(clientId, custom.toString()).getUserLocale()).isEqualTo("ko-KR");
        assertThat(newConfig(clientId, custom.toString()).getUserLocale()).isEqualTo("ko-KR");
        assertThat(newConfig(clientId, "ko-KR-Dropbox-x-lvariant-foo").getUserLocale()).isEqualTo("ko-KR-Dropbox-x-lvariant-foo");
        assertThat(newConfig(clientId, "ko_KR_Dropbox_foo").getUserLocale()).isEqualTo("ko-KR");
        assertThat(newConfig(clientId, custom).getUserLocale()).isEqualTo("ko-KR");

        // Casing
        assertThat(new DbxRequestConfig(clientId, "FR_CA").getUserLocale()).isEqualTo("fr-CA");
        assertThat(newConfig(clientId, "FR_CA").getUserLocale()).isEqualTo("fr-CA");

        // Missing lang (no translation is done)
        assertThat(new DbxRequestConfig(clientId, "_FR").getUserLocale()).isEqualTo("_FR");
        assertThat(newConfig(clientId, "_FR").getUserLocale()).isEqualTo("_FR");

        // Missing region
        assertThat(new DbxRequestConfig(clientId, "de__POSIX").getUserLocale()).isEqualTo("de");
        assertThat(newConfig(clientId, "de__POSIX").getUserLocale()).isEqualTo("de");
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
