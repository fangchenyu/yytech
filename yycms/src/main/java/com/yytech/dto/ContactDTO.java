package com.yytech.dto;

public class ContactDTO {
    private int id;
    private String localimg;//地址图片路径
    private String servicemobile;//业务咨询电话
    private String bossmobile; //经理电话
    private String mobile; //联系电话
    private String email; //公司邮箱
    private String recruit;//招聘邮箱
    private String address; //公司地址
    private String twocode;//公司二维码图片路径
    private String content;
    private long createtime;
    private int del;


    @Override
    public String toString() {
        return "ContactDTO{" +
                "id=" + id +
                ", localimg='" + localimg + '\'' +
                ", servicemobile='" + servicemobile + '\'' +
                ", bossmobile='" + bossmobile + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", recruit='" + recruit + '\'' +
                ", address='" + address + '\'' +
                ", twocode='" + twocode + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", del=" + del +
                '}';
    }

    public ContactDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalimg() {
        return localimg;
    }

    public void setLocalimg(String localimg) {
        this.localimg = localimg;
    }

    public String getServicemobile() {
        return servicemobile;
    }

    public void setServicemobile(String servicemobile) {
        this.servicemobile = servicemobile;
    }

    public String getBossmobile() {
        return bossmobile;
    }

    public void setBossmobile(String bossmobile) {
        this.bossmobile = bossmobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecruit() {
        return recruit;
    }

    public void setRecruit(String recruit) {
        this.recruit = recruit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTwocode() {
        return twocode;
    }

    public void setTwocode(String twocode) {
        this.twocode = twocode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
}
