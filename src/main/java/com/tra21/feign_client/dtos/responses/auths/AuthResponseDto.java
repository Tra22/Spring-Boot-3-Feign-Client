package com.tra21.feign_client.dtos.responses.auths;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthResponseDto implements Serializable {
    private String token;
}
