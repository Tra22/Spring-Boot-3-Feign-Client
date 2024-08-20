package com.tra21.feign_client.controllers;

import com.tra21.feign_client.configurations.feigns.UserFakeAPIStoreFeignClient;
import com.tra21.feign_client.dtos.requests.FilterListDto;
import com.tra21.feign_client.dtos.requests.users.CreateUserRequestDto;
import com.tra21.feign_client.dtos.requests.users.UpdateUserRequestDto;
import com.tra21.feign_client.dtos.responses.users.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserAPIController {
    private final UserFakeAPIStoreFeignClient userFakeAPIStoreFeignClient;
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers(FilterListDto filterListDto){
        return ResponseEntity.ok(this.userFakeAPIStoreFeignClient.getUsers(filterListDto));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(this.userFakeAPIStoreFeignClient.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userFakeAPIStoreFeignClient.createUser(createUserRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") int id, @RequestBody UpdateUserRequestDto updateUserRequestDto){
        return ResponseEntity.ok(this.userFakeAPIStoreFeignClient.updateUser(id, updateUserRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable("id") int id){
        return ResponseEntity.ok(this.userFakeAPIStoreFeignClient.deleteUser(id));
    }
}
