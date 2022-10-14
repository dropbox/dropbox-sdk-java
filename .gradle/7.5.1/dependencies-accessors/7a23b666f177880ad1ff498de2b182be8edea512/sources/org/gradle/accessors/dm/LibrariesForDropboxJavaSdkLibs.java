package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `dropboxJavaSdkLibs` extension.
*/
@NonNullApi
public class LibrariesForDropboxJavaSdkLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final AppengineLibraryAccessors laccForAppengineLibraryAccessors = new AppengineLibraryAccessors(owner);
    private final JacksonLibraryAccessors laccForJacksonLibraryAccessors = new JacksonLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final ServletLibraryAccessors laccForServletLibraryAccessors = new ServletLibraryAccessors(owner);
    private final TestLibraryAccessors laccForTestLibraryAccessors = new TestLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForDropboxJavaSdkLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for glide (com.github.bumptech.glide:glide)
         * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGlide() { return create("glide"); }

        /**
         * Creates a dependency provider for okhttp2 (com.squareup.okhttp:okhttp)
         * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp2() { return create("okhttp2"); }

        /**
         * Creates a dependency provider for okhttp3 (com.squareup.okhttp3:okhttp)
         * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getOkhttp3() { return create("okhttp3"); }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() { return laccForAndroidLibraryAccessors; }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at appengine
     */
    public AppengineLibraryAccessors getAppengine() { return laccForAppengineLibraryAccessors; }

    /**
     * Returns the group of libraries at jackson
     */
    public JacksonLibraryAccessors getJackson() { return laccForJacksonLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() { return laccForKotlinLibraryAccessors; }

    /**
     * Returns the group of libraries at servlet
     */
    public ServletLibraryAccessors getServlet() { return laccForServletLibraryAccessors; }

    /**
     * Returns the group of libraries at test
     */
    public TestLibraryAccessors getTest() { return laccForTestLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {
        private final AndroidGradleLibraryAccessors laccForAndroidGradleLibraryAccessors = new AndroidGradleLibraryAccessors(owner);

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for material (com.google.android.material:material)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() { return create("android.material"); }

        /**
         * Returns the group of libraries at android.gradle
         */
        public AndroidGradleLibraryAccessors getGradle() { return laccForAndroidGradleLibraryAccessors; }

    }

    public static class AndroidGradleLibraryAccessors extends SubDependencyFactory {

        public AndroidGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.android.tools.build:gradle)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("android.gradle.plugin"); }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for activity (androidx.activity:activity)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getActivity() { return create("androidx.activity"); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() { return create("androidx.appcompat"); }

            /**
             * Creates a dependency provider for constraintlayout (androidx.constraintlayout:constraintlayout)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConstraintlayout() { return create("androidx.constraintlayout"); }

            /**
             * Creates a dependency provider for recyclerview (androidx.recyclerview:recyclerview)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRecyclerview() { return create("androidx.recyclerview"); }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() { return laccForAndroidxCoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() { return laccForAndroidxTestLibraryAccessors; }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.core.ktx"); }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleRuntimeLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.lifecycle.runtime
         */
        public AndroidxLifecycleRuntimeLibraryAccessors getRuntime() { return laccForAndroidxLifecycleRuntimeLibraryAccessors; }

    }

    public static class AndroidxLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-runtime-ktx)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.lifecycle.runtime.ktx"); }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {
        private final AndroidxTestEspressoLibraryAccessors laccForAndroidxTestEspressoLibraryAccessors = new AndroidxTestEspressoLibraryAccessors(owner);

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("androidx.test.junit"); }

        /**
         * Returns the group of libraries at androidx.test.espresso
         */
        public AndroidxTestEspressoLibraryAccessors getEspresso() { return laccForAndroidxTestEspressoLibraryAccessors; }

    }

    public static class AndroidxTestEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.test.espresso.core"); }

    }

    public static class AppengineLibraryAccessors extends SubDependencyFactory {

        public AppengineLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (com.google.appengine:appengine-api-1.0-sdk)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("appengine.api"); }

    }

    public static class JacksonLibraryAccessors extends SubDependencyFactory {

        public JacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (com.fasterxml.jackson.core:jackson-core)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("jackson.core"); }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {
        private final KotlinGradleLibraryAccessors laccForKotlinGradleLibraryAccessors = new KotlinGradleLibraryAccessors(owner);
        private final KotlinTestLibraryAccessors laccForKotlinTestLibraryAccessors = new KotlinTestLibraryAccessors(owner);

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for coroutines (org.jetbrains.kotlinx:kotlinx-coroutines-core)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutines() { return create("kotlin.coroutines"); }

            /**
             * Creates a dependency provider for stdlib (org.jetbrains.kotlin:kotlin-stdlib)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStdlib() { return create("kotlin.stdlib"); }

        /**
         * Returns the group of libraries at kotlin.gradle
         */
        public KotlinGradleLibraryAccessors getGradle() { return laccForKotlinGradleLibraryAccessors; }

        /**
         * Returns the group of libraries at kotlin.test
         */
        public KotlinTestLibraryAccessors getTest() { return laccForKotlinTestLibraryAccessors; }

    }

    public static class KotlinGradleLibraryAccessors extends SubDependencyFactory {

        public KotlinGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.kotlin:kotlin-gradle-plugin)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("kotlin.gradle.plugin"); }

    }

    public static class KotlinTestLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final KotlinTestAnnotationsLibraryAccessors laccForKotlinTestAnnotationsLibraryAccessors = new KotlinTestAnnotationsLibraryAccessors(owner);

        public KotlinTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlin:kotlin-test)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("kotlin.test"); }

            /**
             * Creates a dependency provider for common (org.jetbrains.kotlin:kotlin-test-common)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() { return create("kotlin.test.common"); }

            /**
             * Creates a dependency provider for junit5 (org.jetbrains.kotlin:kotlin-test-junit5)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit5() { return create("kotlin.test.junit5"); }

            /**
             * Creates a dependency provider for jvm (org.jetbrains.kotlin:kotlin-test)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJvm() { return create("kotlin.test.jvm"); }

        /**
         * Returns the group of libraries at kotlin.test.annotations
         */
        public KotlinTestAnnotationsLibraryAccessors getAnnotations() { return laccForKotlinTestAnnotationsLibraryAccessors; }

    }

    public static class KotlinTestAnnotationsLibraryAccessors extends SubDependencyFactory {

        public KotlinTestAnnotationsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for common (org.jetbrains.kotlin:kotlin-test-annotations-common)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() { return create("kotlin.test.annotations.common"); }

    }

    public static class ServletLibraryAccessors extends SubDependencyFactory {

        public ServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (javax.servlet:servlet-api)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("servlet.api"); }

    }

    public static class TestLibraryAccessors extends SubDependencyFactory {

        public TestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (junit:junit)
             * This dependency was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("test.junit"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidVersionAccessors vaccForAndroidVersionAccessors = new AndroidVersionAccessors(providers, config);
        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final BinaryVersionAccessors vaccForBinaryVersionAccessors = new BinaryVersionAccessors(providers, config);
        private final DependencyVersionAccessors vaccForDependencyVersionAccessors = new DependencyVersionAccessors(providers, config);
        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final KotlinVersionAccessors vaccForKotlinVersionAccessors = new KotlinVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.android
         */
        public AndroidVersionAccessors getAndroid() { return vaccForAndroidVersionAccessors; }

        /**
         * Returns the group of versions at versions.androidx
         */
        public AndroidxVersionAccessors getAndroidx() { return vaccForAndroidxVersionAccessors; }

        /**
         * Returns the group of versions at versions.binary
         */
        public BinaryVersionAccessors getBinary() { return vaccForBinaryVersionAccessors; }

        /**
         * Returns the group of versions at versions.dependency
         */
        public DependencyVersionAccessors getDependency() { return vaccForDependencyVersionAccessors; }

        /**
         * Returns the group of versions at versions.junit
         */
        public JunitVersionAccessors getJunit() { return vaccForJunitVersionAccessors; }

        /**
         * Returns the group of versions at versions.kotlin
         */
        public KotlinVersionAccessors getKotlin() { return vaccForKotlinVersionAccessors; }

    }

    public static class AndroidVersionAccessors extends VersionFactory  {

        private final AndroidCompileVersionAccessors vaccForAndroidCompileVersionAccessors = new AndroidCompileVersionAccessors(providers, config);
        private final AndroidGradleVersionAccessors vaccForAndroidGradleVersionAccessors = new AndroidGradleVersionAccessors(providers, config);
        private final AndroidMinVersionAccessors vaccForAndroidMinVersionAccessors = new AndroidMinVersionAccessors(providers, config);
        private final AndroidTargetVersionAccessors vaccForAndroidTargetVersionAccessors = new AndroidTargetVersionAccessors(providers, config);
        public AndroidVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.android.compile
         */
        public AndroidCompileVersionAccessors getCompile() { return vaccForAndroidCompileVersionAccessors; }

        /**
         * Returns the group of versions at versions.android.gradle
         */
        public AndroidGradleVersionAccessors getGradle() { return vaccForAndroidGradleVersionAccessors; }

        /**
         * Returns the group of versions at versions.android.min
         */
        public AndroidMinVersionAccessors getMin() { return vaccForAndroidMinVersionAccessors; }

        /**
         * Returns the group of versions at versions.android.target
         */
        public AndroidTargetVersionAccessors getTarget() { return vaccForAndroidTargetVersionAccessors; }

    }

    public static class AndroidCompileVersionAccessors extends VersionFactory  {

        public AndroidCompileVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android.compile.sdk (33)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getSdk() { return getVersion("android.compile.sdk"); }

    }

    public static class AndroidGradleVersionAccessors extends VersionFactory  {

        public AndroidGradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android.gradle.plugin (7.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getPlugin() { return getVersion("android.gradle.plugin"); }

    }

    public static class AndroidMinVersionAccessors extends VersionFactory  {

        public AndroidMinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android.min.sdk (21)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getSdk() { return getVersion("android.min.sdk"); }

    }

    public static class AndroidTargetVersionAccessors extends VersionFactory  {

        public AndroidTargetVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android.target.sdk (33)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getSdk() { return getVersion("android.target.sdk"); }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.activity (1.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getActivity() { return getVersion("androidx.activity"); }

    }

    public static class BinaryVersionAccessors extends VersionFactory  {

        private final BinaryCompatibilityVersionAccessors vaccForBinaryCompatibilityVersionAccessors = new BinaryCompatibilityVersionAccessors(providers, config);
        public BinaryVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.binary.compatibility
         */
        public BinaryCompatibilityVersionAccessors getCompatibility() { return vaccForBinaryCompatibilityVersionAccessors; }

    }

    public static class BinaryCompatibilityVersionAccessors extends VersionFactory  {

        public BinaryCompatibilityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: binary.compatibility.validator (0.11.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getValidator() { return getVersion("binary.compatibility.validator"); }

    }

    public static class DependencyVersionAccessors extends VersionFactory  {

        public DependencyVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: dependency.guard (0.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getGuard() { return getVersion("dependency.guard"); }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: junit.jupiter (5.8.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getJupiter() { return getVersion("junit.jupiter"); }

    }

    public static class KotlinVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public KotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: kotlin (1.6.21)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: kotlin.coroutines (1.6.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<String> getCoroutines() { return getVersion("kotlin.coroutines"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final BinaryPluginAccessors baccForBinaryPluginAccessors = new BinaryPluginAccessors(providers, config);
        private final BlindPluginAccessors baccForBlindPluginAccessors = new BlindPluginAccessors(providers, config);
        private final DependencyPluginAccessors baccForDependencyPluginAccessors = new DependencyPluginAccessors(providers, config);
        private final GradlePluginAccessors baccForGradlePluginAccessors = new GradlePluginAccessors(providers, config);
        private final KotlinPluginAccessors baccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);
        private final MavenPluginAccessors baccForMavenPluginAccessors = new MavenPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.binary
         */
        public BinaryPluginAccessors getBinary() { return baccForBinaryPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.blind
         */
        public BlindPluginAccessors getBlind() { return baccForBlindPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.dependency
         */
        public DependencyPluginAccessors getDependency() { return baccForDependencyPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.gradle
         */
        public GradlePluginAccessors getGradle() { return baccForGradlePluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() { return baccForKotlinPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.maven
         */
        public MavenPluginAccessors getMaven() { return baccForMavenPluginAccessors; }

    }

    public static class BinaryPluginAccessors extends PluginFactory {
        private final BinaryCompatibilityPluginAccessors baccForBinaryCompatibilityPluginAccessors = new BinaryCompatibilityPluginAccessors(providers, config);

        public BinaryPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.binary.compatibility
         */
        public BinaryCompatibilityPluginAccessors getCompatibility() { return baccForBinaryCompatibilityPluginAccessors; }

    }

    public static class BinaryCompatibilityPluginAccessors extends PluginFactory {

        public BinaryCompatibilityPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for binary.compatibility.validator to the plugin id 'org.jetbrains.kotlinx.binary-compatibility-validator'
             * This plugin was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<PluginDependency> getValidator() { return createPlugin("binary.compatibility.validator"); }

    }

    public static class BlindPluginAccessors extends PluginFactory {
        private final BlindPiratePluginAccessors baccForBlindPiratePluginAccessors = new BlindPiratePluginAccessors(providers, config);

        public BlindPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.blind.pirate
         */
        public BlindPiratePluginAccessors getPirate() { return baccForBlindPiratePluginAccessors; }

    }

    public static class BlindPiratePluginAccessors extends PluginFactory {

        public BlindPiratePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for blind.pirate.osgi to the plugin id 'com.github.blindpirate.osgi'
             * This plugin was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<PluginDependency> getOsgi() { return createPlugin("blind.pirate.osgi"); }

    }

    public static class DependencyPluginAccessors extends PluginFactory {

        public DependencyPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for dependency.guard to the plugin id 'com.dropbox.dependency-guard'
             * This plugin was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<PluginDependency> getGuard() { return createPlugin("dependency.guard"); }

    }

    public static class GradlePluginAccessors extends PluginFactory {
        private final GradleVersionPluginAccessors baccForGradleVersionPluginAccessors = new GradleVersionPluginAccessors(providers, config);

        public GradlePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.gradle.version
         */
        public GradleVersionPluginAccessors getVersion() { return baccForGradleVersionPluginAccessors; }

    }

    public static class GradleVersionPluginAccessors extends PluginFactory {

        public GradleVersionPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for gradle.version.plugin to the plugin id 'com.github.ben-manes.versions'
             * This plugin was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<PluginDependency> getPlugin() { return createPlugin("gradle.version.plugin"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.jvm to the plugin id 'org.jetbrains.kotlin.jvm'
             * This plugin was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<PluginDependency> getJvm() { return createPlugin("kotlin.jvm"); }

    }

    public static class MavenPluginAccessors extends PluginFactory {
        private final MavenPublishPluginAccessors baccForMavenPublishPluginAccessors = new MavenPublishPluginAccessors(providers, config);

        public MavenPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.maven.publish
         */
        public MavenPublishPluginAccessors getPublish() { return baccForMavenPublishPluginAccessors; }

    }

    public static class MavenPublishPluginAccessors extends PluginFactory {

        public MavenPublishPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for maven.publish.plugin to the plugin id 'com.vanniktech.maven.publish'
             * This plugin was declared in catalog dropboxJavaSdkLibs.versions.toml
             */
            public Provider<PluginDependency> getPlugin() { return createPlugin("maven.publish.plugin"); }

    }

}
