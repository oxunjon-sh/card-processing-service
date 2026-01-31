package uz.sqb.cardprocessingservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.sqb.cardprocessingservice.dto.CreateCardRequest;
import uz.sqb.cardprocessingservice.dto.CreateCardResponse;
import uz.sqb.cardprocessingservice.repository.CardRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {
    private final CardRepository cardRepository;

    public CreateCardResponse createCard(String idempotencyKey, CreateCardRequest createCardRequest) {
        return null;
    }
}
