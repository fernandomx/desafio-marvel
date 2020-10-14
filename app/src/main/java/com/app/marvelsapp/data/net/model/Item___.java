/*
 * *
 *  * Created by Fernando Meregali  on 07/10/20 22:30
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 07/10/20 22:30
 *
 */

package com.app.marvelsapp.data.net.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item___ {

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item___{" +
                "resourceURI='" + resourceURI + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
