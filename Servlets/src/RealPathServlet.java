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
@WebServlet(name = "RealPathServlet", urlPatterns = {"/realpath"})
public class RealPathServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        if (req.getPathInfo() != null) {
            out.println("The file \"" + req.getPathInfo() + "\"");
            out.println("Is stored at \"" + req.getPathTranslated() + "\"");
        } else {
            out.println("Path info is null, no file to lookup");
        }
    }
}
