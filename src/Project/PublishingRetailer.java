package Project;

import java.util.ArrayList;

public class PublishingRetailer {
    private final int ID;
    private String name;
    private ArrayList<IPublishingArtifact> publishingArtifacts;
    private ArrayList<Country> countries;

    public PublishingRetailer(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = new ArrayList<>();
        this.countries = new ArrayList<>();
    }

    public ArrayList<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void addPublishingArtifact(IPublishingArtifact publishingArtifact){
        if(publishingArtifact != null)
            this.publishingArtifacts.add(publishingArtifact);
    }

    public void addCountry(Country country){
        if(country != null)
            this.countries.add(country);
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishingArtifacts(ArrayList<IPublishingArtifact> publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }
}
