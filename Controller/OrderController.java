package Controller;

import Model.*;
import View.OrderPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class OrderController implements ActionListener {
    OrderPanel orderPanel;
    RetailManagement retailManagement;
    Retailer curentRetailer;
    JComboBox comboBox;
    ArrayList<Warehouse> curentWarehouse = null;
    ArrayList<Order> orders = null;
    ArrayList<Product> listedProducts = null;

    public OrderController(OrderPanel orderPanel, RetailManagement retailManagement) {
        this.orderPanel = orderPanel;
        this.retailManagement = retailManagement;
        comboBox = new JComboBox();
        orders = new ArrayList<>();
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("test " + e.getActionCommand());

        if (e.getActionCommand().equals("Find Warehouse")) {
            JButton button = (JButton) e.getSource();
            String RetailerName = orderPanel.getRetailerName().getText();
            Retailer retailer = retailManagement.getCurrentRetailer(RetailerName);
            if (retailer != null) {
                String zipCode = retailer.getLocation().getLocationZipCode();
                curentRetailer = retailer;
                curentWarehouse = retailManagement.findNearestWarehouse(zipCode);
                setWarehouseList(curentWarehouse);
            }

        } else if (e.getActionCommand().equals("comboBoxChanged")) {
            JComboBox comboBox = (JComboBox) e.getSource();
            if (comboBox.getSelectedIndex() > -1) {
                listedProducts = curentWarehouse.get(comboBox.getSelectedIndex()).getProducts();
                setProductList(curentWarehouse.get(comboBox.getSelectedIndex()).getProducts());
            }
        }
        if (e.getActionCommand().equals("Add")) {
            JComboBox WarehouseCB = orderPanel.getWarehouseListBox();
            JComboBox productsCB = orderPanel.getProductsListBox();
            double amount = ((Integer) orderPanel.getSpinner().getValue()) * 1.0;
            System.out.println(listedProducts.get(productsCB.getSelectedIndex()));
            orders.add(new Order(curentRetailer, curentWarehouse.get(WarehouseCB.getSelectedIndex()), listedProducts.get(productsCB.getSelectedIndex()), amount));
            updateOrderList();
        }
        if (e.getActionCommand().equals("BUY")) {
            for (Order order : orders) {
                order.perform(retailManagement);
                orderPanel.refresh();
                orders = new ArrayList<>();
            }
        }
    }

    public void setWarehouseList(ArrayList<Warehouse> nearestWarehouse) {
        JComboBox comboBox = orderPanel.getWarehouseListBox();
        comboBox.removeAllItems();
        for (int i = 0; i < nearestWarehouse.size(); i++) {
            comboBox.addItem(nearestWarehouse.get(i).getName());
        }


    }

    public void setProductList(ArrayList<Product> products) {
        JComboBox comboBox = orderPanel.getProductsListBox();
        comboBox.removeAllItems();
        for (int i = 0; i < products.size(); i++) {
            comboBox.addItem(products.get(i).getProductName());
        }
    }

    public void updateOrderList() {
        DefaultTableModel model = orderPanel.getOrderListView();
        model.setRowCount(0);
        for (Order order : orders) {
            model.addRow(new String[]{order.getProduct().getProductName(), "" + order.getQuantity(), "" + order.getOrderPrice()});
        }

    }
}
