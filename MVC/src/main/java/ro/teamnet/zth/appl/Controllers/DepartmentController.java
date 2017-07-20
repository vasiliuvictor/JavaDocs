package ro.teamnet.zth.appl.Controllers;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Andrei.Vasiliu on 7/20/2017.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {
    String allDepartments = getAllDepartments();

    @MyRequestMethod(urlPath = "/one",methodType = "GET")
    public String getOneDepartment(){
        return "oneDepartment";

    }

    public String getAllDepartments(){
        return "allDepartments";
    }
}
