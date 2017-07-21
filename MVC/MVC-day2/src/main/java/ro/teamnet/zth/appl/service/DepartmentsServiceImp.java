package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;

/**
 * Created by Andrei.Vasiliu on 7/21/2017.
 */
public class DepartmentsServiceImp implements DepartmentService{
    private final DepartmentDao departmentDao = new DepartmentDao();
    @Override
    public List<Department> findAll() {
        return departmentDao.findAllDepartments();
    }

    @Override
    public Department findOne(Long departmentId) {
        return departmentDao.findDepartmentById(departmentId);
    }
}
