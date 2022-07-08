/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.fileproperties;

import com.dropbox.core.DbxException;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxUserFilePropertiesRequests#templatesUpdateForUserBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class TemplatesUpdateForUserBuilder {
    private final DbxUserFilePropertiesRequests _client;
    private final UpdateTemplateArg.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue
     *     file_properties requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    TemplatesUpdateForUserBuilder(DbxUserFilePropertiesRequests _client, UpdateTemplateArg.Builder _builder) {
        if (_client == null) {
            throw new NullPointerException("_client");
        }
        this._client = _client;
        if (_builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = _builder;
    }

    /**
     * Set value for optional field.
     *
     * @param name  A display name for the template. template names can be up to
     *     256 bytes.
     *
     * @return this builder
     */
    public TemplatesUpdateForUserBuilder withName(String name) {
        this._builder.withName(name);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param description  Description for the new template. Template
     *     descriptions can be up to 1024 bytes.
     *
     * @return this builder
     */
    public TemplatesUpdateForUserBuilder withDescription(String description) {
        this._builder.withDescription(description);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param addFields  Property field templates to be added to the group
     *     template. There can be up to 32 properties in a single template. Must
     *     not contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TemplatesUpdateForUserBuilder withAddFields(List<PropertyFieldTemplate> addFields) {
        this._builder.withAddFields(addFields);
        return this;
    }

    /**
     * Issues the request.
     */
    public UpdateTemplateResult start() throws ModifyTemplateErrorException, DbxException {
        UpdateTemplateArg arg_ = this._builder.build();
        return _client.templatesUpdateForUser(arg_);
    }
}
