package com.fidel.phoneapp;

import java.util.ArrayList;

public class Phonebook {
    private static Phonebook instance;
    private String name;

    private ArrayList<Contact> contacts;


    /**
     * Creates a Phonebook object
     * @param name name of the phonebook
     * @param contacts ArrayList of contacts
     */
    private Phonebook(String name, ArrayList <Contact> contacts){
        this.name = name;
        this.contacts = contacts;
    }

    /**
     * Gets an instance of the Phonebook class
     * @param name name of the phonebook
     * @param contacts ArrayList of contacts
     * @return a Phonebook object
     */

    public static synchronized Phonebook getInstance(String name, ArrayList<Contact> contacts){
        if(instance == null){
            instance = new Phonebook(name, contacts);
        }
        return instance;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Adds a contact to the Phonebook
     * @param contactName name of the contact
     * @param contactInfo info on the contact (email, phone, etc)
     */
    public void addContact(String contactName, String contactInfo){
        boolean contactAdded = this.contacts.add(new Contact(contactName, contactInfo));
        if(contactAdded){
            System.out.println("Contact has been added successfully.");
        }else{
            System.out.println("Contact not added.");
        }
    }

    /**
     * Returns a contact that exists in the Phonebook
     * @param contactName name of the contact
     * @return Contact, null (if contact is not found)
     */
    public Contact getContact(String contactName){
        for(Contact contact : this.contacts){
            if(contact.getContactName().equals(contactName)){
                System.out.println("Contact found.");
                return contact;
            }
        }

        // Return null if contact not found
        System.out.println("Contact not found");
        return null;
    }

    /**
     * Removes a contact from the Phonebook
     * @param contactName name of the contact
     */
    public void deleteContact(String contactName){
        Contact contact = this.getContact(contactName);
        if(contact == null){
            System.out.println("Contact does not exist. Try again.");
        }else{
            boolean contactRemoved = this.contacts.remove(contact);
            if(contactRemoved){
                System.out.println("Contact removed");
            }else{
                System.out.println("Failed to remove contact");
            }
        }
    }
}
