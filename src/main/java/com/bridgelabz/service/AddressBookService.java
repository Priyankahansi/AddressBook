package com.bridgelabz.service;

import com.bridgelabz.DTO.AddressBookDto;
import com.bridgelabz.Repository.AddressBookRepository;
import com.bridgelabz.entity.AddressBook;
//import com.bridgelabz.util.EmailSenderService;
import com.bridgelabz.util.EmailSenderService;
import com.bridgelabz.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {


    @Autowired
    AddressBookRepository repo;

    @Autowired
    TokenUtil tokenutil;

    @Autowired
    EmailSenderService sender;
    @Override
    public String getMessage() {

        return "Hello welcome to AddressBook";
    }

//    @Override
//    public AddressBook AddAddressBook(AddressBookDto addressBookDto) {
//        AddressBook addressBook = new AddressBook(addressBookDto);
//        repo.save(addressBook);
//        return addressBook;
//    }

    @Override
    public String addData(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook(addressBookDto);
        repo.save(addressBook);
        String token=tokenutil.createToken(addressBook.getId());
        sender.sendEmail(addressBook.getEmail(), "Test Email",
                "Registered Successfully :click here-> " +
                        " "+"http://localhost:8080/AddressBookService/retrieve/"+token);
        return token;
    }
    @Override
    public Optional<AddressBook> getAddressBookData(String token) {
        int id=tokenutil.decodeToken(token);
        Optional<AddressBook> addressBook=repo.findById(id);
        if(addressBook.isPresent()) {
            sender.sendEmail(addressBook.get().getEmail(),"TestMail",
                    "Retrieved Contact successfully :click here->"+
                            "http://localhost:8080/AddressBookService/retrieve/"+token);
            return addressBook;
        }else {
            return null;
        }
    }
    /**
     * getting contact details by id
     *
     * @param getId
     * @return
     */
    @Override
    public Optional<AddressBook> getContactById(int getId) {
        Optional<AddressBook> addressBook = repo.findById(getId);
        if (addressBook.isPresent()) {
            sender.sendEmail(addressBook.get().getEmail(), "TestMail..!",
                    "To get the contact details of id :click here->"+
                            "http://localhost:8080/AddressBookService/getContact/"+getId);
            return addressBook;
        } else {
            return null;
        }
    }
    /**
     * getting list of contact details
     *
     * @return
     */
    @Override
    public List<AddressBook> getListOfContacts() {
        List<AddressBook> contacts = repo.findAll();
        sender.sendEmail("priyankahansi95@gmail.com","TestMail",
                "To get the List of Contacts :click here->"
                        +"http://localhost:8080/AddressBookService/getContacts");
        return contacts;
    }

    /**
     * delete contact by id
     *
     * @param id
     */
    @Override
    public void deleteContact(int id) {
        Optional<AddressBook> addressBook = repo.findById(id);
        repo.deleteById(id);
        sender.sendEmail(addressBook.get().getEmail(),"TestMail",
                "Contact deleted Successfully"+addressBook.toString());
    }
    /**
     * update contact details by id
     *
     * @param getId
     * @param addressBookDto
     * @return
     */
    @Override
    public AddressBook updateContact(int getId, AddressBookDto addressBookDto) {
        Optional<AddressBook> newContact = repo.findById(getId);
        if (newContact.isPresent()) {
            newContact.get().setFullName(addressBookDto.getFullName());
            newContact.get().setAddress(addressBookDto.getAddress());
            newContact.get().setCity(addressBookDto.getCity());
            newContact.get().setState(addressBookDto.getState());
            newContact.get().setZip(addressBookDto.getZip());
            newContact.get().setPhone(addressBookDto.getPhone());
            newContact.get().setEmail(addressBookDto.getEmail());
            repo.save(newContact.get());
            sender.sendEmail(newContact.get().getEmail(),"Test Mail",
                   "To get Updated Contact: click here->"+
                           "http://localhost:8080/AddressBookService/getContact/"+getId);
            return newContact.get();
        } else {
            return null;
        }
    }
}





