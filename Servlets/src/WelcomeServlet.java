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
@WebServlet(name = "WelcomeServlet", urlPatterns = {"/wel"})
public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("WelcomeServlet Dearie");
    }
}
