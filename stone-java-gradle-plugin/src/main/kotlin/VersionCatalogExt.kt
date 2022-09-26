import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class VersionCatalogExt(private val project: Project) {

    private val libsVersionCatalog: VersionCatalog = project
        .extensions
        .getByType<VersionCatalogsExtension>()
        .named("libs")

    fun version(key: String): String = with(libsVersionCatalog.findVersion(key)) {
        require(isPresent) {
            "Cannot find $key in libsVersionCatalog: $libsVersionCatalog"
        }
        get().requiredVersion
    }

    fun findLibrary(alias: String) = with(libsVersionCatalog.findLibrary(alias)) {
        require(isPresent) {
            "Cannot find $alias in libsVersionCatalog: $libsVersionCatalog"
        }
        get()
    }

    fun versionInt(key: String) = version(key).toInt()

    val ANDROID_COMPILE_SDK_VERSION by lazy {
        versionInt("android.compilesdk")
    }
    val ANDROID_MIN_SDK_VERSION by lazy {
        versionInt("android.minsdk")
    }
    val ANDROID_TARGET_SDK_VERSION by lazy {
        versionInt("android.targetsdk")
    }
    val ANDROID_TOOLS_CORE_DESUGARING by lazy {
        findLibrary("com.android.tools.desugar.jdk.libs")
    }
}
