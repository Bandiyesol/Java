package java_study.java_practice.validate;

import io.micrometer.common.util.StringUtils;
import java_study.java_practice.error.ErrorCode;
import java_study.java_practice.error.exception.BadRequestException;
import java_study.java_practice.error.exception.NotFoundException;
import java_study.java_practice.repository.UserRepository;
import java_study.java_practice.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class UserValidate {

    private final UserRepository userRepository;

    public UserEntity UserValidateId(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "사용자를 찾을 수 없습니다.",
                                ErrorCode.NOT_FOUND_EXCEPTION
                        )
                );
    }

    public void UserValidateName(String name) {
        if (StringUtils.isNotBlank(name) && userRepository.existsByName(name)) {
            throw new BadRequestException(
                    "이미 등록된 이름입니다.",
                    ErrorCode.DUPLICATE_NAME_EXCEPTION
            );
        }
    }

    public void UserValidateEmail(String email) {
        if (StringUtils.isNotBlank(email) && userRepository.existsByEmail(email)) {
            throw new BadRequestException(
                    "이미 사용 중인 이메일입니다.",
                    ErrorCode.DUPLICATE_EMAIL_EXCEPTION
            );
        }
    }

    public UserEntity findByNameAndPassword(String name, String password) {
        return userRepository
                .findByNameAndPassword(name, password)
                .orElseThrow(
                        () -> new BadRequestException(
                                "잘못된 정보입니다.",
                                ErrorCode.BAD_REQUEST_EXCEPTION
                        )
                );
    }
}
