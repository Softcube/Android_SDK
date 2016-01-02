package com.softcube.softcubelib.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductPage {

    @SerializedName("productKey")
    @Expose
    private String productKey;
    @SerializedName("isInStock")
    @Expose
    private int isInStock;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("tag_something")
    @Expose
    private List<String> tags;

    public  static ProductPage create(String productKey, double price, boolean isInStock){
        ProductPage productPage = new ProductPage();
        return productPage;
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

    /**
     *
     * @return
     * The productKey
     */
    public String getProductKey() {
        return productKey;
    }

    /**
     *
     * @param productKey
     * The productKey
     */
    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    /**
     *
     * @return
     * The isInStock
     */
    public int getIsInStock() {
        return isInStock;
    }

    /**
     *
     * @param isInStock
     * The isInStock
     */
    public void setIsInStock(int isInStock) {
        this.isInStock = isInStock;
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

}