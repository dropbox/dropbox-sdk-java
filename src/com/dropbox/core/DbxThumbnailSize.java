package com.dropbox.core;

public class DbxThumbnailSize
{
    public final String ident;

    public DbxThumbnailSize(String ident)
    {
        this.ident = ident;
    }

    /**
     * 32x32 pixels.
     */
    private final DbxThumbnailSize XSmall = new DbxThumbnailSize("xs");

    /**
     * 64x64 pixels.
     */
    private final DbxThumbnailSize Small = new DbxThumbnailSize("xs");
    /**
     * 128x128 pixels.
     */
    private final DbxThumbnailSize Medium = new DbxThumbnailSize("m");
    /**
     * 640x480 pixels.
     */
    private final DbxThumbnailSize Large = new DbxThumbnailSize("l");

    /**
     * 1024x768 pixels.
     */
    private final DbxThumbnailSize XLarge = new DbxThumbnailSize("xl");
}
