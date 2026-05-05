package com.dropbox.core.json;

import com.dropbox.core.util.Collector;
import com.fasterxml.jackson.core.*;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;

public class JsonArrayReader<T,L> extends JsonReader<L>
{
    public final @Nonnull JsonReader<? extends T> elementReader;
    public final @Nonnull Collector<T,? extends L> collector;

    public JsonArrayReader(@Nonnull JsonReader<? extends T> elementReader, @Nonnull Collector<T, ? extends L> collector)
    {
        this.elementReader = elementReader;
        this.collector = collector;
    }

    public static <T> @Nonnull JsonArrayReader<T,List<T>> mk(@Nonnull JsonReader<? extends T> elementReader)
    {
        return new JsonArrayReader<T,List<T>>(elementReader, new Collector.ArrayListCollector<T>());
    }

    public static <T,L> @Nonnull JsonArrayReader<T,L> mk(@Nonnull JsonReader<? extends T> elementReader, @Nonnull Collector<T,? extends L> collector)
    {
        return new JsonArrayReader<T,L>(elementReader, collector);
    }

    public @Nonnull L read(@Nonnull JsonParser parser)
        throws JsonReadException, IOException
    {
        return read(elementReader, collector, parser);
    }

    public static <T,L> @Nonnull L read(@Nonnull JsonReader<? extends T> elementReader, @Nonnull Collector<T, ? extends L> collector, @Nonnull JsonParser parser)
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
