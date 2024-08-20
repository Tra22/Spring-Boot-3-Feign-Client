package com.tra21.feign_client.dtos.responses.products;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductResponseDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private String image;
}
