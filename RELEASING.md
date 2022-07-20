Releasing
========

 1. Update the top level [gradle.properties](gradle.properties) to a non-SNAPSHOT version.
 2. Update [DbxSdkVersion.java](DbxSdkVersion.java) to a non-SNAPSHOT version.
 3. Update the [ChangeLog.md](ChangeLog.md) for the impending release.
 4. Update the [ReadMe.md](ReadMe.md) with the new version.
 5. `git commit -am "Prepare for release X.Y.Z"` (where X.Y.Z is the new version)
 6. `git tag -a vX.Y.Z -m "Version X.Y.Z"` (where X.Y.Z is the new version)
    * Run `git tag` to verify it
 7. `git push --follow-tags`
    * This should be pushed to your fork
 8. Create a PR with this commit and merge it.
 9. Update the top level [gradle.properties](gradle.properties) to the next `-SNAPSHOT` version.
 10. Update [DbxSdkVersion.java](DbxSdkVersion.java) to the next `-SNAPSHOT` version.
 11. `git commit -am "Prepare next development version"`
 12. Create a PR with this commit and merge it. 
 13. This part below should be automated in CI, but if it fails, you will need to perform these steps manually
       * Login to Sonatype to promote the artifacts https://central.sonatype.org/pages/releasing-the-deployment.html
           * Click on Staging Repositories under Build Promotion
           * Select all the Repositories that contain the content you want to release
           * Click on Close and refresh until the Release button is active
           * Click Release and submit
 14. Create a GitHub release with the title and tag vX.Y.Z. Attach the sdk, -javadoc, and -sources .jar files from your `build/libs` directory.
 15. Update gh-pages. Add or replace the files within `https://github.com/dropbox/dropbox-sdk-java/tree/gh-pages` with the files inside `dropbox-sdk-java/build/docs/javadoc`.  Also update the root `index.html` to link to the new version documentation.  This page will be shown here: https://dropbox.github.io/dropbox-sdk-java/
 16. Push these changes to GitHub.