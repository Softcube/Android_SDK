package com.softcube.softcubelib.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cookies {

    @SerializedName("sc")
    @Expose
    private String sc;

    /**
     *
     * @return
     * The sc
     */
    public String getSc() {
        return sc;
    }

    /**
     *
     * @param sc
     * The sc
     */
    public void setSc(String sc) {
        this.sc = sc;
    }

}