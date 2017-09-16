import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "RequestDispatchServlet", urlPatterns = {"/RDServlet"})
public class RequestDispatchServlet extends HttpServlet {


	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		req.setAttribute("name", "ducat");

		String name = req.getParameter("name");
		String pass = req.getParameter("pass");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "98989");

			Statement s = conn.createStatement();
			String s1 = "select * from ducat WHERE username ='" + name + "' AND password='" + pass + "'";

			ResultSet rs = s.executeQuery(s1);

			out.println("before dispatch");

			if (rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("/wel");
				//rd.include(req,res);
				rd.forward(req, res);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/err");
				rd.include(req, res);
				//rd.forward(req,res);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		out.println("after request dispatch");
	}
}
