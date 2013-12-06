package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;

public final class JsonReadException extends java.lang.Exception
{
	public static final long serialVersionUID = 0;
	
    public final String error;
    public final JsonLocation location;
    private PathPart path;

    public JsonReadException(String error, JsonLocation location)
    {
        this.error = error;
        this.location = location;
        this.path = null;
    }

    public JsonReadException addFieldContext(String fieldName)
    {
        this.path = new PathPart('"' + fieldName + '"', this.path);
        return this;
    }

    public JsonReadException addArrayContext(int index)
    {
        this.path = new PathPart(Integer.toString(index), this.path);
        return this;
    }

    public String getMessage()
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

    public static void toStringLocation(StringBuilder buf, JsonLocation location)
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
        public final String description;
        public final PathPart next;

        public PathPart(String description, PathPart next)
        {
            this.description = description;
            this.next = next;
        }
    }

    public static JsonReadException fromJackson(JsonProcessingException ex)
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
