package upload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "upload.FileInputStreamServlet", urlPatterns = {"/finUpload"})
public class FileInputStreamServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ServletInputStream in = request.getInputStream();
		ServletOutputStream out = response.getOutputStream();

		FileOutputStream fout = new FileOutputStream("/UploadDownload/uploadedfile.txt");
		int i = 0;

		while ((i = in.read()) != -1)
			fout.write(i);
	}

}
