package Model;



public class Product {
    private static final String UNIT_KG = "per kg"; //0 for kg
    private static final String UNIT_LITRE = "per liter"; // 1 for liter
    private static final String UNIT_PIECE = "per piece"; // 2 for piece
    private static final String[] types = {UNIT_KG, UNIT_LITRE, UNIT_PIECE};
    private String name;
    private double price;
    private String unitType;
    private String productDesc;

    public Product(String name, double price, int unitType) {
        this.name = name;
        this.price = price;
        this.unitType = decideUnitTypeOf(unitType);
    }

    private String decideUnitTypeOf(int unitType) {
        for (int i = 0; i < types.length; i++) {
            if (unitType == i) {
                return types[i];
            } else {
                return "Some error occurred.";
            }
        }
        return null;
    }

    public String getProductName() {
        return name;
    }

    public double getProductPrice() {
        return price;
    }

    public String getUnitType() {
        return unitType;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String desc) {
        this.productDesc = desc;
    }
}
