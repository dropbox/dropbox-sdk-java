package com.dropbox.core.util;

public abstract class Maybe<T>
{
    private Maybe() {}

    public abstract boolean isNothing();
    public abstract boolean isJust();
    public abstract T getJust();
    public abstract T get(T def);
    public abstract String toString();
    public abstract int hashCode();
    public abstract boolean equals(Maybe<T> other);

    public static <T> Maybe<T> Just(T value)
    {
        return new Just<T>(value);
    }

    private static final class Just<T> extends Maybe<T>
    {
        private final T value;
        private Just(T value)
        {
            this.value = value;
        }

        public boolean isNothing() { return false; }
        public boolean isJust() { return true; }
        public T getJust() { return value; }
        public T get(T def) { return value; }
        public String toString() { return "Just(" + value + ")"; }
        public int hashCode() { return 1 + LangUtil.nullableHashCode(value); }

        @Override
        public boolean equals(Maybe<T> other)
        {
            if (other instanceof Just) {
                Just<T> j = (Just<T>) other;
                return LangUtil.nullableEquals(value, j.value);
            }
            else if (other instanceof Nothing) {
                return false;
            }
            else {
                throw LangUtil.badType(other);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Maybe<T> Nothing()
    {
        return (Maybe<T>) Nothing;
    }

    private static final Maybe<Object> Nothing = new Nothing<Object>();
    private static final class Nothing<T> extends Maybe<T>
    {
        private Nothing() {}

        public boolean isNothing() { return true; }
        public boolean isJust() { return false; }
        public T getJust() { throw new IllegalStateException("can't call getJust() on a Nothing"); }
        public T get(T def) { return def; }
        public String toString() { return "Nothing"; }
        public int hashCode() { return 0; }

        @Override
        public boolean equals(Maybe<T> other)
        {
            return other == this;  // There's only a single Nothing instance.
        }
    }
}
