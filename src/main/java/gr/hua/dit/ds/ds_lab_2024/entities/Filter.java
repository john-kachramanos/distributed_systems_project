package gr.hua.dit.ds.ds_lab_2024.entities;

import jakarta.persistence.Entity;

public class Filter {
    private String country;
    private String town;
    private String dimensions;
    private int price;

    public Filter(String country, String town, String dimensions, int price) {
        this.country = country;
        this.town = town;
        this.dimensions = dimensions;
        this.price = price;
    }

    public Filter() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}

