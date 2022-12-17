import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SecondServlet extends HttpServlet implements Servlet {
    static String SqlNumberRows = "{? = call filter_by_title(?)}";
    protected static String url = "jdbc:mysql://localhost:3300/Lab10?user=root&password=Apahar33";

    protected void doGet(HttpServletRequest rq,
            HttpServletResponse rs)
            throws ServletException, IOException {
        rs.setCharacterEncoding("CP1251");
        PrintWriter pw = rs.getWriter();
        String title = rq.getParameter("title");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, "root", "Apahar33");
            CallableStatement statement = connection.prepareCall(SqlNumberRows);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, title);
            statement.execute();
            Integer numberRows = statement.getInt(1);
            pw.println("Number of rows with title " + title + " is " + numberRows);
            connection.close();
        } catch (SQLException e) {
            pw.println("<div>" + e.getSQLState() + " " + e.getMessage() + "</div>");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
