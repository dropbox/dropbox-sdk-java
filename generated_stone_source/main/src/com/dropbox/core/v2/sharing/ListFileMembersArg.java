/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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
import java.util.regex.Pattern;

/**
 * Arguments for {@link DbxUserSharingRequests#listFileMembers(String)}.
 */
class ListFileMembersArg {
    // struct sharing.ListFileMembersArg (sharing_files.stone)

    protected final String file;
    protected final List<MemberAction> actions;
    protected final boolean includeInherited;
    protected final long limit;

    /**
     * Arguments for {@link DbxUserSharingRequests#listFileMembers(String)}.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param file  The file for which you want to see members. Must have length
     *     of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param actions  The actions for which to return permissions on a member.
     *     Must not contain a {@code null} item.
     * @param includeInherited  Whether to include members who only have access
     *     from a parent shared folder.
     * @param limit  Number of members to return max per query. Defaults to 100
     *     if no limit is specified. Must be greater than or equal to 1 and be
     *     less than or equal to 300.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersArg(String file, List<MemberAction> actions, boolean includeInherited, long limit) {
        if (file == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (file.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", file)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = file;
        if (actions != null) {
            for (MemberAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = actions;
        this.includeInherited = includeInherited;
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 300L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 300L");
        }
        this.limit = limit;
    }

    /**
     * Arguments for {@link DbxUserSharingRequests#listFileMembers(String)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param file  The file for which you want to see members. Must have length
     *     of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersArg(String file) {
        this(file, null, true, 100L);
    }

    /**
     * The file for which you want to see members.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFile() {
        return file;
    }

    /**
     * The actions for which to return permissions on a member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<MemberAction> getActions() {
        return actions;
    }

    /**
     * Whether to include members who only have access from a parent shared
     * folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeInherited() {
        return includeInherited;
    }

    /**
     * Number of members to return max per query. Defaults to 100 if no limit is
     * specified.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     100L.
     */
    public long getLimit() {
        return limit;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param file  The file for which you want to see members. Must have length
     *     of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String file) {
        return new Builder(file);
    }

    /**
     * Builder for {@link ListFileMembersArg}.
     */
    public static class Builder {
        protected final String file;

        protected List<MemberAction> actions;
        protected boolean includeInherited;
        protected long limit;

        protected Builder(String file) {
            if (file == null) {
                throw new IllegalArgumentException("Required value for 'file' is null");
            }
            if (file.length() < 1) {
                throw new IllegalArgumentException("String 'file' is shorter than 1");
            }
            if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", file)) {
                throw new IllegalArgumentException("String 'file' does not match pattern");
            }
            this.file = file;
            this.actions = null;
            this.includeInherited = true;
            this.limit = 100L;
        }

        /**
         * Set value for optional field.
         *
         * @param actions  The actions for which to return permissions on a
         *     member. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withActions(List<MemberAction> actions) {
            if (actions != null) {
                for (MemberAction x : actions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'actions' is null");
                    }
                }
            }
            this.actions = actions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param includeInherited  Whether to include members who only have
         *     access from a parent shared folder. Defaults to {@code true} when
         *     set to {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeInherited(Boolean includeInherited) {
            if (includeInherited != null) {
                this.includeInherited = includeInherited;
            }
            else {
                this.includeInherited = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 100L}.
         * </p>
         *
         * @param limit  Number of members to return max per query. Defaults to
         *     100 if no limit is specified. Must be greater than or equal to 1
         *     and be less than or equal to 300. Defaults to {@code 100L} when
         *     set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withLimit(Long limit) {
            if (limit < 1L) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (limit > 300L) {
                throw new IllegalArgumentException("Number 'limit' is larger than 300L");
            }
            if (limit != null) {
                this.limit = limit;
            }
            else {
                this.limit = 100L;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ListFileMembersArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListFileMembersArg}
         */
        public ListFileMembersArg build() {
            return new ListFileMembersArg(file, actions, includeInherited, limit);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            file,
            actions,
            includeInherited,
            limit
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
            ListFileMembersArg other = (ListFileMembersArg) obj;
            return ((this.file == other.file) || (this.file.equals(other.file)))
                && ((this.actions == other.actions) || (this.actions != null && this.actions.equals(other.actions)))
                && (this.includeInherited == other.includeInherited)
                && (this.limit == other.limit)
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
    static class Serializer extends StructSerializer<ListFileMembersArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileMembersArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file");
            StoneSerializers.string().serialize(value.file, g);
            if (value.actions != null) {
                g.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).serialize(value.actions, g);
            }
            g.writeFieldName("include_inherited");
            StoneSerializers.boolean_().serialize(value.includeInherited, g);
            g.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFileMembersArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileMembersArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_file = null;
                List<MemberAction> f_actions = null;
                Boolean f_includeInherited = true;
                Long f_limit = 100L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file".equals(field)) {
                        f_file = StoneSerializers.string().deserialize(p);
                    }
                    else if ("actions".equals(field)) {
                        f_actions = StoneSerializers.nullable(StoneSerializers.list(MemberAction.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("include_inherited".equals(field)) {
                        f_includeInherited = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_file == null) {
                    throw new JsonParseException(p, "Required field \"file\" missing.");
                }
                value = new ListFileMembersArg(f_file, f_actions, f_includeInherited, f_limit);
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
