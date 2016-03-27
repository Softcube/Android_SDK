package com.softcube.softcubelib.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartItem {

    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("quantity")
    @Expose
    private int quantity;
    //Optional
    @SerializedName("price_currency_code")
    @Expose
    private String priceCurrencyCode;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("unit_price")
    @Expose
    private double unitPrice;
    @SerializedName("tag_something")
    @Expose
    private List<String> tags;

    public  static CartItem create(String productId,  double price, String priceCurrencyCode, int quantity, double unitPrice){
        CartItem cartItem = new CartItem(productId, price,  priceCurrencyCode,  quantity,  unitPrice, null, null);
        return cartItem;
    }


    public CartItem(String productId,  double price, String priceCurrencyCode, int quantity, double unitPrice, String discount, List<String> tags) {
        this.discount = discount;
        this.price = price;
        this.priceCurrencyCode = priceCurrencyCode;
        this.productId = productId;
        this.quantity = quantity;
        this.tags = tags;
        this.unitPrice = unitPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPriceCurrencyCode() {
        return priceCurrencyCode;
    }

    public void setPriceCurrencyCode(String priceCurrencyCode) {
        this.priceCurrencyCode = priceCurrencyCode;
    }

    public List<String> getTags() {
        return tags;
    }
    /**
     *
     * @param tags
     * Optional, for additional tags for product, starts with tag_
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     *
     * @return
     * The productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     * The productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     *
     * @return
     * The price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     * The quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}