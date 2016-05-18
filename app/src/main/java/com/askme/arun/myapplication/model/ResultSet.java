package com.askme.arun.myapplication.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arun on 18/5/16.
 */

public class ResultSet {
    @SerializedName("totalResultsReturned")
    @Expose
    private Integer totalResultsReturned;
    @SerializedName("items")
    @Expose
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * @return The totalResultsReturned
     */
    public Integer getTotalResultsReturned() {
        return totalResultsReturned;
    }

    /**
     * @param totalResultsReturned The totalResultsReturned
     */
    public void setTotalResultsReturned(Integer totalResultsReturned) {
        this.totalResultsReturned = totalResultsReturned;
    }

    /**
     * @return The items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
