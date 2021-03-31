Releasing
========

 1. Change the version in top level `build.gradle` to a the release version.
 2. Update the `CHANGELOG.md` for the impending release.
 3. Update the `README.md` with the new version.
 4. Update `DbxSdkVersion.java` to point to new release version.
 5. Get our GPG signing password and our Sonatype password (ask internally).
 6. Build and upload the archives to the Sonatype maven staging repository: 
 ```
 (dropbox-sdk-java) $ ./gradlew -Psigning.password=<GPG-passphrase> -PossrhUsername=dropbox-api-team -PossrhPassword=<sonatype-password> clean uploadArchives
 ```
 7. Verify and release artifacts in Sonatype.
 8. Revert version changes to `build.gradle` but commit our `ReadMe.md`, `ChangeLog.txt` and `DbxSdkVersion.java` changes:
 ```

(dropbox-sdk-java) $ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        modified:   ChangeLog.txt
        modified:   ReadMe.md

(dropbox-sdk-java) $ git commit -m 'ChangeLog/ReadMe: Update for X.Y.Z release.'
```
 9. Push changes to public SDK.
```
(dropbox-sdk-java) $ git tag -a vX.Y.Z
# Copy over the release details from the ChangeLog.txt file into this tag's message.
(dropbox-sdk-java) $ git push
(dropbox-sdk-java) $ git push --tags
```

 10. Create a GitHub release with the title vX.Y.Z. Attach .zip and .tar archives and signature files from `build/distributions` directory.
 11. Update gh-pages. Add or replace the files within `dropbox-sdk-java-gh-pages/api-docs/vX.Y.Z` with the files inside `dropbox-sdk-java-v/build/docs/javadoc`
 12. Push these changes to GitHub.