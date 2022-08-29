/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.fileproperties.TemplateFilterBase;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

class GetMetadataArg {
    // struct files.GetMetadataArg (files.stone)

    protected final String path;
    protected final boolean includeMediaInfo;
    protected final boolean includeDeleted;
    protected final boolean includeHasExplicitSharedMembers;
    protected final TemplateFilterBase includePropertyGroups;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo} is
     *     set for photo and video.
     * @param includeDeleted  If true, {@link DeletedMetadata} will be returned
     *     for deleted file or folder, otherwise {@link LookupError#NOT_FOUND}
     *     will be returned.
     * @param includeHasExplicitSharedMembers  If true, the results will include
     *     a flag for each file indicating whether or not  that file has any
     *     explicit members.
     * @param includePropertyGroups  If set to a valid list of template IDs,
     *     {@link FileMetadata#getPropertyGroups} is set if there exists
     *     property data associated with the file and each of the listed
     *     templates.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArg(String path, boolean includeMediaInfo, boolean includeDeleted, boolean includeHasExplicitSharedMembers, TemplateFilterBase includePropertyGroups) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.includeMediaInfo = includeMediaInfo;
        this.includeDeleted = includeDeleted;
        this.includeHasExplicitSharedMembers = includeHasExplicitSharedMembers;
        this.includePropertyGroups = includePropertyGroups;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArg(String path) {
        this(path, false, false, false, null);
    }

    /**
     * The path of a file or folder on Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * If true, {@link FileMetadata#getMediaInfo} is set for photo and video.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeMediaInfo() {
        return includeMediaInfo;
    }

    /**
     * If true, {@link DeletedMetadata} will be returned for deleted file or
     * folder, otherwise {@link LookupError#NOT_FOUND} will be returned.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeDeleted() {
        return includeDeleted;
    }

    /**
     * If true, the results will include a flag for each file indicating whether
     * or not  that file has any explicit members.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeHasExplicitSharedMembers() {
        return includeHasExplicitSharedMembers;
    }

    /**
     * If set to a valid list of template IDs, {@link
     * FileMetadata#getPropertyGroups} is set if there exists property data
     * associated with the file and each of the listed templates.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public TemplateFilterBase getIncludePropertyGroups() {
        return includePropertyGroups;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link GetMetadataArg}.
     */
    public static class Builder {
        protected final String path;

        protected boolean includeMediaInfo;
        protected boolean includeDeleted;
        protected boolean includeHasExplicitSharedMembers;
        protected TemplateFilterBase includePropertyGroups;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.includeMediaInfo = false;
            this.includeDeleted = false;
            this.includeHasExplicitSharedMembers = false;
            this.includePropertyGroups = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo}
         *     is set for photo and video. Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeMediaInfo(Boolean includeMediaInfo) {
            if (includeMediaInfo != null) {
                this.includeMediaInfo = includeMediaInfo;
            }
            else {
                this.includeMediaInfo = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param includeDeleted  If true, {@link DeletedMetadata} will be
         *     returned for deleted file or folder, otherwise {@link
         *     LookupError#NOT_FOUND} will be returned. Defaults to {@code
         *     false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeDeleted(Boolean includeDeleted) {
            if (includeDeleted != null) {
                this.includeDeleted = includeDeleted;
            }
            else {
                this.includeDeleted = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param includeHasExplicitSharedMembers  If true, the results will
         *     include a flag for each file indicating whether or not  that file
         *     has any explicit members. Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeHasExplicitSharedMembers(Boolean includeHasExplicitSharedMembers) {
            if (includeHasExplicitSharedMembers != null) {
                this.includeHasExplicitSharedMembers = includeHasExplicitSharedMembers;
            }
            else {
                this.includeHasExplicitSharedMembers = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param includePropertyGroups  If set to a valid list of template IDs,
         *     {@link FileMetadata#getPropertyGroups} is set if there exists
         *     property data associated with the file and each of the listed
         *     templates.
         *
         * @return this builder
         */
        public Builder withIncludePropertyGroups(TemplateFilterBase includePropertyGroups) {
            this.includePropertyGroups = includePropertyGroups;
            return this;
        }

        /**
         * Builds an instance of {@link GetMetadataArg} configured with this
         * builder's values
         *
         * @return new instance of {@link GetMetadataArg}
         */
        public GetMetadataArg build() {
            return new GetMetadataArg(path, includeMediaInfo, includeDeleted, includeHasExplicitSharedMembers, includePropertyGroups);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            includeMediaInfo,
            includeDeleted,
            includeHasExplicitSharedMembers,
            includePropertyGroups
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
            GetMetadataArg other = (GetMetadataArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.includeMediaInfo == other.includeMediaInfo)
                && (this.includeDeleted == other.includeDeleted)
                && (this.includeHasExplicitSharedMembers == other.includeHasExplicitSharedMembers)
                && ((this.includePropertyGroups == other.includePropertyGroups) || (this.includePropertyGroups != null && this.includePropertyGroups.equals(other.includePropertyGroups)))
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
    static class Serializer extends StructSerializer<GetMetadataArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetMetadataArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("include_media_info");
            StoneSerializers.boolean_().serialize(value.includeMediaInfo, g);
            g.writeFieldName("include_deleted");
            StoneSerializers.boolean_().serialize(value.includeDeleted, g);
            g.writeFieldName("include_has_explicit_shared_members");
            StoneSerializers.boolean_().serialize(value.includeHasExplicitSharedMembers, g);
            if (value.includePropertyGroups != null) {
                g.writeFieldName("include_property_groups");
                StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).serialize(value.includePropertyGroups, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetMetadataArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetMetadataArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                Boolean f_includeMediaInfo = false;
                Boolean f_includeDeleted = false;
                Boolean f_includeHasExplicitSharedMembers = false;
                TemplateFilterBase f_includePropertyGroups = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("include_media_info".equals(field)) {
                        f_includeMediaInfo = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_deleted".equals(field)) {
                        f_includeDeleted = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_has_explicit_shared_members".equals(field)) {
                        f_includeHasExplicitSharedMembers = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_property_groups".equals(field)) {
                        f_includePropertyGroups = StoneSerializers.nullable(TemplateFilterBase.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new GetMetadataArg(f_path, f_includeMediaInfo, f_includeDeleted, f_includeHasExplicitSharedMembers, f_includePropertyGroups);
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
