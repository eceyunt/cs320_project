package Model;



public class Main {

    public static void main(String[] args) {
        RetailManagement retailManagement = new RetailManagement(new Account(100));

        Warehouse warehouse = new Warehouse("Zeynep", new Account(1));

        Location location = new Location("istanbul","10" );

        Retailer retailer = new Retailer("Eren",location,new Account(1000));


        warehouse.addLocation(location);


        retailManagement.addWarehouse(warehouse);

        retailManagement.addRetailer(retailer);

        System.out.println(warehouse.getName());

        SqlConnector sqlConnector = new SqlConnector();


    }
}
