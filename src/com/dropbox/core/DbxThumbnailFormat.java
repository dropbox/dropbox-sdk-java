package com.dropbox.core;

/**
 * Thumbnail image format presets, to be used with {@link DbxClient#getThumbnail}.
 */
public class DbxThumbnailFormat
{
    public final String ident;

    public DbxThumbnailFormat(String ident)
    {
        this.ident = ident;
    }

    /**
     * JPEG format, preferred over PNG for photographic images.
     */
    public static final DbxThumbnailFormat JPEG = new DbxThumbnailFormat("jpeg");

    /**
     * PNG format, preferred over JPEG for non-photographic images, such as
     * screenshots and digital art.
     */
    public static final DbxThumbnailFormat PNG = new DbxThumbnailFormat("png");

    /**
     * Try and guess the right {@code DbxThumbnailFormat} to use based on the image's file
     * name.  Sometimes this function won't be able to guess and will just return whatever you
     * pass in for {@code fallback}.
     *
     * <pre>
     * DbxThumbnailFormat.bestForFileName("test.png");          // returns DbxThumbnailFormat.PNG
     * DbxThumbnailFormat.bestForFileName("/stuff/funny.GIF");  // returns DbxThumbnailFormat.PNG
     * DbxThumbnailFormat.bestForFileName("/family.jpg");       // returns DbxThumbnailFormat.JPEG
     * </pre>
     */
    public static DbxThumbnailFormat bestForFileName(String fileName, DbxThumbnailFormat fallback)
    {
        fileName = fileName.toLowerCase();
        if (fileName.endsWith(".png") || fileName.endsWith(".gif")) {
            return DbxThumbnailFormat.PNG;
        }
        else if (fileName.endsWith(".jpeg") || fileName.endsWith(".jpg") || fileName.endsWith(".jpe")) {
            return DbxThumbnailFormat.JPEG;
        }
        return fallback;
    }
}
