package jyxy.jsj.zs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ds {
    public static Connection getconn(){
        Connection conn=null;
        String dburl="jdbc:mysql://127.0.0.1:3306/fk?useSSL=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(dburl,"root","123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
