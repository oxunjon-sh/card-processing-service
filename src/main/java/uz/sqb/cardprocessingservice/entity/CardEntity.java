package uz.sqb.cardprocessingservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.sqb.cardprocessingservice.enums.CardStatus;
import uz.sqb.cardprocessingservice.enums.CurrencyType;

import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cardId;

    private Long userId;
    @Enumerated(EnumType.STRING)
    private CardStatus status = CardStatus.ACTIVE;

    private BigDecimal initialAmount;

    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType = CurrencyType.UZS;
}
