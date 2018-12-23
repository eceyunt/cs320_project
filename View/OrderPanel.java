package View;

import Controller.OrderController;
import Model.RetailManagement;
import Model.Warehouse;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class OrderPanel extends JPanel {
    private JButton addButton;
    private JButton findWarehouse;
    private JComboBox<Product> productListBox;
    private JComboBox<Warehouse> availableWarehouseListBox;
    private JTextField RetailerName;
    private JSpinner spinnerCount;
    private JPanel addProductPanel;
    private JPanel shopInfPanel;
    private DefaultTableModel orderList;
    private JTable table;
    private JButton buyButton;
    private JPanel jpanel1;
    private JPanel jpanel2;
    private OrderController orderController;

    public OrderPanel(RetailManagement retailManagement) {
        orderController = new OrderController(this, retailManagement);
        setLayout(new BorderLayout());
        addButton = new JButton("Add");
        buyButton = new JButton("BUY");
        findWarehouse = new JButton("Find Warehouse");
        findWarehouse.addActionListener(orderController);
        addButton.addActionListener(orderController);
        buyButton.addActionListener(orderController);

        buildOrderPanel();
    }

    private void buildOrderPanel() {

        addProductPanel = new JPanel();
        shopInfPanel = new JPanel();

        table = new JTable();

        orderList = new DefaultTableModel(0, 0);

        String[] header = {"Name", "Quantity", "Price"};
        orderList.setColumnIdentifiers(header);

        table.setModel(orderList);

        productListBox = new JComboBox<>();
        availableWarehouseListBox = new JComboBox<>();
        availableWarehouseListBox.addActionListener(orderController);
//        orderController.getComboBox();
        spinnerCount = new JSpinner(new SpinnerNumberModel(1, 1,
                100, 1));
        RetailerName = new JTextField();

        addProductPanel.setLayout(new GridLayout(7, 2));
        addProductPanel.setSize(600, 400);
        addProductPanel.setBorder(BorderFactory.createTitledBorder("Add Product"));

        addProductPanel.add(new JLabel("Retailer Name: "));
        addProductPanel.add(RetailerName);
        addProductPanel.add(findWarehouse);
        addProductPanel.add(new JPanel());
        addProductPanel.add(new JLabel("Retailer Name: "));
        addProductPanel.add(availableWarehouseListBox);
        addProductPanel.add(new JLabel("Product: "));
        addProductPanel.add(productListBox);
        addProductPanel.add(new JLabel("Count: "));
        addProductPanel.add(spinnerCount);

        addProductPanel.add(addButton);
        addProductPanel.add(new JScrollPane(table));
        addProductPanel.add(new JPanel());
        addProductPanel.add(buyButton);


        add(addProductPanel);
        add(shopInfPanel);
    }

    public void refresh() {
        removeAll();
        buildOrderPanel();
        revalidate();
        repaint();
    }

    public JSpinner getSpinner() {
        return spinnerCount;
    }

    public JTextField getRetailerName() {
        return RetailerName;
    }

    public JComboBox getWarehouseListBox() {
        return availableWarehouseListBox;
    }

    public JComboBox getProductsListBox() {
        return productListBox;
    }

    public DefaultTableModel getOrderListView() {
        return orderList;
    }
}
