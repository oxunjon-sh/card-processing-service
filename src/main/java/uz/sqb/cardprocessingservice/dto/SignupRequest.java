package uz.sqb.cardprocessingservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    @NotBlank(message = "FullName is required")
    @Size(min = 3, max = 100)
    private String fullName;

    @NotBlank(message = "Login is required")
    private String login;

    @NotBlank(message = "Password is required")
    @Size(min = 4,max =14)
    private String password;

}
