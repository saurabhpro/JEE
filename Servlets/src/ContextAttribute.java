import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Saurabh on 3/13/2016.
 * Context Attribute dies once we redploy or restart the server, not if we closed one browser
 */
@WebServlet(name = "ContextAttribute", urlPatterns = {"/count"})
public class ContextAttribute extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletContext context = getServletContext();

        Integer count = (Integer) context.getAttribute("count");
        if(count==null)
            count = 0;
        count = count + 1;
        context.setAttribute("count", count);

        out.println("Servlet Hit Count = " + count);
    }
}
