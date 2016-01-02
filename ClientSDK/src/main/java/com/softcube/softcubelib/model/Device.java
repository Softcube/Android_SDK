package com.softcube.softcubelib.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device {

@SerializedName("type")
@Expose
private String type;
@SerializedName("id")
@Expose
private String id;
@SerializedName("os")
@Expose
private String os;
@SerializedName("version")
@Expose
private String version;
@SerializedName("vendor")
@Expose
private String vendor;

/**
* 
* @return
* The type
*/
public String getType() {
return type;
}

/**
* 
* @param type
* The type
*/
public void setType(String type) {
this.type = type;
}

/**
* 
* @return
* The id
*/
public String getId() {
return id;
}

/**
* 
* @param id
* Device id
*/
public void setId(String id) {
this.id = id;
}

/**
* 
* @return
* The os
*/
public String getOs() {
return os;
}

/**
* 
* @param os
* The os
*/
public void setOs(String os) {
this.os = os;
}

/**
* 
* @return
* The version
*/
public String getVersion() {
return version;
}

/**
* 
* @param version
* The version
*/
public void setVersion(String version) {
this.version = version;
}

/**
* 
* @return
* The vendor
*/
public String getVendor() {
return vendor;
}

/**
* 
* @param vendor
* The vendor
*/
public void setVendor(String vendor) {
this.vendor = vendor;
}

}