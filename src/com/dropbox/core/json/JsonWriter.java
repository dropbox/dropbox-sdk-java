package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class JsonWriter<T>
{
    public abstract void write(T value, JsonGenerator g)
        throws IOException;

    public final void writeToStream(T value, OutputStream out, boolean indent)
        throws IOException
    {
        JsonGenerator g = JsonReader.jsonFactory.createGenerator(out);
        if (indent) {
            g = g.useDefaultPrettyPrinter();
        }
        try {
            write(value, g);
        }
        finally {
            g.flush();
        }
    }

    public final void writeToStream(T value, OutputStream out)
            throws IOException
    {
        writeToStream(value, out, true);
    }

    public final void writeToFile(T value, File file, boolean indent)
        throws IOException
    {
        FileOutputStream fout = new FileOutputStream(file);
        try {
            writeToStream(value, fout, indent);
        }
        finally {
            fout.close();
        }
    }

    public final void writeToFile(T value, File file)
            throws IOException
    {
        writeToFile(value, file, true);
    }

    public final void writeToFile(T value, String fileName, boolean indent)
            throws IOException
    {
        writeToFile(value, new File(fileName), indent);
    }

    public final void writeToFile(T value, String fileName)
        throws IOException
    {
        writeToFile(value, fileName, true);
    }

    // TODO: Convert JsonGenerationExceptions to RuntimeExceptions.
}
