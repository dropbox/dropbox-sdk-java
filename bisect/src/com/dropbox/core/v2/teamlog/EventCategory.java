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
 * Category of events in event audit log.
 */
public enum EventCategory {
    // union team_log.EventCategory (team_log_generated.stone)
    /**
     * Events that apply to management of linked apps.
     */
    APPS,
    /**
     * Events that have to do with comments on files and Paper documents.
     */
    COMMENTS,
    /**
     * Events that apply to linked devices on mobile, desktop and Web platforms.
     */
    DEVICES,
    /**
     * Events that involve domain management feature: domain verification,
     * invite enforcement and account capture.
     */
    DOMAINS,
    /**
     * Events that have to do with filesystem operations on files and folders:
     * copy, move, delete, etc.
     */
    FILE_OPERATIONS,
    /**
     * Events that apply to the file requests feature.
     */
    FILE_REQUESTS,
    /**
     * Events that involve group management.
     */
    GROUPS,
    /**
     * Events that involve placing holds on content for litigation reasons
     */
    LEGAL_HOLDS,
    /**
     * Events that involve users signing in to or out of Dropbox.
     */
    LOGINS,
    /**
     * Events that involve team member management.
     */
    MEMBERS,
    /**
     * Events that apply to Dropbox Paper.
     */
    PAPER,
    /**
     * Events that involve using, changing or resetting passwords.
     */
    PASSWORDS,
    /**
     * Events that concern generation of admin reports, including team activity
     * and device usage.
     */
    REPORTS,
    /**
     * Events that apply to all types of sharing and collaboration.
     */
    SHARING,
    /**
     * Events that apply to Dropbox Showcase.
     */
    SHOWCASE,
    /**
     * Events that involve using or configuring single sign-on as well as
     * administrative policies concerning single sign-on.
     */
    SSO,
    /**
     * Events that involve team folder management.
     */
    TEAM_FOLDERS,
    /**
     * Events that involve a change in team-wide policies.
     */
    TEAM_POLICIES,
    /**
     * Events that involve a change in the team profile.
     */
    TEAM_PROFILE,
    /**
     * Events that involve using or configuring two factor authentication as
     * well as administrative policies concerning two factor authentication.
     */
    TFA,
    /**
     * Events that apply to cross-team trust establishment.
     */
    TRUSTED_TEAMS,
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
    static class Serializer extends UnionSerializer<EventCategory> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(EventCategory value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case APPS: {
                    g.writeString("apps");
                    break;
                }
                case COMMENTS: {
                    g.writeString("comments");
                    break;
                }
                case DEVICES: {
                    g.writeString("devices");
                    break;
                }
                case DOMAINS: {
                    g.writeString("domains");
                    break;
                }
                case FILE_OPERATIONS: {
                    g.writeString("file_operations");
                    break;
                }
                case FILE_REQUESTS: {
                    g.writeString("file_requests");
                    break;
                }
                case GROUPS: {
                    g.writeString("groups");
                    break;
                }
                case LEGAL_HOLDS: {
                    g.writeString("legal_holds");
                    break;
                }
                case LOGINS: {
                    g.writeString("logins");
                    break;
                }
                case MEMBERS: {
                    g.writeString("members");
                    break;
                }
                case PAPER: {
                    g.writeString("paper");
                    break;
                }
                case PASSWORDS: {
                    g.writeString("passwords");
                    break;
                }
                case REPORTS: {
                    g.writeString("reports");
                    break;
                }
                case SHARING: {
                    g.writeString("sharing");
                    break;
                }
                case SHOWCASE: {
                    g.writeString("showcase");
                    break;
                }
                case SSO: {
                    g.writeString("sso");
                    break;
                }
                case TEAM_FOLDERS: {
                    g.writeString("team_folders");
                    break;
                }
                case TEAM_POLICIES: {
                    g.writeString("team_policies");
                    break;
                }
                case TEAM_PROFILE: {
                    g.writeString("team_profile");
                    break;
                }
                case TFA: {
                    g.writeString("tfa");
                    break;
                }
                case TRUSTED_TEAMS: {
                    g.writeString("trusted_teams");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public EventCategory deserialize(JsonParser p) throws IOException, JsonParseException {
            EventCategory value;
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
            else if ("apps".equals(tag)) {
                value = EventCategory.APPS;
            }
            else if ("comments".equals(tag)) {
                value = EventCategory.COMMENTS;
            }
            else if ("devices".equals(tag)) {
                value = EventCategory.DEVICES;
            }
            else if ("domains".equals(tag)) {
                value = EventCategory.DOMAINS;
            }
            else if ("file_operations".equals(tag)) {
                value = EventCategory.FILE_OPERATIONS;
            }
            else if ("file_requests".equals(tag)) {
                value = EventCategory.FILE_REQUESTS;
            }
            else if ("groups".equals(tag)) {
                value = EventCategory.GROUPS;
            }
            else if ("legal_holds".equals(tag)) {
                value = EventCategory.LEGAL_HOLDS;
            }
            else if ("logins".equals(tag)) {
                value = EventCategory.LOGINS;
            }
            else if ("members".equals(tag)) {
                value = EventCategory.MEMBERS;
            }
            else if ("paper".equals(tag)) {
                value = EventCategory.PAPER;
            }
            else if ("passwords".equals(tag)) {
                value = EventCategory.PASSWORDS;
            }
            else if ("reports".equals(tag)) {
                value = EventCategory.REPORTS;
            }
            else if ("sharing".equals(tag)) {
                value = EventCategory.SHARING;
            }
            else if ("showcase".equals(tag)) {
                value = EventCategory.SHOWCASE;
            }
            else if ("sso".equals(tag)) {
                value = EventCategory.SSO;
            }
            else if ("team_folders".equals(tag)) {
                value = EventCategory.TEAM_FOLDERS;
            }
            else if ("team_policies".equals(tag)) {
                value = EventCategory.TEAM_POLICIES;
            }
            else if ("team_profile".equals(tag)) {
                value = EventCategory.TEAM_PROFILE;
            }
            else if ("tfa".equals(tag)) {
                value = EventCategory.TFA;
            }
            else if ("trusted_teams".equals(tag)) {
                value = EventCategory.TRUSTED_TEAMS;
            }
            else {
                value = EventCategory.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
