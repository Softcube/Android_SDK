package com.softcube.softcubelib.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Screendim {

    @SerializedName("h")
    @Expose
    private int h;
    @SerializedName("w")
    @Expose
    private int w;

    /**
     *
     * @return
     * The h
     */
    public int getH() {
        return h;
    }

    /**
     *
     * @param h
     * The h
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     *
     * @return
     * The w
     */
    public int getW() {
        return w;
    }

    /**
     *
     * @param w
     * The w
     */
    public void setW(int w) {
        this.w = w;
    }

}