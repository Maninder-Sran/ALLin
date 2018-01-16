package com.msapps.allin;

/**
 * Created by Maninder on 4/24/2017.
 */

public class LinkedIn extends ContactInfo{

    private String accountType;
    private String email;
    private String accountName;
    private String name;
    private String website;

    public LinkedIn(int imageResourceId) {
        super(imageResourceId);
    }

    public LinkedIn(int imageResourceId, String accountType) {
        super(imageResourceId, accountType);
    }

    @Override
    public String getAccountType() {
        return super.getAccountType();
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
    public void setAccountName(String accountName) { this.accountName = accountName; }

}
