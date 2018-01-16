package com.msapps.allin;

import java.io.Serializable;

/**
 * Created by Maninder on 4/25/2017.
 */

public class Contact implements Serializable {

    private int imageResourceId;
    private String name;
    private boolean isAdded = false;
    private boolean isRemovable = false;

    public Contact(String name, int imageResourceId) {
        this.imageResourceId = imageResourceId;
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

