package com.dropbox.core.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;


public abstract class Collector<E,L>
{
    public abstract void add(@Nullable E element);
    public abstract @Nonnull L finish();

    public static final class ArrayListCollector<E> extends Collector<E,ArrayList<E>>
    {
        private @Nullable ArrayList<E> list = new ArrayList<E>();

        public void add(@Nullable E element)
        {
            if (list == null) throw new IllegalStateException("already called finish()");
            this.list.add(element);
        }

        public @Nonnull ArrayList<E> finish()
        {
            ArrayList<E> list = this.list;
            if (list == null) throw new IllegalStateException("already called finish()");
            this.list = null;
            return list;
        }
    }

    public static final class NullSkipper<E,L> extends Collector<E,L>
    {
        private final @Nonnull Collector<E,L> underlying;

        public NullSkipper(@Nonnull Collector<E,L> underlying)
        {
            this.underlying = underlying;
        }

        public static <E,L> @Nonnull Collector<E,L> mk(@Nonnull Collector<E,L> underlying)
        {
            return new NullSkipper<E,L>(underlying);
        }

        public void add(@Nullable E element)
        {
            if (element != null) {
                underlying.add(element);
            }
        }

        public @Nonnull L finish()
        {
            return underlying.finish();
        }
    }
}
