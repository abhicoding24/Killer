package com.api.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KillerDto{
    @Size(min=2,message="name should have atleast 2 characters")
    private String name;
    @Email
    private String email;
    @Size(max=10,min=10,message="mobile should have 10 digits")
    private String mobile;
}
