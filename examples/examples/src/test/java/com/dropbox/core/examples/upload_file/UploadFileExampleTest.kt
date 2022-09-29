package com.dropbox.core.examples.upload_file

import com.dropbox.core.examples.CredentialsUtil
import com.dropbox.core.examples.FileCreationUtils.createTempFileOfSize
import com.dropbox.core.examples.FileCreationUtils.kbToBytes
import com.dropbox.core.examples.FileCreationUtils.mbToBytes
import com.dropbox.core.examples.TestUtil
import org.junit.Assume.assumeTrue
import org.junit.Before
import org.junit.Test
import java.io.File
import java.time.Instant

class UploadFileExampleTest {

    private val dateStr = Instant.now().toString()

    @Before
    fun setup() {
        assumeTrue(TestUtil.isRunningInCI())
    }

    @Test
    fun upload1KBFile() {
        File.createTempFile(dateStr, ".dat").also { tempFile ->
            try {
                createTempFileOfSize(tempFile, kbToBytes(1).toInt())
                val localFile = tempFile.absolutePath
                val dropboxFile = "/test/dropbox-sdk-java/${dateStr}/examples/upload-file/small-1KiB.dat"
                UploadFileExample.runExample(CredentialsUtil.getAuthInfo(), localFile, dropboxFile)
            } finally {
                tempFile.delete()
            }
        }

    }

    @Test
    fun upload32MBFile() {
        File.createTempFile(dateStr, ".dat").also { tempFile ->
            try {
                createTempFileOfSize(tempFile, mbToBytes(32).toInt())
                val localFile = tempFile.absolutePath
                val dropboxFile = "/test/dropbox-sdk-java/${dateStr}/examples/upload-file/large-32MiB.dat"
                UploadFileExample.runExample(CredentialsUtil.getAuthInfo(), localFile, dropboxFile)
            } finally {
                tempFile.delete()
            }
        }
    }
}