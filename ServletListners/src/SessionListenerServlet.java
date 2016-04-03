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
@WebServlet(name = "SessionListenerServlet",urlPatterns = {"/slistener"})
public class SessionListenerServlet extends HttpServlet {
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           response.setContentType("text/html");
           PrintWriter out = response.getWriter();

           HttpSession session = request.getSession();
           String s1 = (String) session.getAttribute("name");
           out.println("Name is "+s1);
           out.println("Is session new : "+session.isNew());
    }
}
