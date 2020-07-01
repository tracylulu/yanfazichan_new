package com.h3c.platform.common.excel;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ExcelSignImportInfoModel extends BaseRowModel implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -3828775488885930120L;
    @ExcelProperty(value = "版本号" ,index = 0)
    private String version;
    @ExcelProperty(value = "签名算法" ,index = 1)
    private String signAlg;
    @ExcelProperty(value = "签名秘钥的标识" ,index = 2)
    private String keyId;
    @ExcelProperty(value = "摘要（Base64编码）" ,index = 3)
    private String digest;
    @ExcelProperty(value = "设备SN" ,index = 4)
    private String sn;
    @ExcelProperty(value = "设备唯一ID串" ,index = 5)
    private String uniqueid;
    @ExcelProperty(value = "设备名称" ,index = 6)
    private String deviceName;
    @ExcelProperty(value = "BOM编码" ,index = 7)
    private String bom;
    @ExcelProperty(value = "MAC地址" ,index = 8)
    private String mac;
    @ExcelProperty(value = "ATS客户端ID" ,index = 9)
    private String atsid;
    @ExcelProperty(value = "签名用户名" ,index = 10)
    private String userName;
    @ExcelProperty(value = "用户密码（Base64编码）" ,index = 11)
    private String userPassword;
    @ExcelProperty(value = "厂商编码" ,index = 12)
    private String cmCode;
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getSignAlg() {
        return signAlg;
    }
    public void setSignAlg(String signAlg) {
        this.signAlg = signAlg;
    }
    public String getKeyId() {
        return keyId;
    }
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
    public String getDigest() {
        return digest;
    }
    public void setDigest(String digest) {
        this.digest = digest;
    }
    public String getSn() {
        return sn;
    }
    public void setSn(String sn) {
        this.sn = sn;
    }
    public String getUniqueid() {
        return uniqueid;
    }
    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public String getBom() {
        return bom;
    }
    public void setBom(String bom) {
        this.bom = bom;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getAtsid() {
        return atsid;
    }
    public void setAtsid(String atsid) {
        this.atsid = atsid;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getCmCode() {
        return cmCode;
    }
    public void setCmCode(String cmCode) {
        this.cmCode = cmCode;
    }
   
    
}
