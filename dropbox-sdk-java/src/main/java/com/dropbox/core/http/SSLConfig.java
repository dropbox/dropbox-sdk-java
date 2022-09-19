package com.dropbox.core.http;

import com.dropbox.core.util.IOUtil;
import static com.dropbox.core.util.LangUtil.mkAssert;
import static com.dropbox.core.util.StringUtil.jq;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/*>>> import checkers.nullness.quals.Nullable; */
/*>>> import checkers.nullness.quals.MonotonicNonNull; */

/**
 * The proper SSL configuration that should be used when connecting to Dropbox
 * API servers.  This includes:
 * <ul>
 * <li>A custom set of trusted root SSL certificates.</li>
 * <li>Requiring TLS v1.0 and above (TLS v1.2 if supported)</li>
 * <li>A limited set of allowed SSL ciphersuites.</li>
 * </ul>
 *
 * <p>
 * {@link #getSSLSocketFactory} returns a properly configured object that you can use
 * to create sockets.
 * </p>
 *
 * <p>
 * If you have an {@link HttpsURLConnection}, call the convenience method
 * {@link #apply(HttpsURLConnection)} (before calling {@link HttpsURLConnection#connect})
 * to apply the appropriate security settings.
 * </p>
 *
 */
public class SSLConfig {
    private static final X509TrustManager TRUST_MANAGER = createTrustManager();
    private static final SSLSocketFactory SSL_SOCKET_FACTORY = createSSLSocketFactory();

    private static final String[] PROTOCOL_LIST_TLS_V1_2 = {"TLSv1.2"};
    private static final String[] PROTOCOL_LIST_TLS_V1_1 = {"TLSv1.1"};
    private static final String[] PROTOCOL_LIST_TLS_V1 = {"TLSv1"};

    private static /*@MonotonicNonNull*/CipherSuiteFilterationResults CACHED_CIPHER_SUITE_FILTERATION_RESULTS;

    private static final String ROOT_CERTS_RESOURCE = "/com/dropbox/core/trusted-certs.raw";
    private static final int MAX_CERT_LENGTH = 10 * 1024;

    // All client ciphersuites allowed by Dropbox.
    //
    // Including IBM, RFC and OpenSSL ciphersuite naming conventions to support
    // all Android API levels:
    //  - API Level >= 10 uses the RFC naming convention
    //  - API Level < 10 uses the OpenSSL naming convention
    private static final HashSet<String> ALLOWED_CIPHER_SUITES = new HashSet<String>(Arrays.asList(new String[] {
        "SSL_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "SSL_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
        "SSL_ECDHE_RSA_WITH_AES_256_CBC_SHA",
        "SSL_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "SSL_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
        "SSL_ECDHE_RSA_WITH_AES_128_CBC_SHA",
        "SSL_ECDHE_RSA_WITH_RC4_128_SHA",
        "SSL_DHE_RSA_WITH_AES_256_GCM_SHA384",
        "SSL_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "SSL_DHE_RSA_WITH_AES_256_CBC_SHA",
        "SSL_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "SSL_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "SSL_DHE_RSA_WITH_AES_128_CBC_SHA",
        "SSL_RSA_WITH_AES_256_GCM_SHA384",
        "SSL_RSA_WITH_AES_256_CBC_SHA256",
        "SSL_RSA_WITH_AES_256_CBC_SHA",
        "SSL_RSA_WITH_AES_128_GCM_SHA256",
        "SSL_RSA_WITH_AES_128_CBC_SHA256",
        "SSL_RSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
        "TLS_ECDHE_RSA_WITH_RC4_128_SHA",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_CBC_SHA",
        "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
        "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_256_CBC_SHA256",
        "TLS_RSA_WITH_AES_256_CBC_SHA",
        "TLS_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_RSA_WITH_AES_128_CBC_SHA256",
        "TLS_RSA_WITH_AES_128_CBC_SHA",
        "ECDHE-RSA-AES256-GCM-SHA384",
        "ECDHE-RSA-AES256-SHA384",
        "ECDHE-RSA-AES256-SHA",
        "ECDHE-RSA-AES128-GCM-SHA256",
        "ECDHE-RSA-AES128-SHA256",
        "ECDHE-RSA-AES128-SHA",
        "ECDHE-RSA-RC4-SHA",
        "DHE-RSA-AES256-GCM-SHA384",
        "DHE-RSA-AES256-SHA256",
        "DHE-RSA-AES256-SHA",
        "DHE-RSA-AES128-GCM-SHA256",
        "DHE-RSA-AES128-SHA256",
        "DHE-RSA-AES128-SHA",
        "AES256-GCM-SHA384",
        "AES256-SHA256",
        "AES256-SHA",
        "AES128-GCM-SHA256",
        "AES128-SHA256",
        "AES128-SHA",
    }));

    /**
     * Apply security settings to an {@link HttpsURLConnection}.  Make sure you
     * haven't called {@link HttpsURLConnection#connect} yet.
     */
    public static void apply(HttpsURLConnection conn) throws SSLException {
        conn.setSSLSocketFactory(SSL_SOCKET_FACTORY);
    }

    public static X509TrustManager getTrustManager() {
        return TRUST_MANAGER;
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        return SSL_SOCKET_FACTORY;
    }

    private static void limitProtocolsAndCiphers(SSLSocket socket) throws SSLException {
        socket.setEnabledProtocols(getFilteredProtocols(socket.getEnabledProtocols()));
        socket.setEnabledCipherSuites(getFilteredCipherSuites(socket.getEnabledCipherSuites()));
    }

    private static String[] getFilteredProtocols(String[] availableProtocols) throws SSLException {
        boolean haveTls1_2 = false;
        boolean haveTls1_1 = false;
        boolean haveTls1 = false;

        for (String protocol : availableProtocols) {
            if (protocol.equals("TLSv1.2")) {
                haveTls1_2 = true;
            } else if (protocol.equals("TLSv1.1")) {
                haveTls1_1 = true;
            } else if (protocol.equals("TLSv1")) {
                haveTls1 = true;
            }
        }

        if (haveTls1_2) return PROTOCOL_LIST_TLS_V1_2;
        if (haveTls1_1) return PROTOCOL_LIST_TLS_V1_1;
        if (haveTls1) return PROTOCOL_LIST_TLS_V1;
        throw new SSLException("Socket's available protocols doesn't overlap with our allowed protocols: " + jq(availableProtocols) + ".");
    }

    private static String[] getFilteredCipherSuites(String[] availableCipherSuites) {
        // Since the available cipher suites probably won't change, try to reuse the
        // result of the last filteration.
        CipherSuiteFilterationResults cached = CACHED_CIPHER_SUITE_FILTERATION_RESULTS;
        if (cached != null) {
            if (Arrays.equals(cached.available, availableCipherSuites)) {
                return cached.filtered;
            }
        }

        // Filter the 'available' list to yield the 'filtered' list.
        ArrayList<String> filtered = new ArrayList<String>(ALLOWED_CIPHER_SUITES.size());
        for (String available : availableCipherSuites) {
            if (ALLOWED_CIPHER_SUITES.contains(available)) {
                filtered.add(available);
            }
        }

        String[] filteredArray = filtered.toArray(new String[filtered.size()]);
        CACHED_CIPHER_SUITE_FILTERATION_RESULTS = new CipherSuiteFilterationResults(availableCipherSuites, filteredArray);
        return filteredArray;
    }

    private static final class CipherSuiteFilterationResults {
        private final String[] available;
        private final String[] filtered;

        public CipherSuiteFilterationResults(String[] available, String[] filtered) {
            this.available = available;
            this.filtered = filtered;
        }
    }

    private static X509TrustManager createTrustManager() {
        KeyStore trustedCertKeyStore = loadKeyStore(ROOT_CERTS_RESOURCE);
        return createTrustManager(trustedCertKeyStore);
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLContext sslContext = createSSLContext(new TrustManager[] { TRUST_MANAGER });
        return new SSLSocketFactoryWrapper(sslContext.getSocketFactory());
    }

    private static final class SSLSocketFactoryWrapper extends SSLSocketFactory {
        private final SSLSocketFactory mBase;

        public SSLSocketFactoryWrapper(SSLSocketFactory base) {
            mBase = base;
        }

        @Override
        public String[] getDefaultCipherSuites() {
            return mBase.getDefaultCipherSuites();
        }

        @Override
        public String[] getSupportedCipherSuites() {
            return mBase.getSupportedCipherSuites();
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException {
            Socket socket = mBase.createSocket(host, port);
            limitProtocolsAndCiphers((SSLSocket) socket);
            return socket;
        }

        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            Socket socket = mBase.createSocket(host, port);
            limitProtocolsAndCiphers((SSLSocket) socket);
            return socket;
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
            Socket socket = mBase.createSocket(host, port, localHost,
                    localPort);
            limitProtocolsAndCiphers((SSLSocket) socket);
            return socket;
        }

        @Override
        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
            Socket socket = mBase.createSocket(address, port,
                    localAddress, localPort);
            limitProtocolsAndCiphers((SSLSocket) socket);
            return socket;
        }

        @Override
        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            Socket socket = mBase.createSocket(s, host, port, autoClose);
            limitProtocolsAndCiphers((SSLSocket) socket);
            return socket;
        }
    }

    private static SSLContext createSSLContext(TrustManager[] trustManagers) {
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException ex) {
            throw mkAssert("Couldn't create SSLContext", ex);
        }

        try {
            sslContext.init(null, trustManagers, null);
        } catch (KeyManagementException ex) {
            throw mkAssert("Couldn't initialize SSLContext", ex);
        }

        return sslContext;
    }

    private static X509TrustManager createTrustManager(KeyStore trustedCertKeyStore) {
        TrustManagerFactory tmf;
        try {
            tmf = TrustManagerFactory.getInstance("X509");
        } catch (NoSuchAlgorithmException ex) {
            throw mkAssert("Unable to create TrustManagerFactory", ex);
        }

        try {
            tmf.init(trustedCertKeyStore);
        } catch (KeyStoreException ex) {
            throw mkAssert("Unable to initialize TrustManagerFactory with key store", ex);
        }

        TrustManager[] trustManagers = tmf.getTrustManagers();
        if (trustManagers.length != 1) {
            throw new AssertionError("More than 1 TrustManager created.");
        }
        if (!(trustManagers[0] instanceof X509TrustManager)) {
            throw new AssertionError("TrustManager not of type X509: " + trustManagers[0].getClass());
        }

        return (X509TrustManager) trustManagers[0];
    }

    private static KeyStore loadKeyStore(String certFileResource) {
        KeyStore keyStore;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            char[] password = {};
            keyStore.load(null, password);
        } catch (KeyStoreException ex) {
            throw mkAssert("Couldn't initialize KeyStore", ex);
        } catch (CertificateException ex) {
            throw mkAssert("Couldn't initialize KeyStore", ex);
        } catch (NoSuchAlgorithmException ex) {
            throw mkAssert("Couldn't initialize KeyStore", ex);
        } catch (IOException ex) {
            throw mkAssert("Couldn't initialize KeyStore", ex);
        }

        InputStream in = SSLConfig.class.getResourceAsStream(certFileResource);
        if (in == null) {
            throw new AssertionError("Couldn't find resource \"" + certFileResource + "\"");
        }
        try {
            loadKeyStore(keyStore, in);
        } catch (KeyStoreException ex) {
            throw mkAssert("Error loading from \"" + certFileResource + "\"", ex);
        } catch (LoadException ex) {
            throw mkAssert("Error loading from \"" + certFileResource + "\"", ex);
        } catch (IOException ex) {
            throw mkAssert("Error loading from \"" + certFileResource + "\"", ex);
        } finally {
            IOUtil.closeInput(in);
        }

        return keyStore;
    }

    public static final class LoadException extends Exception {
        private static final long serialVersionUID = 0L;

        public LoadException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadKeyStore(KeyStore keyStore, InputStream in)
        throws IOException, LoadException, KeyStoreException {
        CertificateFactory x509CertFactory;
        try {
            x509CertFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException ex) {
            throw mkAssert("Couldn't initialize X.509 CertificateFactory", ex);
        }

        Collection<X509Certificate> certs;
        try {
            certs = deserializeCertificates(x509CertFactory, in);
        } catch (CertificateException ex) {
            throw new LoadException("Error loading certificate: " + ex.getMessage(), ex);
        }

        for (X509Certificate cert : certs) {
            String alias = cert.getSubjectX500Principal().getName();
            try {
                keyStore.setCertificateEntry(alias, cert);
            } catch (KeyStoreException ex) {
                throw new LoadException("Error loading certificate: " + ex.getMessage(), ex);
            }
        }
    }

    private static List<X509Certificate> deserializeCertificates(CertificateFactory x509CertFactory, InputStream in) throws IOException, LoadException, CertificateException {
        List<X509Certificate> certs = new ArrayList<X509Certificate>();

        DataInputStream din = new DataInputStream(in);
        byte[] data = new byte[MAX_CERT_LENGTH];
        while (true) {
            int length = din.readUnsignedShort();
            if (length == 0) break;
            if (length > MAX_CERT_LENGTH) {
                throw new LoadException("Invalid length for certificate entry: " + length, null);
            }
            din.readFully(data, 0, length);
            certs.add((X509Certificate) x509CertFactory.generateCertificate(new ByteArrayInputStream(data, 0, length)));
        }

        if (din.read() >= 0) {
            throw new LoadException("Found data after after zero-length header.", null);
        }

        return certs;
    }
}
