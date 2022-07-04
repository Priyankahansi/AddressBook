package com.bridgelabz.controller;

import com.bridgelabz.DTO.AddressBookDto;
import com.bridgelabz.DTO.ResponseDto;
import com.bridgelabz.entity.AddressBook;
import com.bridgelabz.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

 @RestController
 @RequestMapping("/home")
 public class AddressBookController {
     @Autowired
     IAddressBookService service;

     @GetMapping("/hello")
     public String hello() {
         String msg = service.getMessage();
         return msg;
     }

     @PostMapping("/AddContact")
     public ResponseEntity<ResponseDto> AddContact(@RequestBody AddressBookDto addressBookDto) {
         String AddContact = service.AddAddressBook(addressBookDto);
         ResponseDto response = new ResponseDto("Contact added Successfully", AddContact);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     @GetMapping("/getContact/{getId}")
     public ResponseEntity<ResponseDto> getContact(@PathVariable int getId) {
         AddressBook contactId = service.getContactId(getId);
         ResponseDto response = new ResponseDto("Got Contact by Successfully", contactId);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     @GetMapping("/getContacts")
     public ResponseEntity<ResponseDto> getContacts() {
         List<AddressBook> contacts = service.getListOfContacts();
         ResponseDto response = new ResponseDto("Got List Contacts Successfully", contacts);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     @DeleteMapping("/delete")
     public ResponseEntity<ResponseDto> deleteContact(@RequestParam int id) {
         service.deleteContact(id);
         ResponseDto response = new ResponseDto("deleted contact successfully", id);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     @PutMapping("/updateContact/{getId}")
     public ResponseEntity<ResponseDto> updateContact(@PathVariable int getId, @RequestBody AddressBookDto addressBookDto) {

         AddressBook updateContact = service.updateContact(getId, addressBookDto);
         ResponseDto response = new ResponseDto("updated contact successfully", updateContact);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }
 }