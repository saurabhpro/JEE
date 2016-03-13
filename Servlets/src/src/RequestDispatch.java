

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatch
 */
@WebServlet("/RequestDispatch")
public class RequestDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatch() {
        super();
        // TODO Auto-generated constructor stub
    }
    
public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		request.setAttribute("name", "ducat");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		try{
		/*	Class.forName("oracle.jdbc.driver.OracleDriver");
			java.sql.Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","98989");
			Statement s = c.createStatement();
			String sql = "select * from emp where name='"+name+"'";
			ResultSet rs = s.executeQuery(sql);
			out.println("before dipatcher");
			
			request.setAttribute("name", "ducat");
			out.println("<br>");
		*/	if(name.equals("saurabh")){
				RequestDispatcher rd = request.getRequestDispatcher("/Welcome");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Error");
				rd.forward(request, response);
			}
			
			}catch(Exception e){
				out.println("Exception aya");
			}
		
		out.println("After Request Dispatcher");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
