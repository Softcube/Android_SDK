package com.softcube.softcubelib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.softcube.softcubelib.model.BaseData;
import com.softcube.softcubelib.model.CartItem;
import com.softcube.softcubelib.model.PageViewData;
import com.softcube.softcubelib.model.ProductPage;
import com.softcube.softcubelib.model.ProductPageData;
import com.softcube.softcubelib.model.PurchasedItemsData;
import com.softcube.softcubelib.model.StatusCartData;
import com.softcube.softcubelib.networking.SCHttpClient;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OwlDeveloper on 26.12.15.
 */
public class SoftCubeClient {

    private static final String TAG = "SoftCubeClient";

    private static String userName = null;
    private static String userEmail = null;

    private Context context;
    public SoftCubeClient(Context context){
        this.context = context;
    }


    public void pageView(String pageUrl){
        if (checkNetwork()) {
            PageViewData data = PageViewData.create(context, userName, userEmail, pageUrl);
            Type type = new TypeToken<PageViewData>(){}.getType();
            new SCRequestTask(data, type).execute();
        }
    }
    public void productPage(ProductPage productPage){
        if (checkNetwork()) {
            ProductPageData data = ProductPageData.create(context, userName, userEmail, productPage);
            Type type = new TypeToken<ProductPageData>(){}.getType();
            new SCRequestTask(data, type).execute();
        }
    }

    public void statusCart(List<CartItem> cartItems){
        if (checkNetwork()) {
            StatusCartData data = StatusCartData.create(context, userName, userEmail, cartItems);
            Type type = new TypeToken<StatusCartData>(){}.getType();
            new SCRequestTask(data, type).execute();
        }
    }

    public void purchasedItems(String orderNumber, String GUID){
        if (checkNetwork()) {
            PurchasedItemsData data = PurchasedItemsData.create(context, userName, userEmail, orderNumber, GUID);
            Type type = new TypeToken<PurchasedItemsData>(){}.getType();
            new SCRequestTask(data, type).execute();
        }
    }

    public void purchasedItems(String orderNumber, String GUID, List<CartItem> purchasedItems){
        if (checkNetwork()) {
            PurchasedItemsData data = PurchasedItemsData.create(context, userName, userEmail, orderNumber, GUID, purchasedItems);
            Type type = new TypeToken<PurchasedItemsData>(){}.getType();
            new SCRequestTask(data, type).execute();
        }
    }

    public static void setUserName(String userName){
        SoftCubeClient.userName = userName;
    }

    public static void setUserEmail(String userEmail){
        SoftCubeClient.userEmail = userEmail;
    }

    private class SCRequestTask extends AsyncTask<BaseData, Void, String> {
        private BaseData data;
        private Type type;

        public SCRequestTask(BaseData data, Type type){
            this.data = data;
            this.type = type;

        }


        @Override
        protected String doInBackground(BaseData... baseDatas) {
            Gson gson = new Gson();
                String json = gson.toJson(data, type);
                SCHttpClient httpClient = new SCHttpClient(true);
                httpClient.postData(json, data.getSiteId());
               return "";
        }




        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            //textView.setText(result);
        }
    }

    private boolean checkNetwork(){
        //TODO: add permission chech for android.permission.ACCESS_NETWORK_STATE

        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            Log.e(TAG, "No network connection available.");
            return false;
        }
    }





}
