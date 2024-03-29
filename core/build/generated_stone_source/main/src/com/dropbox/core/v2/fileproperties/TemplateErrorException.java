/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.fileproperties;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link TemplateError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamFilePropertiesRequests#templatesGetForTeam(String)}, {@link
 * DbxTeamFilePropertiesRequests#templatesListForTeam}, {@link
 * DbxTeamFilePropertiesRequests#templatesRemoveForTeam(String)}, {@link
 * com.dropbox.core.v2.team.DbxTeamTeamRequests#propertiesTemplateGet(String)},
 * {@link com.dropbox.core.v2.team.DbxTeamTeamRequests#propertiesTemplateList},
 * {@link DbxUserFilePropertiesRequests#templatesGetForUser(String)}, {@link
 * DbxUserFilePropertiesRequests#templatesListForUser}, {@link
 * DbxUserFilePropertiesRequests#templatesRemoveForUser(String)}, {@link
 * com.dropbox.core.v2.files.DbxUserFilesRequests#propertiesTemplateGet(String)},
 * and {@link
 * com.dropbox.core.v2.files.DbxUserFilesRequests#propertiesTemplateList}. </p>
 */
public class TemplateErrorException extends DbxApiException {
    // exception for routes:
    //     2/file_properties/templates/get_for_team
    //     2/file_properties/templates/list_for_team
    //     2/file_properties/templates/remove_for_team
    //     2/team/properties/template/get
    //     2/team/properties/template/list
    //     2/file_properties/templates/get_for_user
    //     2/file_properties/templates/list_for_user
    //     2/file_properties/templates/remove_for_user
    //     2/files/properties/template/get
    //     2/files/properties/template/list

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamFilePropertiesRequests#templatesGetForTeam(String)}, {@link
     * DbxTeamFilePropertiesRequests#templatesListForTeam}, {@link
     * DbxTeamFilePropertiesRequests#templatesRemoveForTeam(String)}, {@link
     * com.dropbox.core.v2.team.DbxTeamTeamRequests#propertiesTemplateGet(String)},
     * {@link
     * com.dropbox.core.v2.team.DbxTeamTeamRequests#propertiesTemplateList},
     * {@link DbxUserFilePropertiesRequests#templatesGetForUser(String)}, {@link
     * DbxUserFilePropertiesRequests#templatesListForUser}, {@link
     * DbxUserFilePropertiesRequests#templatesRemoveForUser(String)}, {@link
     * com.dropbox.core.v2.files.DbxUserFilesRequests#propertiesTemplateGet(String)},
     * and {@link
     * com.dropbox.core.v2.files.DbxUserFilesRequests#propertiesTemplateList}.
     */
    public final TemplateError errorValue;

    public TemplateErrorException(String routeName, String requestId, LocalizedText userMessage, TemplateError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
