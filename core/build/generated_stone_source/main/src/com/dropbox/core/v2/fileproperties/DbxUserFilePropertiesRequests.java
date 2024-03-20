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
public class DbxUserFilePropertiesRequests {
    // namespace file_properties (file_properties.stone)

    private final DbxRawClientV2 client;

    public DbxUserFilePropertiesRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/file_properties/properties/add
    //

    /**
     * Add property groups to a Dropbox file. See {@link
     * DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)} or
     * {@link
     * DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)} to
     * create new templates.
     *
     */
    void propertiesAdd(AddPropertiesArg arg) throws AddPropertiesErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/file_properties/properties/add",
                                 arg,
                                 false,
                                 AddPropertiesArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 AddPropertiesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AddPropertiesErrorException("2/file_properties/properties/add", ex.getRequestId(), ex.getUserMessage(), (AddPropertiesError) ex.getErrorValue());
        }
    }

    /**
     * Add property groups to a Dropbox file. See {@link
     * DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)} or
     * {@link
     * DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)} to
     * create new templates.
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyGroups  The property groups which are to be added to a
     *     Dropbox file. No two groups in the input should  refer to the same
     *     template. Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void propertiesAdd(String path, List<PropertyGroup> propertyGroups) throws AddPropertiesErrorException, DbxException {
        AddPropertiesArg _arg = new AddPropertiesArg(path, propertyGroups);
        propertiesAdd(_arg);
    }

    //
    // route 2/file_properties/properties/overwrite
    //

    /**
     * Overwrite property groups associated with a file. This endpoint should be
     * used instead of {@link
     * DbxUserFilePropertiesRequests#propertiesUpdate(String,List)} when
     * property groups are being updated via a "snapshot" instead of via a
     * "delta". In other words, this endpoint will delete all omitted fields
     * from a property group, whereas {@link
     * DbxUserFilePropertiesRequests#propertiesUpdate(String,List)} will only
     * delete fields that are explicitly marked for deletion.
     *
     */
    void propertiesOverwrite(OverwritePropertyGroupArg arg) throws InvalidPropertyGroupErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/file_properties/properties/overwrite",
                                 arg,
                                 false,
                                 OverwritePropertyGroupArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 InvalidPropertyGroupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new InvalidPropertyGroupErrorException("2/file_properties/properties/overwrite", ex.getRequestId(), ex.getUserMessage(), (InvalidPropertyGroupError) ex.getErrorValue());
        }
    }

    /**
     * Overwrite property groups associated with a file. This endpoint should be
     * used instead of {@link
     * DbxUserFilePropertiesRequests#propertiesUpdate(String,List)} when
     * property groups are being updated via a "snapshot" instead of via a
     * "delta". In other words, this endpoint will delete all omitted fields
     * from a property group, whereas {@link
     * DbxUserFilePropertiesRequests#propertiesUpdate(String,List)} will only
     * delete fields that are explicitly marked for deletion.
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyGroups  The property groups "snapshot" updates to force
     *     apply. No two groups in the input should  refer to the same template.
     *     Must contain at least 1 items, not contain a {@code null} item, and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void propertiesOverwrite(String path, List<PropertyGroup> propertyGroups) throws InvalidPropertyGroupErrorException, DbxException {
        OverwritePropertyGroupArg _arg = new OverwritePropertyGroupArg(path, propertyGroups);
        propertiesOverwrite(_arg);
    }

    //
    // route 2/file_properties/properties/remove
    //

    /**
     * Permanently removes the specified property group from the file. To remove
     * specific property field key value pairs, see {@link
     * DbxUserFilePropertiesRequests#propertiesUpdate(String,List)}. To update a
     * template, see {@link
     * DbxUserFilePropertiesRequests#templatesUpdateForUser(String)} or {@link
     * DbxTeamFilePropertiesRequests#templatesUpdateForTeam(String)}. To remove
     * a template, see {@link
     * DbxUserFilePropertiesRequests#templatesRemoveForUser(String)} or {@link
     * DbxTeamFilePropertiesRequests#templatesRemoveForTeam(String)}.
     *
     */
    void propertiesRemove(RemovePropertiesArg arg) throws RemovePropertiesErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/file_properties/properties/remove",
                                 arg,
                                 false,
                                 RemovePropertiesArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 RemovePropertiesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RemovePropertiesErrorException("2/file_properties/properties/remove", ex.getRequestId(), ex.getUserMessage(), (RemovePropertiesError) ex.getErrorValue());
        }
    }

    /**
     * Permanently removes the specified property group from the file. To remove
     * specific property field key value pairs, see {@link
     * DbxUserFilePropertiesRequests#propertiesUpdate(String,List)}. To update a
     * template, see {@link
     * DbxUserFilePropertiesRequests#templatesUpdateForUser(String)} or {@link
     * DbxTeamFilePropertiesRequests#templatesUpdateForTeam(String)}. To remove
     * a template, see {@link
     * DbxUserFilePropertiesRequests#templatesRemoveForUser(String)} or {@link
     * DbxTeamFilePropertiesRequests#templatesRemoveForTeam(String)}.
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyTemplateIds  A list of identifiers for a template created
     *     by {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void propertiesRemove(String path, List<String> propertyTemplateIds) throws RemovePropertiesErrorException, DbxException {
        RemovePropertiesArg _arg = new RemovePropertiesArg(path, propertyTemplateIds);
        propertiesRemove(_arg);
    }

    //
    // route 2/file_properties/properties/search
    //

    /**
     * Search across property templates for particular property field values.
     *
     */
    PropertiesSearchResult propertiesSearch(PropertiesSearchArg arg) throws PropertiesSearchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/properties/search",
                                        arg,
                                        false,
                                        PropertiesSearchArg.Serializer.INSTANCE,
                                        PropertiesSearchResult.Serializer.INSTANCE,
                                        PropertiesSearchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PropertiesSearchErrorException("2/file_properties/properties/search", ex.getRequestId(), ex.getUserMessage(), (PropertiesSearchError) ex.getErrorValue());
        }
    }

    /**
     * Search across property templates for particular property field values.
     *
     * <p> The {@code templateFilter} request parameter will default to {@code
     * TemplateFilter.FILTER_NONE} (see {@link
     * #propertiesSearch(List,TemplateFilter)}). </p>
     *
     * @param queries  Queries to search. Must contain at least 1 items, not
     *     contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchResult propertiesSearch(List<PropertiesSearchQuery> queries) throws PropertiesSearchErrorException, DbxException {
        PropertiesSearchArg _arg = new PropertiesSearchArg(queries);
        return propertiesSearch(_arg);
    }

    /**
     * Search across property templates for particular property field values.
     *
     * @param queries  Queries to search. Must contain at least 1 items, not
     *     contain a {@code null} item, and not be {@code null}.
     * @param templateFilter  Filter results to contain only properties
     *     associated with these template IDs. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchResult propertiesSearch(List<PropertiesSearchQuery> queries, TemplateFilter templateFilter) throws PropertiesSearchErrorException, DbxException {
        if (templateFilter == null) {
            throw new IllegalArgumentException("Required value for 'templateFilter' is null");
        }
        PropertiesSearchArg _arg = new PropertiesSearchArg(queries, templateFilter);
        return propertiesSearch(_arg);
    }

    //
    // route 2/file_properties/properties/search/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserFilePropertiesRequests#propertiesSearch(List,TemplateFilter)}, use
     * this to paginate through all search results.
     *
     */
    PropertiesSearchResult propertiesSearchContinue(PropertiesSearchContinueArg arg) throws PropertiesSearchContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/properties/search/continue",
                                        arg,
                                        false,
                                        PropertiesSearchContinueArg.Serializer.INSTANCE,
                                        PropertiesSearchResult.Serializer.INSTANCE,
                                        PropertiesSearchContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PropertiesSearchContinueErrorException("2/file_properties/properties/search/continue", ex.getRequestId(), ex.getUserMessage(), (PropertiesSearchContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserFilePropertiesRequests#propertiesSearch(List,TemplateFilter)}, use
     * this to paginate through all search results.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserFilePropertiesRequests#propertiesSearch(List,TemplateFilter)}
     *     or {@link
     *     DbxUserFilePropertiesRequests#propertiesSearchContinue(String)}. Must
     *     have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchResult propertiesSearchContinue(String cursor) throws PropertiesSearchContinueErrorException, DbxException {
        PropertiesSearchContinueArg _arg = new PropertiesSearchContinueArg(cursor);
        return propertiesSearchContinue(_arg);
    }

    //
    // route 2/file_properties/properties/update
    //

    /**
     * Add, update or remove properties associated with the supplied file and
     * templates. This endpoint should be used instead of {@link
     * DbxUserFilePropertiesRequests#propertiesOverwrite(String,List)} when
     * property groups are being updated via a "delta" instead of via a
     * "snapshot" . In other words, this endpoint will not delete any omitted
     * fields from a property group, whereas {@link
     * DbxUserFilePropertiesRequests#propertiesOverwrite(String,List)} will
     * delete any fields that are omitted from a property group.
     *
     */
    void propertiesUpdate(UpdatePropertiesArg arg) throws UpdatePropertiesErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/file_properties/properties/update",
                                 arg,
                                 false,
                                 UpdatePropertiesArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 UpdatePropertiesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UpdatePropertiesErrorException("2/file_properties/properties/update", ex.getRequestId(), ex.getUserMessage(), (UpdatePropertiesError) ex.getErrorValue());
        }
    }

    /**
     * Add, update or remove properties associated with the supplied file and
     * templates. This endpoint should be used instead of {@link
     * DbxUserFilePropertiesRequests#propertiesOverwrite(String,List)} when
     * property groups are being updated via a "delta" instead of via a
     * "snapshot" . In other words, this endpoint will not delete any omitted
     * fields from a property group, whereas {@link
     * DbxUserFilePropertiesRequests#propertiesOverwrite(String,List)} will
     * delete any fields that are omitted from a property group.
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param updatePropertyGroups  The property groups "delta" updates to
     *     apply. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void propertiesUpdate(String path, List<PropertyGroupUpdate> updatePropertyGroups) throws UpdatePropertiesErrorException, DbxException {
        UpdatePropertiesArg _arg = new UpdatePropertiesArg(path, updatePropertyGroups);
        propertiesUpdate(_arg);
    }

    //
    // route 2/file_properties/templates/add_for_user
    //

    /**
     * Add a template associated with a user. See {@link
     * DbxUserFilePropertiesRequests#propertiesAdd(String,List)} to add
     * properties to a file. This endpoint can't be called on a team member or
     * admin's behalf.
     *
     */
    AddTemplateResult templatesAddForUser(AddTemplateArg arg) throws ModifyTemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/add_for_user",
                                        arg,
                                        false,
                                        AddTemplateArg.Serializer.INSTANCE,
                                        AddTemplateResult.Serializer.INSTANCE,
                                        ModifyTemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/add_for_user", ex.getRequestId(), ex.getUserMessage(), (ModifyTemplateError) ex.getErrorValue());
        }
    }

    /**
     * Add a template associated with a user. See {@link
     * DbxUserFilePropertiesRequests#propertiesAdd(String,List)} to add
     * properties to a file. This endpoint can't be called on a team member or
     * admin's behalf.
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
    public AddTemplateResult templatesAddForUser(String name, String description, List<PropertyFieldTemplate> fields) throws ModifyTemplateErrorException, DbxException {
        AddTemplateArg _arg = new AddTemplateArg(name, description, fields);
        return templatesAddForUser(_arg);
    }

    //
    // route 2/file_properties/templates/get_for_user
    //

    /**
     * Get the schema for a specified template. This endpoint can't be called on
     * a team member or admin's behalf.
     *
     */
    GetTemplateResult templatesGetForUser(GetTemplateArg arg) throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/get_for_user",
                                        arg,
                                        false,
                                        GetTemplateArg.Serializer.INSTANCE,
                                        GetTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/file_properties/templates/get_for_user", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    /**
     * Get the schema for a specified template. This endpoint can't be called on
     * a team member or admin's behalf.
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
    public GetTemplateResult templatesGetForUser(String templateId) throws TemplateErrorException, DbxException {
        GetTemplateArg _arg = new GetTemplateArg(templateId);
        return templatesGetForUser(_arg);
    }

    //
    // route 2/file_properties/templates/list_for_user
    //

    /**
     * Get the template identifiers for a team. To get the schema of each
     * template use {@link
     * DbxUserFilePropertiesRequests#templatesGetForUser(String)}. This endpoint
     * can't be called on a team member or admin's behalf.
     */
    public ListTemplateResult templatesListForUser() throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/list_for_user",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        ListTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/file_properties/templates/list_for_user", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    //
    // route 2/file_properties/templates/remove_for_user
    //

    /**
     * Permanently removes the specified template created from {@link
     * DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}.
     * All properties associated with the template will also be removed. This
     * action cannot be undone.
     *
     */
    void templatesRemoveForUser(RemoveTemplateArg arg) throws TemplateErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/file_properties/templates/remove_for_user",
                                 arg,
                                 false,
                                 RemoveTemplateArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/file_properties/templates/remove_for_user", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
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
    public void templatesRemoveForUser(String templateId) throws TemplateErrorException, DbxException {
        RemoveTemplateArg _arg = new RemoveTemplateArg(templateId);
        templatesRemoveForUser(_arg);
    }

    //
    // route 2/file_properties/templates/update_for_user
    //

    /**
     * Update a template associated with a user. This route can update the
     * template name, the template description and add optional properties to
     * templates. This endpoint can't be called on a team member or admin's
     * behalf.
     *
     */
    UpdateTemplateResult templatesUpdateForUser(UpdateTemplateArg arg) throws ModifyTemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_properties/templates/update_for_user",
                                        arg,
                                        false,
                                        UpdateTemplateArg.Serializer.INSTANCE,
                                        UpdateTemplateResult.Serializer.INSTANCE,
                                        ModifyTemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ModifyTemplateErrorException("2/file_properties/templates/update_for_user", ex.getRequestId(), ex.getUserMessage(), (ModifyTemplateError) ex.getErrorValue());
        }
    }

    /**
     * Update a template associated with a user. This route can update the
     * template name, the template description and add optional properties to
     * templates. This endpoint can't be called on a team member or admin's
     * behalf.
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
    public UpdateTemplateResult templatesUpdateForUser(String templateId) throws ModifyTemplateErrorException, DbxException {
        UpdateTemplateArg _arg = new UpdateTemplateArg(templateId);
        return templatesUpdateForUser(_arg);
    }

    /**
     * Update a template associated with a user. This route can update the
     * template name, the template description and add optional properties to
     * templates. This endpoint can't be called on a team member or admin's
     * behalf.
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
    public TemplatesUpdateForUserBuilder templatesUpdateForUserBuilder(String templateId) {
        UpdateTemplateArg.Builder argBuilder_ = UpdateTemplateArg.newBuilder(templateId);
        return new TemplatesUpdateForUserBuilder(this, argBuilder_);
    }
}
