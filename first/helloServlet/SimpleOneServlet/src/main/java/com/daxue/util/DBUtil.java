package com.daxue.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author daxue0929
 * @date 2023/7/23
 */

public class DBUtil {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:13306/cloud_project?useSSL=false";
    static String username = "root";
    static String password = "idaas_toa";

    public static Connection getCollection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("mysql create connection success!");
        return connection;
    }

}
