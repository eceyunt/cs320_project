package Model;



public class Location {
    private String locationName;
    private String locationZipCode;

    public Location() {
        this.locationName = locationName;
        this.locationZipCode = locationZipCode;
    }

    public Location(String locationName, String locationZipCode) {
        this.locationName = locationName;
        this.locationZipCode = locationZipCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationZipCode() {
        return locationZipCode;
    }

    @Override
    public String toString() {
        return "Location Name: " + locationName + '\'' +
                ", locationZipCode: '" + locationZipCode + '\'';
    }
}

