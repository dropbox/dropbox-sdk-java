package com.dropbox.stone.gradle

import org.gradle.api.Project
import org.gradle.util.ConfigureUtil

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
public class StoneConvention {
    private final Project project
    private final StoneConfig config

    public StoneConvention(Project project) {
        this.project = project
        this.config = new StoneConfig(project)
    }

    public void stone(Closure closure) {
        ConfigureUtil.configure(closure, config)
    }

    public StoneConfig getStone() {
        return config
    }
}
