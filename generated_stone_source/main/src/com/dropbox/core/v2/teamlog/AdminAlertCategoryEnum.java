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
 * Alert category
 */
public enum AdminAlertCategoryEnum {
    // union team_log.AdminAlertCategoryEnum (team_log_generated.stone)
    ACCOUNT_TAKEOVER,
    DATA_LOSS_PROTECTION,
    INFORMATION_GOVERNANCE,
    MALWARE_SHARING,
    MASSIVE_FILE_OPERATION,
    NA,
    THREAT_MANAGEMENT,
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
    static class Serializer extends UnionSerializer<AdminAlertCategoryEnum> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertCategoryEnum value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACCOUNT_TAKEOVER: {
                    g.writeString("account_takeover");
                    break;
                }
                case DATA_LOSS_PROTECTION: {
                    g.writeString("data_loss_protection");
                    break;
                }
                case INFORMATION_GOVERNANCE: {
                    g.writeString("information_governance");
                    break;
                }
                case MALWARE_SHARING: {
                    g.writeString("malware_sharing");
                    break;
                }
                case MASSIVE_FILE_OPERATION: {
                    g.writeString("massive_file_operation");
                    break;
                }
                case NA: {
                    g.writeString("na");
                    break;
                }
                case THREAT_MANAGEMENT: {
                    g.writeString("threat_management");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AdminAlertCategoryEnum deserialize(JsonParser p) throws IOException, JsonParseException {
            AdminAlertCategoryEnum value;
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
            else if ("account_takeover".equals(tag)) {
                value = AdminAlertCategoryEnum.ACCOUNT_TAKEOVER;
            }
            else if ("data_loss_protection".equals(tag)) {
                value = AdminAlertCategoryEnum.DATA_LOSS_PROTECTION;
            }
            else if ("information_governance".equals(tag)) {
                value = AdminAlertCategoryEnum.INFORMATION_GOVERNANCE;
            }
            else if ("malware_sharing".equals(tag)) {
                value = AdminAlertCategoryEnum.MALWARE_SHARING;
            }
            else if ("massive_file_operation".equals(tag)) {
                value = AdminAlertCategoryEnum.MASSIVE_FILE_OPERATION;
            }
            else if ("na".equals(tag)) {
                value = AdminAlertCategoryEnum.NA;
            }
            else if ("threat_management".equals(tag)) {
                value = AdminAlertCategoryEnum.THREAT_MANAGEMENT;
            }
            else {
                value = AdminAlertCategoryEnum.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
