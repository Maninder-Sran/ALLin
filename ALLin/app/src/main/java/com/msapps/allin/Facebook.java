package com.msapps.allin;

/**
 * Created by Maninder on 4/24/2017.
 */

public class Facebook extends ContactInfo {

    private String accountType;
    private String email;
    private String accountName;
    private String website;
    private String name;

    public Facebook(int imageResourceId) {
        super(imageResourceId);
    }

    public Facebook(int imageResourceId, String accountType) {
        super(imageResourceId, accountType);
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getWebsite() {
        return this.website;
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
    public String getAccountType() {
        return super.getAccountType();
    }

    @Override
    public String getName() {
        return this.name;
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
    public void setAccountName(String accountName) {this.accountName = accountName;}

}
