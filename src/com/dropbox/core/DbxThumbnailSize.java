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
    private final DbxThumbnailSize Square32 = new DbxThumbnailSize("xs");

    /**
     * 64x64 pixels.
     */
    private final DbxThumbnailSize Square64 = new DbxThumbnailSize("xs");
    /**
     * 128x128 pixels.
     */
    private final DbxThumbnailSize Square128 = new DbxThumbnailSize("m");
    /**
     * 640x480 pixels.
     */
    private final DbxThumbnailSize w640h480 = new DbxThumbnailSize("l");

    /**
     * 1024x768 pixels.
     */
    private final DbxThumbnailSize w1024h768 = new DbxThumbnailSize("xl");
}
