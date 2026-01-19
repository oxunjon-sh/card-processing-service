package uz.sqb.cardprocessingservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.sqb.cardprocessingservice.dto.AuthRequest;
import uz.sqb.cardprocessingservice.dto.AuthResponse;
import uz.sqb.cardprocessingservice.dto.SignupRequest;
import uz.sqb.cardprocessingservice.entity.UserEntity;
import uz.sqb.cardprocessingservice.enums.RoleEnum;
import uz.sqb.cardprocessingservice.jwt.JwtUtil;
import uz.sqb.cardprocessingservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;


    public AuthResponse signup(SignupRequest request) {

        if (userRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new RuntimeException("Login already exists");
        }
        UserEntity user = UserEntity.builder()
                .fullName(request.getFullName())
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleEnum.USER)
                .isActive(true)
                .build();
        UserEntity savedUser = userRepository.save(user);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(savedUser.getLogin());
        String token = jwtUtil.generateToken(userDetails, savedUser.getId(), savedUser.getRole().name());

        return new AuthResponse(
                token,
                savedUser.getId(),
                savedUser.getFullName(),
                savedUser.getLogin(),
                savedUser.getRole().name()
        );
    }

    public AuthResponse login(AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getLogin(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Wrong login and password");
        }

        UserEntity user = userRepository.findByLogin(request.getLogin())

                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getLogin());
        String token = jwtUtil.generateToken(userDetails, user.getId(), user.getRole().name());

        return new AuthResponse(
                token,
                user.getId(),
                user.getFullName(),
                user.getLogin(),
                user.getRole().name()
        );
    }
}
