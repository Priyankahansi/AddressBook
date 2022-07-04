package com.bridgelabz.controller;

import com.bridgelabz.entity.AddressBook;
import com.bridgelabz.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping("/home")
 public class AddressBookController {
    @Autowired
    IAddressBookService service;

    @GetMapping("/hello")
    public String hello(){
       String msg=service.getMessage();
       return msg;
   }
    @PostMapping("/AddContact")
    public String AddContact(@RequestBody AddressBook addressBook){
        String AddContact=service.AddAddressBook(addressBook);
        return AddContact;
    }
     @GetMapping("/getContact/{getId}")
     public AddressBook getContact(@PathVariable int getId)
     {
         AddressBook contactId=service.getContactId(getId);
         return contactId;
     }

    @GetMapping("/getContacts")
    public List<AddressBook> getContacts()
    {
        List<AddressBook> contacts=service.getListOfContacts();
        return contacts;
    }

    @DeleteMapping("/delete")
    public String deleteContact(@RequestParam int id){
        service.deleteContact(id);
        return "Deleted....!";
    }
    @PutMapping("/updateContact/{getId}")
    public AddressBook updateContact(@PathVariable int getId,@RequestBody AddressBook  addressBook){
        AddressBook updateContact=service.updateContact(getId,addressBook);
        return updateContact;
    }
}
