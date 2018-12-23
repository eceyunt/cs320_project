package View;

import Controller.LoginController;
import Controller.RegisterController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel {
    private JTextField username;
    private JTextField password;
    private JButton loginButton;
    private JButton registerButton;

    public LoginPanel(){
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        username = new JTextField("Username");
        username.setBounds(169, 71, 140, 20);
        add(username);
        username.setColumns(10);

        password = new JTextField("Password");
        password.setColumns(10);
        password.setBounds(169, 118, 140, 20);
        add(password);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        loginButton.addActionListener(new LoginController(this));
        registerButton.addActionListener(new LoginController(this));

        loginButton.setBounds(192, 168, 89, 23);
        registerButton.setBounds(192, 200, 89, 23);

        add(loginButton);
        add(registerButton);
    }

    public JTextField getUsername() {
        return username;
    }

    public JTextField getPassword() {
        return password;
    }
}
