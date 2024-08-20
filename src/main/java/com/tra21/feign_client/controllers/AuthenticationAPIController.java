package com.tra21.feign_client.controllers;

import com.tra21.feign_client.dtos.requests.auths.AuthRequestDto;
import com.tra21.feign_client.dtos.responses.auths.AuthResponseDto;
import com.tra21.feign_client.configurations.feigns.UserLoginFakeAPIStoreFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationAPIController {
    private final UserLoginFakeAPIStoreFeignClient userLoginFakeAPIStoreFeignClient;
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto){
        return ResponseEntity.ok(this.userLoginFakeAPIStoreFeignClient.login(authRequestDto));
    }
}
