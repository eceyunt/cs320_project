package Model;

import java.awt.*;
import java.util.ArrayList;




public class Warehouse extends Person {
    private ArrayList<Location> locations;
    private ArrayList<Product> products;
    private Account account;

    public Warehouse(String name, Account account) {
        super(name);
        this.account = account;
        locations = new ArrayList<>();
        products = new ArrayList<>();
    }

    public Warehouse(String name){
        super(name);
    }

    public Account getWarehouseAccount() {
        return account;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProductList(ArrayList<Product> products) {
        for (Product product : products) {
            this.products.add(product);
        }
    }

    public void addProduct(Product product) {
       this.products.add(product);
    }

    public void addLocationList(ArrayList<Location> locations) {
        System.out.println(locations);
        for (Location location : locations) {
            this.locations.add(location);
        }
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public String getName() {
        return super.getName();
    }

    public String[] getInfo(){
        return new String[]{getName(), String.valueOf(account.getBalance())};
    }
}
