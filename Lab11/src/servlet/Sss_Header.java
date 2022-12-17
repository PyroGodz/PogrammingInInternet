package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sss_Header extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    public Sss_Header() {
        super();
        System.out.println("Sss_Header:init");
    }
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss_Header:doGet");
        System.out.println(rq.getHeader("Value-X"));
        System.out.println(rq.getHeader("Value-Y"));
        Float x = new Float(rq.getHeader("Value-X"));
        Float y = new Float(rq.getHeader("Value-Y"));
        Float z = x + y;
        System.out.println(z.toString());
        rs.setHeader("Value-Z", z.toString());
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss_Header:doPost");
        System.out.println(rq.getHeader("Value-X"));
        System.out.println(rq.getHeader("Value-Y"));
        Float x = new Float(rq.getHeader("Value-X"));
        Float y = new Float(rq.getHeader("Value-Y"));
        Float z = x + y;
        System.out.println(z.toString());
        rs.setHeader("Value-Z", z.toString());
    }
}
