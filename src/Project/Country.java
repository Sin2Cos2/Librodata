package Project;

public class Country {
    private final int ID;
    private String countryCode;

    public Country(int ID, String countryCode) {
        this.ID = ID;
        this.countryCode = countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getID() {
        return ID;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
