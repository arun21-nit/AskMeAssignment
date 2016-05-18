package com.askme.arun.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Arun on 18/5/16.
 */

public class Item {

    @SerializedName("Title")
    @Expose
    private String Title = "N/A";
    @SerializedName("Summary")
    @Expose
    private String Summary = "N/A";
    @SerializedName("Price")
    @Expose
    private String Price = "N/A";

    /**
     * @return The Title
     */
    public String getTitle() {
        if (Title != null && !Title.isEmpty())
            return Title;
        else return "N/A";
    }

    /**
     * @param Title The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return The Summary
     */
    public String getSummary() {
        if (Summary != null && !Summary.isEmpty())
            return Summary;
        else return "N/A";
    }

    /**
     * @param Summary The Summary
     */
    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

    /**
     * @return The Price
     */
    public String getPrice() {
        if (Price != null && !Price.isEmpty())
            return Price;
        else return "N/A";
    }

    /**
     * @param Price The Price
     */
    public void setPrice(String Price) {
        this.Price = Price;
    }

}
