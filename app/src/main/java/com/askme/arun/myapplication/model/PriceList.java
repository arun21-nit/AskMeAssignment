package com.askme.arun.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Arun on 18/5/16.
 */

public class PriceList {

    @SerializedName("ResultSet")
    @Expose
    private com.askme.arun.myapplication.model.ResultSet ResultSet;

    /**
     * @return The ResultSet
     */
    public com.askme.arun.myapplication.model.ResultSet getResultSet() {
        return ResultSet;
    }

    /**
     * @param ResultSet The ResultSet
     */
    public void setResultSet(com.askme.arun.myapplication.model.ResultSet ResultSet) {
        this.ResultSet = ResultSet;
    }

}




