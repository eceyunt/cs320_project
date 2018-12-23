package Controller;

import Model.*;
import View.RegisterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class RegisterController implements ActionListener {
    private RegisterPanel registerPanel;
    private RetailManagement retailManagement;
    private Retailer retailer;
    private Register register;


    public RegisterController(RegisterPanel registerPanel, RetailManagement retailManagement) {
        this.registerPanel = registerPanel;
        this.retailManagement = retailManagement;
        register = new Register();
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        Warehouse warehouse;
        if (button.getText().equalsIgnoreCase("Warehouse")) {
            registerPanel.removeAll();
            registerPanel.add(registerPanel.getWarehousePanel());
        } else if (button.getText().equalsIgnoreCase("Retailer")) {
            registerPanel.removeAll();
            registerPanel.add(registerPanel.getRetailerPanel());
        } else if (button.getText().equalsIgnoreCase("ADD Warehouse")) {
            warehouse = new Warehouse(registerPanel.getWarehouseNameField().getText(), new Account(0.0));
            warehouse.addLocationList(register.getLocationList());
            warehouse.addProductList(register.getProductList());
            System.out.println(register.getProductList());
            register.setWarehouse(warehouse);
            System.out.println("ADD Warehouse BUTTON WORKS");
            retailManagement.addWarehouse(warehouse);
            register.clear();
            clearForm();

        } else if (button.getText().equalsIgnoreCase("ADD Warehouse LOCATION")) {
            Location location = new Location(registerPanel.getWarehouseLocNameField().getText(), registerPanel.getWarehouseZipField().getText());
            System.out.println("ADD LOCATION BUTTON WORKS");
            register.addLocation(location);
        } else if (button.getText().equalsIgnoreCase("ADD PRODUCT")) {
            Product product;
            JComboBox prodList = registerPanel.getProductList();
            String prodName = registerPanel.getProductList().getSelectedItem().toString();
            warehouse = register.getWarehouse();
            switch (prodName) {
                case "TShirt":
                    product = new TShirt(prodName, 15.0);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Trousers":
                    product = new TShirt(prodName, 40);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Sweatshirt":
                    product = new TShirt(prodName, 35);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Shoes":
                    product = new TShirt(prodName, 35);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Coat":
                    product = new TShirt(prodName, 60);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Jacket":
                    product = new TShirt(prodName, 55);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Jean":
                    product = new TShirt(prodName, 45);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Hat":
                    product = new TShirt(prodName, 10);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
                case "Bag":
                    product = new TShirt(prodName, 30);

                    System.out.println(product.getProductName());
                    if (registerPanel.getLabel().getText().equalsIgnoreCase("")) {
                        registerPanel.getLabel().setText(product.getProductName());
                    } else {
                        registerPanel.getLabel().setText(registerPanel.getLabel().getText() + "," + product.getProductName());
                    }
                    register.addProduct(product);
                    break;
            }
            System.out.println("ADD PRODUCTS BUTTON WORKS");
        } else if (button.getText().equalsIgnoreCase("ADD Retailer")) {

            boolean e1=true;
            boolean e2=true;
            boolean e3=true;
            boolean e4=true;


            if(registerPanel.getRetailerNameField().getText().equals("")){
                registerPanel.getRetailerNameField().setBackground(Color.YELLOW);
                e1=false;
            }else registerPanel.getRetailerNameField().setBackground(Color.WHITE);

            if(registerPanel.getRetailerLocField().getText().equals("")){
                registerPanel.getRetailerLocField().setBackground(Color.YELLOW);
                e2=false;
            }else registerPanel.getRetailerLocField().setBackground(Color.WHITE);

            if(registerPanel.getRetailerZipField().getText().equals("")){
                registerPanel.getRetailerZipField().setBackground(Color.YELLOW);
                e3=false;
            }else registerPanel.getRetailerZipField().setBackground(Color.WHITE);


            if(registerPanel.getRetailerAccount().getText().equals("")){
                registerPanel.getRetailerAccount().setBackground(Color.YELLOW);
                e4=false;
            }else registerPanel.getRetailerAccount().setBackground(Color.WHITE);

            if(e1 & e2 & e3 & e4) {
                retailer = new Retailer(registerPanel.getRetailerNameField().getText(), new Location(), new Account(registerPanel.getAccountBalance()));
                System.out.println("ADD Retailer BUTTON WORKS");
                retailManagement.addRetailer(retailer);
                Location location = new Location(registerPanel.getRetailerLocField().getText(), registerPanel.getRetailerZipField().getText());
                System.out.println("ADD Retailer LOCATION BUTTON WORKS");
                retailer.setLocation(location);
                clearForm();
            }
        }
        else if (button.getText().equalsIgnoreCase("GO TO Retailer PAGE")) {
            registerPanel.getWarehousePanel().removeAll();
            registerPanel.add(registerPanel.getRetailerPanel());
        }
    }

    private void clearForm(){
        registerPanel.refresh();
        registerPanel.revalidate();
        registerPanel.repaint();

    }
}
