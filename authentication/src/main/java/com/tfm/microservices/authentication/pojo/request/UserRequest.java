package com.tfm.microservices.authentication.pojo.request;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;
}
