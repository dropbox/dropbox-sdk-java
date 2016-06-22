package com.dropbox.stone.gradle

import org.gradle.api.InvalidUserDataException;
import org.gradle.api.Project
import org.gradle.api.file.DirectoryTree
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.tasks.util.PatternFilterable
import org.gradle.api.tasks.util.PatternSet

/**
 * SourceSet extension defining stone sources.
 */
public class StoneSourceDirectorySet {
    private final Project project
    private final List<Object> srcDirs
    private final PatternSet patterns

    public StoneSourceDirectorySet(Project project, String sourceSetName) {
        this.project = project
        this.srcDirs = []
        this.patterns = new PatternSet().include('**/*.stone')

        // add default source directory
        srcDir("src/${sourceSetName}/stone")
    }

    public PatternFilterable getFilter() {
        return patterns
    }

    public String getName() {
        return 'stone'
    }

    public Set<File> getSrcDirs() {
        Set<File> files = new HashSet<>(this.srcDirs.size())
        getSrcDirTrees().each { tree ->
            files.add(tree.getDir())
        }
        return files
    }

    public Set<DirectoryTree> getSrcDirTrees() {
        Set<DirectoryTree> trees = new HashSet<>(this.srcDirs.size())
        for (Object srcDir in srcDirs) {
            File file = project.file(srcDir)
            if (file.exists() && !file.isDirectory()) {
                throw new InvalidUserDataException("Source directory not a directory: ${srcDir}")
            }
            trees.add(new SimpleDirectoryTree(file, patterns))
        }
        return trees
    }

    public StoneSourceDirectorySet setSrcDirs(Iterable<String> dirs) {
        this.folders.clear()
        dirs.each { dir ->
            this.folders.add(dir)
        }
        return this
    }

    public StoneSourceDirectorySet source(SourceDirectorySet source) {
        srcDirs(source.getSrcDirs())
        return this
    }

    public StoneSourceDirectorySet srcDir(Object dir) {
        this.srcDirs.add(dir)
        return this
    }

    public StoneSourceDirectorySet srcDirs(Object ... dirs) {
        Collections.addAll(srcDirs, dirs)
        return this
    }

    private static class SimpleDirectoryTree implements DirectoryTree {
        private File dir;
        private PatternSet patterns;

        public SimpleDirectoryTree(File dir, PatternSet patterns) {
            this.dir = dir;
            this.patterns = patterns;
        }

        @Override
        public File getDir() {
            return dir
        }

        @Override
        public PatternSet getPatterns() {
            return patterns
        }
    }
}
