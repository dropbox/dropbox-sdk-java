package com.dropbox.core.examples.authorize;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigHelper
{
    public static final class AppInfoAndHostJson
    {
        public final DbxAppInfo object;
        public final JsonNode hostJson;

        public AppInfoAndHostJson(DbxAppInfo object, JsonNode hostJson)
        {
            this.object = object;
            this.hostJson = hostJson;
        }
    }

    public static DbxAppInfo loadAppInfo(String file)
        throws Exception
    {
        return loadAppInfoAndRawJson(file).object;
    }

    public static AppInfoAndHostJson loadAppInfoAndRawJson(String file)
        throws Exception
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            FileInputStream fin = new FileInputStream(file);
            try {
                IOUtil.copyStreamToStream(fin, out);
            }
            finally {
                IOUtil.closeInput(fin);
            }
        }
        catch (IOException ex) {
            throw new Exception("unable to read file \"" + file + "\": " + ex.getMessage());
        }

        byte[] data = out.toByteArray();

        // Parse once with generic parser.
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rawJson;
        try {
            rawJson = objectMapper.readTree(data);
        }
        catch (JsonProcessingException ex) {
            throw new Exception("\"" + file + "\": bad JSON: " + ex.getMessage());
        }
        catch (IOException ex) {
            throw LangUtil.mkAssert("not doing IO", ex);
        }

        // Parse once into an DbxAppInfo object.
        DbxAppInfo appInfo;
        try {
            appInfo = DbxAppInfo.Reader.readFully(data);
        }
        catch (JsonReadException ex) {
            throw new Exception("\"" + file + "\": " + ex.getMessage());
        }

        JsonNode hostJson = rawJson.get("host");

        return new AppInfoAndHostJson(appInfo, hostJson);
    }

    public static final class Exception extends java.lang.Exception
    {
        public Exception(String message)
        {
            super(message);
        }
    }
}
