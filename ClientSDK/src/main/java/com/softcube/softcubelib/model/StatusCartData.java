package com.softcube.softcubelib.model;

import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StatusCartData extends BaseData{

    private static final String EVENT_NAME = "StatusCart";

    @SerializedName("StatusCart")
    @Expose
    private List<CartItem> cartItems = new ArrayList<CartItem>();
    @SerializedName("GUID")
    @Expose
    private String GUID;




    public static StatusCartData create(Context context, String userName, String userEmail, List<CartItem>  cartItems){
        StatusCartData statusCartData = new StatusCartData();
        GeneralInfo generalInfo = GeneralInfo.create(context, EVENT_NAME, userName, userEmail);
        statusCartData.setGeneralInfo(generalInfo);

        statusCartData.setCartItems(cartItems);

        statusCartData.setGUID(UUID.randomUUID().toString());

        return statusCartData;
    }


    /**
     *
     * @return
     * The StatusCart
     */
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     *
     * @param CartItem
     * The StatusCart
     */
    public void setCartItems(List<CartItem> CartItem) {
        this.cartItems = CartItem;
    }

    /**
     *
     * @return
     * UUID, generated on each change of user's cart
     */
    public String getGUID() {
        return GUID;
    }

    /**
     *
     * @param GUID
     * The GUID
     */
    public void setGUID(String GUID) {
        this.GUID = GUID;
    }


}