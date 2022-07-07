package com.bridgelabz.entity;

import com.bridgelabz.DTO.AddressBookDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString
public class AddressBook {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String phone;

    private String email;

    public AddressBook(AddressBookDto addressBookDto) {
        this.fullName = addressBookDto.getFullName();
        this.address = addressBookDto.getAddress();
        this.city = addressBookDto.getCity();
        this.state = addressBookDto.getState();
        this.zip = addressBookDto.getZip();
        this.phone = addressBookDto.getPhone();
        this.email=addressBookDto.getEmail();
    }
}
