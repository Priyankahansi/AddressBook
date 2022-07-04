package com.bridgelabz.service;

import com.bridgelabz.Repository.AddressBookRepository;
import com.bridgelabz.entity.AddressBook;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    AddressBookRepository repo;

    @Override
    public String getMessage() {
        return "Hello welcome to AddressBook";
    }

    @Override
    public String AddAddressBook(AddressBook addressBook) {
        repo.save(addressBook);
        return addressBook.toString();
    }

    @Override
    public AddressBook getContactId(int getId) {
        Optional<AddressBook> addressBook = repo.findById(getId);
        return addressBook.get();
    }

    @Override
    public List<AddressBook> getListOfContacts() {
        List<AddressBook> contacts = repo.findAll();
        return contacts;
    }

    @Override
    public void deleteContact(int id) {
        repo.deleteById(id);

    }

    @Override
    public AddressBook updateContact(int getId, AddressBook addressBook) {
        Optional<AddressBook> newContact = repo.findById(getId);
        if (newContact.isPresent()) {
            newContact.get().setFullName(addressBook.getFullName());
            newContact.get().setAddress(addressBook.getAddress());
            newContact.get().setCity(addressBook.getCity());
            newContact.get().setState(addressBook.getState());
            newContact.get().setZip(addressBook.getZip());
            newContact.get().setPhone(addressBook.getPhone());
            repo.save(newContact.get());
            return newContact.get();
        } else {
            return null;
        }

    }
}



