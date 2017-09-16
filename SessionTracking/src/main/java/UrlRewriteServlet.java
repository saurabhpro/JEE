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
@WebServlet(name = "UrlRewriteServlet", urlPatterns = {"/urls"})
public class UrlRewriteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		try {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("pass", pass);

			out.println("Session is new " + session.isNew());
			String url = response.encodeURL("demo");
			String url1 = response.encodeURL("logout");

			out.println(url);
			out.println("<a href=" + url + ">demo</a>");
		} catch (Exception ignored) {
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
