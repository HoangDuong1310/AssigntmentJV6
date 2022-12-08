package com.example.finalproject.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBean {
    @NotBlank
    String username;
    @NotBlank
    String password;
    @NotBlank
    String fullname;
    @NotBlank
    @Email
    String email;
    String photo;
}
