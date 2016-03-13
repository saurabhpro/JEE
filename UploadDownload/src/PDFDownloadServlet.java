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
 */
@WebServlet(name = "PDFDownloadServlet", urlPatterns = {"/pdf"})
public class PDFDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fName = "pdfFile2.pdf";
        ServletOutputStream stream = null;
        BufferedInputStream buff = null;

        stream = response.getOutputStream();
        String s1 = getServletContext().getRealPath("/files/pdfFile.pdf");
        File doc = new File(s1);

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + fName);
        response.setContentLength((int) doc.length());

        FileInputStream fin = new FileInputStream(doc);
        buff = new BufferedInputStream(fin);

        int readBytes = 0;
        while ((readBytes = buff.read()) != -1)
            stream.write(readBytes);

    }
}
