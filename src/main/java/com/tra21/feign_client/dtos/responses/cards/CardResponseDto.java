package com.tra21.feign_client.dtos.responses.cards;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CardResponseDto implements Serializable {
    private int id;
    private int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private ProductQuantityResponseDto products;
}
