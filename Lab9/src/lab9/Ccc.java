package lab9;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Ccc extends HttpServlet implements Servlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getResult(req, resp);
    }

    private void getResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String scope = req.getParameter("scope");
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        String value3 = req.getParameter("value3");
        String cBean  = req.getParameter("cBean");

        HttpSession session = req.getSession();
        String sessionId = session.getId();
        lab9.CBean objForSession = new lab9.CBean();
        lab9.CBean objForRequest = new lab9.CBean();

        if(scope != null && scope.equals("session")) {
            if (cBean != null && cBean.equals("new")) {
                objForSession.setValue1(value1);
                objForSession.setValue2(value2);
                objForSession.setValue3(value3);
                session.setAttribute(sessionId, objForSession);
            }
            if (req.getMethod().equals("POST")){
                objForSession.setValue1(value1);
                objForSession.setValue2(value2);
                objForSession.setValue3(value3);
                session.setAttribute(sessionId, objForSession);
            }
            else {
                System.out.println("old session CBean");
            }
        } else if(scope != null && scope.equals("request")) {
            if (cBean != null && cBean.equals("new")) {
                objForRequest.setValue1(value1);
                objForRequest.setValue2(value2);
                objForRequest.setValue3(value3);
                req.setAttribute("atrCBean", objForRequest);
            }
            else {
                System.out.println("old request CBean");
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ccc.jsp");
        requestDispatcher.forward(req, resp);
    }
}