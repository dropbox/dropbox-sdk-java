package com.dropbox.core.stone;

import java.util.HashMap;
import java.util.Map;

public class StoneDeserializerLogger {
    public static Map<Class<?>, LoggerCallback> LOGGER_MAP =
            new HashMap<Class<?>, LoggerCallback>();

    public static <T> void registerCallback(Class<T> c, LoggerCallback callback) {
        LOGGER_MAP.put(c, callback);
    }

    public static void log(Object value, String multiLineLog) {
        Class<?> c = value.getClass();

        if (LOGGER_MAP.containsKey(c)) {
            LoggerCallback callback = LOGGER_MAP.get(c);
            callback.invoke(value, multiLineLog);
        }
    }

    public interface LoggerCallback {
        public void invoke(Object value, String multiLineLog);
    }
}
