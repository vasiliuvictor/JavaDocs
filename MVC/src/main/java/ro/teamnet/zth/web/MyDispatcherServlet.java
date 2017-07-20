package ro.teamnet.zth.web;

import ro.teamnet.zth.appl.Controllers.DepartmentController;
import ro.teamnet.zth.appl.Controllers.EmployeeController;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrei.Vasiliu on 7/20/2017.
 */
@WebServlet(name = "MyDispatcherServlet")
public class MyDispatcherServlet extends HttpServlet {
    Map<String, MethodAttributes> map = new HashMap<String, MethodAttributes>();

    public void init() {

        EmployeeController ec = new EmployeeController();
        DepartmentController dc = new DepartmentController();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodType = "POST";
        dispatchReply(request, response, methodType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodType = "GET";

        dispatchReply(request, response, methodType);
    }

    protected void dispatchReply(HttpServletRequest req, HttpServletResponse resp, String methodType) {
        try {
            Object resultToDisplay = dispatch(req, methodType);
            reply(resp, resultToDisplay);


        } catch (Exception e) {
            sendExceptionError(e);
        }
    }

    public void sendExceptionError(Exception e) {
        System.out.println(e.toString());
    }

    private Object dispatch(HttpServletRequest req, String methodType) {

        StringBuffer url = req.getRequestURL();
        String result = "Test";
        if (url.toString().contains("employees")) {
            if (url.toString().contains("all")) {
                EmployeeController ec = new EmployeeController();
                result = ec.getAllEmployees();
            }
            if (url.toString().contains("one")) {
                EmployeeController ec = new EmployeeController();
                result = ec.getOneEmployee();
            }
        } else if (url.toString().contains("departments")) {
            if (url.toString().contains("all")) {
                DepartmentController dc = new DepartmentController();
                result = dc.getAllDepartments();
            }
        }
        return result;

    }

    private void reply(HttpServletResponse resp, Object obj) throws IOException {
        resp.getWriter().write("reply" + obj);
    }
}

