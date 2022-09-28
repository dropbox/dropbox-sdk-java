package com.dropbox.core.examples.web_file_browser;

import static com.dropbox.core.util.StringUtil.jq;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxPathV2;
import com.dropbox.core.v2.files.DeletedMetadata;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.GetMetadataErrorException;
import com.dropbox.core.v2.files.ListFolderContinueErrorException;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.LookupError;
import com.dropbox.core.v2.files.Metadata;

import javax.servlet.MultipartConfigElement;
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
                               common.dbxAppInfo.getHost());
    }

    private boolean checkPathError(HttpServletResponse response, String path, LookupError le)
        throws IOException
    {
        switch (le.tag()) {
            case NOT_FOUND:
            case NOT_FOLDER:
                response.sendError(400, "Path doesn't exist on Dropbox: " + jq(path));
                return true;
        }
        return false;
    }

    private void renderFolder(HttpServletResponse response, User user, DbxClientV2 dbxClient, String path)
        throws IOException
    {
        // Get the folder listing from Dropbox.
        TreeMap<String,Metadata> children = new TreeMap<String,Metadata>();

        ListFolderResult result;
        try {
            try {
                result = dbxClient.files()
                    .listFolder(path);
            }
            catch (ListFolderErrorException ex) {
                if (ex.errorValue.isPath()) {
                    if (checkPathError(response, path, ex.errorValue.getPathValue())) return;
                }
                throw ex;
            }

            while (true) {
                for (Metadata md : result.getEntries()) {
                    if (md instanceof DeletedMetadata) {
                        children.remove(md.getPathLower());
                    } else {
                        children.put(md.getPathLower(), md);
                    }
                }

                if (!result.getHasMore()) break;

                try {
                    result = dbxClient.files()
                        .listFolderContinue(result.getCursor());
                }
                catch (ListFolderContinueErrorException ex) {
                    if (ex.errorValue.isPath()) {
                        if (checkPathError(response, path, ex.errorValue.getPathValue())) return;
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
        for (Metadata child : children.values()) {
            String href = "/browse?path=" + DbxRequestUtil.encodeUrlParam(child.getPathLower());
            out.println("  <li><a href='" + escapeHtml4(href) + "'>" + escapeHtml4(child.getName()) + "</a></li>");
        }
        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");

        out.flush();
    }

    private void renderFile(HttpServletResponse response, String path, FileMetadata f)
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
            Metadata metadata;
            try {
                metadata = dbxClient.files()
                    .getMetadata(path);
            }
            catch (GetMetadataErrorException ex) {
                if (ex.errorValue.isPath()) {
                    LookupError le = ex.errorValue.getPathValue();
                    if (le.isNotFound()) {
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

            path = DbxPathV2.getParent(path) + "/" + metadata.getName();
            if (metadata instanceof FolderMetadata) {
                renderFolder(response, user, dbxClient, path);
            }
            else {
                renderFile(response, path, (FileMetadata) metadata);
            }
        }
    }

    // -------------------------------------------------------------------------------------------
    // POST /upload
    // -------------------------------------------------------------------------------------------

    public void doUpload(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
        request.setAttribute("org.eclipse.multipartConfig", multipartConfigElement);
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
        FileMetadata metadata;
        try {
            metadata = dbxClient.files()
                .upload(fullTargetPath)
                .uploadAndFinish(filePart.getInputStream());
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
        out.println("<head><title>File uploaded: " + escapeHtml4(metadata.getPathLower()) + "</title></head>");
        out.println("<body>");
        out.println("<h2>File uploaded: " + escapeHtml4(metadata.getPathLower()) + "</h2>");
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

        if (bytesRead == -1) {
            return "";
        }

        String s = StringUtil.utf8ToString(bytes, 0, bytesRead);

        if (in.read() != -1) {
            response.sendError(400, "Field " + jq(name) + " is too long (the limit is " + maxLength + " bytes): " + jq(s));
            return null;
        }

        // TODO: We're just assuming the content is UTF-8 text.  We should actually check it.
        return s;
    }

}
