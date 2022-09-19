/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "file_properties".
 */
public class DbxTeamFilePropertiesRequests {
    // namespace file_properties (file_properties.stone)

    private final DbxRawClientV2 client;

    public DbxTeamFilePropertiesRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/file_properties/templates/add_for_team
    //

    /**
     * Add a template associated with a team. See {@link
     * DbxUserFilePropertiesRequests#propertiesAdd(String,List)} to add
     * properties to a file or folder. Note: this endpoint will create
     * team-owned templates.
     *
     */
    AddTemplateResult templatesAddForTeam(AddTemplateArg arg) throws ModifyTemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/add_for_team",
                                        arg,
                                        false,
                                        AddTemplateArg.Serializer.INSTANCE,
                                        AddTemplateResult.Serializer.INSTANCE,
                                        ModifyTemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/add_for_team", ex.getRequestId(), ex.getUserMessage(), (ModifyTemplateError) ex.getErrorValue());
        }
    }

    /**
     * Add a template associated with a team. See {@link
     * DbxUserFilePropertiesRequests#propertiesAdd(String,List)} to add
     * properties to a file or folder.
     *
     * <p> Note: this endpoint will create team-owned templates. </p>
     *
     * @param name  Display name for the template. Template names can be up to
     *     256 bytes. Must not be {@code null}.
     * @param description  Description for the template. Template descriptions
     *     can be up to 1024 bytes. Must not be {@code null}.
     * @param fields  Definitions of the property fields associated with this
     *     template. There can be up to 32 properties in a single template. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddTemplateResult templatesAddForTeam(String name, String description, List<PropertyFieldTemplate> fields) throws ModifyTemplateErrorException, DbxException {
        AddTemplateArg _arg = new AddTemplateArg(name, description, fields);
        return templatesAddForTeam(_arg);
    }

    //
    // route 2/file_properties/templates/get_for_team
    //

    /**
     * Get the schema for a specified template.
     *
     */
    GetTemplateResult templatesGetForTeam(GetTemplateArg arg) throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/get_for_team",
                                        arg,
                                        false,
                                        GetTemplateArg.Serializer.INSTANCE,
                                        GetTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/file_properties/templates/get_for_team", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    /**
     * Get the schema for a specified template.
     *
     * @param templateId  An identifier for template added by route  See {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemplateResult templatesGetForTeam(String templateId) throws TemplateErrorException, DbxException {
        GetTemplateArg _arg = new GetTemplateArg(templateId);
        return templatesGetForTeam(_arg);
    }

    //
    // route 2/file_properties/templates/list_for_team
    //

    /**
     * Get the template identifiers for a team. To get the schema of each
     * template use {@link
     * DbxTeamFilePropertiesRequests#templatesGetForTeam(String)}.
     */
    public ListTemplateResult templatesListForTeam() throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/list_for_team",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        ListTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/file_properties/templates/list_for_team", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    //
    // route 2/file_properties/templates/remove_for_team
    //

    /**
     * Permanently removes the specified template created from {@link
     * DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}.
     * All properties associated with the template will also be removed. This
     * action cannot be undone.
     *
     */
    void templatesRemoveForTeam(RemoveTemplateArg arg) throws TemplateErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/file_properties/templates/remove_for_team",
                                 arg,
                                 false,
                                 RemoveTemplateArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/file_properties/templates/remove_for_team", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    /**
     * Permanently removes the specified template created from {@link
     * DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}.
     * All properties associated with the template will also be removed. This
     * action cannot be undone.
     *
     * @param templateId  An identifier for a template created by {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void templatesRemoveForTeam(String templateId) throws TemplateErrorException, DbxException {
        RemoveTemplateArg _arg = new RemoveTemplateArg(templateId);
        templatesRemoveForTeam(_arg);
    }

    //
    // route 2/file_properties/templates/update_for_team
    //

    /**
     * Update a template associated with a team. This route can update the
     * template name, the template description and add optional properties to
     * templates.
     *
     */
    UpdateTemplateResult templatesUpdateForTeam(UpdateTemplateArg arg) throws ModifyTemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/update_for_team",
                                        arg,
                                        false,
                                        UpdateTemplateArg.Serializer.INSTANCE,
                                        UpdateTemplateResult.Serializer.INSTANCE,
                                        ModifyTemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/update_for_team", ex.getRequestId(), ex.getUserMessage(), (ModifyTemplateError) ex.getErrorValue());
        }
    }

    /**
     * Update a template associated with a team. This route can update the
     * template name, the template description and add optional properties to
     * templates.
     *
     * @param templateId  An identifier for template added by  See {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateTemplateResult templatesUpdateForTeam(String templateId) throws ModifyTemplateErrorException, DbxException {
        UpdateTemplateArg _arg = new UpdateTemplateArg(templateId);
        return templatesUpdateForTeam(_arg);
    }

    /**
     * Update a template associated with a team. This route can update the
     * template name, the template description and add optional properties to
     * templates.
     *
     * @param templateId  An identifier for template added by  See {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TemplatesUpdateForTeamBuilder templatesUpdateForTeamBuilder(String templateId) {
        UpdateTemplateArg.Builder argBuilder_ = UpdateTemplateArg.newBuilder(templateId);
        return new TemplatesUpdateForTeamBuilder(this, argBuilder_);
    }
}
