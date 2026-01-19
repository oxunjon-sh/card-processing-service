package uz.sqb.cardprocessingservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uz.sqb.cardprocessingservice.enums.RoleEnum;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private Boolean isActive = true;
}
