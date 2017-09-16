package upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "upload.UploadViaAnnotationServlet", urlPatterns = {"/anUpload"})
@MultipartConfig(location = "/JEE/UploadDownload", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadViaAnnotationServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("file");

		Part part = request.getPart("content");
		part.write(fileName + ".txt");
		if (request.getPart("content") != null) {
			PrintWriter out = response.getWriter();
			out.write("<h3> File Uploaded Successfully</h3>");
		}
	}

}
