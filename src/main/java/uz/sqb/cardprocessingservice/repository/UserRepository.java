package uz.sqb.cardprocessingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sqb.cardprocessingservice.entity.UserEntity;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {

     Optional<UserEntity> findByLogin(String login);
}
