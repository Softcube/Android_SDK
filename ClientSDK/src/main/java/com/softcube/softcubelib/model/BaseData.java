package com.softcube.softcubelib.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseData {

    @SerializedName("GeneralInfo")
    @Expose
    private GeneralInfo generalInfo;

    /**
     *
     * @return
     * The generalInfo
     */
    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    /**
     *
     * @param GeneralInfo
     * The generalInfo
     */
    public void setGeneralInfo(GeneralInfo GeneralInfo) {
        this.generalInfo = GeneralInfo;
    }


    public String getSiteId(){
        if(generalInfo != null){
            return generalInfo.getSiteId();
        } else {
            return "";
        }
    }

}