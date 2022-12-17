package servlets;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

public class Task3 extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String URL = "jdbc:mysql://localhost:3300/Lab10?user=root&password=Apahar33";
        String param = req.getParameter("param");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connected Successfully");

            CallableStatement cStmt = conn.prepareCall("call CountUsersByRole(?,?)");
            cStmt.setString(1, param);
            cStmt.registerOutParameter(2, Types.INTEGER);

            PrintWriter out = resp.getWriter();
            cStmt.execute();
            out.println("Number of people: " + cStmt.getInt(2));
        } catch (Exception e) {
            System.out.println("Connection error");
            e.printStackTrace();
        }
    }
}