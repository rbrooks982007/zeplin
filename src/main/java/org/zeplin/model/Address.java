package org.zeplin.model;

/**
 * Created by rbrooks3 on 6/19/16.
 */
public class Address {

    private int locationNumber;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;


    public int getLocationNumber() {

        return locationNumber;
    }

    public void setLocationNumber(final int locationNumber) {

        this.locationNumber = locationNumber;
    }

    public String getStreetAddress() {

        return streetAddress;
    }

    public void setStreetAddress(final String streetAddress) {

        this.streetAddress = streetAddress;
    }

    public String getCity() {

        return city;
    }

    public void setCity(final String city) {

        this.city = city;
    }

    public String getState() {

        return state;
    }

    public void setState(final String state) {

        this.state = state;
    }

    public String getZipCode() {

        return zipCode;
    }

    public void setZipCode(final String zipCode) {

        this.zipCode = zipCode;
    }
}
