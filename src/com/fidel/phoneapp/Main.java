package com.fidel.phoneapp;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Scanner object
        Scanner input = new Scanner(System.in);

        // An array list of contacts
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Fidel", "fidel@email.com"));
        contacts.add(new Contact("John", "john@email.com"));
        contacts.add(new Contact("Jane", "jane@email.com"));

        // Phonebook object
        Phonebook phonebook = Phonebook.getInstance("Personal", contacts);

        // Test contacts for messages
        Contact plumber = new Contact("Plumber David", "0909-0909");
        Contact homeCare = new Contact("Home Care Services", "home@example.net");

        // An array list of messages
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message(plumber, "Sink needs fixing pronto!"));
        messages.add(new Message(homeCare, "I'd like to know the curtains available."));

        // MessageHandler object
        MessageHandler msgHandler = MessageHandler.getInstance(messages);

        boolean inMainMenu = true;

        while(inMainMenu){
            System.out.println("""
                    Welcome to Phone App!
                    1. Manage Contacts
                    2. Messages
                    3. Quit""");
            String option = input.nextLine();
            switch(option){
                case "1"->{
                    // Create a thread to handle contacts menu
                    ContactsMenuThread contactsMenu = new ContactsMenuThread(phonebook, input);
                    contactsMenu.start();
                    try{
                        contactsMenu.join();
                    }catch(InterruptedException e){
                        System.out.println("Thread interruption - " + e.getMessage());
                    }
                }

                case "2"->{
                    // Create a thread to handle messages menu
                    MessagesMenuThread messagesMenu = new MessagesMenuThread(phonebook, msgHandler, input);
                    messagesMenu.start();
                    try{
                        messagesMenu.join();
                    }catch(InterruptedException e){
                        System.out.println("Thread Interruption - " + e.getMessage());
                    }
                }

                case "3"->{
                    System.out.println("Quitting Application...");
                    inMainMenu = false;
                }
            }
        }
    }
}
