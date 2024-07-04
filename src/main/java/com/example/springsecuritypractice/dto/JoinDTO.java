package com.example.springsecuritypractice.dto;

import lombok.Getter;
import lombok.Setter;

//username과 password를 받을거
@Setter
@Getter
public class JoinDTO {
    private String username;
    private String password;
}
