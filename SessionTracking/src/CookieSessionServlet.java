import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Saurabh on 4/3/2016.
 */
@WebServlet(name = "CookieSessionServlet", urlPatterns = {"/login"})
public class CookieSessionServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        try {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("pass", pass);
            out.println("Is this a new Session" + session.isNew());
            out.println("<a href='demo'> demo</a>");
            out.println("<a href='logout'> logout</a>");

        } catch (Exception e) {
        }

    }
}
