package com.tra21.feign_client.dtos.requests.products;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateProductRequestDto implements Serializable {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
