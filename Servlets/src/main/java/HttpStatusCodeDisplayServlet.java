import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "HttpStatusCodeDisplayServlet", urlPatterns = {"/httpstatus"})
public class HttpStatusCodeDisplayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(402);
	}
}
