package uz.sqb.cardprocessingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String tokenType = "Bearer";
    private Long userId;
    private String fullName;
    private String login;
    private String role;

    public AuthResponse(String token, Long userId, String fullName, String login, String role) {
        this.token = token;
        this.userId = userId;
        this.fullName = fullName;
        this.login = login;
        this.role = role;
    }
}
