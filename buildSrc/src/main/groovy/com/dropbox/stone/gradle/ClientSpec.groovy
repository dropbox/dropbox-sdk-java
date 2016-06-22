package com.dropbox.stone.gradle

import org.gradle.api.Named
import org.gradle.api.tasks.Input

/**
 * Specification for generating a single client. Stone can be configured to generate multiple
 * clients.
 */
public class ClientSpec implements Named {
    /**
     * Class name to use for generated client.
     */
    private final String name

    /**
     * Class-level Javadoc to use for generated client.
     *
     * Default: "Generated Stone client."
     */
    private String javadoc

    /**
     * Class name format for routes generated for this client.
     *
     * <p> This name format string will be used to name route classes. The string should contain a
     * single Python string format placeholder, "%s". The placeholder will be substituted with the
     * namespace name for the routes. The names will be properly capitalized in accordance with Java
     * conventions.
     *
     * <p> Example:
     * <pre>
     *     stone {
     *         package "org.example"
     *
     *         clients {
     *             ProdClient {
     *                 routeFilter 'mode="prod" and testing=false'
     *                 routesClassNameFormat "StoneProd%sRequests"
     *             }
     *             DevClient {
     *                 routeFilter 'mode="dev" and owner!="infra"'
     *                 routesClassNameFormat "StoneDev%sRequests"
     *             }
     *         }
     *     }
     * </pre>
     *
     * <p> Note that in the above example, {@code "testing"} and {@code "infra"} cannot be used in
     * the name format string. {@code "testing"} is only used in one of the clients, not all the
     * clients. {@code "infra"} uses a not-equals comparison.
     *
     * Default: "Stone%(namespace)sRequests"
     */
    private String routesClassNameFormat

    /**
     * A String expression for filtering routes based on route attributes.
     *
     * <p> The expression must specify a route attribute on the left-hand side and a value on the
     * right-hand side. Use quotes for strings and bytes. The only supported operators are "=" and
     * "!=". You can also compbine multiple expressions with "and"/"or" and use parentheses to
     * enforce precedence.
     *
     * Example that filters routes to only include beta "user" auth routes and routes that are not
     * "production" mode:
     *
     * <pre>
     *     (auth="user" and beta=true) or mode!="production"
     * </pre>
     *
     * Default: null (no filtering applied)
     */
    private String routeFilter

    public ClientSpec(String name) {
        this.name = name
        this.javadoc = "Generated Stone client."
        this.routesClassNameFormat = "Stone%sRequests"
        this.routeFilter = ""
    }

    @Input
    @Override
    public String getName() {
        return name
    }

    public void javadoc(String javadoc) {
        this.javadoc = javadoc
    }

    public void setJavadoc(String javadoc) {
        this.javadoc = javadoc
    }

    @Input
    public String getJavadoc() {
        return javadoc
    }

    public void routesClassNameFormat(String routesClassNameFormat) {
        this.routesClassNameFormat = routesClassNameFormat
    }

    public void setRoutesClassNameFormat(String routesClassNameFormat) {
        this.routesClassNameFormat = routesClassNameFormat
    }

    @Input
    public String getRoutesClassNameFormat() {
        return routesClassNameFormat
    }

    public void routeFilter(String routeFilter) {
        this.setRouteFilter(routeFilter)
    }

    public void setRouteFilter(String routeFilter) {
        this.routeFilter = routeFilter
    }

    @Input
    public String getRouteFilter() {
        return routeFilter
    }
}
