import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Saurabh on 3/13/2016.
 * downloads at default location of your browser
 */
@WebServlet(name = "ImageDownloadServlet", urlPatterns = {"/img"})
public class ImageDownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fName = "image.jpeg";
        ServletOutputStream stream = null;
        BufferedInputStream buff = null;

        stream = response.getOutputStream();
        String s1 = getServletContext().getRealPath("/files/image.jpg");
        File doc = new File(s1);

        response.setContentType("image/jpeg");
        response.addHeader("Content-Disposition", "attachment; filename=" + fName);
        response.setContentLength((int) doc.length());

        FileInputStream fin = new FileInputStream(doc);
        buff = new BufferedInputStream(fin);

        int readBytes = 0;
        while ((readBytes = buff.read()) != -1)
            stream.write(readBytes);
    }

}
