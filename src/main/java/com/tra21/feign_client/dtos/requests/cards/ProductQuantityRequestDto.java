package com.tra21.feign_client.dtos.requests.cards;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductQuantityRequestDto implements Serializable {
    private int productId;
    private int quantity;
}
