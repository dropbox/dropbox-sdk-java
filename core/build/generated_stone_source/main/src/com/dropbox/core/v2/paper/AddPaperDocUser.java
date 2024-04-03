/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

class AddPaperDocUser extends RefPaperDoc {
    // struct paper.AddPaperDocUser (paper.stone)

    @Nonnull
    protected final List<AddMember> members;
    @Nullable
    protected final String customMessage;
    protected final boolean quiet;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param members  User which should be added to the Paper doc. Specify only
     *     email address or Dropbox account ID. Must contain at most 20 items,
     *     not contain a {@code null} item, and not be {@code null}.
     * @param customMessage  A personal message that will be emailed to each
     *     successfully added member.
     * @param quiet  Clients should set this to true if no email message shall
     *     be sent to added users.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddPaperDocUser(@Nonnull String docId, @Nonnull List<AddMember> members, @Nullable String customMessage, boolean quiet) {
        super(docId);
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        if (members.size() > 20) {
            throw new IllegalArgumentException("List 'members' has more than 20 items");
        }
        for (AddMember x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        this.customMessage = customMessage;
        this.quiet = quiet;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param members  User which should be added to the Paper doc. Specify only
     *     email address or Dropbox account ID. Must contain at most 20 items,
     *     not contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddPaperDocUser(@Nonnull String docId, @Nonnull List<AddMember> members) {
        this(docId, members, null, false);
    }

    /**
     * The Paper doc ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDocId() {
        return docId;
    }

    /**
     * User which should be added to the Paper doc. Specify only email address
     * or Dropbox account ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<AddMember> getMembers() {
        return members;
    }

    /**
     * A personal message that will be emailed to each successfully added
     * member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCustomMessage() {
        return customMessage;
    }

    /**
     * Clients should set this to true if no email message shall be sent to
     * added users.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getQuiet() {
        return quiet;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param members  User which should be added to the Paper doc. Specify only
     *     email address or Dropbox account ID. Must contain at most 20 items,
     *     not contain a {@code null} item, and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String docId, List<AddMember> members) {
        return new Builder(docId, members);
    }

    /**
     * Builder for {@link AddPaperDocUser}.
     */
    public static class Builder {
        protected final String docId;
        protected final List<AddMember> members;

        protected String customMessage;
        protected boolean quiet;

        protected Builder(String docId, List<AddMember> members) {
            if (docId == null) {
                throw new IllegalArgumentException("Required value for 'docId' is null");
            }
            this.docId = docId;
            if (members == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            if (members.size() > 20) {
                throw new IllegalArgumentException("List 'members' has more than 20 items");
            }
            for (AddMember x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = members;
            this.customMessage = null;
            this.quiet = false;
        }

        /**
         * Set value for optional field.
         *
         * @param customMessage  A personal message that will be emailed to each
         *     successfully added member.
         *
         * @return this builder
         */
        public Builder withCustomMessage(String customMessage) {
            this.customMessage = customMessage;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param quiet  Clients should set this to true if no email message
         *     shall be sent to added users. Defaults to {@code false} when set
         *     to {@code null}.
         *
         * @return this builder
         */
        public Builder withQuiet(Boolean quiet) {
            if (quiet != null) {
                this.quiet = quiet;
            }
            else {
                this.quiet = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link AddPaperDocUser} configured with this
         * builder's values
         *
         * @return new instance of {@link AddPaperDocUser}
         */
        public AddPaperDocUser build() {
            return new AddPaperDocUser(docId, members, customMessage, quiet);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.members,
            this.customMessage,
            this.quiet
        });
        hash = (31 * super.hashCode()) + hash;
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
            AddPaperDocUser other = (AddPaperDocUser) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && ((this.members == other.members) || (this.members.equals(other.members)))
                && ((this.customMessage == other.customMessage) || (this.customMessage != null && this.customMessage.equals(other.customMessage)))
                && (this.quiet == other.quiet)
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
    static class Serializer extends StructSerializer<AddPaperDocUser> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddPaperDocUser value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("members");
            StoneSerializers.list(AddMember.Serializer.INSTANCE).serialize(value.members, g);
            if (value.customMessage != null) {
                g.writeFieldName("custom_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.customMessage, g);
            }
            g.writeFieldName("quiet");
            StoneSerializers.boolean_().serialize(value.quiet, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AddPaperDocUser deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AddPaperDocUser value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                List<AddMember> f_members = null;
                String f_customMessage = null;
                Boolean f_quiet = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("members".equals(field)) {
                        f_members = StoneSerializers.list(AddMember.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("custom_message".equals(field)) {
                        f_customMessage = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("quiet".equals(field)) {
                        f_quiet = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                if (f_members == null) {
                    throw new JsonParseException(p, "Required field \"members\" missing.");
                }
                value = new AddPaperDocUser(f_docId, f_members, f_customMessage, f_quiet);
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
