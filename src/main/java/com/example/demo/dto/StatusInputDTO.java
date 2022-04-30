package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StatusInputDTO {
    private Integer userID;
    private boolean isOnline;
}
