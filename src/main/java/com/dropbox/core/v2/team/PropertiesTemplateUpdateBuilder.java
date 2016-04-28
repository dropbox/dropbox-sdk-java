/* DO NOT EDIT */
/* This file was generated from team_property_templates.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.properties.ModifyPropertyTemplateErrorException;
import com.dropbox.core.v2.properties.PropertyFieldTemplate;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#propertiesTemplateUpdateBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class PropertiesTemplateUpdateBuilder {
    private final DbxTeamTeamRequests team;
    private final UpdatePropertyTemplateArg.Builder updatePropertyTemplateArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param updatePropertyTemplateArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    PropertiesTemplateUpdateBuilder(DbxTeamTeamRequests team, UpdatePropertyTemplateArg.Builder updatePropertyTemplateArgBuilder) {
        if (team == null) {
            throw new NullPointerException("team");
        }
        if (updatePropertyTemplateArgBuilder == null) {
            throw new NullPointerException("updatePropertyTemplateArgBuilder");
        }
        this.team = team;
        this.updatePropertyTemplateArgBuilder = updatePropertyTemplateArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param name  A display name for the property template. Property template
     *     names can be up to 256 bytes.
     *
     * @return this builder
     */
    public PropertiesTemplateUpdateBuilder withName(String name) {
        this.updatePropertyTemplateArgBuilder.withName(name);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param description  Description for new property template. Property
     *     template descriptions can be up to 1024 bytes.
     *
     * @return this builder
     */
    public PropertiesTemplateUpdateBuilder withDescription(String description) {
        this.updatePropertyTemplateArgBuilder.withDescription(description);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param addFields  This is a list of custom properties to add to the
     *     property template. There can be up to 64 properties in a single
     *     property template. Must not contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesTemplateUpdateBuilder withAddFields(List<PropertyFieldTemplate> addFields) {
        this.updatePropertyTemplateArgBuilder.withAddFields(addFields);
        return this;
    }

    /**
     * Issues the request.
     */
    public UpdatePropertyTemplateResult start() throws ModifyPropertyTemplateErrorException, DbxException {
        UpdatePropertyTemplateArg arg = this.updatePropertyTemplateArgBuilder.build();
        return team.propertiesTemplateUpdate(arg);
    }
}
