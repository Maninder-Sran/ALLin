package com.msapps.allin;

/**
 * Created by Maninder on 4/24/2017.
 */

public class Twitter extends ContactInfo {

    private String accountType;
    private String email;
    private String accountName;
    private String website;
    private String name;

    public Twitter(int imageResourceId, String accountType) {
        super(imageResourceId, accountType);
    }

    public Twitter(int imageResourceId) {
        super(imageResourceId);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getWebsite() {
        return website;
    }

    @Override
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String getAccountType() {
        return super.getAccountType();
    }

    @Override
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAccountName() {
        return this.accountName;
    }

    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
