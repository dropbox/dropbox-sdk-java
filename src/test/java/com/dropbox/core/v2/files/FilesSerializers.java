package com.dropbox.core.v2.files;

import static org.testng.Assert.fail;

import com.dropbox.core.stone.StoneSerializer;

/**
 * Since serializers are often package private, expose them through
 * this utility class.
 */
public final class FilesSerializers {
    @SuppressWarnings("unchecked")
    public static <T> StoneSerializer<T> serializer(Class<T> dataType) {
        if (Metadata.class.isAssignableFrom(dataType)) {
            return (StoneSerializer<T>) Metadata.Serializer.INSTANCE;
        } else {
            fail("Required serializer not added to FilesSerializers: " + dataType);
            return null;
        }
    }
}
