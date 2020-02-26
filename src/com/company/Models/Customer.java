package com.company.Models;

import com.company.Annotations.*;

public class Customer implements java.io.Serializable, DbEntity {
    private String id;

    @RegexValidator(pattern = "^[A-Za-z].*[0-9]", message = "Your name can not contain any numbers")
    @RegexValidator(pattern = "^[0-9].*", message = "Your name can not contain any numbers")
    private String name;

    @RegexValidator(pattern = "^[0-9].*", message = "Your adress can not contain only numbers!")
    @RegexValidator(pattern = "^[0-9].*[A-Za-z]|^[A-Za-z]*", message = "Your adress need include both characters and number")
    private String address;

    @RegexValidator(pattern = "^[0-9].*", message = "Your mail can not contain only numbers!")
    @RegexValidator(pattern = "^[A-Za-z]|\\w*", message = "Please enter mail like this format example@mail.com!")
    private String mail;

    @RegexValidator(pattern = "^\\d{1,7}", message = "Phone number must be at least 8 digits")
    @RegexValidator(pattern = "^\\D.*", message = "Phone number can not contain any characters")
    private String tel;


    public Customer(String name, String address, String mail, String tel) {
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
