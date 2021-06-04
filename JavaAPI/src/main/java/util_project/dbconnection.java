package util_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class dbconnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String filePath = new File("").getAbsolutePath();
                filePath += "/resources/connection.properties";
                FileReader input = new FileReader(filePath);

                Properties props = new Properties();
                props.load(input);

                String url = props.getProperty("url");
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return conn;
    }
    public static void main(String[] args) {

        Connection conn1 = getConnection();
        Connection conn2 = getConnection();
        Connection conn3 = getConnection();
        System.out.println(conn1);
        System.out.println(conn2);
        System.out.println(conn3);

    }
}

