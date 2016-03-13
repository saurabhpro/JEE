import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "RefreshServlet", urlPatterns = {"/refresh"})
public class RefreshServlet extends HttpServlet {

    static int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setHeader("Refresh", "2");
        out.println(new Date().toString() + " Times " + count++);
    }
}
