import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Saurabh on 3/13/2016.
 */
@WebServlet(name = "ShowImageServlet", urlPatterns = {"/showimg"})
public class ShowImageServlet extends HttpServlet {

    InputStream f = null;

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "98989");

            PreparedStatement ps = conn.prepareStatement("SELECT image FROM image16 WHERE id=?");
            ps.setString(1, "11");
            ResultSet rs = ps.executeQuery();

            out.print("Hi");
            String path = getServletContext().getRealPath("/");
            rs.next();
            f = rs.getBinaryStream("image");
            FileOutputStream fileOutputStream = new FileOutputStream(path + "\newImage.jpg");

            int i = 0;

            while ((i = f.read()) != -1)
                fileOutputStream.write(i);

            out.println("<img src = newImage.jpg width='150' height='200'");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        out.println("Image was Downloaded successfully");

    }
}