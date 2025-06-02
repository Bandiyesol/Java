package java_study.java_practice.service;

import java_study.java_practice.dto.UserLoginRequestDto;
import java_study.java_practice.dto.UserSignupRequestDto;
import java_study.java_practice.dto.UserSignupResponseDto;

public interface UserService {
    UserSignupResponseDto signUpUser(UserSignupRequestDto signUpRequestDto);

    UserSignupResponseDto changeName(Long id, String name);

    UserSignupResponseDto changeEmail(Long id, String email);

    UserSignupResponseDto changePassword(Long id, String password);

    void deleteInfo(Long id);

    String login(UserLoginRequestDto loginRequestDto);

    void logout(String token);
}
