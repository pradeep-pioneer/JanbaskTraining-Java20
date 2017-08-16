package com.janbask.training3;
import java.sql.*;
import java.text.SimpleDateFormat;

public class SimpleConnectionMySql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://sv01:3306/test", userName = "veridic", password = "veridic";
        try {
            makeConnection(url, userName, password);
        }
        catch (SQLException sqlException){
            Helper.LogException(sqlException);
        }
    }

    static void makeConnection(String url, String userName, String password)
    throws SQLException {
        Connection con = DriverManager.getConnection(
                url, userName, password);
        Statement stmt = con.createStatement();
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        ResultSet rs = stmt.executeQuery("select * from table_student");
        while (rs.next()) {
            System.out.printf("\nStudent Id: %s\tFirst Name: %s\tLast Name: %s\tDate Of Birth: %s",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    format.format(rs.getDate(4)));
        }
        con.close();
    }
}
