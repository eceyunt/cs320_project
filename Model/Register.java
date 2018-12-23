package Model;

import java.util.ArrayList;


public class Register {
    private Retailer retailer;
    private Warehouse warehouse;
    private ArrayList<Location> locationList;
    private ArrayList<Product> productList;

    public Register() {
        locationList = new ArrayList<Location>();
        productList = new ArrayList<Product>();
    }

    public void clear(){
        locationList = new ArrayList<Location>();
        productList = new ArrayList<Product>();
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<Location> locationList) {
        this.locationList = locationList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void addLocation(Location location){
        locationList.add(location) ;
    }

    public void addProduct(Product product){
        productList.add(product) ;
    }

}
