package com.dropbox.stone.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.file.FileTree
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.TaskAction

public class StoneTask extends DefaultTask {
    private SourceSet sourceSet
    private Object stoneDir
    private Object generatorDir
    private Object outputBaseDir

    /**
     * Base package name to generate classes into.
     *
     * Default: "stone"
     */
    private String packageName

    /**
     * Only the specified list of namespaces will have routes generated for them. Data types from
     * other namespaces may still be generated.
     *
     * Default: []
     */
    private Set<String> whitelistedNamespaces

    /**
     * The specified list of namespaces will not routes generated for them. Data types may still be
     * generated.
     *
     * Default: []
     */
    private Set<String> blacklistedNamespaces

    /**
     * Whether to keep unused data types or to filter them out from generated sources.
     *
     * A data type that is not referenced by any route directly or indirectly (through inheritance
     * or fields), is unused. By default, unused data types are filtered from generated sources. Set
     * This field to {@code true} to generate unused data types anyway (useful for testing).
     *
     * Default: false
     */
    private boolean keepUnused

    /**
     * A String expression for filtering routes based on route attributes.
     *
     * <p> This filter will be applied to all clients.
     *
     * <p> The expression must specify a route attribute on the left-hand side and a value on the
     * right-hand side. Use quotes for strings and bytes. The only supported operators are "=" and
     * "!=". You can also compbine multiple expressions with "and"/"or" and use parentheses to
     * enforce precedence.
     *
     * Example that filters routes to only include beta "user" auth routes and routes that are not
     * "production" mode:
     *
     * <pre>
     *     (auth="user" and beta=true) or mode!="production"
     * </pre>
     *
     * Default: "" (no filtering applied)
     */
    private String globalRouteFilter

    public StoneTask() {
        this.extensions.clients = project.container(ClientSpec)

        this.packageName = 'stone'
        this.whitelistedNamespaces = new HashSet<String>()
        this.blacklistedNamespaces = new HashSet<String>()
        this.keepUnused = false
        this.globalRouteFilter = ''
    }

    public void packageName(String packageName) {
        this.packageName = packageName
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName
    }

    @Input
    public String getPackageName() {
        return packageName
    }

    public void keepUnused(boolean keepUnused) {
        this.setKeepUnused(keepUnused)
    }

    public void setKeepUnused(boolean keepUnused) {
        this.keepUnused = keepUnused
    }

    @Input
    public boolean getKeepUnused() {
        return keepUnused
    }

    public void whitelistNamespaces(Iterable<String> namespaces) {
        for (String n : namespaces) {
            whitelistNamespace(n)
        }
    }

    public void whitelistNamespaces(String namespace, String ... namespaces) {
        whitelistNamespaces.add(namespace)
        whiteListNamespaces(namespaces)
    }

    public void whitelistNamespace(String namespace) {
        whitelistedNamespaces.add(namespace)
    }

    @Input
    public Set<String> getWhitelistedNamespaces() {
        return whitelistedNamespaces
    }

    public void blacklistNamespaces(Iterable<String> namespaces) {
        for (String n : namespaes) {
            blacklistNamespace(n)
        }
    }

    public void blacklistNamespaces(String namespace, String ... namespaces) {
        blacklistNamespace(namespace)
        blacklistNamespaces(namespaces)
    }

    public void blacklistNamespace(String namespace) {
        blacklistedNamespaces.add(namespace)
    }

    @Input
    public Set<String> getBlacklistedNamespaces() {
        return blacklistedNamespaces
    }

    public void routeFilter(String routeFilter) {
        this.setRouteFilter(routeFilter)
    }

    public void setRouteFilter(String routeFilter) {
        this.globalRouteFilter = routeFilter
    }

    @Input
    public String getRouteFilter() {
        return globalRouteFilter
    }

    @Nested
    public Collection<ClientSpec> getClientSpecs() {
        return this.extensions.clients
    }

    public File getOutputBaseDir() {
        return project.file(this.outputBaseDir)
    }

    public void setOutputBaseDir(Object outputBaseDir) {
        this.outputBaseDir = outputBaseDir
    }

    public SourceSet getSourceSet() {
        return sourceSet
    }

    public void setSourceSet(SourceSet sourceSet) {
        this.sourceSet = sourceSet
    }

    @InputDirectory
    public File getStoneDir() {
        return project.file(stoneDir)
    }

    public void setStoneDir(Object stoneDir) {
        this.stoneDir = stoneDir
    }

    @InputFiles
    public FileTree getGeneratorFiles() {
        return project.fileTree(dir: generatorDir, exclude: '**/*.pyc')
    }

    public void setGeneratorDir(Object generatorDir) {
        this.generatorDir = generatorDir
    }

    @InputFiles
    public Set<File> getSpecFiles() {
        Set<File> files = new HashSet<File>()
        getSourceSet().stone.srcDirTrees.each { srcDirTree ->
            FileTree tree = project.fileTree(srcDirTree.dir).matching(srcDirTree.patterns)
            for (File file : tree.getFiles()) {
                files.add(file)
            }
        }
        return files
    }

    @OutputDirectory
    public File getOutputDir() {
        return new File(getOutputBaseDir(), "src")
    }

    public File getLogFile() {
        return new File(getOutputBaseDir(), "log/stone.log")
    }

    public File getGeneratorFile() {
        return project.fileTree(dir: generatorDir, include: '**/*stoneg.py').getSingleFile()
    }

    @TaskAction
    public void generateStoneSources() {
        getOutputDir().mkdirs()
        getLogFile().getParentFile().mkdirs()

        Set<File> specFiles = getSpecFiles()
        if (specFiles.isEmpty()) {
            return
        }

        getLogFile().withOutputStream { log ->
            generateStoneSourcesForSpecs(getClientSpecs(), log)
        }
    }

    void generateStoneSourcesForSpecs(Iterable<ClientSpec> specs, OutputStream log) {
        project.exec {
            environment PYTHONPATH: getStoneDir().absolutePath
            standardOutput = log
            commandLine "python3", "-m", "stone.cli"
            args "--clean-build"

            for (String namespace : getWhitelistedNamespaces()) {
                args "--whitelist-namespace-routes", namespace
            }

            for (String namespace : getBlacklistedNamespaces()) {
                args "--blacklist-namespace-routes", namespace
            }

            def globalRouteFilter = getRouteFilter()
            if (!globalRouteFilter.isEmpty()) {
                args "--filter-by-route-attr", globalRouteFilter
            }

            // generator arguments
            args getGeneratorFile().absolutePath, getOutputDir().absolutePath
            args specFiles
            args "--"
            args "--package", getPackageName()
            if (getKeepUnused()) {
                args "--keep-unused"
            }

            for (ClientSpec spec : specs) {
                def name = spec.getName()
                def javadoc = (spec.getJavadoc() ?: "")
                def routesClassNameFormat = spec.getRoutesClassNameFormat()
                def routeFilter = spec.getRouteFilter() ?: ""

                args "--client-spec", "${name}:${javadoc}:${routesClassNameFormat}:${routeFilter}"
            }
        }
    }
}
