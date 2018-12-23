package View;

import Model.RetailManagement;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class GUI extends JFrame {

    public GUI(RetailManagement retailManagement) {
        setTitle("Retail Management System");
        setSize(650, 600);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        LoginPanel loginPanel = new LoginPanel();
        tabbedPane.add("Login-Register", loginPanel);


        RegisterPanel registerPanel = new RegisterPanel(retailManagement);
        tabbedPane.add("Register", registerPanel);

        OrderPanel orderPanel = new OrderPanel(retailManagement);

        tabbedPane.add("Order", orderPanel);

        InformationPanel informationPanel = new InformationPanel(retailManagement);
        tabbedPane.add("Information", informationPanel);

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if (tabbedPane.getSelectedIndex() == 2) {
                    informationPanel.fill();
                } else if (tabbedPane.getSelectedIndex() == 1) {
                    orderPanel.refresh();
                } else if (tabbedPane.getSelectedIndex() == 0) {
                    registerPanel.refresh();
                }
            }
        });

        this.add(tabbedPane);
        setVisible(true);
    }
}
