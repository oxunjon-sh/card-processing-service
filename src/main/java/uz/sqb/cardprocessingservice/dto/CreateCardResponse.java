package uz.sqb.cardprocessingservice.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateCardResponse(@NotBlank String cardId, Long userId, String status, BigDecimal balance, String currency) {
}
