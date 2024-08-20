package com.tra21.feign_client.configurations.feigns;

import com.tra21.feign_client.dtos.requests.auths.AuthRequestDto;
import com.tra21.feign_client.dtos.responses.auths.AuthResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "fakestoreapi-auths", url = "https://fakestoreapi.com", path = "/auth")
public interface UserLoginFakeAPIStoreFeignClient {
    @PostMapping("/login")
    AuthResponseDto login(@RequestBody AuthRequestDto authRequestDto);
}
