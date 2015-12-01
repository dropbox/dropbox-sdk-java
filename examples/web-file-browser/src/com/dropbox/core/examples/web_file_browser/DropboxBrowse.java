package com.dropbox.core.examples.web_file_browser;

import static com.dropbox.core.util.StringUtil.jq;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles;
import com.dropbox.core.v2.DbxPathV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;

/**
 * Handles the endpoints related to browsing and uploading files via the Dropbox API.
 */
public class DropboxBrowse
{
    private Common common;

    public DropboxBrowse(Common common)
    {
        this.common = common;
    }

    private DbxClientV2 requireDbxClient(HttpServletRequest request, HttpServletResponse response, User user)
            throws IOException, ServletException
    {
        if (user.dropboxAccessToken == null) {
            common.pageSoftError(response, "This page requires a user whose has linked to their Dropbox account.  Current user hasn't linked us to their Dropbox account.");
            return null;
        }

        return new DbxClientV2(common.getRequestConfig(request),
                               user.dropboxAccessToken,
                               common.dbxAppInfo.host);
    }

    private boolean checkPathError(HttpServletResponse response, String path, DbxFiles.LookupError le)
        throws IOException
    {
        switch (le.tag) {
            case notFound: case notFolder:
                response.sendError(400, "Path doesn't exist on Dropbox: " + jq(path));
                return true;
        }
        return false;
    }

    private void renderFolder(HttpServletResponse response, User user, DbxClientV2 dbxClient, String path)
        throws IOException
    {
        // Get the folder listing from Dropbox.
        TreeMap<String,DbxFiles.Metadata> children = new TreeMap<String,DbxFiles.Metadata>();

        DbxFiles.ListFolderResult result;
        try {
            try {
                result = dbxClient.files.listFolder(path);
            }
            catch (DbxFiles.ListFolderException ex) {
                if (ex.errorValue.tag == DbxFiles.ListFolderError.Tag.path) {
                    if (checkPathError(response, path, ex.errorValue.getPath())) return;
                }
                throw ex;
            }

            while (true) {
                for (DbxFiles.Metadata md : result.entries) {
                    if (md instanceof DbxFiles.DeletedMetadata) {
                        children.remove(md.pathLower);
                    } else {
                        children.put(md.pathLower, md);
                    }
                }

                if (!result.hasMore) break;

                try {
                    result = dbxClient.files.listFolderContinue(result.cursor);
                }
                catch (DbxFiles.ListFolderContinueException ex) {
                    if (ex.errorValue.tag == DbxFiles.ListFolderContinueError.Tag.path) {
                        if (checkPathError(response, path, ex.errorValue.getPath())) return;
                    }
                    throw ex;
                }
            }
        }
        catch (DbxException ex) {
            common.handleDbxException(response, user, ex, "listFolder(" + jq(path) + ")");
            return;
        }

        FormProtection fp = FormProtection.start(response);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = new PrintWriter(IOUtil.utf8Writer(response.getOutputStream()));

        out.println("<html>");
        out.println("<head><title>" + escapeHtml4(path) + "- Web File Browser</title></head>");
        out.println("<body>");
        fp.insertAntiRedressHtml(out);

        out.println("<h2>Path: " + escapeHtml4(path) + "</h2>");

        // Upload form
        out.println("<form action='/upload' method='post' enctype='multipart/form-data'>");
        fp.insertAntiCsrfFormField(out);
        out.println("<label for='file'>Upload file:</label> <input name='file' type='file'/>");
        out.println("<input type='submit' value='Upload'/>");
        out.println("<input name='targetFolder' type='hidden' value='" + escapeHtml4(path) + "'/>");
        out.println("</form>");
        // Listing of folder contents.
        out.println("<ul>");
        for (DbxFiles.Metadata child : children.values()) {
            String href = "/browse?path=" + DbxRequestUtil.encodeUrlParam(child.pathLower);
            out.println("  <li><a href='" + escapeHtml4(href) + "'>" + escapeHtml4(child.name) + "</a></li>");
        }
        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");

        out.flush();
    }

    private void renderFile(HttpServletResponse response, String path, DbxFiles.FileMetadata f)
        throws IOException
    {
        FormProtection fp = FormProtection.start(response);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = new PrintWriter(IOUtil.utf8Writer(response.getOutputStream()));

        out.println("<html>");
        out.println("<head><title>" + escapeHtml4(path) + "- Web File Browser</title></head>");
        out.println("<body>");
        fp.insertAntiRedressHtml(out);

        out.println("<h2>Path: " + escapeHtml4(path) + "</h2>");

        out.println("<pre>");
        out.print(escapeHtml4(f.toStringMultiline()));
        out.println("</pre>");

        out.println("</body>");
        out.println("</html>");

        out.flush();
    }

    // -------------------------------------------------------------------------------------------
    // GET /browse?path=...
    // -------------------------------------------------------------------------------------------
    // The page that lets you browse your Dropbox account.  Makes Dropbox API calls to figure out
    // the contents of your files and folders and display them to you.

    public void doBrowse(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        if (!common.checkGet(request, response)) return;
        User user = common.getLoggedInUser(request);
        if (user == null) {
            common.pageSoftError(response, "Can't do /browse.  Nobody is logged in.");
            return;
        }

        DbxClientV2 dbxClient = requireDbxClient(request, response, user);
        if (dbxClient == null) return;

        String path = request.getParameter("path");
        if (path == null || path.length() == 0) {
            renderFolder(response, user, dbxClient, "");
        } else {
            String pathError = DbxPathV2.findError(path);
            if (pathError != null) {
                response.sendError(400, "Invalid path: " + jq(path) + ": " + pathError);
                return;
            }
            DbxFiles.Metadata metadata;
            try {
                metadata = dbxClient.files.getMetadata(path);
            }
            catch (DbxFiles.GetMetadataException ex) {
                switch (ex.errorValue.tag) {
                    case path:
                        DbxFiles.LookupError le = ex.errorValue.getPath();
                        switch (le.tag) {
                            case notFound:
                                response.sendError(400, "Path doesn't exist on Dropbox: " + jq(path));
                                return;
                        }
                }
                common.handleException(response, ex, "getMetadata(" + jq(path) + ")");
                return;
            }
            catch (DbxException ex) {
                common.handleDbxException(response, user, ex, "getMetadata(" + jq(path) + ")");
                return;
            }

            path = DbxPathV2.getParent(path) + "/" + metadata.name;
            if (metadata instanceof DbxFiles.FolderMetadata) {
                renderFolder(response, user, dbxClient, path);
            }
            else {
                renderFile(response, path, (DbxFiles.FileMetadata) metadata);
            }
        }
    }

    // -------------------------------------------------------------------------------------------
    // POST /upload
    // -------------------------------------------------------------------------------------------

    public void doUpload(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        if (!common.checkPost(request, response)) return;
        User user = common.requireLoggedInUser(request, response);
        if (user == null) return;

        DbxClientV2 dbxClient = requireDbxClient(request, response, user);
        if (dbxClient == null) return;

        try {
            request.getParts();  // Just call getParts() to trigger the too-large exception.
        }
        catch (IllegalStateException ex) {
            response.sendError(400, "Request too large");
            return;
        }

        String targetFolder = slurpUtf8Part(request, response, "targetFolder", 1024);
        if (targetFolder == null) return;

        Part filePart = request.getPart("file");
        if (filePart == null) {
            response.sendError(400, "Field \"file\" is missing.");
            return;
        }
        String fileName = filePart.getName();
        if (fileName == null) {
            response.sendError(400, "Field \"file\" has no name.");
            return;
        }

        // Upload file to Dropbox
        String fullTargetPath = targetFolder + "/" + fileName;
        DbxFiles.FileMetadata metadata;
        try {
            metadata = dbxClient.files.uploadBuilder(fullTargetPath).run(filePart.getInputStream());
        }
        catch (DbxException ex) {
            common.handleDbxException(response, user, ex, "upload(" + jq(fullTargetPath) + ", ...)");
            return;
        }
        catch (IOException ex) {
            response.sendError(400, "Error getting file data from you.");
            return;
        }

        // Display uploaded file metadata.
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));

        out.println("<html>");
        out.println("<head><title>File uploaded: " + escapeHtml4(metadata.pathLower) + "</title></head>");
        out.println("<body>");
        out.println("<h2>File uploaded: " + escapeHtml4(metadata.pathLower) + "</h2>");
        out.println("<pre>");
        out.print(escapeHtml4(metadata.toStringMultiline()));
        out.println("</pre>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
    }

    /**
     * Reads in a single field of a multipart/form-data request.  If the field is not present
     * or the field is longer than maxLength, we'll use the given HttpServletResponse to respond
     * with an error and then return null.
     *
     * Otherwise, process it as UTF-8 bytes and return the equivalent String.
     */
    private static String slurpUtf8Part(HttpServletRequest request, HttpServletResponse response, String name, int maxLength)
            throws IOException, ServletException
    {
        Part part = request.getPart(name);
        if (part == null) {
            response.sendError(400, "Form field " + jq(name) + " is missing");
            return null;
        }

        byte[] bytes = new byte[maxLength];
        InputStream in = part.getInputStream();
        int bytesRead = in.read(bytes);
        String s = StringUtil.utf8ToString(bytes, 0, bytesRead);
        if (in.read() != -1) {
            response.sendError(400, "Field " + jq(name) + " is too long (the limit is " + maxLength + " bytes): " + jq(s));
            return null;
        }

        // TODO: We're just assuming the content is UTF-8 text.  We should actually check it.
        return s;
    }

}
