package com.softcube.softcubelib.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Browser {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("chrome")
    @Expose
    private boolean chrome;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("webkit")
    @Expose
    private boolean webkit;
    @SerializedName("a")
    @Expose
    private boolean a;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The chrome
     */
    public boolean isChrome() {
        return chrome;
    }

    /**
     *
     * @param chrome
     * The chrome
     */
    public void setChrome(boolean chrome) {
        this.chrome = chrome;
    }

    /**
     *
     * @return
     * The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     * The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     * @return
     * The webkit
     */
    public boolean isWebkit() {
        return webkit;
    }

    /**
     *
     * @param webkit
     * The webkit
     */
    public void setWebkit(boolean webkit) {
        this.webkit = webkit;
    }

    /**
     *
     * @return
     * The a
     */
    public boolean isA() {
        return a;
    }

    /**
     *
     * @param a
     * The a
     */
    public void setA(boolean a) {
        this.a = a;
    }

}