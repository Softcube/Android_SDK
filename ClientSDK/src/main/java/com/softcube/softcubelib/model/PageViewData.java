package com.softcube.softcubelib.model;

import android.content.Context;

public class PageViewData extends  BaseData{

    private static final String EVENT_NAME = "PageView";

    public static PageViewData create(Context context, String userName, String userEmail, String pageUrl){
        PageViewData pageViewData = new PageViewData();
        GeneralInfo generalInfo = GeneralInfo.create(context, EVENT_NAME, userName, userEmail);
        generalInfo.setSLocation(pageUrl);
        pageViewData.setGeneralInfo(generalInfo);
        return pageViewData;
    }



}