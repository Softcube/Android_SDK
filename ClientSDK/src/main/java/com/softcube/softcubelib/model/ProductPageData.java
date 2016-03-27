package com.softcube.softcubelib.model;

import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductPageData extends  BaseData{

    private static final String EVENT_NAME = "ProductPage";

    @SerializedName("ProductPage")
    @Expose
    private ProductPage productPage;

   
    /**
     *
     * @return
     * The productPage
     */
    public ProductPage getProductPage() {
        return productPage;
    }

    /**
     *
     * @param ProductPage
     * The productPage
     */
    public void setProductPage(ProductPage ProductPage) {
        this.productPage = ProductPage;
    }



    public static ProductPageData create(Context context, String userName, String userEmail, ProductPage productPage){
        ProductPageData productPageData = new ProductPageData();
        GeneralInfo generalInfo = GeneralInfo.create(context, EVENT_NAME, userName, userEmail);
        productPageData.setGeneralInfo(generalInfo);

        productPageData.setProductPage(productPage);

        return productPageData;
    }



}