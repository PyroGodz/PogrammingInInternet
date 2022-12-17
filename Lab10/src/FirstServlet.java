import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class FirstServlet extends HttpServlet implements Servlet {
    /*
     * protected static String SqlSelectRecipes = "select title,"
     * + "timeOfCooking, calories from Recipes";
     */
    protected static String url = "jdbc:mysql://localhost:3300/Lab10?user=root&password=Apahar33";

    protected static String SqlSelectRecipes = "select id, title from test where id = ?";

    protected void doGet(HttpServletRequest rq,
            HttpServletResponse rs)
            throws ServletException, IOException {
        rs.setCharacterEncoding("CP1251");
        PrintWriter pw = rs.getWriter();
        String id = rq.getParameter("id");
        if (id == null) {
            id = "1";
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, "root", "Apahar33");

            PreparedStatement statement = connection.prepareStatement(SqlSelectRecipes);
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            pw.println("<table>");
            pw.println("<tr><th>Id</th><th>Title</th></tr>");
            while (resultSet.next()) {
                pw.println("<tr><td>" + resultSet.getString("id") + "</td><td>" + resultSet.getString("title")
                        + "</td></tr>");
            }
            pw.println("</table>");
            connection.close();
        } catch (SQLException e) {
            pw.println("<div>" + e.getSQLState() + " " + e.getMessage() + "</div>");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
