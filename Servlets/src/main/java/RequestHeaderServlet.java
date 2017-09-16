import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "RequestHeaderServlet", urlPatterns = {"/header"})
public class RequestHeaderServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		Enumeration e = req.getHeaderNames();

		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = req.getHeader(name);
			out.println("Value = " + value + "<br>");
			out.println();
		}

		out.println("Protocol " + req.getProtocol());
		//default = get
		out.println("Method " + req.getMethod());
		out.println("URI " + req.getRequestURI());
		//default = null
		out.println("Content Type " + req.getContentType());
		//default = -1
		out.println("Content Length " + req.getContentLength());
	}

}
