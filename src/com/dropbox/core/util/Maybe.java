package com.dropbox.core.util;

public final class Maybe<T>
{
	private final boolean isJust;
	private final T value;

	private Maybe(boolean isJust, T value) { this.isJust = isJust; this.value = value; }

	private static final Maybe<Object> Nothing = new Maybe<Object>(false, null);

	public boolean isNothing() { return !this.isJust; }
	public boolean isJust() { return this.isJust; }
	public T getJust() { return this.value; }

	public T get(T def)
	{
		if (isJust) return value; else return def;
	}

	@SuppressWarnings("unchecked")
	public static <T> Maybe<T> Nothing()
	{
		return (Maybe<T>) Nothing;
	}

	public static <T> Maybe<T> Just(T value)
	{
		return new Maybe<T>(true, value);
	}

	public boolean equals(Object other)
	{
		if (other.getClass() != this.getClass()) return false;
		return equals((Maybe<?>)other);
	}

	public boolean equals(Maybe<?> other)
	{
		return this.isJust == other.isJust && eq(this.value, other.value);
	}

	private static boolean eq(Object a, Object b)
	{
		if (a == null) return (b == null);
		if (b == null) return false;
		return a.equals(b);
	}

	public String toString()
	{
		if (isJust) {
			return "Just(" + value + ")";
		} else {
			return "Nothing";
		}
	}

	public int hashCode()
	{
		if (!isJust) return 0;
		if (value == null) return 1;
		return value.hashCode();
	}
}
