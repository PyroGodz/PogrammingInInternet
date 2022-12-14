package servlet;
import javaclass.XXRand;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sss_JSON extends javax.servlet.http.HttpServlet
        implements javax.servlet.Servlet {

    public Sss_JSON() {
        super();
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss_JSON:doPost");
        Integer n = new Integer(rq.getHeader("XRand-N"));
        System.out.println(n);
        XXRand num = new XXRand(n);
        rs.setContentType("application/json");
        PrintWriter w = rs.getWriter();
        String s = "{\"X\":[";
        for (int i = 0; i < 10; i++) {
            s += ("{\"rand\":" + num.Get().toString() + "}" +
                    ((i < 9) ? "," : " "));
        }
        s += "]}";
        System.out.println(s);
        w.println(s);
    }
}

