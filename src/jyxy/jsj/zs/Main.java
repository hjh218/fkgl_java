package jyxy.jsj.zs;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conn=Ds.getconn();
        DatabaseMetaData metaData= conn.getMetaData();
        String url = metaData.getURL();
        System.out.println("数据库URL: " + url);
        String userName = metaData.getUserName();
        System.out.println("当前用户: " + userName );
        String productName = metaData.getDatabaseProductName();
        System.out.println("数据库产品名: " + productName);
        String version = metaData.getDatabaseProductVersion();
        System.out.println("数据库版本: " + version);
        String driverName = metaData.getDriverName();
        System.out.println("驱动名称: " + driverName);

        /*try {
            Statement sta=conn.createStatement();
            ResultSet rs=sta.executeQuery("select * from yeb");
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();
            for (int i = 1; i <= count; i++) {
                String fieldname = rsmd.getColumnName(i);
                String fieldtypename = rsmd.getColumnTypeName(i);
                System.out.println(fieldname + " " + fieldtypename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
