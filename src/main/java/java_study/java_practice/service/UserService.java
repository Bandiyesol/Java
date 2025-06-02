package java_study.java_practice.service;

import java_study.java_practice.dto.UserLoginRequestDto;
import java_study.java_practice.dto.UserSignupRequestDto;
import java_study.java_practice.dto.UserSignupResponseDto;
import java_study.java_practice.user.UserEntity;

public interface UserService {
    UserSignupResponseDto signUpUser(UserSignupRequestDto signUpRequestDto);

    UserEntity updateUser(UserEntity userEntity);

    UserSignupResponseDto changeName(Long id, String name);

    UserSignupResponseDto changeEmail(Long id, String email);

    UserSignupResponseDto changePassword(Long id, String password);

    void deleteInfo(Long id);

    String loginUser(UserLoginRequestDto loginRequestDto);

    void logout(String token);
}
