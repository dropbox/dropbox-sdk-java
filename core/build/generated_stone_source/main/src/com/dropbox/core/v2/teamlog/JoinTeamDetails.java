/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Additional information relevant when a new member joins the team.
 */
public class JoinTeamDetails {
    // struct team_log.JoinTeamDetails (team_log_generated.stone)

    @Nonnull
    protected final List<UserLinkedAppLogInfo> linkedApps;
    @Nonnull
    protected final List<LinkedDeviceLogInfo> linkedDevices;
    @Nonnull
    protected final List<FolderLogInfo> linkedSharedFolders;
    @Nullable
    protected final Boolean wasLinkedAppsTruncated;
    @Nullable
    protected final Boolean wasLinkedDevicesTruncated;
    @Nullable
    protected final Boolean wasLinkedSharedFoldersTruncated;
    @Nullable
    protected final Boolean hasLinkedApps;
    @Nullable
    protected final Boolean hasLinkedDevices;
    @Nullable
    protected final Boolean hasLinkedSharedFolders;

    /**
     * Additional information relevant when a new member joins the team.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param linkedApps  Linked applications. (Deprecated) Please use
     *     has_linked_apps boolean field instead. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param linkedDevices  Linked devices. (Deprecated) Please use
     *     has_linked_devices boolean field instead. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param linkedSharedFolders  Linked shared folders. (Deprecated) Please
     *     use has_linked_shared_folders boolean field instead. Must not contain
     *     a {@code null} item and not be {@code null}.
     * @param wasLinkedAppsTruncated  (Deprecated) True if the linked_apps list
     *     was truncated to the maximum supported length (50).
     * @param wasLinkedDevicesTruncated  (Deprecated) True if the linked_devices
     *     list was truncated to the maximum supported length (50).
     * @param wasLinkedSharedFoldersTruncated  (Deprecated) True if the
     *     linked_shared_folders list was truncated to the maximum supported
     *     length (50).
     * @param hasLinkedApps  True if the user had linked apps at event time.
     * @param hasLinkedDevices  True if the user had linked apps at event time.
     * @param hasLinkedSharedFolders  True if the user had linked shared folders
     *     at event time.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public JoinTeamDetails(@Nonnull List<UserLinkedAppLogInfo> linkedApps, @Nonnull List<LinkedDeviceLogInfo> linkedDevices, @Nonnull List<FolderLogInfo> linkedSharedFolders, @Nullable Boolean wasLinkedAppsTruncated, @Nullable Boolean wasLinkedDevicesTruncated, @Nullable Boolean wasLinkedSharedFoldersTruncated, @Nullable Boolean hasLinkedApps, @Nullable Boolean hasLinkedDevices, @Nullable Boolean hasLinkedSharedFolders) {
        if (linkedApps == null) {
            throw new IllegalArgumentException("Required value for 'linkedApps' is null");
        }
        for (UserLinkedAppLogInfo x : linkedApps) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linkedApps' is null");
            }
        }
        this.linkedApps = linkedApps;
        if (linkedDevices == null) {
            throw new IllegalArgumentException("Required value for 'linkedDevices' is null");
        }
        for (LinkedDeviceLogInfo x : linkedDevices) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linkedDevices' is null");
            }
        }
        this.linkedDevices = linkedDevices;
        if (linkedSharedFolders == null) {
            throw new IllegalArgumentException("Required value for 'linkedSharedFolders' is null");
        }
        for (FolderLogInfo x : linkedSharedFolders) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linkedSharedFolders' is null");
            }
        }
        this.linkedSharedFolders = linkedSharedFolders;
        this.wasLinkedAppsTruncated = wasLinkedAppsTruncated;
        this.wasLinkedDevicesTruncated = wasLinkedDevicesTruncated;
        this.wasLinkedSharedFoldersTruncated = wasLinkedSharedFoldersTruncated;
        this.hasLinkedApps = hasLinkedApps;
        this.hasLinkedDevices = hasLinkedDevices;
        this.hasLinkedSharedFolders = hasLinkedSharedFolders;
    }

    /**
     * Additional information relevant when a new member joins the team.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param linkedApps  Linked applications. (Deprecated) Please use
     *     has_linked_apps boolean field instead. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param linkedDevices  Linked devices. (Deprecated) Please use
     *     has_linked_devices boolean field instead. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param linkedSharedFolders  Linked shared folders. (Deprecated) Please
     *     use has_linked_shared_folders boolean field instead. Must not contain
     *     a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public JoinTeamDetails(@Nonnull List<UserLinkedAppLogInfo> linkedApps, @Nonnull List<LinkedDeviceLogInfo> linkedDevices, @Nonnull List<FolderLogInfo> linkedSharedFolders) {
        this(linkedApps, linkedDevices, linkedSharedFolders, null, null, null, null, null, null);
    }

    /**
     * Linked applications. (Deprecated) Please use has_linked_apps boolean
     * field instead.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<UserLinkedAppLogInfo> getLinkedApps() {
        return linkedApps;
    }

    /**
     * Linked devices. (Deprecated) Please use has_linked_devices boolean field
     * instead.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<LinkedDeviceLogInfo> getLinkedDevices() {
        return linkedDevices;
    }

    /**
     * Linked shared folders. (Deprecated) Please use has_linked_shared_folders
     * boolean field instead.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<FolderLogInfo> getLinkedSharedFolders() {
        return linkedSharedFolders;
    }

    /**
     * (Deprecated) True if the linked_apps list was truncated to the maximum
     * supported length (50).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getWasLinkedAppsTruncated() {
        return wasLinkedAppsTruncated;
    }

    /**
     * (Deprecated) True if the linked_devices list was truncated to the maximum
     * supported length (50).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getWasLinkedDevicesTruncated() {
        return wasLinkedDevicesTruncated;
    }

    /**
     * (Deprecated) True if the linked_shared_folders list was truncated to the
     * maximum supported length (50).
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getWasLinkedSharedFoldersTruncated() {
        return wasLinkedSharedFoldersTruncated;
    }

    /**
     * True if the user had linked apps at event time.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getHasLinkedApps() {
        return hasLinkedApps;
    }

    /**
     * True if the user had linked apps at event time.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getHasLinkedDevices() {
        return hasLinkedDevices;
    }

    /**
     * True if the user had linked shared folders at event time.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getHasLinkedSharedFolders() {
        return hasLinkedSharedFolders;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param linkedApps  Linked applications. (Deprecated) Please use
     *     has_linked_apps boolean field instead. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param linkedDevices  Linked devices. (Deprecated) Please use
     *     has_linked_devices boolean field instead. Must not contain a {@code
     *     null} item and not be {@code null}.
     * @param linkedSharedFolders  Linked shared folders. (Deprecated) Please
     *     use has_linked_shared_folders boolean field instead. Must not contain
     *     a {@code null} item and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(List<UserLinkedAppLogInfo> linkedApps, List<LinkedDeviceLogInfo> linkedDevices, List<FolderLogInfo> linkedSharedFolders) {
        return new Builder(linkedApps, linkedDevices, linkedSharedFolders);
    }

    /**
     * Builder for {@link JoinTeamDetails}.
     */
    public static class Builder {
        protected final List<UserLinkedAppLogInfo> linkedApps;
        protected final List<LinkedDeviceLogInfo> linkedDevices;
        protected final List<FolderLogInfo> linkedSharedFolders;

        protected Boolean wasLinkedAppsTruncated;
        protected Boolean wasLinkedDevicesTruncated;
        protected Boolean wasLinkedSharedFoldersTruncated;
        protected Boolean hasLinkedApps;
        protected Boolean hasLinkedDevices;
        protected Boolean hasLinkedSharedFolders;

        protected Builder(List<UserLinkedAppLogInfo> linkedApps, List<LinkedDeviceLogInfo> linkedDevices, List<FolderLogInfo> linkedSharedFolders) {
            if (linkedApps == null) {
                throw new IllegalArgumentException("Required value for 'linkedApps' is null");
            }
            for (UserLinkedAppLogInfo x : linkedApps) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'linkedApps' is null");
                }
            }
            this.linkedApps = linkedApps;
            if (linkedDevices == null) {
                throw new IllegalArgumentException("Required value for 'linkedDevices' is null");
            }
            for (LinkedDeviceLogInfo x : linkedDevices) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'linkedDevices' is null");
                }
            }
            this.linkedDevices = linkedDevices;
            if (linkedSharedFolders == null) {
                throw new IllegalArgumentException("Required value for 'linkedSharedFolders' is null");
            }
            for (FolderLogInfo x : linkedSharedFolders) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'linkedSharedFolders' is null");
                }
            }
            this.linkedSharedFolders = linkedSharedFolders;
            this.wasLinkedAppsTruncated = null;
            this.wasLinkedDevicesTruncated = null;
            this.wasLinkedSharedFoldersTruncated = null;
            this.hasLinkedApps = null;
            this.hasLinkedDevices = null;
            this.hasLinkedSharedFolders = null;
        }

        /**
         * Set value for optional field.
         *
         * @param wasLinkedAppsTruncated  (Deprecated) True if the linked_apps
         *     list was truncated to the maximum supported length (50).
         *
         * @return this builder
         */
        public Builder withWasLinkedAppsTruncated(Boolean wasLinkedAppsTruncated) {
            this.wasLinkedAppsTruncated = wasLinkedAppsTruncated;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param wasLinkedDevicesTruncated  (Deprecated) True if the
         *     linked_devices list was truncated to the maximum supported length
         *     (50).
         *
         * @return this builder
         */
        public Builder withWasLinkedDevicesTruncated(Boolean wasLinkedDevicesTruncated) {
            this.wasLinkedDevicesTruncated = wasLinkedDevicesTruncated;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param wasLinkedSharedFoldersTruncated  (Deprecated) True if the
         *     linked_shared_folders list was truncated to the maximum supported
         *     length (50).
         *
         * @return this builder
         */
        public Builder withWasLinkedSharedFoldersTruncated(Boolean wasLinkedSharedFoldersTruncated) {
            this.wasLinkedSharedFoldersTruncated = wasLinkedSharedFoldersTruncated;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param hasLinkedApps  True if the user had linked apps at event time.
         *
         * @return this builder
         */
        public Builder withHasLinkedApps(Boolean hasLinkedApps) {
            this.hasLinkedApps = hasLinkedApps;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param hasLinkedDevices  True if the user had linked apps at event
         *     time.
         *
         * @return this builder
         */
        public Builder withHasLinkedDevices(Boolean hasLinkedDevices) {
            this.hasLinkedDevices = hasLinkedDevices;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param hasLinkedSharedFolders  True if the user had linked shared
         *     folders at event time.
         *
         * @return this builder
         */
        public Builder withHasLinkedSharedFolders(Boolean hasLinkedSharedFolders) {
            this.hasLinkedSharedFolders = hasLinkedSharedFolders;
            return this;
        }

        /**
         * Builds an instance of {@link JoinTeamDetails} configured with this
         * builder's values
         *
         * @return new instance of {@link JoinTeamDetails}
         */
        public JoinTeamDetails build() {
            return new JoinTeamDetails(linkedApps, linkedDevices, linkedSharedFolders, wasLinkedAppsTruncated, wasLinkedDevicesTruncated, wasLinkedSharedFoldersTruncated, hasLinkedApps, hasLinkedDevices, hasLinkedSharedFolders);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.linkedApps,
            this.linkedDevices,
            this.linkedSharedFolders,
            this.wasLinkedAppsTruncated,
            this.wasLinkedDevicesTruncated,
            this.wasLinkedSharedFoldersTruncated,
            this.hasLinkedApps,
            this.hasLinkedDevices,
            this.hasLinkedSharedFolders
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
            JoinTeamDetails other = (JoinTeamDetails) obj;
            return ((this.linkedApps == other.linkedApps) || (this.linkedApps.equals(other.linkedApps)))
                && ((this.linkedDevices == other.linkedDevices) || (this.linkedDevices.equals(other.linkedDevices)))
                && ((this.linkedSharedFolders == other.linkedSharedFolders) || (this.linkedSharedFolders.equals(other.linkedSharedFolders)))
                && ((this.wasLinkedAppsTruncated == other.wasLinkedAppsTruncated) || (this.wasLinkedAppsTruncated != null && this.wasLinkedAppsTruncated.equals(other.wasLinkedAppsTruncated)))
                && ((this.wasLinkedDevicesTruncated == other.wasLinkedDevicesTruncated) || (this.wasLinkedDevicesTruncated != null && this.wasLinkedDevicesTruncated.equals(other.wasLinkedDevicesTruncated)))
                && ((this.wasLinkedSharedFoldersTruncated == other.wasLinkedSharedFoldersTruncated) || (this.wasLinkedSharedFoldersTruncated != null && this.wasLinkedSharedFoldersTruncated.equals(other.wasLinkedSharedFoldersTruncated)))
                && ((this.hasLinkedApps == other.hasLinkedApps) || (this.hasLinkedApps != null && this.hasLinkedApps.equals(other.hasLinkedApps)))
                && ((this.hasLinkedDevices == other.hasLinkedDevices) || (this.hasLinkedDevices != null && this.hasLinkedDevices.equals(other.hasLinkedDevices)))
                && ((this.hasLinkedSharedFolders == other.hasLinkedSharedFolders) || (this.hasLinkedSharedFolders != null && this.hasLinkedSharedFolders.equals(other.hasLinkedSharedFolders)))
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
    static class Serializer extends StructSerializer<JoinTeamDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(JoinTeamDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("linked_apps");
            StoneSerializers.list(UserLinkedAppLogInfo.Serializer.INSTANCE).serialize(value.linkedApps, g);
            g.writeFieldName("linked_devices");
            StoneSerializers.list(LinkedDeviceLogInfo.Serializer.INSTANCE).serialize(value.linkedDevices, g);
            g.writeFieldName("linked_shared_folders");
            StoneSerializers.list(FolderLogInfo.Serializer.INSTANCE).serialize(value.linkedSharedFolders, g);
            if (value.wasLinkedAppsTruncated != null) {
                g.writeFieldName("was_linked_apps_truncated");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.wasLinkedAppsTruncated, g);
            }
            if (value.wasLinkedDevicesTruncated != null) {
                g.writeFieldName("was_linked_devices_truncated");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.wasLinkedDevicesTruncated, g);
            }
            if (value.wasLinkedSharedFoldersTruncated != null) {
                g.writeFieldName("was_linked_shared_folders_truncated");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.wasLinkedSharedFoldersTruncated, g);
            }
            if (value.hasLinkedApps != null) {
                g.writeFieldName("has_linked_apps");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.hasLinkedApps, g);
            }
            if (value.hasLinkedDevices != null) {
                g.writeFieldName("has_linked_devices");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.hasLinkedDevices, g);
            }
            if (value.hasLinkedSharedFolders != null) {
                g.writeFieldName("has_linked_shared_folders");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.hasLinkedSharedFolders, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public JoinTeamDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            JoinTeamDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UserLinkedAppLogInfo> f_linkedApps = null;
                List<LinkedDeviceLogInfo> f_linkedDevices = null;
                List<FolderLogInfo> f_linkedSharedFolders = null;
                Boolean f_wasLinkedAppsTruncated = null;
                Boolean f_wasLinkedDevicesTruncated = null;
                Boolean f_wasLinkedSharedFoldersTruncated = null;
                Boolean f_hasLinkedApps = null;
                Boolean f_hasLinkedDevices = null;
                Boolean f_hasLinkedSharedFolders = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("linked_apps".equals(field)) {
                        f_linkedApps = StoneSerializers.list(UserLinkedAppLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("linked_devices".equals(field)) {
                        f_linkedDevices = StoneSerializers.list(LinkedDeviceLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("linked_shared_folders".equals(field)) {
                        f_linkedSharedFolders = StoneSerializers.list(FolderLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("was_linked_apps_truncated".equals(field)) {
                        f_wasLinkedAppsTruncated = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("was_linked_devices_truncated".equals(field)) {
                        f_wasLinkedDevicesTruncated = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("was_linked_shared_folders_truncated".equals(field)) {
                        f_wasLinkedSharedFoldersTruncated = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("has_linked_apps".equals(field)) {
                        f_hasLinkedApps = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("has_linked_devices".equals(field)) {
                        f_hasLinkedDevices = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("has_linked_shared_folders".equals(field)) {
                        f_hasLinkedSharedFolders = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_linkedApps == null) {
                    throw new JsonParseException(p, "Required field \"linked_apps\" missing.");
                }
                if (f_linkedDevices == null) {
                    throw new JsonParseException(p, "Required field \"linked_devices\" missing.");
                }
                if (f_linkedSharedFolders == null) {
                    throw new JsonParseException(p, "Required field \"linked_shared_folders\" missing.");
                }
                value = new JoinTeamDetails(f_linkedApps, f_linkedDevices, f_linkedSharedFolders, f_wasLinkedAppsTruncated, f_wasLinkedDevicesTruncated, f_wasLinkedSharedFoldersTruncated, f_hasLinkedApps, f_hasLinkedDevices, f_hasLinkedSharedFolders);
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
