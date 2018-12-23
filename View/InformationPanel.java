package View;

import Model.Retailer;
import Model.RetailManagement;
import Model.Warehouse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InformationPanel extends JPanel {


    JLabel balkAccountAmount;
    RetailManagement retailManagement;
    private DefaultTableModel RetailerModel;
    private DefaultTableModel WarehouseModel;

    public InformationPanel(RetailManagement retailManagement) {

        this.retailManagement = retailManagement;
        setLayout(new GridLayout(0, 1));

        JPanel panelRetailer = new JPanel();
        JTable tableRetailers = new JTable();
        RetailerModel = new DefaultTableModel();
        tableRetailers.setModel(RetailerModel);
        JScrollPane Retailers = new JScrollPane(tableRetailers);
        panelRetailer.add(Retailers);
        panelRetailer.setPreferredSize(new Dimension(200, 400));


        JPanel panelWarehouses = new JPanel();
        JTable tableWarehouses = new JTable();
        WarehouseModel = new DefaultTableModel();
        tableWarehouses.setModel(WarehouseModel);
        JScrollPane Warehouses = new JScrollPane(tableWarehouses);
        panelWarehouses.add(Warehouses);
        panelWarehouses.setPreferredSize(new Dimension(200, 400));


        JPanel bank = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 1);
        balkAccountAmount = new JLabel("0.0");
        bank.setLayout(gridLayout);
        bank.add("Bank", new JLabel("Retail Management System"));
        bank.add("Bank", balkAccountAmount);
        bank.setPreferredSize(new Dimension(200, 100));

        add(panelRetailer);
        add(panelWarehouses);
        add(bank);

        fill();
    }

    public void fill() {
        String[] header = {"Name", "Balance"};
        WarehouseModel.setColumnIdentifiers(header);
        WarehouseModel.setRowCount(0);
        for (Warehouse warehouse : retailManagement.getWarehouseList()) {
            WarehouseModel.addRow(warehouse.getInfo());

        }

        RetailerModel.setColumnIdentifiers(header);
        RetailerModel.setRowCount(0);
        for (Retailer retailer : retailManagement.getRetailerList()) {
            RetailerModel.addRow(retailer.getInfo());
        }

        balkAccountAmount.setText(String.valueOf(retailManagement.getAccount().getBalance()));
    }
}
