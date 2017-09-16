import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Saurabh on 4/3/2016.
 */
@WebServlet(name = "ServletContextListenerServlet", urlPatterns = {"/clistener"})
public class ServletContextListenerServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletContext servletContext = getServletContext();
		Connection connection = (Connection) servletContext.getAttribute("connection");
		out.println("Connection Received <br>");
		try {
			Statement statement = connection.createStatement();

        /* Run only once to create table
            statement.executeUpdate("CREATE TABLE EmpService (eid INTEGER , name VARCHAR2(25), password VARCHAR2(40) )");
            statement.executeUpdate("INSERT INTO EmpService VALUES (55,'ram','test')");
            statement.executeUpdate("INSERT INTO EmpService VALUES (56,'sam','test')");
        */

			ResultSet resultSet = statement.executeQuery("SELECT * FROM EmpService");
			while (resultSet.next()) {
				out.println("<br>id : " + resultSet.getString(1) + " , Name: " + resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
