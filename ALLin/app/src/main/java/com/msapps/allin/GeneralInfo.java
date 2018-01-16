package com.msapps.allin;

/**
 * Created by Maninder on 4/24/2017.
 */

public class GeneralInfo extends ContactInfo{

    private String accountName;
    private String accountType;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;

    public GeneralInfo(int imageResourceId) {
        super(imageResourceId);
    }

    public GeneralInfo(int imageResourceId, String accountType) {
        super(imageResourceId, accountType);
    }

    @Override
    public String getAccountName() { return this.accountName; }

    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String getAccountType() {
        return super.getAccountType();
    }

    @Override
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
