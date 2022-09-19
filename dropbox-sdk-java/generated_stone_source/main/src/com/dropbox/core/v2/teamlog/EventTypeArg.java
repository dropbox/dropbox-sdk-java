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
 * The type of the event.
 */
public enum EventTypeArg {
    // union team_log.EventTypeArg (team_log_generated.stone)
    /**
     * (admin_alerting) Changed an alert state
     */
    ADMIN_ALERTING_ALERT_STATE_CHANGED,
    /**
     * (admin_alerting) Changed an alert setting
     */
    ADMIN_ALERTING_CHANGED_ALERT_CONFIG,
    /**
     * (admin_alerting) Triggered security alert
     */
    ADMIN_ALERTING_TRIGGERED_ALERT,
    /**
     * (apps) Failed to connect app for member
     */
    APP_BLOCKED_BY_PERMISSIONS,
    /**
     * (apps) Linked app for team
     */
    APP_LINK_TEAM,
    /**
     * (apps) Linked app for member
     */
    APP_LINK_USER,
    /**
     * (apps) Unlinked app for team
     */
    APP_UNLINK_TEAM,
    /**
     * (apps) Unlinked app for member
     */
    APP_UNLINK_USER,
    /**
     * (apps) Connected integration for member
     */
    INTEGRATION_CONNECTED,
    /**
     * (apps) Disconnected integration for member
     */
    INTEGRATION_DISCONNECTED,
    /**
     * (comments) Added file comment
     */
    FILE_ADD_COMMENT,
    /**
     * (comments) Subscribed to or unsubscribed from comment notifications for
     * file
     */
    FILE_CHANGE_COMMENT_SUBSCRIPTION,
    /**
     * (comments) Deleted file comment
     */
    FILE_DELETE_COMMENT,
    /**
     * (comments) Edited file comment
     */
    FILE_EDIT_COMMENT,
    /**
     * (comments) Liked file comment (deprecated, no longer logged)
     */
    FILE_LIKE_COMMENT,
    /**
     * (comments) Resolved file comment
     */
    FILE_RESOLVE_COMMENT,
    /**
     * (comments) Unliked file comment (deprecated, no longer logged)
     */
    FILE_UNLIKE_COMMENT,
    /**
     * (comments) Unresolved file comment
     */
    FILE_UNRESOLVE_COMMENT,
    /**
     * (data_governance) Added folders to policy
     */
    GOVERNANCE_POLICY_ADD_FOLDERS,
    /**
     * (data_governance) Couldn't add a folder to a policy
     */
    GOVERNANCE_POLICY_ADD_FOLDER_FAILED,
    /**
     * (data_governance) Content disposed
     */
    GOVERNANCE_POLICY_CONTENT_DISPOSED,
    /**
     * (data_governance) Activated a new policy
     */
    GOVERNANCE_POLICY_CREATE,
    /**
     * (data_governance) Deleted a policy
     */
    GOVERNANCE_POLICY_DELETE,
    /**
     * (data_governance) Edited policy
     */
    GOVERNANCE_POLICY_EDIT_DETAILS,
    /**
     * (data_governance) Changed policy duration
     */
    GOVERNANCE_POLICY_EDIT_DURATION,
    /**
     * (data_governance) Created a policy download
     */
    GOVERNANCE_POLICY_EXPORT_CREATED,
    /**
     * (data_governance) Removed a policy download
     */
    GOVERNANCE_POLICY_EXPORT_REMOVED,
    /**
     * (data_governance) Removed folders from policy
     */
    GOVERNANCE_POLICY_REMOVE_FOLDERS,
    /**
     * (data_governance) Created a summary report for a policy
     */
    GOVERNANCE_POLICY_REPORT_CREATED,
    /**
     * (data_governance) Downloaded content from a policy
     */
    GOVERNANCE_POLICY_ZIP_PART_DOWNLOADED,
    /**
     * (data_governance) Activated a hold
     */
    LEGAL_HOLDS_ACTIVATE_A_HOLD,
    /**
     * (data_governance) Added members to a hold
     */
    LEGAL_HOLDS_ADD_MEMBERS,
    /**
     * (data_governance) Edited details for a hold
     */
    LEGAL_HOLDS_CHANGE_HOLD_DETAILS,
    /**
     * (data_governance) Renamed a hold
     */
    LEGAL_HOLDS_CHANGE_HOLD_NAME,
    /**
     * (data_governance) Exported hold
     */
    LEGAL_HOLDS_EXPORT_A_HOLD,
    /**
     * (data_governance) Canceled export for a hold
     */
    LEGAL_HOLDS_EXPORT_CANCELLED,
    /**
     * (data_governance) Downloaded export for a hold
     */
    LEGAL_HOLDS_EXPORT_DOWNLOADED,
    /**
     * (data_governance) Removed export for a hold
     */
    LEGAL_HOLDS_EXPORT_REMOVED,
    /**
     * (data_governance) Released a hold
     */
    LEGAL_HOLDS_RELEASE_A_HOLD,
    /**
     * (data_governance) Removed members from a hold
     */
    LEGAL_HOLDS_REMOVE_MEMBERS,
    /**
     * (data_governance) Created a summary report for a hold
     */
    LEGAL_HOLDS_REPORT_A_HOLD,
    /**
     * (devices) Changed IP address associated with active desktop session
     */
    DEVICE_CHANGE_IP_DESKTOP,
    /**
     * (devices) Changed IP address associated with active mobile session
     */
    DEVICE_CHANGE_IP_MOBILE,
    /**
     * (devices) Changed IP address associated with active web session
     */
    DEVICE_CHANGE_IP_WEB,
    /**
     * (devices) Failed to delete all files from unlinked device
     */
    DEVICE_DELETE_ON_UNLINK_FAIL,
    /**
     * (devices) Deleted all files from unlinked device
     */
    DEVICE_DELETE_ON_UNLINK_SUCCESS,
    /**
     * (devices) Failed to link device
     */
    DEVICE_LINK_FAIL,
    /**
     * (devices) Linked device
     */
    DEVICE_LINK_SUCCESS,
    /**
     * (devices) Disabled device management (deprecated, no longer logged)
     */
    DEVICE_MANAGEMENT_DISABLED,
    /**
     * (devices) Enabled device management (deprecated, no longer logged)
     */
    DEVICE_MANAGEMENT_ENABLED,
    /**
     * (devices) Enabled/disabled backup for computer
     */
    DEVICE_SYNC_BACKUP_STATUS_CHANGED,
    /**
     * (devices) Disconnected device
     */
    DEVICE_UNLINK,
    /**
     * (devices) Exported passwords
     */
    DROPBOX_PASSWORDS_EXPORTED,
    /**
     * (devices) Enrolled new Dropbox Passwords device
     */
    DROPBOX_PASSWORDS_NEW_DEVICE_ENROLLED,
    /**
     * (devices) Refreshed auth token used for setting up EMM
     */
    EMM_REFRESH_AUTH_TOKEN,
    /**
     * (devices) Checked external drive backup eligibility status
     */
    EXTERNAL_DRIVE_BACKUP_ELIGIBILITY_STATUS_CHECKED,
    /**
     * (devices) Modified external drive backup
     */
    EXTERNAL_DRIVE_BACKUP_STATUS_CHANGED,
    /**
     * (domains) Granted/revoked option to enable account capture on team
     * domains
     */
    ACCOUNT_CAPTURE_CHANGE_AVAILABILITY,
    /**
     * (domains) Account-captured user migrated account to team
     */
    ACCOUNT_CAPTURE_MIGRATE_ACCOUNT,
    /**
     * (domains) Sent account capture email to all unmanaged members
     */
    ACCOUNT_CAPTURE_NOTIFICATION_EMAILS_SENT,
    /**
     * (domains) Account-captured user changed account email to personal email
     */
    ACCOUNT_CAPTURE_RELINQUISH_ACCOUNT,
    /**
     * (domains) Disabled domain invites (deprecated, no longer logged)
     */
    DISABLED_DOMAIN_INVITES,
    /**
     * (domains) Approved user's request to join team
     */
    DOMAIN_INVITES_APPROVE_REQUEST_TO_JOIN_TEAM,
    /**
     * (domains) Declined user's request to join team
     */
    DOMAIN_INVITES_DECLINE_REQUEST_TO_JOIN_TEAM,
    /**
     * (domains) Sent domain invites to existing domain accounts (deprecated, no
     * longer logged)
     */
    DOMAIN_INVITES_EMAIL_EXISTING_USERS,
    /**
     * (domains) Requested to join team
     */
    DOMAIN_INVITES_REQUEST_TO_JOIN_TEAM,
    /**
     * (domains) Disabled "Automatically invite new users" (deprecated, no
     * longer logged)
     */
    DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_NO,
    /**
     * (domains) Enabled "Automatically invite new users" (deprecated, no longer
     * logged)
     */
    DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_YES,
    /**
     * (domains) Failed to verify team domain
     */
    DOMAIN_VERIFICATION_ADD_DOMAIN_FAIL,
    /**
     * (domains) Verified team domain
     */
    DOMAIN_VERIFICATION_ADD_DOMAIN_SUCCESS,
    /**
     * (domains) Removed domain from list of verified team domains
     */
    DOMAIN_VERIFICATION_REMOVE_DOMAIN,
    /**
     * (domains) Enabled domain invites (deprecated, no longer logged)
     */
    ENABLED_DOMAIN_INVITES,
    /**
     * (file_operations) Applied naming convention
     */
    APPLY_NAMING_CONVENTION,
    /**
     * (file_operations) Created folders (deprecated, no longer logged)
     */
    CREATE_FOLDER,
    /**
     * (file_operations) Added files and/or folders
     */
    FILE_ADD,
    /**
     * (file_operations) Copied files and/or folders
     */
    FILE_COPY,
    /**
     * (file_operations) Deleted files and/or folders
     */
    FILE_DELETE,
    /**
     * (file_operations) Downloaded files and/or folders
     */
    FILE_DOWNLOAD,
    /**
     * (file_operations) Edited files
     */
    FILE_EDIT,
    /**
     * (file_operations) Created copy reference to file/folder
     */
    FILE_GET_COPY_REFERENCE,
    /**
     * (file_operations) Locked/unlocked editing for a file
     */
    FILE_LOCKING_LOCK_STATUS_CHANGED,
    /**
     * (file_operations) Moved files and/or folders
     */
    FILE_MOVE,
    /**
     * (file_operations) Permanently deleted files and/or folders
     */
    FILE_PERMANENTLY_DELETE,
    /**
     * (file_operations) Previewed files and/or folders
     */
    FILE_PREVIEW,
    /**
     * (file_operations) Renamed files and/or folders
     */
    FILE_RENAME,
    /**
     * (file_operations) Restored deleted files and/or folders
     */
    FILE_RESTORE,
    /**
     * (file_operations) Reverted files to previous version
     */
    FILE_REVERT,
    /**
     * (file_operations) Rolled back file actions
     */
    FILE_ROLLBACK_CHANGES,
    /**
     * (file_operations) Saved file/folder using copy reference
     */
    FILE_SAVE_COPY_REFERENCE,
    /**
     * (file_operations) Updated folder overview
     */
    FOLDER_OVERVIEW_DESCRIPTION_CHANGED,
    /**
     * (file_operations) Pinned item to folder overview
     */
    FOLDER_OVERVIEW_ITEM_PINNED,
    /**
     * (file_operations) Unpinned item from folder overview
     */
    FOLDER_OVERVIEW_ITEM_UNPINNED,
    /**
     * (file_operations) Added a label
     */
    OBJECT_LABEL_ADDED,
    /**
     * (file_operations) Removed a label
     */
    OBJECT_LABEL_REMOVED,
    /**
     * (file_operations) Updated a label's value
     */
    OBJECT_LABEL_UPDATED_VALUE,
    /**
     * (file_operations) Organized a folder with multi-file organize
     */
    ORGANIZE_FOLDER_WITH_TIDY,
    /**
     * (file_operations) Rewound a folder
     */
    REWIND_FOLDER,
    /**
     * (file_operations) Reverted naming convention
     */
    UNDO_NAMING_CONVENTION,
    /**
     * (file_operations) Removed multi-file organize
     */
    UNDO_ORGANIZE_FOLDER_WITH_TIDY,
    /**
     * (file_operations) Tagged a file
     */
    USER_TAGS_ADDED,
    /**
     * (file_operations) Removed tags
     */
    USER_TAGS_REMOVED,
    /**
     * (file_requests) Received files via Email to Dropbox
     */
    EMAIL_INGEST_RECEIVE_FILE,
    /**
     * (file_requests) Changed file request
     */
    FILE_REQUEST_CHANGE,
    /**
     * (file_requests) Closed file request
     */
    FILE_REQUEST_CLOSE,
    /**
     * (file_requests) Created file request
     */
    FILE_REQUEST_CREATE,
    /**
     * (file_requests) Delete file request
     */
    FILE_REQUEST_DELETE,
    /**
     * (file_requests) Received files for file request
     */
    FILE_REQUEST_RECEIVE_FILE,
    /**
     * (groups) Added external ID for group
     */
    GROUP_ADD_EXTERNAL_ID,
    /**
     * (groups) Added team members to group
     */
    GROUP_ADD_MEMBER,
    /**
     * (groups) Changed external ID for group
     */
    GROUP_CHANGE_EXTERNAL_ID,
    /**
     * (groups) Changed group management type
     */
    GROUP_CHANGE_MANAGEMENT_TYPE,
    /**
     * (groups) Changed manager permissions of group member
     */
    GROUP_CHANGE_MEMBER_ROLE,
    /**
     * (groups) Created group
     */
    GROUP_CREATE,
    /**
     * (groups) Deleted group
     */
    GROUP_DELETE,
    /**
     * (groups) Updated group (deprecated, no longer logged)
     */
    GROUP_DESCRIPTION_UPDATED,
    /**
     * (groups) Updated group join policy (deprecated, no longer logged)
     */
    GROUP_JOIN_POLICY_UPDATED,
    /**
     * (groups) Moved group (deprecated, no longer logged)
     */
    GROUP_MOVED,
    /**
     * (groups) Removed external ID for group
     */
    GROUP_REMOVE_EXTERNAL_ID,
    /**
     * (groups) Removed team members from group
     */
    GROUP_REMOVE_MEMBER,
    /**
     * (groups) Renamed group
     */
    GROUP_RENAME,
    /**
     * (logins) Unlocked/locked account after failed sign in attempts
     */
    ACCOUNT_LOCK_OR_UNLOCKED,
    /**
     * (logins) Failed to sign in via EMM (deprecated, replaced by 'Failed to
     * sign in')
     */
    EMM_ERROR,
    /**
     * (logins) Started trusted team admin session
     */
    GUEST_ADMIN_SIGNED_IN_VIA_TRUSTED_TEAMS,
    /**
     * (logins) Ended trusted team admin session
     */
    GUEST_ADMIN_SIGNED_OUT_VIA_TRUSTED_TEAMS,
    /**
     * (logins) Failed to sign in
     */
    LOGIN_FAIL,
    /**
     * (logins) Signed in
     */
    LOGIN_SUCCESS,
    /**
     * (logins) Signed out
     */
    LOGOUT,
    /**
     * (logins) Ended reseller support session
     */
    RESELLER_SUPPORT_SESSION_END,
    /**
     * (logins) Started reseller support session
     */
    RESELLER_SUPPORT_SESSION_START,
    /**
     * (logins) Ended admin sign-in-as session
     */
    SIGN_IN_AS_SESSION_END,
    /**
     * (logins) Started admin sign-in-as session
     */
    SIGN_IN_AS_SESSION_START,
    /**
     * (logins) Failed to sign in via SSO (deprecated, replaced by 'Failed to
     * sign in')
     */
    SSO_ERROR,
    /**
     * (members) Created team invite link
     */
    CREATE_TEAM_INVITE_LINK,
    /**
     * (members) Deleted team invite link
     */
    DELETE_TEAM_INVITE_LINK,
    /**
     * (members) Added an external ID for team member
     */
    MEMBER_ADD_EXTERNAL_ID,
    /**
     * (members) Added team member name
     */
    MEMBER_ADD_NAME,
    /**
     * (members) Changed team member admin role
     */
    MEMBER_CHANGE_ADMIN_ROLE,
    /**
     * (members) Changed team member email
     */
    MEMBER_CHANGE_EMAIL,
    /**
     * (members) Changed the external ID for team member
     */
    MEMBER_CHANGE_EXTERNAL_ID,
    /**
     * (members) Changed membership type (limited/full) of member (deprecated,
     * no longer logged)
     */
    MEMBER_CHANGE_MEMBERSHIP_TYPE,
    /**
     * (members) Changed team member name
     */
    MEMBER_CHANGE_NAME,
    /**
     * (members) Changed team member reseller role
     */
    MEMBER_CHANGE_RESELLER_ROLE,
    /**
     * (members) Changed member status (invited, joined, suspended, etc.)
     */
    MEMBER_CHANGE_STATUS,
    /**
     * (members) Cleared manually added contacts
     */
    MEMBER_DELETE_MANUAL_CONTACTS,
    /**
     * (members) Deleted team member profile photo
     */
    MEMBER_DELETE_PROFILE_PHOTO,
    /**
     * (members) Permanently deleted contents of deleted team member account
     */
    MEMBER_PERMANENTLY_DELETE_ACCOUNT_CONTENTS,
    /**
     * (members) Removed the external ID for team member
     */
    MEMBER_REMOVE_EXTERNAL_ID,
    /**
     * (members) Set team member profile photo
     */
    MEMBER_SET_PROFILE_PHOTO,
    /**
     * (members) Set custom member space limit
     */
    MEMBER_SPACE_LIMITS_ADD_CUSTOM_QUOTA,
    /**
     * (members) Changed custom member space limit
     */
    MEMBER_SPACE_LIMITS_CHANGE_CUSTOM_QUOTA,
    /**
     * (members) Changed space limit status
     */
    MEMBER_SPACE_LIMITS_CHANGE_STATUS,
    /**
     * (members) Removed custom member space limit
     */
    MEMBER_SPACE_LIMITS_REMOVE_CUSTOM_QUOTA,
    /**
     * (members) Suggested person to add to team
     */
    MEMBER_SUGGEST,
    /**
     * (members) Transferred contents of deleted member account to another
     * member
     */
    MEMBER_TRANSFER_ACCOUNT_CONTENTS,
    /**
     * (members) Added pending secondary email
     */
    PENDING_SECONDARY_EMAIL_ADDED,
    /**
     * (members) Deleted secondary email
     */
    SECONDARY_EMAIL_DELETED,
    /**
     * (members) Verified secondary email
     */
    SECONDARY_EMAIL_VERIFIED,
    /**
     * (members) Secondary mails policy changed
     */
    SECONDARY_MAILS_POLICY_CHANGED,
    /**
     * (paper) Added Binder page (deprecated, replaced by 'Edited files')
     */
    BINDER_ADD_PAGE,
    /**
     * (paper) Added Binder section (deprecated, replaced by 'Edited files')
     */
    BINDER_ADD_SECTION,
    /**
     * (paper) Removed Binder page (deprecated, replaced by 'Edited files')
     */
    BINDER_REMOVE_PAGE,
    /**
     * (paper) Removed Binder section (deprecated, replaced by 'Edited files')
     */
    BINDER_REMOVE_SECTION,
    /**
     * (paper) Renamed Binder page (deprecated, replaced by 'Edited files')
     */
    BINDER_RENAME_PAGE,
    /**
     * (paper) Renamed Binder section (deprecated, replaced by 'Edited files')
     */
    BINDER_RENAME_SECTION,
    /**
     * (paper) Reordered Binder page (deprecated, replaced by 'Edited files')
     */
    BINDER_REORDER_PAGE,
    /**
     * (paper) Reordered Binder section (deprecated, replaced by 'Edited files')
     */
    BINDER_REORDER_SECTION,
    /**
     * (paper) Added users and/or groups to Paper doc/folder
     */
    PAPER_CONTENT_ADD_MEMBER,
    /**
     * (paper) Added Paper doc/folder to folder
     */
    PAPER_CONTENT_ADD_TO_FOLDER,
    /**
     * (paper) Archived Paper doc/folder
     */
    PAPER_CONTENT_ARCHIVE,
    /**
     * (paper) Created Paper doc/folder
     */
    PAPER_CONTENT_CREATE,
    /**
     * (paper) Permanently deleted Paper doc/folder
     */
    PAPER_CONTENT_PERMANENTLY_DELETE,
    /**
     * (paper) Removed Paper doc/folder from folder
     */
    PAPER_CONTENT_REMOVE_FROM_FOLDER,
    /**
     * (paper) Removed users and/or groups from Paper doc/folder
     */
    PAPER_CONTENT_REMOVE_MEMBER,
    /**
     * (paper) Renamed Paper doc/folder
     */
    PAPER_CONTENT_RENAME,
    /**
     * (paper) Restored archived Paper doc/folder
     */
    PAPER_CONTENT_RESTORE,
    /**
     * (paper) Added Paper doc comment
     */
    PAPER_DOC_ADD_COMMENT,
    /**
     * (paper) Changed member permissions for Paper doc
     */
    PAPER_DOC_CHANGE_MEMBER_ROLE,
    /**
     * (paper) Changed sharing setting for Paper doc
     */
    PAPER_DOC_CHANGE_SHARING_POLICY,
    /**
     * (paper) Followed/unfollowed Paper doc
     */
    PAPER_DOC_CHANGE_SUBSCRIPTION,
    /**
     * (paper) Archived Paper doc (deprecated, no longer logged)
     */
    PAPER_DOC_DELETED,
    /**
     * (paper) Deleted Paper doc comment
     */
    PAPER_DOC_DELETE_COMMENT,
    /**
     * (paper) Downloaded Paper doc in specific format
     */
    PAPER_DOC_DOWNLOAD,
    /**
     * (paper) Edited Paper doc
     */
    PAPER_DOC_EDIT,
    /**
     * (paper) Edited Paper doc comment
     */
    PAPER_DOC_EDIT_COMMENT,
    /**
     * (paper) Followed Paper doc (deprecated, replaced by 'Followed/unfollowed
     * Paper doc')
     */
    PAPER_DOC_FOLLOWED,
    /**
     * (paper) Mentioned user in Paper doc
     */
    PAPER_DOC_MENTION,
    /**
     * (paper) Transferred ownership of Paper doc
     */
    PAPER_DOC_OWNERSHIP_CHANGED,
    /**
     * (paper) Requested access to Paper doc
     */
    PAPER_DOC_REQUEST_ACCESS,
    /**
     * (paper) Resolved Paper doc comment
     */
    PAPER_DOC_RESOLVE_COMMENT,
    /**
     * (paper) Restored Paper doc to previous version
     */
    PAPER_DOC_REVERT,
    /**
     * (paper) Shared Paper doc via Slack
     */
    PAPER_DOC_SLACK_SHARE,
    /**
     * (paper) Shared Paper doc with users and/or groups (deprecated, no longer
     * logged)
     */
    PAPER_DOC_TEAM_INVITE,
    /**
     * (paper) Deleted Paper doc
     */
    PAPER_DOC_TRASHED,
    /**
     * (paper) Unresolved Paper doc comment
     */
    PAPER_DOC_UNRESOLVE_COMMENT,
    /**
     * (paper) Restored Paper doc
     */
    PAPER_DOC_UNTRASHED,
    /**
     * (paper) Viewed Paper doc
     */
    PAPER_DOC_VIEW,
    /**
     * (paper) Changed Paper external sharing setting to anyone (deprecated, no
     * longer logged)
     */
    PAPER_EXTERNAL_VIEW_ALLOW,
    /**
     * (paper) Changed Paper external sharing setting to default team
     * (deprecated, no longer logged)
     */
    PAPER_EXTERNAL_VIEW_DEFAULT_TEAM,
    /**
     * (paper) Changed Paper external sharing setting to team-only (deprecated,
     * no longer logged)
     */
    PAPER_EXTERNAL_VIEW_FORBID,
    /**
     * (paper) Followed/unfollowed Paper folder
     */
    PAPER_FOLDER_CHANGE_SUBSCRIPTION,
    /**
     * (paper) Archived Paper folder (deprecated, no longer logged)
     */
    PAPER_FOLDER_DELETED,
    /**
     * (paper) Followed Paper folder (deprecated, replaced by
     * 'Followed/unfollowed Paper folder')
     */
    PAPER_FOLDER_FOLLOWED,
    /**
     * (paper) Shared Paper folder with users and/or groups (deprecated, no
     * longer logged)
     */
    PAPER_FOLDER_TEAM_INVITE,
    /**
     * (paper) Changed permissions for published doc
     */
    PAPER_PUBLISHED_LINK_CHANGE_PERMISSION,
    /**
     * (paper) Published doc
     */
    PAPER_PUBLISHED_LINK_CREATE,
    /**
     * (paper) Unpublished doc
     */
    PAPER_PUBLISHED_LINK_DISABLED,
    /**
     * (paper) Viewed published doc
     */
    PAPER_PUBLISHED_LINK_VIEW,
    /**
     * (passwords) Changed password
     */
    PASSWORD_CHANGE,
    /**
     * (passwords) Reset password
     */
    PASSWORD_RESET,
    /**
     * (passwords) Reset all team member passwords
     */
    PASSWORD_RESET_ALL,
    /**
     * (reports) Created Classification report
     */
    CLASSIFICATION_CREATE_REPORT,
    /**
     * (reports) Couldn't create Classification report
     */
    CLASSIFICATION_CREATE_REPORT_FAIL,
    /**
     * (reports) Created EMM-excluded users report
     */
    EMM_CREATE_EXCEPTIONS_REPORT,
    /**
     * (reports) Created EMM mobile app usage report
     */
    EMM_CREATE_USAGE_REPORT,
    /**
     * (reports) Created member data report
     */
    EXPORT_MEMBERS_REPORT,
    /**
     * (reports) Failed to create members data report
     */
    EXPORT_MEMBERS_REPORT_FAIL,
    /**
     * (reports) Created External sharing report
     */
    EXTERNAL_SHARING_CREATE_REPORT,
    /**
     * (reports) Couldn't create External sharing report
     */
    EXTERNAL_SHARING_REPORT_FAILED,
    /**
     * (reports) Report created: Links created with no expiration
     */
    NO_EXPIRATION_LINK_GEN_CREATE_REPORT,
    /**
     * (reports) Couldn't create report: Links created with no expiration
     */
    NO_EXPIRATION_LINK_GEN_REPORT_FAILED,
    /**
     * (reports) Report created: Links created without passwords
     */
    NO_PASSWORD_LINK_GEN_CREATE_REPORT,
    /**
     * (reports) Couldn't create report: Links created without passwords
     */
    NO_PASSWORD_LINK_GEN_REPORT_FAILED,
    /**
     * (reports) Report created: Views of links without passwords
     */
    NO_PASSWORD_LINK_VIEW_CREATE_REPORT,
    /**
     * (reports) Couldn't create report: Views of links without passwords
     */
    NO_PASSWORD_LINK_VIEW_REPORT_FAILED,
    /**
     * (reports) Report created: Views of old links
     */
    OUTDATED_LINK_VIEW_CREATE_REPORT,
    /**
     * (reports) Couldn't create report: Views of old links
     */
    OUTDATED_LINK_VIEW_REPORT_FAILED,
    /**
     * (reports) Exported all team Paper docs
     */
    PAPER_ADMIN_EXPORT_START,
    /**
     * (reports) Created Smart Sync non-admin devices report
     */
    SMART_SYNC_CREATE_ADMIN_PRIVILEGE_REPORT,
    /**
     * (reports) Created team activity report
     */
    TEAM_ACTIVITY_CREATE_REPORT,
    /**
     * (reports) Couldn't generate team activity report
     */
    TEAM_ACTIVITY_CREATE_REPORT_FAIL,
    /**
     * (sharing) Shared album
     */
    COLLECTION_SHARE,
    /**
     * (sharing) Transfer files added
     */
    FILE_TRANSFERS_FILE_ADD,
    /**
     * (sharing) Deleted transfer
     */
    FILE_TRANSFERS_TRANSFER_DELETE,
    /**
     * (sharing) Transfer downloaded
     */
    FILE_TRANSFERS_TRANSFER_DOWNLOAD,
    /**
     * (sharing) Sent transfer
     */
    FILE_TRANSFERS_TRANSFER_SEND,
    /**
     * (sharing) Viewed transfer
     */
    FILE_TRANSFERS_TRANSFER_VIEW,
    /**
     * (sharing) Changed Paper doc to invite-only (deprecated, no longer logged)
     */
    NOTE_ACL_INVITE_ONLY,
    /**
     * (sharing) Changed Paper doc to link-accessible (deprecated, no longer
     * logged)
     */
    NOTE_ACL_LINK,
    /**
     * (sharing) Changed Paper doc to link-accessible for team (deprecated, no
     * longer logged)
     */
    NOTE_ACL_TEAM_LINK,
    /**
     * (sharing) Shared Paper doc (deprecated, no longer logged)
     */
    NOTE_SHARED,
    /**
     * (sharing) Shared received Paper doc (deprecated, no longer logged)
     */
    NOTE_SHARE_RECEIVE,
    /**
     * (sharing) Opened shared Paper doc (deprecated, no longer logged)
     */
    OPEN_NOTE_SHARED,
    /**
     * (sharing) Added team to shared folder (deprecated, no longer logged)
     */
    SF_ADD_GROUP,
    /**
     * (sharing) Allowed non-collaborators to view links to files in shared
     * folder (deprecated, no longer logged)
     */
    SF_ALLOW_NON_MEMBERS_TO_VIEW_SHARED_LINKS,
    /**
     * (sharing) Set team members to see warning before sharing folders outside
     * team (deprecated, no longer logged)
     */
    SF_EXTERNAL_INVITE_WARN,
    /**
     * (sharing) Invited Facebook users to shared folder (deprecated, no longer
     * logged)
     */
    SF_FB_INVITE,
    /**
     * (sharing) Changed Facebook user's role in shared folder (deprecated, no
     * longer logged)
     */
    SF_FB_INVITE_CHANGE_ROLE,
    /**
     * (sharing) Uninvited Facebook user from shared folder (deprecated, no
     * longer logged)
     */
    SF_FB_UNINVITE,
    /**
     * (sharing) Invited group to shared folder (deprecated, no longer logged)
     */
    SF_INVITE_GROUP,
    /**
     * (sharing) Granted access to shared folder (deprecated, no longer logged)
     */
    SF_TEAM_GRANT_ACCESS,
    /**
     * (sharing) Invited team members to shared folder (deprecated, replaced by
     * 'Invited user to Dropbox and added them to shared file/folder')
     */
    SF_TEAM_INVITE,
    /**
     * (sharing) Changed team member's role in shared folder (deprecated, no
     * longer logged)
     */
    SF_TEAM_INVITE_CHANGE_ROLE,
    /**
     * (sharing) Joined team member's shared folder (deprecated, no longer
     * logged)
     */
    SF_TEAM_JOIN,
    /**
     * (sharing) Joined team member's shared folder from link (deprecated, no
     * longer logged)
     */
    SF_TEAM_JOIN_FROM_OOB_LINK,
    /**
     * (sharing) Unshared folder with team member (deprecated, replaced by
     * 'Removed invitee from shared file/folder before invite was accepted')
     */
    SF_TEAM_UNINVITE,
    /**
     * (sharing) Invited user to Dropbox and added them to shared file/folder
     */
    SHARED_CONTENT_ADD_INVITEES,
    /**
     * (sharing) Added expiration date to link for shared file/folder
     * (deprecated, no longer logged)
     */
    SHARED_CONTENT_ADD_LINK_EXPIRY,
    /**
     * (sharing) Added password to link for shared file/folder (deprecated, no
     * longer logged)
     */
    SHARED_CONTENT_ADD_LINK_PASSWORD,
    /**
     * (sharing) Added users and/or groups to shared file/folder
     */
    SHARED_CONTENT_ADD_MEMBER,
    /**
     * (sharing) Changed whether members can download shared file/folder
     * (deprecated, no longer logged)
     */
    SHARED_CONTENT_CHANGE_DOWNLOADS_POLICY,
    /**
     * (sharing) Changed access type of invitee to shared file/folder before
     * invite was accepted
     */
    SHARED_CONTENT_CHANGE_INVITEE_ROLE,
    /**
     * (sharing) Changed link audience of shared file/folder (deprecated, no
     * longer logged)
     */
    SHARED_CONTENT_CHANGE_LINK_AUDIENCE,
    /**
     * (sharing) Changed link expiration of shared file/folder (deprecated, no
     * longer logged)
     */
    SHARED_CONTENT_CHANGE_LINK_EXPIRY,
    /**
     * (sharing) Changed link password of shared file/folder (deprecated, no
     * longer logged)
     */
    SHARED_CONTENT_CHANGE_LINK_PASSWORD,
    /**
     * (sharing) Changed access type of shared file/folder member
     */
    SHARED_CONTENT_CHANGE_MEMBER_ROLE,
    /**
     * (sharing) Changed whether members can see who viewed shared file/folder
     */
    SHARED_CONTENT_CHANGE_VIEWER_INFO_POLICY,
    /**
     * (sharing) Acquired membership of shared file/folder by accepting invite
     */
    SHARED_CONTENT_CLAIM_INVITATION,
    /**
     * (sharing) Copied shared file/folder to own Dropbox
     */
    SHARED_CONTENT_COPY,
    /**
     * (sharing) Downloaded shared file/folder
     */
    SHARED_CONTENT_DOWNLOAD,
    /**
     * (sharing) Left shared file/folder
     */
    SHARED_CONTENT_RELINQUISH_MEMBERSHIP,
    /**
     * (sharing) Removed invitee from shared file/folder before invite was
     * accepted
     */
    SHARED_CONTENT_REMOVE_INVITEES,
    /**
     * (sharing) Removed link expiration date of shared file/folder (deprecated,
     * no longer logged)
     */
    SHARED_CONTENT_REMOVE_LINK_EXPIRY,
    /**
     * (sharing) Removed link password of shared file/folder (deprecated, no
     * longer logged)
     */
    SHARED_CONTENT_REMOVE_LINK_PASSWORD,
    /**
     * (sharing) Removed user/group from shared file/folder
     */
    SHARED_CONTENT_REMOVE_MEMBER,
    /**
     * (sharing) Requested access to shared file/folder
     */
    SHARED_CONTENT_REQUEST_ACCESS,
    /**
     * (sharing) Restored shared file/folder invitees
     */
    SHARED_CONTENT_RESTORE_INVITEES,
    /**
     * (sharing) Restored users and/or groups to membership of shared
     * file/folder
     */
    SHARED_CONTENT_RESTORE_MEMBER,
    /**
     * (sharing) Unshared file/folder by clearing membership
     */
    SHARED_CONTENT_UNSHARE,
    /**
     * (sharing) Previewed shared file/folder
     */
    SHARED_CONTENT_VIEW,
    /**
     * (sharing) Changed who can access shared folder via link
     */
    SHARED_FOLDER_CHANGE_LINK_POLICY,
    /**
     * (sharing) Changed whether shared folder inherits members from parent
     * folder
     */
    SHARED_FOLDER_CHANGE_MEMBERS_INHERITANCE_POLICY,
    /**
     * (sharing) Changed who can add/remove members of shared folder
     */
    SHARED_FOLDER_CHANGE_MEMBERS_MANAGEMENT_POLICY,
    /**
     * (sharing) Changed who can become member of shared folder
     */
    SHARED_FOLDER_CHANGE_MEMBERS_POLICY,
    /**
     * (sharing) Created shared folder
     */
    SHARED_FOLDER_CREATE,
    /**
     * (sharing) Declined team member's invite to shared folder
     */
    SHARED_FOLDER_DECLINE_INVITATION,
    /**
     * (sharing) Added shared folder to own Dropbox
     */
    SHARED_FOLDER_MOUNT,
    /**
     * (sharing) Changed parent of shared folder
     */
    SHARED_FOLDER_NEST,
    /**
     * (sharing) Transferred ownership of shared folder to another member
     */
    SHARED_FOLDER_TRANSFER_OWNERSHIP,
    /**
     * (sharing) Deleted shared folder from Dropbox
     */
    SHARED_FOLDER_UNMOUNT,
    /**
     * (sharing) Added shared link expiration date
     */
    SHARED_LINK_ADD_EXPIRY,
    /**
     * (sharing) Changed shared link expiration date
     */
    SHARED_LINK_CHANGE_EXPIRY,
    /**
     * (sharing) Changed visibility of shared link
     */
    SHARED_LINK_CHANGE_VISIBILITY,
    /**
     * (sharing) Added file/folder to Dropbox from shared link
     */
    SHARED_LINK_COPY,
    /**
     * (sharing) Created shared link
     */
    SHARED_LINK_CREATE,
    /**
     * (sharing) Removed shared link
     */
    SHARED_LINK_DISABLE,
    /**
     * (sharing) Downloaded file/folder from shared link
     */
    SHARED_LINK_DOWNLOAD,
    /**
     * (sharing) Removed shared link expiration date
     */
    SHARED_LINK_REMOVE_EXPIRY,
    /**
     * (sharing) Added an expiration date to the shared link
     */
    SHARED_LINK_SETTINGS_ADD_EXPIRATION,
    /**
     * (sharing) Added a password to the shared link
     */
    SHARED_LINK_SETTINGS_ADD_PASSWORD,
    /**
     * (sharing) Disabled downloads
     */
    SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_DISABLED,
    /**
     * (sharing) Enabled downloads
     */
    SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_ENABLED,
    /**
     * (sharing) Changed the audience of the shared link
     */
    SHARED_LINK_SETTINGS_CHANGE_AUDIENCE,
    /**
     * (sharing) Changed the expiration date of the shared link
     */
    SHARED_LINK_SETTINGS_CHANGE_EXPIRATION,
    /**
     * (sharing) Changed the password of the shared link
     */
    SHARED_LINK_SETTINGS_CHANGE_PASSWORD,
    /**
     * (sharing) Removed the expiration date from the shared link
     */
    SHARED_LINK_SETTINGS_REMOVE_EXPIRATION,
    /**
     * (sharing) Removed the password from the shared link
     */
    SHARED_LINK_SETTINGS_REMOVE_PASSWORD,
    /**
     * (sharing) Added members as audience of shared link
     */
    SHARED_LINK_SHARE,
    /**
     * (sharing) Opened shared link
     */
    SHARED_LINK_VIEW,
    /**
     * (sharing) Opened shared Paper doc (deprecated, no longer logged)
     */
    SHARED_NOTE_OPENED,
    /**
     * (sharing) Disabled downloads for link (deprecated, no longer logged)
     */
    SHMODEL_DISABLE_DOWNLOADS,
    /**
     * (sharing) Enabled downloads for link (deprecated, no longer logged)
     */
    SHMODEL_ENABLE_DOWNLOADS,
    /**
     * (sharing) Shared link with group (deprecated, no longer logged)
     */
    SHMODEL_GROUP_SHARE,
    /**
     * (showcase) Granted access to showcase
     */
    SHOWCASE_ACCESS_GRANTED,
    /**
     * (showcase) Added member to showcase
     */
    SHOWCASE_ADD_MEMBER,
    /**
     * (showcase) Archived showcase
     */
    SHOWCASE_ARCHIVED,
    /**
     * (showcase) Created showcase
     */
    SHOWCASE_CREATED,
    /**
     * (showcase) Deleted showcase comment
     */
    SHOWCASE_DELETE_COMMENT,
    /**
     * (showcase) Edited showcase
     */
    SHOWCASE_EDITED,
    /**
     * (showcase) Edited showcase comment
     */
    SHOWCASE_EDIT_COMMENT,
    /**
     * (showcase) Added file to showcase
     */
    SHOWCASE_FILE_ADDED,
    /**
     * (showcase) Downloaded file from showcase
     */
    SHOWCASE_FILE_DOWNLOAD,
    /**
     * (showcase) Removed file from showcase
     */
    SHOWCASE_FILE_REMOVED,
    /**
     * (showcase) Viewed file in showcase
     */
    SHOWCASE_FILE_VIEW,
    /**
     * (showcase) Permanently deleted showcase
     */
    SHOWCASE_PERMANENTLY_DELETED,
    /**
     * (showcase) Added showcase comment
     */
    SHOWCASE_POST_COMMENT,
    /**
     * (showcase) Removed member from showcase
     */
    SHOWCASE_REMOVE_MEMBER,
    /**
     * (showcase) Renamed showcase
     */
    SHOWCASE_RENAMED,
    /**
     * (showcase) Requested access to showcase
     */
    SHOWCASE_REQUEST_ACCESS,
    /**
     * (showcase) Resolved showcase comment
     */
    SHOWCASE_RESOLVE_COMMENT,
    /**
     * (showcase) Unarchived showcase
     */
    SHOWCASE_RESTORED,
    /**
     * (showcase) Deleted showcase
     */
    SHOWCASE_TRASHED,
    /**
     * (showcase) Deleted showcase (old version) (deprecated, replaced by
     * 'Deleted showcase')
     */
    SHOWCASE_TRASHED_DEPRECATED,
    /**
     * (showcase) Unresolved showcase comment
     */
    SHOWCASE_UNRESOLVE_COMMENT,
    /**
     * (showcase) Restored showcase
     */
    SHOWCASE_UNTRASHED,
    /**
     * (showcase) Restored showcase (old version) (deprecated, replaced by
     * 'Restored showcase')
     */
    SHOWCASE_UNTRASHED_DEPRECATED,
    /**
     * (showcase) Viewed showcase
     */
    SHOWCASE_VIEW,
    /**
     * (sso) Added X.509 certificate for SSO
     */
    SSO_ADD_CERT,
    /**
     * (sso) Added sign-in URL for SSO
     */
    SSO_ADD_LOGIN_URL,
    /**
     * (sso) Added sign-out URL for SSO
     */
    SSO_ADD_LOGOUT_URL,
    /**
     * (sso) Changed X.509 certificate for SSO
     */
    SSO_CHANGE_CERT,
    /**
     * (sso) Changed sign-in URL for SSO
     */
    SSO_CHANGE_LOGIN_URL,
    /**
     * (sso) Changed sign-out URL for SSO
     */
    SSO_CHANGE_LOGOUT_URL,
    /**
     * (sso) Changed SAML identity mode for SSO
     */
    SSO_CHANGE_SAML_IDENTITY_MODE,
    /**
     * (sso) Removed X.509 certificate for SSO
     */
    SSO_REMOVE_CERT,
    /**
     * (sso) Removed sign-in URL for SSO
     */
    SSO_REMOVE_LOGIN_URL,
    /**
     * (sso) Removed sign-out URL for SSO
     */
    SSO_REMOVE_LOGOUT_URL,
    /**
     * (team_folders) Changed archival status of team folder
     */
    TEAM_FOLDER_CHANGE_STATUS,
    /**
     * (team_folders) Created team folder in active status
     */
    TEAM_FOLDER_CREATE,
    /**
     * (team_folders) Downgraded team folder to regular shared folder
     */
    TEAM_FOLDER_DOWNGRADE,
    /**
     * (team_folders) Permanently deleted archived team folder
     */
    TEAM_FOLDER_PERMANENTLY_DELETE,
    /**
     * (team_folders) Renamed active/archived team folder
     */
    TEAM_FOLDER_RENAME,
    /**
     * (team_folders) Changed sync default
     */
    TEAM_SELECTIVE_SYNC_SETTINGS_CHANGED,
    /**
     * (team_policies) Changed account capture setting on team domain
     */
    ACCOUNT_CAPTURE_CHANGE_POLICY,
    /**
     * (team_policies) Changed admin email reminder policy for team requests to
     * join
     */
    ADMIN_EMAIL_REMINDERS_CHANGED,
    /**
     * (team_policies) Disabled downloads (deprecated, no longer logged)
     */
    ALLOW_DOWNLOAD_DISABLED,
    /**
     * (team_policies) Enabled downloads (deprecated, no longer logged)
     */
    ALLOW_DOWNLOAD_ENABLED,
    /**
     * (team_policies) Changed app permissions
     */
    APP_PERMISSIONS_CHANGED,
    /**
     * (team_policies) Changed camera uploads setting for team
     */
    CAMERA_UPLOADS_POLICY_CHANGED,
    /**
     * (team_policies) Changed Capture transcription policy for team
     */
    CAPTURE_TRANSCRIPT_POLICY_CHANGED,
    /**
     * (team_policies) Changed classification policy for team
     */
    CLASSIFICATION_CHANGE_POLICY,
    /**
     * (team_policies) Changed computer backup policy for team
     */
    COMPUTER_BACKUP_POLICY_CHANGED,
    /**
     * (team_policies) Changed content management setting
     */
    CONTENT_ADMINISTRATION_POLICY_CHANGED,
    /**
     * (team_policies) Set restrictions on data center locations where team data
     * resides
     */
    DATA_PLACEMENT_RESTRICTION_CHANGE_POLICY,
    /**
     * (team_policies) Completed restrictions on data center locations where
     * team data resides
     */
    DATA_PLACEMENT_RESTRICTION_SATISFY_POLICY,
    /**
     * (team_policies) Added members to device approvals exception list
     */
    DEVICE_APPROVALS_ADD_EXCEPTION,
    /**
     * (team_policies) Set/removed limit on number of computers member can link
     * to team Dropbox account
     */
    DEVICE_APPROVALS_CHANGE_DESKTOP_POLICY,
    /**
     * (team_policies) Set/removed limit on number of mobile devices member can
     * link to team Dropbox account
     */
    DEVICE_APPROVALS_CHANGE_MOBILE_POLICY,
    /**
     * (team_policies) Changed device approvals setting when member is over
     * limit
     */
    DEVICE_APPROVALS_CHANGE_OVERAGE_ACTION,
    /**
     * (team_policies) Changed device approvals setting when member unlinks
     * approved device
     */
    DEVICE_APPROVALS_CHANGE_UNLINK_ACTION,
    /**
     * (team_policies) Removed members from device approvals exception list
     */
    DEVICE_APPROVALS_REMOVE_EXCEPTION,
    /**
     * (team_policies) Added members to directory restrictions list
     */
    DIRECTORY_RESTRICTIONS_ADD_MEMBERS,
    /**
     * (team_policies) Removed members from directory restrictions list
     */
    DIRECTORY_RESTRICTIONS_REMOVE_MEMBERS,
    /**
     * (team_policies) Changed Dropbox Passwords policy for team
     */
    DROPBOX_PASSWORDS_POLICY_CHANGED,
    /**
     * (team_policies) Changed email to Dropbox policy for team
     */
    EMAIL_INGEST_POLICY_CHANGED,
    /**
     * (team_policies) Added members to EMM exception list
     */
    EMM_ADD_EXCEPTION,
    /**
     * (team_policies) Enabled/disabled enterprise mobility management for
     * members
     */
    EMM_CHANGE_POLICY,
    /**
     * (team_policies) Removed members from EMM exception list
     */
    EMM_REMOVE_EXCEPTION,
    /**
     * (team_policies) Accepted/opted out of extended version history
     */
    EXTENDED_VERSION_HISTORY_CHANGE_POLICY,
    /**
     * (team_policies) Changed external drive backup policy for team
     */
    EXTERNAL_DRIVE_BACKUP_POLICY_CHANGED,
    /**
     * (team_policies) Enabled/disabled commenting on team files
     */
    FILE_COMMENTS_CHANGE_POLICY,
    /**
     * (team_policies) Changed file locking policy for team
     */
    FILE_LOCKING_POLICY_CHANGED,
    /**
     * (team_policies) Enabled/disabled file requests
     */
    FILE_REQUESTS_CHANGE_POLICY,
    /**
     * (team_policies) Enabled file request emails for everyone (deprecated, no
     * longer logged)
     */
    FILE_REQUESTS_EMAILS_ENABLED,
    /**
     * (team_policies) Enabled file request emails for team (deprecated, no
     * longer logged)
     */
    FILE_REQUESTS_EMAILS_RESTRICTED_TO_TEAM_ONLY,
    /**
     * (team_policies) Changed file transfers policy for team
     */
    FILE_TRANSFERS_POLICY_CHANGED,
    /**
     * (team_policies) Enabled/disabled Google single sign-on for team
     */
    GOOGLE_SSO_CHANGE_POLICY,
    /**
     * (team_policies) Changed who can create groups
     */
    GROUP_USER_MANAGEMENT_CHANGE_POLICY,
    /**
     * (team_policies) Changed integration policy for team
     */
    INTEGRATION_POLICY_CHANGED,
    /**
     * (team_policies) Changed invite accept email policy for team
     */
    INVITE_ACCEPTANCE_EMAIL_POLICY_CHANGED,
    /**
     * (team_policies) Changed whether users can find team when not invited
     */
    MEMBER_REQUESTS_CHANGE_POLICY,
    /**
     * (team_policies) Changed member send invite policy for team
     */
    MEMBER_SEND_INVITE_POLICY_CHANGED,
    /**
     * (team_policies) Added members to member space limit exception list
     */
    MEMBER_SPACE_LIMITS_ADD_EXCEPTION,
    /**
     * (team_policies) Changed member space limit type for team
     */
    MEMBER_SPACE_LIMITS_CHANGE_CAPS_TYPE_POLICY,
    /**
     * (team_policies) Changed team default member space limit
     */
    MEMBER_SPACE_LIMITS_CHANGE_POLICY,
    /**
     * (team_policies) Removed members from member space limit exception list
     */
    MEMBER_SPACE_LIMITS_REMOVE_EXCEPTION,
    /**
     * (team_policies) Enabled/disabled option for team members to suggest
     * people to add to team
     */
    MEMBER_SUGGESTIONS_CHANGE_POLICY,
    /**
     * (team_policies) Enabled/disabled Microsoft Office add-in
     */
    MICROSOFT_OFFICE_ADDIN_CHANGE_POLICY,
    /**
     * (team_policies) Enabled/disabled network control
     */
    NETWORK_CONTROL_CHANGE_POLICY,
    /**
     * (team_policies) Changed whether Dropbox Paper, when enabled, is deployed
     * to all members or to specific members
     */
    PAPER_CHANGE_DEPLOYMENT_POLICY,
    /**
     * (team_policies) Changed whether non-members can view Paper docs with link
     * (deprecated, no longer logged)
     */
    PAPER_CHANGE_MEMBER_LINK_POLICY,
    /**
     * (team_policies) Changed whether members can share Paper docs outside
     * team, and if docs are accessible only by team members or anyone by
     * default
     */
    PAPER_CHANGE_MEMBER_POLICY,
    /**
     * (team_policies) Enabled/disabled Dropbox Paper for team
     */
    PAPER_CHANGE_POLICY,
    /**
     * (team_policies) Changed Paper Default Folder Policy setting for team
     */
    PAPER_DEFAULT_FOLDER_POLICY_CHANGED,
    /**
     * (team_policies) Enabled/disabled Paper Desktop for team
     */
    PAPER_DESKTOP_POLICY_CHANGED,
    /**
     * (team_policies) Added users to Paper-enabled users list
     */
    PAPER_ENABLED_USERS_GROUP_ADDITION,
    /**
     * (team_policies) Removed users from Paper-enabled users list
     */
    PAPER_ENABLED_USERS_GROUP_REMOVAL,
    /**
     * (team_policies) Changed team password strength requirements
     */
    PASSWORD_STRENGTH_REQUIREMENTS_CHANGE_POLICY,
    /**
     * (team_policies) Enabled/disabled ability of team members to permanently
     * delete content
     */
    PERMANENT_DELETE_CHANGE_POLICY,
    /**
     * (team_policies) Enabled/disabled reseller support
     */
    RESELLER_SUPPORT_CHANGE_POLICY,
    /**
     * (team_policies) Changed Rewind policy for team
     */
    REWIND_POLICY_CHANGED,
    /**
     * (team_policies) Changed send for signature policy for team
     */
    SEND_FOR_SIGNATURE_POLICY_CHANGED,
    /**
     * (team_policies) Changed whether team members can join shared folders
     * owned outside team
     */
    SHARING_CHANGE_FOLDER_JOIN_POLICY,
    /**
     * (team_policies) Changed the allow remove or change expiration policy for
     * the links shared outside of the team
     */
    SHARING_CHANGE_LINK_ALLOW_CHANGE_EXPIRATION_POLICY,
    /**
     * (team_policies) Changed the default expiration for the links shared
     * outside of the team
     */
    SHARING_CHANGE_LINK_DEFAULT_EXPIRATION_POLICY,
    /**
     * (team_policies) Changed the password requirement for the links shared
     * outside of the team
     */
    SHARING_CHANGE_LINK_ENFORCE_PASSWORD_POLICY,
    /**
     * (team_policies) Changed whether members can share links outside team, and
     * if links are accessible only by team members or anyone by default
     */
    SHARING_CHANGE_LINK_POLICY,
    /**
     * (team_policies) Changed whether members can share files/folders outside
     * team
     */
    SHARING_CHANGE_MEMBER_POLICY,
    /**
     * (team_policies) Enabled/disabled downloading files from Dropbox Showcase
     * for team
     */
    SHOWCASE_CHANGE_DOWNLOAD_POLICY,
    /**
     * (team_policies) Enabled/disabled Dropbox Showcase for team
     */
    SHOWCASE_CHANGE_ENABLED_POLICY,
    /**
     * (team_policies) Enabled/disabled sharing Dropbox Showcase externally for
     * team
     */
    SHOWCASE_CHANGE_EXTERNAL_SHARING_POLICY,
    /**
     * (team_policies) Changed automatic Smart Sync setting for team
     */
    SMARTER_SMART_SYNC_POLICY_CHANGED,
    /**
     * (team_policies) Changed default Smart Sync setting for team members
     */
    SMART_SYNC_CHANGE_POLICY,
    /**
     * (team_policies) Opted team into Smart Sync
     */
    SMART_SYNC_NOT_OPT_OUT,
    /**
     * (team_policies) Opted team out of Smart Sync
     */
    SMART_SYNC_OPT_OUT,
    /**
     * (team_policies) Changed single sign-on setting for team
     */
    SSO_CHANGE_POLICY,
    /**
     * (team_policies) Changed team branding policy for team
     */
    TEAM_BRANDING_POLICY_CHANGED,
    /**
     * (team_policies) Changed App Integrations setting for team
     */
    TEAM_EXTENSIONS_POLICY_CHANGED,
    /**
     * (team_policies) Enabled/disabled Team Selective Sync for team
     */
    TEAM_SELECTIVE_SYNC_POLICY_CHANGED,
    /**
     * (team_policies) Edited the approved list for sharing externally
     */
    TEAM_SHARING_WHITELIST_SUBJECTS_CHANGED,
    /**
     * (team_policies) Added members to two factor authentication exception list
     */
    TFA_ADD_EXCEPTION,
    /**
     * (team_policies) Changed two-step verification setting for team
     */
    TFA_CHANGE_POLICY,
    /**
     * (team_policies) Removed members from two factor authentication exception
     * list
     */
    TFA_REMOVE_EXCEPTION,
    /**
     * (team_policies) Enabled/disabled option for members to link personal
     * Dropbox account and team account to same computer
     */
    TWO_ACCOUNT_CHANGE_POLICY,
    /**
     * (team_policies) Changed team policy for viewer info
     */
    VIEWER_INFO_POLICY_CHANGED,
    /**
     * (team_policies) Changed watermarking policy for team
     */
    WATERMARKING_POLICY_CHANGED,
    /**
     * (team_policies) Changed limit on active sessions per member
     */
    WEB_SESSIONS_CHANGE_ACTIVE_SESSION_LIMIT,
    /**
     * (team_policies) Changed how long members can stay signed in to
     * Dropbox.com
     */
    WEB_SESSIONS_CHANGE_FIXED_LENGTH_POLICY,
    /**
     * (team_policies) Changed how long team members can be idle while signed in
     * to Dropbox.com
     */
    WEB_SESSIONS_CHANGE_IDLE_LENGTH_POLICY,
    /**
     * (team_profile) Requested data residency migration for team data
     */
    DATA_RESIDENCY_MIGRATION_REQUEST_SUCCESSFUL,
    /**
     * (team_profile) Request for data residency migration for team data has
     * failed
     */
    DATA_RESIDENCY_MIGRATION_REQUEST_UNSUCCESSFUL,
    /**
     * (team_profile) Merged another team into this team
     */
    TEAM_MERGE_FROM,
    /**
     * (team_profile) Merged this team into another team
     */
    TEAM_MERGE_TO,
    /**
     * (team_profile) Added team background to display on shared link headers
     */
    TEAM_PROFILE_ADD_BACKGROUND,
    /**
     * (team_profile) Added team logo to display on shared link headers
     */
    TEAM_PROFILE_ADD_LOGO,
    /**
     * (team_profile) Changed team background displayed on shared link headers
     */
    TEAM_PROFILE_CHANGE_BACKGROUND,
    /**
     * (team_profile) Changed default language for team
     */
    TEAM_PROFILE_CHANGE_DEFAULT_LANGUAGE,
    /**
     * (team_profile) Changed team logo displayed on shared link headers
     */
    TEAM_PROFILE_CHANGE_LOGO,
    /**
     * (team_profile) Changed team name
     */
    TEAM_PROFILE_CHANGE_NAME,
    /**
     * (team_profile) Removed team background displayed on shared link headers
     */
    TEAM_PROFILE_REMOVE_BACKGROUND,
    /**
     * (team_profile) Removed team logo displayed on shared link headers
     */
    TEAM_PROFILE_REMOVE_LOGO,
    /**
     * (tfa) Added backup phone for two-step verification
     */
    TFA_ADD_BACKUP_PHONE,
    /**
     * (tfa) Added security key for two-step verification
     */
    TFA_ADD_SECURITY_KEY,
    /**
     * (tfa) Changed backup phone for two-step verification
     */
    TFA_CHANGE_BACKUP_PHONE,
    /**
     * (tfa) Enabled/disabled/changed two-step verification setting
     */
    TFA_CHANGE_STATUS,
    /**
     * (tfa) Removed backup phone for two-step verification
     */
    TFA_REMOVE_BACKUP_PHONE,
    /**
     * (tfa) Removed security key for two-step verification
     */
    TFA_REMOVE_SECURITY_KEY,
    /**
     * (tfa) Reset two-step verification for team member
     */
    TFA_RESET,
    /**
     * (trusted_teams) Changed enterprise admin role
     */
    CHANGED_ENTERPRISE_ADMIN_ROLE,
    /**
     * (trusted_teams) Changed enterprise-connected team status
     */
    CHANGED_ENTERPRISE_CONNECTED_TEAM_STATUS,
    /**
     * (trusted_teams) Ended enterprise admin session
     */
    ENDED_ENTERPRISE_ADMIN_SESSION,
    /**
     * (trusted_teams) Ended enterprise admin session (deprecated, replaced by
     * 'Ended enterprise admin session')
     */
    ENDED_ENTERPRISE_ADMIN_SESSION_DEPRECATED,
    /**
     * (trusted_teams) Changed who can update a setting
     */
    ENTERPRISE_SETTINGS_LOCKING,
    /**
     * (trusted_teams) Changed guest team admin status
     */
    GUEST_ADMIN_CHANGE_STATUS,
    /**
     * (trusted_teams) Started enterprise admin session
     */
    STARTED_ENTERPRISE_ADMIN_SESSION,
    /**
     * (trusted_teams) Accepted a team merge request
     */
    TEAM_MERGE_REQUEST_ACCEPTED,
    /**
     * (trusted_teams) Accepted a team merge request (deprecated, replaced by
     * 'Accepted a team merge request')
     */
    TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_PRIMARY_TEAM,
    /**
     * (trusted_teams) Accepted a team merge request (deprecated, replaced by
     * 'Accepted a team merge request')
     */
    TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_SECONDARY_TEAM,
    /**
     * (trusted_teams) Automatically canceled team merge request
     */
    TEAM_MERGE_REQUEST_AUTO_CANCELED,
    /**
     * (trusted_teams) Canceled a team merge request
     */
    TEAM_MERGE_REQUEST_CANCELED,
    /**
     * (trusted_teams) Canceled a team merge request (deprecated, replaced by
     * 'Canceled a team merge request')
     */
    TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_PRIMARY_TEAM,
    /**
     * (trusted_teams) Canceled a team merge request (deprecated, replaced by
     * 'Canceled a team merge request')
     */
    TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_SECONDARY_TEAM,
    /**
     * (trusted_teams) Team merge request expired
     */
    TEAM_MERGE_REQUEST_EXPIRED,
    /**
     * (trusted_teams) Team merge request expired (deprecated, replaced by 'Team
     * merge request expired')
     */
    TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_PRIMARY_TEAM,
    /**
     * (trusted_teams) Team merge request expired (deprecated, replaced by 'Team
     * merge request expired')
     */
    TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_SECONDARY_TEAM,
    /**
     * (trusted_teams) Rejected a team merge request (deprecated, no longer
     * logged)
     */
    TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_PRIMARY_TEAM,
    /**
     * (trusted_teams) Rejected a team merge request (deprecated, no longer
     * logged)
     */
    TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_SECONDARY_TEAM,
    /**
     * (trusted_teams) Sent a team merge request reminder
     */
    TEAM_MERGE_REQUEST_REMINDER,
    /**
     * (trusted_teams) Sent a team merge request reminder (deprecated, replaced
     * by 'Sent a team merge request reminder')
     */
    TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_PRIMARY_TEAM,
    /**
     * (trusted_teams) Sent a team merge request reminder (deprecated, replaced
     * by 'Sent a team merge request reminder')
     */
    TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_SECONDARY_TEAM,
    /**
     * (trusted_teams) Canceled the team merge
     */
    TEAM_MERGE_REQUEST_REVOKED,
    /**
     * (trusted_teams) Requested to merge their Dropbox team into yours
     */
    TEAM_MERGE_REQUEST_SENT_SHOWN_TO_PRIMARY_TEAM,
    /**
     * (trusted_teams) Requested to merge your team into another Dropbox team
     */
    TEAM_MERGE_REQUEST_SENT_SHOWN_TO_SECONDARY_TEAM,
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
    static class Serializer extends UnionSerializer<EventTypeArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(EventTypeArg value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ADMIN_ALERTING_ALERT_STATE_CHANGED: {
                    g.writeString("admin_alerting_alert_state_changed");
                    break;
                }
                case ADMIN_ALERTING_CHANGED_ALERT_CONFIG: {
                    g.writeString("admin_alerting_changed_alert_config");
                    break;
                }
                case ADMIN_ALERTING_TRIGGERED_ALERT: {
                    g.writeString("admin_alerting_triggered_alert");
                    break;
                }
                case APP_BLOCKED_BY_PERMISSIONS: {
                    g.writeString("app_blocked_by_permissions");
                    break;
                }
                case APP_LINK_TEAM: {
                    g.writeString("app_link_team");
                    break;
                }
                case APP_LINK_USER: {
                    g.writeString("app_link_user");
                    break;
                }
                case APP_UNLINK_TEAM: {
                    g.writeString("app_unlink_team");
                    break;
                }
                case APP_UNLINK_USER: {
                    g.writeString("app_unlink_user");
                    break;
                }
                case INTEGRATION_CONNECTED: {
                    g.writeString("integration_connected");
                    break;
                }
                case INTEGRATION_DISCONNECTED: {
                    g.writeString("integration_disconnected");
                    break;
                }
                case FILE_ADD_COMMENT: {
                    g.writeString("file_add_comment");
                    break;
                }
                case FILE_CHANGE_COMMENT_SUBSCRIPTION: {
                    g.writeString("file_change_comment_subscription");
                    break;
                }
                case FILE_DELETE_COMMENT: {
                    g.writeString("file_delete_comment");
                    break;
                }
                case FILE_EDIT_COMMENT: {
                    g.writeString("file_edit_comment");
                    break;
                }
                case FILE_LIKE_COMMENT: {
                    g.writeString("file_like_comment");
                    break;
                }
                case FILE_RESOLVE_COMMENT: {
                    g.writeString("file_resolve_comment");
                    break;
                }
                case FILE_UNLIKE_COMMENT: {
                    g.writeString("file_unlike_comment");
                    break;
                }
                case FILE_UNRESOLVE_COMMENT: {
                    g.writeString("file_unresolve_comment");
                    break;
                }
                case GOVERNANCE_POLICY_ADD_FOLDERS: {
                    g.writeString("governance_policy_add_folders");
                    break;
                }
                case GOVERNANCE_POLICY_ADD_FOLDER_FAILED: {
                    g.writeString("governance_policy_add_folder_failed");
                    break;
                }
                case GOVERNANCE_POLICY_CONTENT_DISPOSED: {
                    g.writeString("governance_policy_content_disposed");
                    break;
                }
                case GOVERNANCE_POLICY_CREATE: {
                    g.writeString("governance_policy_create");
                    break;
                }
                case GOVERNANCE_POLICY_DELETE: {
                    g.writeString("governance_policy_delete");
                    break;
                }
                case GOVERNANCE_POLICY_EDIT_DETAILS: {
                    g.writeString("governance_policy_edit_details");
                    break;
                }
                case GOVERNANCE_POLICY_EDIT_DURATION: {
                    g.writeString("governance_policy_edit_duration");
                    break;
                }
                case GOVERNANCE_POLICY_EXPORT_CREATED: {
                    g.writeString("governance_policy_export_created");
                    break;
                }
                case GOVERNANCE_POLICY_EXPORT_REMOVED: {
                    g.writeString("governance_policy_export_removed");
                    break;
                }
                case GOVERNANCE_POLICY_REMOVE_FOLDERS: {
                    g.writeString("governance_policy_remove_folders");
                    break;
                }
                case GOVERNANCE_POLICY_REPORT_CREATED: {
                    g.writeString("governance_policy_report_created");
                    break;
                }
                case GOVERNANCE_POLICY_ZIP_PART_DOWNLOADED: {
                    g.writeString("governance_policy_zip_part_downloaded");
                    break;
                }
                case LEGAL_HOLDS_ACTIVATE_A_HOLD: {
                    g.writeString("legal_holds_activate_a_hold");
                    break;
                }
                case LEGAL_HOLDS_ADD_MEMBERS: {
                    g.writeString("legal_holds_add_members");
                    break;
                }
                case LEGAL_HOLDS_CHANGE_HOLD_DETAILS: {
                    g.writeString("legal_holds_change_hold_details");
                    break;
                }
                case LEGAL_HOLDS_CHANGE_HOLD_NAME: {
                    g.writeString("legal_holds_change_hold_name");
                    break;
                }
                case LEGAL_HOLDS_EXPORT_A_HOLD: {
                    g.writeString("legal_holds_export_a_hold");
                    break;
                }
                case LEGAL_HOLDS_EXPORT_CANCELLED: {
                    g.writeString("legal_holds_export_cancelled");
                    break;
                }
                case LEGAL_HOLDS_EXPORT_DOWNLOADED: {
                    g.writeString("legal_holds_export_downloaded");
                    break;
                }
                case LEGAL_HOLDS_EXPORT_REMOVED: {
                    g.writeString("legal_holds_export_removed");
                    break;
                }
                case LEGAL_HOLDS_RELEASE_A_HOLD: {
                    g.writeString("legal_holds_release_a_hold");
                    break;
                }
                case LEGAL_HOLDS_REMOVE_MEMBERS: {
                    g.writeString("legal_holds_remove_members");
                    break;
                }
                case LEGAL_HOLDS_REPORT_A_HOLD: {
                    g.writeString("legal_holds_report_a_hold");
                    break;
                }
                case DEVICE_CHANGE_IP_DESKTOP: {
                    g.writeString("device_change_ip_desktop");
                    break;
                }
                case DEVICE_CHANGE_IP_MOBILE: {
                    g.writeString("device_change_ip_mobile");
                    break;
                }
                case DEVICE_CHANGE_IP_WEB: {
                    g.writeString("device_change_ip_web");
                    break;
                }
                case DEVICE_DELETE_ON_UNLINK_FAIL: {
                    g.writeString("device_delete_on_unlink_fail");
                    break;
                }
                case DEVICE_DELETE_ON_UNLINK_SUCCESS: {
                    g.writeString("device_delete_on_unlink_success");
                    break;
                }
                case DEVICE_LINK_FAIL: {
                    g.writeString("device_link_fail");
                    break;
                }
                case DEVICE_LINK_SUCCESS: {
                    g.writeString("device_link_success");
                    break;
                }
                case DEVICE_MANAGEMENT_DISABLED: {
                    g.writeString("device_management_disabled");
                    break;
                }
                case DEVICE_MANAGEMENT_ENABLED: {
                    g.writeString("device_management_enabled");
                    break;
                }
                case DEVICE_SYNC_BACKUP_STATUS_CHANGED: {
                    g.writeString("device_sync_backup_status_changed");
                    break;
                }
                case DEVICE_UNLINK: {
                    g.writeString("device_unlink");
                    break;
                }
                case DROPBOX_PASSWORDS_EXPORTED: {
                    g.writeString("dropbox_passwords_exported");
                    break;
                }
                case DROPBOX_PASSWORDS_NEW_DEVICE_ENROLLED: {
                    g.writeString("dropbox_passwords_new_device_enrolled");
                    break;
                }
                case EMM_REFRESH_AUTH_TOKEN: {
                    g.writeString("emm_refresh_auth_token");
                    break;
                }
                case EXTERNAL_DRIVE_BACKUP_ELIGIBILITY_STATUS_CHECKED: {
                    g.writeString("external_drive_backup_eligibility_status_checked");
                    break;
                }
                case EXTERNAL_DRIVE_BACKUP_STATUS_CHANGED: {
                    g.writeString("external_drive_backup_status_changed");
                    break;
                }
                case ACCOUNT_CAPTURE_CHANGE_AVAILABILITY: {
                    g.writeString("account_capture_change_availability");
                    break;
                }
                case ACCOUNT_CAPTURE_MIGRATE_ACCOUNT: {
                    g.writeString("account_capture_migrate_account");
                    break;
                }
                case ACCOUNT_CAPTURE_NOTIFICATION_EMAILS_SENT: {
                    g.writeString("account_capture_notification_emails_sent");
                    break;
                }
                case ACCOUNT_CAPTURE_RELINQUISH_ACCOUNT: {
                    g.writeString("account_capture_relinquish_account");
                    break;
                }
                case DISABLED_DOMAIN_INVITES: {
                    g.writeString("disabled_domain_invites");
                    break;
                }
                case DOMAIN_INVITES_APPROVE_REQUEST_TO_JOIN_TEAM: {
                    g.writeString("domain_invites_approve_request_to_join_team");
                    break;
                }
                case DOMAIN_INVITES_DECLINE_REQUEST_TO_JOIN_TEAM: {
                    g.writeString("domain_invites_decline_request_to_join_team");
                    break;
                }
                case DOMAIN_INVITES_EMAIL_EXISTING_USERS: {
                    g.writeString("domain_invites_email_existing_users");
                    break;
                }
                case DOMAIN_INVITES_REQUEST_TO_JOIN_TEAM: {
                    g.writeString("domain_invites_request_to_join_team");
                    break;
                }
                case DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_NO: {
                    g.writeString("domain_invites_set_invite_new_user_pref_to_no");
                    break;
                }
                case DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_YES: {
                    g.writeString("domain_invites_set_invite_new_user_pref_to_yes");
                    break;
                }
                case DOMAIN_VERIFICATION_ADD_DOMAIN_FAIL: {
                    g.writeString("domain_verification_add_domain_fail");
                    break;
                }
                case DOMAIN_VERIFICATION_ADD_DOMAIN_SUCCESS: {
                    g.writeString("domain_verification_add_domain_success");
                    break;
                }
                case DOMAIN_VERIFICATION_REMOVE_DOMAIN: {
                    g.writeString("domain_verification_remove_domain");
                    break;
                }
                case ENABLED_DOMAIN_INVITES: {
                    g.writeString("enabled_domain_invites");
                    break;
                }
                case APPLY_NAMING_CONVENTION: {
                    g.writeString("apply_naming_convention");
                    break;
                }
                case CREATE_FOLDER: {
                    g.writeString("create_folder");
                    break;
                }
                case FILE_ADD: {
                    g.writeString("file_add");
                    break;
                }
                case FILE_COPY: {
                    g.writeString("file_copy");
                    break;
                }
                case FILE_DELETE: {
                    g.writeString("file_delete");
                    break;
                }
                case FILE_DOWNLOAD: {
                    g.writeString("file_download");
                    break;
                }
                case FILE_EDIT: {
                    g.writeString("file_edit");
                    break;
                }
                case FILE_GET_COPY_REFERENCE: {
                    g.writeString("file_get_copy_reference");
                    break;
                }
                case FILE_LOCKING_LOCK_STATUS_CHANGED: {
                    g.writeString("file_locking_lock_status_changed");
                    break;
                }
                case FILE_MOVE: {
                    g.writeString("file_move");
                    break;
                }
                case FILE_PERMANENTLY_DELETE: {
                    g.writeString("file_permanently_delete");
                    break;
                }
                case FILE_PREVIEW: {
                    g.writeString("file_preview");
                    break;
                }
                case FILE_RENAME: {
                    g.writeString("file_rename");
                    break;
                }
                case FILE_RESTORE: {
                    g.writeString("file_restore");
                    break;
                }
                case FILE_REVERT: {
                    g.writeString("file_revert");
                    break;
                }
                case FILE_ROLLBACK_CHANGES: {
                    g.writeString("file_rollback_changes");
                    break;
                }
                case FILE_SAVE_COPY_REFERENCE: {
                    g.writeString("file_save_copy_reference");
                    break;
                }
                case FOLDER_OVERVIEW_DESCRIPTION_CHANGED: {
                    g.writeString("folder_overview_description_changed");
                    break;
                }
                case FOLDER_OVERVIEW_ITEM_PINNED: {
                    g.writeString("folder_overview_item_pinned");
                    break;
                }
                case FOLDER_OVERVIEW_ITEM_UNPINNED: {
                    g.writeString("folder_overview_item_unpinned");
                    break;
                }
                case OBJECT_LABEL_ADDED: {
                    g.writeString("object_label_added");
                    break;
                }
                case OBJECT_LABEL_REMOVED: {
                    g.writeString("object_label_removed");
                    break;
                }
                case OBJECT_LABEL_UPDATED_VALUE: {
                    g.writeString("object_label_updated_value");
                    break;
                }
                case ORGANIZE_FOLDER_WITH_TIDY: {
                    g.writeString("organize_folder_with_tidy");
                    break;
                }
                case REWIND_FOLDER: {
                    g.writeString("rewind_folder");
                    break;
                }
                case UNDO_NAMING_CONVENTION: {
                    g.writeString("undo_naming_convention");
                    break;
                }
                case UNDO_ORGANIZE_FOLDER_WITH_TIDY: {
                    g.writeString("undo_organize_folder_with_tidy");
                    break;
                }
                case USER_TAGS_ADDED: {
                    g.writeString("user_tags_added");
                    break;
                }
                case USER_TAGS_REMOVED: {
                    g.writeString("user_tags_removed");
                    break;
                }
                case EMAIL_INGEST_RECEIVE_FILE: {
                    g.writeString("email_ingest_receive_file");
                    break;
                }
                case FILE_REQUEST_CHANGE: {
                    g.writeString("file_request_change");
                    break;
                }
                case FILE_REQUEST_CLOSE: {
                    g.writeString("file_request_close");
                    break;
                }
                case FILE_REQUEST_CREATE: {
                    g.writeString("file_request_create");
                    break;
                }
                case FILE_REQUEST_DELETE: {
                    g.writeString("file_request_delete");
                    break;
                }
                case FILE_REQUEST_RECEIVE_FILE: {
                    g.writeString("file_request_receive_file");
                    break;
                }
                case GROUP_ADD_EXTERNAL_ID: {
                    g.writeString("group_add_external_id");
                    break;
                }
                case GROUP_ADD_MEMBER: {
                    g.writeString("group_add_member");
                    break;
                }
                case GROUP_CHANGE_EXTERNAL_ID: {
                    g.writeString("group_change_external_id");
                    break;
                }
                case GROUP_CHANGE_MANAGEMENT_TYPE: {
                    g.writeString("group_change_management_type");
                    break;
                }
                case GROUP_CHANGE_MEMBER_ROLE: {
                    g.writeString("group_change_member_role");
                    break;
                }
                case GROUP_CREATE: {
                    g.writeString("group_create");
                    break;
                }
                case GROUP_DELETE: {
                    g.writeString("group_delete");
                    break;
                }
                case GROUP_DESCRIPTION_UPDATED: {
                    g.writeString("group_description_updated");
                    break;
                }
                case GROUP_JOIN_POLICY_UPDATED: {
                    g.writeString("group_join_policy_updated");
                    break;
                }
                case GROUP_MOVED: {
                    g.writeString("group_moved");
                    break;
                }
                case GROUP_REMOVE_EXTERNAL_ID: {
                    g.writeString("group_remove_external_id");
                    break;
                }
                case GROUP_REMOVE_MEMBER: {
                    g.writeString("group_remove_member");
                    break;
                }
                case GROUP_RENAME: {
                    g.writeString("group_rename");
                    break;
                }
                case ACCOUNT_LOCK_OR_UNLOCKED: {
                    g.writeString("account_lock_or_unlocked");
                    break;
                }
                case EMM_ERROR: {
                    g.writeString("emm_error");
                    break;
                }
                case GUEST_ADMIN_SIGNED_IN_VIA_TRUSTED_TEAMS: {
                    g.writeString("guest_admin_signed_in_via_trusted_teams");
                    break;
                }
                case GUEST_ADMIN_SIGNED_OUT_VIA_TRUSTED_TEAMS: {
                    g.writeString("guest_admin_signed_out_via_trusted_teams");
                    break;
                }
                case LOGIN_FAIL: {
                    g.writeString("login_fail");
                    break;
                }
                case LOGIN_SUCCESS: {
                    g.writeString("login_success");
                    break;
                }
                case LOGOUT: {
                    g.writeString("logout");
                    break;
                }
                case RESELLER_SUPPORT_SESSION_END: {
                    g.writeString("reseller_support_session_end");
                    break;
                }
                case RESELLER_SUPPORT_SESSION_START: {
                    g.writeString("reseller_support_session_start");
                    break;
                }
                case SIGN_IN_AS_SESSION_END: {
                    g.writeString("sign_in_as_session_end");
                    break;
                }
                case SIGN_IN_AS_SESSION_START: {
                    g.writeString("sign_in_as_session_start");
                    break;
                }
                case SSO_ERROR: {
                    g.writeString("sso_error");
                    break;
                }
                case CREATE_TEAM_INVITE_LINK: {
                    g.writeString("create_team_invite_link");
                    break;
                }
                case DELETE_TEAM_INVITE_LINK: {
                    g.writeString("delete_team_invite_link");
                    break;
                }
                case MEMBER_ADD_EXTERNAL_ID: {
                    g.writeString("member_add_external_id");
                    break;
                }
                case MEMBER_ADD_NAME: {
                    g.writeString("member_add_name");
                    break;
                }
                case MEMBER_CHANGE_ADMIN_ROLE: {
                    g.writeString("member_change_admin_role");
                    break;
                }
                case MEMBER_CHANGE_EMAIL: {
                    g.writeString("member_change_email");
                    break;
                }
                case MEMBER_CHANGE_EXTERNAL_ID: {
                    g.writeString("member_change_external_id");
                    break;
                }
                case MEMBER_CHANGE_MEMBERSHIP_TYPE: {
                    g.writeString("member_change_membership_type");
                    break;
                }
                case MEMBER_CHANGE_NAME: {
                    g.writeString("member_change_name");
                    break;
                }
                case MEMBER_CHANGE_RESELLER_ROLE: {
                    g.writeString("member_change_reseller_role");
                    break;
                }
                case MEMBER_CHANGE_STATUS: {
                    g.writeString("member_change_status");
                    break;
                }
                case MEMBER_DELETE_MANUAL_CONTACTS: {
                    g.writeString("member_delete_manual_contacts");
                    break;
                }
                case MEMBER_DELETE_PROFILE_PHOTO: {
                    g.writeString("member_delete_profile_photo");
                    break;
                }
                case MEMBER_PERMANENTLY_DELETE_ACCOUNT_CONTENTS: {
                    g.writeString("member_permanently_delete_account_contents");
                    break;
                }
                case MEMBER_REMOVE_EXTERNAL_ID: {
                    g.writeString("member_remove_external_id");
                    break;
                }
                case MEMBER_SET_PROFILE_PHOTO: {
                    g.writeString("member_set_profile_photo");
                    break;
                }
                case MEMBER_SPACE_LIMITS_ADD_CUSTOM_QUOTA: {
                    g.writeString("member_space_limits_add_custom_quota");
                    break;
                }
                case MEMBER_SPACE_LIMITS_CHANGE_CUSTOM_QUOTA: {
                    g.writeString("member_space_limits_change_custom_quota");
                    break;
                }
                case MEMBER_SPACE_LIMITS_CHANGE_STATUS: {
                    g.writeString("member_space_limits_change_status");
                    break;
                }
                case MEMBER_SPACE_LIMITS_REMOVE_CUSTOM_QUOTA: {
                    g.writeString("member_space_limits_remove_custom_quota");
                    break;
                }
                case MEMBER_SUGGEST: {
                    g.writeString("member_suggest");
                    break;
                }
                case MEMBER_TRANSFER_ACCOUNT_CONTENTS: {
                    g.writeString("member_transfer_account_contents");
                    break;
                }
                case PENDING_SECONDARY_EMAIL_ADDED: {
                    g.writeString("pending_secondary_email_added");
                    break;
                }
                case SECONDARY_EMAIL_DELETED: {
                    g.writeString("secondary_email_deleted");
                    break;
                }
                case SECONDARY_EMAIL_VERIFIED: {
                    g.writeString("secondary_email_verified");
                    break;
                }
                case SECONDARY_MAILS_POLICY_CHANGED: {
                    g.writeString("secondary_mails_policy_changed");
                    break;
                }
                case BINDER_ADD_PAGE: {
                    g.writeString("binder_add_page");
                    break;
                }
                case BINDER_ADD_SECTION: {
                    g.writeString("binder_add_section");
                    break;
                }
                case BINDER_REMOVE_PAGE: {
                    g.writeString("binder_remove_page");
                    break;
                }
                case BINDER_REMOVE_SECTION: {
                    g.writeString("binder_remove_section");
                    break;
                }
                case BINDER_RENAME_PAGE: {
                    g.writeString("binder_rename_page");
                    break;
                }
                case BINDER_RENAME_SECTION: {
                    g.writeString("binder_rename_section");
                    break;
                }
                case BINDER_REORDER_PAGE: {
                    g.writeString("binder_reorder_page");
                    break;
                }
                case BINDER_REORDER_SECTION: {
                    g.writeString("binder_reorder_section");
                    break;
                }
                case PAPER_CONTENT_ADD_MEMBER: {
                    g.writeString("paper_content_add_member");
                    break;
                }
                case PAPER_CONTENT_ADD_TO_FOLDER: {
                    g.writeString("paper_content_add_to_folder");
                    break;
                }
                case PAPER_CONTENT_ARCHIVE: {
                    g.writeString("paper_content_archive");
                    break;
                }
                case PAPER_CONTENT_CREATE: {
                    g.writeString("paper_content_create");
                    break;
                }
                case PAPER_CONTENT_PERMANENTLY_DELETE: {
                    g.writeString("paper_content_permanently_delete");
                    break;
                }
                case PAPER_CONTENT_REMOVE_FROM_FOLDER: {
                    g.writeString("paper_content_remove_from_folder");
                    break;
                }
                case PAPER_CONTENT_REMOVE_MEMBER: {
                    g.writeString("paper_content_remove_member");
                    break;
                }
                case PAPER_CONTENT_RENAME: {
                    g.writeString("paper_content_rename");
                    break;
                }
                case PAPER_CONTENT_RESTORE: {
                    g.writeString("paper_content_restore");
                    break;
                }
                case PAPER_DOC_ADD_COMMENT: {
                    g.writeString("paper_doc_add_comment");
                    break;
                }
                case PAPER_DOC_CHANGE_MEMBER_ROLE: {
                    g.writeString("paper_doc_change_member_role");
                    break;
                }
                case PAPER_DOC_CHANGE_SHARING_POLICY: {
                    g.writeString("paper_doc_change_sharing_policy");
                    break;
                }
                case PAPER_DOC_CHANGE_SUBSCRIPTION: {
                    g.writeString("paper_doc_change_subscription");
                    break;
                }
                case PAPER_DOC_DELETED: {
                    g.writeString("paper_doc_deleted");
                    break;
                }
                case PAPER_DOC_DELETE_COMMENT: {
                    g.writeString("paper_doc_delete_comment");
                    break;
                }
                case PAPER_DOC_DOWNLOAD: {
                    g.writeString("paper_doc_download");
                    break;
                }
                case PAPER_DOC_EDIT: {
                    g.writeString("paper_doc_edit");
                    break;
                }
                case PAPER_DOC_EDIT_COMMENT: {
                    g.writeString("paper_doc_edit_comment");
                    break;
                }
                case PAPER_DOC_FOLLOWED: {
                    g.writeString("paper_doc_followed");
                    break;
                }
                case PAPER_DOC_MENTION: {
                    g.writeString("paper_doc_mention");
                    break;
                }
                case PAPER_DOC_OWNERSHIP_CHANGED: {
                    g.writeString("paper_doc_ownership_changed");
                    break;
                }
                case PAPER_DOC_REQUEST_ACCESS: {
                    g.writeString("paper_doc_request_access");
                    break;
                }
                case PAPER_DOC_RESOLVE_COMMENT: {
                    g.writeString("paper_doc_resolve_comment");
                    break;
                }
                case PAPER_DOC_REVERT: {
                    g.writeString("paper_doc_revert");
                    break;
                }
                case PAPER_DOC_SLACK_SHARE: {
                    g.writeString("paper_doc_slack_share");
                    break;
                }
                case PAPER_DOC_TEAM_INVITE: {
                    g.writeString("paper_doc_team_invite");
                    break;
                }
                case PAPER_DOC_TRASHED: {
                    g.writeString("paper_doc_trashed");
                    break;
                }
                case PAPER_DOC_UNRESOLVE_COMMENT: {
                    g.writeString("paper_doc_unresolve_comment");
                    break;
                }
                case PAPER_DOC_UNTRASHED: {
                    g.writeString("paper_doc_untrashed");
                    break;
                }
                case PAPER_DOC_VIEW: {
                    g.writeString("paper_doc_view");
                    break;
                }
                case PAPER_EXTERNAL_VIEW_ALLOW: {
                    g.writeString("paper_external_view_allow");
                    break;
                }
                case PAPER_EXTERNAL_VIEW_DEFAULT_TEAM: {
                    g.writeString("paper_external_view_default_team");
                    break;
                }
                case PAPER_EXTERNAL_VIEW_FORBID: {
                    g.writeString("paper_external_view_forbid");
                    break;
                }
                case PAPER_FOLDER_CHANGE_SUBSCRIPTION: {
                    g.writeString("paper_folder_change_subscription");
                    break;
                }
                case PAPER_FOLDER_DELETED: {
                    g.writeString("paper_folder_deleted");
                    break;
                }
                case PAPER_FOLDER_FOLLOWED: {
                    g.writeString("paper_folder_followed");
                    break;
                }
                case PAPER_FOLDER_TEAM_INVITE: {
                    g.writeString("paper_folder_team_invite");
                    break;
                }
                case PAPER_PUBLISHED_LINK_CHANGE_PERMISSION: {
                    g.writeString("paper_published_link_change_permission");
                    break;
                }
                case PAPER_PUBLISHED_LINK_CREATE: {
                    g.writeString("paper_published_link_create");
                    break;
                }
                case PAPER_PUBLISHED_LINK_DISABLED: {
                    g.writeString("paper_published_link_disabled");
                    break;
                }
                case PAPER_PUBLISHED_LINK_VIEW: {
                    g.writeString("paper_published_link_view");
                    break;
                }
                case PASSWORD_CHANGE: {
                    g.writeString("password_change");
                    break;
                }
                case PASSWORD_RESET: {
                    g.writeString("password_reset");
                    break;
                }
                case PASSWORD_RESET_ALL: {
                    g.writeString("password_reset_all");
                    break;
                }
                case CLASSIFICATION_CREATE_REPORT: {
                    g.writeString("classification_create_report");
                    break;
                }
                case CLASSIFICATION_CREATE_REPORT_FAIL: {
                    g.writeString("classification_create_report_fail");
                    break;
                }
                case EMM_CREATE_EXCEPTIONS_REPORT: {
                    g.writeString("emm_create_exceptions_report");
                    break;
                }
                case EMM_CREATE_USAGE_REPORT: {
                    g.writeString("emm_create_usage_report");
                    break;
                }
                case EXPORT_MEMBERS_REPORT: {
                    g.writeString("export_members_report");
                    break;
                }
                case EXPORT_MEMBERS_REPORT_FAIL: {
                    g.writeString("export_members_report_fail");
                    break;
                }
                case EXTERNAL_SHARING_CREATE_REPORT: {
                    g.writeString("external_sharing_create_report");
                    break;
                }
                case EXTERNAL_SHARING_REPORT_FAILED: {
                    g.writeString("external_sharing_report_failed");
                    break;
                }
                case NO_EXPIRATION_LINK_GEN_CREATE_REPORT: {
                    g.writeString("no_expiration_link_gen_create_report");
                    break;
                }
                case NO_EXPIRATION_LINK_GEN_REPORT_FAILED: {
                    g.writeString("no_expiration_link_gen_report_failed");
                    break;
                }
                case NO_PASSWORD_LINK_GEN_CREATE_REPORT: {
                    g.writeString("no_password_link_gen_create_report");
                    break;
                }
                case NO_PASSWORD_LINK_GEN_REPORT_FAILED: {
                    g.writeString("no_password_link_gen_report_failed");
                    break;
                }
                case NO_PASSWORD_LINK_VIEW_CREATE_REPORT: {
                    g.writeString("no_password_link_view_create_report");
                    break;
                }
                case NO_PASSWORD_LINK_VIEW_REPORT_FAILED: {
                    g.writeString("no_password_link_view_report_failed");
                    break;
                }
                case OUTDATED_LINK_VIEW_CREATE_REPORT: {
                    g.writeString("outdated_link_view_create_report");
                    break;
                }
                case OUTDATED_LINK_VIEW_REPORT_FAILED: {
                    g.writeString("outdated_link_view_report_failed");
                    break;
                }
                case PAPER_ADMIN_EXPORT_START: {
                    g.writeString("paper_admin_export_start");
                    break;
                }
                case SMART_SYNC_CREATE_ADMIN_PRIVILEGE_REPORT: {
                    g.writeString("smart_sync_create_admin_privilege_report");
                    break;
                }
                case TEAM_ACTIVITY_CREATE_REPORT: {
                    g.writeString("team_activity_create_report");
                    break;
                }
                case TEAM_ACTIVITY_CREATE_REPORT_FAIL: {
                    g.writeString("team_activity_create_report_fail");
                    break;
                }
                case COLLECTION_SHARE: {
                    g.writeString("collection_share");
                    break;
                }
                case FILE_TRANSFERS_FILE_ADD: {
                    g.writeString("file_transfers_file_add");
                    break;
                }
                case FILE_TRANSFERS_TRANSFER_DELETE: {
                    g.writeString("file_transfers_transfer_delete");
                    break;
                }
                case FILE_TRANSFERS_TRANSFER_DOWNLOAD: {
                    g.writeString("file_transfers_transfer_download");
                    break;
                }
                case FILE_TRANSFERS_TRANSFER_SEND: {
                    g.writeString("file_transfers_transfer_send");
                    break;
                }
                case FILE_TRANSFERS_TRANSFER_VIEW: {
                    g.writeString("file_transfers_transfer_view");
                    break;
                }
                case NOTE_ACL_INVITE_ONLY: {
                    g.writeString("note_acl_invite_only");
                    break;
                }
                case NOTE_ACL_LINK: {
                    g.writeString("note_acl_link");
                    break;
                }
                case NOTE_ACL_TEAM_LINK: {
                    g.writeString("note_acl_team_link");
                    break;
                }
                case NOTE_SHARED: {
                    g.writeString("note_shared");
                    break;
                }
                case NOTE_SHARE_RECEIVE: {
                    g.writeString("note_share_receive");
                    break;
                }
                case OPEN_NOTE_SHARED: {
                    g.writeString("open_note_shared");
                    break;
                }
                case SF_ADD_GROUP: {
                    g.writeString("sf_add_group");
                    break;
                }
                case SF_ALLOW_NON_MEMBERS_TO_VIEW_SHARED_LINKS: {
                    g.writeString("sf_allow_non_members_to_view_shared_links");
                    break;
                }
                case SF_EXTERNAL_INVITE_WARN: {
                    g.writeString("sf_external_invite_warn");
                    break;
                }
                case SF_FB_INVITE: {
                    g.writeString("sf_fb_invite");
                    break;
                }
                case SF_FB_INVITE_CHANGE_ROLE: {
                    g.writeString("sf_fb_invite_change_role");
                    break;
                }
                case SF_FB_UNINVITE: {
                    g.writeString("sf_fb_uninvite");
                    break;
                }
                case SF_INVITE_GROUP: {
                    g.writeString("sf_invite_group");
                    break;
                }
                case SF_TEAM_GRANT_ACCESS: {
                    g.writeString("sf_team_grant_access");
                    break;
                }
                case SF_TEAM_INVITE: {
                    g.writeString("sf_team_invite");
                    break;
                }
                case SF_TEAM_INVITE_CHANGE_ROLE: {
                    g.writeString("sf_team_invite_change_role");
                    break;
                }
                case SF_TEAM_JOIN: {
                    g.writeString("sf_team_join");
                    break;
                }
                case SF_TEAM_JOIN_FROM_OOB_LINK: {
                    g.writeString("sf_team_join_from_oob_link");
                    break;
                }
                case SF_TEAM_UNINVITE: {
                    g.writeString("sf_team_uninvite");
                    break;
                }
                case SHARED_CONTENT_ADD_INVITEES: {
                    g.writeString("shared_content_add_invitees");
                    break;
                }
                case SHARED_CONTENT_ADD_LINK_EXPIRY: {
                    g.writeString("shared_content_add_link_expiry");
                    break;
                }
                case SHARED_CONTENT_ADD_LINK_PASSWORD: {
                    g.writeString("shared_content_add_link_password");
                    break;
                }
                case SHARED_CONTENT_ADD_MEMBER: {
                    g.writeString("shared_content_add_member");
                    break;
                }
                case SHARED_CONTENT_CHANGE_DOWNLOADS_POLICY: {
                    g.writeString("shared_content_change_downloads_policy");
                    break;
                }
                case SHARED_CONTENT_CHANGE_INVITEE_ROLE: {
                    g.writeString("shared_content_change_invitee_role");
                    break;
                }
                case SHARED_CONTENT_CHANGE_LINK_AUDIENCE: {
                    g.writeString("shared_content_change_link_audience");
                    break;
                }
                case SHARED_CONTENT_CHANGE_LINK_EXPIRY: {
                    g.writeString("shared_content_change_link_expiry");
                    break;
                }
                case SHARED_CONTENT_CHANGE_LINK_PASSWORD: {
                    g.writeString("shared_content_change_link_password");
                    break;
                }
                case SHARED_CONTENT_CHANGE_MEMBER_ROLE: {
                    g.writeString("shared_content_change_member_role");
                    break;
                }
                case SHARED_CONTENT_CHANGE_VIEWER_INFO_POLICY: {
                    g.writeString("shared_content_change_viewer_info_policy");
                    break;
                }
                case SHARED_CONTENT_CLAIM_INVITATION: {
                    g.writeString("shared_content_claim_invitation");
                    break;
                }
                case SHARED_CONTENT_COPY: {
                    g.writeString("shared_content_copy");
                    break;
                }
                case SHARED_CONTENT_DOWNLOAD: {
                    g.writeString("shared_content_download");
                    break;
                }
                case SHARED_CONTENT_RELINQUISH_MEMBERSHIP: {
                    g.writeString("shared_content_relinquish_membership");
                    break;
                }
                case SHARED_CONTENT_REMOVE_INVITEES: {
                    g.writeString("shared_content_remove_invitees");
                    break;
                }
                case SHARED_CONTENT_REMOVE_LINK_EXPIRY: {
                    g.writeString("shared_content_remove_link_expiry");
                    break;
                }
                case SHARED_CONTENT_REMOVE_LINK_PASSWORD: {
                    g.writeString("shared_content_remove_link_password");
                    break;
                }
                case SHARED_CONTENT_REMOVE_MEMBER: {
                    g.writeString("shared_content_remove_member");
                    break;
                }
                case SHARED_CONTENT_REQUEST_ACCESS: {
                    g.writeString("shared_content_request_access");
                    break;
                }
                case SHARED_CONTENT_RESTORE_INVITEES: {
                    g.writeString("shared_content_restore_invitees");
                    break;
                }
                case SHARED_CONTENT_RESTORE_MEMBER: {
                    g.writeString("shared_content_restore_member");
                    break;
                }
                case SHARED_CONTENT_UNSHARE: {
                    g.writeString("shared_content_unshare");
                    break;
                }
                case SHARED_CONTENT_VIEW: {
                    g.writeString("shared_content_view");
                    break;
                }
                case SHARED_FOLDER_CHANGE_LINK_POLICY: {
                    g.writeString("shared_folder_change_link_policy");
                    break;
                }
                case SHARED_FOLDER_CHANGE_MEMBERS_INHERITANCE_POLICY: {
                    g.writeString("shared_folder_change_members_inheritance_policy");
                    break;
                }
                case SHARED_FOLDER_CHANGE_MEMBERS_MANAGEMENT_POLICY: {
                    g.writeString("shared_folder_change_members_management_policy");
                    break;
                }
                case SHARED_FOLDER_CHANGE_MEMBERS_POLICY: {
                    g.writeString("shared_folder_change_members_policy");
                    break;
                }
                case SHARED_FOLDER_CREATE: {
                    g.writeString("shared_folder_create");
                    break;
                }
                case SHARED_FOLDER_DECLINE_INVITATION: {
                    g.writeString("shared_folder_decline_invitation");
                    break;
                }
                case SHARED_FOLDER_MOUNT: {
                    g.writeString("shared_folder_mount");
                    break;
                }
                case SHARED_FOLDER_NEST: {
                    g.writeString("shared_folder_nest");
                    break;
                }
                case SHARED_FOLDER_TRANSFER_OWNERSHIP: {
                    g.writeString("shared_folder_transfer_ownership");
                    break;
                }
                case SHARED_FOLDER_UNMOUNT: {
                    g.writeString("shared_folder_unmount");
                    break;
                }
                case SHARED_LINK_ADD_EXPIRY: {
                    g.writeString("shared_link_add_expiry");
                    break;
                }
                case SHARED_LINK_CHANGE_EXPIRY: {
                    g.writeString("shared_link_change_expiry");
                    break;
                }
                case SHARED_LINK_CHANGE_VISIBILITY: {
                    g.writeString("shared_link_change_visibility");
                    break;
                }
                case SHARED_LINK_COPY: {
                    g.writeString("shared_link_copy");
                    break;
                }
                case SHARED_LINK_CREATE: {
                    g.writeString("shared_link_create");
                    break;
                }
                case SHARED_LINK_DISABLE: {
                    g.writeString("shared_link_disable");
                    break;
                }
                case SHARED_LINK_DOWNLOAD: {
                    g.writeString("shared_link_download");
                    break;
                }
                case SHARED_LINK_REMOVE_EXPIRY: {
                    g.writeString("shared_link_remove_expiry");
                    break;
                }
                case SHARED_LINK_SETTINGS_ADD_EXPIRATION: {
                    g.writeString("shared_link_settings_add_expiration");
                    break;
                }
                case SHARED_LINK_SETTINGS_ADD_PASSWORD: {
                    g.writeString("shared_link_settings_add_password");
                    break;
                }
                case SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_DISABLED: {
                    g.writeString("shared_link_settings_allow_download_disabled");
                    break;
                }
                case SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_ENABLED: {
                    g.writeString("shared_link_settings_allow_download_enabled");
                    break;
                }
                case SHARED_LINK_SETTINGS_CHANGE_AUDIENCE: {
                    g.writeString("shared_link_settings_change_audience");
                    break;
                }
                case SHARED_LINK_SETTINGS_CHANGE_EXPIRATION: {
                    g.writeString("shared_link_settings_change_expiration");
                    break;
                }
                case SHARED_LINK_SETTINGS_CHANGE_PASSWORD: {
                    g.writeString("shared_link_settings_change_password");
                    break;
                }
                case SHARED_LINK_SETTINGS_REMOVE_EXPIRATION: {
                    g.writeString("shared_link_settings_remove_expiration");
                    break;
                }
                case SHARED_LINK_SETTINGS_REMOVE_PASSWORD: {
                    g.writeString("shared_link_settings_remove_password");
                    break;
                }
                case SHARED_LINK_SHARE: {
                    g.writeString("shared_link_share");
                    break;
                }
                case SHARED_LINK_VIEW: {
                    g.writeString("shared_link_view");
                    break;
                }
                case SHARED_NOTE_OPENED: {
                    g.writeString("shared_note_opened");
                    break;
                }
                case SHMODEL_DISABLE_DOWNLOADS: {
                    g.writeString("shmodel_disable_downloads");
                    break;
                }
                case SHMODEL_ENABLE_DOWNLOADS: {
                    g.writeString("shmodel_enable_downloads");
                    break;
                }
                case SHMODEL_GROUP_SHARE: {
                    g.writeString("shmodel_group_share");
                    break;
                }
                case SHOWCASE_ACCESS_GRANTED: {
                    g.writeString("showcase_access_granted");
                    break;
                }
                case SHOWCASE_ADD_MEMBER: {
                    g.writeString("showcase_add_member");
                    break;
                }
                case SHOWCASE_ARCHIVED: {
                    g.writeString("showcase_archived");
                    break;
                }
                case SHOWCASE_CREATED: {
                    g.writeString("showcase_created");
                    break;
                }
                case SHOWCASE_DELETE_COMMENT: {
                    g.writeString("showcase_delete_comment");
                    break;
                }
                case SHOWCASE_EDITED: {
                    g.writeString("showcase_edited");
                    break;
                }
                case SHOWCASE_EDIT_COMMENT: {
                    g.writeString("showcase_edit_comment");
                    break;
                }
                case SHOWCASE_FILE_ADDED: {
                    g.writeString("showcase_file_added");
                    break;
                }
                case SHOWCASE_FILE_DOWNLOAD: {
                    g.writeString("showcase_file_download");
                    break;
                }
                case SHOWCASE_FILE_REMOVED: {
                    g.writeString("showcase_file_removed");
                    break;
                }
                case SHOWCASE_FILE_VIEW: {
                    g.writeString("showcase_file_view");
                    break;
                }
                case SHOWCASE_PERMANENTLY_DELETED: {
                    g.writeString("showcase_permanently_deleted");
                    break;
                }
                case SHOWCASE_POST_COMMENT: {
                    g.writeString("showcase_post_comment");
                    break;
                }
                case SHOWCASE_REMOVE_MEMBER: {
                    g.writeString("showcase_remove_member");
                    break;
                }
                case SHOWCASE_RENAMED: {
                    g.writeString("showcase_renamed");
                    break;
                }
                case SHOWCASE_REQUEST_ACCESS: {
                    g.writeString("showcase_request_access");
                    break;
                }
                case SHOWCASE_RESOLVE_COMMENT: {
                    g.writeString("showcase_resolve_comment");
                    break;
                }
                case SHOWCASE_RESTORED: {
                    g.writeString("showcase_restored");
                    break;
                }
                case SHOWCASE_TRASHED: {
                    g.writeString("showcase_trashed");
                    break;
                }
                case SHOWCASE_TRASHED_DEPRECATED: {
                    g.writeString("showcase_trashed_deprecated");
                    break;
                }
                case SHOWCASE_UNRESOLVE_COMMENT: {
                    g.writeString("showcase_unresolve_comment");
                    break;
                }
                case SHOWCASE_UNTRASHED: {
                    g.writeString("showcase_untrashed");
                    break;
                }
                case SHOWCASE_UNTRASHED_DEPRECATED: {
                    g.writeString("showcase_untrashed_deprecated");
                    break;
                }
                case SHOWCASE_VIEW: {
                    g.writeString("showcase_view");
                    break;
                }
                case SSO_ADD_CERT: {
                    g.writeString("sso_add_cert");
                    break;
                }
                case SSO_ADD_LOGIN_URL: {
                    g.writeString("sso_add_login_url");
                    break;
                }
                case SSO_ADD_LOGOUT_URL: {
                    g.writeString("sso_add_logout_url");
                    break;
                }
                case SSO_CHANGE_CERT: {
                    g.writeString("sso_change_cert");
                    break;
                }
                case SSO_CHANGE_LOGIN_URL: {
                    g.writeString("sso_change_login_url");
                    break;
                }
                case SSO_CHANGE_LOGOUT_URL: {
                    g.writeString("sso_change_logout_url");
                    break;
                }
                case SSO_CHANGE_SAML_IDENTITY_MODE: {
                    g.writeString("sso_change_saml_identity_mode");
                    break;
                }
                case SSO_REMOVE_CERT: {
                    g.writeString("sso_remove_cert");
                    break;
                }
                case SSO_REMOVE_LOGIN_URL: {
                    g.writeString("sso_remove_login_url");
                    break;
                }
                case SSO_REMOVE_LOGOUT_URL: {
                    g.writeString("sso_remove_logout_url");
                    break;
                }
                case TEAM_FOLDER_CHANGE_STATUS: {
                    g.writeString("team_folder_change_status");
                    break;
                }
                case TEAM_FOLDER_CREATE: {
                    g.writeString("team_folder_create");
                    break;
                }
                case TEAM_FOLDER_DOWNGRADE: {
                    g.writeString("team_folder_downgrade");
                    break;
                }
                case TEAM_FOLDER_PERMANENTLY_DELETE: {
                    g.writeString("team_folder_permanently_delete");
                    break;
                }
                case TEAM_FOLDER_RENAME: {
                    g.writeString("team_folder_rename");
                    break;
                }
                case TEAM_SELECTIVE_SYNC_SETTINGS_CHANGED: {
                    g.writeString("team_selective_sync_settings_changed");
                    break;
                }
                case ACCOUNT_CAPTURE_CHANGE_POLICY: {
                    g.writeString("account_capture_change_policy");
                    break;
                }
                case ADMIN_EMAIL_REMINDERS_CHANGED: {
                    g.writeString("admin_email_reminders_changed");
                    break;
                }
                case ALLOW_DOWNLOAD_DISABLED: {
                    g.writeString("allow_download_disabled");
                    break;
                }
                case ALLOW_DOWNLOAD_ENABLED: {
                    g.writeString("allow_download_enabled");
                    break;
                }
                case APP_PERMISSIONS_CHANGED: {
                    g.writeString("app_permissions_changed");
                    break;
                }
                case CAMERA_UPLOADS_POLICY_CHANGED: {
                    g.writeString("camera_uploads_policy_changed");
                    break;
                }
                case CAPTURE_TRANSCRIPT_POLICY_CHANGED: {
                    g.writeString("capture_transcript_policy_changed");
                    break;
                }
                case CLASSIFICATION_CHANGE_POLICY: {
                    g.writeString("classification_change_policy");
                    break;
                }
                case COMPUTER_BACKUP_POLICY_CHANGED: {
                    g.writeString("computer_backup_policy_changed");
                    break;
                }
                case CONTENT_ADMINISTRATION_POLICY_CHANGED: {
                    g.writeString("content_administration_policy_changed");
                    break;
                }
                case DATA_PLACEMENT_RESTRICTION_CHANGE_POLICY: {
                    g.writeString("data_placement_restriction_change_policy");
                    break;
                }
                case DATA_PLACEMENT_RESTRICTION_SATISFY_POLICY: {
                    g.writeString("data_placement_restriction_satisfy_policy");
                    break;
                }
                case DEVICE_APPROVALS_ADD_EXCEPTION: {
                    g.writeString("device_approvals_add_exception");
                    break;
                }
                case DEVICE_APPROVALS_CHANGE_DESKTOP_POLICY: {
                    g.writeString("device_approvals_change_desktop_policy");
                    break;
                }
                case DEVICE_APPROVALS_CHANGE_MOBILE_POLICY: {
                    g.writeString("device_approvals_change_mobile_policy");
                    break;
                }
                case DEVICE_APPROVALS_CHANGE_OVERAGE_ACTION: {
                    g.writeString("device_approvals_change_overage_action");
                    break;
                }
                case DEVICE_APPROVALS_CHANGE_UNLINK_ACTION: {
                    g.writeString("device_approvals_change_unlink_action");
                    break;
                }
                case DEVICE_APPROVALS_REMOVE_EXCEPTION: {
                    g.writeString("device_approvals_remove_exception");
                    break;
                }
                case DIRECTORY_RESTRICTIONS_ADD_MEMBERS: {
                    g.writeString("directory_restrictions_add_members");
                    break;
                }
                case DIRECTORY_RESTRICTIONS_REMOVE_MEMBERS: {
                    g.writeString("directory_restrictions_remove_members");
                    break;
                }
                case DROPBOX_PASSWORDS_POLICY_CHANGED: {
                    g.writeString("dropbox_passwords_policy_changed");
                    break;
                }
                case EMAIL_INGEST_POLICY_CHANGED: {
                    g.writeString("email_ingest_policy_changed");
                    break;
                }
                case EMM_ADD_EXCEPTION: {
                    g.writeString("emm_add_exception");
                    break;
                }
                case EMM_CHANGE_POLICY: {
                    g.writeString("emm_change_policy");
                    break;
                }
                case EMM_REMOVE_EXCEPTION: {
                    g.writeString("emm_remove_exception");
                    break;
                }
                case EXTENDED_VERSION_HISTORY_CHANGE_POLICY: {
                    g.writeString("extended_version_history_change_policy");
                    break;
                }
                case EXTERNAL_DRIVE_BACKUP_POLICY_CHANGED: {
                    g.writeString("external_drive_backup_policy_changed");
                    break;
                }
                case FILE_COMMENTS_CHANGE_POLICY: {
                    g.writeString("file_comments_change_policy");
                    break;
                }
                case FILE_LOCKING_POLICY_CHANGED: {
                    g.writeString("file_locking_policy_changed");
                    break;
                }
                case FILE_REQUESTS_CHANGE_POLICY: {
                    g.writeString("file_requests_change_policy");
                    break;
                }
                case FILE_REQUESTS_EMAILS_ENABLED: {
                    g.writeString("file_requests_emails_enabled");
                    break;
                }
                case FILE_REQUESTS_EMAILS_RESTRICTED_TO_TEAM_ONLY: {
                    g.writeString("file_requests_emails_restricted_to_team_only");
                    break;
                }
                case FILE_TRANSFERS_POLICY_CHANGED: {
                    g.writeString("file_transfers_policy_changed");
                    break;
                }
                case GOOGLE_SSO_CHANGE_POLICY: {
                    g.writeString("google_sso_change_policy");
                    break;
                }
                case GROUP_USER_MANAGEMENT_CHANGE_POLICY: {
                    g.writeString("group_user_management_change_policy");
                    break;
                }
                case INTEGRATION_POLICY_CHANGED: {
                    g.writeString("integration_policy_changed");
                    break;
                }
                case INVITE_ACCEPTANCE_EMAIL_POLICY_CHANGED: {
                    g.writeString("invite_acceptance_email_policy_changed");
                    break;
                }
                case MEMBER_REQUESTS_CHANGE_POLICY: {
                    g.writeString("member_requests_change_policy");
                    break;
                }
                case MEMBER_SEND_INVITE_POLICY_CHANGED: {
                    g.writeString("member_send_invite_policy_changed");
                    break;
                }
                case MEMBER_SPACE_LIMITS_ADD_EXCEPTION: {
                    g.writeString("member_space_limits_add_exception");
                    break;
                }
                case MEMBER_SPACE_LIMITS_CHANGE_CAPS_TYPE_POLICY: {
                    g.writeString("member_space_limits_change_caps_type_policy");
                    break;
                }
                case MEMBER_SPACE_LIMITS_CHANGE_POLICY: {
                    g.writeString("member_space_limits_change_policy");
                    break;
                }
                case MEMBER_SPACE_LIMITS_REMOVE_EXCEPTION: {
                    g.writeString("member_space_limits_remove_exception");
                    break;
                }
                case MEMBER_SUGGESTIONS_CHANGE_POLICY: {
                    g.writeString("member_suggestions_change_policy");
                    break;
                }
                case MICROSOFT_OFFICE_ADDIN_CHANGE_POLICY: {
                    g.writeString("microsoft_office_addin_change_policy");
                    break;
                }
                case NETWORK_CONTROL_CHANGE_POLICY: {
                    g.writeString("network_control_change_policy");
                    break;
                }
                case PAPER_CHANGE_DEPLOYMENT_POLICY: {
                    g.writeString("paper_change_deployment_policy");
                    break;
                }
                case PAPER_CHANGE_MEMBER_LINK_POLICY: {
                    g.writeString("paper_change_member_link_policy");
                    break;
                }
                case PAPER_CHANGE_MEMBER_POLICY: {
                    g.writeString("paper_change_member_policy");
                    break;
                }
                case PAPER_CHANGE_POLICY: {
                    g.writeString("paper_change_policy");
                    break;
                }
                case PAPER_DEFAULT_FOLDER_POLICY_CHANGED: {
                    g.writeString("paper_default_folder_policy_changed");
                    break;
                }
                case PAPER_DESKTOP_POLICY_CHANGED: {
                    g.writeString("paper_desktop_policy_changed");
                    break;
                }
                case PAPER_ENABLED_USERS_GROUP_ADDITION: {
                    g.writeString("paper_enabled_users_group_addition");
                    break;
                }
                case PAPER_ENABLED_USERS_GROUP_REMOVAL: {
                    g.writeString("paper_enabled_users_group_removal");
                    break;
                }
                case PASSWORD_STRENGTH_REQUIREMENTS_CHANGE_POLICY: {
                    g.writeString("password_strength_requirements_change_policy");
                    break;
                }
                case PERMANENT_DELETE_CHANGE_POLICY: {
                    g.writeString("permanent_delete_change_policy");
                    break;
                }
                case RESELLER_SUPPORT_CHANGE_POLICY: {
                    g.writeString("reseller_support_change_policy");
                    break;
                }
                case REWIND_POLICY_CHANGED: {
                    g.writeString("rewind_policy_changed");
                    break;
                }
                case SEND_FOR_SIGNATURE_POLICY_CHANGED: {
                    g.writeString("send_for_signature_policy_changed");
                    break;
                }
                case SHARING_CHANGE_FOLDER_JOIN_POLICY: {
                    g.writeString("sharing_change_folder_join_policy");
                    break;
                }
                case SHARING_CHANGE_LINK_ALLOW_CHANGE_EXPIRATION_POLICY: {
                    g.writeString("sharing_change_link_allow_change_expiration_policy");
                    break;
                }
                case SHARING_CHANGE_LINK_DEFAULT_EXPIRATION_POLICY: {
                    g.writeString("sharing_change_link_default_expiration_policy");
                    break;
                }
                case SHARING_CHANGE_LINK_ENFORCE_PASSWORD_POLICY: {
                    g.writeString("sharing_change_link_enforce_password_policy");
                    break;
                }
                case SHARING_CHANGE_LINK_POLICY: {
                    g.writeString("sharing_change_link_policy");
                    break;
                }
                case SHARING_CHANGE_MEMBER_POLICY: {
                    g.writeString("sharing_change_member_policy");
                    break;
                }
                case SHOWCASE_CHANGE_DOWNLOAD_POLICY: {
                    g.writeString("showcase_change_download_policy");
                    break;
                }
                case SHOWCASE_CHANGE_ENABLED_POLICY: {
                    g.writeString("showcase_change_enabled_policy");
                    break;
                }
                case SHOWCASE_CHANGE_EXTERNAL_SHARING_POLICY: {
                    g.writeString("showcase_change_external_sharing_policy");
                    break;
                }
                case SMARTER_SMART_SYNC_POLICY_CHANGED: {
                    g.writeString("smarter_smart_sync_policy_changed");
                    break;
                }
                case SMART_SYNC_CHANGE_POLICY: {
                    g.writeString("smart_sync_change_policy");
                    break;
                }
                case SMART_SYNC_NOT_OPT_OUT: {
                    g.writeString("smart_sync_not_opt_out");
                    break;
                }
                case SMART_SYNC_OPT_OUT: {
                    g.writeString("smart_sync_opt_out");
                    break;
                }
                case SSO_CHANGE_POLICY: {
                    g.writeString("sso_change_policy");
                    break;
                }
                case TEAM_BRANDING_POLICY_CHANGED: {
                    g.writeString("team_branding_policy_changed");
                    break;
                }
                case TEAM_EXTENSIONS_POLICY_CHANGED: {
                    g.writeString("team_extensions_policy_changed");
                    break;
                }
                case TEAM_SELECTIVE_SYNC_POLICY_CHANGED: {
                    g.writeString("team_selective_sync_policy_changed");
                    break;
                }
                case TEAM_SHARING_WHITELIST_SUBJECTS_CHANGED: {
                    g.writeString("team_sharing_whitelist_subjects_changed");
                    break;
                }
                case TFA_ADD_EXCEPTION: {
                    g.writeString("tfa_add_exception");
                    break;
                }
                case TFA_CHANGE_POLICY: {
                    g.writeString("tfa_change_policy");
                    break;
                }
                case TFA_REMOVE_EXCEPTION: {
                    g.writeString("tfa_remove_exception");
                    break;
                }
                case TWO_ACCOUNT_CHANGE_POLICY: {
                    g.writeString("two_account_change_policy");
                    break;
                }
                case VIEWER_INFO_POLICY_CHANGED: {
                    g.writeString("viewer_info_policy_changed");
                    break;
                }
                case WATERMARKING_POLICY_CHANGED: {
                    g.writeString("watermarking_policy_changed");
                    break;
                }
                case WEB_SESSIONS_CHANGE_ACTIVE_SESSION_LIMIT: {
                    g.writeString("web_sessions_change_active_session_limit");
                    break;
                }
                case WEB_SESSIONS_CHANGE_FIXED_LENGTH_POLICY: {
                    g.writeString("web_sessions_change_fixed_length_policy");
                    break;
                }
                case WEB_SESSIONS_CHANGE_IDLE_LENGTH_POLICY: {
                    g.writeString("web_sessions_change_idle_length_policy");
                    break;
                }
                case DATA_RESIDENCY_MIGRATION_REQUEST_SUCCESSFUL: {
                    g.writeString("data_residency_migration_request_successful");
                    break;
                }
                case DATA_RESIDENCY_MIGRATION_REQUEST_UNSUCCESSFUL: {
                    g.writeString("data_residency_migration_request_unsuccessful");
                    break;
                }
                case TEAM_MERGE_FROM: {
                    g.writeString("team_merge_from");
                    break;
                }
                case TEAM_MERGE_TO: {
                    g.writeString("team_merge_to");
                    break;
                }
                case TEAM_PROFILE_ADD_BACKGROUND: {
                    g.writeString("team_profile_add_background");
                    break;
                }
                case TEAM_PROFILE_ADD_LOGO: {
                    g.writeString("team_profile_add_logo");
                    break;
                }
                case TEAM_PROFILE_CHANGE_BACKGROUND: {
                    g.writeString("team_profile_change_background");
                    break;
                }
                case TEAM_PROFILE_CHANGE_DEFAULT_LANGUAGE: {
                    g.writeString("team_profile_change_default_language");
                    break;
                }
                case TEAM_PROFILE_CHANGE_LOGO: {
                    g.writeString("team_profile_change_logo");
                    break;
                }
                case TEAM_PROFILE_CHANGE_NAME: {
                    g.writeString("team_profile_change_name");
                    break;
                }
                case TEAM_PROFILE_REMOVE_BACKGROUND: {
                    g.writeString("team_profile_remove_background");
                    break;
                }
                case TEAM_PROFILE_REMOVE_LOGO: {
                    g.writeString("team_profile_remove_logo");
                    break;
                }
                case TFA_ADD_BACKUP_PHONE: {
                    g.writeString("tfa_add_backup_phone");
                    break;
                }
                case TFA_ADD_SECURITY_KEY: {
                    g.writeString("tfa_add_security_key");
                    break;
                }
                case TFA_CHANGE_BACKUP_PHONE: {
                    g.writeString("tfa_change_backup_phone");
                    break;
                }
                case TFA_CHANGE_STATUS: {
                    g.writeString("tfa_change_status");
                    break;
                }
                case TFA_REMOVE_BACKUP_PHONE: {
                    g.writeString("tfa_remove_backup_phone");
                    break;
                }
                case TFA_REMOVE_SECURITY_KEY: {
                    g.writeString("tfa_remove_security_key");
                    break;
                }
                case TFA_RESET: {
                    g.writeString("tfa_reset");
                    break;
                }
                case CHANGED_ENTERPRISE_ADMIN_ROLE: {
                    g.writeString("changed_enterprise_admin_role");
                    break;
                }
                case CHANGED_ENTERPRISE_CONNECTED_TEAM_STATUS: {
                    g.writeString("changed_enterprise_connected_team_status");
                    break;
                }
                case ENDED_ENTERPRISE_ADMIN_SESSION: {
                    g.writeString("ended_enterprise_admin_session");
                    break;
                }
                case ENDED_ENTERPRISE_ADMIN_SESSION_DEPRECATED: {
                    g.writeString("ended_enterprise_admin_session_deprecated");
                    break;
                }
                case ENTERPRISE_SETTINGS_LOCKING: {
                    g.writeString("enterprise_settings_locking");
                    break;
                }
                case GUEST_ADMIN_CHANGE_STATUS: {
                    g.writeString("guest_admin_change_status");
                    break;
                }
                case STARTED_ENTERPRISE_ADMIN_SESSION: {
                    g.writeString("started_enterprise_admin_session");
                    break;
                }
                case TEAM_MERGE_REQUEST_ACCEPTED: {
                    g.writeString("team_merge_request_accepted");
                    break;
                }
                case TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_PRIMARY_TEAM: {
                    g.writeString("team_merge_request_accepted_shown_to_primary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_SECONDARY_TEAM: {
                    g.writeString("team_merge_request_accepted_shown_to_secondary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_AUTO_CANCELED: {
                    g.writeString("team_merge_request_auto_canceled");
                    break;
                }
                case TEAM_MERGE_REQUEST_CANCELED: {
                    g.writeString("team_merge_request_canceled");
                    break;
                }
                case TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_PRIMARY_TEAM: {
                    g.writeString("team_merge_request_canceled_shown_to_primary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_SECONDARY_TEAM: {
                    g.writeString("team_merge_request_canceled_shown_to_secondary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_EXPIRED: {
                    g.writeString("team_merge_request_expired");
                    break;
                }
                case TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_PRIMARY_TEAM: {
                    g.writeString("team_merge_request_expired_shown_to_primary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_SECONDARY_TEAM: {
                    g.writeString("team_merge_request_expired_shown_to_secondary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_PRIMARY_TEAM: {
                    g.writeString("team_merge_request_rejected_shown_to_primary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_SECONDARY_TEAM: {
                    g.writeString("team_merge_request_rejected_shown_to_secondary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_REMINDER: {
                    g.writeString("team_merge_request_reminder");
                    break;
                }
                case TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_PRIMARY_TEAM: {
                    g.writeString("team_merge_request_reminder_shown_to_primary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_SECONDARY_TEAM: {
                    g.writeString("team_merge_request_reminder_shown_to_secondary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_REVOKED: {
                    g.writeString("team_merge_request_revoked");
                    break;
                }
                case TEAM_MERGE_REQUEST_SENT_SHOWN_TO_PRIMARY_TEAM: {
                    g.writeString("team_merge_request_sent_shown_to_primary_team");
                    break;
                }
                case TEAM_MERGE_REQUEST_SENT_SHOWN_TO_SECONDARY_TEAM: {
                    g.writeString("team_merge_request_sent_shown_to_secondary_team");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public EventTypeArg deserialize(JsonParser p) throws IOException, JsonParseException {
            EventTypeArg value;
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
            else if ("admin_alerting_alert_state_changed".equals(tag)) {
                value = EventTypeArg.ADMIN_ALERTING_ALERT_STATE_CHANGED;
            }
            else if ("admin_alerting_changed_alert_config".equals(tag)) {
                value = EventTypeArg.ADMIN_ALERTING_CHANGED_ALERT_CONFIG;
            }
            else if ("admin_alerting_triggered_alert".equals(tag)) {
                value = EventTypeArg.ADMIN_ALERTING_TRIGGERED_ALERT;
            }
            else if ("app_blocked_by_permissions".equals(tag)) {
                value = EventTypeArg.APP_BLOCKED_BY_PERMISSIONS;
            }
            else if ("app_link_team".equals(tag)) {
                value = EventTypeArg.APP_LINK_TEAM;
            }
            else if ("app_link_user".equals(tag)) {
                value = EventTypeArg.APP_LINK_USER;
            }
            else if ("app_unlink_team".equals(tag)) {
                value = EventTypeArg.APP_UNLINK_TEAM;
            }
            else if ("app_unlink_user".equals(tag)) {
                value = EventTypeArg.APP_UNLINK_USER;
            }
            else if ("integration_connected".equals(tag)) {
                value = EventTypeArg.INTEGRATION_CONNECTED;
            }
            else if ("integration_disconnected".equals(tag)) {
                value = EventTypeArg.INTEGRATION_DISCONNECTED;
            }
            else if ("file_add_comment".equals(tag)) {
                value = EventTypeArg.FILE_ADD_COMMENT;
            }
            else if ("file_change_comment_subscription".equals(tag)) {
                value = EventTypeArg.FILE_CHANGE_COMMENT_SUBSCRIPTION;
            }
            else if ("file_delete_comment".equals(tag)) {
                value = EventTypeArg.FILE_DELETE_COMMENT;
            }
            else if ("file_edit_comment".equals(tag)) {
                value = EventTypeArg.FILE_EDIT_COMMENT;
            }
            else if ("file_like_comment".equals(tag)) {
                value = EventTypeArg.FILE_LIKE_COMMENT;
            }
            else if ("file_resolve_comment".equals(tag)) {
                value = EventTypeArg.FILE_RESOLVE_COMMENT;
            }
            else if ("file_unlike_comment".equals(tag)) {
                value = EventTypeArg.FILE_UNLIKE_COMMENT;
            }
            else if ("file_unresolve_comment".equals(tag)) {
                value = EventTypeArg.FILE_UNRESOLVE_COMMENT;
            }
            else if ("governance_policy_add_folders".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_ADD_FOLDERS;
            }
            else if ("governance_policy_add_folder_failed".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_ADD_FOLDER_FAILED;
            }
            else if ("governance_policy_content_disposed".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_CONTENT_DISPOSED;
            }
            else if ("governance_policy_create".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_CREATE;
            }
            else if ("governance_policy_delete".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_DELETE;
            }
            else if ("governance_policy_edit_details".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_EDIT_DETAILS;
            }
            else if ("governance_policy_edit_duration".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_EDIT_DURATION;
            }
            else if ("governance_policy_export_created".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_EXPORT_CREATED;
            }
            else if ("governance_policy_export_removed".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_EXPORT_REMOVED;
            }
            else if ("governance_policy_remove_folders".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_REMOVE_FOLDERS;
            }
            else if ("governance_policy_report_created".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_REPORT_CREATED;
            }
            else if ("governance_policy_zip_part_downloaded".equals(tag)) {
                value = EventTypeArg.GOVERNANCE_POLICY_ZIP_PART_DOWNLOADED;
            }
            else if ("legal_holds_activate_a_hold".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_ACTIVATE_A_HOLD;
            }
            else if ("legal_holds_add_members".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_ADD_MEMBERS;
            }
            else if ("legal_holds_change_hold_details".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_CHANGE_HOLD_DETAILS;
            }
            else if ("legal_holds_change_hold_name".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_CHANGE_HOLD_NAME;
            }
            else if ("legal_holds_export_a_hold".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_EXPORT_A_HOLD;
            }
            else if ("legal_holds_export_cancelled".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_EXPORT_CANCELLED;
            }
            else if ("legal_holds_export_downloaded".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_EXPORT_DOWNLOADED;
            }
            else if ("legal_holds_export_removed".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_EXPORT_REMOVED;
            }
            else if ("legal_holds_release_a_hold".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_RELEASE_A_HOLD;
            }
            else if ("legal_holds_remove_members".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_REMOVE_MEMBERS;
            }
            else if ("legal_holds_report_a_hold".equals(tag)) {
                value = EventTypeArg.LEGAL_HOLDS_REPORT_A_HOLD;
            }
            else if ("device_change_ip_desktop".equals(tag)) {
                value = EventTypeArg.DEVICE_CHANGE_IP_DESKTOP;
            }
            else if ("device_change_ip_mobile".equals(tag)) {
                value = EventTypeArg.DEVICE_CHANGE_IP_MOBILE;
            }
            else if ("device_change_ip_web".equals(tag)) {
                value = EventTypeArg.DEVICE_CHANGE_IP_WEB;
            }
            else if ("device_delete_on_unlink_fail".equals(tag)) {
                value = EventTypeArg.DEVICE_DELETE_ON_UNLINK_FAIL;
            }
            else if ("device_delete_on_unlink_success".equals(tag)) {
                value = EventTypeArg.DEVICE_DELETE_ON_UNLINK_SUCCESS;
            }
            else if ("device_link_fail".equals(tag)) {
                value = EventTypeArg.DEVICE_LINK_FAIL;
            }
            else if ("device_link_success".equals(tag)) {
                value = EventTypeArg.DEVICE_LINK_SUCCESS;
            }
            else if ("device_management_disabled".equals(tag)) {
                value = EventTypeArg.DEVICE_MANAGEMENT_DISABLED;
            }
            else if ("device_management_enabled".equals(tag)) {
                value = EventTypeArg.DEVICE_MANAGEMENT_ENABLED;
            }
            else if ("device_sync_backup_status_changed".equals(tag)) {
                value = EventTypeArg.DEVICE_SYNC_BACKUP_STATUS_CHANGED;
            }
            else if ("device_unlink".equals(tag)) {
                value = EventTypeArg.DEVICE_UNLINK;
            }
            else if ("dropbox_passwords_exported".equals(tag)) {
                value = EventTypeArg.DROPBOX_PASSWORDS_EXPORTED;
            }
            else if ("dropbox_passwords_new_device_enrolled".equals(tag)) {
                value = EventTypeArg.DROPBOX_PASSWORDS_NEW_DEVICE_ENROLLED;
            }
            else if ("emm_refresh_auth_token".equals(tag)) {
                value = EventTypeArg.EMM_REFRESH_AUTH_TOKEN;
            }
            else if ("external_drive_backup_eligibility_status_checked".equals(tag)) {
                value = EventTypeArg.EXTERNAL_DRIVE_BACKUP_ELIGIBILITY_STATUS_CHECKED;
            }
            else if ("external_drive_backup_status_changed".equals(tag)) {
                value = EventTypeArg.EXTERNAL_DRIVE_BACKUP_STATUS_CHANGED;
            }
            else if ("account_capture_change_availability".equals(tag)) {
                value = EventTypeArg.ACCOUNT_CAPTURE_CHANGE_AVAILABILITY;
            }
            else if ("account_capture_migrate_account".equals(tag)) {
                value = EventTypeArg.ACCOUNT_CAPTURE_MIGRATE_ACCOUNT;
            }
            else if ("account_capture_notification_emails_sent".equals(tag)) {
                value = EventTypeArg.ACCOUNT_CAPTURE_NOTIFICATION_EMAILS_SENT;
            }
            else if ("account_capture_relinquish_account".equals(tag)) {
                value = EventTypeArg.ACCOUNT_CAPTURE_RELINQUISH_ACCOUNT;
            }
            else if ("disabled_domain_invites".equals(tag)) {
                value = EventTypeArg.DISABLED_DOMAIN_INVITES;
            }
            else if ("domain_invites_approve_request_to_join_team".equals(tag)) {
                value = EventTypeArg.DOMAIN_INVITES_APPROVE_REQUEST_TO_JOIN_TEAM;
            }
            else if ("domain_invites_decline_request_to_join_team".equals(tag)) {
                value = EventTypeArg.DOMAIN_INVITES_DECLINE_REQUEST_TO_JOIN_TEAM;
            }
            else if ("domain_invites_email_existing_users".equals(tag)) {
                value = EventTypeArg.DOMAIN_INVITES_EMAIL_EXISTING_USERS;
            }
            else if ("domain_invites_request_to_join_team".equals(tag)) {
                value = EventTypeArg.DOMAIN_INVITES_REQUEST_TO_JOIN_TEAM;
            }
            else if ("domain_invites_set_invite_new_user_pref_to_no".equals(tag)) {
                value = EventTypeArg.DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_NO;
            }
            else if ("domain_invites_set_invite_new_user_pref_to_yes".equals(tag)) {
                value = EventTypeArg.DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_YES;
            }
            else if ("domain_verification_add_domain_fail".equals(tag)) {
                value = EventTypeArg.DOMAIN_VERIFICATION_ADD_DOMAIN_FAIL;
            }
            else if ("domain_verification_add_domain_success".equals(tag)) {
                value = EventTypeArg.DOMAIN_VERIFICATION_ADD_DOMAIN_SUCCESS;
            }
            else if ("domain_verification_remove_domain".equals(tag)) {
                value = EventTypeArg.DOMAIN_VERIFICATION_REMOVE_DOMAIN;
            }
            else if ("enabled_domain_invites".equals(tag)) {
                value = EventTypeArg.ENABLED_DOMAIN_INVITES;
            }
            else if ("apply_naming_convention".equals(tag)) {
                value = EventTypeArg.APPLY_NAMING_CONVENTION;
            }
            else if ("create_folder".equals(tag)) {
                value = EventTypeArg.CREATE_FOLDER;
            }
            else if ("file_add".equals(tag)) {
                value = EventTypeArg.FILE_ADD;
            }
            else if ("file_copy".equals(tag)) {
                value = EventTypeArg.FILE_COPY;
            }
            else if ("file_delete".equals(tag)) {
                value = EventTypeArg.FILE_DELETE;
            }
            else if ("file_download".equals(tag)) {
                value = EventTypeArg.FILE_DOWNLOAD;
            }
            else if ("file_edit".equals(tag)) {
                value = EventTypeArg.FILE_EDIT;
            }
            else if ("file_get_copy_reference".equals(tag)) {
                value = EventTypeArg.FILE_GET_COPY_REFERENCE;
            }
            else if ("file_locking_lock_status_changed".equals(tag)) {
                value = EventTypeArg.FILE_LOCKING_LOCK_STATUS_CHANGED;
            }
            else if ("file_move".equals(tag)) {
                value = EventTypeArg.FILE_MOVE;
            }
            else if ("file_permanently_delete".equals(tag)) {
                value = EventTypeArg.FILE_PERMANENTLY_DELETE;
            }
            else if ("file_preview".equals(tag)) {
                value = EventTypeArg.FILE_PREVIEW;
            }
            else if ("file_rename".equals(tag)) {
                value = EventTypeArg.FILE_RENAME;
            }
            else if ("file_restore".equals(tag)) {
                value = EventTypeArg.FILE_RESTORE;
            }
            else if ("file_revert".equals(tag)) {
                value = EventTypeArg.FILE_REVERT;
            }
            else if ("file_rollback_changes".equals(tag)) {
                value = EventTypeArg.FILE_ROLLBACK_CHANGES;
            }
            else if ("file_save_copy_reference".equals(tag)) {
                value = EventTypeArg.FILE_SAVE_COPY_REFERENCE;
            }
            else if ("folder_overview_description_changed".equals(tag)) {
                value = EventTypeArg.FOLDER_OVERVIEW_DESCRIPTION_CHANGED;
            }
            else if ("folder_overview_item_pinned".equals(tag)) {
                value = EventTypeArg.FOLDER_OVERVIEW_ITEM_PINNED;
            }
            else if ("folder_overview_item_unpinned".equals(tag)) {
                value = EventTypeArg.FOLDER_OVERVIEW_ITEM_UNPINNED;
            }
            else if ("object_label_added".equals(tag)) {
                value = EventTypeArg.OBJECT_LABEL_ADDED;
            }
            else if ("object_label_removed".equals(tag)) {
                value = EventTypeArg.OBJECT_LABEL_REMOVED;
            }
            else if ("object_label_updated_value".equals(tag)) {
                value = EventTypeArg.OBJECT_LABEL_UPDATED_VALUE;
            }
            else if ("organize_folder_with_tidy".equals(tag)) {
                value = EventTypeArg.ORGANIZE_FOLDER_WITH_TIDY;
            }
            else if ("rewind_folder".equals(tag)) {
                value = EventTypeArg.REWIND_FOLDER;
            }
            else if ("undo_naming_convention".equals(tag)) {
                value = EventTypeArg.UNDO_NAMING_CONVENTION;
            }
            else if ("undo_organize_folder_with_tidy".equals(tag)) {
                value = EventTypeArg.UNDO_ORGANIZE_FOLDER_WITH_TIDY;
            }
            else if ("user_tags_added".equals(tag)) {
                value = EventTypeArg.USER_TAGS_ADDED;
            }
            else if ("user_tags_removed".equals(tag)) {
                value = EventTypeArg.USER_TAGS_REMOVED;
            }
            else if ("email_ingest_receive_file".equals(tag)) {
                value = EventTypeArg.EMAIL_INGEST_RECEIVE_FILE;
            }
            else if ("file_request_change".equals(tag)) {
                value = EventTypeArg.FILE_REQUEST_CHANGE;
            }
            else if ("file_request_close".equals(tag)) {
                value = EventTypeArg.FILE_REQUEST_CLOSE;
            }
            else if ("file_request_create".equals(tag)) {
                value = EventTypeArg.FILE_REQUEST_CREATE;
            }
            else if ("file_request_delete".equals(tag)) {
                value = EventTypeArg.FILE_REQUEST_DELETE;
            }
            else if ("file_request_receive_file".equals(tag)) {
                value = EventTypeArg.FILE_REQUEST_RECEIVE_FILE;
            }
            else if ("group_add_external_id".equals(tag)) {
                value = EventTypeArg.GROUP_ADD_EXTERNAL_ID;
            }
            else if ("group_add_member".equals(tag)) {
                value = EventTypeArg.GROUP_ADD_MEMBER;
            }
            else if ("group_change_external_id".equals(tag)) {
                value = EventTypeArg.GROUP_CHANGE_EXTERNAL_ID;
            }
            else if ("group_change_management_type".equals(tag)) {
                value = EventTypeArg.GROUP_CHANGE_MANAGEMENT_TYPE;
            }
            else if ("group_change_member_role".equals(tag)) {
                value = EventTypeArg.GROUP_CHANGE_MEMBER_ROLE;
            }
            else if ("group_create".equals(tag)) {
                value = EventTypeArg.GROUP_CREATE;
            }
            else if ("group_delete".equals(tag)) {
                value = EventTypeArg.GROUP_DELETE;
            }
            else if ("group_description_updated".equals(tag)) {
                value = EventTypeArg.GROUP_DESCRIPTION_UPDATED;
            }
            else if ("group_join_policy_updated".equals(tag)) {
                value = EventTypeArg.GROUP_JOIN_POLICY_UPDATED;
            }
            else if ("group_moved".equals(tag)) {
                value = EventTypeArg.GROUP_MOVED;
            }
            else if ("group_remove_external_id".equals(tag)) {
                value = EventTypeArg.GROUP_REMOVE_EXTERNAL_ID;
            }
            else if ("group_remove_member".equals(tag)) {
                value = EventTypeArg.GROUP_REMOVE_MEMBER;
            }
            else if ("group_rename".equals(tag)) {
                value = EventTypeArg.GROUP_RENAME;
            }
            else if ("account_lock_or_unlocked".equals(tag)) {
                value = EventTypeArg.ACCOUNT_LOCK_OR_UNLOCKED;
            }
            else if ("emm_error".equals(tag)) {
                value = EventTypeArg.EMM_ERROR;
            }
            else if ("guest_admin_signed_in_via_trusted_teams".equals(tag)) {
                value = EventTypeArg.GUEST_ADMIN_SIGNED_IN_VIA_TRUSTED_TEAMS;
            }
            else if ("guest_admin_signed_out_via_trusted_teams".equals(tag)) {
                value = EventTypeArg.GUEST_ADMIN_SIGNED_OUT_VIA_TRUSTED_TEAMS;
            }
            else if ("login_fail".equals(tag)) {
                value = EventTypeArg.LOGIN_FAIL;
            }
            else if ("login_success".equals(tag)) {
                value = EventTypeArg.LOGIN_SUCCESS;
            }
            else if ("logout".equals(tag)) {
                value = EventTypeArg.LOGOUT;
            }
            else if ("reseller_support_session_end".equals(tag)) {
                value = EventTypeArg.RESELLER_SUPPORT_SESSION_END;
            }
            else if ("reseller_support_session_start".equals(tag)) {
                value = EventTypeArg.RESELLER_SUPPORT_SESSION_START;
            }
            else if ("sign_in_as_session_end".equals(tag)) {
                value = EventTypeArg.SIGN_IN_AS_SESSION_END;
            }
            else if ("sign_in_as_session_start".equals(tag)) {
                value = EventTypeArg.SIGN_IN_AS_SESSION_START;
            }
            else if ("sso_error".equals(tag)) {
                value = EventTypeArg.SSO_ERROR;
            }
            else if ("create_team_invite_link".equals(tag)) {
                value = EventTypeArg.CREATE_TEAM_INVITE_LINK;
            }
            else if ("delete_team_invite_link".equals(tag)) {
                value = EventTypeArg.DELETE_TEAM_INVITE_LINK;
            }
            else if ("member_add_external_id".equals(tag)) {
                value = EventTypeArg.MEMBER_ADD_EXTERNAL_ID;
            }
            else if ("member_add_name".equals(tag)) {
                value = EventTypeArg.MEMBER_ADD_NAME;
            }
            else if ("member_change_admin_role".equals(tag)) {
                value = EventTypeArg.MEMBER_CHANGE_ADMIN_ROLE;
            }
            else if ("member_change_email".equals(tag)) {
                value = EventTypeArg.MEMBER_CHANGE_EMAIL;
            }
            else if ("member_change_external_id".equals(tag)) {
                value = EventTypeArg.MEMBER_CHANGE_EXTERNAL_ID;
            }
            else if ("member_change_membership_type".equals(tag)) {
                value = EventTypeArg.MEMBER_CHANGE_MEMBERSHIP_TYPE;
            }
            else if ("member_change_name".equals(tag)) {
                value = EventTypeArg.MEMBER_CHANGE_NAME;
            }
            else if ("member_change_reseller_role".equals(tag)) {
                value = EventTypeArg.MEMBER_CHANGE_RESELLER_ROLE;
            }
            else if ("member_change_status".equals(tag)) {
                value = EventTypeArg.MEMBER_CHANGE_STATUS;
            }
            else if ("member_delete_manual_contacts".equals(tag)) {
                value = EventTypeArg.MEMBER_DELETE_MANUAL_CONTACTS;
            }
            else if ("member_delete_profile_photo".equals(tag)) {
                value = EventTypeArg.MEMBER_DELETE_PROFILE_PHOTO;
            }
            else if ("member_permanently_delete_account_contents".equals(tag)) {
                value = EventTypeArg.MEMBER_PERMANENTLY_DELETE_ACCOUNT_CONTENTS;
            }
            else if ("member_remove_external_id".equals(tag)) {
                value = EventTypeArg.MEMBER_REMOVE_EXTERNAL_ID;
            }
            else if ("member_set_profile_photo".equals(tag)) {
                value = EventTypeArg.MEMBER_SET_PROFILE_PHOTO;
            }
            else if ("member_space_limits_add_custom_quota".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_ADD_CUSTOM_QUOTA;
            }
            else if ("member_space_limits_change_custom_quota".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_CUSTOM_QUOTA;
            }
            else if ("member_space_limits_change_status".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_STATUS;
            }
            else if ("member_space_limits_remove_custom_quota".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_REMOVE_CUSTOM_QUOTA;
            }
            else if ("member_suggest".equals(tag)) {
                value = EventTypeArg.MEMBER_SUGGEST;
            }
            else if ("member_transfer_account_contents".equals(tag)) {
                value = EventTypeArg.MEMBER_TRANSFER_ACCOUNT_CONTENTS;
            }
            else if ("pending_secondary_email_added".equals(tag)) {
                value = EventTypeArg.PENDING_SECONDARY_EMAIL_ADDED;
            }
            else if ("secondary_email_deleted".equals(tag)) {
                value = EventTypeArg.SECONDARY_EMAIL_DELETED;
            }
            else if ("secondary_email_verified".equals(tag)) {
                value = EventTypeArg.SECONDARY_EMAIL_VERIFIED;
            }
            else if ("secondary_mails_policy_changed".equals(tag)) {
                value = EventTypeArg.SECONDARY_MAILS_POLICY_CHANGED;
            }
            else if ("binder_add_page".equals(tag)) {
                value = EventTypeArg.BINDER_ADD_PAGE;
            }
            else if ("binder_add_section".equals(tag)) {
                value = EventTypeArg.BINDER_ADD_SECTION;
            }
            else if ("binder_remove_page".equals(tag)) {
                value = EventTypeArg.BINDER_REMOVE_PAGE;
            }
            else if ("binder_remove_section".equals(tag)) {
                value = EventTypeArg.BINDER_REMOVE_SECTION;
            }
            else if ("binder_rename_page".equals(tag)) {
                value = EventTypeArg.BINDER_RENAME_PAGE;
            }
            else if ("binder_rename_section".equals(tag)) {
                value = EventTypeArg.BINDER_RENAME_SECTION;
            }
            else if ("binder_reorder_page".equals(tag)) {
                value = EventTypeArg.BINDER_REORDER_PAGE;
            }
            else if ("binder_reorder_section".equals(tag)) {
                value = EventTypeArg.BINDER_REORDER_SECTION;
            }
            else if ("paper_content_add_member".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_ADD_MEMBER;
            }
            else if ("paper_content_add_to_folder".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_ADD_TO_FOLDER;
            }
            else if ("paper_content_archive".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_ARCHIVE;
            }
            else if ("paper_content_create".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_CREATE;
            }
            else if ("paper_content_permanently_delete".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_PERMANENTLY_DELETE;
            }
            else if ("paper_content_remove_from_folder".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_REMOVE_FROM_FOLDER;
            }
            else if ("paper_content_remove_member".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_REMOVE_MEMBER;
            }
            else if ("paper_content_rename".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_RENAME;
            }
            else if ("paper_content_restore".equals(tag)) {
                value = EventTypeArg.PAPER_CONTENT_RESTORE;
            }
            else if ("paper_doc_add_comment".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_ADD_COMMENT;
            }
            else if ("paper_doc_change_member_role".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_CHANGE_MEMBER_ROLE;
            }
            else if ("paper_doc_change_sharing_policy".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_CHANGE_SHARING_POLICY;
            }
            else if ("paper_doc_change_subscription".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_CHANGE_SUBSCRIPTION;
            }
            else if ("paper_doc_deleted".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_DELETED;
            }
            else if ("paper_doc_delete_comment".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_DELETE_COMMENT;
            }
            else if ("paper_doc_download".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_DOWNLOAD;
            }
            else if ("paper_doc_edit".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_EDIT;
            }
            else if ("paper_doc_edit_comment".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_EDIT_COMMENT;
            }
            else if ("paper_doc_followed".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_FOLLOWED;
            }
            else if ("paper_doc_mention".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_MENTION;
            }
            else if ("paper_doc_ownership_changed".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_OWNERSHIP_CHANGED;
            }
            else if ("paper_doc_request_access".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_REQUEST_ACCESS;
            }
            else if ("paper_doc_resolve_comment".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_RESOLVE_COMMENT;
            }
            else if ("paper_doc_revert".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_REVERT;
            }
            else if ("paper_doc_slack_share".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_SLACK_SHARE;
            }
            else if ("paper_doc_team_invite".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_TEAM_INVITE;
            }
            else if ("paper_doc_trashed".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_TRASHED;
            }
            else if ("paper_doc_unresolve_comment".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_UNRESOLVE_COMMENT;
            }
            else if ("paper_doc_untrashed".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_UNTRASHED;
            }
            else if ("paper_doc_view".equals(tag)) {
                value = EventTypeArg.PAPER_DOC_VIEW;
            }
            else if ("paper_external_view_allow".equals(tag)) {
                value = EventTypeArg.PAPER_EXTERNAL_VIEW_ALLOW;
            }
            else if ("paper_external_view_default_team".equals(tag)) {
                value = EventTypeArg.PAPER_EXTERNAL_VIEW_DEFAULT_TEAM;
            }
            else if ("paper_external_view_forbid".equals(tag)) {
                value = EventTypeArg.PAPER_EXTERNAL_VIEW_FORBID;
            }
            else if ("paper_folder_change_subscription".equals(tag)) {
                value = EventTypeArg.PAPER_FOLDER_CHANGE_SUBSCRIPTION;
            }
            else if ("paper_folder_deleted".equals(tag)) {
                value = EventTypeArg.PAPER_FOLDER_DELETED;
            }
            else if ("paper_folder_followed".equals(tag)) {
                value = EventTypeArg.PAPER_FOLDER_FOLLOWED;
            }
            else if ("paper_folder_team_invite".equals(tag)) {
                value = EventTypeArg.PAPER_FOLDER_TEAM_INVITE;
            }
            else if ("paper_published_link_change_permission".equals(tag)) {
                value = EventTypeArg.PAPER_PUBLISHED_LINK_CHANGE_PERMISSION;
            }
            else if ("paper_published_link_create".equals(tag)) {
                value = EventTypeArg.PAPER_PUBLISHED_LINK_CREATE;
            }
            else if ("paper_published_link_disabled".equals(tag)) {
                value = EventTypeArg.PAPER_PUBLISHED_LINK_DISABLED;
            }
            else if ("paper_published_link_view".equals(tag)) {
                value = EventTypeArg.PAPER_PUBLISHED_LINK_VIEW;
            }
            else if ("password_change".equals(tag)) {
                value = EventTypeArg.PASSWORD_CHANGE;
            }
            else if ("password_reset".equals(tag)) {
                value = EventTypeArg.PASSWORD_RESET;
            }
            else if ("password_reset_all".equals(tag)) {
                value = EventTypeArg.PASSWORD_RESET_ALL;
            }
            else if ("classification_create_report".equals(tag)) {
                value = EventTypeArg.CLASSIFICATION_CREATE_REPORT;
            }
            else if ("classification_create_report_fail".equals(tag)) {
                value = EventTypeArg.CLASSIFICATION_CREATE_REPORT_FAIL;
            }
            else if ("emm_create_exceptions_report".equals(tag)) {
                value = EventTypeArg.EMM_CREATE_EXCEPTIONS_REPORT;
            }
            else if ("emm_create_usage_report".equals(tag)) {
                value = EventTypeArg.EMM_CREATE_USAGE_REPORT;
            }
            else if ("export_members_report".equals(tag)) {
                value = EventTypeArg.EXPORT_MEMBERS_REPORT;
            }
            else if ("export_members_report_fail".equals(tag)) {
                value = EventTypeArg.EXPORT_MEMBERS_REPORT_FAIL;
            }
            else if ("external_sharing_create_report".equals(tag)) {
                value = EventTypeArg.EXTERNAL_SHARING_CREATE_REPORT;
            }
            else if ("external_sharing_report_failed".equals(tag)) {
                value = EventTypeArg.EXTERNAL_SHARING_REPORT_FAILED;
            }
            else if ("no_expiration_link_gen_create_report".equals(tag)) {
                value = EventTypeArg.NO_EXPIRATION_LINK_GEN_CREATE_REPORT;
            }
            else if ("no_expiration_link_gen_report_failed".equals(tag)) {
                value = EventTypeArg.NO_EXPIRATION_LINK_GEN_REPORT_FAILED;
            }
            else if ("no_password_link_gen_create_report".equals(tag)) {
                value = EventTypeArg.NO_PASSWORD_LINK_GEN_CREATE_REPORT;
            }
            else if ("no_password_link_gen_report_failed".equals(tag)) {
                value = EventTypeArg.NO_PASSWORD_LINK_GEN_REPORT_FAILED;
            }
            else if ("no_password_link_view_create_report".equals(tag)) {
                value = EventTypeArg.NO_PASSWORD_LINK_VIEW_CREATE_REPORT;
            }
            else if ("no_password_link_view_report_failed".equals(tag)) {
                value = EventTypeArg.NO_PASSWORD_LINK_VIEW_REPORT_FAILED;
            }
            else if ("outdated_link_view_create_report".equals(tag)) {
                value = EventTypeArg.OUTDATED_LINK_VIEW_CREATE_REPORT;
            }
            else if ("outdated_link_view_report_failed".equals(tag)) {
                value = EventTypeArg.OUTDATED_LINK_VIEW_REPORT_FAILED;
            }
            else if ("paper_admin_export_start".equals(tag)) {
                value = EventTypeArg.PAPER_ADMIN_EXPORT_START;
            }
            else if ("smart_sync_create_admin_privilege_report".equals(tag)) {
                value = EventTypeArg.SMART_SYNC_CREATE_ADMIN_PRIVILEGE_REPORT;
            }
            else if ("team_activity_create_report".equals(tag)) {
                value = EventTypeArg.TEAM_ACTIVITY_CREATE_REPORT;
            }
            else if ("team_activity_create_report_fail".equals(tag)) {
                value = EventTypeArg.TEAM_ACTIVITY_CREATE_REPORT_FAIL;
            }
            else if ("collection_share".equals(tag)) {
                value = EventTypeArg.COLLECTION_SHARE;
            }
            else if ("file_transfers_file_add".equals(tag)) {
                value = EventTypeArg.FILE_TRANSFERS_FILE_ADD;
            }
            else if ("file_transfers_transfer_delete".equals(tag)) {
                value = EventTypeArg.FILE_TRANSFERS_TRANSFER_DELETE;
            }
            else if ("file_transfers_transfer_download".equals(tag)) {
                value = EventTypeArg.FILE_TRANSFERS_TRANSFER_DOWNLOAD;
            }
            else if ("file_transfers_transfer_send".equals(tag)) {
                value = EventTypeArg.FILE_TRANSFERS_TRANSFER_SEND;
            }
            else if ("file_transfers_transfer_view".equals(tag)) {
                value = EventTypeArg.FILE_TRANSFERS_TRANSFER_VIEW;
            }
            else if ("note_acl_invite_only".equals(tag)) {
                value = EventTypeArg.NOTE_ACL_INVITE_ONLY;
            }
            else if ("note_acl_link".equals(tag)) {
                value = EventTypeArg.NOTE_ACL_LINK;
            }
            else if ("note_acl_team_link".equals(tag)) {
                value = EventTypeArg.NOTE_ACL_TEAM_LINK;
            }
            else if ("note_shared".equals(tag)) {
                value = EventTypeArg.NOTE_SHARED;
            }
            else if ("note_share_receive".equals(tag)) {
                value = EventTypeArg.NOTE_SHARE_RECEIVE;
            }
            else if ("open_note_shared".equals(tag)) {
                value = EventTypeArg.OPEN_NOTE_SHARED;
            }
            else if ("sf_add_group".equals(tag)) {
                value = EventTypeArg.SF_ADD_GROUP;
            }
            else if ("sf_allow_non_members_to_view_shared_links".equals(tag)) {
                value = EventTypeArg.SF_ALLOW_NON_MEMBERS_TO_VIEW_SHARED_LINKS;
            }
            else if ("sf_external_invite_warn".equals(tag)) {
                value = EventTypeArg.SF_EXTERNAL_INVITE_WARN;
            }
            else if ("sf_fb_invite".equals(tag)) {
                value = EventTypeArg.SF_FB_INVITE;
            }
            else if ("sf_fb_invite_change_role".equals(tag)) {
                value = EventTypeArg.SF_FB_INVITE_CHANGE_ROLE;
            }
            else if ("sf_fb_uninvite".equals(tag)) {
                value = EventTypeArg.SF_FB_UNINVITE;
            }
            else if ("sf_invite_group".equals(tag)) {
                value = EventTypeArg.SF_INVITE_GROUP;
            }
            else if ("sf_team_grant_access".equals(tag)) {
                value = EventTypeArg.SF_TEAM_GRANT_ACCESS;
            }
            else if ("sf_team_invite".equals(tag)) {
                value = EventTypeArg.SF_TEAM_INVITE;
            }
            else if ("sf_team_invite_change_role".equals(tag)) {
                value = EventTypeArg.SF_TEAM_INVITE_CHANGE_ROLE;
            }
            else if ("sf_team_join".equals(tag)) {
                value = EventTypeArg.SF_TEAM_JOIN;
            }
            else if ("sf_team_join_from_oob_link".equals(tag)) {
                value = EventTypeArg.SF_TEAM_JOIN_FROM_OOB_LINK;
            }
            else if ("sf_team_uninvite".equals(tag)) {
                value = EventTypeArg.SF_TEAM_UNINVITE;
            }
            else if ("shared_content_add_invitees".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_ADD_INVITEES;
            }
            else if ("shared_content_add_link_expiry".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_ADD_LINK_EXPIRY;
            }
            else if ("shared_content_add_link_password".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_ADD_LINK_PASSWORD;
            }
            else if ("shared_content_add_member".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_ADD_MEMBER;
            }
            else if ("shared_content_change_downloads_policy".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CHANGE_DOWNLOADS_POLICY;
            }
            else if ("shared_content_change_invitee_role".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CHANGE_INVITEE_ROLE;
            }
            else if ("shared_content_change_link_audience".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CHANGE_LINK_AUDIENCE;
            }
            else if ("shared_content_change_link_expiry".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CHANGE_LINK_EXPIRY;
            }
            else if ("shared_content_change_link_password".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CHANGE_LINK_PASSWORD;
            }
            else if ("shared_content_change_member_role".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CHANGE_MEMBER_ROLE;
            }
            else if ("shared_content_change_viewer_info_policy".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CHANGE_VIEWER_INFO_POLICY;
            }
            else if ("shared_content_claim_invitation".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_CLAIM_INVITATION;
            }
            else if ("shared_content_copy".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_COPY;
            }
            else if ("shared_content_download".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_DOWNLOAD;
            }
            else if ("shared_content_relinquish_membership".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_RELINQUISH_MEMBERSHIP;
            }
            else if ("shared_content_remove_invitees".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_REMOVE_INVITEES;
            }
            else if ("shared_content_remove_link_expiry".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_REMOVE_LINK_EXPIRY;
            }
            else if ("shared_content_remove_link_password".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_REMOVE_LINK_PASSWORD;
            }
            else if ("shared_content_remove_member".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_REMOVE_MEMBER;
            }
            else if ("shared_content_request_access".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_REQUEST_ACCESS;
            }
            else if ("shared_content_restore_invitees".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_RESTORE_INVITEES;
            }
            else if ("shared_content_restore_member".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_RESTORE_MEMBER;
            }
            else if ("shared_content_unshare".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_UNSHARE;
            }
            else if ("shared_content_view".equals(tag)) {
                value = EventTypeArg.SHARED_CONTENT_VIEW;
            }
            else if ("shared_folder_change_link_policy".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_CHANGE_LINK_POLICY;
            }
            else if ("shared_folder_change_members_inheritance_policy".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_INHERITANCE_POLICY;
            }
            else if ("shared_folder_change_members_management_policy".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_MANAGEMENT_POLICY;
            }
            else if ("shared_folder_change_members_policy".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_POLICY;
            }
            else if ("shared_folder_create".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_CREATE;
            }
            else if ("shared_folder_decline_invitation".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_DECLINE_INVITATION;
            }
            else if ("shared_folder_mount".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_MOUNT;
            }
            else if ("shared_folder_nest".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_NEST;
            }
            else if ("shared_folder_transfer_ownership".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_TRANSFER_OWNERSHIP;
            }
            else if ("shared_folder_unmount".equals(tag)) {
                value = EventTypeArg.SHARED_FOLDER_UNMOUNT;
            }
            else if ("shared_link_add_expiry".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_ADD_EXPIRY;
            }
            else if ("shared_link_change_expiry".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_CHANGE_EXPIRY;
            }
            else if ("shared_link_change_visibility".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_CHANGE_VISIBILITY;
            }
            else if ("shared_link_copy".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_COPY;
            }
            else if ("shared_link_create".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_CREATE;
            }
            else if ("shared_link_disable".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_DISABLE;
            }
            else if ("shared_link_download".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_DOWNLOAD;
            }
            else if ("shared_link_remove_expiry".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_REMOVE_EXPIRY;
            }
            else if ("shared_link_settings_add_expiration".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_ADD_EXPIRATION;
            }
            else if ("shared_link_settings_add_password".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_ADD_PASSWORD;
            }
            else if ("shared_link_settings_allow_download_disabled".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_DISABLED;
            }
            else if ("shared_link_settings_allow_download_enabled".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_ENABLED;
            }
            else if ("shared_link_settings_change_audience".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_AUDIENCE;
            }
            else if ("shared_link_settings_change_expiration".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_EXPIRATION;
            }
            else if ("shared_link_settings_change_password".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_PASSWORD;
            }
            else if ("shared_link_settings_remove_expiration".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_REMOVE_EXPIRATION;
            }
            else if ("shared_link_settings_remove_password".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SETTINGS_REMOVE_PASSWORD;
            }
            else if ("shared_link_share".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_SHARE;
            }
            else if ("shared_link_view".equals(tag)) {
                value = EventTypeArg.SHARED_LINK_VIEW;
            }
            else if ("shared_note_opened".equals(tag)) {
                value = EventTypeArg.SHARED_NOTE_OPENED;
            }
            else if ("shmodel_disable_downloads".equals(tag)) {
                value = EventTypeArg.SHMODEL_DISABLE_DOWNLOADS;
            }
            else if ("shmodel_enable_downloads".equals(tag)) {
                value = EventTypeArg.SHMODEL_ENABLE_DOWNLOADS;
            }
            else if ("shmodel_group_share".equals(tag)) {
                value = EventTypeArg.SHMODEL_GROUP_SHARE;
            }
            else if ("showcase_access_granted".equals(tag)) {
                value = EventTypeArg.SHOWCASE_ACCESS_GRANTED;
            }
            else if ("showcase_add_member".equals(tag)) {
                value = EventTypeArg.SHOWCASE_ADD_MEMBER;
            }
            else if ("showcase_archived".equals(tag)) {
                value = EventTypeArg.SHOWCASE_ARCHIVED;
            }
            else if ("showcase_created".equals(tag)) {
                value = EventTypeArg.SHOWCASE_CREATED;
            }
            else if ("showcase_delete_comment".equals(tag)) {
                value = EventTypeArg.SHOWCASE_DELETE_COMMENT;
            }
            else if ("showcase_edited".equals(tag)) {
                value = EventTypeArg.SHOWCASE_EDITED;
            }
            else if ("showcase_edit_comment".equals(tag)) {
                value = EventTypeArg.SHOWCASE_EDIT_COMMENT;
            }
            else if ("showcase_file_added".equals(tag)) {
                value = EventTypeArg.SHOWCASE_FILE_ADDED;
            }
            else if ("showcase_file_download".equals(tag)) {
                value = EventTypeArg.SHOWCASE_FILE_DOWNLOAD;
            }
            else if ("showcase_file_removed".equals(tag)) {
                value = EventTypeArg.SHOWCASE_FILE_REMOVED;
            }
            else if ("showcase_file_view".equals(tag)) {
                value = EventTypeArg.SHOWCASE_FILE_VIEW;
            }
            else if ("showcase_permanently_deleted".equals(tag)) {
                value = EventTypeArg.SHOWCASE_PERMANENTLY_DELETED;
            }
            else if ("showcase_post_comment".equals(tag)) {
                value = EventTypeArg.SHOWCASE_POST_COMMENT;
            }
            else if ("showcase_remove_member".equals(tag)) {
                value = EventTypeArg.SHOWCASE_REMOVE_MEMBER;
            }
            else if ("showcase_renamed".equals(tag)) {
                value = EventTypeArg.SHOWCASE_RENAMED;
            }
            else if ("showcase_request_access".equals(tag)) {
                value = EventTypeArg.SHOWCASE_REQUEST_ACCESS;
            }
            else if ("showcase_resolve_comment".equals(tag)) {
                value = EventTypeArg.SHOWCASE_RESOLVE_COMMENT;
            }
            else if ("showcase_restored".equals(tag)) {
                value = EventTypeArg.SHOWCASE_RESTORED;
            }
            else if ("showcase_trashed".equals(tag)) {
                value = EventTypeArg.SHOWCASE_TRASHED;
            }
            else if ("showcase_trashed_deprecated".equals(tag)) {
                value = EventTypeArg.SHOWCASE_TRASHED_DEPRECATED;
            }
            else if ("showcase_unresolve_comment".equals(tag)) {
                value = EventTypeArg.SHOWCASE_UNRESOLVE_COMMENT;
            }
            else if ("showcase_untrashed".equals(tag)) {
                value = EventTypeArg.SHOWCASE_UNTRASHED;
            }
            else if ("showcase_untrashed_deprecated".equals(tag)) {
                value = EventTypeArg.SHOWCASE_UNTRASHED_DEPRECATED;
            }
            else if ("showcase_view".equals(tag)) {
                value = EventTypeArg.SHOWCASE_VIEW;
            }
            else if ("sso_add_cert".equals(tag)) {
                value = EventTypeArg.SSO_ADD_CERT;
            }
            else if ("sso_add_login_url".equals(tag)) {
                value = EventTypeArg.SSO_ADD_LOGIN_URL;
            }
            else if ("sso_add_logout_url".equals(tag)) {
                value = EventTypeArg.SSO_ADD_LOGOUT_URL;
            }
            else if ("sso_change_cert".equals(tag)) {
                value = EventTypeArg.SSO_CHANGE_CERT;
            }
            else if ("sso_change_login_url".equals(tag)) {
                value = EventTypeArg.SSO_CHANGE_LOGIN_URL;
            }
            else if ("sso_change_logout_url".equals(tag)) {
                value = EventTypeArg.SSO_CHANGE_LOGOUT_URL;
            }
            else if ("sso_change_saml_identity_mode".equals(tag)) {
                value = EventTypeArg.SSO_CHANGE_SAML_IDENTITY_MODE;
            }
            else if ("sso_remove_cert".equals(tag)) {
                value = EventTypeArg.SSO_REMOVE_CERT;
            }
            else if ("sso_remove_login_url".equals(tag)) {
                value = EventTypeArg.SSO_REMOVE_LOGIN_URL;
            }
            else if ("sso_remove_logout_url".equals(tag)) {
                value = EventTypeArg.SSO_REMOVE_LOGOUT_URL;
            }
            else if ("team_folder_change_status".equals(tag)) {
                value = EventTypeArg.TEAM_FOLDER_CHANGE_STATUS;
            }
            else if ("team_folder_create".equals(tag)) {
                value = EventTypeArg.TEAM_FOLDER_CREATE;
            }
            else if ("team_folder_downgrade".equals(tag)) {
                value = EventTypeArg.TEAM_FOLDER_DOWNGRADE;
            }
            else if ("team_folder_permanently_delete".equals(tag)) {
                value = EventTypeArg.TEAM_FOLDER_PERMANENTLY_DELETE;
            }
            else if ("team_folder_rename".equals(tag)) {
                value = EventTypeArg.TEAM_FOLDER_RENAME;
            }
            else if ("team_selective_sync_settings_changed".equals(tag)) {
                value = EventTypeArg.TEAM_SELECTIVE_SYNC_SETTINGS_CHANGED;
            }
            else if ("account_capture_change_policy".equals(tag)) {
                value = EventTypeArg.ACCOUNT_CAPTURE_CHANGE_POLICY;
            }
            else if ("admin_email_reminders_changed".equals(tag)) {
                value = EventTypeArg.ADMIN_EMAIL_REMINDERS_CHANGED;
            }
            else if ("allow_download_disabled".equals(tag)) {
                value = EventTypeArg.ALLOW_DOWNLOAD_DISABLED;
            }
            else if ("allow_download_enabled".equals(tag)) {
                value = EventTypeArg.ALLOW_DOWNLOAD_ENABLED;
            }
            else if ("app_permissions_changed".equals(tag)) {
                value = EventTypeArg.APP_PERMISSIONS_CHANGED;
            }
            else if ("camera_uploads_policy_changed".equals(tag)) {
                value = EventTypeArg.CAMERA_UPLOADS_POLICY_CHANGED;
            }
            else if ("capture_transcript_policy_changed".equals(tag)) {
                value = EventTypeArg.CAPTURE_TRANSCRIPT_POLICY_CHANGED;
            }
            else if ("classification_change_policy".equals(tag)) {
                value = EventTypeArg.CLASSIFICATION_CHANGE_POLICY;
            }
            else if ("computer_backup_policy_changed".equals(tag)) {
                value = EventTypeArg.COMPUTER_BACKUP_POLICY_CHANGED;
            }
            else if ("content_administration_policy_changed".equals(tag)) {
                value = EventTypeArg.CONTENT_ADMINISTRATION_POLICY_CHANGED;
            }
            else if ("data_placement_restriction_change_policy".equals(tag)) {
                value = EventTypeArg.DATA_PLACEMENT_RESTRICTION_CHANGE_POLICY;
            }
            else if ("data_placement_restriction_satisfy_policy".equals(tag)) {
                value = EventTypeArg.DATA_PLACEMENT_RESTRICTION_SATISFY_POLICY;
            }
            else if ("device_approvals_add_exception".equals(tag)) {
                value = EventTypeArg.DEVICE_APPROVALS_ADD_EXCEPTION;
            }
            else if ("device_approvals_change_desktop_policy".equals(tag)) {
                value = EventTypeArg.DEVICE_APPROVALS_CHANGE_DESKTOP_POLICY;
            }
            else if ("device_approvals_change_mobile_policy".equals(tag)) {
                value = EventTypeArg.DEVICE_APPROVALS_CHANGE_MOBILE_POLICY;
            }
            else if ("device_approvals_change_overage_action".equals(tag)) {
                value = EventTypeArg.DEVICE_APPROVALS_CHANGE_OVERAGE_ACTION;
            }
            else if ("device_approvals_change_unlink_action".equals(tag)) {
                value = EventTypeArg.DEVICE_APPROVALS_CHANGE_UNLINK_ACTION;
            }
            else if ("device_approvals_remove_exception".equals(tag)) {
                value = EventTypeArg.DEVICE_APPROVALS_REMOVE_EXCEPTION;
            }
            else if ("directory_restrictions_add_members".equals(tag)) {
                value = EventTypeArg.DIRECTORY_RESTRICTIONS_ADD_MEMBERS;
            }
            else if ("directory_restrictions_remove_members".equals(tag)) {
                value = EventTypeArg.DIRECTORY_RESTRICTIONS_REMOVE_MEMBERS;
            }
            else if ("dropbox_passwords_policy_changed".equals(tag)) {
                value = EventTypeArg.DROPBOX_PASSWORDS_POLICY_CHANGED;
            }
            else if ("email_ingest_policy_changed".equals(tag)) {
                value = EventTypeArg.EMAIL_INGEST_POLICY_CHANGED;
            }
            else if ("emm_add_exception".equals(tag)) {
                value = EventTypeArg.EMM_ADD_EXCEPTION;
            }
            else if ("emm_change_policy".equals(tag)) {
                value = EventTypeArg.EMM_CHANGE_POLICY;
            }
            else if ("emm_remove_exception".equals(tag)) {
                value = EventTypeArg.EMM_REMOVE_EXCEPTION;
            }
            else if ("extended_version_history_change_policy".equals(tag)) {
                value = EventTypeArg.EXTENDED_VERSION_HISTORY_CHANGE_POLICY;
            }
            else if ("external_drive_backup_policy_changed".equals(tag)) {
                value = EventTypeArg.EXTERNAL_DRIVE_BACKUP_POLICY_CHANGED;
            }
            else if ("file_comments_change_policy".equals(tag)) {
                value = EventTypeArg.FILE_COMMENTS_CHANGE_POLICY;
            }
            else if ("file_locking_policy_changed".equals(tag)) {
                value = EventTypeArg.FILE_LOCKING_POLICY_CHANGED;
            }
            else if ("file_requests_change_policy".equals(tag)) {
                value = EventTypeArg.FILE_REQUESTS_CHANGE_POLICY;
            }
            else if ("file_requests_emails_enabled".equals(tag)) {
                value = EventTypeArg.FILE_REQUESTS_EMAILS_ENABLED;
            }
            else if ("file_requests_emails_restricted_to_team_only".equals(tag)) {
                value = EventTypeArg.FILE_REQUESTS_EMAILS_RESTRICTED_TO_TEAM_ONLY;
            }
            else if ("file_transfers_policy_changed".equals(tag)) {
                value = EventTypeArg.FILE_TRANSFERS_POLICY_CHANGED;
            }
            else if ("google_sso_change_policy".equals(tag)) {
                value = EventTypeArg.GOOGLE_SSO_CHANGE_POLICY;
            }
            else if ("group_user_management_change_policy".equals(tag)) {
                value = EventTypeArg.GROUP_USER_MANAGEMENT_CHANGE_POLICY;
            }
            else if ("integration_policy_changed".equals(tag)) {
                value = EventTypeArg.INTEGRATION_POLICY_CHANGED;
            }
            else if ("invite_acceptance_email_policy_changed".equals(tag)) {
                value = EventTypeArg.INVITE_ACCEPTANCE_EMAIL_POLICY_CHANGED;
            }
            else if ("member_requests_change_policy".equals(tag)) {
                value = EventTypeArg.MEMBER_REQUESTS_CHANGE_POLICY;
            }
            else if ("member_send_invite_policy_changed".equals(tag)) {
                value = EventTypeArg.MEMBER_SEND_INVITE_POLICY_CHANGED;
            }
            else if ("member_space_limits_add_exception".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_ADD_EXCEPTION;
            }
            else if ("member_space_limits_change_caps_type_policy".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_CAPS_TYPE_POLICY;
            }
            else if ("member_space_limits_change_policy".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_POLICY;
            }
            else if ("member_space_limits_remove_exception".equals(tag)) {
                value = EventTypeArg.MEMBER_SPACE_LIMITS_REMOVE_EXCEPTION;
            }
            else if ("member_suggestions_change_policy".equals(tag)) {
                value = EventTypeArg.MEMBER_SUGGESTIONS_CHANGE_POLICY;
            }
            else if ("microsoft_office_addin_change_policy".equals(tag)) {
                value = EventTypeArg.MICROSOFT_OFFICE_ADDIN_CHANGE_POLICY;
            }
            else if ("network_control_change_policy".equals(tag)) {
                value = EventTypeArg.NETWORK_CONTROL_CHANGE_POLICY;
            }
            else if ("paper_change_deployment_policy".equals(tag)) {
                value = EventTypeArg.PAPER_CHANGE_DEPLOYMENT_POLICY;
            }
            else if ("paper_change_member_link_policy".equals(tag)) {
                value = EventTypeArg.PAPER_CHANGE_MEMBER_LINK_POLICY;
            }
            else if ("paper_change_member_policy".equals(tag)) {
                value = EventTypeArg.PAPER_CHANGE_MEMBER_POLICY;
            }
            else if ("paper_change_policy".equals(tag)) {
                value = EventTypeArg.PAPER_CHANGE_POLICY;
            }
            else if ("paper_default_folder_policy_changed".equals(tag)) {
                value = EventTypeArg.PAPER_DEFAULT_FOLDER_POLICY_CHANGED;
            }
            else if ("paper_desktop_policy_changed".equals(tag)) {
                value = EventTypeArg.PAPER_DESKTOP_POLICY_CHANGED;
            }
            else if ("paper_enabled_users_group_addition".equals(tag)) {
                value = EventTypeArg.PAPER_ENABLED_USERS_GROUP_ADDITION;
            }
            else if ("paper_enabled_users_group_removal".equals(tag)) {
                value = EventTypeArg.PAPER_ENABLED_USERS_GROUP_REMOVAL;
            }
            else if ("password_strength_requirements_change_policy".equals(tag)) {
                value = EventTypeArg.PASSWORD_STRENGTH_REQUIREMENTS_CHANGE_POLICY;
            }
            else if ("permanent_delete_change_policy".equals(tag)) {
                value = EventTypeArg.PERMANENT_DELETE_CHANGE_POLICY;
            }
            else if ("reseller_support_change_policy".equals(tag)) {
                value = EventTypeArg.RESELLER_SUPPORT_CHANGE_POLICY;
            }
            else if ("rewind_policy_changed".equals(tag)) {
                value = EventTypeArg.REWIND_POLICY_CHANGED;
            }
            else if ("send_for_signature_policy_changed".equals(tag)) {
                value = EventTypeArg.SEND_FOR_SIGNATURE_POLICY_CHANGED;
            }
            else if ("sharing_change_folder_join_policy".equals(tag)) {
                value = EventTypeArg.SHARING_CHANGE_FOLDER_JOIN_POLICY;
            }
            else if ("sharing_change_link_allow_change_expiration_policy".equals(tag)) {
                value = EventTypeArg.SHARING_CHANGE_LINK_ALLOW_CHANGE_EXPIRATION_POLICY;
            }
            else if ("sharing_change_link_default_expiration_policy".equals(tag)) {
                value = EventTypeArg.SHARING_CHANGE_LINK_DEFAULT_EXPIRATION_POLICY;
            }
            else if ("sharing_change_link_enforce_password_policy".equals(tag)) {
                value = EventTypeArg.SHARING_CHANGE_LINK_ENFORCE_PASSWORD_POLICY;
            }
            else if ("sharing_change_link_policy".equals(tag)) {
                value = EventTypeArg.SHARING_CHANGE_LINK_POLICY;
            }
            else if ("sharing_change_member_policy".equals(tag)) {
                value = EventTypeArg.SHARING_CHANGE_MEMBER_POLICY;
            }
            else if ("showcase_change_download_policy".equals(tag)) {
                value = EventTypeArg.SHOWCASE_CHANGE_DOWNLOAD_POLICY;
            }
            else if ("showcase_change_enabled_policy".equals(tag)) {
                value = EventTypeArg.SHOWCASE_CHANGE_ENABLED_POLICY;
            }
            else if ("showcase_change_external_sharing_policy".equals(tag)) {
                value = EventTypeArg.SHOWCASE_CHANGE_EXTERNAL_SHARING_POLICY;
            }
            else if ("smarter_smart_sync_policy_changed".equals(tag)) {
                value = EventTypeArg.SMARTER_SMART_SYNC_POLICY_CHANGED;
            }
            else if ("smart_sync_change_policy".equals(tag)) {
                value = EventTypeArg.SMART_SYNC_CHANGE_POLICY;
            }
            else if ("smart_sync_not_opt_out".equals(tag)) {
                value = EventTypeArg.SMART_SYNC_NOT_OPT_OUT;
            }
            else if ("smart_sync_opt_out".equals(tag)) {
                value = EventTypeArg.SMART_SYNC_OPT_OUT;
            }
            else if ("sso_change_policy".equals(tag)) {
                value = EventTypeArg.SSO_CHANGE_POLICY;
            }
            else if ("team_branding_policy_changed".equals(tag)) {
                value = EventTypeArg.TEAM_BRANDING_POLICY_CHANGED;
            }
            else if ("team_extensions_policy_changed".equals(tag)) {
                value = EventTypeArg.TEAM_EXTENSIONS_POLICY_CHANGED;
            }
            else if ("team_selective_sync_policy_changed".equals(tag)) {
                value = EventTypeArg.TEAM_SELECTIVE_SYNC_POLICY_CHANGED;
            }
            else if ("team_sharing_whitelist_subjects_changed".equals(tag)) {
                value = EventTypeArg.TEAM_SHARING_WHITELIST_SUBJECTS_CHANGED;
            }
            else if ("tfa_add_exception".equals(tag)) {
                value = EventTypeArg.TFA_ADD_EXCEPTION;
            }
            else if ("tfa_change_policy".equals(tag)) {
                value = EventTypeArg.TFA_CHANGE_POLICY;
            }
            else if ("tfa_remove_exception".equals(tag)) {
                value = EventTypeArg.TFA_REMOVE_EXCEPTION;
            }
            else if ("two_account_change_policy".equals(tag)) {
                value = EventTypeArg.TWO_ACCOUNT_CHANGE_POLICY;
            }
            else if ("viewer_info_policy_changed".equals(tag)) {
                value = EventTypeArg.VIEWER_INFO_POLICY_CHANGED;
            }
            else if ("watermarking_policy_changed".equals(tag)) {
                value = EventTypeArg.WATERMARKING_POLICY_CHANGED;
            }
            else if ("web_sessions_change_active_session_limit".equals(tag)) {
                value = EventTypeArg.WEB_SESSIONS_CHANGE_ACTIVE_SESSION_LIMIT;
            }
            else if ("web_sessions_change_fixed_length_policy".equals(tag)) {
                value = EventTypeArg.WEB_SESSIONS_CHANGE_FIXED_LENGTH_POLICY;
            }
            else if ("web_sessions_change_idle_length_policy".equals(tag)) {
                value = EventTypeArg.WEB_SESSIONS_CHANGE_IDLE_LENGTH_POLICY;
            }
            else if ("data_residency_migration_request_successful".equals(tag)) {
                value = EventTypeArg.DATA_RESIDENCY_MIGRATION_REQUEST_SUCCESSFUL;
            }
            else if ("data_residency_migration_request_unsuccessful".equals(tag)) {
                value = EventTypeArg.DATA_RESIDENCY_MIGRATION_REQUEST_UNSUCCESSFUL;
            }
            else if ("team_merge_from".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_FROM;
            }
            else if ("team_merge_to".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_TO;
            }
            else if ("team_profile_add_background".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_ADD_BACKGROUND;
            }
            else if ("team_profile_add_logo".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_ADD_LOGO;
            }
            else if ("team_profile_change_background".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_CHANGE_BACKGROUND;
            }
            else if ("team_profile_change_default_language".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_CHANGE_DEFAULT_LANGUAGE;
            }
            else if ("team_profile_change_logo".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_CHANGE_LOGO;
            }
            else if ("team_profile_change_name".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_CHANGE_NAME;
            }
            else if ("team_profile_remove_background".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_REMOVE_BACKGROUND;
            }
            else if ("team_profile_remove_logo".equals(tag)) {
                value = EventTypeArg.TEAM_PROFILE_REMOVE_LOGO;
            }
            else if ("tfa_add_backup_phone".equals(tag)) {
                value = EventTypeArg.TFA_ADD_BACKUP_PHONE;
            }
            else if ("tfa_add_security_key".equals(tag)) {
                value = EventTypeArg.TFA_ADD_SECURITY_KEY;
            }
            else if ("tfa_change_backup_phone".equals(tag)) {
                value = EventTypeArg.TFA_CHANGE_BACKUP_PHONE;
            }
            else if ("tfa_change_status".equals(tag)) {
                value = EventTypeArg.TFA_CHANGE_STATUS;
            }
            else if ("tfa_remove_backup_phone".equals(tag)) {
                value = EventTypeArg.TFA_REMOVE_BACKUP_PHONE;
            }
            else if ("tfa_remove_security_key".equals(tag)) {
                value = EventTypeArg.TFA_REMOVE_SECURITY_KEY;
            }
            else if ("tfa_reset".equals(tag)) {
                value = EventTypeArg.TFA_RESET;
            }
            else if ("changed_enterprise_admin_role".equals(tag)) {
                value = EventTypeArg.CHANGED_ENTERPRISE_ADMIN_ROLE;
            }
            else if ("changed_enterprise_connected_team_status".equals(tag)) {
                value = EventTypeArg.CHANGED_ENTERPRISE_CONNECTED_TEAM_STATUS;
            }
            else if ("ended_enterprise_admin_session".equals(tag)) {
                value = EventTypeArg.ENDED_ENTERPRISE_ADMIN_SESSION;
            }
            else if ("ended_enterprise_admin_session_deprecated".equals(tag)) {
                value = EventTypeArg.ENDED_ENTERPRISE_ADMIN_SESSION_DEPRECATED;
            }
            else if ("enterprise_settings_locking".equals(tag)) {
                value = EventTypeArg.ENTERPRISE_SETTINGS_LOCKING;
            }
            else if ("guest_admin_change_status".equals(tag)) {
                value = EventTypeArg.GUEST_ADMIN_CHANGE_STATUS;
            }
            else if ("started_enterprise_admin_session".equals(tag)) {
                value = EventTypeArg.STARTED_ENTERPRISE_ADMIN_SESSION;
            }
            else if ("team_merge_request_accepted".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED;
            }
            else if ("team_merge_request_accepted_shown_to_primary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_PRIMARY_TEAM;
            }
            else if ("team_merge_request_accepted_shown_to_secondary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_SECONDARY_TEAM;
            }
            else if ("team_merge_request_auto_canceled".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_AUTO_CANCELED;
            }
            else if ("team_merge_request_canceled".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_CANCELED;
            }
            else if ("team_merge_request_canceled_shown_to_primary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_PRIMARY_TEAM;
            }
            else if ("team_merge_request_canceled_shown_to_secondary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_SECONDARY_TEAM;
            }
            else if ("team_merge_request_expired".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED;
            }
            else if ("team_merge_request_expired_shown_to_primary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_PRIMARY_TEAM;
            }
            else if ("team_merge_request_expired_shown_to_secondary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_SECONDARY_TEAM;
            }
            else if ("team_merge_request_rejected_shown_to_primary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_PRIMARY_TEAM;
            }
            else if ("team_merge_request_rejected_shown_to_secondary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_SECONDARY_TEAM;
            }
            else if ("team_merge_request_reminder".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_REMINDER;
            }
            else if ("team_merge_request_reminder_shown_to_primary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_PRIMARY_TEAM;
            }
            else if ("team_merge_request_reminder_shown_to_secondary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_SECONDARY_TEAM;
            }
            else if ("team_merge_request_revoked".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_REVOKED;
            }
            else if ("team_merge_request_sent_shown_to_primary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_SENT_SHOWN_TO_PRIMARY_TEAM;
            }
            else if ("team_merge_request_sent_shown_to_secondary_team".equals(tag)) {
                value = EventTypeArg.TEAM_MERGE_REQUEST_SENT_SHOWN_TO_SECONDARY_TEAM;
            }
            else {
                value = EventTypeArg.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
