package com.fidel.phoneapp;

import java.util.Scanner;
public class ContactsMenuThread extends PhoneThread{
    private boolean inContactsMenu;

    public ContactsMenuThread(Phonebook phonebook, Scanner input) {
        super(phonebook, input);
        this.inContactsMenu = true;
        this.setName("contacts-menu");
    }

    // Start the contacts menu thread
    @Override
    public void run(){
        while(inContactsMenu){
            System.out.println("""
                            Manage Contacts
                            1. Show all contacts
                            2. Add a new contact
                            3. Search for a contact
                            4. Delete a contact
                            5. Go back to the previous menu""");
            String option = input.nextLine();
            switch(option){
                case "1"->{
                    System.out.println("--Contacts--");
                    for(Contact contact: phonebook.getContacts()){
                        contact.showDetails();
                    }
                }case "2"->{
                    System.out.println("Enter contact details:");
                    System.out.print("Name: ");
                    String contactName = input.nextLine();
                    System.out.print("Contact info: ");
                    String contactInfo = input.nextLine();
                    phonebook.addContact(contactName, contactInfo);
                }
                case "3"->{
                    System.out.println("Enter contact to search:");
                    String contactName = input.nextLine();
                    Contact contact = phonebook.getContact(contactName);
                    contact.showDetails();
                }case "4"->{
                    System.out.println("Enter contact to delete:");
                    String contactName = input.nextLine();
                    phonebook.deleteContact(contactName);
                }
                case "5"->{
                    this.inContactsMenu = false;
                }

                default -> {
                    System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
}
