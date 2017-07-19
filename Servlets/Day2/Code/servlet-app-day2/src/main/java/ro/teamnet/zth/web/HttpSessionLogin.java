package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Andrei.Vasiliu on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            HttpSession session = (HttpSession) request.getSession();

            if(user.equals("admin")&&pass.equals("admin")){
                response.getWriter().write("Welcome back "+user + "The Session id is: ");
                response.getWriter().write(request.getSession().getId());
            }
            else{
                session.setAttribute("session",session);
                session.setAttribute("user",user);
                RequestDispatcher requestDispatcher =
                        request.getRequestDispatcher("/views/loginFail.jsp");
                requestDispatcher.forward(request, response);

            }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
