package com.tra21.feign_client.dtos.requests.auths;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthRequestDto implements Serializable {
    private String username;
    private String password;
}
