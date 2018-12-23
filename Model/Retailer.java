package Model;



public class Retailer extends Person {
    private Location location;
    private Account account;

    public Retailer(String name, Location location, Account account) {
        super(name);
        this.account = account;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Account getRetailerAccount() {
        return account;
    }

    public String[] getInfo(){
        return new String[]{getName(), String.valueOf(account.getBalance())};
    }
}
