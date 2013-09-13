package com.dropbox.core;

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

    public DbxAccountInfo(long userId, String displayName, String country, String referralLink, Quota quota)
    {
        this.userId = userId;
        this.displayName = displayName;
        this.country = country;
        this.referralLink = referralLink;
        this.quota = quota;
    }

    @Override
    protected void dumpFields(DumpWriter out)
    {
        out.field("userId", userId);
        out.field("displayName", displayName);
        out.field("country", country);
        out.field("referralLink", referralLink);
        out.field("quota", quota);
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
            out.field("total", total);
            out.field("normal", normal);
            out.field("shared", shared);
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

            return new DbxAccountInfo(uid, display_name, country, referral_link, quota_info);
        }
    };

    private static final int FM_uid = 0;
    private static final int FM_display_name = 1;
    private static final int FM_country = 2;
    private static final int FM_referral_link = 3;
    private static final int FM_quota_info = 4;
    private static final JsonReader.FieldMapping FM;

    static {
        JsonReader.FieldMapping.Builder b = new JsonReader.FieldMapping.Builder();
        b.add("uid", FM_uid);
        b.add("display_name", FM_display_name);
        b.add("country", FM_country);
        b.add("referral_link", FM_referral_link);
        b.add("quota_info", FM_quota_info);
        FM = b.build();
    }
}
