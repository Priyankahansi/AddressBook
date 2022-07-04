package com.bridgelabz.service;


import com.bridgelabz.DTO.AddressBookDto;
import com.bridgelabz.entity.AddressBook;

import java.util.List;

public interface IAddressBookService {
    String getMessage();

    String AddAddressBook(AddressBookDto addressBookDto);

    AddressBook getContactId(int getId);

    List<AddressBook> getListOfContacts();

    void deleteContact(int id);


    AddressBook updateContact(int getId, AddressBookDto addressBookDto);

}
