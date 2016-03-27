package com.softcube.softcubelib.model;

import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PurchasedItemsData extends  BaseData{

    private static final String EVENT_NAME = "PurchasedItems";

    @SerializedName("OrderNumber")
    @Expose
    private String orderNumber;

    @SerializedName("GUID")
    @Expose
    private String GUID;

    @SerializedName("PurchasedItems")
    @Expose
    private List<CartItem> purchasedItems = new ArrayList<CartItem>();

    public String getGUID() {
        return GUID;
    }

    /**
     *
     * @param GUID
     * UUID, taken from last StatusCart
     */
    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<CartItem> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(List<CartItem> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public static PurchasedItemsData create(Context context, String userName, String userEmail, String orderNumber, String GUID){
        PurchasedItemsData purchasedItemsData = new PurchasedItemsData();
        GeneralInfo generalInfo = GeneralInfo.create(context, EVENT_NAME, userName, userEmail);
        purchasedItemsData.setGeneralInfo(generalInfo);

        purchasedItemsData.setOrderNumber(orderNumber);

        purchasedItemsData.setGUID(GUID);

        return purchasedItemsData;
    }

    public static PurchasedItemsData create(Context context, String userName, String userEmail, String orderNumber, String GUID, List<CartItem> purchasedItems){
        PurchasedItemsData purchasedItemsData = PurchasedItemsData.create(context, userName, userEmail, orderNumber, GUID);
        purchasedItemsData.setPurchasedItems(purchasedItems);
        return purchasedItemsData;
    }



}