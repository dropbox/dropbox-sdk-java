/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

public enum FileCategory {
    // union files.FileCategory (files.stone)
    /**
     * jpg, png, gif, and more.
     */
    IMAGE,
    /**
     * doc, docx, txt, and more.
     */
    DOCUMENT,
    /**
     * pdf.
     */
    PDF,
    /**
     * xlsx, xls, csv, and more.
     */
    SPREADSHEET,
    /**
     * ppt, pptx, key, and more.
     */
    PRESENTATION,
    /**
     * mp3, wav, mid, and more.
     */
    AUDIO,
    /**
     * mov, wmv, mp4, and more.
     */
    VIDEO,
    /**
     * dropbox folder.
     */
    FOLDER,
    /**
     * dropbox paper doc.
     */
    PAPER,
    /**
     * any file not in one of the categories above.
     */
    OTHERS,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<FileCategory> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileCategory value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case IMAGE: {
                    g.writeString("image");
                    break;
                }
                case DOCUMENT: {
                    g.writeString("document");
                    break;
                }
                case PDF: {
                    g.writeString("pdf");
                    break;
                }
                case SPREADSHEET: {
                    g.writeString("spreadsheet");
                    break;
                }
                case PRESENTATION: {
                    g.writeString("presentation");
                    break;
                }
                case AUDIO: {
                    g.writeString("audio");
                    break;
                }
                case VIDEO: {
                    g.writeString("video");
                    break;
                }
                case FOLDER: {
                    g.writeString("folder");
                    break;
                }
                case PAPER: {
                    g.writeString("paper");
                    break;
                }
                case OTHERS: {
                    g.writeString("others");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileCategory deserialize(JsonParser p) throws IOException, JsonParseException {
            FileCategory value;
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
            else if ("image".equals(tag)) {
                value = FileCategory.IMAGE;
            }
            else if ("document".equals(tag)) {
                value = FileCategory.DOCUMENT;
            }
            else if ("pdf".equals(tag)) {
                value = FileCategory.PDF;
            }
            else if ("spreadsheet".equals(tag)) {
                value = FileCategory.SPREADSHEET;
            }
            else if ("presentation".equals(tag)) {
                value = FileCategory.PRESENTATION;
            }
            else if ("audio".equals(tag)) {
                value = FileCategory.AUDIO;
            }
            else if ("video".equals(tag)) {
                value = FileCategory.VIDEO;
            }
            else if ("folder".equals(tag)) {
                value = FileCategory.FOLDER;
            }
            else if ("paper".equals(tag)) {
                value = FileCategory.PAPER;
            }
            else if ("others".equals(tag)) {
                value = FileCategory.OTHERS;
            }
            else {
                value = FileCategory.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
