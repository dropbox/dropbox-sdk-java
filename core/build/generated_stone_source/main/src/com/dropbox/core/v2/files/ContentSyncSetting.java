/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ContentSyncSetting {
    // struct files.ContentSyncSetting (files.stone)

    protected final String id;
    protected final SyncSetting syncSetting;

    /**
     *
     * @param id  Id of the item this setting is applied to. Must have length of
     *     at least 4, match pattern "{@code id:.+}", and not be {@code null}.
     * @param syncSetting  Setting for this item. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ContentSyncSetting(String id, SyncSetting syncSetting) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 4) {
            throw new IllegalArgumentException("String 'id' is shorter than 4");
        }
        if (!Pattern.matches("id:.+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
        if (syncSetting == null) {
            throw new IllegalArgumentException("Required value for 'syncSetting' is null");
        }
        this.syncSetting = syncSetting;
    }

    /**
     * Id of the item this setting is applied to.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    /**
     * Setting for this item.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public SyncSetting getSyncSetting() {
        return syncSetting;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id,
            syncSetting
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ContentSyncSetting other = (ContentSyncSetting) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.syncSetting == other.syncSetting) || (this.syncSetting.equals(other.syncSetting)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    public static class Serializer extends StructSerializer<ContentSyncSetting> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ContentSyncSetting value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("sync_setting");
            SyncSetting.Serializer.INSTANCE.serialize(value.syncSetting, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ContentSyncSetting deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ContentSyncSetting value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                SyncSetting f_syncSetting = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sync_setting".equals(field)) {
                        f_syncSetting = SyncSetting.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_syncSetting == null) {
                    throw new JsonParseException(p, "Required field \"sync_setting\" missing.");
                }
                value = new ContentSyncSetting(f_id, f_syncSetting);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
