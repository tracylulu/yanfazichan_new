package com.h3c.platform.common.entity;

public class SearchParamEntity {

    private String searchParam;
    
    private Integer num;
    
    private Integer size;
    
    private String createTime;
    
    private byte isDisable;

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
    
    public Integer getStart(){
        return (num - 1) * size;
    }
    
    public Integer getLimit(){
        return size;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public byte getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(byte isDisable) {
        this.isDisable = isDisable;
    }
}
