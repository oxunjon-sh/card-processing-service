package uz.sqb.cardprocessingservice.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCardRequest
        ( @NotBlank Long userId)
{}
