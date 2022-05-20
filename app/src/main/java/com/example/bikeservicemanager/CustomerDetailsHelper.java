package com.example.bikeservicemanager;

import java.io.Serializable;

public class CustomerDetailsHelper implements Serializable {

    String name,contact,bm,bmmodel,byear,bno,dailyrunning,addrress;

    public CustomerDetailsHelper() {
    }

    public CustomerDetailsHelper(String name, String contact, String bm, String bmmodel, String byear, String bno, String dailyrunning, String addrress) {
        this.name = name;
        this.contact = contact;
        this.bm = bm;
        this.bmmodel = bmmodel;
        this.byear = byear;
        this.bno = bno;
        this.dailyrunning = dailyrunning;
        this.addrress = addrress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getBmmodel() {
        return bmmodel;
    }

    public void setBmmodel(String bmmodel) {
        this.bmmodel = bmmodel;
    }

    public String getByear() {
        return byear;
    }

    public void setByear(String byear) {
        this.byear = byear;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getDailyrunning() {
        return dailyrunning;
    }

    public void setDailyrunning(String dailyrunning) {
        this.dailyrunning = dailyrunning;
    }

    public String getAddrress() {
        return addrress;
    }

    public void setAddrress(String addrress) {
        this.addrress = addrress;
    }
}
