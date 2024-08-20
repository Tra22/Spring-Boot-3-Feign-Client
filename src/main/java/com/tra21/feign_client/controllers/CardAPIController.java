package com.tra21.feign_client.controllers;

import com.tra21.feign_client.dtos.requests.FilterListDto;
import com.tra21.feign_client.dtos.requests.cards.CreateCardRequestDto;
import com.tra21.feign_client.dtos.requests.cards.UpdateCardRequestDto;
import com.tra21.feign_client.dtos.responses.cards.CardResponseDto;
import com.tra21.feign_client.configurations.feigns.CardFakeAPIStoreFeignClient;
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
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardAPIController {
    private final CardFakeAPIStoreFeignClient cardFakeAPIStoreFeignClient;
    @GetMapping
    public ResponseEntity<List<CardResponseDto>> getCards(FilterListDto filterListDto){
        return ResponseEntity.ok(this.cardFakeAPIStoreFeignClient.getCards(filterListDto));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<CardResponseDto>> getCardsByUserId(@PathVariable("id") int id){
        return ResponseEntity.ok(this.cardFakeAPIStoreFeignClient.getCardsByUserId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> getCardById(@PathVariable("id") int id){
        return ResponseEntity.ok(this.cardFakeAPIStoreFeignClient.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<CardResponseDto> createCard(@RequestBody CreateCardRequestDto createCardRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cardFakeAPIStoreFeignClient.createCard(createCardRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDto> updateCard(@PathVariable("id") int id, @RequestBody UpdateCardRequestDto updateCardRequestDto){
        return ResponseEntity.ok(this.cardFakeAPIStoreFeignClient.updateCard(id, updateCardRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardResponseDto> deleteCard(@PathVariable("id") int id){
        return ResponseEntity.ok(this.cardFakeAPIStoreFeignClient.deleteCard(id));
    }
}
