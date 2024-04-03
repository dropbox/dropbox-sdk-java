/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Asset details.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class AssetLogInfo {
    // union team_log.AssetLogInfo (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link AssetLogInfo}.
     */
    public enum Tag {
        /**
         * File's details.
         */
        FILE, // FileLogInfo
        /**
         * Folder's details.
         */
        FOLDER, // FolderLogInfo
        /**
         * Paper document's details.
         */
        PAPER_DOCUMENT, // PaperDocumentLogInfo
        /**
         * Paper folder's details.
         */
        PAPER_FOLDER, // PaperFolderLogInfo
        /**
         * Showcase document's details.
         */
        SHOWCASE_DOCUMENT, // ShowcaseDocumentLogInfo
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final AssetLogInfo OTHER = new AssetLogInfo().withTag(Tag.OTHER);

    private Tag _tag;
    private FileLogInfo fileValue;
    private FolderLogInfo folderValue;
    private PaperDocumentLogInfo paperDocumentValue;
    private PaperFolderLogInfo paperFolderValue;
    private ShowcaseDocumentLogInfo showcaseDocumentValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private AssetLogInfo() {
    }


    /**
     * Asset details.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private AssetLogInfo withTag(Tag _tag) {
        AssetLogInfo result = new AssetLogInfo();
        result._tag = _tag;
        return result;
    }

    /**
     * Asset details.
     *
     * @param fileValue  File's details. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AssetLogInfo withTagAndFile(Tag _tag, FileLogInfo fileValue) {
        AssetLogInfo result = new AssetLogInfo();
        result._tag = _tag;
        result.fileValue = fileValue;
        return result;
    }

    /**
     * Asset details.
     *
     * @param folderValue  Folder's details. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AssetLogInfo withTagAndFolder(Tag _tag, FolderLogInfo folderValue) {
        AssetLogInfo result = new AssetLogInfo();
        result._tag = _tag;
        result.folderValue = folderValue;
        return result;
    }

    /**
     * Asset details.
     *
     * @param paperDocumentValue  Paper document's details. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AssetLogInfo withTagAndPaperDocument(Tag _tag, PaperDocumentLogInfo paperDocumentValue) {
        AssetLogInfo result = new AssetLogInfo();
        result._tag = _tag;
        result.paperDocumentValue = paperDocumentValue;
        return result;
    }

    /**
     * Asset details.
     *
     * @param paperFolderValue  Paper folder's details. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AssetLogInfo withTagAndPaperFolder(Tag _tag, PaperFolderLogInfo paperFolderValue) {
        AssetLogInfo result = new AssetLogInfo();
        result._tag = _tag;
        result.paperFolderValue = paperFolderValue;
        return result;
    }

    /**
     * Asset details.
     *
     * @param showcaseDocumentValue  Showcase document's details. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AssetLogInfo withTagAndShowcaseDocument(Tag _tag, ShowcaseDocumentLogInfo showcaseDocumentValue) {
        AssetLogInfo result = new AssetLogInfo();
        result._tag = _tag;
        result.showcaseDocumentValue = showcaseDocumentValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code AssetLogInfo}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FILE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#FILE},
     *     {@code false} otherwise.
     */
    public boolean isFile() {
        return this._tag == Tag.FILE;
    }

    /**
     * Returns an instance of {@code AssetLogInfo} that has its tag set to
     * {@link Tag#FILE}.
     *
     * <p> File's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AssetLogInfo} with its tag set to {@link
     *     Tag#FILE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AssetLogInfo file(FileLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndFile(Tag.FILE, value);
    }

    /**
     * File's details.
     *
     * <p> This instance must be tagged as {@link Tag#FILE}. </p>
     *
     * @return The {@link FileLogInfo} value associated with this instance if
     *     {@link #isFile} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFile} is {@code false}.
     */
    public FileLogInfo getFileValue() {
        if (this._tag != Tag.FILE) {
            throw new IllegalStateException("Invalid tag: required Tag.FILE, but was Tag." + this._tag.name());
        }
        return fileValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FOLDER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#FOLDER},
     *     {@code false} otherwise.
     */
    public boolean isFolder() {
        return this._tag == Tag.FOLDER;
    }

    /**
     * Returns an instance of {@code AssetLogInfo} that has its tag set to
     * {@link Tag#FOLDER}.
     *
     * <p> Folder's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AssetLogInfo} with its tag set to {@link
     *     Tag#FOLDER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AssetLogInfo folder(FolderLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndFolder(Tag.FOLDER, value);
    }

    /**
     * Folder's details.
     *
     * <p> This instance must be tagged as {@link Tag#FOLDER}. </p>
     *
     * @return The {@link FolderLogInfo} value associated with this instance if
     *     {@link #isFolder} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFolder} is {@code false}.
     */
    public FolderLogInfo getFolderValue() {
        if (this._tag != Tag.FOLDER) {
            throw new IllegalStateException("Invalid tag: required Tag.FOLDER, but was Tag." + this._tag.name());
        }
        return folderValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PAPER_DOCUMENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PAPER_DOCUMENT}, {@code false} otherwise.
     */
    public boolean isPaperDocument() {
        return this._tag == Tag.PAPER_DOCUMENT;
    }

    /**
     * Returns an instance of {@code AssetLogInfo} that has its tag set to
     * {@link Tag#PAPER_DOCUMENT}.
     *
     * <p> Paper document's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AssetLogInfo} with its tag set to {@link
     *     Tag#PAPER_DOCUMENT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AssetLogInfo paperDocument(PaperDocumentLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndPaperDocument(Tag.PAPER_DOCUMENT, value);
    }

    /**
     * Paper document's details.
     *
     * <p> This instance must be tagged as {@link Tag#PAPER_DOCUMENT}. </p>
     *
     * @return The {@link PaperDocumentLogInfo} value associated with this
     *     instance if {@link #isPaperDocument} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPaperDocument} is {@code
     *     false}.
     */
    public PaperDocumentLogInfo getPaperDocumentValue() {
        if (this._tag != Tag.PAPER_DOCUMENT) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_DOCUMENT, but was Tag." + this._tag.name());
        }
        return paperDocumentValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PAPER_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PAPER_FOLDER}, {@code false} otherwise.
     */
    public boolean isPaperFolder() {
        return this._tag == Tag.PAPER_FOLDER;
    }

    /**
     * Returns an instance of {@code AssetLogInfo} that has its tag set to
     * {@link Tag#PAPER_FOLDER}.
     *
     * <p> Paper folder's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AssetLogInfo} with its tag set to {@link
     *     Tag#PAPER_FOLDER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AssetLogInfo paperFolder(PaperFolderLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndPaperFolder(Tag.PAPER_FOLDER, value);
    }

    /**
     * Paper folder's details.
     *
     * <p> This instance must be tagged as {@link Tag#PAPER_FOLDER}. </p>
     *
     * @return The {@link PaperFolderLogInfo} value associated with this
     *     instance if {@link #isPaperFolder} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPaperFolder} is {@code
     *     false}.
     */
    public PaperFolderLogInfo getPaperFolderValue() {
        if (this._tag != Tag.PAPER_FOLDER) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_FOLDER, but was Tag." + this._tag.name());
        }
        return paperFolderValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SHOWCASE_DOCUMENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SHOWCASE_DOCUMENT}, {@code false} otherwise.
     */
    public boolean isShowcaseDocument() {
        return this._tag == Tag.SHOWCASE_DOCUMENT;
    }

    /**
     * Returns an instance of {@code AssetLogInfo} that has its tag set to
     * {@link Tag#SHOWCASE_DOCUMENT}.
     *
     * <p> Showcase document's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AssetLogInfo} with its tag set to {@link
     *     Tag#SHOWCASE_DOCUMENT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AssetLogInfo showcaseDocument(ShowcaseDocumentLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AssetLogInfo().withTagAndShowcaseDocument(Tag.SHOWCASE_DOCUMENT, value);
    }

    /**
     * Showcase document's details.
     *
     * <p> This instance must be tagged as {@link Tag#SHOWCASE_DOCUMENT}. </p>
     *
     * @return The {@link ShowcaseDocumentLogInfo} value associated with this
     *     instance if {@link #isShowcaseDocument} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isShowcaseDocument} is {@code
     *     false}.
     */
    public ShowcaseDocumentLogInfo getShowcaseDocumentValue() {
        if (this._tag != Tag.SHOWCASE_DOCUMENT) {
            throw new IllegalStateException("Invalid tag: required Tag.SHOWCASE_DOCUMENT, but was Tag." + this._tag.name());
        }
        return showcaseDocumentValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.fileValue,
            this.folderValue,
            this.paperDocumentValue,
            this.paperFolderValue,
            this.showcaseDocumentValue
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
        else if (obj instanceof AssetLogInfo) {
            AssetLogInfo other = (AssetLogInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case FILE:
                    return (this.fileValue == other.fileValue) || (this.fileValue.equals(other.fileValue));
                case FOLDER:
                    return (this.folderValue == other.folderValue) || (this.folderValue.equals(other.folderValue));
                case PAPER_DOCUMENT:
                    return (this.paperDocumentValue == other.paperDocumentValue) || (this.paperDocumentValue.equals(other.paperDocumentValue));
                case PAPER_FOLDER:
                    return (this.paperFolderValue == other.paperFolderValue) || (this.paperFolderValue.equals(other.paperFolderValue));
                case SHOWCASE_DOCUMENT:
                    return (this.showcaseDocumentValue == other.showcaseDocumentValue) || (this.showcaseDocumentValue.equals(other.showcaseDocumentValue));
                case OTHER:
                    return true;
                default:
                    return false;
            }
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
    static class Serializer extends UnionSerializer<AssetLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AssetLogInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case FILE: {
                    g.writeStartObject();
                    writeTag("file", g);
                    FileLogInfo.Serializer.INSTANCE.serialize(value.fileValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case FOLDER: {
                    g.writeStartObject();
                    writeTag("folder", g);
                    FolderLogInfo.Serializer.INSTANCE.serialize(value.folderValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case PAPER_DOCUMENT: {
                    g.writeStartObject();
                    writeTag("paper_document", g);
                    PaperDocumentLogInfo.Serializer.INSTANCE.serialize(value.paperDocumentValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case PAPER_FOLDER: {
                    g.writeStartObject();
                    writeTag("paper_folder", g);
                    PaperFolderLogInfo.Serializer.INSTANCE.serialize(value.paperFolderValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case SHOWCASE_DOCUMENT: {
                    g.writeStartObject();
                    writeTag("showcase_document", g);
                    ShowcaseDocumentLogInfo.Serializer.INSTANCE.serialize(value.showcaseDocumentValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AssetLogInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            AssetLogInfo value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("file".equals(tag)) {
                FileLogInfo fieldValue = null;
                fieldValue = FileLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AssetLogInfo.file(fieldValue);
            }
            else if ("folder".equals(tag)) {
                FolderLogInfo fieldValue = null;
                fieldValue = FolderLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AssetLogInfo.folder(fieldValue);
            }
            else if ("paper_document".equals(tag)) {
                PaperDocumentLogInfo fieldValue = null;
                fieldValue = PaperDocumentLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AssetLogInfo.paperDocument(fieldValue);
            }
            else if ("paper_folder".equals(tag)) {
                PaperFolderLogInfo fieldValue = null;
                fieldValue = PaperFolderLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AssetLogInfo.paperFolder(fieldValue);
            }
            else if ("showcase_document".equals(tag)) {
                ShowcaseDocumentLogInfo fieldValue = null;
                fieldValue = ShowcaseDocumentLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AssetLogInfo.showcaseDocument(fieldValue);
            }
            else {
                value = AssetLogInfo.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
