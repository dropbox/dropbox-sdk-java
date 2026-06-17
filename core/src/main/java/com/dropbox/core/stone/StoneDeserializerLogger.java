package com.dropbox.core.stone;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StoneDeserializerLogger {
    public static @Nonnull Map<Class<?>, LoggerCallback> LOGGER_MAP =
            new HashMap<Class<?>, LoggerCallback>();

    public static <T> void registerCallback(@Nonnull Class<T> c, @Nonnull LoggerCallback callback) {
        LOGGER_MAP.put(c, callback);
    }

    public static void log(@Nonnull Object value, @Nonnull String multiLineLog) {
        Class<?> c = value.getClass();

        if (LOGGER_MAP.containsKey(c)) {
            @Nullable LoggerCallback callback = LOGGER_MAP.get(c);
            if (callback == null) {
                return;
            }
            callback.invoke(value, multiLineLog);
        }
    }

    public interface LoggerCallback {
        public void invoke(@Nonnull Object value, @Nonnull String multiLineLog);
    }
}
