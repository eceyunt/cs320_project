package Model;

import java.sql.*;

public class SqlConnector {

    public SqlConnector(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/dbName", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String username,String password){
        String query="INSERT INTO `cs320`.`userinfo` (`username`, `password`) VALUES (" + username + "," + password + ");";
    }
}
