package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Andrei.Vasiliu on 7/13/2017.
 */
public class DBManager {
    private DBManager() throws UnsupportedOperationException{}
    private  static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT+":xe";

    private static void registerDriver() throws ClassNotFoundException {
        Class.forName(DBProperties.DRIVER_CLASS);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        registerDriver();
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,DBProperties.USER,DBProperties.PASS);
        return  conn;

    }
    static boolean checkConnection(Connection connection) throws SQLException {
        String SQL = "Select 1 FROM DUAL";
        Statement stm = connection.createStatement();
        ResultSet result = stm.executeQuery(SQL);
        if(result.next())
            return true;
            else
                return false;

    }
}
