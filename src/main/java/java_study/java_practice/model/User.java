package java_study.java_practice.model;

import jakarta.persistence.*;
import java_study.java_practice.dto.UserRequestDto;
import java_study.java_practice.dto.UserResponseDto;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;
    private String email;
    private String password;

    @Builder
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static User from(UserRequestDto dto) {
        return User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .build();
    }

    public void update(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserResponseDto toResponseDto() {
        return new UserResponseDto(this.id, this.username, this.email);
    }
}