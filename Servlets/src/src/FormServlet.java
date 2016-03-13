import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Saurabh on 2/21/2016.
 */

@WebServlet("/login")
public class FormServlet extends HttpServlet {
	/*
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uName = request.getParameter("name");
        String uPassword = request.getParameter("pass");

        if (uName.equals("Saurabh") && uPassword.equals("98989"))
            out.println("User is valid through Service method");
        else
            out.println("User is invalid through Service method");
    }*/

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String method = request.getMethod();
        out.println("method is" + method);
        if (method.equals("GET"))
            doGet(request, response);
        else
            doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        try {
          //  Class.forName("oracle.jdbc.driver.OracleDriver");
            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
            Statement st = con.createStatement();

            st.executeUpdate("CREATE TABLE EmpService (eid INTEGER , name VARCHAR2(25), password VARCHAR2(40) )");
            st.executeUpdate("INSERT INTO EmpService VALUES (55,'ram','test')");
            st.executeUpdate("INSERT INTO EmpService VALUES (58,'" + name + "','" + pass + "')");

            ResultSet rs = st.executeQuery("SELECT * FROM EmpService");
            ResultSetMetaData rsmd = rs.getMetaData();

            int column = rsmd.getColumnCount();

            out.println("<table bgcolor='yellow' border='1' width=200>");
            out.println("<tr>");
            for (int i = 0; i < column; i++) {
                out.println("<th>" + rsmd.getColumnClassName(i) + "</th>");
            }

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (name.equals("saurabh") && pass.equals("98989")) out.println("User is post valid");
        else out.println("user is post invalid");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name.equals("saurabh") && pass.equals("98989")) out.println("User is get valid");
        else out.println("user is get invalid");
    }
}
