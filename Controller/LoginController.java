package Controller;

import View.LoginPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;

/**
 * Created by User on 12/23/2018.
 */
public class LoginController implements ActionListener {
    private LoginPanel loginPanel;
    private JTextField username;
    private JTextField password;

    public LoginController(LoginPanel loginPanel){
        this.loginPanel = loginPanel;
        username = loginPanel.getUsername();
        password = loginPanel.getPassword();

    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String command = button.getActionCommand();
        String query;
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1234");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");



        //query = "INSERT INTO `cs320`.`userinfo` (`username`, `password`) VALUES ('" + username + "' , '" + password + "')";




        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs320", properties);
            /*Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/cs320?autoReconnect=true&useSSL=false", "root", "1234");*/


            if (command.equals("Login")) {
                query = "select username, password from `cs320`.`userinfo` where username=" + username + " and password =" + password;
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet set = ps.executeQuery();
                if (set.next()) {
                    JOptionPane.showMessageDialog(null, "Login Sucessfull");
                    //write your code here
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    return;
                }
            }else {
                query = "INSERT INTO `cs320`.`userinfo` (`username`, `password`) VALUES ('eren', '1')";
                PreparedStatement ps = con.prepareStatement(query);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Register Sucessfull");
            }




        } catch (Exception exception) {
            // TODO: handle exception
        }
    }

    private String getQuery(String buttonName, String username, String password){
        String query;
        if (buttonName.equals("Login"))
            query = "select username, password from `cs320`.`userinfo` where username=" + username + " and password =" + password;
        else
            query = "INSERT INTO `cs320`.`userinfo` (`username`, `password`) VALUES ('eren', '1')";

        //query = "INSERT INTO `cs320`.`userinfo` (`username`, `password`) VALUES ('" + username + "' , '" + password + "')";

        return query;
    }
}
