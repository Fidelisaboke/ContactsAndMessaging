package com.fidel.phoneapp;

public class Contact {
    private String contactName;
    private String contactInfo;

    public Contact(String name, String contactInfo) {
        this.contactName = name;
        this.contactInfo = contactInfo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String name) {
        this.contactName = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void showDetails(){
        System.out.println("Name: " + this.getContactName());
        System.out.println("Contact Info: " +this.getContactInfo());
    }
}
