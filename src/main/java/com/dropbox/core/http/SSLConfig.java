package com.dropbox.core.http;

import com.dropbox.core.util.IOUtil;
import static com.dropbox.core.util.LangUtil.mkAssert;

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
import java.util.HashSet;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

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
    /**
     * Apply security settings to an {@link HttpsURLConnection}.  Make sure you
     * haven't called {@link HttpsURLConnection#connect} yet.
     */
    public static void apply(HttpsURLConnection conn) throws SSLException {
        conn.setSSLSocketFactory(sslSocketFactory);
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        return sslSocketFactory;
    }

    private static final SSLSocketFactory sslSocketFactory = createSSLSocketFactory();

    private static final String[] protocolListTLS_v1_2 = {"TLSv1.2"};
    private static final String[] protocolListTLS_v1_0 = {"TLSv1.0"};
    private static final String[] protocolListTLS_v1 = {"TLSv1"};

    private static /*@MonotonicNonNull*/CipherSuiteFilterationResults CACHED_CIPHER_SUITE_FILTERATION_RESULTS;

    // All client ciphersuites allowed by Dropbox.
    //
    // Including both RFC and OpenSSL ciphersuite naming conventions to support
    // all Android API levels:
    //  - API Level >= 10 uses the RFC naming convention
    //  - API Level < 10 uses the OpenSSL naming convention
    private static HashSet<String> allowedCipherSuites = new HashSet<String>(Arrays.asList(new String[] {
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

    private static void limitProtocolsAndCiphers(SSLSocket socket) throws SSLException
    {
        // Set TLS protocol version
        outer: {
            for (String protocol : socket.getSupportedProtocols()) {
                if (protocol.equals("TLSv1.2")) {
                    socket.setEnabledProtocols(protocolListTLS_v1_2);
                    break outer;
                }
                if (protocol.equals("TLSv1.0")) {
                    socket.setEnabledProtocols(protocolListTLS_v1_0);
                    break outer;
                }
                if (protocol.equals("TLSv1")) {
                    socket.setEnabledProtocols(protocolListTLS_v1);
                    break outer;
                }
            }
            throw new SSLException("Socket doesn't support protocols \"TLSv1.2\", \"TLSv1.0\" or \"TLSv1\".");
        }

        socket.setEnabledCipherSuites(getFilteredCipherSuites(socket.getSupportedCipherSuites()));
    }

    private static String[] getFilteredCipherSuites(String[] supportedCipherSuites) {
        // Since the supported cipher suites probably won't change, try to reuse the
        // result of the last filteration.
        CipherSuiteFilterationResults cached = CACHED_CIPHER_SUITE_FILTERATION_RESULTS;
        if (cached != null) {
            if (Arrays.equals(cached.supported, supportedCipherSuites)) {
                return cached.enabled;
            }
        }

        // Filter the 'supported' list to yield the 'enabled' list.
        ArrayList<String> enabled = new ArrayList<String>(allowedCipherSuites.size());
        for (String supported : supportedCipherSuites) {
            if (allowedCipherSuites.contains(supported)) {
                enabled.add(supported);
            }
        }

        String[] filteredArray = enabled.toArray(new String[enabled.size()]);
        CACHED_CIPHER_SUITE_FILTERATION_RESULTS = new CipherSuiteFilterationResults(supportedCipherSuites, filteredArray);
        return filteredArray;
    }

    private static final class CipherSuiteFilterationResults {
        private final String[] supported;
        private final String[] enabled;

        public CipherSuiteFilterationResults(String[] supported, String[] enabled) {
            this.supported = supported;
            this.enabled = enabled;
        }

        // The ciphersuites supported by the underlying library.
        public String [] getSupported() {
            return supported;
        }

        // The subset of 'supported' that we allow to be used.
        public String [] getEnabled() {
            return enabled;
        }
    }

    private static final String RootCertsResourceName = "trusted-certs.raw";

    private static SSLSocketFactory createSSLSocketFactory() {
        KeyStore trustedCertKeyStore = loadKeyStore(RootCertsResourceName);
        TrustManager[] trustManagers = createTrustManagers(trustedCertKeyStore);
        SSLContext sslContext = createSSLContext(trustManagers);
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

    private static TrustManager[] createTrustManagers(KeyStore trustedCertKeyStore) {
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

        return tmf.getTrustManagers();
    }

    private static KeyStore loadKeyStore(String certFileResourceName) {
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

        InputStream in = SSLConfig.class.getResourceAsStream(certFileResourceName);
        if (in == null) {
            throw new AssertionError("Couldn't find resource \"" + certFileResourceName + "\"");
        }
        try {
            loadKeyStore(keyStore, in);
        } catch (KeyStoreException ex) {
            throw mkAssert("Error loading from \"" + certFileResourceName + "\"", ex);
        } catch (LoadException ex) {
            throw mkAssert("Error loading from \"" + certFileResourceName + "\"", ex);
        } catch (IOException ex) {
            throw mkAssert("Error loading from \"" + certFileResourceName + "\"", ex);
        } finally {
            IOUtil.closeInput(in);
        }

        return keyStore;
    }

    public static final int MaxCertLength = 10 * 1024;

    public static final class LoadException extends Exception {
        private static final long serialVersionUID = 0L;

        public LoadException(String message) {
            super(message);
        }
    }

    private static void loadKeyStore(KeyStore keyStore, InputStream in)
        throws IOException, LoadException, KeyStoreException {
        CertificateFactory x509CertFactory;
        try {
            x509CertFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException ex) {
            throw mkAssert("Couldn't initialize X.509 CertificateFactory", ex);
        }

        DataInputStream din = new DataInputStream(in);
        byte[] data = new byte[MaxCertLength];
        while (true) {
            int length = din.readUnsignedShort();
            if (length == 0) break;
            if (length > MaxCertLength) {
                throw new LoadException("Invalid length for certificate entry: " + length);
            }
            din.readFully(data, 0, length);
            X509Certificate cert;
            try {
                cert = (X509Certificate) x509CertFactory.generateCertificate(new ByteArrayInputStream(data, 0, length));
            } catch (CertificateException ex) {
                throw new LoadException("Error loading certificate: " + ex.getMessage());
            }
            String alias = cert.getSubjectX500Principal().getName();
            try {
                keyStore.setCertificateEntry(alias, cert);
            } catch (KeyStoreException ex) {
                throw new LoadException("Error loading certificate: " + ex.getMessage());
            }
        }
        if (din.read() >= 0) {
            throw new LoadException("Found data after after zero-length header.");
        }
    }
}
