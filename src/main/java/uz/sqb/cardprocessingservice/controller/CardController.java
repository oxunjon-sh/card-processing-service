package uz.sqb.cardprocessingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sqb.cardprocessingservice.dto.CreateCardRequest;
import uz.sqb.cardprocessingservice.dto.CreateCardResponse;
import uz.sqb.cardprocessingservice.service.CardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CreateCardResponse> createCard(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestBody CreateCardRequest createCardRequest){

        return ResponseEntity.ok(cardService.createCard(idempotencyKey,createCardRequest));

    }

}
