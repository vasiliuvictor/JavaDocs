package ro.teamnet.zth.appl.Controllers;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Andrei.Vasiliu on 7/20/2017.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {



    @MyRequestMethod(urlPath = "/all", methodType = "GET")

    public String getAllEmployees(){

        return "allEmployees";

    }

    public String getOneEmployee(){
        return "oneEmployee";
    }
}
