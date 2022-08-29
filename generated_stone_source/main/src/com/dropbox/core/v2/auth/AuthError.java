/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

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
 * Errors occurred during authentication.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class AuthError {
    // union auth.AuthError (auth.stone)

    /**
     * Discriminating tag type for {@link AuthError}.
     */
    public enum Tag {
        /**
         * The access token is invalid.
         */
        INVALID_ACCESS_TOKEN,
        /**
         * The user specified in 'Dropbox-API-Select-User' is no longer on the
         * team.
         */
        INVALID_SELECT_USER,
        /**
         * The user specified in 'Dropbox-API-Select-Admin' is not a Dropbox
         * Business team admin.
         */
        INVALID_SELECT_ADMIN,
        /**
         * The user has been suspended.
         */
        USER_SUSPENDED,
        /**
         * The access token has expired.
         */
        EXPIRED_ACCESS_TOKEN,
        /**
         * The access token does not have the required scope to access the
         * route.
         */
        MISSING_SCOPE, // TokenScopeError
        /**
         * The route is not available to public.
         */
        ROUTE_ACCESS_DENIED,
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * The access token is invalid.
     */
    public static final AuthError INVALID_ACCESS_TOKEN = new AuthError().withTag(Tag.INVALID_ACCESS_TOKEN);
    /**
     * The user specified in 'Dropbox-API-Select-User' is no longer on the team.
     */
    public static final AuthError INVALID_SELECT_USER = new AuthError().withTag(Tag.INVALID_SELECT_USER);
    /**
     * The user specified in 'Dropbox-API-Select-Admin' is not a Dropbox
     * Business team admin.
     */
    public static final AuthError INVALID_SELECT_ADMIN = new AuthError().withTag(Tag.INVALID_SELECT_ADMIN);
    /**
     * The user has been suspended.
     */
    public static final AuthError USER_SUSPENDED = new AuthError().withTag(Tag.USER_SUSPENDED);
    /**
     * The access token has expired.
     */
    public static final AuthError EXPIRED_ACCESS_TOKEN = new AuthError().withTag(Tag.EXPIRED_ACCESS_TOKEN);
    /**
     * The route is not available to public.
     */
    public static final AuthError ROUTE_ACCESS_DENIED = new AuthError().withTag(Tag.ROUTE_ACCESS_DENIED);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final AuthError OTHER = new AuthError().withTag(Tag.OTHER);

    private Tag _tag;
    private TokenScopeError missingScopeValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private AuthError() {
    }


    /**
     * Errors occurred during authentication.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private AuthError withTag(Tag _tag) {
        AuthError result = new AuthError();
        result._tag = _tag;
        return result;
    }

    /**
     * Errors occurred during authentication.
     *
     * @param missingScopeValue  The access token does not have the required
     *     scope to access the route. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AuthError withTagAndMissingScope(Tag _tag, TokenScopeError missingScopeValue) {
        AuthError result = new AuthError();
        result._tag = _tag;
        result.missingScopeValue = missingScopeValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code AuthError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_ACCESS_TOKEN}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_ACCESS_TOKEN}, {@code false} otherwise.
     */
    public boolean isInvalidAccessToken() {
        return this._tag == Tag.INVALID_ACCESS_TOKEN;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_SELECT_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_SELECT_USER}, {@code false} otherwise.
     */
    public boolean isInvalidSelectUser() {
        return this._tag == Tag.INVALID_SELECT_USER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_SELECT_ADMIN}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_SELECT_ADMIN}, {@code false} otherwise.
     */
    public boolean isInvalidSelectAdmin() {
        return this._tag == Tag.INVALID_SELECT_ADMIN;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#USER_SUSPENDED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_SUSPENDED}, {@code false} otherwise.
     */
    public boolean isUserSuspended() {
        return this._tag == Tag.USER_SUSPENDED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#EXPIRED_ACCESS_TOKEN}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EXPIRED_ACCESS_TOKEN}, {@code false} otherwise.
     */
    public boolean isExpiredAccessToken() {
        return this._tag == Tag.EXPIRED_ACCESS_TOKEN;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MISSING_SCOPE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MISSING_SCOPE}, {@code false} otherwise.
     */
    public boolean isMissingScope() {
        return this._tag == Tag.MISSING_SCOPE;
    }

    /**
     * Returns an instance of {@code AuthError} that has its tag set to {@link
     * Tag#MISSING_SCOPE}.
     *
     * <p> The access token does not have the required scope to access the
     * route. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AuthError} with its tag set to {@link
     *     Tag#MISSING_SCOPE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AuthError missingScope(TokenScopeError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AuthError().withTagAndMissingScope(Tag.MISSING_SCOPE, value);
    }

    /**
     * The access token does not have the required scope to access the route.
     *
     * <p> This instance must be tagged as {@link Tag#MISSING_SCOPE}. </p>
     *
     * @return The {@link TokenScopeError} value associated with this instance
     *     if {@link #isMissingScope} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMissingScope} is {@code
     *     false}.
     */
    public TokenScopeError getMissingScopeValue() {
        if (this._tag != Tag.MISSING_SCOPE) {
            throw new IllegalStateException("Invalid tag: required Tag.MISSING_SCOPE, but was Tag." + this._tag.name());
        }
        return missingScopeValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ROUTE_ACCESS_DENIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ROUTE_ACCESS_DENIED}, {@code false} otherwise.
     */
    public boolean isRouteAccessDenied() {
        return this._tag == Tag.ROUTE_ACCESS_DENIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            missingScopeValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        else if (obj instanceof AuthError) {
            AuthError other = (AuthError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INVALID_ACCESS_TOKEN:
                    return true;
                case INVALID_SELECT_USER:
                    return true;
                case INVALID_SELECT_ADMIN:
                    return true;
                case USER_SUSPENDED:
                    return true;
                case EXPIRED_ACCESS_TOKEN:
                    return true;
                case MISSING_SCOPE:
                    return (this.missingScopeValue == other.missingScopeValue) || (this.missingScopeValue.equals(other.missingScopeValue));
                case ROUTE_ACCESS_DENIED:
                    return true;
                case OTHER:
                    return true;
                default:
                    return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    public static class Serializer extends UnionSerializer<AuthError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AuthError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INVALID_ACCESS_TOKEN: {
                    g.writeString("invalid_access_token");
                    break;
                }
                case INVALID_SELECT_USER: {
                    g.writeString("invalid_select_user");
                    break;
                }
                case INVALID_SELECT_ADMIN: {
                    g.writeString("invalid_select_admin");
                    break;
                }
                case USER_SUSPENDED: {
                    g.writeString("user_suspended");
                    break;
                }
                case EXPIRED_ACCESS_TOKEN: {
                    g.writeString("expired_access_token");
                    break;
                }
                case MISSING_SCOPE: {
                    g.writeStartObject();
                    writeTag("missing_scope", g);
                    TokenScopeError.Serializer.INSTANCE.serialize(value.missingScopeValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case ROUTE_ACCESS_DENIED: {
                    g.writeString("route_access_denied");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AuthError deserialize(JsonParser p) throws IOException, JsonParseException {
            AuthError value;
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
            else if ("invalid_access_token".equals(tag)) {
                value = AuthError.INVALID_ACCESS_TOKEN;
            }
            else if ("invalid_select_user".equals(tag)) {
                value = AuthError.INVALID_SELECT_USER;
            }
            else if ("invalid_select_admin".equals(tag)) {
                value = AuthError.INVALID_SELECT_ADMIN;
            }
            else if ("user_suspended".equals(tag)) {
                value = AuthError.USER_SUSPENDED;
            }
            else if ("expired_access_token".equals(tag)) {
                value = AuthError.EXPIRED_ACCESS_TOKEN;
            }
            else if ("missing_scope".equals(tag)) {
                TokenScopeError fieldValue = null;
                fieldValue = TokenScopeError.Serializer.INSTANCE.deserialize(p, true);
                value = AuthError.missingScope(fieldValue);
            }
            else if ("route_access_denied".equals(tag)) {
                value = AuthError.ROUTE_ACCESS_DENIED;
            }
            else {
                value = AuthError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
