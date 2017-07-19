package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Andrei.Vasiliu on 7/19/2017.
 */
public class HeadersLogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

//        PrintWriter out = resp.getWriter();
//        resp.setContentType("text/plain");


            while (headerNames.hasMoreElements()){
                String headerName = headerNames.nextElement();
                String headerValue = httpRequest.getHeader(headerName);
                LogFileWriter.logHeader(headerName,headerValue);
            }


        chain.doFilter(httpRequest, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }


}
