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
@WebServlet(name = "HiddenFormFeildServlet", urlPatterns = {"/hiddenform"})
public class HiddenFormFeildServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        try {
            HttpSession session = request.getSession();
            String id = session.getId();
            out.println(id);

            session.setAttribute("name", name);
            session.setAttribute("pass", pass);

            out.println("<form action='demo' method='get'>");
            out.println("<input type='hidden' name ='jsessonid' value=" + id + ">");
            out.println("<input type='text' name='uname'>");
            out.println("<input type='submit'");
            out.println("</form>");

        } catch (Exception e) {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
