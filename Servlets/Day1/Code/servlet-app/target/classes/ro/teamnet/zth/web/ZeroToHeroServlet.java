package ro.teamnet.zth.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Andrei.Vasiliu on 7/18/2017.
 */
public class ZeroToHeroServlet extends HttpServlet {

    protected String handleRequest(HttpServletRequest req){
        String response ;
        response ="Hello " +req.getParameter("firstName")+ " "+req.getParameter("lastName") +"</b>! Enjoy Zero To Hero!!!";
        return response;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        pw.write("The value is " + handleRequest(request));


    }



}
