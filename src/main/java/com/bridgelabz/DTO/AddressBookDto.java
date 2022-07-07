package com.bridgelabz.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@ToString
public class AddressBookDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Inavlid name...!")
    private String fullName;

    @NotNull(message = "Address should not be null")
    private String address;

    @NotNull(message = "State should not be null")
    private String state;

    @NotNull(message = "City should not be null")
    private String city;

    @NotBlank(message = "Zip cannot be blank")
    private String zip;

    @NotNull(message = "Phone Number should not be null")
    private String phone;

    private String email;
}
