package com.dropbox.core;

import java.io.IOException;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/*>>> import checkers.nullness.quals.Nullable; */

public class DbxMember extends Dumpable implements java.io.Serializable
{
    public static final long serialVersionUID = 0;

    public final String memberId;

    /**
     * This is almost always {@link DbxHost#Default}.  This is only set differently for testing
     * purposes.
     */
    public final DbxHost host;

    public DbxMember(String memberId)
    {
    	this.memberId = memberId;
        this.host = DbxHost.Default;
    }

    public DbxMember(String memberId, DbxHost host)
    {
    	this.memberId = memberId;
        this.host = host;
    }

    @Override
    protected void dumpFields(DumpWriter out)
    {
        out.field("member_id", memberId);
    }


    // ------------------------------------------------------
    // JSON parsing

    public static final JsonReader<DbxMember> Reader = new JsonReader<DbxMember>()
    {
        @Override
        public final DbxMember read(JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String memberId = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("memeber_id")) {
                    	memberId = MemberIdReader.readField(parser, fieldName, memberId);
                    }
                    else {
                        // Unknown field.  Skip over it.
                        JsonReader.skipValue(parser);
                    }
                }
                catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);

            if (memberId == null) throw new JsonReadException("missing field \"member_id\"", top);

            return new DbxMember(memberId);
        }
    };

    public static final JsonReader<String> MemberIdReader = new JsonReader<String>()
    {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException
        {
            try {
                String v = parser.getText();
                parser.nextToken();
                return v;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }
    };


 
}
