package uz.sqb.cardprocessingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sqb.cardprocessingservice.entity.CardEntity;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
