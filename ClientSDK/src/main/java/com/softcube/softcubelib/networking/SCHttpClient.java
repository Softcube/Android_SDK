package com.softcube.softcubelib.networking;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by OwlDeveloper on 26.12.15.
 */
public class SCHttpClient {

    private static final String SOFTCUBE_URL = "http://tracker.softcube.com";
    private static final String HOST = "tracker.softcube.com";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private Gson gson = new Gson();
    private boolean debug;
    private static final String TAG = "SCHttpClient";

    public SCHttpClient(boolean debug){
            this.debug = debug;
    }


    public String postData(String json, String siteId) {
        HttpURLConnection urlConnection = null;
        DataOutputStream printout;
        DataInputStream input;
        URL url = null;
        String response = "";
        logDebug("JSON: " + json);
        logDebug("SITE_ID: " + siteId);
        try {
            url = new URL(SOFTCUBE_URL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);

            HashMap<String, String> params = new HashMap<String, String>();
            params.put("id", json);
            params.put("site", siteId);

            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(params));
            writer.flush();
            writer.close();
            os.close();
            int responseCode=urlConnection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="Code: " + responseCode;

            }
        } catch (Exception e) {
            if(debug) {
                e.printStackTrace();
                logError(e.getLocalizedMessage());
            }
        }
        finally {
            if(urlConnection!=null) {
                urlConnection.disconnect();
            }
        }
        logDebug(response);
        return response;
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                stringBuilder.append("&");

            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }

        return stringBuilder.toString();
    }

    private void logError(String errorMessage){
        if(debug){
            Log.e(TAG, ""+errorMessage);
        }
    }
    private void logDebug(String message){
        if(debug){
            Log.d(TAG, ""+message);
        }
    }



}
