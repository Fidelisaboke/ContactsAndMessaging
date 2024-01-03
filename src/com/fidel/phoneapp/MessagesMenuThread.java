package com.fidel.phoneapp;

import java.util.ArrayList;
import java.util.Scanner;

public class MessagesMenuThread extends PhoneThread{

    private final MessageHandler msgHandler;
    private boolean inMessagesMenu;

    public MessagesMenuThread(Phonebook phonebook, MessageHandler msgHandler, Scanner input) {
        super(phonebook, input);
        this.msgHandler = msgHandler;
        this.inMessagesMenu = true;
        this.setName("messages-menu");
    }

    @Override
    public void run(){
        while(inMessagesMenu){
            System.out.println("""
                    Messages Menu:
                    1. See all messages
                    2. Send a message
                    3. See all messages for a contact
                    4. Go back to previous menu""");

            String option = input.nextLine();
            switch(option){
                case "1"->{
                    System.out.println("--Messages--");
                    for(Message message: msgHandler.getMessages()){
                        message.showDetails();
                    }
                }

                case "2"->{
                    System.out.println("--Send a message--");
                    System.out.println("To: ");
                    String contactName = input.nextLine();
                    Contact contact = phonebook.getContact(contactName);
                    if(contact != null){
                        System.out.println("Message body: ");
                        String msgBody = input.nextLine();
                        msgHandler.addMessage(contact, msgBody);
                    }
                }

                case "3"->{
                    System.out.println("Enter the contact: ");
                    String contactName = input.nextLine();
                    ArrayList<Message> contactMessages = msgHandler.getMessagesByContact(contactName);
                    for(Message message: contactMessages){
                        message.showDetails();
                    }
                }

                case "4"->{
                    this.inMessagesMenu = false;
                }
            }
        }
    }
}
