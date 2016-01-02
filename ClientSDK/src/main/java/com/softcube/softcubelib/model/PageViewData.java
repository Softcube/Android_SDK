package com.softcube.softcubelib.model;

import android.content.Context;

public class PageViewData extends  BaseData{

    public static PageViewData create(Context context, String userName, String userEmail, String pageUrl){
        PageViewData pageViewData = new PageViewData();
        GeneralInfo generalInfo = GeneralInfo.create(context, userName, userEmail);
        generalInfo.setSLocation(pageUrl);
        pageViewData.setGeneralInfo(generalInfo);
        return pageViewData;
    }



}