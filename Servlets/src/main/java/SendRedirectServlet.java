import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Saurabh on 3/13/2016.
 * CREATE TABLE ducat (name VARCHAR2(20) PRIMARY KEY , username VARCHAR2(10), password VARCHAR2(10), message VARCHAR2(40));
 * INSERT INTO ducat VALUES ('saurabh', 'saurabh','saurabh','no message');
 * INSERT INTO ducat VALUES ('ducat', 'ducat', 'ducat','no message');
 * java only shows values entered through java code, not outer modification like by sql plus
 */
public class SendRedirectServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("before");

		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "98989");

			Statement s = conn.createStatement();
			String s0 = "INSERT INTO ducat VALUES ('saurabh1', 'saurabh','saurabh','no message')";
			String s1 = "select * from ducat WHERE username ='" + name + "' AND password='" + pass + "'";
			s.executeUpdate(s0);
			ResultSet rs = s.executeQuery(s1);
			if (rs.next()) {
				res.sendRedirect("wel");
			} else {
				res.sendRedirect("err");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		out.println("after");
	}
}
