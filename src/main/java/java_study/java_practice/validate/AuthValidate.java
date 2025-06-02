package java_study.java_practice.validate;

import java_study.java_practice.error.ErrorCode;
import java_study.java_practice.error.exception.NotFoundException;
import java_study.java_practice.error.exception.TokenException;
import java_study.java_practice.redis.RedisTokenRepository;
import java_study.java_practice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthValidate {

    private final RedisTokenRepository redisTokenRepository;
    private final UserRepository userRepository;

    public void validateTempToken(String token) {
        String email = redisTokenRepository.getEmailByTempToken(token);

        if (email == null) {
            throw new TokenException("유효하지 않은 토큰입니다.", ErrorCode.INVALID_CODE_EXCEPTION);
        }

        userRepository
                .findByEmail(email)
                .orElseThrow(() -> new NotFoundException("사용자를 찾을 수 없습니다.", ErrorCode.NOT_FOUND_EXCEPTION));
    }
}
