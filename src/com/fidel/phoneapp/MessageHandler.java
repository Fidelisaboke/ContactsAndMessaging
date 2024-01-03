package com.fidel.phoneapp;

import java.util.ArrayList;
public class MessageHandler {
    private ArrayList<Message> messages;

    private static MessageHandler instance;

    private MessageHandler(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public static MessageHandler getInstance(ArrayList<Message> messages){
        if(instance == null){
            instance = new MessageHandler(messages);
        }

        return instance;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    /**
     * Creates and adds messages (simulates sending messages)
     * @param contact The contact to receive the message
     * @param msgBody The body of the message
     */
    public void addMessage(Contact contact, String msgBody){
        boolean messageAdded = this.messages.add(new Message(contact, msgBody));
        if(messageAdded){
            System.out.println("Message sent successfully.");
        }else{
            System.out.println("Message has not been sent");
        }
    }

    /**
     * Gets the messages sent to a specific contact
     * @param contactName name of the contact
     * @return an ArrayList containing messages of a specific contact
     */
    public ArrayList<Message> getMessagesByContact(String contactName){
        ArrayList<Message> contactMessages = new ArrayList<>();
        for(Message message : this.getMessages()){
            if(message.getContact().getContactName().equals(contactName)){
                contactMessages.add(message);
            }
        }

        return contactMessages;
    }
}


