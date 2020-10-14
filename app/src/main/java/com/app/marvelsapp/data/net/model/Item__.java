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

public class Item__ {

    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item__{" +
                "resourceURI='" + resourceURI + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
