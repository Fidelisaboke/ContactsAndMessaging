package com.fidel.phoneapp;

public class Message {
    private Contact contact;
    private String msgBody;

    public Message(Contact contact, String msgBody) {
        this.contact = contact;
        this.msgBody = msgBody;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public void showDetails(){
        System.out.println("Contact Name: " + this.getContact().getContactName());
        System.out.println("Message: " +this.getMsgBody());
    }
}
