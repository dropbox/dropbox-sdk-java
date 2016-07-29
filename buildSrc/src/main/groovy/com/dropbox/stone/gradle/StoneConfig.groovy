package com.dropbox.stone.gradle

import org.gradle.api.Project

/**
 * Add stone {} block to project.
 *
 * <p> Use this extension to configure the locations of stone and
 * generator sources. Additionally set global defaults for generator
 * configuration.
 *
 * <pre>
 *     stone {
 *         stoneDir "stone"
 *         generatorDir "generator"
 *     }
 * </pre>
 */
class StoneConfig {
    private final Project project

    /**
     * The base directory of generated files.
     *
     * Default: "${project.buildDir}/generated/stone"
     */
    private String generatedFilesBaseDir

    /**
     * The base directory of the stone repository.
     *
     * Default "stone"
     */
    private String stoneDir

    /**
     * The base directory of the stone Java generator.
     *
     * Default: "generator"
     */
    private String generatorDir

    /**
     * Whether to keep unused data types or to filter them out from generated sources.
     *
     * A data type that is not referenced by any route directly or indirectly (through inheritance
     * or fields), is unused. By default, unused data types are filtered from generated sources. Set
     * This field to {@code true} to generate unused data types anyway (useful for testing).
     *
     * Default: false
     */
    public boolean keepUnused

    public StoneConfig(Project project) {
        this.project = project
        this.generatedFilesBaseDir = "${project.buildDir}/generated/stone"
        this.stoneDir = "stone"
        this.generatorDir = "generator"
        this.keepUnused = false
    }

    public String getGeneratedFilesBaseDir() {
        return generatedFilesBaseDir
    }

    public StoneConfig generatedFilesBaseDir(String generatedFilesBaseDir) {
        this.generatedFilesBaseDir = generatedFilesBaseDir
        return this
    }

    public String getStoneDir() {
        return stoneDir
    }

    public StoneConfig stoneDir(String stoneDir) {
        this.stoneDir = stoneDir
        return this;
    }

    public String getGeneratorDir() {
        return generatorDir
    }

    public StoneConfig generatorDir(String generatorDir) {
        this.generatorDir = generatorDir
        return this
    }
}
