Releasing
========

 1. Change the version in the top level `build.gradle` to a non-SNAPSHOT version.
 2. Update `DbxSdkVersion.java` to a non-SNAPSHOT version.
 3. Update the `ChangeLog.txt` for the impending release.
 4. Update the `ReadMe.md` with the new version.
 5. `git commit -am "Prepare for release X.Y.Z"` (where X.Y.Z is the new version)
 6. `git tag -a X.Y.Z -m "Version X.Y.Z"` (where X.Y.Z is the new version)
    * Run `git tag` to verify it
 7. `git push && git push --tags`
    * This should be pushed to your fork
 8. Create a PR with this commit and merge it.
 9. Update the top level `build.gradle` to the next `-SNAPSHOT` version.
 10. `git commit -am "Prepare next development version"`
 11. Create a PR with this commit and merge it. 
 12. Login to Sonatype to promote the artifacts https://central.sonatype.org/pages/releasing-the-deployment.html
   * Click on Staging Repositories under Build Promotion
   * Select all the Repositories that contain the content you want to release
   * Click on Close and refresh until the Release button is active
   * Click Release and submit
 13. Create a GitHub release with the title vX.Y.Z. Attach .zip and .tar archives and signature files from `build/distributions` directory.
 14. Update gh-pages. Add or replace the files within `https://github.com/dropbox/dropbox-sdk-java/tree/gh-pages` with the files inside `dropbox-sdk-java/build/docs/javadoc`
 15. Push these changes to GitHub.