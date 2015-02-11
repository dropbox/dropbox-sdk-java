package com.dropbox.core;

import java.io.IOException;
import java.io.OutputStream;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.http.HttpRequestor;

public class DbxUploader<R,E,X extends Throwable> {
    private HttpRequestor.Uploader httpUploader;
    private JsonReader<R> resultReader;
    private JsonReader<E> errorReader;
    private DbxRequestUtil.RouteSpecificErrorMaker<X> errorMaker;

    protected DbxUploader(HttpRequestor.Uploader httpUploader,
                          JsonReader<R> resultReader, JsonReader<E> errorReader,
                          DbxRequestUtil.RouteSpecificErrorMaker<X> errorMaker) {
        this.httpUploader = httpUploader;
        this.resultReader = resultReader;
        this.errorReader = errorReader;
        this.errorMaker = errorMaker;
    }

    public static abstract class UploaderMaker<R,E,X extends Throwable> {
        public abstract DbxUploader<R,E,X> makeUploader(HttpRequestor.Uploader httpUploader);
    }

    public OutputStream getBody() { return this.httpUploader.body; }

    public void close() { }

    public void abort() { }

    public R finish() throws DbxException, X {
        HttpRequestor.Response response;
        try {
            response = httpUploader.finish();
            if (response.statusCode == 200) {
                return resultReader.readFully(response.body);
            }
            else if (response.statusCode == 409) {
                throw errorMaker.makeError(new DbxRequestUtil.ErrorWrapper(errorReader, response.body));
            }
            else {
                throw DbxRequestUtil.unexpectedStatus(response);
            }
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
        catch (JsonReadException ex) {
            throw new DbxException.BadResponse("Bad JSON in response " + ex, ex);
        }
    }
}
