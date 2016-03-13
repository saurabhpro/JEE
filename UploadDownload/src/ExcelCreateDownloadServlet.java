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
@WebServlet(name = "ExcelCreateDownloadServlet",urlPatterns = {"/excel"})
public class ExcelCreateDownloadServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        PrintWriter out = response.getWriter();
        out.println("Names\tHindi\tEnglish\tMath\tTotal");
        //each println is a row in excel
        out.println("Ram\t76\t93\t92\t88\t=sum(b2:d2)");
    }
}
