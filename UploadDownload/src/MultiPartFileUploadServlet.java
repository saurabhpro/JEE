import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "MultiPartFileUploadServlet", urlPatterns = {"/upload"})
public class MultiPartFileUploadServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String path = getServletContext().getRealPath("/files/");

        out.println(path + "<br>");

        MultipartRequest multipartRequest = new MultipartRequest(req, path, 500 * 1024 * 1024);
        String s1 = multipartRequest.getOriginalFileName("file");

        out.println("File uploaded Successfully" + s1);
    }
}
