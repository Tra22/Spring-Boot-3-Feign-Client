package com.tra21.feign_client.configurations.feigns;

import com.tra21.feign_client.dtos.requests.FilterListDto;
import com.tra21.feign_client.dtos.requests.cards.CreateCardRequestDto;
import com.tra21.feign_client.dtos.requests.cards.UpdateCardRequestDto;
import com.tra21.feign_client.dtos.responses.cards.CardResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "fakestoreapi-cards", url = "https://fakestoreapi.com", path = "/cards")
public interface CardFakeAPIStoreFeignClient {
    @GetMapping
    List<CardResponseDto> getCards(FilterListDto filterListDto);

    @GetMapping("/user/{id}")
    List<CardResponseDto> getCardsByUserId(@PathVariable("id") int id);

    @GetMapping("/{id}")
    CardResponseDto getCardById(@PathVariable("id") int id);

    @PostMapping
    CardResponseDto createCard(@RequestBody CreateCardRequestDto createCardRequestDto);

    @PutMapping("/{id}")
    CardResponseDto updateCard(@PathVariable("id") int id, @RequestBody UpdateCardRequestDto updateCardRequestDto);

    @DeleteMapping("/{id}")
    CardResponseDto deleteCard(@PathVariable("id") int id);
}
