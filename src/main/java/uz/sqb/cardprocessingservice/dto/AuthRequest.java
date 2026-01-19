package uz.sqb.cardprocessingservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotBlank(message = "Login not empty")
    private String login;

    @NotBlank(message = "Password not empty")
    private String password;
}
