package View;

import Controller.RegisterController;
import Model.RetailManagement;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;



public class RegisterPanel extends JPanel {

    private JPanel WarehousePanel;
    private JPanel RetailerPanel;
    private JButton WarehouseButton;
    private JButton RetailerButton;
    private JTextField WarehouseNameField;
    private JTextField WarehouseLocNameField;
    private JTextField WarehouseZipField;
    private JTextField RetailerNameField;
    private JTextField RetailerLocField;
    private JTextField RetailerZipField;
    private JButton WarehouseAddButton;
    private JButton WarehouseLocAddButton;
    private JButton productAddButton;
    private JButton RetailerAddButton;
    private JButton returnCustButton;
    private JLabel displayProdName;
    private JComboBox ProductList;
    private OrderPanel orderPanel;
    private RegisterController registerController;
    private JTextField RetailerAccount;

    public RegisterPanel(RetailManagement retailManagement) {
        setLayout(new FlowLayout());
        registerController = new RegisterController(this, retailManagement);
        WarehouseButton = new JButton("Warehouse");
        RetailerButton = new JButton("Retailer");
        returnCustButton = new JButton("GO TO RETAILER PAGE");
        RetailerButton.addActionListener(registerController);
        WarehouseButton.addActionListener(registerController);
        returnCustButton.addActionListener(registerController);
        add(WarehouseButton);
        add(RetailerButton);


        RetailerAccount = new JTextField();
        buildWarehousePanel();
        buildRetailerPanel();



        RetailerAccount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changeBg();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changeBg();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changeBg();
            }
        });
    }

    public void changeBg(){
       if(!RetailerAccount.getText().equals("")){
        try {
            Double.parseDouble(RetailerAccount.getText());
            RetailerAccount.setBackground(Color.WHITE);
        }catch (Exception wx){
            RetailerAccount.setBackground(Color.RED);
        }
       }else{
           RetailerAccount.setBackground(Color.WHITE);
       }
    }

    public void refresh(){
        removeAll();
        add(WarehouseButton);
        add(RetailerButton);

        buildWarehousePanel();
        buildRetailerPanel();

    }

    public void setOrderPanel(OrderPanel panel) {
        orderPanel = panel;
    }

    public JTextField getWarehouseNameField() {
        return WarehouseNameField;
    }

    public JButton getRetailerButton() {
        return RetailerButton;
    }

    public JButton getRetailerAddButton() {
        return RetailerAddButton;
    }

    public double getAccountBalance(){
        try {
            return Double.parseDouble(RetailerAccount.getText());
        }catch (Exception e){
            return 0;
        }

    }

    public JTextField getRetailerNameField() {
        return RetailerNameField;
    }

    public JTextField getRetailerAccount() {
        return RetailerAccount;
    }
    public JTextField getRetailerLocField() {
        return RetailerLocField;
    }

    public JTextField getRetailerZipField() {
        return RetailerZipField;
    }

    public JTextField getWarehouseLocNameField() {
        return WarehouseLocNameField;
    }

    public JTextField getWarehouseZipField() {
        return WarehouseZipField;
    }

    public JPanel getWarehousePanel() {
        return WarehousePanel;
    }

    public JPanel getRetailerPanel() {
        return RetailerPanel;
    }

    public JComboBox getProductList() {
        return ProductList;
    }

    public JLabel getLabel() {
        return displayProdName;
    }

    private void buildWarehousePanel() {

        String[] Product = {"Select Product", "Jacket", "Sweatshirt", "Shoes", "Coat",
                "Bag", "Jean", "TShirt", "Hat", "Trousers"};

        ProductList = new JComboBox(Product);

        WarehouseAddButton = new JButton("ADD Warehouse");
        WarehouseLocAddButton = new JButton("ADD Warehouse LOCATION");
        productAddButton = new JButton("ADD PRODUCT");

        WarehouseNameField = new JTextField();
        WarehouseLocNameField = new JTextField();
        WarehouseZipField = new JTextField();
        RetailerAccount.setText("0");
        WarehouseAddButton.addActionListener(registerController);
        WarehouseLocAddButton.addActionListener(registerController);
        productAddButton.addActionListener(registerController);

        WarehousePanel = new JPanel();
        WarehousePanel.setLayout(new GridLayout(12, 1));

        JPanel WarehouseInfPanel = new JPanel();
        JPanel WarehouseLocPanel = new JPanel();
        JPanel productPanel = new JPanel();
        JPanel tablePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel buttonPanel2 = new JPanel();
        JPanel buttonPanel3 = new JPanel();

        WarehouseInfPanel.setLayout(new GridLayout(1, 2));
        WarehouseInfPanel.setBorder(BorderFactory.createTitledBorder("Warehouse"));
        WarehouseInfPanel.add(new JLabel("Warehouse Name: "));
        WarehouseInfPanel.add(WarehouseNameField);

        WarehouseLocPanel.setLayout(new GridLayout(2, 2));
        WarehouseLocPanel.setBorder(BorderFactory.createTitledBorder("Locations"));
        WarehouseLocPanel.add(new JLabel("Location Name: "));
        WarehouseLocPanel.add(WarehouseLocNameField);
        WarehouseLocPanel.add(new JLabel("Location Zip Number: "));
        WarehouseLocPanel.add(WarehouseZipField);

        productPanel.setLayout(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Select Product"));
        productPanel.add(new JLabel("Product: "), BorderLayout.WEST);
        productPanel.add(ProductList, BorderLayout.EAST);

        tablePanel.setBorder(BorderFactory.createTitledBorder("Current Products"));
        tablePanel.setLayout(new GridLayout(2, 0));
        displayProdName = new JLabel("");
        tablePanel.add(displayProdName);

        buttonPanel2.add(WarehouseLocAddButton);
        buttonPanel2.add(new JPanel());

        buttonPanel3.add(productAddButton);


        WarehousePanel.add(WarehouseInfPanel);
        WarehousePanel.add(WarehouseLocPanel);
        WarehousePanel.add(buttonPanel2);
        WarehousePanel.add(productPanel);
        WarehousePanel.add(buttonPanel3);
        WarehousePanel.add(tablePanel);
        WarehousePanel.add(buttonPanel);
        WarehousePanel.add(WarehouseAddButton);
    }

    private void buildRetailerPanel() {

        RetailerPanel = new JPanel();

        RetailerNameField = new JTextField();
        RetailerLocField = new JTextField();
        RetailerZipField = new JTextField();


        RetailerAddButton = new JButton("ADD Retailer");

        RetailerAddButton.addActionListener(registerController);

        RetailerPanel.setLayout(new GridLayout(5, 1));

        JPanel custInfPanel = new JPanel();
        JPanel custLocPanel = new JPanel();
        JPanel custAccPanel = new JPanel();

        custInfPanel.setLayout(new GridLayout(1, 2));
        custInfPanel.setBorder(BorderFactory.createTitledBorder("Retailer"));
        custInfPanel.add(new JLabel("Retailer Name: "));
        custInfPanel.add(RetailerNameField);

        custAccPanel.setLayout(new GridLayout(1, 2));
        custAccPanel.setBorder(BorderFactory.createTitledBorder("Account"));
        custAccPanel.add(new JLabel("Retailer Account Balance: "));
        custAccPanel.add(RetailerAccount);

        custLocPanel.setLayout(new GridLayout(2, 2));
        custLocPanel.setBorder(BorderFactory.createTitledBorder("Locations"));
        custLocPanel.add(new JLabel("Location Name: "));
        custLocPanel.add(RetailerLocField);
        custLocPanel.add(new JLabel("Location Zip Number: "));
        custLocPanel.add(RetailerZipField);



        RetailerPanel.add(custInfPanel);
        RetailerPanel.add(custAccPanel);
        RetailerPanel.add(custLocPanel);
        RetailerPanel.add(RetailerAddButton);
    }
}
