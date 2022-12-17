import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServletS extends HttpServlet implements Servlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws IOException {
        rs.setCharacterEncoding("CP1251");
        System.out.println("Servlet:ServletS");
        String dir = rq.getServletContext().getInitParameter("doc-dir");
        File file = new File(dir + "/" + rq.getParameter("file"));
        OutputDoc(file, rs);
    }

    protected void OutputDoc(File doc, HttpServletResponse rs)
            throws IOException {
        rs.setContentType("application/msword");
        rs.addHeader("Content-Disposition", "attachment; filename=" +
                doc.getName());
        rs.setContentLength((int) doc.length());
        Logger logger = Logger.getLogger(ServletS.class.getName());
        logger.addHandler(new FileHandler("D:\\study\\Java\\lab13\\debug.txt"));

        logger.log(Level.INFO, doc.getName());

        FileInputStream in = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(in);
        ServletOutputStream out = rs.getOutputStream();
        int readBytes = 0;
        while ((readBytes = buf.read()) != -1)
            out.write(readBytes);
    }
}
