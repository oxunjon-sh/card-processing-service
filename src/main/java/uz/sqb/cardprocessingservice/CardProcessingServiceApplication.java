package uz.sqb.cardprocessingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CardProcessingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardProcessingServiceApplication.class, args);
    }

}
