package com.company.Models;

import com.company.Annotations.*;

public class Customer implements java.io.Serializable, DbEntity {
    private String id;

    @RegexValidator(pattern = "^\\D.{1,}$", message = "Your name must be at least one character!")
    @RegexValidator(pattern = "^\\D*$", message = "Your name can not contain any numbers")
    private String name;

    /*@RegexValidator(pattern = "[0-9]+", message = "Your adress can not only contain numbers!")
    @RegexValidator(pattern = "\"^.{1,}$\"", message = "Your adress must be at least one character!")
    @RegexValidator(pattern = ".*\\d.*", message = "There must be at least one number in your adress!")*/

    @RegexValidator(pattern = "^\\D.*\\d", message = "Your adress must contain characters and number(s)")
    private String address;

    @RegexValidator(pattern = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$",
            message = "Your email adress must contain an @ character and a ., example: hello@hi.com"
    )
    private String mail;

    @RegexValidator(pattern = "^\\d{5,}$", message = "Phone number must be at least 5 digits")
    private String tel;

    public Customer(String name, String address, String mail, String tel) {
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.tel = tel;
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
