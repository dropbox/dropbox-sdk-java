package com.dropbox.core.v1;

import javax.annotation.Nonnull;

/**
 * Thumbnail size presets, to be used with {@link DbxClientV1#getThumbnail}.
 */
public class DbxThumbnailSize
{
    public final @Nonnull String ident;
    public final int width;
    public final int height;

    public DbxThumbnailSize(@Nonnull String ident, int width, int height)
    {
        this.ident = ident;
        this.width = width;
        this.height = height;
    }

    public @Nonnull String toString()
    {
        return "(" + ident + " " + width + "x" + height + ")";
    }

    /**
     * 32x32 pixels.
     */
    public static final @Nonnull DbxThumbnailSize w32h32 = new DbxThumbnailSize("xs", 32, 32);

    /**
     * 64x64 pixels.
     */
    public static final @Nonnull DbxThumbnailSize w64h64 = new DbxThumbnailSize("s", 64, 64);

    /**
     * 128x128 pixels.
     */
    public static final @Nonnull DbxThumbnailSize w128h128 = new DbxThumbnailSize("m", 128, 128);

    /**
     * 640x480 pixels.
     */
    public static final @Nonnull DbxThumbnailSize w640h480 = new DbxThumbnailSize("l", 640, 480);

    /**
     * 1024x768 pixels.
     */
    public static final @Nonnull DbxThumbnailSize w1024h768 = new DbxThumbnailSize("xl", 1024, 768);
}
