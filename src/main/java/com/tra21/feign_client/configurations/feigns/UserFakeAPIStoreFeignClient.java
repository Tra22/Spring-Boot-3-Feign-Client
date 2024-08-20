package com.tra21.feign_client.configurations.feigns;

import com.tra21.feign_client.dtos.requests.FilterListDto;
import com.tra21.feign_client.dtos.requests.users.CreateUserRequestDto;
import com.tra21.feign_client.dtos.requests.users.UpdateUserRequestDto;
import com.tra21.feign_client.dtos.responses.users.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "fakestoreapi-users", url = "https://fakestoreapi.com", path = "/users")
public interface UserFakeAPIStoreFeignClient {
    @GetMapping
    List<UserResponseDto> getUsers(FilterListDto filterListDto);

    @GetMapping("/{id}")
    UserResponseDto getUserById(@PathVariable("id") int id);

    @PostMapping
    UserResponseDto createUser(@RequestBody CreateUserRequestDto createUserRequestDto);

    @PutMapping("/{id}")
    UserResponseDto updateUser(@PathVariable("id") int id, @RequestBody UpdateUserRequestDto updateUserRequestDto);

    @DeleteMapping("/{id}")
    UserResponseDto deleteUser(@PathVariable("id") int id);
}
