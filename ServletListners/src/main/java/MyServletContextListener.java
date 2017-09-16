import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Saurabh on 4/3/2016.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
	private Connection connection;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			ServletContext context = servletContextEvent.getServletContext();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
			context.setAttribute("connection", connection);
			System.out.println("Context Created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
