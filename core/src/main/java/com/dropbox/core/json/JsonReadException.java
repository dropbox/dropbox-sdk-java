package com.dropbox.core.json;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;


public final class JsonReadException extends java.lang.Exception
{
    public static final long serialVersionUID = 0;

    public final @Nonnull String error;
    public final @Nonnull JsonLocation location;
    private @Nullable PathPart path;

    public JsonReadException(@Nonnull String error, @Nonnull JsonLocation location)
    {
        this.error = error;
        this.location = location;
        this.path = null;
    }

    public JsonReadException(@Nonnull String error, @Nonnull JsonLocation location, @Nonnull Throwable cause)
    {
        super(cause);
        this.error = error;
        this.location = location;
        this.path = null;
    }

    public @Nonnull JsonReadException addFieldContext(@Nonnull String fieldName)
    {
        this.path = new PathPart('"' + fieldName + '"', this.path);
        return this;
    }

    public @Nonnull JsonReadException addArrayContext(int index)
    {
        this.path = new PathPart(Integer.toString(index), this.path);
        return this;
    }

    public @Nonnull String getMessage()
    {
        StringBuilder buf = new StringBuilder();

        // Location
        toStringLocation(buf, location);
        buf.append(": ");

        // "Logical Path"
        if (path != null) {
            PathPart p = path;
            buf.append(p.description);
            while (p.next != null) {
                p = p.next;
                buf.append(".");
                buf.append(p.description);
            }
            buf.append(": ");
        }

        // Actual error message.
        buf.append(error);

        return buf.toString();
    }

    public static void toStringLocation(@Nonnull StringBuilder buf, @Nonnull JsonLocation location)
    {
        Object sourceRef = location.getSourceRef();
        if (sourceRef instanceof File) {
            File f = (File) sourceRef;
            buf.append(f.getPath());
            buf.append(": ");
        }

        buf.append(location.getLineNr());
        buf.append(".");
        buf.append(location.getColumnNr());
    }

    public static final class PathPart
    {
        public final @Nonnull String description;
        public final @Nullable PathPart next;

        public PathPart(@Nonnull String description, @Nullable PathPart next)
        {
            this.description = description;
            this.next = next;
        }
    }

    public static @Nonnull JsonReadException fromJackson(@Nonnull JsonProcessingException ex)
    {
        String message = ex.getMessage();

        // Strip off location.
        int locPos = message.lastIndexOf(" at [Source");
        if (locPos >= 0) {
            message = message.substring(0, locPos);
        }

        return new JsonReadException(message, ex.getLocation());
    }
}
