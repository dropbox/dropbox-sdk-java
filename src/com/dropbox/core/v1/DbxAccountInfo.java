package com.dropbox.core.v1;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class DbxAccountInfo extends Dumpable
{
    public final long userId;
    public final String displayName;
    public final String country;
    public final String referralLink;
    public final Quota quota;
    public final String email;
    public final NameDetails nameDetails;
    public final boolean emailVerified;


    public DbxAccountInfo(long userId, String displayName, String country, String referralLink, Quota quota, String email,
                          NameDetails nameDetails, boolean emailVerified)
    {
        this.userId = userId;
        this.displayName = displayName;
        this.country = country;
        this.referralLink = referralLink;
        this.quota = quota;
        this.email = email;
        this.nameDetails = nameDetails;
        this.emailVerified = emailVerified;
    }

    @Override
    protected void dumpFields(DumpWriter out)
    {
        out.f("userId").v(userId);
        out.f("displayName").v(displayName);
        out.f("country").v(country);
        out.f("referralLink").v(referralLink);
        out.f("quota").v(quota);
        out.f("nameDetails").v(nameDetails);
        out.f("email").v(email);
        out.f("emailVerified").v(emailVerified);
    }

    public static final class Quota extends Dumpable
    {
        public final long total;
        public final long normal;
        public final long shared;

        public Quota(long quota, long normal, long quotaShared)
        {
            this.total = quota;
            this.normal = normal;
            this.shared = quotaShared;
        }

        @Override
        protected void dumpFields(DumpWriter out)
        {
            out.f("total").v(total);
            out.f("normal").v(normal);
            out.f("shared").v(shared);
        }

        // ------------------------------------------------------
        // JSON parsing

        public static final JsonReader<Quota> Reader = new JsonReader<Quota>()
        {
            public final Quota read(JsonParser parser)
                throws IOException, JsonReadException
            {
                JsonLocation top = JsonReader.expectObjectStart(parser);

                long quota = -1;
                long normal = -1;
                long shared = -1;

                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();

                    int fi = FM.get(fieldName);
                    try {
                        switch (fi) {
                            case -1: JsonReader.skipValue(parser); break;
                            case FM_quota: quota = JsonReader.readUnsignedLongField(parser, fieldName, quota); break;
                            case FM_normal: normal = JsonReader.readUnsignedLongField(parser, fieldName, normal); break;
                            case FM_shared: shared = JsonReader.readUnsignedLongField(parser, fieldName, shared); break;
                            default:
                                throw new AssertionError("bad index: " + fi + ", field = \"" + fieldName + "\"");
                        }
                    }
                    catch (JsonReadException ex) {
                        throw ex.addFieldContext(fieldName);
                    }
                }

                JsonReader.expectObjectEnd(parser);

                if (quota < 0) throw new JsonReadException("missing field \"quota\"", top);
                if (normal < 0) throw new JsonReadException("missing field \"normal\"", top);
                if (shared < 0) throw new JsonReadException("missing field \"shared\"", top);

                return new Quota(quota, normal, shared);
            }
        };

        private static final int FM_quota = 0;
        private static final int FM_normal = 1;
        private static final int FM_shared = 2;
        private static final JsonReader.FieldMapping FM;

        static {
            JsonReader.FieldMapping.Builder b = new JsonReader.FieldMapping.Builder();
            b.add("quota", FM_quota);
            b.add("normal", FM_normal);
            b.add("shared", FM_shared);
            FM = b.build();
        }

    }

    public static final class NameDetails extends Dumpable
    {
        public final String familiarName;
        public final String givenName;
        public final String surname;

        public NameDetails(String familiarName, String givenName, String surname)
        {
            this.familiarName = familiarName;
            this.givenName = givenName;
            this.surname = surname;
        }

        @Override
        protected void dumpFields(DumpWriter out)
        {
            out.f("familiarName").v(familiarName);
            out.f("givenName").v(givenName);
            out.f("surname").v(surname);
        }

        // ------------------------------------------------------
        // JSON parsing

        public static final JsonReader<NameDetails> Reader = new JsonReader<NameDetails>()
        {
            public final NameDetails read(JsonParser parser)
                    throws IOException, JsonReadException
            {
                JsonLocation top = JsonReader.expectObjectStart(parser);

                String familiarName = null;
                String givenName = null;
                String surname = null;

                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();

                    int fi = FM.get(fieldName);
                    try {
                        switch (fi) {
                            case -1: JsonReader.skipValue(parser); break;
                            case FM_familiar_name: familiarName = JsonReader.StringReader.readField(parser, fieldName, familiarName); break;
                            case FM_given_name: givenName = JsonReader.StringReader.readField(parser, fieldName, givenName); break;
                            case FM_surname: surname = JsonReader.StringReader.readField(parser, fieldName, surname); break;
                            default:
                                throw new AssertionError("bad index: " + fi + ", field = \"" + fieldName + "\"");
                        }
                    }
                    catch (JsonReadException ex) {
                        throw ex.addFieldContext(fieldName);
                    }
                }

                JsonReader.expectObjectEnd(parser);

                if (familiarName == null) throw new JsonReadException("missing field \"familiarName\"", top);
                if (surname == null) throw new JsonReadException("missing field \"surname\"", top);
                if (givenName == null) throw new JsonReadException("missing field \"givenName\"", top);

                return new NameDetails(familiarName, givenName, surname);
            }
        };

        private static final int FM_familiar_name = 0;
        private static final int FM_given_name = 1;
        private static final int FM_surname = 2;
        private static final JsonReader.FieldMapping FM;

        static {
            JsonReader.FieldMapping.Builder b = new JsonReader.FieldMapping.Builder();
            b.add("familiar_name", FM_familiar_name);
            b.add("given_name", FM_given_name);
            b.add("surname", FM_surname);
            FM = b.build();
        }

    }

    // ------------------------------------------------------
    // JSON parsing

    public static final JsonReader<DbxAccountInfo> Reader = new JsonReader<DbxAccountInfo>()
    {
        public final DbxAccountInfo read(JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            long uid = -1;
            String display_name = null;
            String country = null;
            String referral_link = null;
            Quota quota_info = null;
            String email = null;
            NameDetails nameDetails = null;
            Boolean emailVerified = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    int fi = FM.get(fieldName);
                    switch (fi) {
                        case -1: JsonReader.skipValue(parser); break;
                        case FM_uid: uid = JsonReader.readUnsignedLongField(parser, fieldName, uid); break;
                        case FM_display_name: display_name = JsonReader.StringReader.readField(parser, fieldName, display_name); break;
                        case FM_country: country = JsonReader.StringReader.readField(parser, fieldName, country); break;
                        case FM_referral_link: referral_link = JsonReader.StringReader.readField(parser, fieldName, referral_link); break;
                        case FM_quota_info: quota_info = Quota.Reader.readField(parser, fieldName, quota_info); break;
                        case FM_name_details: nameDetails = NameDetails.Reader.readField(parser, fieldName, nameDetails); break;
                        case FM_email: email = JsonReader.StringReader.readField(parser, fieldName, email); break;
                        case FM_email_verified: emailVerified = JsonReader.BooleanReader.readField(parser, fieldName, emailVerified); break;
                        default:
                            throw new AssertionError("bad index: " + fi + ", field = \"" + fieldName + "\"");
                    }
                }
                catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);

            if (uid < 0) throw new JsonReadException("missing field \"uid\"", top);
            if (display_name == null) throw new JsonReadException("missing field \"display_name\"", top);
            if (country == null) throw new JsonReadException("missing field \"country\"", top);
            if (referral_link == null) throw new JsonReadException("missing field \"referral_link\"", top);
            if (quota_info == null) throw new JsonReadException("missing field \"quota_info\"", top);
            if (email == null) throw new JsonReadException("missing field \"email\"", top);
            if (nameDetails == null) throw new JsonReadException("missing field \"nameDetails\"", top);
            if (emailVerified == null) throw new JsonReadException("missing field \"emailVerified\"", top);

            return new DbxAccountInfo(uid, display_name, country, referral_link, quota_info, email, nameDetails, emailVerified);
        }
    };

    private static final int FM_uid = 0;
    private static final int FM_display_name = 1;
    private static final int FM_country = 2;
    private static final int FM_referral_link = 3;
    private static final int FM_quota_info = 4;
    private static final int FM_name_details = 5;
    private static final int FM_email = 6;
    private static final int FM_email_verified = 7;

    private static final JsonReader.FieldMapping FM;

    static {
        JsonReader.FieldMapping.Builder b = new JsonReader.FieldMapping.Builder();
        b.add("uid", FM_uid);
        b.add("display_name", FM_display_name);
        b.add("country", FM_country);
        b.add("referral_link", FM_referral_link);
        b.add("quota_info", FM_quota_info);
        b.add("name_details", FM_name_details);
        b.add("email", FM_email);
        b.add("email_verified", FM_email_verified);

        FM = b.build();
    }
}
