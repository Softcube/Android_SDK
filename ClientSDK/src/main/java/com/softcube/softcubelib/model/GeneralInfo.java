package com.softcube.softcubelib.model;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GeneralInfo {

    @SerializedName("eventName")
    @Expose
    private String eventName;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("screendim")
    @Expose
    private Screendim screendim;
    @SerializedName("browser")
    @Expose
    private Browser browser;
    @SerializedName("siteId")
    @Expose
    private String siteId;
    @SerializedName("cookies")
    @Expose
    private Cookies cookies;
    @SerializedName("s_location")
    @Expose
    private String sLocation;
    @SerializedName("referrer")
    @Expose
    private String referrer;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("device")
    @Expose
    private Device device;
    @SerializedName("user_device_id")
    @Expose
    private String userDeviceId;



    public static GeneralInfo create(Context context, String eventName, String userName, String userEmail){
        GeneralInfo generalInfo = new GeneralInfo();

        Device device = new Device();
        Screendim screendim = new Screendim();

        //Get screen size
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        screendim.setH(metrics.heightPixels);
        screendim.setW(metrics.widthPixels);

        //Get site id
        try {
            ApplicationInfo app = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = app.metaData;
            String site = bundle.getString("com.softcube.siteId");
            //TODO: Add exeption with error about empty <meta-data android:name = "com.softcube.siteId" android:value="test" />
            generalInfo.setSiteId(site);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        //Get current time
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss z", Locale.US);
        String dateString = sdf.format(date);

        //Get device
        device.setType("mobile");
        device.setVendor(Build.MANUFACTURER);
        device.setId(Build.ID);
        device.setVersion(Build.MODEL);
        device.setOs(Build.VERSION.RELEASE);

        generalInfo.setEventName(eventName);
        generalInfo.setDatetime(dateString);
        generalInfo.setScreendim(screendim);
        generalInfo.setDevice(device);
        generalInfo.setUserName(userName);
        generalInfo.setUserEmail(userEmail);
        return generalInfo;
    }


    /**
     *
     * @return
     * The eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     *
     * @param eventName
     * The eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     *
     * @return
     * The datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     *
     * @param datetime
     * The datetime
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     *
     * @return
     * The screendim
     */
    public Screendim getScreendim() {
        return screendim;
    }

    /**
     *
     * @param screendim
     * The screendim
     */
    public void setScreendim(Screendim screendim) {
        this.screendim = screendim;
    }

    /**
     *
     * @return
     * The browser
     */
    public Browser getBrowser() {
        return browser;
    }

    /**
     *
     * @param browser
     * The browser
     */
    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    /**
     *
     * @return
     * The siteId
     */
    public String getSiteId() {
        return siteId;
    }

    /**
     *
     * @param siteId
     * The siteId
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /**
     *
     * @return
     * The cookies
     */
    public Cookies getCookies() {
        return cookies;
    }

    /**
     *
     * @param cookies
     * The cookies
     */
    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    /**
     *
     * @return
     * The sLocation
     */
    public String getSLocation() {
        return sLocation;
    }

    /**
     *
     * @param sLocation
     * The s_location
     */
    public void setSLocation(String sLocation) {
        this.sLocation = sLocation;
    }

    /**
     *
     * @return
     * The referrer
     */
    public String getReferrer() {
        return referrer;
    }

    /**
     *
     * @param referrer
     * The referrer
     */
    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    /**
     *
     * @return
     * The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     * The user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     * The userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     *
     * @param userEmail
     * The user_email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getUserDeviceId() {
        return userDeviceId;
    }

    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }
}