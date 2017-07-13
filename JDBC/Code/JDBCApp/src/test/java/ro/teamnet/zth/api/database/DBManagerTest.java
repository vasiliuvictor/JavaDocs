package ro.teamnet.zth.api.database;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Andrei.Vasiliu on 7/13/2017.
 */
public class DBManagerTest {

    @Test
    public void testCheckConnection() throws Exception {
        assertEquals(true,DBManager.checkConnection(DBManager.getConnection()));
    }
}
