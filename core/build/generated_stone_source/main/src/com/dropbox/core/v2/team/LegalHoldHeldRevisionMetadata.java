/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

public class LegalHoldHeldRevisionMetadata {
    // struct team.LegalHoldHeldRevisionMetadata (team_legal_holds.stone)

    protected final String newFilename;
    protected final String originalRevisionId;
    protected final String originalFilePath;
    protected final Date serverModified;
    protected final String authorMemberId;
    protected final TeamMemberStatus authorMemberStatus;
    protected final String authorEmail;
    protected final String fileType;
    protected final long size;
    protected final String contentHash;

    /**
     *
     * @param newFilename  The held revision filename. Must not be {@code null}.
     * @param originalRevisionId  The id of the held revision. Must have length
     *     of at least 9, match pattern "{@code [0-9a-f]+}", and not be {@code
     *     null}.
     * @param originalFilePath  The original path of the held revision. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param authorMemberId  The member id of the revision's author. Must not
     *     be {@code null}.
     * @param authorMemberStatus  The member status of the revision's author.
     *     Must not be {@code null}.
     * @param authorEmail  The email address of the held revision author. Must
     *     have length of at most 255, match pattern "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param fileType  The type of the held revision's file. Must not be {@code
     *     null}.
     * @param size  The file size in bytes.
     * @param contentHash  A hash of the file content. This field can be used to
     *     verify data integrity. For more information see our <a
     *     href="https://www.dropbox.com/developers/reference/content-hash">Content
     *     hash</a> page. Must have length of at least 64, have length of at
     *     most 64, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldHeldRevisionMetadata(String newFilename, String originalRevisionId, String originalFilePath, Date serverModified, String authorMemberId, TeamMemberStatus authorMemberStatus, String authorEmail, String fileType, long size, String contentHash) {
        if (newFilename == null) {
            throw new IllegalArgumentException("Required value for 'newFilename' is null");
        }
        this.newFilename = newFilename;
        if (originalRevisionId == null) {
            throw new IllegalArgumentException("Required value for 'originalRevisionId' is null");
        }
        if (originalRevisionId.length() < 9) {
            throw new IllegalArgumentException("String 'originalRevisionId' is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", originalRevisionId)) {
            throw new IllegalArgumentException("String 'originalRevisionId' does not match pattern");
        }
        this.originalRevisionId = originalRevisionId;
        if (originalFilePath == null) {
            throw new IllegalArgumentException("Required value for 'originalFilePath' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)?", originalFilePath)) {
            throw new IllegalArgumentException("String 'originalFilePath' does not match pattern");
        }
        this.originalFilePath = originalFilePath;
        if (serverModified == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = LangUtil.truncateMillis(serverModified);
        if (authorMemberId == null) {
            throw new IllegalArgumentException("Required value for 'authorMemberId' is null");
        }
        this.authorMemberId = authorMemberId;
        if (authorMemberStatus == null) {
            throw new IllegalArgumentException("Required value for 'authorMemberStatus' is null");
        }
        this.authorMemberStatus = authorMemberStatus;
        if (authorEmail == null) {
            throw new IllegalArgumentException("Required value for 'authorEmail' is null");
        }
        if (authorEmail.length() > 255) {
            throw new IllegalArgumentException("String 'authorEmail' is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", authorEmail)) {
            throw new IllegalArgumentException("String 'authorEmail' does not match pattern");
        }
        this.authorEmail = authorEmail;
        if (fileType == null) {
            throw new IllegalArgumentException("Required value for 'fileType' is null");
        }
        this.fileType = fileType;
        this.size = size;
        if (contentHash == null) {
            throw new IllegalArgumentException("Required value for 'contentHash' is null");
        }
        if (contentHash.length() < 64) {
            throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
        }
        if (contentHash.length() > 64) {
            throw new IllegalArgumentException("String 'contentHash' is longer than 64");
        }
        this.contentHash = contentHash;
    }

    /**
     * The held revision filename.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getNewFilename() {
        return newFilename;
    }

    /**
     * The id of the held revision.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getOriginalRevisionId() {
        return originalRevisionId;
    }

    /**
     * The original path of the held revision.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getOriginalFilePath() {
        return originalFilePath;
    }

    /**
     * The last time the file was modified on Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public Date getServerModified() {
        return serverModified;
    }

    /**
     * The member id of the revision's author.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getAuthorMemberId() {
        return authorMemberId;
    }

    /**
     * The member status of the revision's author.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamMemberStatus getAuthorMemberStatus() {
        return authorMemberStatus;
    }

    /**
     * The email address of the held revision author.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getAuthorEmail() {
        return authorEmail;
    }

    /**
     * The type of the held revision's file.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getFileType() {
        return fileType;
    }

    /**
     * The file size in bytes.
     *
     * @return value for this field.
     */
    public long getSize() {
        return size;
    }

    /**
     * A hash of the file content. This field can be used to verify data
     * integrity. For more information see our <a
     * href="https://www.dropbox.com/developers/reference/content-hash">Content
     * hash</a> page.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getContentHash() {
        return contentHash;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            newFilename,
            originalRevisionId,
            originalFilePath,
            serverModified,
            authorMemberId,
            authorMemberStatus,
            authorEmail,
            fileType,
            size,
            contentHash
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
            LegalHoldHeldRevisionMetadata other = (LegalHoldHeldRevisionMetadata) obj;
            return ((this.newFilename == other.newFilename) || (this.newFilename.equals(other.newFilename)))
                && ((this.originalRevisionId == other.originalRevisionId) || (this.originalRevisionId.equals(other.originalRevisionId)))
                && ((this.originalFilePath == other.originalFilePath) || (this.originalFilePath.equals(other.originalFilePath)))
                && ((this.serverModified == other.serverModified) || (this.serverModified.equals(other.serverModified)))
                && ((this.authorMemberId == other.authorMemberId) || (this.authorMemberId.equals(other.authorMemberId)))
                && ((this.authorMemberStatus == other.authorMemberStatus) || (this.authorMemberStatus.equals(other.authorMemberStatus)))
                && ((this.authorEmail == other.authorEmail) || (this.authorEmail.equals(other.authorEmail)))
                && ((this.fileType == other.fileType) || (this.fileType.equals(other.fileType)))
                && (this.size == other.size)
                && ((this.contentHash == other.contentHash) || (this.contentHash.equals(other.contentHash)))
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
    static class Serializer extends StructSerializer<LegalHoldHeldRevisionMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldHeldRevisionMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_filename");
            StoneSerializers.string().serialize(value.newFilename, g);
            g.writeFieldName("original_revision_id");
            StoneSerializers.string().serialize(value.originalRevisionId, g);
            g.writeFieldName("original_file_path");
            StoneSerializers.string().serialize(value.originalFilePath, g);
            g.writeFieldName("server_modified");
            StoneSerializers.timestamp().serialize(value.serverModified, g);
            g.writeFieldName("author_member_id");
            StoneSerializers.string().serialize(value.authorMemberId, g);
            g.writeFieldName("author_member_status");
            TeamMemberStatus.Serializer.INSTANCE.serialize(value.authorMemberStatus, g);
            g.writeFieldName("author_email");
            StoneSerializers.string().serialize(value.authorEmail, g);
            g.writeFieldName("file_type");
            StoneSerializers.string().serialize(value.fileType, g);
            g.writeFieldName("size");
            StoneSerializers.uInt64().serialize(value.size, g);
            g.writeFieldName("content_hash");
            StoneSerializers.string().serialize(value.contentHash, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldHeldRevisionMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldHeldRevisionMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_newFilename = null;
                String f_originalRevisionId = null;
                String f_originalFilePath = null;
                Date f_serverModified = null;
                String f_authorMemberId = null;
                TeamMemberStatus f_authorMemberStatus = null;
                String f_authorEmail = null;
                String f_fileType = null;
                Long f_size = null;
                String f_contentHash = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_filename".equals(field)) {
                        f_newFilename = StoneSerializers.string().deserialize(p);
                    }
                    else if ("original_revision_id".equals(field)) {
                        f_originalRevisionId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("original_file_path".equals(field)) {
                        f_originalFilePath = StoneSerializers.string().deserialize(p);
                    }
                    else if ("server_modified".equals(field)) {
                        f_serverModified = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("author_member_id".equals(field)) {
                        f_authorMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("author_member_status".equals(field)) {
                        f_authorMemberStatus = TeamMemberStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("author_email".equals(field)) {
                        f_authorEmail = StoneSerializers.string().deserialize(p);
                    }
                    else if ("file_type".equals(field)) {
                        f_fileType = StoneSerializers.string().deserialize(p);
                    }
                    else if ("size".equals(field)) {
                        f_size = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("content_hash".equals(field)) {
                        f_contentHash = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newFilename == null) {
                    throw new JsonParseException(p, "Required field \"new_filename\" missing.");
                }
                if (f_originalRevisionId == null) {
                    throw new JsonParseException(p, "Required field \"original_revision_id\" missing.");
                }
                if (f_originalFilePath == null) {
                    throw new JsonParseException(p, "Required field \"original_file_path\" missing.");
                }
                if (f_serverModified == null) {
                    throw new JsonParseException(p, "Required field \"server_modified\" missing.");
                }
                if (f_authorMemberId == null) {
                    throw new JsonParseException(p, "Required field \"author_member_id\" missing.");
                }
                if (f_authorMemberStatus == null) {
                    throw new JsonParseException(p, "Required field \"author_member_status\" missing.");
                }
                if (f_authorEmail == null) {
                    throw new JsonParseException(p, "Required field \"author_email\" missing.");
                }
                if (f_fileType == null) {
                    throw new JsonParseException(p, "Required field \"file_type\" missing.");
                }
                if (f_size == null) {
                    throw new JsonParseException(p, "Required field \"size\" missing.");
                }
                if (f_contentHash == null) {
                    throw new JsonParseException(p, "Required field \"content_hash\" missing.");
                }
                value = new LegalHoldHeldRevisionMetadata(f_newFilename, f_originalRevisionId, f_originalFilePath, f_serverModified, f_authorMemberId, f_authorMemberStatus, f_authorEmail, f_fileType, f_size, f_contentHash);
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
