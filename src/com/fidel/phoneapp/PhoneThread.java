package com.fidel.phoneapp;

import java.util.Scanner;

public class PhoneThread extends Thread{
    protected final Phonebook phonebook;
    protected final Scanner input;
    public PhoneThread(Phonebook phonebook, Scanner input){
        this.phonebook = phonebook;
        this.input = input;
    }
}
