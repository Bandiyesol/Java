package java_study.java_practice.service;

import java_study.java_practice.dto.UserLoginRequestDto;
import java_study.java_practice.dto.UserSignupRequestDto;
import java_study.java_practice.dto.UserSignupResponseDto;
import java_study.java_practice.redis.RedisTokenRepository;
import java_study.java_practice.repository.UserRepository;
import java_study.java_practice.domain.UserEntity;
import java_study.java_practice.validate.AuthValidate;
import java_study.java_practice.validate.UserValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RedisTokenRepository redisTokenRepository;
    private final UserValidate userValidate;
    private final AuthValidate authValidate;

    @Override
    public UserSignupResponseDto signUpUser(UserSignupRequestDto request) {
        String name = request.getName();
        String email = request.getEmail();

        userValidate.UserValidateName(name);
        userValidate.UserValidateEmail(email);

        UserEntity user = request.SignUpToUserEntity();

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
    }

    @Override
    public UserSignupResponseDto changeName(Long id, String name) {
        UserEntity user = userValidate.UserValidateId(id);

        userValidate.UserValidateName(name);
        user.changeName(name);

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
    }

    @Override
    public UserSignupResponseDto changeEmail(Long id, String email) {
        UserEntity user = userValidate.UserValidateId(id);

        userValidate.UserValidateEmail(email);

        user.changeEmail(email);

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
    }

    @Override
    public UserSignupResponseDto changePassword(Long id, String password) {
        UserEntity user = userValidate.UserValidateId(id);

        user.changePassword(password);

        userRepository.save(user);

        return UserSignupResponseDto.SignUpToUserEntity(user);
    }

    @Override
    public void deleteInfo(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public String login(UserLoginRequestDto request) {
        UserEntity user = userValidate.findByNameAndPassword(request.getName(), request.getPassword());

        return redisTokenRepository.createTempToken(user.getEmail(), true);
    }

    @Override
    public void logout(String token) {
        authValidate.validateTempToken(token);
        redisTokenRepository.deleteTempToken(token);
    }
}