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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Signed in.
 */
public class LoginSuccessDetails {
    // struct team_log.LoginSuccessDetails (team_log_generated.stone)

    @Nullable
    protected final Boolean isEmmManaged;
    @Nonnull
    protected final LoginMethod loginMethod;

    /**
     * Signed in.
     *
     * @param loginMethod  Login method. Must not be {@code null}.
     * @param isEmmManaged  Tells if the login device is EMM managed. Might be
     *     missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LoginSuccessDetails(@Nonnull LoginMethod loginMethod, @Nullable Boolean isEmmManaged) {
        this.isEmmManaged = isEmmManaged;
        if (loginMethod == null) {
            throw new IllegalArgumentException("Required value for 'loginMethod' is null");
        }
        this.loginMethod = loginMethod;
    }

    /**
     * Signed in.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param loginMethod  Login method. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LoginSuccessDetails(@Nonnull LoginMethod loginMethod) {
        this(loginMethod, null);
    }

    /**
     * Login method.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public LoginMethod getLoginMethod() {
        return loginMethod;
    }

    /**
     * Tells if the login device is EMM managed. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsEmmManaged() {
        return isEmmManaged;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            isEmmManaged,
            loginMethod
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
            LoginSuccessDetails other = (LoginSuccessDetails) obj;
            return ((this.loginMethod == other.loginMethod) || (this.loginMethod.equals(other.loginMethod)))
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
    static class Serializer extends StructSerializer<LoginSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LoginSuccessDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("login_method");
            LoginMethod.Serializer.INSTANCE.serialize(value.loginMethod, g);
            if (value.isEmmManaged != null) {
                g.writeFieldName("is_emm_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isEmmManaged, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LoginSuccessDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LoginSuccessDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                LoginMethod f_loginMethod = null;
                Boolean f_isEmmManaged = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("login_method".equals(field)) {
                        f_loginMethod = LoginMethod.Serializer.INSTANCE.deserialize(p);
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
                value = new LoginSuccessDetails(f_loginMethod, f_isEmmManaged);
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
