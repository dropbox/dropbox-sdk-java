package com.dropbox.core;

/**
 * Thumbnail size presets, to be used with {@link DbxClient#getThumbnail}.
 */
public class DbxThumbnailSize
{
    public final String ident;
    public final int width;
    public final int height;

    public DbxThumbnailSize(String ident, int width, int height)
    {
        this.ident = ident;
        this.width = width;
        this.height = height;
    }

    public String toString()
    {
        return "(" + ident + " " + width + "x" + height + ")";
    }

    /**
     * 32x32 pixels.
     */
    public static final DbxThumbnailSize w32h32 = new DbxThumbnailSize("xs", 32, 32);

    /**
     * 64x64 pixels.
     */
    public static final DbxThumbnailSize w64h64 = new DbxThumbnailSize("s", 64, 64);

    /**
     * 128x128 pixels.
     */
    public static final DbxThumbnailSize w128h128 = new DbxThumbnailSize("m", 128, 128);

    /**
     * 640x480 pixels.
     */
    public static final DbxThumbnailSize w640h480 = new DbxThumbnailSize("l", 640, 480);

    /**
     * 1024x768 pixels.
     */
    public static final DbxThumbnailSize w1024h768 = new DbxThumbnailSize("xl", 1024, 768);
}
