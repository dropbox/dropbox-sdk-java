Please follow the steps in each one of the following sections to complete a release.

## Merge the Release to Trigger Publishing to Maven Central
 1. Update the top level [gradle.properties](gradle.properties) to a non-SNAPSHOT version.
 2. Update [DbxSdkVersion.java](DbxSdkVersion.java) to a non-SNAPSHOT version.
 3. Update the [ChangeLog.md](ChangeLog.md) for the impending release.
 4. Update the [README.md](README.md) with the new version.
 5. `git commit -am "Prepare for release X.Y.Z"` (where X.Y.Z is the new version)
 6. Create a PR titled "Release vX.Y.Z"
 7. Merge the PR after checks pass.  This will trigger our GitHub Action to publish to Maven Central.
 8. This part below should be automated in CI, but if publishing fails, you will need to perform these steps manually
     * Login to Sonatype to promote the artifacts https://central.sonatype.org/pages/releasing-the-deployment.html
         * Click on Staging Repositories under Build Promotion
         * Select all the Repositories that contain the content you want to release
         * Click on Close and refresh until the Release button is active
         * Click Release and submit

## Tag the Release
 1. Pull the latest code `git fetch origin` that was just merged with the stable version.
 2. Check out the commit that landed `git checkout COMMIT_HASH`
 3. Tag the commit with `git tag -a vX.Y.Z -m "Version X.Y.Z"` (where X.Y.Z is the new version)
 4. Push the tag `git push origin vX.Y.Z`

## Preparing For Next Snapshot
 1. Checkout the latest code from `main` into a new branch.
 2. Update the top level [gradle.properties](gradle.properties) to the next `-SNAPSHOT` version.
 3. Update [DbxSdkVersion.java](DbxSdkVersion.java) to the next `-SNAPSHOT` version.
 4. `git commit -am "Prepare next development version"`
 5. Create a PR with this commit and merge it.

## Creating the Release on GitHub and Upload Artifacts
 1. [Create a GitHub release](https://github.com/dropbox/dropbox-sdk-java/releases) with the title from the `vX.Y.Z` tag. Attach the sdk, -javadoc, and -sources .jar files that were [published to Maven Central](https://repo1.maven.org/maven2/com/dropbox/core/dropbox-core-sdk/).
 2. Checkout the `gh-pages` branch. Add or replace the files within `https://github.com/dropbox/dropbox-sdk-java/tree/gh-pages` with the files inside the javadoc jar (You can unzip the javadoc jar after downloading from Maven Central).  Also update the root `index.html` to link to the new version documentation.  This page will be shown here: https://dropbox.github.io/dropbox-sdk-java/
 3. Push these changes to the `gh-pages` branch on GitHub.
