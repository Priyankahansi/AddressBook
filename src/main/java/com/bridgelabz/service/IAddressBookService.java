package com.bridgelabz.service;


import com.bridgelabz.entity.AddressBook;

import java.util.List;

public interface IAddressBookService {
    String getMessage();

    String AddAddressBook(AddressBook addressBook);

    AddressBook getContactId(int getId);

    List<AddressBook> getListOfContacts();

    void deleteContact(int id);


    AddressBook updateContact(int getId, AddressBook addressBook);

}
