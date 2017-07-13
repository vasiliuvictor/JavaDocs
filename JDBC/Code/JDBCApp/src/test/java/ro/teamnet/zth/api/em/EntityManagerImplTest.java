package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;

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

        assertEquals("List size should be 29",29,departments.size());
    }


}
