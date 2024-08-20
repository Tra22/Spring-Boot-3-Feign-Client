package com.tra21.feign_client.dtos.responses.cards;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductQuantityResponseDto implements Serializable {
    private int productId;
    private int quantity;
}
