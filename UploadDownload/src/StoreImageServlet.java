import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Saurabh on 3/13/2016.
 * CREATE TABLE image16 (id VARCHAR2(10), image BLOB);
 */
@WebServlet(name = "StoreImageServlet", urlPatterns = {"/storeimg"})
public class StoreImageServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String path = getServletContext().getRealPath("/image");

        MultipartRequest mpr = new MultipartRequest(req, path, 1024 * 1024 * 5);

        String path1 = mpr.getOriginalFileName("file"); // file is the req parameter name
        String path2 = path + "/" + path1;

        FileInputStream fin = new FileInputStream(path2);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "98989");

            PreparedStatement ps = conn.prepareStatement("INSERT INTO image16 VALUES (?,?)");
            ps.setBinaryStream(2, fin, fin.available());
            ps.setString(1, "11");
            ps.executeUpdate();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        out.println("Image was Uploaded successfully");

    }
}