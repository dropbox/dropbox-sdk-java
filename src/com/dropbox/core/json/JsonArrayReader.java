package com.dropbox.core.json;

import com.dropbox.core.util.Collector;
import com.fasterxml.jackson.core.*;

import java.io.IOException;
import java.util.ArrayList;

public class JsonArrayReader<T,L> extends JsonReader<L>
{
    public final JsonReader<? extends T> elementReader;
    public final Collector<T,? extends L> collector;

    public JsonArrayReader(JsonReader<? extends T> elementReader, Collector<T, ? extends L> collector)
    {
        this.elementReader = elementReader;
        this.collector = collector;
    }

    public static <T> JsonArrayReader<T,ArrayList<T>> mk(JsonReader<? extends T> elementReader)
    {
        return new JsonArrayReader<T,ArrayList<T>>(elementReader, new Collector.ArrayListCollector<T>());
    }

    public static <T,L> JsonArrayReader<T,L> mk(JsonReader<? extends T> elementReader, Collector<T,? extends L> collector)
    {
        return new JsonArrayReader<T,L>(elementReader, collector);
    }

    public L read(JsonParser parser)
        throws JsonReadException, IOException
    {
        return read(elementReader, collector, parser);
    }

    public static <T,L> L read(JsonReader<? extends T> elementReader, Collector<T, ? extends L> collector, JsonParser parser)
        throws JsonReadException, IOException
    {
        expectArrayStart(parser);

        int index = 0;
        while (!isArrayEnd(parser)) {
            try {
                T value = elementReader.read(parser);
                collector.add(value);
                index++;
            }
            catch (JsonReadException ex) {
                throw ex.addArrayContext(index);
            }
        }

        parser.nextToken();
        return collector.finish();
    }
}
