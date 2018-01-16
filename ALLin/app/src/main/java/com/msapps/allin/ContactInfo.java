package com.msapps.allin;

/**
 * Created by Maninder on 4/24/2017.
 */

public class ContactInfo {

    private String accountType;
    private String name;
    private String accountName;
    private String email;
    private String website;
    private String address;
    private int logo;
    private String phoneNumber;

    public ContactInfo(int imageResourceId) {
        this.logo = imageResourceId;
    }

    public ContactInfo(int imageResourceId, String accountType) {
        this.accountType = accountType;
        this.logo = imageResourceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLogo() {
        return this.logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
