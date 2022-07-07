package com.bridgelabz.service;


import com.bridgelabz.DTO.AddressBookDto;
import com.bridgelabz.entity.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    String getMessage();

//    AddressBook AddAddressBook(AddressBookDto addressBookDto);

    Optional<AddressBook> getContactById(int getId);

    List<AddressBook> getListOfContacts();

    void deleteContact(int id);

    AddressBook updateContact(int getId, AddressBookDto addressBookDto);

   Optional<AddressBook> getAddressBookData(String token);

    String addData(AddressBookDto addressBookDto);

}
