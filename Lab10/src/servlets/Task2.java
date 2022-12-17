package servlets;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

public class Task2 extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String URL = "jdbc:mysql://localhost:3300/Lab10?user=root&password=Apahar33";
        String param = req.getParameter("param");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connected Successfully");

            PreparedStatement prStmt = conn.prepareStatement("SELECT * FROM users where role LIKE ?");
            prStmt.setString(1, param);
            ResultSet rs = prStmt.executeQuery();

            PrintWriter out = resp.getWriter();
            while (rs.next()) {
                out.println(
                        "id: " + rs.getString("id") +
                                ", username: " + rs.getString("username") +
                                ", email: " + rs.getString("email") +
                                ", role: " + rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println("Connection error");
            e.printStackTrace();
        }
    }
}