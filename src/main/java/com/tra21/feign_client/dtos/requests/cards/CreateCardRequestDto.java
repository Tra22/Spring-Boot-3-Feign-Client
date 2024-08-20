package com.tra21.feign_client.dtos.requests.cards;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CreateCardRequestDto implements Serializable {
    private int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private ProductQuantityRequestDto products;
}
