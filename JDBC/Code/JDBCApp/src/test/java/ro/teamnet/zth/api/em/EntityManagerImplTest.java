package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrei.Vasiliu on 7/13/2017.
 */
public class EntityManagerImplTest {
    @Test
    public void testFindById(){
        EntityManagerImpl manager = new EntityManagerImpl();
        try {
            Department d = manager.findById(Department.class, 70l);
            Assert.assertNotNull("shouldn't be null",d);
            assertEquals("Departament diferit","Public Relations",d.getDepartmentName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testGetNextIdVal() throws SQLException, ClassNotFoundException {
        EntityManagerImpl manager = new EntityManagerImpl();
        long id = manager.getNextIdVal("locations", "location_id");

        Assert.assertNotEquals("Shouldn't be -1!", -1, id);
        assertEquals("Id different than expected!", 3201L, id);
    }

    @Test
    public void testInsert() {
        EntityManagerImpl manager = new EntityManagerImpl();
        Department d = new Department();
        d.setDepartmentName("Telecommunication");
        d.setLocation(1000L);
        Department result = (Department) manager.insert(d);


        assertEquals("Department name different than expected!", "Telecommunication", result.getDepartmentName());


    }

    @Test
    public void findAllTest()throws Exception
    {
        EntityManagerImpl entityManager = new EntityManagerImpl();
        List<Department> departments = entityManager.findAll(Department.class);

        assertEquals("List size should be 28",28,departments.size());
    }

    @Test
    public void testUpdate() throws Exception {
        EntityManagerImpl manager = new EntityManagerImpl();
        Department d = new Department();
        d.setDepartmentName("Steaua");
        d.setId(160L);
        d.setLocation((long)1700);

        Department result = manager.update(d);
        assertEquals("Department diferit","Steaua",result.getDepartmentName());


    }

    @Test
    public void testDelete() throws Exception {
        EntityManagerImpl manager = new EntityManagerImpl();
        Department d = new Department();

        d.setId(110L);
        d.setLocation((long)1700);


        manager.delete(d);


    }

    @Test
    public void findByParamsTest() throws Exception {
        EntityManagerImpl em = new EntityManagerImpl();
        Map<String,Object> params = new HashMap<>();
        params.put("Location_id",1700L);
        params.put("Department_name","IT Support");
        List<Department> result = em.findByParams(Department.class,params);

        assertEquals(1,result.size());
    }

    @Test
    public void findEmployeesTest() throws Exception {
        EntityManagerImpl entityManager= new EntityManagerImpl();
        List<Employee> result =entityManager.findEmployees("es");
        assertEquals(35,result.size());
    }
}
