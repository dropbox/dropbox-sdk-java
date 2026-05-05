package com.dropbox.core.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Maybe<T>
{
    private Maybe() {}

    public abstract boolean isNothing();
    public abstract boolean isJust();
    public abstract @Nullable T getJust();
    public abstract @Nullable T get(@Nullable T def);
    public abstract @Nonnull String toString();
    public abstract int hashCode();
    public abstract boolean equals(@Nullable Maybe<T> other);

    public static <T> @Nonnull Maybe<T> Just(@Nullable T value)
    {
        return new Just<T>(value);
    }

    private static final class Just<T> extends Maybe<T>
    {
        private final @Nullable T value;
        private Just(@Nullable T value)
        {
            this.value = value;
        }

        public boolean isNothing() { return false; }
        public boolean isJust() { return true; }
        public @Nullable T getJust() { return value; }
        public @Nullable T get(@Nullable T def) { return value; }
        public @Nonnull String toString() { return "Just(" + value + ")"; }
        public int hashCode() { return 1 + LangUtil.nullableHashCode(value); }

        @Override
        public boolean equals(@Nullable Maybe<T> other)
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
    public static <T> @Nonnull Maybe<T> Nothing()
    {
        return (Maybe<T>) Nothing;
    }

    private static final @Nonnull Maybe<Object> Nothing = new Nothing<Object>();
    private static final class Nothing<T> extends Maybe<T>
    {
        private Nothing() {}

        public boolean isNothing() { return true; }
        public boolean isJust() { return false; }
        public @Nullable T getJust() { throw new IllegalStateException("can't call getJust() on a Nothing"); }
        public @Nullable T get(@Nullable T def) { return def; }
        public @Nonnull String toString() { return "Nothing"; }
        public int hashCode() { return 0; }

        @Override
        public boolean equals(@Nullable Maybe<T> other)
        {
            return other == this;  // There's only a single Nothing instance.
        }
    }
}
