/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Failed to sign in.
 */
public class LoginFailDetails {
    // struct team_log.LoginFailDetails (team_log_generated.stone)

    protected final Boolean isEmmManaged;
    protected final LoginMethod loginMethod;
    protected final FailureDetailsLogInfo errorDetails;

    /**
     * Failed to sign in.
     *
     * @param loginMethod  Login method. Must not be {@code null}.
     * @param errorDetails  Error details. Must not be {@code null}.
     * @param isEmmManaged  Tells if the login device is EMM managed. Might be
     *     missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LoginFailDetails(LoginMethod loginMethod, FailureDetailsLogInfo errorDetails, Boolean isEmmManaged) {
        this.isEmmManaged = isEmmManaged;
        if (loginMethod == null) {
            throw new IllegalArgumentException("Required value for 'loginMethod' is null");
        }
        this.loginMethod = loginMethod;
        if (errorDetails == null) {
            throw new IllegalArgumentException("Required value for 'errorDetails' is null");
        }
        this.errorDetails = errorDetails;
    }

    /**
     * Failed to sign in.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param loginMethod  Login method. Must not be {@code null}.
     * @param errorDetails  Error details. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LoginFailDetails(LoginMethod loginMethod, FailureDetailsLogInfo errorDetails) {
        this(loginMethod, errorDetails, null);
    }

    /**
     * Login method.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public LoginMethod getLoginMethod() {
        return loginMethod;
    }

    /**
     * Error details.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public FailureDetailsLogInfo getErrorDetails() {
        return errorDetails;
    }

    /**
     * Tells if the login device is EMM managed. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Boolean getIsEmmManaged() {
        return isEmmManaged;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            isEmmManaged,
            loginMethod,
            errorDetails
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
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            LoginFailDetails other = (LoginFailDetails) obj;
            return ((this.loginMethod == other.loginMethod) || (this.loginMethod.equals(other.loginMethod)))
                && ((this.errorDetails == other.errorDetails) || (this.errorDetails.equals(other.errorDetails)))
                && ((this.isEmmManaged == other.isEmmManaged) || (this.isEmmManaged != null && this.isEmmManaged.equals(other.isEmmManaged)))
                ;
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
    static class Serializer extends StructSerializer<LoginFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LoginFailDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("login_method");
            LoginMethod.Serializer.INSTANCE.serialize(value.loginMethod, g);
            g.writeFieldName("error_details");
            FailureDetailsLogInfo.Serializer.INSTANCE.serialize(value.errorDetails, g);
            if (value.isEmmManaged != null) {
                g.writeFieldName("is_emm_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isEmmManaged, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LoginFailDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LoginFailDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                LoginMethod f_loginMethod = null;
                FailureDetailsLogInfo f_errorDetails = null;
                Boolean f_isEmmManaged = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("login_method".equals(field)) {
                        f_loginMethod = LoginMethod.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("error_details".equals(field)) {
                        f_errorDetails = FailureDetailsLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("is_emm_managed".equals(field)) {
                        f_isEmmManaged = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_loginMethod == null) {
                    throw new JsonParseException(p, "Required field \"login_method\" missing.");
                }
                if (f_errorDetails == null) {
                    throw new JsonParseException(p, "Required field \"error_details\" missing.");
                }
                value = new LoginFailDetails(f_loginMethod, f_errorDetails, f_isEmmManaged);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
