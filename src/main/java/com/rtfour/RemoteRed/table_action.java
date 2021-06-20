package com.rtfour.RemoteRed;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class table_action extends conn_establish {
    public static String id_check;
    public static String password_check;

    public static boolean table_checker(String id, String password) throws SQLException {
        final String spec_sym = "$aesc6$";
        //Check if table exists in database.
        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "remote_access", null);
        id_check = id;
        password_check = password;

        if (tables.next()) {
            System.out.println("table exists!");
            if(info_checker()){
                return true;
            }
        } else {
            System.out.println("creating new table!");
            stat.execute("CREATE TABLE remote_access(id_ varchar, password_ varchar)");
            info_checker();
        }
        return false;
    }

    public static boolean info_checker() throws SQLException {
        ResultSet result = stat.executeQuery("SELECT * FROM remote_access WHERE id_ = '" + id_check + "' and password_ = '" + password_check + "'");
        if (result.next()) {
            System.out.println("data found!");
            return true;
        } else {
            System.out.println("data not found!");
        }
        result.close();
        return false;
    }
}
