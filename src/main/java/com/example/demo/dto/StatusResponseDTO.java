package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StatusResponseDTO {
    private Integer userID;
    private boolean isOnline;
}
