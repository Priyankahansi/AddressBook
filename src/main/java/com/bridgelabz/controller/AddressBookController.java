package com.bridgelabz.controller;

import com.bridgelabz.DTO.AddressBookDto;
import com.bridgelabz.DTO.ResponseDto;
import com.bridgelabz.entity.AddressBook;
import com.bridgelabz.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
 @RequestMapping("/AddressBookService")
 public class AddressBookController {
     @Autowired
     IAddressBookService service;


     @GetMapping("/hello")
     public String hello() {
         String msg = service.getMessage();
         return msg;
     }

//     @PostMapping("/AddContact")
//      public ResponseEntity<ResponseDto> AddContact(@Valid @RequestBody AddressBookDto addressBookDto) {
//         AddressBook addressBook = service.AddAddressBook(addressBookDto);
//         ResponseDto response = new ResponseDto("Contact added Successfully", addressBook);
//         return new ResponseEntity<>(response, HttpStatus.OK);
//     }

    /** creating insert API, to insert Data
     *
     * @param addressBookDto
     * @return
     */
     @PostMapping(value = "/insert")
     public ResponseEntity<ResponseDto> addEmployeePayRollData(@Valid @RequestBody AddressBookDto addressBookDto)
     {
         String addData = service.addData(addressBookDto);
         ResponseDto response = new ResponseDto("Contact added successfully",addData);
         return new ResponseEntity<>(response,HttpStatus.OK);
     }

    /** Creating retrieve API,to retrieve a data
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/retrieve/{token}")
    public ResponseEntity<ResponseDto> getAddressBookData(@PathVariable String token)
    {
        Optional<AddressBook> addressBook = service.getAddressBookData(token);
        ResponseDto response = new ResponseDto("Contact retrieved successfully",addressBook);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /** Creating getContact to retrieve data
     *
     * @param getId
     * @return
     */
     @GetMapping("/getContact/{getId}")
     public ResponseEntity<ResponseDto> getContact(@PathVariable int getId) {
         Optional<AddressBook> contactId = service.getContactById(getId);
         ResponseDto response = new ResponseDto("Contact retrieved successfully by id:" +" " +getId,contactId);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     /**Creating getContacts Api, to get the list of contacts
      *
      * @return ResponseDto
      */
     @GetMapping("/getContacts")
     public ResponseEntity<ResponseDto> getContacts() {
         List<AddressBook> contacts = service.getListOfContacts();
         ResponseDto response = new ResponseDto("retrieved list of contacts all data Successfully", contacts);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     /**Creating delete Api, to delete the contact by id
      *
      * @param id
      * @return ResponseDto
      */
     @DeleteMapping("/delete")
     public ResponseEntity<ResponseDto> deleteContact(@RequestParam int id) {
         service.deleteContact(id);
         ResponseDto response = new ResponseDto("deleted contact successfully", id );
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

     /**Creating updateContact Api,to update the contact by id
      *
      * @param getId
      * @param addressBookDto
      * @return ResponseDto
      */
     @PutMapping("/updateContact/{getId}")
     public ResponseEntity<ResponseDto> updateContact(@PathVariable int getId,@Valid @RequestBody AddressBookDto addressBookDto) {
         AddressBook updateContact = service.updateContact(getId, addressBookDto);
         ResponseDto response = new ResponseDto("updated contact successfully", updateContact);
         return new ResponseEntity<>(response, HttpStatus.OK);
     }

 }