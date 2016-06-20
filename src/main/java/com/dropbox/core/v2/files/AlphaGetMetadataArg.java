/* DO NOT EDIT */
/* This file was generated from files_properties.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class AlphaGetMetadataArg extends GetMetadataArg {
    // struct AlphaGetMetadataArg

    protected final List<String> includePropertyTemplates;

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
     * @param includePropertyTemplates  If true, {@link
     *     FileMetadata#getPropertyGroups} is set for files with custom
     *     properties. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGetMetadataArg(String path, boolean includeMediaInfo, boolean includeDeleted, boolean includeHasExplicitSharedMembers, List<String> includePropertyTemplates) {
        super(path, includeMediaInfo, includeDeleted, includeHasExplicitSharedMembers);
        if (includePropertyTemplates != null) {
            for (String x : includePropertyTemplates) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'includePropertyTemplates' is null");
                }
                if (x.length() < 1) {
                    throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' is shorter than 1");
                }
                if (!java.util.regex.Pattern.matches("(/|ptid:).*", x)) {
                    throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' does not match pattern");
                }
            }
        }
        this.includePropertyTemplates = includePropertyTemplates;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGetMetadataArg(String path) {
        this(path, false, false, false, null);
    }

    /**
     * If true, {@link FileMetadata#getPropertyGroups} is set for files with
     * custom properties.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<String> getIncludePropertyTemplates() {
        return includePropertyTemplates;
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
     * Builder for {@link AlphaGetMetadataArg}.
     */
    public static class Builder extends GetMetadataArg.Builder {

        protected List<String> includePropertyTemplates;

        protected Builder(String path) {
            super(path);
            this.includePropertyTemplates = null;
        }

        /**
         * Set value for optional field.
         *
         * @param includePropertyTemplates  If true, {@link
         *     FileMetadata#getPropertyGroups} is set for files with custom
         *     properties. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withIncludePropertyTemplates(List<String> includePropertyTemplates) {
            if (includePropertyTemplates != null) {
                for (String x : includePropertyTemplates) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'includePropertyTemplates' is null");
                    }
                    if (x.length() < 1) {
                        throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' is shorter than 1");
                    }
                    if (!java.util.regex.Pattern.matches("(/|ptid:).*", x)) {
                        throw new IllegalArgumentException("Stringan item in list 'includePropertyTemplates' does not match pattern");
                    }
                }
            }
            this.includePropertyTemplates = includePropertyTemplates;
            return this;
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
            super.withIncludeMediaInfo(includeMediaInfo);
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
            super.withIncludeDeleted(includeDeleted);
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
            super.withIncludeHasExplicitSharedMembers(includeHasExplicitSharedMembers);
            return this;
        }

        /**
         * Builds an instance of {@link AlphaGetMetadataArg} configured with
         * this builder's values
         *
         * @return new instance of {@link AlphaGetMetadataArg}
         */
        public AlphaGetMetadataArg build() {
            return new AlphaGetMetadataArg(path, includeMediaInfo, includeDeleted, includeHasExplicitSharedMembers, includePropertyTemplates);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            includePropertyTemplates
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            AlphaGetMetadataArg other = (AlphaGetMetadataArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.includeMediaInfo == other.includeMediaInfo)
                && (this.includeDeleted == other.includeDeleted)
                && (this.includeHasExplicitSharedMembers == other.includeHasExplicitSharedMembers)
                && ((this.includePropertyTemplates == other.includePropertyTemplates) || (this.includePropertyTemplates != null && this.includePropertyTemplates.equals(other.includePropertyTemplates)))
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
    static final class Serializer extends StructSerializer<AlphaGetMetadataArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlphaGetMetadataArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (value.includePropertyTemplates != null) {
                g.writeFieldName("include_property_templates");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.includePropertyTemplates, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AlphaGetMetadataArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AlphaGetMetadataArg value;
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
                List<String> f_includePropertyTemplates = null;
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
                    else if ("include_property_templates".equals(field)) {
                        f_includePropertyTemplates = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new AlphaGetMetadataArg(f_path, f_includeMediaInfo, f_includeDeleted, f_includeHasExplicitSharedMembers, f_includePropertyTemplates);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
