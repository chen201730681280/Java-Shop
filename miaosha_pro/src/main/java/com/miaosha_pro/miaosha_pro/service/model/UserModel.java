package com.miaosha_pro.miaosha_pro.service.model;

public class UserModel
{
    private Integer id;
    private String name;
    private Byte gender;
    private String age;
    private String telphone;
    private String thirdId;

    private String encrptPassWord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getEncrptPassWord() {
        return encrptPassWord;
    }

    public void setEncrptPassWord(String encrptPassWord) {
        this.encrptPassWord = encrptPassWord;
    }
}

