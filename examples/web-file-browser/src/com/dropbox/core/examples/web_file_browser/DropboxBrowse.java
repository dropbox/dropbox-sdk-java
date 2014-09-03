package com.dropbox.core.examples.web_file_browser;

import static com.dropbox.core.util.StringUtil.jq;
import static com.dropbox.core.util.StringUtil.UTF8;

import com.dropbox.core.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    private DbxClient requireDbxClient(HttpServletRequest request, HttpServletResponse response, User user)
            throws IOException, ServletException
    {
        if (user.dropboxAccessToken == null) {
            common.pageSoftError(response, "This page requires a user whose has linked to their Dropbox account.  Current user hasn't linked us to their Dropbox account.");
            return null;
        }

        return new DbxClient(common.getRequestConfig(request),
                             user.dropboxAccessToken,
                             common.dbxAppInfo.host);
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

        DbxClient dbxClient = requireDbxClient(request, response, user);
        if (dbxClient == null) return;

        // Make sure the path starts with '/'.  There are probably other checks we can perform...
        String path = request.getParameter("path");
        if (path == null) {
            path = "/";
        } else {
            String pathError = DbxPath.findError(path);
            if (pathError != null) {
                response.sendError(400, "Invalid path: " + jq(path) + ": " + pathError);
                return;
            }
        }

        // Get the folder listing from Dropbox.
        DbxEntry.WithChildren listing;
        try {
            listing = dbxClient.getMetadataWithChildren(path);
        }
        catch (DbxException ex) {
            common.handleDbxException(response, user, ex, "getMetadataWithChildren(" + jq(path) + ")");
            return;
        }

        if (listing == null) {
            response.sendError(400, "Path doesn't exist on Dropbox: " + jq(path));
        }

        FormProtection fp = FormProtection.start(response);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), UTF8));

        out.println("<html>");
        out.println("<head><title>" + escapeHtml4(path) + "- Web File Browser</title></head>");
        out.println("<body>");
        fp.insertAntiRedressHtml(out);

        out.println("<h2>Path: " + escapeHtml4(path) + "</h2>");

        if (listing == null) {
            out.println("<p>Nothing here...</p>");
        }
        // Folder
        else if (listing.entry instanceof DbxEntry.Folder) {
            // Upload form
            out.println("<form action='/upload' method='post' enctype='multipart/form-data'>");
            fp.insertAntiCsrfFormField(out);
            out.println("<label for='file'>Upload file:</label> <input name='file' type='file'/>");
            out.println("<input type='submit' value='Upload'/>");
            out.println("<input name='targetFolder' type='hidden' value='" + escapeHtml4(listing.entry.path) + "'/>");
            out.println("</form>");
            // Listing of folder contents.
            out.println("<ul>");
            for (DbxEntry child : listing.children) {
                String href = "/browse?path=" + DbxRequestUtil.encodeUrlParam(child.path);
                out.println("  <li><a href='" + escapeHtml4(href) + "'>" + escapeHtml4(child.name) + "</a></li>");
            }
            out.println("</ul>");
        }
        // File
        else {
            DbxEntry.File f = (DbxEntry.File) listing.entry;
            out.println("<pre>");
            out.print(escapeHtml4(f.toStringMultiline()));
            out.println("</pre>");
        }

        out.println("</body>");
        out.println("</html>");

        out.flush();
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

        DbxClient dbxClient = requireDbxClient(request, response, user);
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
        DbxEntry.File metadata;
        try {
            metadata = dbxClient.uploadFile(fullTargetPath, DbxWriteMode.add(), filePart.getSize(), filePart.getInputStream());
        }
        catch (DbxException ex) {
            common.handleDbxException(response, user, ex, "uploadFile(" + jq(fullTargetPath) + ", ...)");
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
        out.println("<head><title>File uploaded: " + escapeHtml4(metadata.path) + "</title></head>");
        out.println("<body>");
        out.println("<h2>File uploaded: " + escapeHtml4(metadata.path) + "</h2>");
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
        String s = new String(bytes, 0, bytesRead, UTF8);
        if (in.read() != -1) {
            response.sendError(400, "Field " + jq(name) + " is too long (the limit is " + maxLength + " bytes): " + jq(s));
            return null;
        }

        // TODO: We're just assuming the content is UTF-8 text.  We should actually check it.
        return s;
    }

}
