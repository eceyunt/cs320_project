package Model;



public class Order {

    private Warehouse warehouse;
    private Product product;
    private double quantity;
    private Retailer retailer;

    public Order(Retailer retailer, Warehouse warehouse, Product product, double quantity) {
        this.retailer = retailer;
        this.warehouse = warehouse;
        this.product = product;
        this.quantity = quantity;
        System.out.println(product.getProductName() + "   ***");
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getOrderPrice() {
        return quantity * product.getProductPrice();
    }

    @Override
    public String toString() {
        return product.getProductName() + "\t" + quantity + "\t" + (quantity * product.getProductPrice());
    }

    public void perform(RetailManagement retailManagement) {
        if (retailer.getRetailerAccount().getBalance() >= getOrderPrice()) {
            retailer.getRetailerAccount().decreaseAccount(getOrderPrice());
            getWarehouse().getWarehouseAccount().increaseAccount(getOrderPrice() * 0.98);
            retailManagement.getAccount().increaseAccount(getOrderPrice() * 0.02);
            System.out.println(retailer.getRetailerAccount().getBalance() + "\t" + warehouse.getWarehouseAccount().getBalance() + "\t");
        }
    }
}
