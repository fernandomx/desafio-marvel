/*
 * *
 *  * Created by Fernando Meregali  on 07/10/20 22:29
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 07/10/20 22:29
 *
 */

package com.app.marvelsapp.data.net.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<Item___> items = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Item___> getItems() {
        return items;
    }

    public void setItems(List<Item___> items) {
        this.items = items;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Events{" +
                "available=" + available +
                ", collectionURI='" + collectionURI + '\'' +
                ", items=" + items +
                ", returned=" + returned +
                '}';
    }
}
