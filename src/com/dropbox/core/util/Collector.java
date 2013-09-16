package com.dropbox.core.util;

import java.util.ArrayList;

public abstract class Collector<E,L>
{
    public abstract void add(E element);
    public abstract L finish();

    public static final class ArrayListCollector<E> extends Collector<E,ArrayList<E>>
    {
        private ArrayList<E> list = new ArrayList<E>();

        public void add(E element)
        {
            this.list.add(element);
        }

        public ArrayList<E> finish()
        {
            ArrayList<E> list = this.list;
            this.list = null;
            return list;
        }
    }

    public static final class NullSkipper<E,L> extends Collector<E,L>
    {
        private final Collector<E,L> underlying;

        public NullSkipper(Collector<E, L> underlying)
        {
            this.underlying = underlying;
        }

        public static <E,L> Collector<E,L> mk(Collector<E,L> underlying)
        {
            return new NullSkipper<E,L>(underlying);
        }

        public void add(E element)
        {
            if (element != null) {
                underlying.add(element);
            }
        }

        public L finish()
        {
            return underlying.finish();
        }
    }
}
