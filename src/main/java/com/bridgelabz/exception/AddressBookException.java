package com.bridgelabz.exception;


import com.bridgelabz.entity.AddressBook;

public class AddressBookException extends RuntimeException{

    public AddressBookException(String message) {

        super(message);
    }
}
