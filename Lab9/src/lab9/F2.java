package lab9;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class F2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("F2: init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getParameter("value1").equals("1")) {
            System.out.println("F2: doFilter");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            PrintWriter out = servletResponse.getWriter();
            out.println("F2: Access Denied");
        }
    }

    @Override
    public void destroy() {
        System.out.println("F2: destroy");
    }
}