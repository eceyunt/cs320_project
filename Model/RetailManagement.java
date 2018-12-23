package Model;

import View.GUI;

import java.util.ArrayList;



public class RetailManagement {
    private Account account;
    private ArrayList<Warehouse> warehouseList;
    private ArrayList<Retailer> retailerList;

    public RetailManagement(Account account) {
        this.account = account;
        warehouseList = new ArrayList<Warehouse>();
        retailerList = new ArrayList<Retailer>();
        GUI gui = new GUI(this);
    }

    public void register(Person person) {
        if (person instanceof Retailer)
            retailerList.add((Retailer) person);
        if (person instanceof Warehouse)
            warehouseList.add((Warehouse) person);
    }

    public ArrayList<Warehouse> findNearestWarehouse(String zipCode) {
        ArrayList<Warehouse> nearestWarehouses = new ArrayList<>();

        for (int i = 0; i < warehouseList.size(); i++) {
            Warehouse warehouse = warehouseList.get(i);
            System.out.println(warehouse.getName());
            ArrayList<Location> locations = warehouse.getLocations();
            for (int j = 0; j < locations.size(); j++) {
                Location location = locations.get(j);
                if (location.getLocationZipCode().equals(zipCode))
                    nearestWarehouses.add(warehouse);
            }
        }
        return nearestWarehouses;
    }

    public Retailer getCurrentRetailer(String name) {
        for (int i = 0; i < retailerList.size(); i++) {
            if (retailerList.get(i).getName().equals(name))
                return retailerList.get(i);
        }
        return null;
    }

    public Warehouse getCurrentWarehouse(String name) {
        for (int i = 0; i < warehouseList.size(); i++) {
            if (warehouseList.get(i).getName().equals(name))
                return warehouseList.get(i);
        }
        return null;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouseList.add(warehouse);
        System.out.println(warehouse.getLocations());
    }

    public Account getAccount() {
        return account;
    }

    public ArrayList<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public ArrayList<Retailer> getRetailerList() {
        return retailerList;
    }

    public void addRetailer(Retailer retailer) {
        retailerList.add(retailer);
    }
}