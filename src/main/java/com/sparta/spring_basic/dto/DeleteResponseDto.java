package com.sparta.spring_basic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteResponseDto {
    private Boolean success;

    public DeleteResponseDto(Boolean result) {
        this.success = result;
    }
}
